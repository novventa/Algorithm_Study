package study_ssafy;

/*
 * DFS, BFS의 기본적인 개념을 가지고 푸는 문제이다
 * 
 * DFS : 깊이 우선 탐색이라고 하며 연결된 노드의 최대 깊이까지 우선적으로 탐색하는 방법이다
 *  
 * BFS : 너비 우선 탐색이라고 하며 가깝게 연결된 노드들 부터 차례대로 탐색하는 방법이다.
 *  => 최대한 멀리있는 노드를 우선적으로 탐색하는 DFS와는 반대이다.
 * 
 * 
 * 
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.StringTokenizer;

public class solution_1260_DFS와BFS_김현수 {

	// 각 정점번호가 방문된 정보를 1차원 배열 자료형으로 표현
	public static boolean[] visited;

	// 각 노드가 연결된 정보를 2차원 배열 자료형으로 표현
	public static Integer[][] graph;

	public static int N, M, start;

	public static void main(String[] args) throws IOException {

		// 버퍼 리더 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Tokenizer 사용
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 정점의 개수 받아오기
		N = Integer.parseInt(st.nextToken());

		// 간선의 개수 받아오기
		M = Integer.parseInt(st.nextToken());

		// 시작 노드
		start = Integer.parseInt(st.nextToken());

		// 정점과 index를 같게 보기 위해 N+1크기로 받는다
		visited = new boolean[N + 1];

		// 간선의 개수만큼 노드가 연결된 정보가 있으므로 M개로 만들어준다
		graph = new Integer[M][2];

		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			if (tmp1 > tmp2) {
				graph[i][0] = tmp2;
				graph[i][1] = tmp1;
			} else {
				graph[i][0] = tmp1;
				graph[i][1] = tmp2;
			}
		}
		br.close();

		Arrays.sort(graph, new Comparator<Integer[]>() {

			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				// TODO Auto-generated method stub
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}

		});

		for (int i = 0; i < M; i++) {
			System.out.println(Arrays.toString(graph[i]));
		}

		dfs(start);

		System.out.println();
		visited = new boolean[N + 1];
		bfs(start);

	}

	/*
	 * bfs 알고리즘을 수행하는 함수
	 * 
	 * @param v 탐색할 노드
	 */
	public static void bfs(int v) {

		Queue<Integer> queue = new ArrayDeque<>();

		queue.add(v);
		// 현재 노드 방문 처리
		visited[v] = true;

		// 인접 노드 탐색
		while (!queue.isEmpty()) {
			int tmp = queue.poll();

			System.out.print(tmp + " ");

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < 2; j++) {
					if (graph[i][j] == tmp) {

						for (Integer num : graph[i]) {
//						System.out.println(num);
							// 방문하지 않은 인접 노드 중 가장 작은 노드를 스택에 넣기
							if (visited[num] == false) {
								visited[num] = true;
								queue.add(num);
							}

						}
					}
				}

			}

		}

	}

	public static void dfs(int v) {
		visited[v] = true;

		System.out.print(v + " ");

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 2; j++) {
				if (graph[i][j] == v) {
//					System.out.printf("i번째 : %d j번쨰 : %d\n", i, j);
					for (Integer num : graph[i]) {
//						System.out.println(num);
						// 방문하지 않은 인접 노드 중 가장 작은 노드를 스택에 넣기
						if (visited[num] == false) {
							dfs(num);
						}
					}
				}
			}
		}
	}
}