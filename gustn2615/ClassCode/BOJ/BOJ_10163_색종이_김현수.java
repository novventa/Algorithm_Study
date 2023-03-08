package study_ssafy;

/*
 * 
 * 1. 색종이를 놓을 2차원 배열을 만든다
 * 2. 2차원 배열에 색종이의 번호를 적어 그 개수를 센다
 *    ex) 예를 들어 (0,0) 에서 너비가 2 높이가 2 인 색종이가 주어지면 그 범위내에 모든 배열의 값을
 *        색종이 번호로 바꾼다.
 * 3. 색종이 번호를 늘려가면서 평면을 채우기 때문에 나중에 들어온 색종이의 번호가 덮어 씌어질 수 있다.
 * 4. 결과값은 평면에서 각각의 색종이 번호를 찾아서 개수를 세어주면 된다.  
 * 
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution_10163_색종이_김현수 {
	public static void main(String[] args) throws IOException {

		// 버퍼리더 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 색종이 개수 받아오기
		int paperNum = Integer.parseInt(br.readLine());

		// 색종이를 넣을 평면 정의
		int[][] map = new int[1001][1001];

		// 평면에 색종이의 넓이 만큼 색종이 번호를 적어줄 것이다
		// 색종이 번호는 1번부터 시작한다.
		// 색종이 개수만큼 반복하면서
		for (int i = 1; i <= paperNum; i++) {

			// StringTokenizer를 통해 좌표와 너비 높이를 받아온다
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());

			// 색종이 범위만큼 돌면서
			for (int row = x; row < x + width; row++) {
				for (int col = y; col < y + height; col++) {
					// 평면에 색종이 번호로 채워준다
					map[row][col] = i;
				}
			}
		}
		br.close();

		// 반복문을 다돌았으면 색종이 범위만큼 돌면서
		for (int i = 1; i <= paperNum; i++) {
			int cnt = 0;
			for (int row = 0; row < 1001; row++) {
				for (int col = 0; col < 1001; col++) {

					// 색종이 번호에 따라 그 개수를 세주면 그게 넓이가 된다.
					if (map[row][col] == i) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}

	}
}
