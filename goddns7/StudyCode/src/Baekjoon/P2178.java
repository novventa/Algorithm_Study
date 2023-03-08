package day0308;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2178 {
	// 배열의 높이
	static int height;
	// 배열의 너비
	static int width;
	// 배열
	static int[][] arr;
	// 방문 체크 배열
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 배열의 높이
		height = sc.nextInt();
		// 배열의 너비
		width = sc.nextInt();
		// 배열
		arr = new int[height][width];
		// 방문자 배열 선언, 초기화:False
		visited = new boolean[height][width];
		// 배열에서 상태 입력(1: 이동할 수 있음, 0: 이동할 수 없음)
		for (int i = 0; i < height; i++) {
			String[] line = sc.next().split("");
			for (int j = 0; j < width; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
			}
		}

		bfs();
	
		// 제일 끝에 마지막으로 더해진 총 횟수가 있기에 그것을 출력한다
		System.out.println(arr[height - 1][width - 1]);
		sc.close();
	}

	public static void bfs() {

		// 상하좌우 모두 확인
		int[] dRow = { 1, 0, -1, 0 };
		int[] dCol = { 0, 1, 0, -1 };

		// 큐 생성
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { 0, 0 });// 첫 탐색 지역(0, 0)
		// -> 배열로 추가

		int[] tmp = new int[2]; // 행+열의 값으로 들어갈 크기 2의 int[] 배열 선언
		// -> [0] : row, [1] : col

		visited[0][0] = true; // 첫 방문 지역은 탐색한 상태에서 시작

		int row, col; // queue값을 담을 row, col
		int nRow, nCol; // 델타배열을 적용한 새로운 row, col

		// 아래의 실행을 큐가 비어있을 때까지 반복한다
		// 1. 큐에 처음(0, 0)을 추가하고 해당 원소를 다시 poll 시키고
		// 2. 상하좌우를 확인하여 1인데 방문하지 않은 것들이 있으면 그곳을 방문하고, 해당 행렬을 배열(tmp)로 추가하고
		// 3. 처음으로 다시 돌아가서 추가했던 새 위치의 행열을 다시 poll 시킨다(1.의 실행과 동일)
		// -> 위의 실행을 큐가 비어있을 때까지 반복한다고 했는데, 그것의 의미는 더이상 움직일 칸이 없다는 것이다
		// 즉, 인접한 모든 칸을 모두 방문했거나, 주위에는 방문할 수 없는 지역만 남은 것이다. => 도착지에 도달(배열의 제일 오른쪽 아래 끝)
		while (!queue.isEmpty()) {
			tmp = queue.poll(); // -> 배열로 입력했기 때문에 배열로 출력됨

			row = tmp[0]; // 배열의 첫번째 원소는 row
			col = tmp[1]; // 배열의 두번째 원소는 col

			for (int j = 0; j < 4; j++) {
				// 상하좌우를 확인
				nRow = row + dRow[j];
				nCol = col + dCol[j];
				// 배열의 범위 밖에 있으면 무시하고 계속 진행
				if (nCol < 0 || nCol >= width || nRow < 0 || nRow >= height) {
					continue;
				}
				// 상하좌우를 확인했는데 1인데, 방문한 적이 없다면
				if (visited[nRow][nCol] == false && arr[nRow][nCol] == 1) {
					// 방문했다는 것으로 바꾸고
					visited[nRow][nCol] = true;
					// 처음(0, 0)에서 한 칸씩 이동할 수록 몇번째 움직이는 건지 확인하기 위해 이동한 후의 위치의 값(이동할 수 있는 곳은 값이 1이다)을
					// 더해준다
					arr[nRow][nCol] += arr[row][col];
					// 새로 이동한 곳을 큐에 다시 새로 추가한다
					queue.add(new int[] { nRow, nCol });
				}

			}
		}

	}

}



