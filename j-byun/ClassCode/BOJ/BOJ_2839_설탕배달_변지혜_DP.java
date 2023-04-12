import java.util.Scanner;

/**
 * @author jihye.byun
 * BOJ 2839 설탕 배달 실버4 DP
 * 
 * 문제
 * 정확하게 N킬로그램의 설탕을 배달하자.
 * 설탕 봉지는 3키로와 5키로 두 종류이다.
 * 최대한 적은 봉지로 배달하자.
 * 봉지를 몇 개를 가져가면 되는지 그 수를 구하자.
 * 정확하게 N킬로그램을 만들 수 없다면 -1을 출력하시오.
 * 
 * 조건
 * (3 ≤ N ≤ 5000)
 * 
 * 풀이
 * 1. 0~N킬로그램까지의 배열을 만들어서, 각 임시 무게에 필요한 최소 설탕 봉지 개수를 저장하자.
 * 2. 정확하게 N킬로그램을 만들 수 없다면 -1을 출력해야하니, 1,2킬로그램은 -1로 초기화하자.
 * 3. dp[i-3] + 1 과 dp[i-5] + 1 중 작은 값을 dp[i]에 저장하는데, 이 때 dp[i-3]과 dp[i-5]가 -1이 아닌 지 확인하자.
 */

public class BOJ_2839_설탕배달_변지혜_DP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] dp = new int[N + 1];
		
		dp[1] = -1;
		dp[2] = -1;
		
		for (int idx = 3; idx <= N; idx++) {
			// 3키로 봉지 사용하는 경우 생각해보기
			if (dp[idx - 3] != -1)
				dp[idx] = dp[idx - 3] + 1;
			
			// 5키로 봉지 사용하는 경우 생각해보기
			if (idx >= 5 && dp[idx - 5] != -1) {
				if (dp[idx] != 0) // 3키로도 사용할 수 있었으면 둘 중 비교
					dp[idx] = Math.min(dp[idx], dp[idx - 5] + 1);
				else // 3키로 사용 못하면 걍 5키로 사용하는 경우만 넣어버려
					dp[idx] = dp[idx - 5] + 1;
			}
			
			// 두 경우 모두 고려했는데 값이 0으로 남아있다면 해당 키로를 만들 수 없는거니까
			// -1로 채워주자
			if (dp[idx] == 0)
				 dp[idx] = -1;
		}
		
		System.out.println(dp[N]);
	}
}
