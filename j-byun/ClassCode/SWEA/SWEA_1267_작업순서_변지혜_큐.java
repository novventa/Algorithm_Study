import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author jhye.byun
 * SWEA 1267 작업순서 D6 위상정렬-Queue
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
 * 1. 위상정렬을 큐로 구현하자.
 */

public class SWEA_1267_작업순서_변지혜_큐 {
	
	static int vertexCnt;
	static int[][] adjArr;
	static int[] indegree;
	
	public static String topologicalSorting() {
		// 위상정렬 과정을 큐로 구현해보자
		
		// 진입차수가 0인 노드를 저장할 큐 공간을 만들자
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		// 큐에서 뽑아낸 노드들을 차례대로 저장할 스트링빌더를 만들자
		StringBuilder sb = new StringBuilder();
		
		// 초기 진입차수가 0인 노드들을 노드 번호가 작은 순서대로 큐에 넣자
		for (int idx = 1; idx <= vertexCnt; idx++) {
			if (indegree[idx] == 0)
				q.offer(idx);
		}
		
		// 큐가 빌 때까지 반복 진행
		while (!q.isEmpty()) {
			int curr = q.poll(); // 대기 1번을 뽑아서 확인하자
			
			sb.append(curr).append(" "); // 뽑은 노드를 출력하고
			
			// 인접 행렬을 확인하며 현재 노드와 인접한 노드를 찾아보자
			// 인접한 노드를 발견했다면 해당 노드와 연결된 선을 끊자!
			// => 인접한 노드의 진입차수를 -1 시켜주자
			for (int idx = 1; idx <= vertexCnt; idx++) {
				if (adjArr[curr][idx] != 1) continue;
				
				indegree[idx]--; // 진입차수 -1
				// 만약 인접 정점의 진입차수가 0이 됐다면 해당 정점도 큐에 넣어주자
				if (indegree[idx] == 0)
					q.offer(idx);
			}
		}
		
		// 큐가 비었다면 진입 차수가 0이 된 모든 정점을 차례로 확인한 것이니,
		// 차례대로 저장된 스트링빌더를 문자열로 변환시켜서 반환하자
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 10개만큼 반복 실행
		for (int tc = 1; tc <= 10; tc++) {
			
			vertexCnt = sc.nextInt(); // 정점의 개수 입력받기
			int edgeCnt = sc.nextInt(); // 간선의 개수 입력받기
			
			// 두 작업의 연결 관계를 저장할 인접 행렬을 만들자
			adjArr = new int[vertexCnt + 1][vertexCnt + 1];
			
			// 각 정점의 진입차수를 나타낼 배열을 만들자
			indegree = new int[vertexCnt + 1];
			
			// 간선의 개수만큼 간선 정보를 입력받자
			for (int cnt = 0; cnt < edgeCnt; cnt++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				
				adjArr[start][end] = 1; // 인접 행렬 업데이트
				indegree[end]++; // 진입 차수 업데이트
			}
			
			// 입력이 끝났다면 위상정렬을 해보자
			System.out.printf("#%d %s\n", tc, topologicalSorting());
		}
	}
	
}
