package test;


import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 개수 t 입력받기
		int t = sc.nextInt();
		
		// 테스트케이스 개수만큼 반복
		for (int testCase = 0; testCase < t; testCase++) {
			// 크기가 10인 배열 만들어주기
			int [] arr = new int[10];
			
			// 배열 요소 입력받기
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
			// 버블정렬
			// 오름차순
			for (int i = 0; i < arr.length - 1; i++) {
				for (int idx = 0; idx < arr.length - 1 - i; idx++) {
					if (arr[idx] > arr[idx + 1]) {
						int tmp = arr[idx];
						arr[idx] = arr[idx + 1];
						arr[idx + 1] = tmp;
					}
				}
			} // 오름차순 정렬 완료
			
//			System.out.println(Arrays.toString(arr));
			
			// idx 0과 9를 제외한 나머지 값의 합 구하기
			// 더한 값을 저장한 sum 공간 만들기
			double sum = 0;
			
			for (int idx = 1; idx < arr.length - 1; idx++) {
				sum += arr[idx];
			}
			
			// 평균값 구하기
			double avr = (double) (sum / (arr.length - 2));
			
			System.out.printf("#%d %.0f", testCase + 1, avr);
			System.out.println();
		}
		
		
		
		
		
		
	}

}
