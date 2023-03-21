
/**
 * @author jhye.byun
 * 순열 알고리즘
 * 
 * 김밥에 넣을 재료를 조합해보자.
 */

public class 순열_변지혜 {
	
	static String[] topping = new String[] {"참치", "김치", "치즈", "야채"}; // 김밥 재료 배열
	static int toppingCnt = topping.length; // 재료의 개수
	static boolean[] used; // 각 재료의 사용 여부를 체크할 boolean 배열
	static String[] per; // 순서대로 뽑은 재료를 저장해둘 공간
	
	private static void comb(int depth, int maxDepth) {
		// 재료를 조합해보자
		
		// 기저조건
		if (depth == maxDepth) {
			// 재료의 개수만큼 다 확인했으면 현재 사용한 재료를 출력하자
			String result = "";
			for (int idx = 0; idx < depth; idx++) {
				result += per[idx]; // 사용한 재료는 출력할 문자열에 추가
			}
			System.out.println(result);
			return;
		}
		
		for (int idx = 0; idx < toppingCnt; idx++) {
			if (used[idx]) continue; // 만약 현재 재료가 이미 사용됐으면 다음 재료를 확인하자
			// 현재 재료가 사용되지 않았으면 사용해주자
			per[depth] = topping[idx];
			used[idx] = true; // 현재 재료를 사용한 상태로
			comb(depth + 1, maxDepth);  // 다음 재료를 확인하자
			used[idx] = false; // 확인이 끝났으면 다시 현재 재료를 미사용 상태로 만들어주자
		}
	}
	
	public static void main(String[] args) {
		
		used = new boolean[toppingCnt];
		per = new String[toppingCnt];
		
		// 재료를 1개만 사용할 때, 2개 사용할 때, ... 전체 재료를 다 사용할 때 까지 확인해보자
		for (int cnt = 1; cnt <= toppingCnt; cnt++) {
			comb(0, cnt); // 순열을 구해보자
		}
	}

}
