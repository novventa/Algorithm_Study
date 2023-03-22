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

public class SWEA_14229_백만개의정수정렬_변지혜_병합정렬 {
	
	private static int[] mergeSort(int[] arr, int[] tmp, int start, int end) {
		// 분할 과정
		
		if (start >= end) return arr; // 정렬할 원소가 하나가 되면 정렬을 그만하자
		
		int mid = (start + end) / 2; // 중앙값 인덱스 설정
		mergeSort(arr, tmp, start, mid); // 배열을 반으로 나눠서 확인해보자
		mergeSort(arr, tmp, mid + 1, end);
		return merge(arr, tmp, start, mid, end); // 반으로 나눈 배열을 확인했으면 다시 병합하자
	}
	
	private static int[] merge(int[] arr, int[] tmp, int start, int mid, int end) {
		// 병합 과정
		
		int left = start; // 왼쪽 배열의 시작점
		int right = mid + 1; // 오른쪽 배열의 시작점
		int idx = left; // 채워넣을 배열의 인덱스 표시
		
		// 왼쪽 배열과 오른쪽 배열의 범위를 벗어나지 않는 선에서 양쪽의 수를 비교해보자
		while (left <= mid && right <= end) {
			// 작은 수 부터 임시 배열에 차례대로 저장하자
			if (arr[left] <= arr[right])
				tmp[idx++] = arr[left++];
			else
				tmp[idx++] = arr[right++];
		}
		
		// 왼쪽 배열의 값이 남아있다면
		// 남아있는 값들을 차례대로 배열에 넣자
		while (left <= mid) {
			tmp[idx++] = arr[left++];
		}
		
		// 오른쪽 배열의 값이 남아있다면
		// 남아있는 값들을 차례대로 배열에 넣자
		while (right <= end) {
			tmp[idx++] = arr[right++];
		}
		
		// 임시 배열에 오름차순 정렬한 수의 저장이 끝났으니,
		// 임시 배열에 저장된 순서대로 원본 배열에 복사하자
		for (int index = start; index <= end; index++) {
			arr[index] = tmp[index];
		}
		
		// 원본 배열을 정렬시켜줬으니 반환하자
		return arr;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = 1000000; // 배열에 저장할 수의 개수 백만
		int[] num = new int[size]; // 백만 개의 정수를 저장할 배열
		int[] tmp = new int[size]; // 정수를 정렬할 때 임시로 저장해놓을 배열
		
		// 배열에 백만 개의 정수를 입력받자
		for (int idx = 0; idx < size; idx++) {
			num[idx] = sc.nextInt();
		}
		
		// num배열을 mergesort로 오름차순 정렬해보자.
		// mergesort 범위 : 배열의 전체 수에 대해
		mergeSort(num, tmp, 0, size - 1);

		System.out.println(num[size / 2]); // 50만째 수 출력
	}

}
