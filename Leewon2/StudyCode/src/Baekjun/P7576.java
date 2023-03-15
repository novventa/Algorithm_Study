/* 문제
* 토마토 농장에 M*N 크기의 창고가 있다.
* 창고에 보관되는 토마토 중에는 잘 익은 토마토도 있지만 익지 않은 토마토도 있다.
* 익지 않은 토마토는 익은 토마토의 영향을 받아 익게되는데
* 하루가 지나면 익은 토마토 상하좌우에 토마토들은 익게된다.
* 몇일이 지나면 창고의 토마토들이 모두 익는지 구해보자.
* 
* 
* 문제 조건
* 창고의 칸에는 토마토가 들어있지 않을수도 있다.
* 상자의 가로 칸의 수 N, 세로 칸의 수 M은 2 이상 1000 이하다.
* 정수 1은 익은 토마토, 0은 익지 않은 토마토, -1은 토마토가 들어있지 않은 칸이다. 
* 저장될 때 부터 모든 토마토가 익어있는 상태이면 0을 출력하고, 모두 익지 못하면 -1을 출력하자.
* 
* 
* 문제 해결 방법
* BFS와 델타배열을 이용해보자.
* 
* 큐 배열을 총 4개 만든다.
* 첫번째 firstRow,firstCol 큐 배열에는 0이었던 값이 1로 바뀐 새로운 값들을 넣는다.
* 
* 두번째 secondRow,secondCol 큐 배열에는 첫번째 배열에 있던 정보를 그대로 가지고 온 후, 첫번째 큐 배열은 모두 비운다.
* 두번째 큐 배열은 하루동안 범위를 넓히는 과정을 의미한다.
* 두번째 큐 배열이 빌 때 까지 반복하며 델타배열을 이용하여 0인 값을 찾고 1로 바꾼다.
* 찾은 값은 secondRow가 아닌 firstRow에 넣는다.
* 두번째 큐가 비면 카운트를 하나 늘리고
* 첫번째 큐가 빌 때 까지 위 과정을 반복하자.
* 
* 
*/

package Baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P7576 {
	// 한번 실행한 후 카운트를 해주기 위해
	// 큐 배열을 총 4개를 만들어 보자.

	// rowQ와 colQ에는 값이 1인 row와 col을 저장한다.
	static Queue<Integer> firstRowQ = new LinkedList<>();
	static Queue<Integer> firstColQ = new LinkedList<>();

	// rowQ와 colQ에 담겨있는 값들을 newRowQ와 newColQ에 옮긴다.
	// newRowQ가 빌 때 까지 반복하고, 새로 찾는 값 들은 rowQ와 colQ에 저장한다.
	// newRowQ가 비게 된다면 1이었던 값들이 범위를 넓히고 종료된 것이다.
	// 이는 하루가 지난 것과 동일하다.
	static Queue<Integer> secondRowQ = new LinkedList<>();
	static Queue<Integer> secondColQ = new LinkedList<>();

	static int width;
	static int height;
	static int cnt = 0;
	static int[][] arr;

	public static void bfs() {

		// 델타배열을 이용하기 위해 델타배열을 만들자.
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		// rowQ와 colQ에 담겨있는 값들을 newRowQ와 newColQ에 옮긴다.
		// newRowQ가 빌 때 까지 반복하고, 새로 찾는 값 들은 rowQ와 colQ에 저장한다.
		// newRowQ가 비게 된다면 1이었던 값들이 범위를 넓히고 종료된 것이다.
		// 이는 하루가 지난 것과 동일하다.

		// rowQ가 종료된다는 것은 더이상 범위를 넓힐 곳이 없다는 것이다.
		while (!firstRowQ.isEmpty()) {

			// rowQ와 colQ에 있는 값들을
			while (!firstRowQ.isEmpty()) {
//					newRowQ와 newColQ로 옮기고, rowQ와 colQ는 비운다.
				secondRowQ.offer(firstRowQ.poll());
				secondColQ.offer(firstColQ.poll());
			}

			// 실행되었는지 여부를 판단하기 위한 변수를 만든다.
			// 실행되었다면 카운트를 하나 늘리고, 실행되지 않았다면 카운트를 늘리지 않는다.
			int doit = 0;

			// 새로운 큐가 한번 빌 때 까지 반복하자.
			while (!secondRowQ.isEmpty()) {

				// 델타배열을 이용할 때, 기준값이 변하면 안되므로 값을 꺼내어 새로운 변수에 저장한다.
				int rowPoll = secondRowQ.poll();
				int colPoll = secondColQ.poll();

				// 델타 배열을 이용하여 상하좌우를 탐색해보자.
				for (int i = 0; i < dr.length; i++) {
					// 상하좌우를 탐색하자.
					int newRowPoll = rowPoll + dr[i];
					int newColPoll = colPoll + dc[i];

					// 배열의 범위를 벗어나면 continue를 해주자.
					if (newRowPoll < 0 || newColPoll < 0 || newRowPoll >= width || newColPoll >= height)
						continue;

					// 상하좌우를 확인했는데 0 값이 있다면?
					// 그 값을 rowQ와 colQ에 넣고, 값은 1로 바꿔주자.
					if (arr[newRowPoll][newColPoll] == 0) {
						firstRowQ.offer(newRowPoll);
						firstColQ.offer(newColPoll);
						arr[newRowPoll][newColPoll] = 1;
						// if문이 실행 됐다면, doit을 하나 늘리자.
						doit++;
					}
				}
			}
			// 실행이 됐다면 카운트를 늘린다.
			if (doit > 0)
				cnt++;
		}

		// 큐를 전부 비웠는데 배열에 0 값이 존재한다면,
		// 토마토가 전부 익지 못한 것 이므로, cnt를 -1로 바꾼다.
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (arr[i][j] == 0)
					cnt = -1;
			}
		}

		// 출력
		System.out.println(cnt);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		height = sc.nextInt();
		width = sc.nextInt();

		// 가로 세로 크기의 배열을 만들어보자
		arr = new int[width][height];

		// 배열에 값을 입력 받자.
		for (int row = 0; row < width; row++) {
			for (int col = 0; col < height; col++) {
				arr[row][col] = sc.nextInt();

				// 배열의 값이 1이라면 q에 저장하자.
				if (arr[row][col] == 1) {
					firstRowQ.offer(row);
					firstColQ.offer(col);
				}
			}
		}

		bfs();

	}

}
