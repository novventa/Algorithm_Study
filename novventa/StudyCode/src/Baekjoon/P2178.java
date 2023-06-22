package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2178 {

    static int N,M;
    static int[][] map;
    static  boolean[][] visited;
    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int r=0;r<N;r++){
            String str = sc.next();
            for(int c=0;c<M;c++){
                map[r][c] = str.charAt(c)-'0';
            }
        }

        visited[0][0] = true;
        bfs(0,0);

        System.out.println(map[N-1][M-1]);

    }

    private static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r,c});

        while(!q.isEmpty()){
            int cor[] = q.poll();
            int row = cor[0];
            int col = cor[1];

            for(int d=0;d<4;d++){
                int nRow = row + dRow[d];
                int nCol = col + dCol[d];

                if(nRow<0 || nRow>=N || nCol<0 || nCol>=M)
                    continue;
                if(visited[nRow][nCol] || map [nRow][nCol] == 0)
                    continue;

                q.add(new int[] {nRow,nCol});
                map[nRow][nCol] = map[row][col]+1;
                visited[nRow][nCol] = true;
            }
        }
    }
}
