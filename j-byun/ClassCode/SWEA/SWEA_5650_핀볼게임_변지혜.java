import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author jhye.byun
 * SWEA 5650 핀볼 게임 모의 SW 역량테스트
 * 
 * 문제
 * N*N 핀볼 게임판에서 핀볼 게임을 하자.
 * 정사각형 블록 / 4가지 형태의 삼각형 블록 / 웜홀 / 블랙홀
 * 작은 핀볼 하나가 상하좌우 중 한 방향으로 움직인다.
 * 핀볼은 블록/웜홀/블랙홀을 만나지 않는 한 현재 방향을 유지하면서 계속 직진하며,
 * 블록의 수평이나 수직면을 만날 경우 방향을 바꿔 반대 방향으로 돌아오고,
 * 경사면을 만날 경우 직각으로 진행 방향이 꺾이게 된다.
 * 핀볼이 벽을 만날 경우에도 반대 방향으로 돌아온다.
 * 핀볼이 웜홀에 빠지면 동일한 숫자를 가진 다른 반대편 웜홈로 빠져 나오게 되며, 진행방향은 그대로 유지된다.
 * 핀볼이 블랙홀을 만나면, 핀볼이 사라지게 되어 게임은 끝난다.
 * 게임 종료 조건 : 1. 핀볼이 출발 위치로 돌아오거나, 2. 블랙홀에 빠지면 끝난다.
 * 게임 점수 : 벽이나 블록에 부딪힌 횟수 (웜홀 통과는 포함x)
 * 게임에서 얻을 수 있는 점수의 최댓값을 구하여라!
 * 
 * 조건
 * 게임판은 정사각형이며, 한 변의 길이 N은 5이상 100이하이다.
 * 웜홀은 게임판 내에서 숫자 6~10으로 주어진다.
 * 블랙홀은 게임판 내에서 숫자 -1로 주어진다.
 * 게임판에서 웜홀 또는 블랙홀이 존재하지 않는 경우도 있다.
 * 웜홀이 있는 경우 반드시 쌍으로 존재하며, 웜홀이 주어지는 경우 최대 5쌍 존재한다.
 * 블랙홀은 최대 5개가 주어진다.
 * 
 * 풀이
 * 1. 상우하좌 델타배열을 만들자.
 * 1-1. 벽이나 블록의 수직수평면에 부딪히면 현재 진행방향 + 2 % 4 의 방형으로 전환하고 점수 + 1점
 * 1-2. 1번 블록 : 하 -> 우 / 좌 -> 상
 * 1-3. 2번 블록 : 상 -> 우 / 좌 -> 하
 * 1-4. 3번 블록 : 상 -> 좌 / 우 -> 하
 * 1-5. 4번 블록 : 하 -> 좌 / 우 -> 상
 * 2. 시작점 : 상하좌우 방향이 빈 칸이 아닌 경우에만 시작하자.
 * 2-1. 어차피 다음 칸이 빈 칸이면 똑같으니까 중복으로 고려할 필요 없음
 */

public class SWEA_5650_핀볼게임_변지혜 {
	
	static int[] dr = new int[] {-1, 0, 1, 0}; // 상우하좌 델타배열
	static int[] dc = new int[] {0, 1, 0, -1};
	
	static int size, result;
	static int[][] map;
	static List<Coo>[] wormhole;
	
