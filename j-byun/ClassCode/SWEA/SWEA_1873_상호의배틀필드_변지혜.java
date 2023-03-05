import java.util.HashMap;
import java.util.Scanner;

// 1873 상호의 배틀필드
// D3

// 문제
// 배틀필드 게임 개발 -> 전차로 시가전
// 전차는 사용자의 전차 딱 하나 뿐
// 전차는 사용자의 입력에 따라 격자판 맵에서 다양한 동작을 한다

// 맵의 구성요소
// . 평지 (전차 진입 가능)
// * 벽돌로 만들어진 벽
// # 강철로 만들어진 벽
// - 물 (전차 진입 불가)
// ^ 위쪽을 바라보는 전차 (아래는 평지)
// v 아래쪽을 바라보는 전차 (아래는 평지)
// < 왼쪽을 바라보는 전차 (아래는 평지)
// > 오른쪽을 바라보는 전차 (아래는 평지)

// 사용자가 넣을 수 있는 입력의 종류
// U : up = 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 그 칸으로 이동
// D : down = 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동
// L : left = 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동
// R : right = 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동
// S : shoot = 전차가 현재 바라보고 있는 방향으로 포탄 발사

// 이동하려는 방향이 게임 맵 밖이면 이동하지 않음

// 포탄을 발사했을 때...
// 벽이 없으면 게임 맵 밖으로 나갈 때 까지 직진
// 벽돌 벽이면 그 벽 부셔서 평지만들고 stop
// 강철 벽이면 그대로 포탄 소멸

// 초기 게임 맵의 상태와 사용자가 넣을 입력이 순서대로 주어질 때, 모든 입력 처리 후 게임 맵 상태 출력하는 프로그램 작성

// 조건
// 전차는 하나만 있다
// 맵의 크기 H, W (2 ≤ H, W ≤ 20)
// 사용자가 넣을 입력의 개수를 나타내는 정수 N(0 < N ≤ 100)

// 풀이
// map 정보 입력받으면서 전차 (^ || v || < || >) 입력되면 좌표 저장하기

// 상하좌우 방향 델타배열 만들고
// hashmap에...
// 명령어를 key, 전차방향 표시 문자를 value로 저장하고
// 전차방향 표시 문자를 key, 델타배열 인덱스번호를 value로 저장해서
// 입력되는 명령어에 따라 전차방향을 바꾸고, 해당하는 델타배열 진행 방향을 가져온다

// UDLR이 입력되면 현재 전차 위치 + 델타배열인 칸이 평지면 전차 위치 변경시키고
// S이 입력되면 현재 전차위치의 델타방향으로 쭉 진행하며 벽 만나면 벽 부시고 멈추거나 소멸하기

public class SWEA_1873_상호의배틀필드_변지혜 {
	static int[] dr = new int[] {-1, 1, 0, 0}; // 상하좌우 순서
	static int[] dc = new int[] {0, 0, -1, 1}; // 상하좌우 순서
	static HashMap<Character, Character> command = new HashMap<Character, Character>() {{
		put('U', '^');
		put('D', 'v');
		put('L', '<');
		put('R', '>');
	}};
	static HashMap<Character, Integer> direction = new HashMap<Character, Integer>() {{
		put('^', 0);
		put('v', 1);
		put('<', 2);
		put('>', 3);
	}};
	
	static int rowSize;
	static int colSize;
	
	static char[][] map;
	
	static int curRow;
	static int curCol;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기
		
		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복 실행
			sb.append("#").append(tc).append(" "); // 출력양식
			
			rowSize = sc.nextInt(); // map의 row크기 입력받기
			colSize = sc.nextInt(); // map의 col크기 입력받기
			
			map = new char[rowSize][colSize]; // h*w 사이즈의 격자판 게임 맵 만들기
			
			curRow = 0; // 현재 전차 위치 좌표값 저장할 공간
			curCol = 0;
			
			for (int row = 0; row < rowSize; row++) { // 맵에 데이터 입력받기
				String line = sc.next();
				
				for (int col = 0; col < colSize; col++) {
					char cur = line.charAt(col);
					
					map[row][col] = cur;
					
					if (cur == '^' || cur == 'v' || cur == '<' || cur == '>') { // 전차 위치가 입력되면
						curRow = row; // 전차 위치 좌표값 저장하기
						curCol = col;
					}
				}
			} // 현재 map 정보 입력 끝
			
			
			int commandLength = sc.nextInt(); // 사용자가 입력할 명령어의 개수 입력받기
			String commandLine = sc.next(); // 명령어 문자열 입력받기
			
			for (int idx = 0; idx < commandLength; idx++) { // 명령어 개수만큼 반복해서 실행
				char c = commandLine.charAt(idx);
				
				play(c); // 게임 실행
			}
			
			// 게임이 끝났으면 업데이트 된 맵의 상태를 출력하자
			for (int row = 0; row < rowSize; row++) {
				for (int col = 0; col < colSize; col++) {
					sb.append(map[row][col]);
				}
				
				sb.append("\n");
			}
			
		}
		
		System.out.println(sb);
	}

	private static void play(char c) {
		
		if (c == 'S') { // 입력된 명령어가 S라면...
			char train = map[curRow][curCol]; // 현재 전차 상태
			int d = direction.get(train); // 진행할 방향 가져오기
			
			// 포탄 쏘기
			int cnt = 1;
			
			int nr = curRow + dr[d] * cnt;
			int nc = curCol + dc[d] * cnt;
			
			while (nr < rowSize && nr >= 0 && nc < colSize && nc >= 0) { // 진행할 방향이 map 범위에 있을 때 까지 반복
				
				if (map[nr][nc] == '*') { // 벽돌 벽을 만나면
					map[nr][nc] = '.'; // 벽을 부셔서 평지로 만들고
					break; // 포탄 소멸
					
				} else if (map[nr][nc] == '#') { // 강철 벽을 만나면
					break; // 그대로 포탄 소멸
				}
				
				// 벽을 만나지 않으면 해당 방향으로 계속 진행
				cnt++;
				nr = curRow + dr[d] * cnt;
				nc = curCol + dc[d] * cnt;
			}
			
			
		} else { // 입력된 명령어가 S가 아니라면
			char train = command.get(c); // 현재 전차 상태 바꾸기
			int d = direction.get(train); // 진행할 방향 가져오기
			
			map[curRow][curCol] = train; // 현재 위치의 전차 상태 바꿔주기
			
			curRow += dr[d]; // 전차가 바라보고 있는 방향으로 진행하기
			curCol += dc[d];
			
			if (curRow >= rowSize || curRow < 0 || curCol >= colSize || curCol < 0) { // map 범위를 벗어나면 전차의 좌표 원상복구
				curRow -= dr[d];
				curCol -= dc[d];
				
			} else if (map[curRow][curCol] == '.') { // 움직일 방향이 평지이면
				map[curRow][curCol] = train; // 전차를 해당 방향으로 움직이고
				map[curRow - dr[d]][curCol - dc[d]] = '.'; // 원래 전차가 있던 칸은 평지로 만들어주자
				
			} else { // 전차가 움직일 방향이 평지가 아니면
				curRow -= dr[d]; // 전차의 좌표 원상복구
				curCol -= dc[d];
			}
			
		}
		
	}

}
