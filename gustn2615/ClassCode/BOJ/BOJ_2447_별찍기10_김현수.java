package study_ssafy;

/*
 * 2차원 배열을 만들어 배열에 공백과 *를 넣고 나중에 출력하는 형식으로 문제를 푼다
 * 처음에 생각할때는 2차원 배열을 만들지 않고 바로 출력해보려고 했지만 배열을 만들지 않고 풀기는 불가능한 것 같다
 * 
 * 1. 주어진 크기에 맞는 2차원 배열을 만든다
 * 2. N=3일 때가 가장 작은 단위 이므로 재귀함수의 기저 조건을 N==3일 때로 만들어 준다
 * 3. N의 크기가 주어질때 N/3~ 2*N/3 까지는 공백으로 주어지므로 공백을 표시할 boolean을 넣어준다
 * 4. 조건에 맞게 2차원 배일을 공백 또는 *로 채워준다. 이때 공백 대신 '\u0000'으로 채우면 안된다
 * 5. '\u0000'는 얼핏 보면 출력은 맞지만 공백을 나타내는게 아니므로 출력결과물이 다르게 뜬다.
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solution_2447_별찍기10_김현수 {
	static int N;
	static char[][] map;

	public static void main(String[] args) throws IOException {

		// 버퍼리더 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 배열의 크기 받아오기
		N = Integer.parseInt(br.readLine().trim());

		// 2차원 배열 선언
		map = new char[N][N];

		// 스트링빌더 사용
		StringBuilder sb = new StringBuilder();

		// 재귀호출
		star(N, 0, 0, false);

		// 스트링 빌더에 더하기
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				sb.append(map[row][col]);
			}
			sb.append("\n");
		}

		// 출력
		System.out.println(sb);

	}

	// 재귀 메소드
	static void star(int N, int x, int y, boolean blank) {

		// 만약 공백이라면 공백으로 채워준다.
		if (blank) {

			// 공백이 시작되는 지점에서 N을 더한 범위만큼이 공백이 되면 된다.
			for (int row = x; row < N + x; row++) {
				for (int col = y; col < N + y; col++) {
					map[row][col] = ' ';
				}
			}

			return;
		}

		// N이 3이 되면 별을 그려준다
		if (N == 3) {
			for (int row = x; row < N + x; row++) {
				for (int col = y; col < N + y; col++) {
					if (row >= x + N / 3 && row < x + 2 * N / 3 && col >= y + N / 3 && col < y + 2 * N / 3) {
						map[row][col] = ' ';
					} else {
						map[row][col] = '*';
					}
				}
			}
			return;
		}

		// 그릴 별의 크기를 가로 세로 3등분한다
		int size = N / 3;

		// 총 9등분을 한 map의 시작 지점을 돌면서
		for (int row = x; row < x + N; row += size) {
			for (int col = y; col < y + N; col += size) {

				// 공백이라면 공백으로 메소드 호출
				if (row >= x + N / 3 && row < x + 2 * N / 3 && col >= y + N / 3 && col < y + 2 * N / 3) {
					star(N / 3, row, col, true);
				}
				// 공백이 아니라면 flase로 메소드를 호출한다
				else {
					star(N / 3, row, col, false);
				}
			}
		}
	}
}
