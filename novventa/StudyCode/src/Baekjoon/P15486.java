package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15486 {
    static int N;
    static int[] T, P, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        T = new int[N+1];
        P = new int[N+1];
        dp = new int[N+6];  // 상담 일수가 최대 50일까지 가능하므로

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=N; i>0; i--){
            if(i + T[i] <= N + 1)
                dp[i] = Math.max(P[i] + dp[i + T[i]], dp[i+1]);
            else
                dp[i] = dp[i+1];
        }

        System.out.println(dp[1]);
    }
}

