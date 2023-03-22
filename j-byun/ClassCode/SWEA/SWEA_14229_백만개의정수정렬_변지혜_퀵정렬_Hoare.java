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

public class SWEA_14229_백만개의정수정렬_변지혜_퀵정렬_Hoare {
	
	private static void quickSort(int[] arr, int start, int end) {
		// 퀵 정렬 - 호어 파티션 알고리즘
		// top-down 방식
		
		if (start >= end) return; // 원소가 1개짜리 배열이면 확인할 필요가 없다
		int pivot = hoarePartition(arr, start, end); // 피봇을 제 자리에 정렬시키자
		quickSort(arr, start, pivot - 1); // 피봇 기준 왼쪽 배열 정렬
		quickSort(arr, pivot + 1, end); // 피봇 기준 오른쪽 배열 정렬
	}
	
	private static int hoarePartition(int[] arr, int start, int end) {
		// 호어 파티션 알고리즘 : 배열의 첫번째 값을 피봇으로 정한다
		int pivotNum = arr[start];
		// 왼쪽 값 : 피봇 다음 값부터 차례대로 오른쪽으로 진행하며 찾기 
		int left = start + 1;
		// 오른쪽 값 : 배열의 제일 마지막 값부터 차례대로 왼쪽으로 진행하며 찾기
		int right = end;
		
		// 왼쪽 값을 가르키는 인덱스가 오른쪽 값을 가르키는 인덱스와 교차되면 탐색 중지 
		while (left <= right) {
			// 왼쪽 오른쪽 인덱스가 교차되지 않는 범위에서 (배열 범위를 벗어날 수 있어서 필요한 조건)
			// 피봇보다 큰 수가 발견될 때 까지 왼쪽 인덱스를 증가시키며 확인
			while (left <= right && arr[left] <= pivotNum)
				left++;
			// 피봇보다 작은 수가 발견될 때 까지 오른쪽 인덱스를 감소시키며 확인
			// 해당 조건에서 오른쪽 인덱스가 피봇 위치를 가르킬 때가 걸러지므로 추가조건 불필요
			while (arr[right] > pivotNum)
				right--;
			
			// 조건을 만족하는 왼쪽 오른쪽 인덱스를 발견했다면
			// 두 수의 자리를 바꿔주자
			if (left < right)
				swap(arr, left, right);
		}
		
		// 조건을 만족하는 왼쪽 오른쪽 인덱스 값을 다 바꿔줬다면
		// 두 인덱스가 교차해서 while문이 끝났다!
		// 그럼 이제 오른쪽 인덱스 값과 피봇의 자리를 바꿔주자
		// => 두 인덱스가 교차했기 때문에 오른쪽 인덱스가 더 왼쪽의 값을 가르키고 있다
		swap(arr, right, start);
		// 이제 오른쪽 인덱스가 피봇을 가르키고 있으니,
		// 피봇을 가르키는 right를 반환해주자
		return right;
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
		
		// num배열을 퀵 정렬 - 호어 파티션 알고리즘을 활용하여 오름차순 정렬해보자.
		quickSort(num, 0, size - 1);

		System.out.println(num[size / 2]); // 50만째 수 출력
	}

}
