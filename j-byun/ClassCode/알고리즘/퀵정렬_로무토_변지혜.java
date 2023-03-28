import java.util.Arrays;

/**
 * @author jhye.byun
 * 정렬 - 퀵정렬 - 로무토
 * 
 * 주어진 숫자를 오름차순 순서대로 정렬해보자.
 */

public class 퀵정렬_로무토_변지혜 {
	
	private static void quickSort(int[] arr, int start, int end) {
		// 퀵정렬
		
		if (start >= end) return; // 쪼갤 배열이 없으면 반환
		
		int pivot = lomuto(arr, start, end); // 제 자리에 위치한 피봇 값 찾기
		quickSort(arr, start, pivot - 1); // 피봇 기준 왼쪽 정렬
		quickSort(arr, pivot + 1, end); // 피봇 기준 오른쪽 정렬
	}
	
	private static int lomuto(int[] arr, int start, int end) {
		// 로무토 알고리즘으로 피봇을 정하자
		
		int pivot = arr[end];
		int left = start - 1;
		int right = start;
		
		while (left < end && right < end) {
			if (arr[right] <= pivot)
				swap(arr, ++left, right);
			
			right++;
		}
		
		swap(arr, ++left, end);
		return left;
	}
	
	private static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	
	public static void main(String[] args) {
		int[] num = new int[] {0, 51, 19, 3 ,26 ,13, 24, 67, 31, 1, 5};
		int numCnt = num.length; // 재료의 개수
		
		quickSort(num, 0, numCnt - 1); // 퀵정렬로 배열을 오름차순 정렬하자
		System.out.println(Arrays.toString(num)); // 정렬된 배열을 출력하자
	}

}
