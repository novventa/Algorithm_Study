package Baekjun;

import java.util.Scanner;

public class P1193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt(); // 수 X를 입력받는다.
		int cnt = 1; // 대각선 줄의 번호를 차례대로 매기기 위해 변수 cnt를 선언하고 1로 초기화 한다.
		int a = 1; // 변수 cnt를 통해 번호를 매기기 위해서, X에서 지속적으로 뺄 변수 a를 선언, 1로 초기화한다.

		while (X - a > 0) { // while문을 사용해,
			X = X - a; // X에서 a를 뺐을 때, 그 값이 0보다 크다면, 변수 X에 X-a를 대입하고,
			a++; // 변수 a를 1 증가 시키고,
			cnt++; // 변수 cnt도 1 증가 시킨다.
		} // 변수 X-a의 크기가 0보다 클 때까지 반복한다.
			// 줄의 번호에 따라, 시작점이 다르기 때문에,
		if (cnt % 2 == 0) // 번호(변수 cnt)가 짝수인 경우와
			System.out.println(X + "/" + (cnt - (X - 1)));
		else // 홀수인 경우를 나눠서 값을 출력한다.
			System.out.println((cnt - (X - 1)) + "/" + X);
	}
}
