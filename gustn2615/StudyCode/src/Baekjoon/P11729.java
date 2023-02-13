package Baekjoon;

public class P11729 {
	public static void main(String[] args) {

		int[][] hanoi = new int[3][7];
		int cnt = 0;
		for (int i = 0; i < 7; i++) {
			hanoi[0][i] = 1;
		}
		Hanoi(7, hanoi, cnt);
	}

	public static void Hanoi(int N, int[][] hanoi, int cnt) {
		if (N % 2 == 0) {
			for (int i = 0; i < N; i++) {
				if (hanoi[0][i] == 1) {
					for (int j = 0; j <= i; j++) {
						if(hanoi[1][j]==1) {
							hanoi[2][i]=1;
							hanoi[0][i]=0;
							cnt++;
						}
						else {
							hanoi[1][i]=1;
							hanoi[0][i]=0;
							cnt++;
						}
					}
				}
			}
		}
	}
}
