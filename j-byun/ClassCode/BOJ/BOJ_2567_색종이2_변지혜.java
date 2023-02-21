import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2567 색종이 - 2
// 실버4

// 문제
// 100*100크기 정사각형 흰색 도화지
// 도화지 위에 10*10 검은 색종이를 삐뚤지않게 붙임
// => 색종이가 붙은 검은 영역의 둘레의 길이를 구하시오

// 풀이
// 색종이 1 가져와서 붙이고
// 델타배열 상하좌우 만들어서
// 확인한 방향이 하얀색(false)거나 <= 0(배열인덱스 1부터 가져다 썼으니까) || >= 101 일 때 마다 둘레++

public class BOJ_2567_색종이2_변지혜 {

	static boolean[][] paper = new boolean[101][101]; // 도화지 공간
	static int blackRoundLength = 0; // 검은 색종이 둘레 저장할 공간

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int confettiCnt = Integer.parseInt(br.readLine()); // 색종이 개수 입력받기

		for (int cnt = 1; cnt <= confettiCnt; cnt++) { // 색종이 개수만큼 반복

			StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄 읽어와서 띄어쓰기 단위로 끊기

			int blackCol = Integer.parseInt(st.nextToken()); // 검은색 색종이의 시작 col 입력받기
			int blackRow = Integer.parseInt(st.nextToken()); // 검은색 색종이의 끝 row 입력받기

			confettiOnPaper(blackRow, blackCol); // 도화지에 검은색 색종이 붙이기
		}

		blackRoundOnPaperCnt(); // 도화지에 붙은 검은색 색종이 영역 구하기

		sb.append(blackRoundLength);
		System.out.println(sb); // 출력

	}

	private static void confettiOnPaper(int blackRow, int blackCol) { // 도화지에 검은색 색종이를 붙이는 method

		for (int row = blackRow; row < blackRow + 10; row++) { // 입력된 row,col 기준으로 +10만큼씩 영역에 검은색 색종이 붙이기
			for (int col = blackCol; col < blackCol + 10; col++) {

				if (!paper[row][col]) { // 1*1 영역의 현재 칸이 하얀색 도화지 일 때만
					paper[row][col] = true; // 검은색 색종이를 붙여준다
				}
			}
		}

	}

	private static void blackRoundOnPaperCnt() { // 도화지에 붙은 검은색 색종이 둘레를 구하는 method

		int[] dr = new int[] { -1, 1, 0, 0 }; // 상하좌우 방향 확인할 델타배열
		int[] dc = new int[] { 0, 0, -1, 1 };

		for (int row = 1; row < 101; row++) { // 도화지의 모든 영역을 확인하면서
			for (int col = 1; col < 101; col++) {

				if (paper[row][col]) { // 1*1 영역이 true(검은색)이면

					for (int direction = 0; direction < 4; direction++) { // 상하좌우 확인
						int nr = row + dr[direction];
						int nc = col + dc[direction];

						if (nr <= 0 || nr >= 101 || nc <= 0 || nc >= 101) { // 색종이 범위를 벗어날 경우
							blackRoundLength++; // 둘레++
							continue;
						}

						if (!paper[nr][nc]) { // 검은색 색종이와 하얀색 도화지의 경계인 경우
							blackRoundLength++; // 둘레++
						}
					}
				}
			}
		}

	}

}
