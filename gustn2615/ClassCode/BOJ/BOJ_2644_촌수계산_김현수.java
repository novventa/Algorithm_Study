
package study_ssafy;

/*
 * 플로이드 워셜 알고리즘을 통해 문제를 해결한다
 * 플로이드 워셜 알고리즘은 각 모든 정점에서 다른 정점까지의 최단거리를 구할 수 있는 알고리즘이다
 * 따라서 부모와 자식간에 간선의 값이 1로 연결 되어있다고 가정하고 이를 통해 최단거리를 구하면 촌수가 된다
 * 
 * 1. 전체 map을 충분히 큰값으로 초기화한다
 * 2. 입력된 부모 자식 간의 간선을 인접행렬을 통해 나타낸다
 * 3. 플로이드 워셜을 통해 최단 거기를 구한다
 * 4. 정답을 출력한다
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution_2644_촌수계산_김현수 {
	static int V, E;
	static int person1, person2;
	static int[][] map;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		// 전체 사람수
		V = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine().trim());

		// 서로다른 두사람의 번호
		person1 = Integer.parseInt(st.nextToken());
		person2 = Integer.parseInt(st.nextToken());

		// 간선의 개수
		E = Integer.parseInt(br.readLine().trim());

		// 인접행렬을 표현할 2차원 배열
		map = new int[V + 1][V + 1];

		// 충분히 큰값으로 초기화
		for (int row = 0; row < V + 1; row++) {
			for (int col = 0; col < V + 1; col++) {
				if (row != col) {
					map[row][col] = 1000000;
				}
			}
		}

		// 부모 자식간의 관계를 인접행렬로 표현
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int tmpParent = Integer.parseInt(st.nextToken());
			int tmpChild = Integer.parseInt(st.nextToken());
			map[tmpParent][tmpChild] = 1;
			map[tmpChild][tmpParent] = 1;
		}
		br.close();

		// 모든 정점에서 다른 정점까지 최단거리 구하기
		for (int k = 0; k < V + 1; k++) {
			for (int row = 0; row < V + 1; row++) {
				for (int col = 0; col < V + 1; col++) {
					map[row][col] = Math.min(map[row][col], map[row][k] + map[k][col]);
				}
			}
		}

		// 결과 출력
		System.out.println(map[person1][person2] == 1000000 ? -1 : map[person1][person2]);

	}

}
