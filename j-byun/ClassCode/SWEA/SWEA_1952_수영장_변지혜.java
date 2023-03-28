import java.util.Scanner;

/**
 * @author jhye.byun
 * SWEA 1952 수영장 DFS/BFS
 * 
 * 문제
 * 가장 적은 비용으로 수영장을 이용하자.
 * 이용권 종류 : 1일 / 1달 / 3달 / 1년
 * 
 * 조건
 * 모든 종류의 이용권 요금은 10 이상 3,000 이하의 정수
 * 각 달의 이용 계획은 각 달의 마지막 일자보다 크지 않다.
 * 
 * 풀이
 * 1. 1년 이용권의 금액을 초기값으로 선언하고, 나머지 세 종류의 이용권을 쓰는 경우를 확인해보자
 * 2. 재귀 호출하면서 현재까지의 최소금액보다 커지면 더 이상 탐색하지 말자. (백트래킹)
 */

public class SWEA_1952_수영장_변지혜 {
	
	static int minFee;
	static int[] fee, month;
	
	public static void dfs(int sumFee, int depth, int maxDepth) {
		
		// 백트래킹 조건
		// 지금까지 더한 요금이 찾아놨던 최소 요금보다 비싸면 해당 가지 탐색 중단
		if (sumFee >= minFee) {
			return;
		}
		
		// 기저조건
		// 11월이나 12월에 3개월권을 구매했으면 depth가 12가 넘어가니까 조건을 maxDepth 이상으로 설정
		if (depth >= maxDepth) {
			minFee = Math.min(minFee, sumFee);
			return;
		}
		
		// 세 종류의 이용권을 구매하는 경우를 고려해보자
		// 1일 이용권
		dfs(sumFee + (fee[0] * month[depth]), depth + 1, maxDepth);
		// 1달 이용권
		dfs(sumFee + fee[1], depth + 1, maxDepth);
		// 3달 이용권
		dfs(sumFee + fee[2], depth + 3, maxDepth);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt(); // 테케 개수
		
		for (int tc = 1; tc <= testCase; tc++) {
			fee = new int[4]; // 네 종류의 이용권 금액을 저장할 공간
			
			// 네 종류의 이용권 금액을 차례대로 입력받자
			for (int idx = 0; idx < 4; idx++) {
				fee[idx] = sc.nextInt();
			}
			
			month = new int[12]; // 각 달의 이용 계획을 저장할 공간
			
			// 각 달의 이용 계획을 입력받자
			for (int idx = 0; idx < 12; idx++) {
				month[idx] = sc.nextInt();
			}
			
			// 최소 금액을 1년 이용권을 구매했을 때로 가정하자
			minFee = fee[3];
			
			// 각 달에 대해 세 종류의 이용권을 구매할 때의 경우를 살펴보자
			dfs(0, 0, 12);
			
			// 모든 경우를 탐색했다면 찾아낸 최소 이용 금액을 출력하자
			System.out.printf("#%d %d\n", tc, minFee); // 출력
		}
	}
}
