package study_ssafy;

import java.util.Scanner;

public class solution_2567_색종이2_김현수_다시 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int paperNum = sc.nextInt();
		int[][] whiteBoard = new int[100][100];
		int[] deltaRow = { -1, 0, 1, 0 };
		int[] deltaCol = { 0, -1, 0, 1 };
		int[][] paper = new int[paperNum][2];
		for (int row = 0; row < paperNum; row++) {
			for (int col = 0; col < 2; col++) {
				paper[row][col] = sc.nextInt();
			}
		}

		for (int i = 0; i < paperNum; i++) {
			int x1 = paper[i][0];
			int y1 = paper[i][1];
			for (int row = x1; row < x1 + 10; row++) {
				for (int col = y1; col < y1 + 10; col++) {
					whiteBoard[row][col] = 1;
				}
			}
		}
//		for (int row = 0; row < 100; row++) {
//			for (int col = 0; col < 100; col++) {
//				System.out.print(whiteBoard[row][col]);
//			}
//			System.out.println();
//		}
		int count = 0;
		for (int row = 0; row < 100; row++) {
			for (int col = 0; col < 100; col++) {
				if (whiteBoard[row][col] == 1) {
					for (int j = 0; j < 4; j++) {
						int newRow = row + deltaRow[j];
						int newCol = col + deltaCol[j];
						if (newRow >= 0 && newRow < 100 && newCol >= 0 && newCol < 100) {
							if (whiteBoard[newRow][newCol] == 0) {
								count++;
							}
						}

					}
				}
			}
		}
		System.out.println(count);

	}
}
