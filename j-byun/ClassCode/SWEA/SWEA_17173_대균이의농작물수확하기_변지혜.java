import java.util.Scanner;

/**
 * @author jhye.byun
 * SWEA 17173 대균이의 농작물 수확하기 모의A형기출
 * 
 * 문제
 * 농작물을 수확하는 로봇
 * 로봇은 바라보고 있는 방향 기준 오른쪽, 앞, 왼쪽, 뒤 순서로 확인하면서 이동한다.
 * 1일 동안 다음과 같은 작업을 진행한다.
 * - 오전
 * 오후에 이동할 수 있는 영역이 있다면, 현재 위치에서 아래 2가지 중 1가지를 수행한다
 * 1) 씨앗을 심는다.
 * 2) 다 자란 농작물을 수확한다.
 * - 오후
 * 이동할 수 있는 영역으로 이동한다.
 * 
 * 씨앗을 심은 후 다음 날 싹이 트고, K+3일이 지나 수확할 수 있다.
 * 이때 K는 씨앗을 심는 회차이다.
 * 
 * 산이 있는 위치에는 농작물을 수확할 수 없다.
 * 
 * 조건
 * 영역의 크기 6 <= N <= 10
 * 로봇이 일하는 기간 (일) 10 <= D <= 50
 * 
 * 풀이
 * 걍 구현해!
 */

public class SWEA_17173_대균이의농작물수확하기_변지혜 {
	
	// 오른쪽 -> 앞 -> 왼쪽 -> 뒤
	// 시계 반대방향
	static int[] dr = new int[] {0, -1, 0, 1};
	static int[] dc = new int[] {1, 0, -1, 0};
	
	static int size, conditionDate, maxCrops;
	static int[][] map;
	
	public static int farming(int curRow, int curCol, int direction, int date) {
		
		// 배열 복사
		int[][] tmpMap = new int[size][size];
		
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				tmpMap[row][col] = map[row][col];
			}
		}
		
		// 해당 위치에 농작물 심은 회차 정보 저장할 배열
		int[][] turn = new int[size][size];
		int crops = 0;
		
		while (date < conditionDate) {
			
			// 오전
			boolean canMove = false;
			for (int cnt = 0; cnt < 4; cnt++) {
				// 우선순위 맞춰서 방향 확인
				int d = (direction - 1 + cnt + 4) % 4;
				
				int nr = curRow + dr[d];
				int nc = curCol + dc[d];
				
				// 오후에 갈 수 있어?
				// 산이면 못가지
				if (tmpMap[nr][nc] == conditionDate + 1) continue;
				// 갈 수 있으면 그 방향으로 픽스하고 for문 탈출
				if (tmpMap[nr][nc] == 0 || tmpMap[nr][nc] <= date) {
					direction = d;
					canMove = true;
					break;
				}
			}
			
			// 움직일 수 있는 칸이 하나도 없으면 걍 다음 날로 넘어가
			if (!canMove)  {
				date++;
				continue;
			}
			
			// 움직일 수 있는 칸이 하나라도 있다면?
			// 오전 => 일하고, 오후 => 움직여
			// 수확할게 있으면 수확해
			if (tmpMap[curRow][curCol] != 0) {
				tmpMap[curRow][curCol] = 0;
				crops++;
			} else {
				// 수확할거 없으면? 심어
				// 지금 날짜 + 싹트는 1일 + 수확할 수 있는 3일 + 회차 날 이상이 되면 수확 가능
				tmpMap[curRow][curCol] = date + 1 + 3 + ++turn[curRow][curCol];
			}
			
			// 오후
			// 이동할 방향으로 이동해~
			curRow += dr[direction];
			curCol += dc[direction];
			
			// 다음날로 넘어가
			date++;
		}
		
		return crops;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			size = sc.nextInt();
			conditionDate = sc.nextInt();
			
			map = new int[size][size];
			
			for (int row = 0; row < size; row++) {
				for (int col = 0; col < size; col++) {
					int curr = sc.nextInt();
					
					// 산은 최대 진행일+1로 만들어버리자
					// 영영 못가는 칸으로 만들면 되잖아!
					if (curr == 1) curr = conditionDate + 1;
					map[row][col] = curr;
				}
			}
			
			// 최대 수확 농작물 저장할 변수
			maxCrops = 0;
			
			for (int row = 0; row < size; row++) {
				for (int col = 0; col < size; col++) {
					// 산이면 어차피 못가
					if (map[row][col] == conditionDate + 1) continue;
					
					for (int d = 0; d < 4; d++) {
						maxCrops = Math.max(maxCrops, farming(row, col, d, 0));
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, maxCrops);
		}
	}

}
