package Baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2630 {

	static int N;

	static int[][] arr;

	static int blueCnt;

	static int whiteCnt;

	static boolean check;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N 입력 받기
		N = Integer.parseInt(br.readLine());

		// 배열 크기 정하기
		arr = new int[N][N];

		// 색종이의 갯수 0으로 초기화
		blueCnt = whiteCnt = 0;

		// 배열에 값 입력
		for (int row = 0; row < N; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int col = 0; col < N; col++) {
				arr[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		conquer(0, 0, N);
		System.out.println(whiteCnt);
		System.out.println(blueCnt);

	}

	private static void conquer(int r, int c, int size) {

		// 모두 같은지 확인
		same(r, c, size);
		// check를 확인
		// true면 모두 같은 색
		if (check) {
			// 기준으로 설정한 값이 1이면
			if (arr[r][c] == 1) {
				// blueCnt늘리기
				blueCnt++;
			}
			// 아니면 whiteCnt 늘리기
			else {
				whiteCnt++;
			}
		}
		// 다른색이 발견됐으면
		else {
			// size를 2로 나누자
			size /= 2;
			// 4등분을 해야한다
			// 0,0부터 시작하므로, 0~size/2까지 => 2사분면
			conquer(r, c, size);
			// 1사분면
			conquer(r, c + size, size);
			// 3사분면
			conquer(r + size, c, size);
			// 4사분면
			conquer(r + size, c + size, size);
		}

	}

	// 사각형이 모두 같은 색인지 알아보자.
	private static void same(int r, int c, int size) {
		// 모두 같다고 설정
		check = true;
		// 첫번째 값을 기준
		int standard = arr[r][c];

		// 배열을 돌면서 다른 값이 나오면 check를 false로 바꾸고 break
		outer: for (int row = r; row < r + size; row++) {
			for (int col = c; col < c + size; col++) {
				if (arr[row][col] != standard) {
					check = false;
					break outer;
				}
			}
		}
	}

}
