import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author jhye.byun
 * SWEA 7465 창용 마을 무리의 개수 D4 그래프
 * 
 * 문제
 * 1번~N번까지의 사람
 * 두 사람이 서로 아는 관계이거나 몇 사람을 거쳐서 알 수 있는 관계라면 하나의 무리라고 한다.
 * 몇 개의 무리가 존재하는지 계산하자.
 * 
 * 조건
 * 정점의 개수 N (1 ≤ N ≤ 100)
 * 간선의 개수 M (0 ≤ M ≤ N(N-1)/2)
 * 
 * 풀이
 * 1. 입력되는 간선의 정보를 인접 행렬에 저장하자.
 * 2. N명의 사람을 카운트 했는지 나타낼 boolean 배열을 만들어서, 무리에 포함됐다면 true로 표시해주자.
 * 3. 1~N번 까지의 사람을 확인하며 아직 무리에 포함되지 않아 false 상태이면 무리를 1 증가시키고,
 * 3-1. bfs를 통해 해당 무리에 포함되는 사람들을 모두 true로 바꾸자.
 */

public class SWEA_7465_창용마을무리의개수_변지혜 {
	
	static int nodeCnt;
	static boolean[][] graph;
	static boolean[] checked;
	
	public static void bfs(int peopleNum) {
		// 한 사람과 인접한 사람들을 찾아서 무리에 포함시키자
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		
		queue.add(peopleNum); // 인접한 사람들을 찾기 위해 대기열에 저장
		checked[peopleNum] = true; // 무리에 포함되었다고 표시해주자
		
		// 대기열에 들어있는 모든 사람을 확인하자
		while (!queue.isEmpty()) {
			int curPeople = queue.poll(); // 대기 1번 사람 확인
			
			for (int idx = 1; idx <= nodeCnt; idx++) {
				// 인접하지 않은 사람은 패스
				if (!graph[curPeople][idx]) continue;
				
				// 인접한 사람 중에서 이미 무리에 포함된 사람이면 패스
				if (checked[idx]) continue;
				
				// 인접한 사람이 아직 무리에 포함되지도 않았다면,
				// 대기열에 저장해서 확인하고 무리에 포함됐다고 표시해주자
				queue.add(idx);
				checked[idx] = true;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt(); // 테케 개수 입력받기
		
		for (int tc = 1; tc <= testCase; tc++) { // 테케 개수만큼 반복 실행
			
			nodeCnt = sc.nextInt(); // 정점의 개수 입력받기 (사람 수)
			int edgeCnt = sc.nextInt(); // 간선의 개수 입력받기
			
			graph = new boolean[nodeCnt + 1][nodeCnt + 1]; // 사람들의 인접 여부를 나타내는 인접 행렬을 만들자
			
			// 간선 정보 (인접 정보)를 입력받자
			for (int cnt = 0; cnt < edgeCnt; cnt++) {
				int people1 = sc.nextInt();
				int people2 = sc.nextInt();
				
				graph[people1][people2] = graph[people2][people1] = true;
			}
			
			int count = 0; // 무리의 개수를 세어줄 변수
			
			// 각 사람의 확인 여부를 표현할 배열을 만들자
			checked = new boolean[nodeCnt + 1]; 
			
			// 각 사람에 대해 확인 여부를 체크하고 무리의 개수를 세어주자
			for (int cnt = 1; cnt <= nodeCnt; cnt++) {
				// 이미 무리에 포함시킨 사람이면 다음 사람 확인
				if (checked[cnt]) continue;
				
				// 아직 포함되지 않은 사람이면 무리를 찾아주자
				count++; // 무리의 개수를 1 증가시키고
				bfs(cnt); // 인접한 사람들을 무리에 포함시키자
			}
			
			// 무리의 개수를 모두 확인했다면 출력하자
			System.out.printf("#%d %d\n", tc, count);
		}
	}
}
