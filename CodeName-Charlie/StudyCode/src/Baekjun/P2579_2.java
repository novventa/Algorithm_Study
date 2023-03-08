package Baekjun;

// 이 방법은 재귀함수가 아닌 반복문을 사용해 문제를 해결하는 방법입니다.
// 자세한 주석은 P2579를 확인해주세요.

import java.util.Scanner;

public class P2579_2 {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
		int N = sc.nextInt();
 
		int[] DP = new int[N + 1];
		int[] arr = new int[N + 1];
 
 
		for (int idx = 1; idx <= N; idx++) {
			arr[idx] = sc.nextInt();
		}
        
		// index = 0 은 시작점이므로 0이다.		
		DP[1] = arr[1];
        
		// N 이 1이 입력될 수도 있기 때문에 예외처리를 해줄 필요가 있다.
		if (N >= 2) {
			DP[2] = arr[1] + arr[2];
		}
 
		for (int idx = 3; idx <= N; idx++) {
			DP[idx] = Math.max(DP[idx - 2] , DP[idx - 3] + arr[idx - 1]) + arr[idx];
		}
 
		System.out.println(DP[N]);
 
	}
 
}
