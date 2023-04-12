import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author jhye.byun
 * SWEA 1238 Contact D4 그래프
 * 
 * 문제
 * 비상연락망과 연락을 시작하는 당번에 대한 정보가 주어질 때,
 * 가장 나중에 연락을 받게 되는 사람 중 번호가 가장 큰 사람을 구하는 함수를 작성하시오.
 * 유향 그래프이다.
 * 
 * 조건
 * 연락 인원은 최대 100명
 * 부여될 수 있는 번호는 1이상 100이하
 * 중간에 비어있는 번호가 있을 수 있다.
 * 가중치는 모두 1로 동일하다.
 * 연락을 받을 수 없는 사람도 존재할 수 있다.
 * 
 * 풀이
 * <다익스트라 알고리즘>
 * 시작 정점에서 거리가 최소인 정점을 선택해 나가면서 최단경로를 구하는 방식
 * 1. 시작 정점을 입력받는다.
 * 2. 거리를 저장할 배열을 INF로 초기화 한 후 시작점에서 갈 수 있는 곳의 값은 바꿔놓는다.
 * 3. 아직 방문하지 않은 점들이 가지고 있는 거리 값과 현재 정점에서 방문하지 않은 정점까지의 가중치의 합이 작다면 변경하여 적는다.
 * 4. 모든 정점을 방문할 때까지 반복
 */

public class SWEA_1238_Contact_변지혜 {
	
	static final int INF = 987654321;
	static int peopleCnt = 100;
	static List<Edge>[] adjList;
	static int[] dist;
	static boolean[] visited;
	
	public static void dijkstra(int start) {
		// start 노드부터 시작해서 각 정점에 도착하는 최단시간을 구해보자
		
		// 가중치 순서대로 정렬해줄 우선순위 큐
		// 현재 문제에서는 모든 가중치가 1이기 때문에 불필요하지만 연습해보자~
//		PriorityQueue<Edge> pq = new PriorityQueue<>();
		// 우선순위 큐 : 레드블랙 트리 => 넣은 순서가 유지되지 않음
		// => 그래서 우선순위 큐로 구현 불가
		Queue<Edge> pq = new LinkedList<>(); // 그냥 큐에 넣자...
		
		// 해당 정점을 방문했는지 여부를 나타낼 boolean 배열
		visited = new boolean[peopleCnt + 1];
		
		// 시작 노드의 시간은 0으로 초기화
		dist[start] = 0;
		// 시작 노드 방문 여부 true로 바꾸기
		visited[start] = true;
		
		// 시작노드와 인접한 노드들을 큐에 넣어주자
		for (Edge e : adjList[start]) {
			if (visited[e.e]) continue;
			pq.add(e);
		}
		
		// 큐에 넣은 애들 다 확인하자
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if (visited[curr.e]) continue;
			visited[curr.e] = true;
			
			// 출발 정점의 거리 + 출발 정점부터 도착 정점까지의 거리를 저장해주자
			dist[curr.e] = dist[curr.s] + curr.w;
			
			for (Edge e : adjList[curr.e]) {
				if (visited[e.e]) continue;
				pq.add(e);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) { // 테케 10개만큼 반복
			
			int edgeCnt = sc.nextInt() / 2; // 간선의 개수
			int startNode = sc.nextInt(); // 시작 정점 번호
			
			// 1~100번까지의 정점에 대해 인접 정점 정보를 저장할 공간을 만들자
			adjList = new ArrayList[peopleCnt + 1];
			
			// 배열에 값을 넣기 위해 공간을 먼저 만들어줘야 한다
			for (int idx = 1; idx <= peopleCnt; idx++)
				adjList[idx] = new ArrayList<>();
			
			// 간선 정보를 입력받아서 인접 리스트에 정보를 넣어주자
			for (int cnt = 0; cnt < edgeCnt; cnt++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				
				adjList[start].add(new Edge(start, end, 1));
				// 가중치는 1로 저장하자
			}
			
			// 각 사람이 전화를 받는 시간을 저장할 배열 공간을 만들자
			dist = new int[peopleCnt + 1];
			
			// 무한수로 배열 초기화
			Arrays.fill(dist, INF);
			
			dijkstra(startNode); // 다익스트라 알고리즘으로 각 노드에 도착하는 시간을 찾아보자
			
			// 시작 정점에서 도달할 수 있는 모든 정점을 확인했다면,
			// 가장 마지막에 도착하는 정점 중 정점 번호가 가장 큰 값을 찾아내자
			int maxDist = -1;
			int maxIdx = -1;
			for (int idx = 1; idx <= peopleCnt; idx++) {
				if (dist[idx] != INF && dist[idx] >= maxDist) {
					maxDist = dist[idx];
					if (idx > maxIdx)
						maxIdx = idx;
				}
			}
			
			// 마지막 사람 출력
			System.out.printf("#%d %d\n", tc, maxIdx);
		}
	}
	
	public static class Edge{
		int s, e, w; // 시작-도착 정점과 가중치 저장
		
		public Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
	}
//	public static class Edge implements Comparable<Edge>{
//		int s, e, w; // 시작-도착 정점과 가중치 저장
//
//		public Edge(int s, int e, int w) {
//			this.s = s;
//			this.e = e;
//			this.w = w;
//		}
//		
//		// 가중치 순서대로 정렬
//		@Override
//		public int compareTo(Edge o) {
//			// TODO Auto-generated method stub
//			return this.w - o.w;
//		}
//	}
}
