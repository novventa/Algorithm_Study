package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2775 {
	public static void main(String[] args) throws IOException {
		// 버퍼 리더를 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 횟수 받아오기
		int T = Integer.parseInt(br.readLine());
		// 테스트 케이스 만큼 반복
		for (int tc = 1; tc <= T; tc++) {
			// 층수와 호수를 받아온다
			int floor = Integer.parseInt(br.readLine());
			int line = Integer.parseInt(br.readLine());

			// 호수가 14호수 까지 있으므로 index를 호수로 보기위해
			// 배열 사이즈를 15로 지정한다
			// 이 배열에 층에 사는 사람 수를 넣을 것이다.
			int[] nums = new int[15];

			// 0층에 사는 사람 수 저장
			for (int index = 0; index < 15; index++) {
				nums[index] = index;
			}

			// 층이 올라갈 수록 누적합을 구해주면 line과 같은 index를
			// 가지는 배열 값이 floor층과 line호수에 사는 사람 수이다.
			// 즉 몇층인지에 따라 계속 해서 누적합을 구해주면 된다.
			// 층수가 없어질때 까지 반복
			while (floor > 0) {
				for (int index = 1; index < 15; index++) {
					nums[index] += nums[index - 1];
				}
				// 누적합을 구해서 배열에 넣고 층수를 하나 줄인다.
				floor--;
			}
			// 사람 수를 출력한다.
			System.out.println(nums[line]);
		}
	}
}
