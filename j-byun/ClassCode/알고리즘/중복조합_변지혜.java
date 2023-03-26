/**
 * @author jhye.byun
 * 중복조합 알고리즘
 * 
 * 김밥에 넣을 재료를 조합해보자.
 */

public class 중복조합_변지혜 {
	
	static String[] topping = new String[] {"참치", "김치", "치즈", "야채"}; // 김밥 재료 배열
	static int toppingCnt = topping.length; // 재료의 개수
	static String[] combResult; // 뽑은 조합 결과를 저장할 배열
	
	private static void comb(int start, int depth, int maxDepth) {
		// 재료를 조합해보자
		
		// 기저조건
		if (depth == maxDepth) {
			// 재료의 개수만큼 다 확인했으면 현재 사용한 재료를 출력하자
			String result = "";
			for (int idx = 0; idx < maxDepth; idx++) {
				result += combResult[idx]; // 사용한 재료는 출력할 문자열에 추가
			}
			System.out.println(result);
			return;
		}
		
		for (int idx = start; idx < toppingCnt; idx++) {
			combResult[depth] = topping[idx]; // 현재 재료를 사용한 상태로
			comb(idx, depth + 1, maxDepth);  // 다음 재료를 확인하자
			// 현재 사용한 재료도 중복 사용할 수 있으니 start를 idx부터로 재귀 호출하자
		}
	}
	
	public static void main(String[] args) {
		
		combResult = new String[toppingCnt];
		
		// 재료를 1개만 사용할 때, 2개 사용할 때, ... 전체 재료를 다 사용할 때 까지 확인해보자
		for (int cnt = 1; cnt <= toppingCnt; cnt++) {
			comb(0, 0, cnt); // 조합을 구해보자
		}
	}

}
