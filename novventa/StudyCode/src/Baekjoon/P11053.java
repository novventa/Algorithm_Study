package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11053  {
    static int N;
    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            LIS(i);
        }

        int max = dp[0];
        for(int i=1; i<N; i++){
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    static int LIS(int N) {
        if(dp[N] == null) {
            dp[N] = 1;

            for(int i=N-1; i>=0; i--){
                if(arr[i] < arr[N]) {
                    dp[N] = Math.max(dp[N], LIS(i) + 1);
                }
            }
        }

        return dp[N];
    }
}
