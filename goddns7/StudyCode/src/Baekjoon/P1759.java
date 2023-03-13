package day0313;

import java.util.Arrays;
import java.util.Scanner;

public class P1759 {
	// 사용하는 문자의 개수
	static int useCnt;
	// 사용할 수 있는 문자의 개수
	static int canuseCnt;
	// 사용할 수 있는 문자들이 담긴 배열
	static String[] canUse;

	// 탐색과정에서 담게되는 배열
	static String[] output;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 사용하는 문자의 개수
		useCnt = sc.nextInt();
		// 사용할 수 있는 문자의 개수
		canuseCnt = sc.nextInt();
		// 사용할 수 있는 문자들이 담긴 배열
		canUse = new String[canuseCnt];

		for (int i = 0; i < canuseCnt; i++) {
			canUse[i] = sc.next();
		}

		// canUse배열을 오름차순으로 배열(사전순)
		Arrays.sort(canUse);

		// 탐색과정에서 담게되는 배열
		output = new String[useCnt];

		// 0, 0부터 백트래킹 시작
		backTracking(0, 0);

		sc.close();
	}

	public static void backTracking(int depth, int start) {

		// 조건1: 재귀 깊이가 useCnt와 같아지면
		if (depth == useCnt) {
			// 조건2: 최소 1개 모음, 최소 2개 자음 구성되어 있는지
			// 위의 조건을 만족한다면
			if (consist()) {
				// 탐색과정에서 담았던 배열 출력
				for (int i = 0; i < useCnt; i++) {
					System.out.print(output[i]);
				}
				System.out.println();
			}

			return;
		}

		// visited배열은 필요 없다
		// -> 오름차순이므로 다음 재귀함수 때,
		// for문을 시작하는 인덱스의 값을 하나씩 증가시켜
		// 사용한 것의 다음 인덱스부터 시작하면 되기 때문
		for (int i = start; i < canuseCnt; i++) {
			output[depth] = canUse[i];
			backTracking(depth + 1, i + 1);
		}
	}

	private static boolean consist() {
		// 모음 사용 횟수
		int vow = 0;
		// 자음 사용 횟수
		int cons = 0;
		// 출력하려는 배열에서 모음과 자음의 사용 횟수를 센다
		for (int i = 0; i < useCnt; i++) {
			if (output[i].equals("a") || output[i].equals("e") || output[i].equals("i") || output[i].equals("o")
					|| output[i].equals("u")) {
				vow++;
			} else {
				cons++;
			}
		}

		// 모음을 1번이상 사용하고 자음을 2번이상 사용했을 경우에는
		if (cons >= 2 && vow >= 1) {
			// true
			return true;
			// 반대의 경우
		} else {
			// false
			return false;
		}
	}

}
