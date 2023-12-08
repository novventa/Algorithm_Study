package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12865 {
    static int[][] ls;
    static int[][] dp;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ls = new int[n][2];
        dp = new int[n][101010];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ls[i][0] = Integer.parseInt(st.nextToken());
            ls[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 101010; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(recur(0, 0));
    }

    public static int recur(int cur, int w) {
        if (w > m) {
            return -1231231233;
        }
        if (cur == n) {
            return 0;
        }
        if (dp[cur][w] != -1) {
            return dp[cur][w];
        }
        dp[cur][w] = Math.max(recur(cur + 1, w + ls[cur][0]) + ls[cur][1], recur(cur + 1, w));
        return dp[cur][w];
    }
}