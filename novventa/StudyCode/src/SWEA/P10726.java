package SWEA;

import java.util.Scanner;

public class P10726 {
    static String answer;
    static int checkBitSize;
    static int num;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        for(int tc = 1; tc <= testCase; tc++) {
            answer = "OFF";
            // 마지막 비트의 개수
            checkBitSize = sc.nextInt();
            // 판단해야하는 수.
            num = sc.nextInt();

            int checkBit = (1 << checkBitSize) - 1; // 요 친구가 어떻게 되는지?
            // checkBit를 계산하는 비트 연산은 이진수에서 첫 번째 n 비트를 1로 설정
            // 구체적으로, 첫 번째 n 비트를 1로 설정하기 위해 왼쪽 시프트 연산자 <<를 사용하여
            // 1을 n 비트만큼 왼쪽으로 이동시킨 다음 결과에서 1을 뺀다
            // 예를 들어, n이 3인 경우, checkBit 변수는 0b111 (10진수 7)이다.
            if((num & checkBit) == checkBit) {
                answer = "ON";
            }

            System.out.println("#"+tc+" "+ answer);
        }

    }
}