package day0308;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1260 {

	// 함수에서 사용할 변수들
	static int[][] treeArray; // 트리(간선 연결상태)
	static boolean[] visited; // 확인 여부
	static int nodeCnt; // 정점 개수
	static int lineCnt; // 간선 개수
	static int start; // 시작 정점 번호

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 정점의 개수
		nodeCnt = sc.nextInt();
		// 간선의 개수
		lineCnt = sc.nextInt();
		// 탐색을 시작할 정점의 번호
		start = sc.nextInt();

		treeArray = new int[nodeCnt + 1][nodeCnt + 1]; // 정점의 인덱스를 0이 아닌 1부터 받아들이기 위해 +1해서 nodeCnt+1로 선언

		// 간선 연결 상태 저장
		for (int i = 0; i < lineCnt; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			// 연결된 노드를 1로 세팅
			treeArray[x][y] = 1;
			treeArray[y][x] = 1;
		}

		visited = new boolean[nodeCnt + 1]; // 확인상태 초기화(node가 1부터 시작해서 nodeCnt+1을 해준다)
		// -> 초기값 : false

		dfs(start); // dfs호출
		System.out.println(); // 줄바꿈

		visited = new boolean[nodeCnt + 1]; // 위에 dfs하고 나서 확인상태 다시 초기화(node가 1부터 시작해서 nodeCnt+1을 해준다)

		bfs(start); // bfs호출
		System.out.println(); // 줄바꿈
		sc.close();
	}

	public static void dfs(int start) {
		// 방문하면 true로 바꿔주고
		visited[start] = true;
		// 방문한 노드의 번호 출력
		System.out.print(start + " ");

		for (int j = 1; j < treeArray.length; j++) {
			// 연결된 노드인데, 방문하지 않은 경우
			if (treeArray[start][j] == 1 && visited[j] == false) {
				// 해당 노드(연결된 노드)를 찾으면 재귀 함수 호출하여 방문하고 출력해주기
				dfs(j);
			}
		}
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		// 해당 노드를 추가
		queue.offer(start);
		// 방문했기에 true로 변환
		visited[start] = true;
		// 출력한다
		System.out.print(start + " ");

		while (!queue.isEmpty()) {
			int n = queue.poll();

			// 노드 하나로 연결된 모든 노드 먼저 다 체크
			for (int i = 1; i < treeArray.length; i++) {
				// 연결된 노드인데 방문하지 않은 경우
				if (treeArray[n][i] == 1 && visited[i] == false) {
					// 방문해서 true로 변환하고
					visited[i] = true;
					// 출력한다
					System.out.print(i + " ");
					queue.offer(i);

				}
			}
		}

	}
}



