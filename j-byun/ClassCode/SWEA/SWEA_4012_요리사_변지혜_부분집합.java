import java.util.Scanner;

/**
 * @author jhye.byun
 * SWEA 4012 요리사 부분집합/조합
 * 
 * 문제
 * N개의 식재료를 동일한 개수인 N/2개씩 사용해서 두 요리를 한다. (N은 짝수)
 * 이 때 두 요리의 맛 점수 차이가 최소가 되도록 재료를 배분하자.
 * 서로 다른 두 식재료가 조합되면 시너지 맛 점수가 발생한다.
 * 두 음식의 맛 차이가 최소가 될 때, 그 차이를 출력하자.
 *
 * 조건
 * 식재료의 수 N은 4이상 16이하의 짝수
 * 시너지 Sij는 1이상 20,000이하의 정수 (int범위 내에서 해결 가능)
 * i와 j가 서로 같은 경우의 Sij값은 정의되지 않는다. 입력에서는 0으로 주어진다.
 * 
 * 풀이
 * 1. N개의 식재료 중 N/2개를 뽑는 조합을 만들어보자.
 * 2. 사용하기로한 N/2개의 true 재료와 사용하지 않기로한 N/2개의 false 재료로 구분하자.
 * 3. 두 개의 재료 집합에서 다시 2개의 재료만 뽑는 조합을 만들어 보자.
 * 3-1. 이 때 뽑아진 조합의 시너지 점수를 각각 true재료의 시너지 점수 합, false재료의 시너지 점수 합에 더해주자.
 * 4. 2개의 재료만 뽑는 모든 조합을 확인한 후 true와 false 시너지 점수 합의 차이를 구해서
 * 4-1. 지금까지의 차이보다 작은 값이면 업데이트 해주자.
 * 
 * => 시너지12와 시너지21이 다르다!!!
 * 그렇다면 2개의 재료 조합을 뽑아서 시너지12와 시너지21을 다 시너지 점수 합에 더해주자!
 */

public class SWEA_4012_요리사_변지혜_부분집합 {
	
	static int foodCnt, minGap, sumTrue, sumFalse;
	static int[][] synergy;
	static boolean[] used, used2;
	static int[] trueFood, falseFood;
	
	private static void comb(int start, int depth, int maxDepth) {
		// N개의 재료 중 N/2개의 재료를 뽑아보자
		
		// 기저조건
		if (depth == maxDepth) {
			// N/2개의 재료를 다 뽑았다면
			// 두 개로 분류된 재료들의 시너지 점수를 확인해보자
			
			// N개의 재료를 2개의 그룹으로 나누자
			int trueIdx = 0, falseIdx = 0;
			for (int idx = 0; idx < foodCnt; idx++) {
				if (used[idx])
					trueFood[trueIdx++] = idx;
				else
					falseFood[falseIdx++] = idx;
			}
			
			// 두 그룹에서 각각 2개씩의 재료 조합을 뽑아 시너지 점수의 합을 구해보자
			sumTrue = 0; // true 재료 그룹의 시너지 합 초기화
			sumFalse = 0; // false 재료 그룹의 시너지 합 초기화
			used2 = new boolean[foodCnt / 2]; // 각 재료를 확인했는지 나타낼 boolean 배열
			checkSynergy(0, 0, 2); // 2개의 재료를 뽑아서 확인하자
			
			// 시너지의 합을 다 구했다면 그 차를 확인해서 최솟값으로 업데이트 해주자
			minGap = Math.min(minGap, Math.abs(sumTrue - sumFalse));
			return;
		}
		
		if (start == foodCnt)
			return;
		
		comb(start + 1, depth, maxDepth);
		used[start] = true; // 아직 사용하지 않은 재료라면 사용하자
		comb(start + 1, depth + 1, maxDepth);
		used[start] = false; // 사용 끝났으면 미사용 상태로 돌려주자
		
	}
	
	private static void checkSynergy(int start, int depth, int maxDepth) {
		// true 재료와 false 재료들의 시너지 점수를 구해서 그 차이를 확인하자
		
		// 기저조건
		if (depth == maxDepth) {
			// 확인할 두 개의 수를 정했다면,
			// 두 수를 찾아주자
			int[] food = new int[2];
			int foodIdx = 0;
			
			for (int idx = 0; idx < foodCnt / 2; idx++) {
				if (!used2[idx]) continue;
				food[foodIdx++] = idx; // true로 표시된 수를 배열에 저장
			}
			
			// 현재 확인한 조합의 시너지 점수를 sum에 더해주자
			sumTrue += synergy[trueFood[food[0]]][trueFood[food[1]]];
			sumTrue += synergy[trueFood[food[1]]][trueFood[food[0]]];
			sumFalse += synergy[falseFood[food[0]]][falseFood[food[1]]];
			sumFalse += synergy[falseFood[food[1]]][falseFood[food[0]]];
			return;
		}
		
		if (start == foodCnt / 2)
			return;
		
		// 두 개의 조합 만들기
		checkSynergy(start + 1, depth, maxDepth);
		used2[start] = true;
		checkSynergy(start + 1, depth + 1, maxDepth);
		used2[start] = false;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int testCase = sc.nextInt(); // 테스트케이스 개수 입력
		
		// 테스트케이스 개수만큼 반복 실행
		for (int tc = 1; tc <= testCase; tc++) {
			sb.append("#").append(tc).append(" "); // 출력 양식
			
			foodCnt = sc.nextInt(); // 식재료의 수 N
			synergy = new int[foodCnt][foodCnt]; // 식재료 조합에 따른 시너지 점수를 저장할 공간
			used = new boolean[foodCnt];// 각 재료의 사용여부를 나타낼 boolean 배열
			trueFood = new int[foodCnt / 2]; // true 그룹에 들어간 재료를 저장할 공간
			falseFood = new int[foodCnt / 2]; // false 그룹에 들어간 재료를 저장할 공간
			
			// 시너지 점수를 입력받자
			for (int row = 0; row < foodCnt; row++) {
				for (int col = 0; col < foodCnt; col++) {
					synergy[row][col] = sc.nextInt();
				}
			}
			
			minGap = Integer.MAX_VALUE;
			comb(0, 0, foodCnt / 2); // N/2개의 재료 조합을 만들 수 있는 모든 경우의 수를 확인해보자
			
			// 깊이우선탐색을 통해 시너지 합의 차가 최소가 되는 경우를 확인했으니,
			// 최소 차이를 출력하자
			sb.append(minGap).append("\n");
		}
		
		System.out.println(sb); // 출력
	}

}
