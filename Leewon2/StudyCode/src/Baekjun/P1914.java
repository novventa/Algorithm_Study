/* 문제
 * 세 개의 장대가 있고, 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여있다.
 * 각 원판은 반경이 큰 순서대로 쌓여있고, 다음 규칙에 따라 세 번째 장대로 옮기려고 한다.
 * 1. 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
 * 2. 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
 * 이 작업을 수행하는데 필요한 최소 이동 횟수를 출력해보자.
 * 
 * 
 * 
 * 조건
 * 장대에 쌓인 원판의 갯수 N은 1 이상 100 이하다.
 * N이 20 이하인 경우에는 두 번째 줄 부터 수행 과정을 출력한다.
 * 수행 과정 A B를 출력하는데, A번째 탑의 가장 위에 있는 원판을 B번째 탑의 가장 위로 옮긴다는 뜻이다.
 * 
 */

package Baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P1914 {

	static int N;

	static int cnt;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		// result에 1값을 저장한다.
		BigInteger result = new BigInteger("1");

		// N이 20보다 큰 경우는 재귀함수가 매우 많이 호출되므로 규칙을 찾아 해결한다.
		// N이 100인 경우 결과값은 1267650600228229401496703205375 이므로, BigInteger를 사용해야 한다.
		if (N > 20) {
			for (int i = 0; i < N; i++) {
				// 하노이 탑의 결과값은 2^n-1이므로, N까지 2를 곱한 후 1을 빼준다.
				result = result.multiply(new BigInteger("2"));
			}
			result = result.subtract(new BigInteger("1"));
			System.out.println(result);

		}
		// 20 이하인 경우는 결과값과 수행과정을 출력해야 한다.
		else {
			// 재귀호출을 하고
			hanoi(N, 1, 3, 2);

			// 결과값을 출력하고
			System.out.println(cnt);

			// StringBuilder에 저장된 수행과정을 출력해보자.
			System.out.println(sb);

		}

	}

	// 기둥이 3개이므로, 3개의 파라미터를 받아보자.
	// from은 시작점, to는 도착점, other은 나머지 기둥이다.
	public static void hanoi(int num, int from, int to, int other) {
		// 재귀조건
		// num이 0이 되면 return 하자.
		if (num == 0) {
			return;
		}

		hanoi(num - 1, from, other, to);
		// 한번 움직이고 cnt를 하나 늘려준다.
		cnt++;

		// N이 20 이하인 경우는 StringBuilder에 수행 과정을 저장하자.
		if (N <= 20) {
			sb.append(from).append(" ").append(to).append("\n");
		}

		hanoi(num - 1, other, to, from);

	}
}
