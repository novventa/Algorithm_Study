package study_ssafy2;

/*
 * PriorityQueue(우선순위큐)를 사용한다.
 * dfs를 통해 각 좌표를 우선순위큐에 넣어서 문제를 해결한다.
 * 
 * 좌표에 먹을 수 있는 물고기가 존재할 때
 * 1. 거리가 더 가까운 것을 먹는다. ->너비탐색을 해야하는 이유
 * 2. 거리가 가까운 물고기가 여러개이면 위쪽부터 먹는다.
 * 3. 거리도 같고 row좌표 위치도 같다면 왼쪽부터 먹는다.
 * 
 * 위의 세가지 조건을 유의해서 Position class를 만들어서 우선순위를 미리 지정해준다
 * 이후 문제의 조건에 맞게 상어를 이동시키면서 총 걸리는 시간을 계산한다.
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어_김현수 {
	
	// 각 좌표의 x,y좌표 ,
	// distance =(그 좌표까지 거리)=(가는데 걸리는 시간 )
	static class Position implements Comparable<Position> {
		int x, y;
		int distance;

		public Position(int x, int y, int distance) {
			super();
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

		@Override
		public int compareTo(Position o) {
			
			// 거리가 같다면
			if (this.distance == o.distance) {
				// row 좌표가 같다면
				if (this.x == o.x) {
					// col좌표가 작은 것 선택
					return this.y - o.y;
				} 
				// row 좌표가 다르다면
				else {
					// row 좌표가 작은 것 선택
					return this.x - o.x;
				}
			} 
			// 거리가 다르다면
			else {
				// 거리가 작은 것 선택
				return this.distance - o.distance;
			}
		}
	}

	static int mapSize, sharkRow, sharkCol;
	static int sharkSize, fishCount, time;
	static int[][] map;
	static boolean[][] isVisted;

	static PriorityQueue<Position> pq;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	// 상좌하우
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {

		mapSize = Integer.parseInt(br.readLine().trim());

		map = new int[mapSize][mapSize];

		// map을 받아오면서
		for (int row = 0; row < mapSize; row++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int col = 0; col < mapSize; col++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[row][col] = tmp;
				
				// 상어의 위치를 저장하고
				if (tmp == 9) {
					sharkRow = row;
					sharkCol = col;
					
					// 상어가 존재하는 곳은 0으로 표시해준다
					// 왜냐면 9로 놔두면 상어가 이곳으로 이동하지 못하게 된다.
					map[row][col] = 0;
				}
			}
		}

		// 상어의 크기
		sharkSize = 2;
		
		// 먹은 물고기 개수
		fishCount = 0;
		
		// 총 걸린시간
		time = 0;

		// 물고기를 먹으러간다
		eat();

		// 출력
		System.out.println(time);
	}

	private static void eat() {
		
		// 우선순위큐 초기화
		pq = new PriorityQueue<>();

		// 방문했다는 것을 표시해줄 논리형 2차원 배열
		isVisted = new boolean[mapSize][mapSize];
		
		// 현재 위치 방문했다고 표시
		isVisted[sharkRow][sharkCol] = true;

		// 현재 위치를 넣어주고
		pq.add(new Position(sharkRow, sharkCol, 0));

		// 물고기를 먹었는지 확인해줄 논리형
		boolean isCatched = false;

		while (!pq.isEmpty()) {
			
			// 큐에서 원소를 하나 빼서
			Position p = pq.poll();

			// 만약 먹을 수 있는 물고기라면
			if (map[p.x][p.y] > 0 && map[p.x][p.y] < sharkSize) {
				
				// 물고기가 있는 자리를 빈칸으로 바꾸고
				map[p.x][p.y] = 0;
				
				// 물고기 먹은 수를 카운트 해주고
				fishCount++;
				
				// 가는데 걸린 시간을 더해주고
				time += p.distance;
				
				// 상어의 위치를 바꾸어준다.
				sharkRow = p.x;
				sharkCol = p.y;
				
				// 물고기를 먹었다고 표시한다.
				isCatched = true;

				// 만약 물고기 개수가 상어 크기랑 같아지면
				if (fishCount == sharkSize) {
					
					// 상어 크기를 늘리고
					sharkSize++;
					
					// 물고기 잡은 개수를 초기화한다
					fishCount = 0;
				}

				// 물고기를 먹었으므로 반복문을 종료한다
				break;
			}
			
			// 만약 먹을 수 없다면
			// 4방향으로 이동하면서
			for (int i = 0; i < 4; i++) {
				int nr = dr[i] + p.x;
				int nc = dc[i] + p.y;

				// 범위를 벗어나면 다음 좌표확인
				if (nr == -1 || nr == mapSize || nc == -1 || nc == mapSize) {
					continue;
				}

				// 방문했다면 다음좌표로
				if (isVisted[nr][nc]) {
					continue;
				}

				// 물고기 크기가 상어 크기보다 크면 다음좌표로
				if (map[nr][nc] > sharkSize) {
					continue;
				}

				// 모두 해당하지 않는다면 방문했다고 표시한다.
				isVisted[nr][nc] = true;

//				int tmp = Math.abs(nr - sharkRow) + Math.abs(nc - sharkCol);
//				System.out.printf("tmp : %d, 답: %d\n",tmp,p.distance+1);
				// 아.... 이건 길을 가다가 못갈 수도 있기 때문에
				// 시작지점과 도착지점의 최단거리를 넣어주면 안된다..!!!
				// 무조건 현재위치보다 1을 늘려서 넣어줘야하네
				pq.add(new Position(nr, nc, p.distance+1));

			}

		}

		// 만약 물고기를 못먹었다면 메소드 종료
		if (!isCatched) {
			return;
		}

		// 다음 물고기를 먹으러 간다.
		eat();

	}
}
