package SWEA;

import java.util.Scanner;

public class P13705 {
    // 파동파동

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=1;tc<=T;tc++){
            // 맵 범위
            int N = sc.nextInt();
            // 에너지 시작값
            int M = sc.nextInt();
            // 행
            int R = sc.nextInt()-1;
            // 열
            int C = sc.nextInt()-1;
            // 증감값
            int D = sc.nextInt();
            // 크기가 N인 2차원 배열 생성
            int[][] map = new int[N][N];

            int[] sum = new int[N];

            for (int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    map[R][C] = M;
                    if(Math.abs(R-i)!=0 || Math.abs(C-j) !=0) {
                        if(Math.abs(R-i) < Math.abs(C-j)) {
                            map[i][j] = M + Math.abs(C-j)*D;
                        }
                        else {
                            map[i][j] = M + Math.abs(R-i)*D;
                        }
                    }
                    if(map[i][j]>=255) {
                        map[i][j] =255;
                    }
                    else if (map[i][j]<0) {
                        map[i][j]=0;
                    }
                    sum [i] += map[i][j];
                }
            }

            System.out.printf("#%d",tc);
            for (int k=0; k<N; k++) {
                System.out.printf(" %d", sum[k]);
            }
            System.out.println();


        }

    }
}
