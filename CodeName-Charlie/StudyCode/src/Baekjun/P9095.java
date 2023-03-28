
// 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
// 1+1+1+1
// 1+1+2
// 1+2+1
// 2+1+1
// 2+2
// 1+3
// 3+1
// 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

package Baekjun;

// 점화식을 활용해 풀어보자.

import java.util.Scanner;

public class P9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트 케이스의 수를 입력 받는다.
		
		for(int tc = 0; tc < T; tc++) {
			int n = sc.nextInt(); // 정수 n을 입력 받는다.
			
			int[] dp = new int[11]; // n은 11보다 작은 양수이기 때문에, dp 배열의 크기를 11로 초기화 한다.
			dp[1] = 1; // 1
			dp[2] = 2; // 1+1, 2
			dp[3] = 4; // 1+1+1, 1+2, 2+1, 3
			
			for (int i = 4; i < 11; i++) { // 반복문을 통해, 나머지 배열의 요소값을 채워준다.
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
			System.out.println(dp[n]); // 값을 출력한다.
		}
	}
}