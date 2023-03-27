package SWEA;

import java.util.Scanner;

public class P5215 {
    public static void main(String[] args) {
        // 스캐너 선언
        Scanner sc = new Scanner(System.in);
        // 테스트 케이스 입력받기
        int T = sc.nextInt();
        // 테스트 케이스 횟수만큼 반복
        for(int tc=1;tc<=T;tc++){
            // 재료 갯수 입력받기
            int N = sc.nextInt();
            // 제한 칼로리 입력받기
            int L = sc.nextInt();
            // 재료의 점수를 저장할 배열
            int[] grad = new int[N];
            // 재료의 칼로리를 저장할 배열
            int[] cal = new int[N];
            // 재료 정보 입력받기
            for(int i=0;i<N;i++){
                grad[i] = sc.nextInt();
                cal[i] = sc.nextInt();
            }
            // DP 알고리즘 사용
            // Bottom-Up
            // 제한 칼로리 이내에서의 점수의 최댓값이 저장된다.
            int[][] dp = new int[N + 1][L + 1];
            // 재료를 하나씩 더해보면서 선택하거나 선택하지 않고 조합해본다.
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= L; j++) {
                    // i번째 재료를 더 넣을 수 있는 경우
                    if (cal[i - 1] > j) {
                        dp[i][j] = dp[i - 1][j];
                        // i번째 재료를 더 넣을 수 없는 경우
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cal[i - 1]] + grad[i - 1]);
                    }
                }
            }
            // 출력
            System.out.println("#" + tc + " " + dp[N][L]);


        }
    }
}