	public static void play(int row, int col, int dir) {
		
		// 현재 출발 지점에서 얻은 점수를 저장할 변수
		int score = 0;
		
		// 출발점이 좌표를 저장해두자
		int startRow = row;
		int startCol = col;
		
		while (true) {
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			
			// 벽을 만나면 1점 획득하고 방향 전환
			if (nr < 0 || nr >= size || nc < 0 || nc >= size) {
				score++;
				row = nr;
				col = nc;
				dir = (dir + 2) % 4;
				continue;
			}
			
			// 출발점으로 돌아오면 게임 종료
			if (nr == startRow && nc == startCol)
				break;
			
			// 블랙홀을 만나면 게임 종료
			if (map[nr][nc] == -1)
				break;
			
			// 빈 칸을 만나면 계속 직진
			if (map[nr][nc] == 0) {
				row = nr;
				col = nc;
				continue;
			}
			
			// 블록을 만나면 1점 획득하고 방향 전환
			if (map[nr][nc] >= 1 && map[nr][nc] <= 5) {
				int block = map[nr][nc]; // 블록 번호
				
				score++;
				row = nr;
				col = nc;
				
				if (block == 1 && dir == 2)
					dir = 1;
				else if (block == 1 && dir == 3)
					dir = 0;
				else if (block == 2 && dir == 0)
					dir = 1;
				else if (block == 2 && dir == 3)
					dir = 2;
				else if (block == 3 && dir == 0)
					dir = 3;
				else if (block == 3 && dir == 1)
					dir = 2;
				else if (block == 4 && dir == 2)
					dir = 3;
				else if (block == 4 && dir == 1)
					dir = 0;
				else
					dir = (dir + 2) % 4;
				
				continue;
			}
			
			// 웜홀을 만나면 반대편 웜홀로 빠져나가자
			if (map[nr][nc] >= 6 && map[nr][nc] <= 10) {
				int num = map[nr][nc]; // 웜홀 번호
				
				// 해당 번호 웜홀 쌍 중 먼저 들어온 좌표를 확인해보자
				Coo wormCoo = wormhole[num].get(0);
				
				// 먼저 들어온 좌표에 있다면, 다음 웜홀 좌표로 이동하자
				if (wormCoo.row == nr && wormCoo.col == nc) {
					row = wormhole[num].get(1).row;
					col = wormhole[num].get(1).col;
				} else {
					// 먼저 들어온 좌표에 있지 않다면, 먼저 들어온 좌표로 이동하자
					row = wormhole[num].get(0).row;
					col = wormhole[num].get(0).col;
				}
				
				continue;
			}
			
		}
		
		// 이번 판 점수가 여태까지 최고점보다 높았다면 점수 업데이트
		result = Math.max(result, score);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기
		
		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복 실행
			
			size = sc.nextInt(); // 맵의 한 변의 길이 N 입력받기
			
			map = new int[size][size]; // N*N 크기의 게임판 만들기
			
			// 웜홀의 정보를 저장할 공간을 만들자
			wormhole = new ArrayList[11];
			
			// 귀찮으니까 11만큼 만들어서 6~10번 인덱스만 사용하자
			for (int idx = 6; idx <= 10; idx++) {
				wormhole[idx] = new ArrayList<>();
			}
			
			// 게임판의 블록, 웜홀, 블랙홀 정보 입력받기
			for (int row = 0; row < size; row++) {
				for (int col = 0; col < size; col++) {
					int curr = sc.nextInt();
					
					map[row][col] = curr;
					
					// 현재 좌표가 웜홀이라면 웜홀 리스트에 좌표를 저장하자
					if (curr >= 6 && curr <= 10)
						wormhole[curr].add(new Coo(row, col));
				}
			}
			
			// 최대 점수 저장할 변수를 일단 0점으로 초기화하자
			result = 0;
			
			// 게임판에서 시작 위치와 시작 방향을 정해보자
			// 현재 칸이 빈 칸이고, 진행하려는 방향이 빈 칸이 아닌 경우에만 게임 시작!
			for (int row = 0; row < size; row++) {
				for (int col = 0; col < size; col++) {
					if (map[row][col] != 0) continue;
					
					// 현재 칸이 빈 칸이라면,
					// 네 방향에 대해 다음 칸이 빈 칸인지 확인해보자
					for (int d = 0; d < 4; d++) {
						int nr = row + dr[d];
						int nc = col + dc[d];
						
						// 진행방향이 벽이면 플레이 해보자
						if (nr < 0 || nr >= size || nc < 0 || nc >= size) {
							play(row, col, d);
							continue;
						}
						
						// 빈 칸이면 다른 방향 확인
						if (map[nr][nc] == 0)
							continue;
						
						// 빈 칸이 아니면 플레이 해보자
						play(row, col, d);
					}
				}
			}
			
			// 모든 경우에서 플레이를 해봤으니, 저장된 최대 점수를 출력하자
			System.out.printf("#%d %d\n", tc, result); // 결과 출력
		}
	}
	
	// 웜홀의 좌표를 저장하기 위한 Coo 클래스를 만들자
	public static class Coo {
		int row, col;
		public Coo(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
}
