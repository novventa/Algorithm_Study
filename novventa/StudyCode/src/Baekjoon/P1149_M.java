package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1149_M {
    static int[][] cost;
    static Integer[][] dp;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        cost = new int[N+1][3];
        dp = new Integer[N+1][3];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<3; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(Math.min(Math.min(paint_cost(N, 0), paint_cost(N, 1)), paint_cost(N, 2)));
    }

    static int paint_cost(int n, int color) {
        if(dp[n][color] == null) {
            if(n == 1) {
                dp[n][color] = cost[n][color];
            } else if(color == 0) { // 현재 집을 빨간색으로 칠하는 경우
                dp[n][color] = Math.min(paint_cost(n-1, 1), paint_cost(n-1, 2)) + cost[n][color];
            } else if(color == 1) { // 현재 집을 초록색으로 칠하는 경우
                dp[n][color] = Math.min(paint_cost(n-1, 0), paint_cost(n-1, 2)) + cost[n][color];
            } else { // 현재 집을 파란색으로 칠하는 경우
                dp[n][color] = Math.min(paint_cost(n-1, 0), paint_cost(n-1, 1)) + cost[n][color];
            }
        }

        return dp[n][color];
    }
}
