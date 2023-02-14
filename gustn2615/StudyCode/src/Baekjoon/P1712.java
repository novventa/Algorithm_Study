package Baekjoon;

import java.util.Scanner;

public class P1712 {
	public static void main(String[] args) {
		// 스캐너로 입력 받기
		Scanner sc = new Scanner(System.in);
		
		// A,B,C 입력받기
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		sc.close();
		
		// 만드는 비용이 판매비용보다 크거나 같으면 
		// 손익분기점을 넘을 수없으므로 -1출력
		if (B >= C) {
			System.out.println(-1);
		}

		// 그외의 경우에는 수식을 통해 손익분기점이
		// A / (C - B) 보다 크다는 것을 알 수 있다.
		else {
			int result = (A / (C - B));
			// int는 버림으로 계산이 되기 때문에 1을 더해준다.
			System.out.println(result + 1);
		}
	}
}




