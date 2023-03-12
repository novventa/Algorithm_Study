package SWEA;

import java.util.Scanner;

public class P13707 {
    // 기지국

    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,-1,1};
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=1;tc<=T;tc++){

            int N = sc.nextInt();

            char[][] map = new char[N][N];

            int cnt = 0;

            for(int r=0;r<N;r++){
                String str = sc.next();
                for(int c=0;c<N;c++){
                    map[r][c] = str.charAt(c);
                    if(map[r][c]=='H')
                        cnt++;
                }
            }

            int cover = 0;

            for(int r=0;r<N;r++){
                for(int c=0;c<N;c++){
                    if(map[r][c]=='A'){
                        for(int d=0;d<4;d++){
                            int nRow = r+dRow[d];
                            int nCol = c+dCol[d];
                            if(nRow>=0 && nRow<N && nCol>=0 && nCol<N){
                                if(map[nRow][nCol]=='H'){
                                    cover++;
                                    map[nRow][nCol] = 'P';
                                }
                            }
                        }
                    } else if(map[r][c]=='B') {
                        for (int d = 0; d < 4; d++) {
                            for (int m = 1; m <= 2; m++) {
                                int nRow = r + dRow[d]*m;
                                int nCol = c + dCol[d]*m;
                                if (nRow >= 0 && nRow < N && nCol >= 0 && nCol < N) {
                                    if (map[nRow][nCol] == 'H') {
                                        cover++;
                                        map[nRow][nCol] = 'P';
                                    }
                                }
                            }
                        }
                    } else if(map[r][c]=='C') {
                        for (int d = 0; d < 4; d++) {
                            for (int m = 1; m <= 3; m++) {
                                int nRow = r + dRow[d]*m;
                                int nCol = c + dCol[d]*m;
                                if (nRow >= 0 && nRow < N && nCol >= 0 && nCol < N) {
                                    if (map[nRow][nCol] == 'H') {
                                        cover++;
                                        map[nRow][nCol] = 'P';
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("#"+tc+" "+(cnt-cover));

        }
    }
}
