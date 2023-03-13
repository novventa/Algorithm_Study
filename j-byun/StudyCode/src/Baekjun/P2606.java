import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

// 2606 바이러스
// 실버3

// 문제
// 간선으로 연결된 모든 노드에 대해 전파되는 웜바이러스
// 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때,
// 1번 컴퓨터를 통해 웜바이러스에 걸리게 되는 컴퓨터의 수를 출력하시오

// 조건
// 컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.

// 풀이
// 1번을 통해 전파되는 컴퓨터의 수만 세어준다 => 1번은 세지 않음
// 컴퓨터의 수 * 컴퓨터의 수 크기의 인접행렬을 만들어서
// 간선으로 이어진 두 노드를 true로 표시하자
// 노드로 연결된 트리의 크기만큼 숫자만 세면 되니까 bfs가 더 효율적이다 (라는 나의 생각)

// 1번 노드와 연결된 노드를 대기열에 저장하면서 바이러스 감염된 컴퓨터 수를 +1 해준다

public class P2606 {
	
	static int nodeCnt, edgeCnt;
	static boolean[][] map;
	static boolean[] isInfectioned;
	
	static int virusCnt = 0; // 바이러스 감염된 컴퓨터 수를 저장할 공간
	
	public static void bfs() {
		// 너비 우선 탐색으로 네트워크로 연결된 컴퓨터에 바이러스를 감염시키자
		
		Queue<Integer> search = new ArrayDeque<>(); // 레벨이 낮은 순서대로 네트워크로 연결된 컴퓨터를 저장할 대기열
							// 큐를 활용할 때에는 ArrayDeque이 빠르다
		search.offer(1); // 1번 노드를 감염시키자
		isInfectioned[1] = true; // 1번 노드의 감염 여부를 true로 변경
		
		while (!search.isEmpty()) { // 대기열이 빌 때 까지 반복
			int cur = search.poll(); // 감염된 컴퓨터 대기열의 제일 앞 컴퓨터를 뽑아서 확인하자
			
			for (int idx = 1; idx <= nodeCnt; idx++) { // 인접행렬에서 현재 컴퓨터와 간선으로 연결된 컴퓨터가 있는지 확인해보자
				if (!map[cur][idx]) continue; // 간선으로 연결되지 않은 노드면 넘어가자
				if (isInfectioned[idx]) continue; // 이미 감염된 컴퓨터면 넘어가자
				
				// 간선으로 연결되어 있고 아직 감염되지 않음 컴퓨터를 찾았다면...
				search.offer(idx); // 감염될 컴퓨터 대기열에 넣어주자
				isInfectioned[idx] = true; // 대기열에 넣은 컴퓨터의 감염 여부를 true로 바꿔주자
				virusCnt++; // 감염된 컴퓨터 수 +1
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		nodeCnt = sc.nextInt(); // 컴퓨터의 수 입력받기 (노드 개수)
		edgeCnt = sc.nextInt(); // 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수 입력받기 (간선 개수)
		
		map = new boolean[nodeCnt + 1][nodeCnt + 1]; // 각 노드의 연결 여부를 저장할 인접행렬
		isInfectioned = new boolean[nodeCnt + 1]; // 해당 노드의 방문 여부를 저장할 boolean 배열 (감염 여부 저장)
		
		for (int cnt = 0; cnt < edgeCnt; cnt++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			
			map[node1][node2] = true;
			map[node2][node1] = true;
		}
		
		bfs(); // 너비 우선 탐색으로 바이러스를 전파시키자
		
		System.out.println(virusCnt); // 바이러스 전파가 끝난 후의 감염된 컴퓨터 수 출력
	}
	
}
