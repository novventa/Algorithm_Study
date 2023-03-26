import java.util.Arrays;

/**
 * @author jhye.byun
 * 정렬 - 선택정렬
 * 
 * 주어진 숫자를 오름차순 순서대로 정렬해보자.
 */

public class 선택정렬_변지혜 {
	
	
	private static void selectionSort(int[] arr, int start, int end) {
		// 선택정렬
		
		for (int pass = start; pass < end - 1; pass++) {
			int minIdx = pass;
			for (int idx = pass + 1; idx < end; idx++) {
				if (arr[minIdx] > arr[idx])
					minIdx = idx;
			}
			swap(arr, minIdx, pass);
		}
		
	}
	
	private static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	
	public static void main(String[] args) {
		int[] num = new int[] {0, 51, 19, 3 ,26 ,13, 24, 67, 31, 1, 5};
		int numCnt = num.length; // 재료의 개수
		
		selectionSort(num, 0, numCnt); // 선택정렬로 배열을 오름차순 정렬하자
		System.out.println(Arrays.toString(num)); // 정렬된 배열을 출력하자
	}

}
