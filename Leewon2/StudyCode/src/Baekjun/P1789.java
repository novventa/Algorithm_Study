/* 문제
* 서로 다른 N개의 자연수의 합이 S라고할 때 자연수 N의 최댓값은 얼마일까?
* 
* 
* 문제 조건
* 자연수들의 합 S 는 1 이상 42억 이하다.
* 
*
* 문제 해결 방법
* sum의 크기가 int보다 크므로
* 수 들의 합 sum를 long 타입으로 입력 받는다.
* 1부터 더해가면서 sum에서 i를 뺏을 때 음수가 된다면, i는 선택하지 않고, i-1 값을 수정해보자.
* 예를 들어, 11의 경우,
* 11 - 1 = 10
* 10 - 2 = 8
* 8 - 3 = 5
* 5 - 4 = 1
* 1 - 5 = -4가 된다.
* 음수가 됐으니, i(5)는 선택하지 않고, i-1(4)를 i-1(5)로 바꾸면 된다.
* 갯수만 셋면 되니, i가 1씩 커지면서 뺄 때, 0이 된다면 i-1이 되고, 음수가 된다면 i-2가 된다.
* 
*/

package Baekjun;

import java.util.Scanner;

public class P1789 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// long 타입으로 입력 받아 보자.
		long sum = sc.nextLong();

		// 1씩 커지는 숫자를 변수에 저장해보자.
		int i = 1;
		// sum이 0보다 작아지면 종료된다.
		while (sum > 0) {
			// sum에서 1씩 빼간다.
			sum -= i;
			// 한번 돌고 i에 1을 더하자.
			i++;
		}

		// 삼항 연산자를 이용해 result에 저장해보자.
		// sum이 0이면, i-1을, sum이 음수라면 i-2를 출력해보자.
		int result = (sum == 0) ? i - 1 : i - 2;
		System.out.println(result);

	}
}
