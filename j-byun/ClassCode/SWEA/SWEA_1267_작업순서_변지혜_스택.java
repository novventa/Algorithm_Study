import java.util.Scanner;
import java.util.Stack;

/**
 * @author jhye.byun
 * SWEA 1267 작업순서 D6 위상정렬-Stack
 * 
 * 문제
 * 해야 할 V개의 작업이 있다.
 * 이들 중 어떤 작업은 특정 작업이 끝나야 시작할 수 있다.
 * 이 그래프에서 사이클은 존재하지 않는다.
 * 선행 관계를 지키며 일을 끝낼 수 있는 작업 순서를 찾자.
 * 가능한 작업 순서가 여러 가지일 경우, 하나만 제시하면 된다.
 * 
 * 조건
 * 테스트케이스 10개
 * 그래프의 정점의 개수 V(3 ≤ V ≤ 1000)
 * 간선의 개수 E(2 ≤ E ≤ 3000)
 * 정점의 번호는 1부터 V까지의 정수값을 가진다.
 * 
 * 풀이
 * 1. 위상정렬을 스택으로 구현하자.
 */

public class SWEA_1267_작업순서_변지혜_스택 {
	
	static int vertexCnt;
	static boolean[] visited;
	static int[][] adjArr;
	static Stack<Integer> result;
	
	public static void topologicalSorting(int vertex) {
		
		// 내 방문 여부를 true로 바꿔주자
		visited[vertex] = true;
		
		// 나와 인접한 노드 중 아직 방문하지 않은 노드를 찾아서 dfs를 실행해주자
		for (int idx = 1; idx <= vertexCnt; idx++) {
			if (visited[idx]) continue;
			if (adjArr[vertex][idx] != 1) continue;
			topologicalSorting(idx);
		}
		
		// 인접노드 탐색이 끝났다면 내 할 일을 다했으니 결과 스택에 저장해주자
		result.push(vertex);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 10개만큼 반복 실행
		for (int tc = 1; tc <= 10; tc++) {
			
			vertexCnt = sc.nextInt(); // 정점의 개수 입력받기
			int edgeCnt = sc.nextInt(); // 간선의 개수 입력받기
			
			// 두 작업의 연결 관계를 저장할 인접 행렬을 만들자
			adjArr = new int[vertexCnt + 1][vertexCnt + 1];
			
			// 초기 진입 차수가 0인 노드만 찾아주기 위해 진입 차수를 나타낼 배열을 boolean형으로 만들자
			boolean[] indegree = new boolean[vertexCnt + 1];
			
			// 간선의 개수만큼 간선 정보를 입력받자
			for (int cnt = 0; cnt < edgeCnt; cnt++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				
				adjArr[start][end] = 1; // 인접 행렬 업데이트
				indegree[end] = true; // 진입 차수가 존재하면 true로 바꿔주자
				
			}
			
			// 각 노드의 방문 여부를 저장할 boolean 배열을 만들어주자
			visited = new boolean[vertexCnt + 1];
			
			// 수행 결과를 거꾸로 저장할 스택을 만들어주자
			result = new Stack<>();
			
			// 초기 진입 차수가 0인 노드들에 대해 dfs를 실행해주자
			for (int idx = 1; idx <= vertexCnt; idx++) {
				if (indegree[idx]) continue;
				topologicalSorting(idx);
			}
			
			// 위상정렬이 끝났다면 스택에 거꾸로 저장된 결과를 뒤집어서 출력하자
			StringBuilder sb = new StringBuilder();
			
			while (!result.isEmpty()) {
				sb.append(result.pop()).append(" ");
			}
			
			System.out.printf("#%d %s\n", tc, sb);
		}
	}
	
}
