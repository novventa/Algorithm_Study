package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P7569 {
    static int M, N,H,ans;
    static int[][][] map;
    static boolean[][][] visited;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dX = {0,0,0,0,-1,1};
    static int[] dY = {0,0,1,-1,0,0};
    static int[] dZ = {1,-1,0,0,0,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 가로 세로 높이 입력받기
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        // 3차원 배열 및 방문 배열 생성
        map = new int[M][N][H];
        visited = new boolean[M][N][H];

        // 입력받고 익은 토마토 있으면 방문처리 및 큐에 저장
        for(int h=0;h<H;h++){
            for(int r = 0; r< M; r++){
                for(int c = 0; c< N; c++){
                    int tmp = sc.nextInt();
                    map[r][c][h] = tmp;

                    if(tmp == 1){
                        q.offer(new int[]{r,c,h});
                        visited[r][c][h] = true;
                    }
                }
            }
        }

        // 너비우선탐색
        bfs();

        // 전부 다 안익으면 -1 출력 후 종료
        for(int h=0;h<H;h++){
            for(int r = 0; r< M; r++){
                for(int c = 0; c< N; c++){
                    if(map[r][c][h] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                    // 모두 익으면 날짜 계산
                    else
                        ans = Math.max(ans,map[r][c][h]);
                }
            }
        }
        // 출력
        System.out.println(ans-1);

    }

    private static void bfs() {
        // 너비우선탐색
        while (!q.isEmpty()){
            int x = q.peek()[0];
            int y = q.peek()[1];
            int z = q.peek()[2];
            q.poll();

            for(int d=0;d<6;d++){
                int nX = x + dX[d];
                int nY = y + dY[d];
                int nZ = z + dZ[d];
                // 경계조건
                if(nX >= 0 && nX < M && nY >= 0 && nY < N && nZ >= 0 && nZ < H ){
                    if(map[nX][nY][nZ] == 0 && !visited[nX][nY][nZ]){
                        q.offer(new int[]{nX,nY,nZ});
                        visited[nX][nY][nZ] = true;
                        map[nX][nY][nZ] = map[x][y][z] + 1;
                    }
                }
            }
        }
    }
}
