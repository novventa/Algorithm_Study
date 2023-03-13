package day0313;

import java.util.Scanner;

public class P1149 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 집의 수
		int houseCnt = sc.nextInt();

		// 각 줄의 최소 비용
		int[][] DP = new int[houseCnt + 1][3];
		// 가격 입력
		for (int idx = 1; idx <= houseCnt; idx++) {

			// 각 색의 비용 입력받기
			int R = sc.nextInt();
			int G = sc.nextInt();
			int B = sc.nextInt();

			// col=0 : 윗 칸에서 1 또는 2를 택하는 경우이므로 그 중 최소값을 받고 R을 더한다
			// col=1 : 윗 칸에서 0 또는 2를 택하는 경우이므로 그 중 최소값을 받고 G을 더한다
			// col=2 : 윗 칸에서 0 또는 1를 택하는 경우이므로 그 중 최소값을 받고 B을 더한다
			DP[idx][0] = Math.min(DP[idx - 1][1], DP[idx - 1][2]) + R;
			DP[idx][1] = Math.min(DP[idx - 1][0], DP[idx - 1][2]) + G;
			DP[idx][2] = Math.min(DP[idx - 1][0], DP[idx - 1][1]) + B;

		}

		// 마지막 row에서 col=0, 1, 2 중에서 최소값을 고르면 됨
		System.out.println(Math.min(DP[houseCnt][0], Math.min(DP[houseCnt][1], DP[houseCnt][2])));

		sc.close();
	}
}
