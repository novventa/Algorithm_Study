package study_ssafy2;

/*
 * bfs와 2차원 방문처리 배열을 이용해 문제를 풀어주었다
 * 1. 색의 배열을 입력받는다.
 * 2. map을 훑으면서 방문하지 않은 곳이 있을 때 그 지점을 기준으로 bfs 탐색을 한다.
 * 3. bfs 탐색을 하면서 방문처리를 해준다. 탐색이 끝나면 하나의 구역이 생긴다
 * 4. 2~3을 반복하면서 전체 map을 훑는다.
 * 5. map의 G와 R을 같게 놔두고 위의 과정을 반복한다.
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_10026_적록색약_김현수 {

	// 위치를 저장해줄 CLASS
	static class Position {
		int x, y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static int N, normal, strange;
	static char[][] map;
	static boolean[][] visted;
	static Queue<Position> q;

	// 상 우 하 좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		// map의 크기
		N = Integer.parseInt(br.readLine().trim());

		// 맵 정의
		map = new char[N][N];

		// 맵 색 받아오기
		for (int r = 0; r < N; r++) {
			String str = br.readLine().trim();
			for (int c = 0; c < N; c++) {
				map[r][c] = str.charAt(c);
			}
		}

		// 정상인일 때
		visted = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visted[r][c]) {
					bfs(new Position(r, c));
					normal++;
				}
			}
		}

		// 적녹색약 일 때 확인하기 위해 map을 바꾸어준다
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 'G') {
					map[r][c] = 'R';
				}
			}
		}

		// 적녹색약 일 때
		visted = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visted[r][c]) {
					bfs(new Position(r, c));
					strange++;
				}
			}
		}

		// 결과 출력
		System.out.println(normal + " " + strange);

	}

	static void bfs(Position position) {

		// bfs에 사용할 큐
		q = new ArrayDeque<>();

		// 큐에 시작 좌표를 넣어준다
		q.add(position);

		// 시작 좌표를 방문처리 해준다
		visted[position.x][position.y] = true;

		// 큐가 빌때까지 반복
		while (!q.isEmpty()) {

			// 큐에서 좌표 하나를 뺀다
			Position p = q.poll();

			// 4방향을 돌면서
			for (int i = 0; i < 4; i++) {
				int nr = dr[i] + p.x;
				int nc = dc[i] + p.y;

				// 범위를 벗어나거나 방문했었다면 다음좌표 확인
				if (nr == -1 || nr == N || nc == -1 || nc == N || visted[nr][nc]) {
					continue;
				}

				// 두 색이 같지않다면 다음 좌표로
				if (map[p.x][p.y] != map[nr][nc]) {
					continue;
				}

				// 같은 색이라면 방문처리 했다고 표시해주고 큐에 좌표를 넣어준다.
				visted[nr][nc] = true;
				q.add(new Position(nr, nc));
			}
		}
	}

}
