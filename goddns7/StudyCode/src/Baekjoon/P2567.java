package day0216;

import java.util.Scanner;

public class P2567 {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 색종이의 수
		int num = sc.nextInt();
		// 도화지
		int[][] map = new int[100][100];

		for (int i = 0; i < num; i++) {
			// 색종이의 왼쪽아래 꼭짓점의 x와 y좌표
			int x = sc.nextInt();
			int y = sc.nextInt();

			// 각 꼭짓점으로부터 가로, 세로 방향으로 10씩 1을 넣어준다
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					map[j][k] = 1;
				}
			}
		}

		// 검정색 부분 둘레의 길이
		int count = 0;
		for (int k = 0; k < 100; k++) {
			for (int j = 0; j < 100; j++) {
				// 1이 나오면 델타배열을 이용해 상하좌우를 확인
				if (map[k][j] == 1) {
					for (int i = 0; i < 4; i++) {
						int x = k + dx[i];
						int y = j + dy[i];
						// 범위를 넘어가는 곳들은 경계선이라 둘레이기 때문에 count++해준다
						if (x < 0 || x >= 100 || y < 0 || y >= 100) {
							count++;
							continue;
							// 0이 나오면 둘레이기 때문에 count++해준다
						} else if (map[x][y] == 0) {
							count++;
						}
					}
				}
			}
		}

		System.out.println(count);

		sc.close();

	}
}


