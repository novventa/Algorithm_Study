package test;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// SWEA
		// 1209 Sum
		// D3

		// 문제
		// 100*100 사이즈의 2차원 배열
		// 각 행의 합, 각 열의 합, 각 대각선의 합 (대각선 두 개) 중 최댓값을 구하는 프로그램을 작성하여라

		// 테스트케이스 10개
		// 동일한 최댓값이 있을 경우, 하나의 값만 출력한다

		// 풀이
		// 가로 100개 for문 돌리고
		// 각 행의 합이 현재의 max보다 크면 max값 업데이트해주고

		// 세로 100개 for문 돌려서
		// 각 열의 합이 현재의 max보다 크면 max값 업데이트 해주고

		// 대각선 두 개 for문 돌려서
		// 합이 현재의 max보다 크면 max값 업데이트 해주고

		// 마지막으로 업데이트 된 max값 출력

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		// 테스트케이스 10번만큼 반복
		for (int tc = 1; tc <= 10; tc++) {
			// 테스트케이스 번호 입력 받기
			int testCase = sc.nextInt();

			// 100*100 사이즈 map 만들기
			int[][] map = new int[100][100];

			// map data 입력받기
			for (int row = 0; row < 100; row++) {
				for (int col = 0; col < 100; col++) {
					map[row][col] = sc.nextInt();
				}
			}

			// 최대값을 저장할 max 변수 만들어주기
			int max = -1;

			// 각 행, 열, 대각선의 합을 저장할 sum 변수 만들어주기
			int sum = 0;

			// max는 테스트케이스 당 하나의 최대값을 뽑아낼 거니까
			// 테케가 새로 시작할 때만 초기화 해주고

			// sum은 각 줄에 대한 합을 확인할거니까
			// 각 줄에 대해 확인 시작할 때 마다 sum = 0으로 초기화 해주기

			// 가로 줄 다 확인하기
			for (int row = 0; row < 100; row++) {
				// 한 줄 확인 시작할 때 sum = 0 으로 리셋시키고
				sum = 0;
				// 왼쪽에서부터 확인하면서 sum에 값 더해주기
				for (int col = 0; col < 100; col++) {
					sum += map[row][col];
				}
				// 한 줄 확인 끝났을 때 현재까지의 max랑 비교해서
				// sum이 더 크면 max를 sum으로 업데이트 해주기
				if (sum > max) {
					max = sum;
				}
			}

			// 세로 줄 다 확인하기
			for (int col = 0; col < 100; col++) {
				// 한 줄 확인 시작할 때 sum = 0 으로 리셋시키고
				sum = 0;
				// 위에서부터 확인하면서 sum에 값 더해주기
				for (int row = 0; row < 100; row++) {
					sum += map[row][col];
				}
				// 한 줄 확인 끝났을 때 현재까지의 max랑 비교해서
				// sum이 더 크면 max를 sum으로 업데이트 해주기
				if (sum > max) {
					max = sum;
				}
			}

			// 0,0에서 시작하는 대각선 줄 확인하기
			// sum = 0 으로 초기화 하고
			sum = 0;
			for (int row = 0, col = 0; row < 100 && col < 100; row++, col++) {
				sum += map[row][col];
			}
			// 대각선 한 줄 확인끝났을 때 현재까지의 max랑 비교해서
			// sum이 더 크면 max를 sum으로 업데이트 해주기
			if (sum > max) {
				max = sum;
			}

			// 0,99에서 시작하는 대각선 줄 확인하기
			// sum = 0 으로 초기화 하고
			sum = 0;
			for (int row = 0, col = 99; row < 100 && col >= 0; row++, col--) {
				sum += map[row][col];
			}
			// 대각선 한 줄 확인끝났을 때 현재까지의 max랑 비교해서
			// sum이 더 크면 max를 sum으로 업데이트 해주기
			if (sum > max) {
				max = sum;
			}

			// 다 확인하면 max가 여태까지 모든 줄 확인했을 때
			// 그 중 최대값으로 업데이트 되어있음
			
			// 출력
			sb.append("#").append(testCase).append(" ").append(max).append("\n");
		}

		System.out.println(sb);

	}
}


