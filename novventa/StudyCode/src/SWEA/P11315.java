package SWEA;

import java.util.Scanner;

public class P11315 {

	// 8방탐색을 위한 델타 배열 선언
	static int[] dRow = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dCol = { 0, 0, -1, 1, -1, 1, -1, 1 };
	// 상 하 좌 우 좌상 우상 좌하 우하

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 횟수 입력받기
		int T = sc.nextInt();

		// 테스트 케이스 횟수만큼 반복
		for (int tc = 1; tc < T + 1; tc++) {

			// 바둑판 길이 입력받기
			int N = sc.nextInt();

			// 바둑돌 상태 입력받을 character 2차원 배열 생성
			char[][] map = new char[N][N];

			// 바둑판 채우기
			for (int r = 0; r < map.length; r++) {
				String row = sc.next();
				for (int c = 0; c < map.length; c++) {
					map[r][c] = row.charAt(c);
				}
			}
			// 연속되는지 안되는지에 대한 판정
			boolean isContinue = false;
			// 돌 하나가 놓여있으면 탐색을 시작하자.
			// 바둑판을 처음부터 탐색
			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map.length; c++) {
					// 그 칸에 돌이 놓여있다면
					if (map[r][c] == 'o') {
						// 8방탐색을 한다.
						for (int d = 0; d < 8; d++) {
							// 카운트 for문이 끝나면 5개가 연속이다.
							// for문이 끝나기 전에 break 되면 5개 연속이 아니다.
							for (int count = 1; count < 5; count++) {
								int nRow = r + dRow[d] * count;
								int nCol = c + dCol[d] * count;
								// 경계를 벗어나면 break
								if (nRow < 0 || nRow >= map.length || nCol < 0 || nCol >= map.length)
									break;
								// 돌이 놓여있지 않으면 break
								else if (map[nRow][nCol] != 'o')
									break;
								// count가 4면 
								if (count == 4)
									// 5개 연속이다.
									isContinue = true;
							}
						}
					}
				}
			}
			// 연속이면 YES 출력
			if (isContinue)
				System.out.println("#" + tc + " YES");
			// 연속이 아니면 NO 출력
			else
				System.out.println("#" + tc + " NO");
		}
	}
}
