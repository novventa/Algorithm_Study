import java.util.Arrays;

/**
 * @author jhye.byun
 * 정렬 - 병합정렬
 * 
 * 주어진 숫자를 오름차순 순서대로 정렬해보자.
 */

public class 병합정렬_변지혜 {
	
	
	private static void mergeSort(int[] arr, int start, int end) {
		// 병합정렬 - 분할과정
		
		if (start == end) return;
		
		int mid = (start + end) / 2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid + 1, end);
		merge(arr, start, end);
	}
	
	private static void merge(int[] arr, int start, int end) {
		// 병합정렬 - 병합과정
		
		int[] tmp = new int[arr.length]; // 정렬된 값을 임시로 저장할 배열
		
		int left = start;
		int mid = (start + end) / 2;
		int right = mid + 1;
		int idx = left;
		
		while (left <= mid && right <= end) {
			if(arr[left] <= arr[right])
				tmp[idx++] = arr[left++];
			else
				tmp[idx++] = arr[right++];
		}
		
		while (left <= mid) {
			tmp[idx++] = arr[left++];
		}
		
		while (right <= end) {
			tmp[idx++] = arr[right++];
		}
		
		for (int index = start; index <= end; index++) {
			arr[index] = tmp[index];
		}
	}
	
	public static void main(String[] args) {
		int[] num = new int[] {0, 51, 19, 3 ,26 ,13, 24, 67, 31, 1, 5};
		int numCnt = num.length; // 재료의 개수
		
		mergeSort(num, 0, numCnt - 1); // 선택정렬로 배열을 오름차순 정렬하자
		System.out.println(Arrays.toString(num)); // 정렬된 배열을 출력하자
	}

}
