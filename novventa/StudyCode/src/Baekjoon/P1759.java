package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P1759 {

    // 암호 만들기
    // L개의 알파벳 소문자, 적어도 한개의 모음, 적어도 2개의 자음으로 구성된 암호
    // 암호는 알파벳순으로 정렬되었을 가능성이 크다.
    // C개의 문자가 주어지고, 가능성이 있는 암호들을 모두 구하는 문제
    // 가능성이 있는 암호란 자음 모음 조건을 만족하면서 정렬되어있는 길이 L의 문자열이 암호이다.
    // 먼저, 입력받은 알파벳을 정렬하고
    // 조건에 맞는 문자열을 sb에 저장하고 출력한다.
    // 조합 메서드를 직접 구현해야 한다.

        // 필요한 숫자를 저장할 변수
        static int L, C;
        // 입력받은 알파벳들을 저장할 배열
        static char[] alpha;
        // 스트링빌더로 문자열을 만들기 위해 선언
        static StringBuilder sb = new StringBuilder();

        // 메인 메소드
        public static void main(String[] args) {
            // 스캐너 선언
            Scanner sc = new Scanner(System.in);
            // 정수 2개 입력받기
            L = sc.nextInt();
            C = sc.nextInt();
            // 배열 생성
            alpha = new char[C];
            // 알파벳 입력받기
            for (int i = 0; i < C; i++) {
                alpha[i] = sc.next().charAt(0);
            }
            // 알파벳 순서대로 정렬
            Arrays.sort(alpha);
            // 조합을 사용해 암호 만들기
            combination(0, 0, 0, 0, new StringBuilder());
            // 스트링빌더에 쌓인 값들을 출력
            System.out.println(sb);
        }

        // 현재 선택하고 있는 문자의 인덱스, 현재까지의 문자열에 포함된 모음의 갯수, 현재까지의 문자열에 포함된 자음의 갯수
        // 현재까지 선택한 문자의 개수, 현재까지 생성된 암호를 저장한 스트링빌더를 파라미터로 받는 조합 메서드
        // 조합 메서드가 처음 호출되면 배열을 맨 앞의 알파벳부터 조건에 맞는 조합을 찾아 저장한다.
        public static void combination(int idx, int vowel, int cons, int count, StringBuilder password) {
            // 기저조건
            // L개의 문자를 모두 선택한 경우
            if (count == L) {
                // 모음과 자음의 개수가 조건에 맞으면
                if (vowel >= 1 && cons >= 2) {
                    // 암호가 완성된 것이므로, 스트링빌더에 저장한다.
                    sb.append(password.toString()).append('\n');
                }
                // 메서드 종료
                return;
            }
            // 알파벳을 저장한 인덱스 범위를 벗어나는 경우
            if (idx == C)

                // 메서드 종료
                return;

            // 현재 인덱스의 문자를 선택하는 경우
            // 파라미터로 받은 암호들이 저장된 스트링빌더를 바탕으로 새로운 암호를 저장하기 위해 다시 선언
            StringBuilder updatedPassword = new StringBuilder(password);
            // 문자를 선택했으므로 스트링빌더에 문자 저장
            updatedPassword.append(alpha[idx]);
            // 다음 문자로 이동하기 위해 idx+1, 선택한 문자가 모음이면 모음 갯수 1 증가, 아니면 0 증가
            // 선택한 문자가 자음이면 자음의 갯수 증가, 문자를 하나 추가했으므로 카운트도 1 증가
            // 업데이트 된 스트링빌더, 5개의 파라미터를 업데이트하고 조합 재귀함수를 호출한다.
            combination(idx + 1, vowel + (isVowel(alpha[idx]) ? 1 : 0), cons + (isVowel(alpha[idx]) ? 0 : 1), count + 1, updatedPassword);

            // 현재 인덱스의 문자를 선택하지 않는 경우
            // 다음 문자로 이동하기 위해 idx+1만 해준다.
            // 조합 재귀함수를 호출한다.
            combination(idx + 1, vowel, cons, count, password);
        }

        // 모음인지 판별하는 메서드
        public static boolean isVowel(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }
}
