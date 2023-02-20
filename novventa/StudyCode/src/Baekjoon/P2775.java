package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2775 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 입력받기
        int tc = Integer.parseInt(br.readLine());

        // 테스트 케이스 횟수만큼 반복
        for(int T=0;T<tc;T++){

            // 몇층 몇호의 답을 구하는지 입력받기
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            // 사람의 수를 넣을 2차원 배열 선언
            int[][] arr = new int[15][15];

            // 0층에 사는 사람 수 입력하기
            for(int r=1;r<=14;r++){
                arr[0][r] = r;
            }

            // 나머지 집에 사람이 몇명 사는지 채우기
            for(int r=1; r<=14; r++){
                for(int c=1; c<=14; c++){
                    arr[r][c] = arr[r][c-1] + arr[r-1][c];
                }
            }
            // k층 n호에 사는 사람 수 출력
            System.out.println(arr[k][n]);
        }
    }
}
//층수
//5 0  1  8 36 120  330
//4 0  1  7 28  84  210
//3 0  1  6 21  56  126
//2 0  1  5 15  35   70
//1 0  1  4 10  20   35
//0 0  1  3  6  10   15
//  0  1  2  3   4    5 호수