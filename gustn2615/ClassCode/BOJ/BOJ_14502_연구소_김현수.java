package study_ssafy2;

/*
 * 1. 조합을 사용해서 전체 빈칸 중 3개의 벽을 놓을 수 있는 경우를 모두 찾는다
 * 2. 모든 경우에 대해서 바이러스가 퍼지는 경우를 확인한다
 * 3. 이후 빈칸이 가장 많을 때를 저장한다.
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소_김현수 {

	// 위치를 저장해줄 CLASS
	static class Position {
		int x, y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static int N, M, max;
	static int[][] map;
	static boolean[][] visted;
	static Queue<Position> q;

	// 배열을 복사해서 사용해야 하므로 정의한다
	// 기존 연구소를 복사할 배열
	static int[][] tmpMap;
	// 방문한곳인지 체크해줄 배열
	static boolean[][] tmpVisted;

	// 상 우 하 좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		// 연구소의 모양을 받아온다
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// 빈칸이 최대일때를 저장해줄 변수
		max = Integer.MIN_VALUE;
		
		// 조합에서 방문했는지를 알려줄 배열
		visted = new boolean[N][M];
		
		// 조합메소드 실행
		combination(0);
		
		// 정답 출력
		System.out.println(max);
	}

	static void combination(int depth) {
		
		// 만약 벽 3개를 다세웠다면
		if (depth == 3) {
			
			// 연구소의 모양과 방문위치를 임시로 저장할 배열을 만들고
			tmpMap = new int[N][M];
			tmpVisted = new boolean[N][M];

			// 배열을 복사한다
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					tmpMap[r][c] = map[r][c];
					tmpVisted[r][c] = visted[r][c];
				}
			}

			// 전체 배열을 돌면서
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					// 바이러스 위치이면서 방문하지 않았다면
					if (tmpMap[r][c] == 2 && !tmpVisted[r][c]) {
						// 너비탐색한다.
						bfs(new Position(r, c));
					}
				}
			}
			
//			for (int r = 0; r < N; r++) {
//				for (int c = 0; c < M; c++) {
//					System.out.printf("%2d",tmpMap[r][c]);
//				}System.out.println();
//			}
//			System.out.println();
			

			// 빈칸의 개수를 세어줄 변수
			int count = 0;
			// 빈칸의 개수를 세고
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (tmpMap[r][c] == 0) {
						count++;
					}
				}
			}

			// 최대값을 저장 후 메소드를 종료한다
			max = Math.max(count, max);
			return;
		}

		// 조합으로 3개의 좌표를 벽으로 만들어준다
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 0) {
					//빈칸이라면 벽으로 바꾸어주고
					map[r][c] = 1;
					// 뽑았다고 표시
					visted[r][c] = true;
					// 다음 좌표를 뽑으러간다
					combination(depth + 1);
					// 빈칸으로 다시 만들고
					map[r][c] = 0;
					// 안뽑았다고 표시
					visted[r][c] = false;
				}
			}
		}
	}

	static void bfs(Position position) {
		q = new ArrayDeque<>();

		q.add(position);

		tmpVisted[position.x][position.y] = true;

		// bfs로 바이러스를 퍼뜨린다
		while (!q.isEmpty()) {
			Position p = q.poll();

			// 현재 위치에서 4방향을 돌면서
			for (int i = 0; i < 4; i++) {
				int nr = dr[i] + p.x;
				int nc = dc[i] + p.y;

				// 만약 방문했거나 map을 벗어나면 다음좌표로 간다
				if (nr == -1 || nr == N || nc == -1 || nc == M || tmpVisted[nr][nc]) {
					continue;
				}

				// 만약 벽이라면 방문했다고 하고 다음좌표로 간다
				if (tmpMap[nr][nc] == 1) {
					tmpVisted[nr][nc] = true;
					continue;
				}

				// 빈칸이거나 바이러스 라면
				// 큐에 넣어주고 바이러스칸으로 만들고 방문했다고 표시한다
				q.add(new Position(nr, nc));
				tmpMap[nr][nc] = 2;
				tmpVisted[nr][nc] = true;
			}
		}

	}
}
