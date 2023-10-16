package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15650 {
    static int N,M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(1,0);

    }

    private static void dfs(int idx, int depth) {
        if(depth==M){
            for(int num : arr){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i=idx;i<=N;i++){
            arr[depth] = i;
            dfs(i+1,depth+1);
        }

    }
}
