package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15654 {
    static int[] nums;
    static int[] arr;
    static boolean[] visited;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        arr = new int[N];

        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        dfs(0);

        System.out.println(sb.toString());
    }

    private static void dfs(int idx){
        if(idx==M){
            for(int i=0;i<M;i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                arr[idx] = nums[i];
                dfs(idx+1);
                visited[i] = false;
            }
        }

    }
}
