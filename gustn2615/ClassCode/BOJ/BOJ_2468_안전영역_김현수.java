package study_ssafy;

/*
 * bfs를 통해서 문제를 풀어낸다
 * 
 * 1. 행렬을 받아온다
 * 2. 물이 잠기는 높이를 1씩 늘려가면서 물에 잠기지 않는 영역을 센다
 * 3. 물이 잠기는 영역은 map의 높이를 벗어날 수 없으므로 미리 최대 높이를 구해놓는다
 * 4. 물에 잠기지않은 부분들을 bfs를 통해 확인한다. 확인한 부분은 논리형을 통해 표시해준다
 * 5. 최대 안전영역의 개수를 계산한다.
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class solution_2468_안전영역_김현수 {

	// 좌표를 담아놓을 class
	static class Position {
		int x, y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, heightMax, count, max;
	static int[][] map;
	static boolean[][] visted;
	static Queue<Position> queue;

	// bfs에 사용할 델타배열
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		// 입력을 받아올 메소드
		input();

		// 안전한 영역을 구하는 메소드
		solution();

		// 안전한 영역의 최대값을 출력한다
		System.out.println(max);
	}

	// 안전한 영역을 구하는 메소드
	static void solution() {

		// 안전한 영역의 최대값을 저장할 변수
		max = Integer.MIN_VALUE;

		// 비에 잠기는 높이를 늘려가면서
		for (int k = 0; k <= heightMax; k++) {

			// 안전한 영역을 세어줄 임시 변수
			count = 0;

			// 방문한 곳을 표시해줄 논리형
			visted = new boolean[N][N];

			// 전체 map을 돌면서
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {

					// 비에 잠기는 높이보다 크고 방문하지 않았다면
					if (k < map[row][col] && !visted[row][col]) {

						// bfs를 통해 안전 영역을 확인 후
						bfs(new Position(row, col), k);

						// 세어준다
						count++;
					}
				}
			}

			// 이때 최대값을 저장한다
			if (max < count) {
				max = count;
			}
		}
	}

	// 안전한 영역을 찾아줄 bfs 메소드
	static void bfs(Position position, int k) {

		// 좌표를 넣어줄 queue 만들기
		queue = new ArrayDeque<>();

		// 큐에 좌표 넣기
		queue.offer(position);

		// 방문했다고 표시
		visted[position.x][position.y] = true;

		// 큐가 빌때 까지 반복
		while (!queue.isEmpty()) {

			// 큐에서 하나의 좌표를 빼서
			Position p = queue.poll();

			// 사방을 탐색
			for (int i = 0; i < 4; i++) {
				int nr = p.x + dr[i];
				int nc = p.y + dc[i];

				// 범위를 벗어나거나 방문했다면 다음좌표확인
				if (nr == -1 || nr == N || nc == -1 || nc == N || visted[nr][nc]) {
					continue;
				}

				// 비에 잠기는 높이보다 작거나 같아도 다음 좌표 확인
				if (map[nr][nc] <= k) {
					continue;
				}

				// 방문했다고 표시
				visted[nr][nc] = true;

				// 큐에 넣어주기
				queue.offer(new Position(nr, nc));
			}
		}
	}

	// 입력값 받아오기
	static void input() throws IOException {

		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];

		// 지형의 최대 높이를 저장해줄 변수
		heightMax = Integer.MIN_VALUE;

		// 전체를 훑으면서
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int col = 0; col < N; col++) {
				// map에 넣는다
				int tmp = Integer.parseInt(st.nextToken());
				map[row][col] = tmp;

				// 최대 높이이면은 갱신해준다.
				if (heightMax < tmp) {
					heightMax = tmp;
				}
			}
		}
	}
}
