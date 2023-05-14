package Baekjoon;

import java.util.Scanner;

public class P2193 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        // N이 매우 클 경우 int 배열에 저장하지 못할 수도 있으므로
        // long 배열로 선언한다
        long[] dp = new long[N+1];

        // 값 초기화
        dp[0] = 0;
        dp[1] = 1;

        // n번째 자리에 0이 오는 경우
        // n-1번째 자리에 0, 1 아무거나 가능, dp[n-1]만큼 더한다
        // n번쨰 자리에 1이 오는 경우
        // n-1번째 자리에 무조건 0이 와야 한다, dp[n-1]에 dp[n-2]를 더한다.
        for(int i=2; i<=N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[N]);
    }
}
