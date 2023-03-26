import java.util.Scanner;


/**
 * @author jhye.byun
 * SWEA 1486 장훈이의 높은 선반 D4 백트래킹
 * 
 * 문제
 * 높이가 B인 선반을 사용하기 위해 N명의 사람을 타고타고 올라가자.
 * 각 사람의 키의 합이 탑이 높이이다.
 * 높이가 너무 높아지면 위험하니까 높이가 B이상이면서 가장 낮은 탑을 찾아보자.
 * 
 * 조건
 * 사람의 수 N(1 ≤ N ≤ 20)
 * 선반의 높이 B(1 ≤ B ≤ S)
 * S : 모든 사람의 키의 합
 * 각 사람의 키 Hi (1 ≤ Hi ≤ 10,000)
 * 
 * 풀이
 * 1. int범위 내에서 해결 가능
 * 2. N크기의 배열에 각 사람의 키를 저장하자.
 * 3. 각 사람을 사용할지 안할지 판단하는 부분집합을 만들자.
 * 4. 부분집합 메소드의 파라미터로 지금까지 사용한 사람의 키의 합을 넘겨주자.
 * 5. 재귀의 깊이가 증가할 때 마다 지금까지의 키의 합이 선반의 높이보다 높아졌는지 확인해보고,
 * 6. 선반 높이보다 높아졌으면 선반의 높이 이상 값 중 최솟값을 찾아서 업데이트 해주자.
 * 7. 업데이트 후 더 이상 깊이를 증가시키지 말고 반환해버리자.
 * 7-1. 어차피 선반 높이 이상 값 중 최솟값을 찾아야 하기 때문에 이후 값들은 모두 사용하지 않는다고 가정해버리는 것이다.
 * 8. 모든 사람을 사용하지 않을 경우를 위해 재귀의 깊이가 사람 수 만큼 되면 반환하는 조건을 넣어주자.
 */

public class SWEA_1486_장훈이의높은선반_변지혜 {
	
	static int peopleCnt, conditionHeight, minHeight;
	static int[] people;
	static boolean[] used;
	
	private static void backtracking(int depth, int sumHeight) {
		
		// 현재까지의 부분집합이 이미 선반 높이를 넘었다면,
		// 다음 사람들은 모두 사용하지 않는다고 가정하고 재귀를 종료하자
		// => 유망성이 없는 가지를 잘라버림 = 백트래킹
		// 어차피 우리가 필요한건 조건을 만족하는 키의 합 중 최솟값이기 때문에
		if (sumHeight >= conditionHeight) {
			minHeight = Math.min(minHeight, sumHeight);
			return;
		}
		
		// 기저조건
		// 모든 사람의 사용여부를 다 확인했으면 재귀 종료
		if (depth == peopleCnt) {
			return;
		}
		
		// 현재 사람을 사용하지 말고 다음 사람의 사용여부를 확인하자
		backtracking(depth + 1, sumHeight);
		used[depth] = true;
		// 현재 사람을 사용하고 다음 사람의 사용여부를 확인하자
		backtracking(depth + 1, sumHeight + people[depth]);
		used[depth] = false;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기
		
		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복
			sb.append("#").append(tc).append(" ");
			
			peopleCnt = sc.nextInt(); // 사람의 수 N 입력받기
			conditionHeight = sc.nextInt(); // 선반의 높이 B 입력받기
			minHeight = Integer.MAX_VALUE; // 선반의 높이보다 높은 탑 중 최솟값을 저장할 공간
			
			people = new int[peopleCnt]; // 각 사람의 키를 저장할 공간
			used = new boolean[peopleCnt]; // 각 사람을 사용했는지 여부를 저장할 boolean배열
			
			// 사람들의 키를 입력받자
			for (int cnt = 0; cnt < peopleCnt; cnt++) {
				people[cnt] = sc.nextInt();
			}
			
			// 백트래킹으로 각 사람을 사용할 때, 안 할 때를 고려해보자
			backtracking(0, 0);
			
			// 백트래킹을 통해 각 사람을 사용할지 말지 여부를 다 확인했으니,
			// 사람탑의 높이가 선반 높이 이상인 경우 중 최솟값과 선반 높이의 차를 출력하자
			sb.append(minHeight - conditionHeight).append("\n");
		}
		
		System.out.println(sb); // 출력
	}

}
