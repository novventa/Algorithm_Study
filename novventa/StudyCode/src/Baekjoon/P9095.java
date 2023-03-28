package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9095 {
	
	static int cnt;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		// 버퍼드리더 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 입력받기
		int T = Integer.parseInt(br.readLine());
		// 테스트케이스만큼 반복
		for(int tc=1;tc<=T;tc++) {
			// 숫자 입력받기
			int n = Integer.parseInt(br.readLine());
			// 갯수 변수
			cnt = 0;
			// dp 값을 저장할 배열
			dp = new int[11];
			
			// n이 1일 때는 1가지
			// n이 2일 때는 1+1, 2 2가지
			// n이 3일 때는 1+1+1, 2+1, 1+2, 3 4가지
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			
			// 나머지 값들은 위 값들로 이루어진다.(n<11)
			for(int i=4;i<11;i++) {
				dp[i] = dp[i-3] + dp[i-2] + dp[i-1]; 
			}
			
			// 출력
			System.out.println(dp[n]);
		}
	}
}
