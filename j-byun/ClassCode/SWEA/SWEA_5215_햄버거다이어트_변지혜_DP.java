import java.util.Scanner;

/**
 * @author jhye.byun
 * SWEA 5215 햄버거 다이어트 D3 DP
 * 
 * 문제
 * 원하는 재료만 넣어서 조합할 수 있는 햄버거 가게
 * 각 재료에 대한 맛 점수와 칼로리가 주어졌을 때,
 * 정해진 칼로리 이하의 조합 중에서 가장 점수가 높은 햄버거를 조합하자.
 *
 * 조건
 * 같은 재료를 여러 번 사용할 수 없다.
 * 재료의 수 N (1 ≤ N ≤ 20)
 * 제한 칼로리 L (1 ≤ L ≤ 10^4)
 * 각 재료에 대한 맛 점수 Ti (1 ≤ Ti ≤ 10^3)
 * 각 재료의 칼로리 Ki (1 ≤ Ki ≤ 10^3)
 * 
 * 풀이
 * 1. 0칼로리부터 제한 칼로리까지의 배열을 만들어서 임시 칼로리에서 얻을 수 있는 최대 맛 점수를 저장하자.
 * 2. 1번 재료를 고려했을 때, 1번과 2번 재료를 고려했을 때, 1번+2번+3번 재료를 고려했을 때... 차례대로 생각해보자.
 * 3. 현 재료의 칼로리 미만일 때에는, 이전 재료까지의 최댓값을 저장하고,
 * 3-1. 현 재료의 칼로리 이상일 때는 현재 재료를 사용하는 경우를 고려해주자.
 */

public class SWEA_5215_햄버거다이어트_변지혜_DP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기
		
		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복 실행
			
			int N = sc.nextInt(); // 재료의 수 입력받기
			int L = sc.nextInt(); // 제한 칼로리 입력받기
			
			int[] taste = new int[N + 1]; // 각 재료의 맛에 대한 점수를 저장할 공간
			int[] kcal = new int[N + 1]; // 각 재료의 칼로리를 저장할 공간
			
			// 맛 점수와 칼로리를 입력받자
			for (int idx = 1; idx <= N; idx++) {
				taste[idx] = sc.nextInt();
				kcal[idx] = sc.nextInt();
			}
			
			// 각 재료를 사용했을 때, 임시 제한 칼로리에서의 최대 맛 점수를 저장해보자
			int[][] dp = new int[N + 1][L + 1];
			
			for (int topping = 1; topping <= N; topping++) {
				for (int calorie = 0; calorie <= L; calorie++) {
					if (kcal[topping] <= calorie)
						dp[topping][calorie] = Math.max(dp[topping - 1][calorie], dp[topping - 1][calorie - kcal[topping]] + taste[topping]);
					else
						dp[topping][calorie] = dp[topping - 1][calorie];
				}
			}
			
			// 모든 재료를 다 고려해봤다면,
			// 모든 재료를 다 고려해줬을 때 제한 칼로리에 저장된 최대 맛 점수를 출력하자
			System.out.printf("#%d %d\n", tc, dp[N][L]);
		}
	}

}
