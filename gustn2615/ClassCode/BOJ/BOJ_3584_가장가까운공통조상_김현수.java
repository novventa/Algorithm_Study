package study_ssafy2;

/*
 * 서로소 집합을 만들 때 처럼 배열을 만들어서 문제를 푼다
 * 1. node의 개수+1 크기의 부모배열을 만들어서 index=자식노드 배열값=부모노드를 넣어준다.
 * 2. 방문 처리를 해줄 배열을 만들어 준다.
 * 3. 공통 조상을 찾아야 하는 두수를 부모배열을 활용해 부모들을 찾아 방문 처리해준다.
 * 4. 이때 이미 방문 처리가 되어있다면 공통 조상 이므로 이를 출력해준다. 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3584_가장가까운공통조상_김현수 {

	static int T, nodeNum, answer;
	static int[] parent;
	static boolean[] visted;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		// 테스트 케이스 횟수 받아오기
		T = Integer.parseInt(br.readLine().trim());

		// 테스트 케이스 횟수만큼 반복
		for (int tc = 1; tc <= T; tc++) {

			// 노드의 개수 받아오기
			nodeNum = Integer.parseInt(br.readLine().trim());

			// 부모와 자식의 관계를 나타내어줄 배열
			parent = new int[nodeNum + 1];

			// 방문했는지 확인해줄 배열
			visted = new boolean[nodeNum + 1];

			// 간선 수만큼 반복하면서
			for (int i = 0; i < nodeNum - 1; i++) {
				st = new StringTokenizer(br.readLine().trim());

				// 부모 자식의 노드 값을 받아오고
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				// c의 부모는 p이다
				parent[c] = p;
			}

			// 공통 조상을 찾아야하는 값들
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 공통조상을 찾는 메소드
			search(a, b);

			// 정답출력
			System.out.println(answer);
		}
	}

	// 공통조상을 찾는 메소드
	static void search(int a, int b) {

		// 조상이 있을 때 까지만 반복
		while (a > 0) {
			// 방문했다고 해주고
			visted[a] = true;

			// 부모를 저장
			a = parent[a];
		}

		// 조상이 있을때 까지 반복
		while (b > 0) {

			// 만약 이미 방문했다면
			if (visted[b]) {
				// 공통조상을 찾았다 메소드 종료
				answer = b;
				return;
			}
			// 방문 안했다면
			else {
				// 방문했다고 처리하고
				visted[b] = true;
				// 부모를 저장
				b = parent[b];
			}
		}
	}
}
