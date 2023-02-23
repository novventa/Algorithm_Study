package SWEA;

import java.util.Scanner;

public class P1954 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
         
        int[] dRow = {0,1,0,-1};    // 우 하 좌 상
        int[] dCol = {1,0,-1,0};
        // 테스트 케이스 입력받기
        int T = sc.nextInt();
        // 테스트 케이스만큼 반복
        for(int tc=1;tc<T+1;tc++) {
            // 배열 크기 입력받기
            int N = sc.nextInt();
            // 배열 선언
            int[][] map = new int[N][N];
            // 델타 배열 방향 변수
            int direction = 0;
            // 처음 시작 좌표
            int r=0;
            int c=0;
            // 배열 채우기
            for(int i=1;i<=N*N;i++) {
                // 좌표에 i값 넣기
                map[r][c]=i;
                // 경계를 벗어나거나 좌표가 이미 채워져 있으면
                if(r+dRow[direction] >= N || r+dRow[direction]<0|| c+dCol[direction]>=N || c+dCol[direction]<0 || map[r+dRow[direction]][c+dCol[direction]]!=0) {
                    // 방향 전환
                    direction = (direction+1) % 4;
                }
                // 행과 열 움직이기
                r += dRow[direction];
                c += dCol[direction];
            }
             
            // 출력
            System.out.println("#"+tc);
            for(int row=0;row<N;row++) {
                for(int col=0;col<N;col++) {
                    System.out.print(map[row][col]+" ");
                }
                System.out.println();
            }
             
             
        }
         
    }
}
