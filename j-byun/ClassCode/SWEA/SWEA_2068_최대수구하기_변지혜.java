package test;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 개수 T 입력받기
		int t = sc.nextInt();

		// T만큼 반복하기
		for (int testCase = 0; testCase < t; testCase++) {
			// 크가 10인 배열 arr 만들기
			int[] arr = new int[10];

			// 배열 요소 입력받기
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}

			// 버블정렬
			// 어차피 제일 큰 값 하나만 꺼내면 되니까 pass 딱 한 번만 실행
			for (int i = 0; i < arr.length - 1; i++) {
				// 오름차순 정렬
				// 왼쪽 값이 오른쪽 값보다 클 경우 swap
				if (arr[i] > arr[i + 1]) {
					int tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
				}
			}

			// 테스트케이스 번호 + 최대수 출력
			System.out.println("#" + (testCase + 1) + " " + arr[arr.length - 1]);

		}

	}

}
