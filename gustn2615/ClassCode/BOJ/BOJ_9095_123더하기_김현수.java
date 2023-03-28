package study_ssafy;
/*
 * dp로 문제를 푼다
 * 1 , 2 , 3 을 사용해서 정수 n을 만들어야 한다
 * 
 * 1. 1 , 2 , 3 을 만들 수 있는 경우의 수를 구한다.
 * 2. 이후에 정수 4를 만드는 경우를 생각해 보자
 * 2-1. 정수 4 => 1+3 , 2+2, 3+1 만 하면 만들어 질 수 있다.
 * 3. 따라서 정수 4를 만드는 경우의 수는 1,2,3을 만드는 모든 경우의 수를 합친것이다.
 * 4. dp[n]=dp[n-1]+dp[n-2]+dp[n-3] 가 된다.
 * 
 * */
import java.util.Scanner;

public class solution_9095_123더하기_김현수 {
	public static void main(String[] args) {
		
		// 스캐너 사용
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 횟수 받아오기
		int T = sc.nextInt();
		
		// 경우의 수를 저장할 dp 배열
		int[] dp = new int[11];

		// 1, 2, 3을 만들 수 있는 경우의 수를 dp 배열에 넣는다 
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		// 이후 점화식을 통해 나머지 dp 를 채워준다
		for (int i = 4; i < 11; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}

		// 출력한다
		for (int i = 0; i < T; i++) {
			System.out.println(dp[sc.nextInt()]);
		}
		
		// 스캐너 종료
		sc.close();
	}
}
