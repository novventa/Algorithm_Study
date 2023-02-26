import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2563 색종이
// 실버5

// 문제
// 100*100크기 정사각형 흰색 도화지
// 도화지 위에 10*10 검은 색종이를 삐뚤지않게 붙임
// => 색종이가 붙은 검은 영역의 넓이를 구하시오

// 풀이
// 100*100 boolean 배열 만들어서
//	=> 인덱스 신경쓰기 귀찮으니까 101*101로 만들고 row == 0 || col == 0 일 때 무시하기
// false = white, true = black
// 색종이 붙이려는 칸이 false일 때만 true로 바꾸고
// 이미 true일 때는 고려하지 않기
//	=> 배열 돌면서 true 갯수 세기

// 도화지 위아래 뒤집힌다고 색종이 붙이는 영역 바뀌는거 아니니까
// 색종이 위치 입력값 그대로 좌표값으로 활용하기
//	=> 입력되는 row는 end row이지만, 
//		얘를 start row로 활용해도 도화지 위아래 뒤집으면 똑같으니까 상관없다
//		도화지, 색종이 다 정사각형이니까!

public class BOJ_2563_색종이_변지혜 {

	static boolean[][] paper = new boolean[101][101]; // 도화지 공간
	static int blackArea = 0; // 검은 색종이 면적 저장할 공간

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

		blackOnPaperCnt(); // 도화지에 붙은 검은색 색종이 영역 구하기

		sb.append(blackArea);
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

	private static void blackOnPaperCnt() { // 도화지에 붙은 검은색 색종이 영역을 구하는 method

		for (int row = 1; row < 101; row++) { // 도화지의 모든 영역을 확인하면서
			for (int col = 1; col < 101; col++) {
				if (paper[row][col]) { // 1*1 영역이 true(검은색)이면
					blackArea++; // 검은색 영역++
				}
			}
		}

	}

}
