package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15593 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] time = new int[1001];
        int[][] arr = new int[n][2];
        int total = 0;
        for(int i=0; i<n; ++i) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            for(int j=arr[i][0]; j<arr[i][1]; ++j) {
                if(time[j] == 0) {
                    ++total;
                }
                ++time[j];
            }
        }
        int cnt = Integer.MAX_VALUE;
        for(int i=0; i<n; ++i) {
            int c = 0;
            for(int j=arr[i][0]; j<arr[i][1]; ++j) {
                if(time[j]<=1) {
                    ++c;
                }
            }
            cnt = Math.min(cnt, c);
        }

        System.out.println(total - cnt + "");
    }
}
