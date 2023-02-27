
// 극장의 한 줄에는 자리가 N개가 있다.
// 서로 인접한 좌석 사이에는 컵홀더가 하나씩 있고, 양 끝 좌석에는 컵홀더가 하나씩 더 있다.
// 또, 이 극장에는 커플석이 있다. 커플석 사이에는 컵홀더가 없다.
// 극장의 한 줄의 정보가 주어진다. 이때, 이 줄에 사람들이 모두 앉았을 때, 컵홀더에 컵을 꽂을 수 있는 최대 사람의 수를 구하는 프로그램을 작성하시오.
// 모든 사람은 컵을 한 개만 들고 있고, 자신의 좌석의 양 옆에 있는 컵홀더에만 컵을 꽂을 수 있다.
// S는 일반 좌석, L은 커플석을 의미하며, L은 항상 두개씩 쌍으로 주어진다.

package Baekjun;

// 변수 N과, 자리의 정보를 나타내는 문자열을 입력 받자.
// 문자열을 각각의 문자로 나눠 배열에 저장하자.
// 배열을 탐색해 커플석의 수를 알아내자.
// 기본좌석과 커플석의 개수를 바탕으로 컵홀더의 개수를 도출하자.
// 답을 출력하자.


import java.util.Scanner;

public class P2810 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 자리의 개수를 의미하는 변수 N을 입력 받는다.
		String data = sc.next(); // 좌석의 정보를 나타내는 문자열 data를 입력 받는다.
		
		int cnt = 0; // 커플석의 개수를 셀 변수 cnt를 선언하고 0으로 초기화한다.
		char[] seat = data.toCharArray(); // 입력 받은 좌석의 정보를 toCharArray 메서드를 사용해 문자로 나누고 각각의 문자를 배열로 저장한다.
		
		for(int idx = 0; idx < N; idx ++) { // for문을 사용해
			if(seat[idx] == 'L') { // seat 배열을 탐색해 커플석을 찾아내고,
				cnt++; // 커플석인 경우 cnt를 1 증가시킨다.
			}
		}
		
		int result = N + 1 - (cnt/2);
		// 컵홀더의 개수를 나타내는 결과값은 N(자리의 개수) + 1(양쪽 끝에 컵홀더 존재) - (cnt(커플석의 수) / 2)(커플석 사이에는 컵홀더 없음)으로 나타낼 수 있다.
		if (N > result) { // 만약 N보다 result가 작으면,
			System.out.println(result); // result를 출력하고,
		}
		else System.out.println(N); // 아니라면, N을 출력한다. (컵홀더에 컵을 꽂을 수 있는 사람 수를 물어보는 것이기 때문.)
	}
}
