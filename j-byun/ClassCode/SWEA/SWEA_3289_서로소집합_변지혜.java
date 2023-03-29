import java.util.Scanner;

/**
 * @author jhye.byun
 * SWEA 3289 서로소 집합 D4 그래프
 * 
 * 문제
 * 1~n이 초기에 각각 n개의 집합을 이루고 있다.
 * 여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.
 * 연산을 수행하는 프로그램을 작성하자.
 * 
 * 조건
 * 정점의 개수 n(1≤n≤1,000,000)
 * 연산의 개수 m(1≤m≤100,000)
 * 
 * 풀이
 * 1. 랭크와 Path compression을 적용해서 union find set을 만들어보자.
 */

public class SWEA_3289_서로소집합_변지혜 {
	
	static int[] parentList, rankList;
	
	public static void make(int nodeCnt) {
		// 유일한 멤버 idx를 포함하는 새로운 집합을 생성하는 연산
		
		// 각 노드의 부모 노드를 저장할 배열 공간을 만들자
		parentList = new int[nodeCnt + 1];
		// 각 노드의 랭크를 저장할 배열 공간을 만들자
		rankList = new int[nodeCnt + 1];
		
		for (int idx = 0; idx <= nodeCnt; idx++) {
			parentList[idx] = idx; // 내가 나의 부모가 된다
			rankList[idx] = 0; // 초기 랭크 0
		}
	}
	
	public static int find(int element) {
		// 어떤 놈이 들어왔을 때, 이 친구의 부모를 찾아주자
		
		// 만약에 내가 그대로 부모면? 그대로 리턴
		if (parentList[element] == element)
			return element;
		
		// 내가 부모가 아니라면?
		// 내 부모를 찾아 떠나자!
		// Path compression 적용
		return parentList[element] = find(parentList[element]);
	}
	
	public static void union(int element1, int element2) {
		// x와 y의 무리를 합치자
		
		// 합치기 전에 먼저 각자의 부모를 찾자
		int e1Parent = find(element1);
		int e2Parent = find(element2);
		
		// e1의 부모와 e2의 부모가 같다면
		// 같은 집합 / 사이클이 만들어졌다
		// 똑같으면 합쳐줄 이유가 없다.
		if (e1Parent == e2Parent)
			return;
		
		// 서로 다른 부모를 가지고 있다면?
		// 이제 두 무리를 합쳐주자
		// 묶어줄 때, 랭크를 사용하자
		// 랭크 : 어떤 놈이 더 큰지 확인
		if (rankList[e1Parent] > rankList[e2Parent])
			// 합친다 : 부모를 바꿔준다는 것
			parentList[e2Parent] = e1Parent;
		
		else {
			// 작은 놈도 있고 동일한 친구도 있다
			parentList[e1Parent] = e2Parent;
			
			// 동일한 친구라면 랭크 1 증가
			if (rankList[e1Parent] == rankList[e2Parent])
				rankList[e2Parent]++;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt(); // 테케 개수 입력받기
		
		for (int tc = 1; tc <= testCase; tc++) { // 테케 개수만큼 반복 실행
			StringBuilder sb = new StringBuilder();
			
			int nodeCnt = sc.nextInt(); // 정점의 개수 입력받기
			
			// 일단 모든 정점을 단독 집합으로 만들자
			make(nodeCnt);
			
			int operCnt = sc.nextInt(); // 연산의 개수 입력받기
			
			// 연산 정보를 입력받자
			for (int cnt = 0; cnt < operCnt; cnt++) {
				int oper = sc.nextInt(); // 연산의 종류
				int x = sc.nextInt(); // 정점1
				int y = sc.nextInt(); // 정점2
				
				// 0번 연산이 입력되면 x와 y가 있는 집합을 통합시키자
				if (oper == 0)
					union(x, y);
				
				// 1번 연산이 입력되면 x의 루트노드와 y의 루트노드가 같은지 확인하자
				else {
					int rootX = find(x);
					int rootY = find(y);
					
					// 같으면 1, 다르면 0 출력
					if (rootX == rootY) sb.append('1');
					else sb.append('0');
				}
			}
			
			// 모든 연산이 끝났다면 stringBuilder에 저장된 결과 문자열을 출력하자
			System.out.printf("#%d %s\n", tc, sb.toString());
		}
	}
}
