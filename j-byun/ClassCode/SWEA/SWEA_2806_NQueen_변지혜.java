import java.util.Scanner;


/**
 * @author jhye.byun
 * SWEA 2806 N-Queen D3 백트래킹
 * 
 * 문제
 * 8*8체스판에 8개의 퀸을 서로 공격하지 못하게 배치하자.
 * 퀸은 같은 행, 열 , 또는 대각선 위에 있는 말을 공격할 수 있다.
 * N*N 보드에 N개의 퀸을 서로 다른 퀸이 공격하지 못하게 놓는 경우의 수는 몇가지가 있을까?
 * 
 * 조건
 * N(1 ≤ N ≤ 10)
 * 
 * 풀이
 * 1. N*N 크기의 체스판을 만들고, 퀸을 놓을 위치를 true로 표시해보자.
 * 2. N개의 퀸 중 i번째 퀸은 체스판의 i번째 행에만 위치할 수 있게 하자.
 * 3. i번째 행의 N개의 칸에 대해 위치시켜보고, 해당 열, 대각선 방향에 놓여진 다른 퀸이 없는 지 확인해보자.
 * 3-1. 열++, 열--, 대각선++, 대각선--, 대각선+-, 대각선-+ 여섯 방향을 확인하는 델타 배열을 만들자.
 * 4. N개의 퀸을 다 배치시켰는데 공격할 수 있는 퀸이 없다면, 경우의 수를 1 증가시켜주자.
 * 5. 처음부터 조건을 만족하지 못하는 경우는 빨리 가지를 쳐내기 위해 백트래킹으로 구현하자.
 * 
 * => 보완점
 * board를 1차원 배열로 만들어보자.
 * 보드의 인덱스를 열, 해당 칸에 들어갈 값을 행이라고 하자.
 * i번째 퀸을 위치시킬 때, 대각선 네 방향에 대해서만 퀸의 존재 여부를 확인하면 된다.
 * \ 대각선 : row-col값이 동일하다
 * / 대각선 : row+col값이 동일하다
 * 위의 두 대각선 특징을 활용해서 배치 가능 여부를 판단하고 배치하자!
 */

public class SWEA_2806_NQueen_변지혜 {
	
	static int[] dr = new int[] {1, -1, 1, -1, -1, 1}; // 상-하-대각선우하-대각선좌상-대각선우상-대각선좌하 방향을 확인할 델타 배열
	static int[] dc = new int[] {0, 0, 1, -1, 1, -1};
	
	static int size, count;
	static boolean[][] board;
	
	private static void backtracking(int row, int col, int depth) {
		// 백트래킹으로 N개의 퀸이 서로를 공격하지 않고 위치할 수 있는지 확인하자
		// 마지막으로 위치시킨 퀸이 조건을 만족하는 지 확인하기 위해
		// 마지막 퀸의 좌표를 파라미터로 받아주자
		
		// 퀸을 위치시킬 수 있는 자리인지 조건 확인
		// 첫 번째 퀸은 아무데에나 놓을 수 있으니,
		// 두 번째 퀸부터 마지막 퀸까지는 현재 놓여진 위치에서 공격할 수 있는 퀸이 없는지 확인하자
		// 제일 마지막에 위치시킨 퀸에 대해서만 확인하면 된다!
		// 그 전 퀸에 대해서는 이미 그 전 재귀호출에서 확인이 완료됐기 때문에
		if (depth > 0 && depth <= size) {
			if(!check(row, col)) // 공격할 수 있는 퀸이 존재한다면
				return; // 해당 가지는 더 이상 확인하지 말자
		}
		
		// 기저 조건
		// 모든 퀸을 다 위치 시켰는데 위의 조건에서 return되지 않고 여기까지 내려왔다면,
		// 위치시킨 모든 퀸이 조건을 만족하는 경우이니,
		// 퀸을 위치시킬 수 있는 경우의 수를 1 증가시켜주자
		// 단말노드까지 왔으니 return하자
		if (depth == size) {
			count++;
			return;
		}
		
		// i번째 퀸을 i행의 N개의 칸에 위치시켜 보는 경우를 모두 확인해보자
		for (int idx = 0; idx < size; idx++) {
			board[depth][idx] = true; // 고른 칸에 위치시켜보자
			backtracking(depth, idx, depth + 1); // 다음 퀸을 위치시키러 가보자
			board[depth][idx] = false; // 다른 칸에 위치시켜보기 위해 현재 칸에 위치시킨 퀸을 제거하자
		}
	}
	
	private static boolean check(int row, int col) {
		// 마지막으로 위치시킨 퀸이 공격할 수 있는 다른 퀸이 있는 경우
		// 퀸을 위치시킬 수 있는 조건을 만족하지 않기 때문에 false를 반환하고,
		// 조건을 만족하는 경우 true를 반환하자
		
		// 초기 상태 : 조건을 만족한다고 가정하자
		
		for (int d = 0; d < 6; d++) { // 상-하-대각선우하-대각선좌상-대각선우상-대각선좌하 여섯 방향에 대해 확인해보자
			int dis = 0; // 확인할 방향으로 진행할 거리
			
			while (dis <= size) {
				dis++; // 다음 칸을 확인해보자
				
				int nr = row + dr[d] * dis; // 다음 칸의 좌표
				int nc = col + dc[d] * dis;
				
				// 체스판의 범위를 벗어나면 다른 방향을 확인해보자
				if (nr < 0 || nr >= size || nc < 0 || nc >= size) break;
				
				// 확인하던 방향에 공격할 수 있는 퀸이 존재한다면 false를 반환하자
				if (board[nr][nc]) return false;
			}
		}
		
		// 여기까지 내려왔다는 말은,
		// 네 방향에 대해 체스판 범위 내에서 모두 확인했는데 공격할 수 있는 퀸이 존재하지 않는다는 뜻이다
		// 그렇다면 퀸이 위치할 수 있는 조건을 만족하는 것이니 true를 반환하자
		return true;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기
		
		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복
			sb.append("#").append(tc).append(" ");
			
			size = sc.nextInt(); // 체스판의 크기, 퀸의 개수를 나타내는 N 입력받기
			
			count = 0; // N개의 퀸을 조건에 맞게 위치시킬 수 있는 경우의 수를 저장할 공간
			board = new boolean[size][size]; // N*N 크기의 체스판을 만들자
			
			backtracking(0, 0, 0); // N개의 퀸을 위치시켜보자
			
			// 백트래킹을 통해 퀸을 위치시킬 수 있는 경우는 모두 카운트 해줬으니,
			// 가능한 경우의 수를 저장해둔 count를 출력하자
			sb.append(count).append("\n");
		}
		
		System.out.println(sb); // 출력
	}

}
