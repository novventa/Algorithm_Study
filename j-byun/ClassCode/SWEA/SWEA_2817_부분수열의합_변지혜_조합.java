import java.util.Scanner;

/**
 * @author jhye.byun
 * SWEA 2817 부분 수열의 합 D3 부분집합/조합
 * 
 * 문제
 * N개의 자연수가 주어졌을 때, 최소 1개 이상의 수를 선택하여 그 합이 K가 되는 경우의 수를 구하자.
 *
 * 조건
 * 주어지는 자연수의 개수 N(1 ≤ N ≤ 20)
 * 자연수의 합으로 만들어야 되는 수 K(1 ≤ K ≤ 1000)
 * 주어지는 각 자연수의 범위는 1이상 100이하
 * 
 * 풀이
 * 1. N크기의 int배열을 만들어서 주어지는 자연수를 저장하자.
 * 2. 재귀 호출을 통해 0번부터 N-1번까지 각 수를 사용할 때, 안 할 때를 고려해보자. (부분집합)
 * 3. 기저조건에 도달했을 때 사용하기로 한 수들의 합을 구해서 그 합이 K이면 경우의 수를 1 증가시키자.
 * 
 * 2-1. 1개부터 N개의 자연수를 사용할 때의 경우를 고려해보자. (조합)
 * 3-1. 현재 조합하기로 한 개수만큼의 수를 뽑았다면, 뽑은 수들의 합을 구하자.
 */

public class SWEA_2817_부분수열의합_변지혜_조합 {
	
	static int numCnt, conditionSum, count;
	static int[] num;
	static boolean[] used;
	
	private static void dfs(int start, int depth, int maxDepth) {
		// N개의 수에 대해 각 수를 사용할 지 말 지 깊이탐색을 통해 정해보자
		
		// 기저조건
		if (depth == maxDepth) {
			// N개의 수에 대해 각 수를 사용할 지 말 지 정했다면,
			// 현재 사용하기로한 수들의 합이 K인지 확인해보자
			checkSum();
			return;
		}
		
		for (int idx = start; idx < numCnt; idx++) {
			if (used[idx]) continue;
			used[idx] = true; // 현재 수를 조합에 사용한다고 하고
			dfs(idx + 1, depth + 1, maxDepth); // 다음 수를 확인하러 가자
			used[idx] = false; // 사용이 끝났으면 다시 미사용 상태로 돌려주자
		}
	}
	
	private static void checkSum() {
		// 현재 사용하기로 한 수들의 합이 K인지 확인해보자
		
		int sum = 0; // 현재 사용하기로 한 수들의 합을 저장할 공간
		
		// 모든 수를 확인해보자
		for (int cnt = 0; cnt < numCnt; cnt++) {
			if (!used[cnt]) continue; // 사용안하기로 한 수면 다음 수를 확인하자
			sum += num[cnt]; // 사용하기로 한 수면 수들의 합에 더해주자
		}
		
		// 사용하기로 한 모든 수의 합이 K라면
		if (sum == conditionSum)
			count++;
		return;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int testCase = sc.nextInt(); // 테스트케이스 개수 입력
		
		// 테스트케이스 개수만큼 반복 실행
		for (int tc = 1; tc <= testCase; tc++) {
			sb.append("#").append(tc).append(" "); // 출력 양식
			
			numCnt = sc.nextInt(); // 입력되는 자연수의 개수 N
			conditionSum = sc.nextInt(); // 자연수들의 합으로 만들어야 되는 수 K
			
			num = new int[numCnt]; // N개의 자연수를 저장할 배열 공간
			used = new boolean[numCnt]; // N개의 자연수에 대해 각 수를 사용할 지 말 지 여부를 저장해줄 boolean 배열
			
			// N개의 자연수를 배열에 차례대로 입력받자
			for (int cnt = 0; cnt < numCnt; cnt++) {
				num[cnt] = sc.nextInt();
			}
			
			count = 0; // 자연수의 합이 K가 되는 경우의 수를 저장할 공간
			
			// 조합
			for (int cnt = 1; cnt <= numCnt; cnt++) {
				dfs(0, 0, cnt); // N개의 자연수에 대해 각 수를 사용할 지 말 지 결정해보자
				// 1개의 수를 사용할 때 부터 전체 수를 사용할 때 까지의 경우를 고려해보자
			}
			
			// 깊이우선탐색을 통해 자연수의 합이 K가 되는 경우의 수를 카운트해줬으니,
			// 카운트를 출력하자
			sb.append(count).append("\n");
		}
		
		System.out.println(sb); // 출력
	}

}
