package day0313;

import java.util.Scanner;

public class P2606 {
	// 컴퓨터 수
	static int computerCnt;
	// 컴퓨터가 연결된 트리
	static int[][] tree;
	// 방문했는지 기록 남기기 위한 배열
	static boolean[] visited;
	// 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 컴퓨터 수
		computerCnt = sc.nextInt();
		// 연결되어 있는 컴퓨터 쌍의 수
		int comPair = sc.nextInt();

		// 컴퓨터가 연결된 트리
		tree = new int[computerCnt + 1][computerCnt + 1];
		visited = new boolean[computerCnt + 1];

		for (int i = 0; i < comPair; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			tree[a][b] = 1;
			tree[b][a] = 1;
		}

		dfs(1);
		System.out.println(count);
		sc.close();
	}

	private static void dfs(int x) {
		visited[x] = true;
		for (int i = 1; i < computerCnt + 1; i++) {
			if (tree[x][i] == 1 && visited[i] == false) {
				count++;
				dfs(i);
			}
		}

	}
}
