package test;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// SWEA
		// 2063 중간값 찾기
		// D1
		
		// N개의 점수 입력 => 중간값 출력
		// N은 항상 홀수
		// 9 <= N <= 199
		
		// 오름차순 정렬 후 N/2 번째 값 출력 (인덱스는 0부터 시작하니까)
		// 선택정렬
		
		Scanner sc = new Scanner(System.in);
		
		// 점수의 개수 n 입력
		int n = sc.nextInt();
		// n의 크기를 갖는 int 배열 scores 만들기
		int[] scores = new int[n];
		
		// scores 배열의 n개의 점수 입력받기
		for (int idx = 0; idx < n; idx++) {
			scores[idx] = sc.nextInt();
		}
		
		// n-1번 확인
		// 마지막에는 남은 두 개의 값을 확인해서 한 번 정렬하면 두 값이 다 제자리에 들어가기 때문에
		for (int idx = 0; idx < n - 1; idx++) {
			// 현재 인덱스를 최소값의 인덱스로 임의지정
			int minIdx = idx;
			
			// 현재 인덱스 기준 오른쪽 배열들을 확인하며
			// 최소값 인덱스 업데이트
			for (int newIdx = idx + 1; newIdx < n; newIdx++) {
				if (scores[newIdx] < scores[minIdx]) {
					minIdx = newIdx;
				}
			}
			// 한 패스 다 돌았을때의 최소값을 현재 인덱스와 자리 바꾸기
			int tmp = scores[idx];
			scores[idx] = scores[minIdx];
			scores[minIdx] = tmp;
		}
		
		// 중간값 출력
		System.out.println(scores[n / 2]);
		

	}

}

