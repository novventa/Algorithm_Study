package study_ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class solution_2810_컵홀더_김현수 {
	public static void main(String[] args) throws IOException {
		// stack 사용
		Stack<Character> stack = new Stack<>();
		// 버퍼리더로 변수 읽어오기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 사람 수 받아오기
		int personNum = Integer.parseInt(br.readLine());
		// 좌석 받아오기
		char[] sheet = br.readLine().toCharArray();
		// 처음 한번은 컵홀더를 더한다
		stack.add('*');
		// L이 두번 나오면 컵홀더를 더할 변수
		int count = 0;
		// 사람 수만큼 반복하면서
		for (int i = 0; i < personNum; i++) {
			// S이면 컵홀더를 더하고
			if (sheet[i] == 'S') {
				stack.add('*');
			}
			// 커플석이 두개이면 컵홀더를 더한다.
			else if (sheet[i] == 'L') {
				count++;
				if (count % 2 == 0) {
					stack.add('*');
				}
			}
		}
		// 버퍼리더 종료
		br.close();

		// 답을 출력한다
		// 답이 사람수보다 크면 사람수를 출력한다.
		int answer = stack.size();
		if (answer > personNum) {
			answer = personNum;
		}
		System.out.println(answer);
	}
}
