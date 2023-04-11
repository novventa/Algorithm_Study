package study_ssafy;

/*
 * 델타배열을 사용해서 2차원 배열을 채워나간다
 * 시간 초과를 고려해서 버퍼와 스트링 빌더를 쓴다
 * 
 * 1. 달팽이의 경우 벽을 만나거나 방문했던 곳이면 반시계방향으로 꺽어야한다
 * 2. 따라서 시작지점에서 아래방향으로 나아가면서 벽이나 방문했던 곳을 만나면 방향을 꺽어준다.
 * 3. 이후 출력한다
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solution_1913_달팽이_김현수 {
	static int N;
	static int findNum;
	static int num;
	static boolean[][] visted;
	static int[][] map;

	// 방향을 나타내는 델타배열 하우상좌
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		// 버퍼리더 스트링빌더 정의
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 달팽이의 크기 받아오기
		N = Integer.parseInt(br.readLine().trim());

		// 찾아야할 숫자를 받아온다
		findNum = Integer.parseInt(br.readLine().trim());

		// 버퍼리더 사용 종료
		br.close();

		// 처음 채워지는 숫자를 저장한다
		num = N * N;

		// 달팽이 배열 선언
		map = new int[N][N];

		// 논리형 배열 선언
		visted = new boolean[N][N];

		// 찾아야할 숫자의 좌표를 저장할 변수
		int answerRow = 0;
		int answerCol = 0;

		// 시작지점을 저장할 변수
		int nr = 0;
		int nc = 0;

		// 시작지점에 숫자 채우기
		map[nr][nc] = num--;

		// 방문했다고 표시
		visted[nr][nc] = true;

		// 처음 시작 방향 정의
		int direction = 0;

		// 숫자가 0보다 클때까지 반복
		while (num > 0) {

			// 한칸 진행하고
			nr += dr[direction];
			nc += dc[direction];

			// 그칸이 막다른 길이거나 방문했던 곳이면
			if (nr == -1 || nr == N || nc == -1 || nc == N || visted[nr][nc]) {

				// 이전 좌표로 돌아가고
				nr -= dr[direction];
				nc -= dc[direction];

				// 방향을 바꾸고
				direction = (direction + 1) % 4;

				// 다음 좌표로 진행한다
				continue;
			}

			// 현재 위치에 숫자를 채우고
			map[nr][nc] = num--;

			// 방문했다고 표시
			visted[nr][nc] = true;

			// 만약 찾는 숫자라면 좌표 저장
			if (map[nr][nc] == findNum) {
				answerRow = nr;
				answerCol = nc;
			}

		}

		// 출력값 받아오기
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				sb.append(map[row][col]).append(" ");
			}
			sb.append("\n");
		}
		sb.append(answerRow + 1).append(" ").append(answerCol + 1);

		// 출력하기
		System.out.println(sb);
	}
}
