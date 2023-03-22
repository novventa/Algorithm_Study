import java.util.Scanner;


/**
 * @author jhye.byun
 * SWEA 14229 백만 개의 정수 정렬 D2 분할정복
 * 
 * 문제
 * 공백으로 구분된 백만개의 정수
 * 오름차순으로 정렬 후 배열 A에 저장하고 A[500000]을 출력하자.
 *
 * 조건
 * 1<=A[i]<=1000000
 * 테스트케이스 1개
 * 
 * 풀이
 * 1. MergeSort(병합 정렬)로 정렬해보자.
 * 2. 퀵 정렬 - 호어 파티션 알고리즘으로 정렬해보자.
 * 3. 퀵 정렬 - 로무토 파티션 알고리즘으로 정렬해보자. 
 */

public class SWEA_14229_백만개의정수정렬_변지혜_퀵정렬_Lomuto {
	
	private static void quickSort(int[] arr, int start, int end) {
		// 퀵 정렬 - 로무토 파티션 알고리즘
		// top-down 방식
		
		if (start >= end) return; // 원소가 1개짜리 배열이면 확인할 필요가 없다
		int pivot = lomutoPartition(arr, start, end); // 피봇을 제 자리에 정렬시키자
		quickSort(arr, start, pivot - 1); // 피봇 기준 왼쪽 배열 정렬
		quickSort(arr, pivot + 1, end); // 피봇 기준 오른쪽 배열 정렬
	}
	
	private static int lomutoPartition(int[] arr, int start, int end) {
		// 로무토 파티션 알고리즘 : 배열의 마지막 값을 피봇으로 정한다
		int pivotNum = arr[end];
		// 왼쪽 값 : 배열의 맨 왼쪽 인덱스 -1
		int left = start - 1;
		// 오른쪽 값 : 배열의 맨 왼쪽 인덱스
		int right = start;
		
		// 오른쪽 값을 나타내는 인덱스가 피봇 바로 전 값까지 확인한다
		while (right < end) {
			// 오른쪽 값이 피봇 값 보다 작으면 왼쪽 인덱스를 1 증가시키고 오른쪽 왼쪽 값을 바꾼다
			if (arr[right] <= pivotNum)
				swap(arr, ++left, right);
			// 오른쪽 값이 피봇 값보다 크면 오른쪽 인덱스만 증가시킨다
			// 왼쪽 오른쪽 값을 바꿨어도 오른쪽 인덱스를 증가시킨다
			right++;
		}
		
		// 오른쪽 인덱스가 피봇 바로 전까지 확인했다면
		// 왼쪽 인덱스가 가르키는 값이 피봇보다 작은 값 중 마지막 위치이다
		// 그러니 왼쪽 인덱스 + 1의 값과 피봇 값의 자리를 바꿔주자
		swap(arr, left + 1, end);
		// 이제 피봇의 위치는 왼쪽 인덱스 + 1 이니
		// 업데이트된 피봇 위치를 반환해주자
		return left + 1;
	}
	
	private static void swap(int[] arr, int a, int b) {
		// 배열의 a번째 인덱스 값과 b번째 인덱스 값을 서로 바꿔주는 method
		
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = 1_000_000; // 배열에 저장할 수의 개수 백만
		int[] num = new int[size]; // 백만 개의 정수를 저장할 배열
		int[] tmp = new int[size]; // 정수를 정렬할 때 임시로 저장해놓을 배열
		
		// 배열에 백만 개의 정수를 입력받자
		for (int idx = 0; idx < size; idx++) {
			num[idx] = sc.nextInt();
		}
		
		// num배열을 퀵 정렬 - 로무토 파티션 알고리즘을 활용하여 오름차순 정렬해보자.
		quickSort(num, 0, size - 1);

		System.out.println(num[size / 2]); // 50만째 수 출력
	}

}
