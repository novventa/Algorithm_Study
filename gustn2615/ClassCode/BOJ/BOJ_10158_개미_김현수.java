package study_ssafy;

/*
 * 규칙을 찾아서 해결
 * while문으로는 해결했으나 시간초과가 떠서 규칙을 찾아서 해결했습니다
 * 혼자 찾은 규칙으로는 정답이 찾아지지않아서
 * 구글링의 도움을 받았습니다
 * 점 P가 움직일때 2*row 시간만큼 움직이면 제자리에 돌아오는 규칙을 사용하였습니다
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution_10158_개미_김현수_다시 {
	public static void main(String[] args) throws IOException {

		// 시간 초과를 줄이기 위해 버퍼 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// StringTokenizer로 읽어오기
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 격자의 최대 x좌표 y좌표
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		// 처음 주어지는 x y 좌표
		int startX = Integer.parseInt(st.nextToken());
		int startY = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		// 움직인 시간 받아오기
		int time = Integer.parseInt(st.nextToken());

		// 버퍼리더 사용종료
		br.close();

		// 2*row, 2*col 만큼 가면 다시 제자리로 돌아오므로
		// 처음위치에서 time만큼 흘렀을때 이 time을 2*row로 나눈
		// 나머지가 개미가 이동한 거리이다.
		startX += time % (2 * row);
		startY += time % (2 * col);

		// 좌표가 row 범위를 넘어가면
		// 2*row에서 startX좌표를 빼주면 좌표가 나온다
		// 이때 startX가 2*row 범위를 벗어나면 음수가 될수 있으므로
		// 절대값을 취해줘야한다.
		if (startX > row) {
			startX = Math.abs(2 * row - startX);
		}
		if (startY > col) {
			startY = Math.abs(2 * col - startY);
		}

		// 출력한다.
		System.out.printf("%d %d", startX, startY);

	}
}
