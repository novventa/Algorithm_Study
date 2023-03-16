package Baekjoon;

import java.util.Scanner;
// 1부터 하나씩 더해가면서 S보다 합이 커지기 직전의 갯수를 구하고
// 그 갯수에서 2를 빼면 N의 최대값이다.
public class P1789 {
    public static void main(String[] args) {
        // 스캐너 선언
        Scanner sc = new Scanner(System.in);
        // 41억까지이므로 long으로 선언
        long S = sc.nextLong();
        // sum 또한 long으로 선언
        long sum = 0;
        // N은 1부터 시작
        int N = 1;
        // 합이 S보다 커지기 직전까지
        while(sum<=S){
            // 더한다.
            sum += N;
            // N은 1씩 더한다.
            N++;
        }
        // 출력
        System.out.println(N-2);

    }
}
