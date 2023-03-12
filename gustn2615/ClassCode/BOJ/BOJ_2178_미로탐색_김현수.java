package study_ssafy;

/*
 * 미로탐색이기 때문에 dfs(깊이 탐색)보다는 bfs(너비 탐색)이 더 적당하다
 * 1. map을 받아온다.
 * 2. queue를 통해 bfs 탐색을 한다.
 * 3. 이때 queue에 추가되는 것은 다음에 이동할 수 있는 1차원 배열의 좌표이다.
 * 4. 또한 방문했던 미로는 또 탐색하면 안되기 때문에 논리형 배열 또한 만들어 준다.
 * 
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class solution_2178_미로탐색_김현수 {

	// 미로를 받아올 배열
	static int[][] map;

	// 미로의 크기를 받아올 변수
	static int N, M;

	// 미로에 탐색 여부를 알려줄 2차원 논리형 배열
	static boolean[][] visited;

	// 델타배열 사용
	static int[] deltaRow = { -1, 1, 0, 0 }; // x방향배열-상하
	static int[] deltaCol = { 0, 0, -1, 1 }; // y방향배열-좌우

	public static void main(String[] args) throws IOException {

		// 버퍼리더 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Tokenizer 사용
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 미로의 크기 받아오기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 미로 배열 정의 후 받아오기
		map = new int[N][M];
		for (int row = 0; row < N; row++) {
			String str = br.readLine();
			for (int col = 0; col < M; col++) {
				// char로 받아왔으므로 '0'을 빼준다
				map[row][col] = str.charAt(col) - '0';
			}
		}
		// 버퍼 리더 종료

		br.close();
		// 미로의 탐색 여부를 알려줄 논리형 정의
		visited = new boolean[N][M];

		// 첫번째 자리는 무조건 방문하므로 true로 정의
		visited[0][0] = true;

		// 미로 탐색
		bfs(0, 0);

		// 결과출력
		System.out.println(map[N - 1][M - 1]);
	}

	// 미로 탐색
	public static void bfs(int x, int y) {

		// 큐를 사용, ArrayDeque이 제일 빨라서 사용 권장
		// 여기에 미로의 좌표를 넣어준다
		Queue<int[]> queue = new ArrayDeque<int[]>();

		// 큐에 처음 방문한 미로의 좌표를 넣어준다
		queue.add(new int[] { x, y });

		// 큐가 빌때 까지 반복한다
		while (!queue.isEmpty()) {

			// 현재 좌표를 빼내어서
			int[] now = queue.poll();

			// 좌표를 각각 저장해준다
			int nowX = now[0];
			int nowY = now[1];

			// 4방향을 돌면서
			for (int i = 0; i < 4; i++) {

				// 이동한 미로의 좌표를 새로 지정한다
				int newRow = nowX + deltaRow[i];
				int newCol = nowY + deltaCol[i];

				// 이동한 미로가 범위안에 있을 때
				if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < M) {

					// 만약 미로가 방문하지 않았고 값이 1이라면
					if (visited[newRow][newCol] == false && map[newRow][newCol] == 1) {
						visited[newRow][newCol] = true;

						// 그 좌표는 이동할 수 있으므로 queue에 넣어주고
						queue.add(new int[] { newRow, newCol });

						// 이동한 미로는 그 이전 미로값에 1을 더해준다
						map[newRow][newCol] = map[nowX][nowY] + 1;
					}
				}
			}
		}

	}
}