package SWEA;

import java.util.Scanner;

public class P1209 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[100][100];

        for(int T = 0; T < 10; T++){

            // 테스트 케이스 번호 입력받기
            int tc = sc.nextInt();

            // 배열 채우기
            for(int r=0;r< arr.length;r++){
                for(int c=0;c< arr.length;c++){
                    arr[r][c] = sc.nextInt();
                }
            }

            // 최대값 계산하기
            int maxSum = 0;

            // 행, 열, 대각선의 합 중 최대값 구하기
            maxSum = Math.max(maxSum, rowSum(arr));
            maxSum = Math.max(maxSum, colSum(arr));
            maxSum = Math.max(maxSum, diagonalSum(arr));

            // 출력
            System.out.println("#" + tc + " " + maxSum);
        }
    }

    // 2차원 배열에서 행의 합 중 최대값을 반환하는 메소드
    public static int rowSum(int[][] arr) {
        int maxSum = 0;
        for(int r=0; r<arr.length; r++){
            int sum = 0;
            for(int c=0; c<arr.length;c++){
                sum += arr[r][c];
            }
            if(sum>maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    // 2차원 배열에서 열의 합 중 최대값을 반환하는 메소드
    public static int colSum(int[][] arr) {
        int maxSum = 0;
        for(int c=0; c<arr.length; c++){
            int sum = 0;
            for(int r=0; r<arr.length;r++){
                sum += arr[r][c];
            }
            if(sum>maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    // 2차원 배열에서 대각선의 합 중 최대값을 반환하는 메소드
    public static int diagonalSum(int[][] arr) {
        int maxSum = 0;
        int sum = 0;

        // 왼쪽 위에서 오른쪽 아래로의 대각선
        for(int i=0; i<arr.length; i++){
            sum += arr[i][i];
        }
        maxSum = Math.max(maxSum, sum);

        // 오른쪽 위에서 왼쪽 아래로의 대각선
        sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i][arr.length-1-i];
        }
        maxSum = Math.max(maxSum, sum);

        return maxSum;
    }
}