package study_ssafy2;

/*
 * 재귀를 활용해서 문제를 풀어본다.
 * 1. 잘라진 색종이의 범위 내에서 모두 같은 색인지 확인하는 메소드를 만든다.
 * 2. 색종이가 시작하는 모든 위치에 대해서 재귀메소드를 실행한다.
 * 3. 답을 출력한다.
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630_색종이만들기_김현수 {
	static int N, whiteCount, blueCount;
	static int[][] map;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine().trim());

		map = new int[N][N];

		// 색종이를 받아온다
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int col = 0; col < N; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		// 같은색인지 확인하는 메소드
		isPossible(0, 0, N);

		// 정답출력
		System.out.println(whiteCount);
		System.out.println(blueCount);
	}

	// 같은색인지 확인한다
	static void isPossible(int startRow, int startCol, int mapSize) {
		
		// 색종이 시작지점의 색을 확인후
		int tmp = map[startRow][startCol];

		// 전체를 돌면서
		for (int row = startRow; row < startRow + mapSize; row++) {
			for (int col = startCol; col < startCol + mapSize; col++) {
				
				// 만약 시작지점의 색과 다르다면
				if (map[row][col] != tmp) {
					
					// 색종이를 4개로 나누어 확인한다.
					isPossible(startRow, startCol, mapSize / 2);
					isPossible(startRow, startCol + mapSize / 2, mapSize / 2);
					isPossible(startRow + mapSize / 2, startCol, mapSize / 2);
					isPossible(startRow + mapSize / 2, startCol + mapSize / 2, mapSize / 2);
					
					// 확인했다면 메소드를 종료한다
					return;
				}
			}
		}

		// 모두 같은색이라면 각각 개수를 세어준다.
		if (tmp == 1) {
			blueCount++;
		} else {
			whiteCount++;
		}

	}

}
