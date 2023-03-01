package SWEA;

import java.util.Scanner;

public class P2005 {
    public static void main(String[] args) {

        // 스캐너 선언
        Scanner sc = new Scanner(System.in);
        // 테스트 케이스 입력받기
        int T = sc.nextInt();
        // 테스트 케이스만큼 반복
        for(int tc=1;tc<T+1;tc++){
            // 파스칼의 삼각형 층 수 입력받기
            int N = sc.nextInt();
            // 파스칼의 삼각형 층만큼 2차원 배열 생성
            int[][] tri = new int[N][N];

            // 파스칼의 삼각형 규칙 알고리즘
            for(int r=0;r<N;r++){
                for(int c=0;c<=r;c++){
                    // 행과 열의 값이 같을 때에는
                    if(r==c){
                        // 1이다
                        tri[r][c] = 1;
                    } else if (c==0) {
                        // 0열은 모두 1이다
                        tri[r][c] = 1;
                        // 나머지는 규칙에 따라 배열에 저장한다.
                    }else{
                        tri[r][c] = tri[r-1][c-1] + tri[r-1][c];
                    }

                }
            }

            // 출력하기
            System.out.println("#" + tc);
            for(int r=0;r<N;r++){
                for(int c=0;c<=r;c++){
                    System.out.print(tri[r][c] + " ");
                }
                System.out.println();
            }

        }
    }
}
