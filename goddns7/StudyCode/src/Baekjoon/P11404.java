package 백준;

import java.util.Scanner;

public class P11404 {
	// 도시의 개수
	static int cityNum;
	// 버스의 개수
	static int busNum;
	// 버스 노선
	static int[][] line;

	// 엄청 큰 수
	static int INF = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 도시의 개수
		cityNum = sc.nextInt();
		// 버스의 개수
		busNum = sc.nextInt();
		// 버스 노선
		line = new int[cityNum + 1][cityNum + 1];

		// 초기값 설정
		// 엄청 큰 수로 지정해놓고, 경로가 없을 경우에 이 수로 대비해서 최소 비용을 찾을 때 고려되지 않도록 한다.
		// -> 엄청 큰 수로 지정해놓으면 최소 비용을 찾을 때 고려되지 않기 때문
		// 엄청 큰 수로 지정해놓는다는 것은 구별시키는 역할이라고 생각 -> 나중에 경로가 없는 것으로 구분
		for (int i = 1; i <= cityNum; i++) {
			for (int j = 1; j <= cityNum; j++) {
				line[i][j] = INF;
				// 예외: 자기 도시로 가능 경우는 무조건 비용 0이 최소이므로 0으로 지정
				if (i == j) {
					line[i][j] = 0;
				}
			}
		}

		// 버스의 정보 하나씩 입력
		for (int i = 0; i < busNum; i++) {
			// 버스의 출발 도시
			int start = sc.nextInt();
			// 버스의 도착 도시
			int end = sc.nextInt();
			// 한 번 타는데 필요한 비용
			int cost = sc.nextInt();

			// 버스 노선 배열에 입력
			// 경우1. 이미 비용 정보가 있는 경우 : 기존의 비용과 새로운 비용 중 더 싼 비용을 적어야
			// 경우2. 비용 정보가 없는 경우 : INF와 새로운 비용 중 더 싼 비용을 적어야 함
			line[start][end] = Math.min(line[start][end], cost);

		}

		// 플로이드 와샬 알고리즘
		// 거쳐가는 노드 k
		for (int k = 1; k <= cityNum; k++) {
			// 출발하는 노드 i
			for (int i = 1; i <= cityNum; i++) {
				// 도착하는 노드 j
				for (int j = 1; j <= cityNum; j++) {
					// i->k->j의 경로와 i->j의 경로를 비교해 작은 값이 최단 경로
					if (line[i][j] > line[i][k] + line[k][j]) {
						line[i][j] = line[i][k] + line[k][j];
					}
				}
			}
		}

		for (int i = 1; i <= cityNum; i++) {
			for (int j = 1; j <= cityNum; j++) {
				if (line[i][j] == INF) { // ->건들이지 않은 경우 = 경로가 없는 경우 = 처음에 지정한 INF로 남아있는 경우
					System.out.print("0 "); // 갈 수 없는 경로이므로 0을 출력
				} else { // -> 위에서 미리 지정된 경로
					System.out.print(line[i][j] + " "); // 지정된 값 출력
				}
			}
			System.out.println();
		}

		sc.close();
	}
}



