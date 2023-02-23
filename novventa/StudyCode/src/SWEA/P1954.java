package SWEA;

import java.util.Scanner;

public class P1954 {
    public static void main(String[] args) {

        // 스캐너 선언
        Scanner sc = new Scanner(System.in);
        // 테스트 케이스 입력받기
        int T = sc.nextInt();
        // 테스트 케이스만큼 반복
        for(int tc=1;tc<T+1;tc++){
            // 달팽이 크기 입력받기
            int N = sc.nextInt();
            // 달팽이 크기만큼 2차원 배열 생성
            int[][] snail = new int[N][N];
            // 0,0에는 무조건 1이 들어간다.
            snail[0][0] = 1;

            for(int i=0;i<N;i++){

            }





        }
    }
}
//                    0,0  0,1  0,2  0,3
//
//                    1,0  1,1  1,2  1,3
//
//                    2,0  2,1  2,2  2,3
//
//                    3,0  3,1  3,2  3,3