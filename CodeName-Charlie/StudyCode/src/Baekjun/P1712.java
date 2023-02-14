package Baekjun;

import java.util.Scanner;

public class P1712 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt(); // 고정비용 A를 입력 받는다.
		int B = sc.nextInt(); // 가변비용 B를 입력 받는다.
		int C = sc.nextInt(); // 노트북의 가격 C를 입력 받는다.
		
		int X = 0; // 손익분기점을 나타내는 변수 X를 0으로 초기화한다.
		
		if(B < C) { // 가변비용 B가 가격 C보다 작은 경우에는  
			X = A / (C-B); // 손익분기점을 구하는 식(고정비용 / (가격 - 가변비용))을 X에 대입한다.
		}
		else {
			X = -1; // 가변비용이 가격보다 크거나 같은 경우에는 X에 -1을 대입한다.
		}
		
		if(X >= 0) { // X의 값이 0보다 크거나 같은 경우,
			System.out.println(X+1);} // 손익분기점인 X+1을 출력하고,
		else {
			System.out.println(X); // 아닌 경우 X(-1)를 출력한다.
		}
	}
}
