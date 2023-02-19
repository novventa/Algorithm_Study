package SWEA;

import java.util.Scanner;

public class P1210 {

	// 델타 배열 선언
	// 3방 탐색만 하면 된다.
	static int[] dRow = { -1, 0, 0 }; // 상 좌 우
	static int[] dCol = { 0, -1, 1 }; // 0 1 2

	static final int UP = 0;
	static final int LEFT = 1;
	static final int RIGHT = 2;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 10번 반복
		for (int tc = 0; tc < 10; tc++) {
			// 100 X 100 배열 생성
			int[][] ladder = new int[100][100];

			// TC번호 입력받기
			int T = sc.nextInt();

			// 배열을 입력받으면서
			// 거꾸로 올라갈 것이므로
			// 도착점의 좌표를 저장한다.
			int endRow = 0;
			int endCol = 0;

			for (int r = 0; r < ladder.length; r++) {
				for (int c = 0; c < ladder.length; c++) {
					ladder[r][c] = sc.nextInt();

					if (ladder[r][c] == 2) {
						endRow = r;
						endCol = c;
					}
				}
			}

			int direction = UP;
			// Row가 0이 될 때 까지 탐색 시작

			int nextRow = endRow;
			int nextCol = endCol;

			while (nextRow != 0) {
				// 다음 좌표로 이동
				nextRow = endRow + dRow[direction];
				nextCol = endCol + dCol[direction];

				// 위로 올라가면서
				// 왼쪽 또는 오른쪽으로 갈 수 있는지?
				if (direction == UP) {
					
					// 왼쪽으로 갈 수 있다.
					if (nextCol > 0 && ladder[nextRow][nextCol - 1] == 1) {
						direction = LEFT;
					}

					// 오른쪽으로 갈 수 있다.
					if (nextCol <99 && ladder[nextRow][nextCol + 1] == 1) {
						direction = RIGHT;
					}
					
				} else if (direction == LEFT || direction == RIGHT) {
					if(ladder[nextRow -1][nextCol] == 1) {
						direction = UP;
					}
				}  
				// 좌표를 갱신해주어야 한다.
				endRow = nextRow;
				endCol = nextCol;
				
			}
			System.out.println("#" + T + " " + nextCol);
		}
	}
}
