import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author jhye.byun
 * SWEA 7733 치즈 도둑 D4 DFS/BFS
 * 
 * 문제
 * N*N크기의 치즈
 * 각 칸의 맛 점수가 상이하다.
 * 맛 점수는 1부터 100사이로 표현된다.
 * 100일동안 치즈를 갉아먹는데, X번째 날에는 맛 점수가 X인 칸을 먹는다.
 * 먹고 남은 칸의 상하좌우 인접한 묶음이 하나의 치즈 덩어리라고 할 때,
 * 100일 중에서 치즈 덩어리가 가장 많을 때의 덩어리 개수를 구하자.
 * 
 * 조건
 * 치즈의 한 변의 길이 N(2 ≤ N ≤ 100)
 * 
 * 풀이
 * 1. 0일에는 모든 치즈가 한 덩어리이니 확인할 필요가 없다.
 * 1-1. 따라서 최대 덩어리 개수의 초기값을 1로 선언하자.
 * 2. 100일째에는 다 먹어서 덩어리가 없으니 확인할 필요가 없다.
 * 3. 따라서 1일째~99일째까지 확인해보자.
 * 4. 하루가 시작될 때 마다 visited 정보를 초기화해주자.
 * 5. 각 날짜가 시작되면 치즈의 칸을 돌면서 현재 날짜 이상의 값을 찾자
 * 5-1. 찾은 칸은 true로 만들고 오늘 날짜의 치즈 덩어리를 하나 증가시키자
 * 5-2. 찾은 칸에서 너비 우선 탐색을 통해 상하좌우 방향의 인접한 칸들을 모두 true로 만들자
 * 5-3. 한 칸에 대해 인접한 칸들을 모두 true로 만들었다면, 다시 5번으로 돌아가서 true가 아니고, 현재 날짜 이상의 값인 칸을 찾자.
 * 6. 이렇게 각 날짜에 대한 치즈 덩어리 개수를 세어보고, 최대 덩어리 개수와 비교해서 업데이트 해주자.
 */

public class SWEA_7733_치즈도둑_변지혜 {
	
	static int[] dr = new int[] {-1, 0, 1, 0}; // 상우하좌 델타배열 : 인접 치즈를 찾기 위해 사용
	static int[] dc = new int[] {0, 1, 0, -1};
	
	static int size, maxPiece;
	static int[][] cheese;
	static boolean[][] visited;
	
	public static void search() {
		
		// 치즈 먹은 날을 1일째부터 99일째까지 확인해보자
		for (int day = 1; day < 100; day++) {
			// 각 날짜가 시작될 때 마다 방문 정보 초기화
			visited = new boolean[size][size];
			// 각 날짜가 시작될 때 마다 오늘의 치즈 덩어리 개수 초기화
			int curPiece = 0;
			
			// 치즈 덩어리에서 아직 안먹은 치즈를 찾아보자
			for (int row = 0; row < size; row++) {
				for (int col = 0; col < size; col++) {
					// 안먹었고 아직 덩어리에 포함되지 않은 조각을 찾았다면
					if (cheese[row][col] > day && !visited[row][col]) {
						curPiece++; // 덩어리 개수 +1
						visited[row][col] = true; // 이제 덩어리에 포함해주자
						
						// 각 날짜에 대해 그 날 아직 안먹은 치즈 조각을 찾았다면
						// 해당 치즈와 인접한 치즈들을 찾아 하나의 덩어리로 판단해야하니
						// 이 치즈들을 너비 우선 탐색하기 위해 저장해둘 큐 공간을 만들자.
						Queue<Coo> queue = new ArrayDeque<Coo>();
						queue.add(new Coo(row, col));
						bfs(day, queue); // 인접한 치즈 덩어리를 찾자
					}
				}
			}
			
			// 각 날짜에 대한 치즈 덩어리 개수를 모두 세어줬다면
			// 지금까지의 최대 덩어리 개수와 비교해서 값을 업데이트 시켜주자
			maxPiece = Math.max(maxPiece, curPiece);
		}
	}
	
	public static void bfs(int day, Queue<Coo> queue) {
		// serach에서 찾아낸 한 칸의 치즈에 대해 인접한 치즈 덩어리 묶음을 다 방문처리 해주자
		
		while (!queue.isEmpty()) {
			// 큐에 저장한 좌표 하나를 뽑아서 해당 좌표와 인접한 칸을 확인하자
			Coo cur = queue.poll();
			
			// 상하좌우 네 방향에 대해 확인
			for (int d = 0; d < 4; d++) {
				int nr = cur.row + dr[d];
				int nc = cur.col + dc[d];
				
				// 인접한 칸이 치즈 범위를 벗어나면 확인 불가
				if (nr < 0 || nr >= size || nc < 0 || nc >= size)
					continue;
				
				// 인접한 칸이 이미 먹힌 칸이면 다른 방향 확인
				if (cheese[nr][nc] <= day)
					continue;
				
				// 인접한 칸이 이미 방문했던 칸이면 다른 방향 확인
				if (visited[nr][nc])
					continue;
				
				// 위의 조건들에 걸리지 않았다면, 덩어리에 포함시켜주자!
				visited[nr][nc] = true; // 방문여부를 true로 만들고
				queue.add(new Coo(nr, nc)); // 큐에 넣어서 이 칸과 인접한 칸들도 확인하자
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기
		
		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복 진행
			size = sc.nextInt(); // 치즈의 한 변의 길이 N
			
			cheese = new int[size][size]; // 치즈 공간을 만들자
			
			// 치즈의 각 칸에 맛 점수를 입력받자
			for (int row = 0; row < size; row++) {
				for (int col = 0; col < size; col++) {
					cheese[row][col] = sc.nextInt();
				}
			}
			
			maxPiece = 1; // 최대 치즈 개수의 초기값을 1로 선언하자
			
			search(); // 각 날짜의 치즈 덩어리 개수를 확인해보자
			
			// 모든 날짜에 대해 덩어리 개수를 확인했다면,
			// 지금까지 찾은 최대 덩어리 개수를 출력하자
			System.out.printf("#%d %d\n", tc, maxPiece);
		}
	}
	
	// 큐에 좌표값을 한 번에 저장하기 위해 Coo 클래스를 만들어 사용하자
	public static class Coo {
		int row, col;
		
		public Coo(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
}
