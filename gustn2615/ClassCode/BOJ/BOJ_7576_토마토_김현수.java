package study_ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 미로찾기와 비슷하게 풀면 된다
 * 미로찾기와 차이점은 토마토의 경우 익은 토마토가 여러개여서 시작지점이 여러개가 될 수 있다는 점이다
 * 시작지점이 여러개여도 bfs로 풀면 너비 탐색이기 때문에 미로찾기와 마찬가지로 최소일수 또한 구할 수 있다
 * 
 * 1. 익은 토마토가 있는 위치를 모두 받아온다
 * 2. 일반 bfs의 경우 처음 시작지점을 queue에 넣어 메소드를 통해 너비탐색을 진행한다
 *   => 이때 시작지점이 여러개인 경우는 queue에 미리 여러개의 시작지점을 넣고 bfs 메소드를 진행하면 된다.
 * 3. 익은 토마토가 있는 위치를 전부 queue에 넣은 후에 bfs 메소드를 통해 box의 토마토들이 몇일뒤에 익게 되는지를 저장한다
 * 4. 이후 box 전체를 훑으면서 익기까지가 가장 오래걸리는 토마토를 찾으면 그 토마토가 바로 최소 일 수가 된다.
 * 
 * */
public class solution_7576_토마토_김현수 {

	// 메소드를 만들어서 사용하므로 변수들을 전역변수로 선언
	static int M, N, totalNum, answer;

	// 토마토가 들어갈 2차원 배열
	static int[][] box;

	// 토마토에 방문했는지를 알아볼 2차원 논리형 배열
	static boolean[][] isRipe;

	// bfs 메소드에 필요한 queue
	static Queue<int[]> queue;

	// 델타배열 사용
	static int[] deltaRow = { -1, 1, 0, 0 }; // x방향배열-상하
	static int[] deltaCol = { 0, 0, -1, 1 }; // y방향배열-좌우

	public static void main(String[] args) throws IOException {

		// 버퍼 리더 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Tokenizer 사용
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 상자의 크기 받아오기
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		// 상자에 최대로 보관할 수 있는 토마토의 개수를 변수로 저장
		// 나중에 토마토가 익은 상태를 확인할때 사용한다
		totalNum = M * N;

		// 토마토를 넣을 상자 배열 크기 정의
		box = new int[N][M];

		// 상자에 토마토를 넣는다
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < M; col++) {
				// Tokenizer를 통해 가져왔으므로 문자열이다.
				// 이를 숫자로 바꾸어 넣어준다.
				box[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		// 버퍼리더 사용 종료
		br.close();

		// 토마토가 처음부터 전부 익어져 있는지를 확인하기 위한 변수
		int tmpCount = 0;

		// 상자 전체를 훑으면서
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {

				// 익은 토마토가 있거나 , 비어있다면
				if (box[row][col] == 1 || box[row][col] == -1) {

					// 1. 익은 토마토라면
					if (box[row][col] == 1) {

						// 해당좌표를 queue에 넣는다.
						queue.add(new int[] { row, col });

					}

					// 2. 익은 토마토이거나 빈 공간이라면
					// 익은 토마토 개수를 증가시킨다
					tmpCount++;

				}
			}

		}

		// bfs에 사용할 queue정의
		// ArrayDeque이 빨라서 ArrayDeque 사용
		queue = new ArrayDeque<>();

		// 답을 저장할 변수
		answer = -1;

		// 1. 만약 익은 토마토 개수가 전체 상자의 공간과 같다면
		if (tmpCount == totalNum) {

			// 이는 처음부터 전부 익은 것 이므로 0출력
			answer = 0;
		}

		// 1. 만약 처음부터 익어있지 않았다면
		else {

			// bfs에서 사용할 논리형 크기 정의
			isRipe = new boolean[N][M];

			// bfs 메소드 실행
			bfs(queue);

			// 상자 전체를 훑으면서
			loop: for (int row = 0; row < N; row++) {
				for (int col = 0; col < M; col++) {

					// 1. 만약 상자안에 빈공간이 있다면
					if (box[row][col] == 0) {

						// 토마토가 모두 익지 못하는 상황이므로 -1 출력
						answer = -1;

						// 반복문을 아예 빠져나간다.
						break loop;
					}

					// 2. 만약 빈공간이 없다면
					else {

						// 그중 가장 큰값을 찾는다.
						// 이때 걸린 일 수는 1을 빼줘야한다.
						answer = Math.max(answer, box[row][col] - 1);
					}
				}
			}
		}

		// 결과 출력
		System.out.println(answer);

		// 상자에 토마토가 익은 일수가 잘 들어갔는지 확인
//		for (int row1 = 0; row1 < N; row1++) {
//			for (int col1 = 0; col1 < M; col1++) {
//				System.out.printf("%3d", box[row1][col1]);
//			}
//			System.out.println();
//		}
//		System.out.println();

	}

	// 너비 탐색
	static void bfs(Queue<int[]> queue) {

		// Queue가 빌 때 까지 반복
		while (!queue.isEmpty()) {

			// queue에 있는 좌표를 빼내어 X , Y 좌표 따로 저장
			int[] now = queue.poll();
			int nowX = now[0];
			int nowY = now[1];

			// 현재 자리를 방문했다고 저장
			isRipe[nowX][nowY] = true;

			// 델타배열을 사용하기위해 반복문을 4번 돈다
			for (int i = 0; i < 4; i++) {

				// 상하좌우로 이동해서 새로운 좌표로 저장
				int newRow = nowX + deltaRow[i];
				int newCol = nowY + deltaCol[i];

				// 1. 새로운 좌표가 범위를 벗어나거나
				// 2. 값이 1인 토마토가 있거나
				// 3. 빈공간 이거나
				// 4. 이미 방문했다면
				// 다음 반복문으로 넘어간다
				if (newRow < 0 || newRow > N - 1 || newCol < 0 || newCol > M - 1 || box[newRow][newCol] == -1
						|| box[newRow][newCol] == 1 || isRipe[newRow][newCol] == true) {
					continue;
				}

				// 위의 조건문에 해당되지 않는다면 이는 일반 토마토 이므로

				// 방문했다고 저장
				isRipe[newRow][newCol] = true;

				// 방문한 곳에 이전 토마토값에 +1 여기서 +1은 경과된 일수를 의미한다
				box[newRow][newCol] = box[nowX][nowY] + 1;

				// Queue에 방문한 좌표 추가
				queue.add(new int[] { newRow, newCol });
			}

		}
	}

}
