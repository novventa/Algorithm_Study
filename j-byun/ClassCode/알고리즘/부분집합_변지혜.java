
/**
 * @author jhye.byun
 * 부분집합 알고리즘
 * 
 * 김밥에 넣을 재료를 조합해보자.
 */

public class 부분집합_변지혜 {
	
	static String[] topping = new String[] {"참치", "김치", "치즈", "야채"}; // 김밥 재료 배열
	static int toppingCnt = topping.length; // 재료의 개수
	static boolean[] used; // 각 재료의 사용 여부를 체크할 boolean 배열
	
	private static void comb(int depth) {
		// 재료를 조합해보자
		
		// 기저조건
		if (depth == toppingCnt) {
			// 재료의 개수만큼 다 확인했으면 현재 사용한 재료를 출력하자
			String result = "";
			for (int idx = 0; idx < toppingCnt; idx++) {
				if (!used[idx]) continue; // 사용안한 재료는 무시
				result += topping[idx]; // 사용한 재료는 출력할 문자열에 추가
			}
			System.out.println(result);
			return;
		}
		
		comb(depth + 1); // 현재 재료를 사용하지 않은 상태로 다음 재료를 확인하자
		used[depth] = true; // 현재 재료를 사용한 상태로
		comb(depth + 1); // 다음 재료를 확인하자
		used[depth] = false; // 확인이 끝났으면 다시 현재 재료를 미사용 상태로 만들어주자
	}
	
	public static void main(String[] args) {
		
		used = new boolean[toppingCnt];
		comb(0); // 부분집합을 구해보자
	}

}
