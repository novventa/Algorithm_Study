
// 서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최댓값은 얼마일까?

package Baekjun;

// 변수 S를 입력 받자. 
// N이 가장 큰 값이 되려면, S는 1부터 시작해서 작은 수들의 합으로 이루어져야한다.
// S에서 자연수를 순차적으로 빼고, 그 수를 세 답을 출력하자.
// ex) S = 13, S = 1 + 2 + 3 + (4 + 3), N = 4  

import java.util.Scanner;

public class P1789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long S = sc.nextLong(); // 변수 S를 입력 받는다. 
		// S의 최대값이 약 42억이기 때문에, 약 21억까지만 저장할 수 있는 int 형태가 아닌, long 형태로 입력 받는다. 
		int number = 1; // S에서 순차적으로 빼줄 자연수를 나타내는 변수 number를 선언하고, 자연수 중 가장 작은 수인 1로 초기화한다. 
		int cnt = 0; // 수를 셀 때 사용할 변수 cnt를 선언하고, 0으로 초기화한다.
		
		while(S >= 0) { // while문을 사용해, S가 0이 될 때 까지 반복한다.
			S -=number; // S에서 number를 빼고,
			number++; // number를 1씩 증가시키고,
			cnt++; // cnt를 1씩 증가시킨다.
		}
		System.out.println(cnt-1); // 반복문이 종료됐을 때, cnt는 원래 수 보다 하나 더 많이 세어졌기 때문에, cnt - 1을 출력한다.
		
	}
}
