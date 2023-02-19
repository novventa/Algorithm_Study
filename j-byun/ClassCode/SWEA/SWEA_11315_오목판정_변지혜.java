package test;

import java.util.Scanner;

// SWEA
// 11315 오목 판정
// D3

// 문제
// n*n 크기의 판
// 판의 각 칸에는 돌이 있거나 없음
// 돌이 가로, 세로, 대각선 중 하나의 방향으로 다섯 개 이상 연속한 부분이 있는지 없는지 판정

// 풀이
// 가로는 오른쪽으로만 진행,
// 	세로는 아래로만 진행,
// 		대각선은 양쪽 아래로 진행하는 델타 배열을 만들어서
// 돌이 있는 칸을 발견하면 
// 	for문을 돌리면서 확인
//		=> 돌이 있는 칸 카운트가 5가 되면
//			yes 출력
//		=> 5가 되기 전에 끝나면
//			카운트 리셋하고 다음 칸 확인 시작

public class SWEA_11315_오목판정_변지혜 {
	
	// 오른쪽, 아래쪽, 오른쪽아래 대각선, 왼쪽 아래 대각선 방향을 확인할 델타배열 만들기
	static int[] deltaRow = {0, 1, 1, 1};
	static int[] deltaCol = {1, 0, 1, -1};
	
//	static final int RIGHT = 0;
//	static final int DOWN = 1;
//	static final int RIGHT_DIAGONAL = 2;
//	static final int LEFT_DIAGONAL = 3;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		// 입력 줄이 띄어쓰기로 구분되어 있지 않으니까...
		//	한 줄 단위로 입력 받아서 짤라 넣기 위해
		//		한 줄을 입력받을 string read 만들어주기
		String read;
		
		// 테스트케이스의 수 t 입력받기
		int t = sc.nextInt();
		
		// 테케 개수만큼 반복
		for (int testCase = 1; testCase <= t; testCase++) {
			
			// 판의 가로, 세로 길이 n을 변수 mapSize로 입력받기
			int mapSize = sc.nextInt();
			
			// n*n 크기의 2차원배열 map만들어주기
			char[][] map = new char[mapSize][mapSize];
			
			
			// 연속으로 돌이 있는 칸 5개가 확인되면 yes를 출력할 문자열 isFive 만들기
			String isFive = "NO";
			
			// 연속으로 돌이 있는 칸 개수를 저장할 변수 stoneCnt 만들기
			int stoneCnt = 0;
			
			// map 정보 입력받기
			for (int row = 0; row < mapSize; row++) {
				// 한 줄 씩 읽어서
				read = sc.next();
				
				for (int col = 0; col < mapSize; col++) {
					// 차례대로 map에 넣어주기
					map[row][col] = read.charAt(col);
				}
			}
			
			// 델타배열로 확인할 다음 칸의 좌표값을 저장할 변수 만들기
			int newRow;
			int newCol;
			
			// map의 모든 칸을 확인하면서...
			outer : for (int row = 0; row < mapSize; row++) {
				for (int col = 0; col < mapSize; col++) {
					// 각 칸에서 시작할 때 스톤카운트 0으로 리셋
					stoneCnt = 0;
					
					// 만약 지금 칸에 돌이 있다면
					if (map[row][col] == 'o') {
						
						// 델타배열 확인
						// 가로, 세로, 대각선*2 네 방향에 대해
						for (int direction = 0; direction < 4; direction++) {
							// 모든 방향에 대해 확인을 시작할 때 stoneCnt 를 1로 초기화
							stoneCnt = 1;
							
							// 현재 스톤 카운트가 1 이니까 4칸만 더 확인한다
							for (int idxCnt = 1; idxCnt <= 4; idxCnt++) {
								newRow = row + idxCnt * deltaRow[direction];
								newCol = col + idxCnt * deltaCol[direction];
								
								
								// 다음 칸에도 돌이 있다면 스톤 카운트++ 하고
								if (newRow < mapSize && newCol < mapSize && newCol >= 0 && map[newRow][newCol] == 'o') {
									stoneCnt++;
									
									// ++한 스톤 카운트가 5가 됐다면 이미 오목이 완성돼서 더 이상 확인 할 필요가 없다
									if (stoneCnt == 5) {
										// 그렇다면 isFive를 yes로 바꿔주고
										isFive = "YES";
										
										// 다른 칸은 더 이상 확인하지 않고 끝내버린다
										break outer;
										}
								} else {
									// 다음 칸에 돌이 없다면
									// 현재 방향으로는 오목이 불가능하니까
									// 다른 방향을 탐색하러 간다
									break;
								}
							}
						}
					}
				}
			}
			// 1. for문을 벗어나는 경우 1번
			// 5개의 돌이 연속으로 나열된 경우가 있으면
			// stoneCnt가 5가 됐을 때 isFive = YES가 되고 break outer를 통해 for문을 벗어남
			
			// 2. for문을 벗어나는 경우 2번
			// 모든 칸, 모든 방향에 대해 다 확인 했는데
			// 연속된 돌이 5개 미만인 경우
			// isFive = NO 인 상태로 모든 칸의 확인이 끝나 for문을 벗어나게 된다
			
			// 출력 양식
			sb.append("#").append(testCase).append(" ").append(isFive).append("\n");
		}
		
		// 출력
		System.out.println(sb);
		
	}
}


