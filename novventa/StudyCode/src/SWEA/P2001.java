package SWEA;

import java.util.Scanner;

public class P2001 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 횟수 입력받기
		int T = sc.nextInt();

		// 테스트 케이스 횟수만큼 반복
		for (int tc = 1; tc < T + 1; tc++) {
			// 맵의 크기 입력받기
			int N = sc.nextInt();
			// 파리채 크기 입력받기
			int M = sc.nextInt();

			// 맵 크기만큼 2차원 배열 생성
			int[][] map = new int[N][N];

			// 맵 채우기
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			// 최대합 변수 선언
			int maxSum = 0;
			// 배열 요소 하나마다 탐색
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					// 요소가 for문을 돌 때마다 sum값을 초기화한다.
					int sum = 0;
					// 요소에서 자기자신과 행, 열에서 M칸까지 더해서 sum에 저장.
					for (int dr = 0; dr < M; dr++) {
						for (int dc = 0; dc < M; dc++) {
							// 첫번째 반복은 자기자신이다.
							// 이후 반복은 나머지 칸을 탐색한다.
							int nRow = r + dr;
							int nCol = c + dc;
							// 맵의 왼쪽이나 위쪽으로 탐색할 일이 없으므로
							if (nRow >= N || nCol >= N)
								break;
							// 맵을 벗어나지 않으면 값을 더한다.
							else
								sum += map[nRow][nCol];
						}
					}
					// 최대합보다 크면 최대합으로 바꿔준다.
					if (maxSum < sum)
						maxSum = sum;
				}
			}
			// 출력
			System.out.println("#" + tc + " " + maxSum);
		}
	}
}
