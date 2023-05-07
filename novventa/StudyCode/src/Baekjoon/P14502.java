package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14502 {
    // dfs, bfs 둘 다 쓰는 문제
    // 벽을 세울 땐 dfs를 쓰고
    // 바이러스가 퍼질 땐 bfs를 쓴다

    static int N,M,max;
    static int[][] map;
    static int[][] vMap;
    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,-1,1};
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        // 가로 세로 입력받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;
        
        map = new int[N][M];
        // 맵 입력받기
        for(int r=0;r<N;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<M;c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // dfs로 벽 세우기
        dfs(0);
        // 출력
        System.out.println(max);



    }

    private static void dfs(int cnt) {
        // 벽 3개 세웠으면 바이러스 퍼뜨리기
        if(cnt == 3){
            bfs();
            return;
        }
        // 벽 세워보기
        for(int r=0;r<N;r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 0) {
                    map[r][c] = 1;
                    dfs(cnt + 1);
                    map[r][c] = 0;
                }
            }
        }
    }

    private static void bfs() {
        // 바이러스 퍼뜨리기
        Queue<int[]> q = new LinkedList<>();
        vMap = new int[N][M];

        for(int r=0;r<N;r++){
            for(int c=0;c<M;c++){
                vMap[r][c] = map[r][c];
                if(vMap[r][c]==2)
                    q.add(new int[] {r,c});
            }
        }

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int row = tmp[0];
            int col = tmp[1];

            for(int d=0;d<4;d++){
                int nRow = row + dRow[d];
                int nCol = col + dCol[d];

                if(nRow>=0 && nRow<N && nCol>=0 && nCol<M && vMap[nRow][nCol]==0){
                    vMap[nRow][nCol] = 2;
                    q.add(new int[] {nRow, nCol});
                }
            }
        }
        // 안전영역 갯수 세기
        int cnt = 0;
        for(int r=0;r<N;r++){
            for(int c=0;c<M;c++){
                if(vMap[r][c]==0)
                    cnt++;
            }
        }
        // 최대값 갱신
        max = Math.max(max,cnt);

    }
}
