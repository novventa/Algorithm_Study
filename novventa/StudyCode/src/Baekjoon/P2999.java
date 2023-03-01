package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2999 {
    // 메시지를 입력받고 메시지의 글자수를 알아낸다.
    // 행이 열보다 작거나 같고 행과 열의 곱이 글자수인 2차원 배열에서 글자를 하나씩 저장한다.
    // 행값이 가장 큰 경우의 문자열을 해독한다.

    public static void main(String[] args) throws IOException {
        // 버퍼드리더 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 메세지 입력받기
        String message = br.readLine();
        // 메세지의 길이 구하기
        int N = message.length();
        // 행의 크기 R과 열의 크기 C를 저장하기 위한 변수
        int R = 0;
        int C = 0;

        // R과 C를 구한다.
        for (int i = 1; i < N; i++) {
            // 문자열 길이를 하나씩 옮겨가면서
            // 조건에 맞는 R과 C를 구한다.
            if (N % i == 0 && i <= N / i) {
                R = i;
                C = N / i;
            }
        }
        // 조건에 맞는 R과 C가 없다면 둘 다 1로 설정한다.
        if (R == 0 && C == 0) {
            R = 1;
            C = 1;
        }

        // 메세지를 한 글자씩 배열에 저장한다.
        char[] messageArr = message.toCharArray();
        // 암호화한 문자열을 저장할 2차원 배열 생성
        char[][] encrypted = new char[R][C];
        // char 배열에서 하나씩 2차원 배열에 넣기 위한 변수
        int idx = 0;
        // 암호화 규칙에 따라 넣는다.
        for(int c=0; c<C; c++){
            for(int r=0; r<R; r++){
                encrypted[r][c] = messageArr[idx++];
            }
        }

        // 출력
        for(int r=0; r<R; r++) {
            for (int c = 0; c < C; c++) {
                System.out.print(encrypted[r][c]);
            }
        }

    }
}
