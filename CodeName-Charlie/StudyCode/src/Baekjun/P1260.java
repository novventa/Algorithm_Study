
// 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
// 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
// 정점 번호는 1번부터 N번까지이다.

package Baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1260 {
	static int[][] branch; // 간선 연결 상태
	static boolean[] visit; // 노드 확인 여부
	static int N; // 정점 개수
	static int M; // 간선 개수
	static int V; // 시작할 정점의 번호

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		branch = new int[1001][1001]; // 정점의 개수가 최대 1000개 이기 때문에, 간선 연결 상태를 나타내는 배열 branch를 1001 x 1001 크기로 생성한다.
		visit = new boolean[1001]; // 초기값 false로 설정

		// 간선 연결상태 저장
		for (int i = 0; i < M; i++) { // 반복문을 통해 간선의 연결상태를 저장한다.
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(str.nextToken());
			int y = Integer.parseInt(str.nextToken());

			branch[x][y] = branch[y][x] = 1; // 간선이 연결되었다면, 해당 배열의 요소값에 1을 입력한다.
		}

		dfs(V); // dfs 메서드 실행한다.

		visit = new boolean[1001]; // 방문 상태를 초기화하고
		System.out.println();

		bfs(); // bfs 메서드를 실행한다.
	}

	// 시작점을 변수로 받아 확인하고, 출력 후 다음 연결점을 찾아 시작점을 변경하여 다시 호출한다.
	// 재귀함수를 통해 dfs 메서드를 표현한다.
	public static void dfs(int i) {
		visit[i] = true;
		System.out.print(i + " ");

		for (int j = 1; j <= N; j++) {
			if (branch[i][j] == 1 && visit[j] == false) {
				dfs(j);
			}
		}
	}
	
	// 큐를 활용해 bfs 메서드를 표현한다.
	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(V); // 시작점도 Queue에 넣는다.
		visit[V] = true;
		System.out.print(V + " ");

		// Queue가 빌 때까지 반복하고, 방문 정점은 확인한 뒤, 출력 후 Queue에 넣어 순서대로 확인한다.
		while (!q.isEmpty()) {
			int temp = q.poll();

			for (int j = 1; j <= N; j++) {
				if (branch[temp][j] == 1 && visit[j] == false) {
					q.offer(j);
					visit[j] = true;
					System.out.print(j + " ");
				}
			}
		}

	}
}
