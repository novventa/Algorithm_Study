
// "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. 
// O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다.
// 예를 들어, 10번 문제의 점수는 3이 된다.
// "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
// OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.

package Baekjun;

// 테스트 케이스를 입력 받자.
// X와 O로 이루어진 문자열을 입력 받자.
// 해당 문자열을 하나의 문자 형태로 구분해,
// X와 O를 판별하고,
// O의 개수를 세는 cnt 변수와 점수의 합을 나타내는 sum 변수를 생성한 뒤
// 값을 도출하자.

import java.util.Scanner;

public class P8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 T를 입력 받는다.
		String[] xo = new String[T]; // 퀴즈의 정답 결과를 문자열의 형태로 입력 받을 배열 'xo'를 생성한다. 
		for (int i = 0; i < T; i++) { // 테스트 케이스의 수만큼 반복문을 실행한다.
			xo[i] = sc.next(); // 정답 결과를 입력 받는다.
		}
		int sum = 0; // 점수의 합을 저장할 변수 sum을 선언하고, 0으로 초기화한다.
		int cnt = 0; // 문자 'O'를 셀 변수 cnt를 선언하고, 0으로 초기화한다.
		for (int j = 0; j < T; j++) {
			for (int k = 0; k < xo[j].length(); k++) { // 입력받은 문자열의 길이만큼 반복문을 실행한다.
				if (xo[j].charAt(k) == 'O' && k != (xo[j].length() - 1)) { // char.At 메서드를 사용해 해당 문자가 'O'이면서, 문자열의 마지막 문자가 아니라면,
					cnt++; // cnt를 증가시키고,
				} if (xo[j].charAt(k) == 'X') { // 'X'라면
					sum = sum + (((cnt + 1) * cnt) / 2); // cnt 수 만큼 sum으로 환산한 뒤,
					cnt = 0; // cnt를 0으로 만든다.
				} if (xo[j].charAt(k) == 'O' && k == (xo[j].length() - 1)) { // 'O'이면서, 문자열의 마지막 문자라면,
					cnt++; // cnt를 증가시키고,
					sum = sum + (((cnt + 1) * cnt) / 2); // cnt 수 만큼 sum으로 환산한 뒤,
					cnt = 0; // cnt를 0으로 만든다.
				}
			}
			System.out.println(sum); sum = 0; // 합계를 출력하고, 다시 0으로 초기화한다.
		}
	}
}
