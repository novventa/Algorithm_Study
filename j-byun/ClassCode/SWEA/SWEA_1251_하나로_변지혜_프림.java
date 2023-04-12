import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author jhye.byun
 * SWEA 1251 하나로 D4 그래프-프림 알고리즘
 * 
 * 문제
 * N개의 섬들을 연결하자.
 * N개의 섬이 한 무리가 되어야 함. (간접 연결도 인정)
 * 환경 부담금 정책 : 환경 부담 세율(E)과 각 해저터널 길이(L)의 제곱의 곱(E * L^2)만큼 지불
 * 총 환경 부담금을 최소로 지불하게 설계하자.
 * 
 * 조건
 * 섬의 개수 N (1≤N≤1,000)
 * 섬의 X, Y 좌표 (0≤X≤1,000,000, 0≤Y≤1,000,000)
 * 해저터널 건설의 환경 부담 세율 실수 E (0≤E≤1)
 * 
 * 풀이
 * <프림 알고리즘>
 * 하나의 정점에서 연결된 간선들 중에 하나씩 선택하면서 MST를 만들어 가는 방식
 * 1. 임의 정점을 하나 선택해서 시작
 * 2. 선택한 정점과 인접하는 정점들 중 최소 비용의 간선이 존재하는 정점을 선택
 * 3. 모든 정점이 선택될 때 까지 1-2번 과정을 반복 진행
 */

public class SWEA_1251_하나로_변지혜_프림 {
	
	static int nodeCnt;
	static double E;
	static List<Edge>[] adjList;
	static PriorityQueue<Edge> pq;
	
	public static double prim() {
		
		// 각 섬의 방문 여부를 나타낼 공간을 만들자
		boolean[] visited = new boolean[nodeCnt];
		
		// 모든 간선의 정보를 우선순위 큐에 저장하자
		pq = new PriorityQueue<>();
		
		// 0번째 섬에서 시작하자
		visited[0] = true;
		
		int pickCnt = 1; // 고른 정점의 개수
		double maxFee = 0; // 환경 부담금을 저장할 공간
		
		// 시작 정점과 연결될 수 있는 모든 정점 정보를 우선순위 큐에 넣자
		for (Edge e : adjList[0])
			pq.add(e);
		
		// 섬의 개수 -1개 만큼 연결시켰다면 종료
		while (pickCnt < nodeCnt) {
			Edge curr = pq.poll();
			
			// 이미 우선순위 큐에서 뽑혀나와서 확인한 섬이면 확인하지 말자
			if (visited[curr.end]) continue;
			
			visited[curr.end] = true; // 방문처리하고
			maxFee += E * curr.weight; // 환경부담금을 계산해서 더해주고
			pickCnt++; // 연결함 섬의 개수를 1 증가시키자
			
			// 이제 현재 섬과 연결될 수 있는 모든 섬들을 확인하기 위해 우선순위 큐에 넣자
			for (Edge e : adjList[curr.end]) {
				if (visited[e.end]) continue;
				pq.offer(e);
			}
		}
		
		// 우선순위 큐를 활용해 확인한 최소 환경부담금을 반환하자
		return maxFee;
	}
	
	public static double getDis(double a, double b) {
		return a * a + b * b;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복 실행
			
			nodeCnt = sc.nextInt(); // 섬의 개수
			
			// 각 섬의 x좌표를 저장할 공간
			int[] xs = new int[nodeCnt];
			
			// x좌표 입력받기
			for (int idx = 0; idx < nodeCnt; idx++)
				xs[idx] = sc.nextInt();
			
			// 각 섬의 y좌표를 저장할 공간
			int[] ys = new int[nodeCnt]; 
			
			// y좌표 입력받기
			for (int idx = 0; idx < nodeCnt; idx++)
				ys[idx] = sc.nextInt();
			
			E = sc.nextDouble(); // 환경 부담 세율 실수 E 입력받기
			
			// 모든 정점이 인접될 수 있다고 가정하고 인접 정보를 저장할 공간을 만들자
			adjList = new ArrayList[nodeCnt];
			
			// 리스트 공간 초기화
			for (int idx = 0; idx < nodeCnt; idx++)
				adjList[idx] = new ArrayList<>();
			
			// 한 정점에서 모든 정점으로 갈 수 있는 경우를 확인하자
			for (int node1 = 0; node1 < nodeCnt; node1++) {
				for (int node2 = 0; node2 < nodeCnt; node2++) {
					if (node1 == node2) continue;
					adjList[node1].add(new Edge(node1, node2, getDis(xs[node1] - xs[node2], ys[node1] - ys[node2])));
				}
			}
			
			// 임의의 정점에서 탐색을 시작해서 반환된 최소 환경부담금을 출력하자
			System.out.printf("#%d %.0f\n", tc, prim());
		}
	}
	
	public static class Edge implements Comparable<Edge>{
		int start, end;
		double weight;
		public Edge (int start, int end, double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			if (this.weight > o.weight) return 1;
			else if (this.weight == o.weight) return 0;
			else return -1;
		}
	}
}
