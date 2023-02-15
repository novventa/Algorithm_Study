package test;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// 230213
		// [S/W 문제해결 기본] 1일차 - View
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 10번 만큼 반복
		for (int testCase = 0; testCase < 10; testCase++) {
			// 건물의 개수 n 입력받기
			int n = sc.nextInt();
			
			// n의 크기를 갖는 배열 building 만들기
			int[] building = new int[n];
			
			// 조망권이 확보된 세대의 수를 저장할 sum 공간 만들기
			int sum = 0;
			
			// building 칸에 대해 건물 높이를 입력받는다
			for (int idx = 0; idx < n; idx++) {
				building[idx] = sc.nextInt();
			}
			
//			System.out.println(Arrays.toString(building));
			
			// 처음 2개 칸, 마지막 2개칸은 제외하고
			// 모든 건물에 대해 확인
			for (int idx = 2; idx < n - 2; idx++) {
				// 현재 칸의 건물이 좌우 2개칸의 건물들 보다 높을 경우만 확인
				if (building[idx] > building[idx - 1] && building[idx] > building[idx - 2] 
						&& building[idx] > building[idx + 1] && building[idx] > building[idx + 2]) {
					// 최소값을 건물 최대 높이보다 크게 지정
					int min = 260;
					// 현재의 죄소값보다 옆 건물 과의 차이가 작으면 min값 리뉴얼
					if (building[idx] - building[idx - 1] < min) {
						min = building[idx] - building[idx - 1];
					}
					if (building[idx] - building[idx - 2] < min) {
						min = building[idx] - building[idx - 2];
					}
					if (building[idx] - building[idx + 1] < min) {
						min = building[idx] - building[idx + 1];
					}
					if (building[idx] - building[idx + 2] < min) {
						min = building[idx] - building[idx + 2];
					}
					// 좌우로 2칸씩 차이 다 확인하고 제일 작은 min 값 을 sum에 포함
					sum += min;
				}
				
			}
			
			
			System.out.printf("#%d %d", (testCase + 1), sum);
			System.out.println();
			
		}
		
		
	}

}
