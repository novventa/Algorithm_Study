package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10026 {

    static int N, normal, blind;
    static char[][] map;
    static boolean[][] visited;
    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,-1,1};


    public static void main(String[] args) throws IOException {
        // 버퍼드 리더
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 맵 크기
        N = Integer.parseInt(br.readLine());
        // 맵 정보 배열
        map = new char[N][N];
        // 방문체크 배열
        visited = new boolean[N][N];
        // 맵 입력받기
        for(int r=0;r<N;r++){
            String str = br.readLine();
            for(int c=0;c<N;c++){
                map[r][c] = str.charAt(c);
            }
        }
        // 정상인
        normal = 0;
        // dfs 실행
        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                if(!visited[r][c]){
                    dfs(r,c);
                    normal++;
                }
            }
        }
        // 적녹색약
        blind = 0;
        // 방문체크 배열 다시 선언
        visited = new boolean[N][N];
        // G를 R로 바꾸고
        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                if(map[r][c]=='G')
                    map[r][c] = 'R';
            }
        }
        // dfs 실행
        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                if (!visited[r][c]) {
                    dfs(r, c);
                    blind++;
                }
            }
        }
        // 출력
        System.out.println(normal + " " + blind);

    }

    private static void dfs(int r, int c) {
        // 방문 체크
        visited[r][c] = true;
        // 현재 위치의 색 임시 저장
        char tmp = map[r][c];
        // 4방 탐색
        for(int d=0;d<4;d++){
            int nRow = r+dRow[d];
            int nCol = c+dCol[d];
            // 경계 벗어나면 continue
            if(nRow>=N || nRow <0 || nCol>=N || nCol<0)
                continue;
            // 탐색하는 곳이 같은 색이면 dfs
            if(!visited[nRow][nCol] && map[nRow][nCol] == tmp)
                dfs(nRow,nCol);
        }

    }
}
