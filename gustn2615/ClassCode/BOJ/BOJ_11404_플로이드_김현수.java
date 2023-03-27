package study_ssafy;

/*
 * 플로이드 와샬 알고리즘으로 풀어야한다.
 * 모든정점에서 모든정점으로 최단거리를 구하는 알고리즘이다.
 * 
 * */
import java.util.Scanner;

public class solution_11404_플로이드_김현수 {
	static int INF=10000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cityNum = sc.nextInt();
		int busNum = sc.nextInt();
		int[][] cityMap = new int[cityNum + 1][cityNum + 1];

		for (int row = 1; row < cityNum + 1; row++) {
			for (int col = 1; col < cityNum + 1; col++) {
				if (row != col)
					cityMap[row][col] = INF;
			}
		}

		
		
		for (int i = 0; i < busNum; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int cost = sc.nextInt();
			cityMap[x][y] = Math.min(cost, cityMap[x][y]);
		}
		
		sc.close();
		
			

		for (int k = 1; k < cityNum + 1; k++) {
			for (int row = 1; row < cityNum + 1; row++) {
				for (int col = 1; col < cityNum + 1; col++) {
					cityMap[row][col] = Math.min(cityMap[row][col], cityMap[row][k] + cityMap[k][col]);
				}
			}
		}
		

		for (int row = 1; row < cityNum + 1; row++) {
			for (int col = 1; col < cityNum + 1; col++) {
				if (cityMap[row][col] == INF) {
					System.out.print(0 + " ");
				} else {
					System.out.print(cityMap[row][col] + " ");
				}
			}
			System.out.println();
		}

	}
}
