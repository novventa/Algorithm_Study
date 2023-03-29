import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author jhye.byun
 * SWEA 1251 하나로 D4 그래프
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
 * <크루스칼 알고리즘>
 * - 간선을 하나씩 선택해서 MST를 찾는 알고리즘
 * 1. 모든 간선을 가중치에 따라 오름차순으로 정렬
 * 2. 가중치가 가장 낮은 간선부터 선택하면서 트리를 증가시킴
 * 2-1. 사이클이 된다면, 다음으로 가중치가 낮은 간선 선택
 * 3. N개의 정점이니까.. N-1개의 간선이 선택될 때까지 2번을 반복 진행
 */

public class SWEA_1251_하나로_변지혜 {
	
	static int[] parent, rank;
	
	public static void make(int size) {
		// 각 섬들을 단독집합으로 만들어주자
		
		parent = new int[size + 1];
		rank = new int[size + 1];
		
		for (int idx = 0; idx <= size; idx++) {
			parent[idx] = idx; // 내가 나의 부모가 된다
			rank[idx] = 0; // 초기 랭크 0
		}
	}
	
	public static int find(int element) {
		// 나의 부모(루트)를 찾아서 반환해주자
		
		if (parent[element] == element) return parent[element];
		return parent[element] = find(parent[element]);
	}
	
	public static void union(int element1, int element2) {
		// 두 그룹을 합치자
		
		int element1P = find(element1);
		int element2P = find(element2);
		
		// 이미 그룹으로 묶인 애들이면 묶지마
		if (element1P == element2P) return;
		
		// 그룹이 아니면 묶어주는데
		// 랭크가 더 높은애 밑으로 들어가자
		if (rank[element1P] > rank[element2P])
			parent[element2P] = element1P;
		
		else {
			parent[element1P] = element2P;
			
			// 랭크가 같으면 랭크를 하나 증가시켜 주자
			if (rank[element1P] == rank[element2P])
				rank[element2P]++;
		}
	}
	
	public static double calcDis(int x1, int x2, int y1, int y2) {
		double dx = x1 - x2;
		double dy = y1 - y2;
		
		return dx * dx + dy * dy;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for (int tc = 1; tc <= testCase; tc++) {
			
			int islandCnt = sc.nextInt(); // 섬의 개수
			
			int[] xs = new int[islandCnt + 1]; // 섬의 x좌표를 저장할 공간
			
			// x좌표들을 입력받자
			for (int idx = 1; idx <= islandCnt; idx++) {
				xs[idx] = sc.nextInt();
			}
			
			int[] ys = new int[islandCnt + 1]; // 섬의 y좌표를 저장할 공간
			
			// y좌표들을 입력받자
			for (int idx = 1; idx <= islandCnt; idx++) {
				ys[idx] = sc.nextInt();
			}
			
			// 입력받은 좌표들을 가중치 순서대로 배열에 넣어주는데...
			// 가중치는 어떻게 계산할 것인가?
			// 섬 하나를 골랐을 때 그 섬에서 갈 수 있는 모든 섬에 대한 거리를 계산해서 다 넣어주자
			// 순열이 아니기 때문에 한 섬에서 갈 수 있는 섬 중 더 큰 번호의 섬만 계산하자
			// 어차피 union set할 때 랭크가 더 높은 섬이 루트가 될거니 순열로 고려하지 않아도 된다
			
			// 간선 정보와 가중치(거리)를 저장할 공간을 만들어주자
			ArrayList<Edge> edges = new ArrayList<>();
			
			// 리스트에 두 섬의 번호와 거리를 저장하자
			for (int island1 = 1; island1 <= islandCnt; island1++) {
				for (int island2 = island1 + 1; island2 <= islandCnt; island2++) {
					edges.add(new Edge(island1, island2, calcDis(xs[island1], xs[island2], ys[island1], ys[island2])));
				}
			}
			
			// 크루스칼 1단계 : 간선을 오름차순 정렬한다.
			// 리스트를 환경 부담금이 적은 순서대로 정렬하자
			edges.sort((o1, o2) -> {
				if (o1.dis > o2.dis) return 1;
				else if (o1.dis < o2.dis) return -1;
				else return 0;
			});
			
//			edges.sort((o1, o2) -> {
//				if (o1.dis == o2.dis) {
//					if (o1.island1 == o2.island1)
//						return o1.island2 - o2.island2;
//					return o1.island1 - o2.island1;
//				}
//				return (int) (o1.dis - o2.dis);
//			});
			
			// 크루스칼 2단계 : 섬의 개수 -1개의 간선을 뽑는데, 사이클이 발생하지 않는 친구들로만 뽑자
			
			// 환경 부담 세율 실수를 입력받자
			double E = sc.nextDouble();
			
			// 각 섬에 대한 단독 집합을 만들어주자
			make(islandCnt);
			
			double minFee = 0; // 최소 거리를 저장할 변수를 만들자
			int pickCnt = 0; // 내가 뽑은 간선의 개수를 저장할 변수를 만들자
			
			// 모든 간선을 순회하면서 확인해보자
			int edgeCnt = edges.size();
			for (int idx = 0; idx < edgeCnt; idx++) {
				// idx번째 간선을 뽑아 두 정점의 대표를 확인하자
				Edge cur = edges.get(idx);
				int island1 = cur.island1;
				int island2 = cur.island2;
				
				// 이미 그룹으로 묶인 섬은 묶을 수 없다
				if (find(island1) == find(island2))
					continue;
				
				// 그룹으로 묶이지 않은 섬이라면 묶어주자
				union(island1, island2);
				minFee += (E * cur.dis);
				pickCnt++;
				
				// 전체 섬을 연결했다면 탐색 중지
				if (pickCnt == islandCnt - 1)
					break;
			}
			
			// 지금까지 찾은 최소 환경 부담금을 출력하자
			System.out.printf("#%d %.0f\n", tc, minFee);
		}
	}
	
	// 간선 정보를 한 번에 저장하기 위해 edge 클래스를 만들어서 사용하자
	public static class Edge {
		int island1, island2;
		double dis;
		
		public Edge(int island1, int island2, double dis) {
			this.island1 = island1;
			this.island2 = island2;
			this.dis = dis;
		}
	}
}
