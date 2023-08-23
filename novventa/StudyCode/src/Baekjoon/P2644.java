package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2644 {
    static int N, M, X, Y;
    static int[][] map;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        distance = new int[N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            map[v1][v2] = map[v2][v1] = 1;
        }

        dfs(X);

        System.out.println(distance[Y] == 0 ? -1 : distance[Y]);
    }

    private static void dfs(int X) {
        if(X == Y)
            return;

        for(int i=1;i<=N;i++){
            if(map[X][i] == 1 && distance[i] == 0){
                distance[i] = distance[X] + 1;
                dfs(i);
            }
        }
    }
}
