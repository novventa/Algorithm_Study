/* 문제
 * N*M크기의 배열로 표현되는 미로가 있다.
 * 미로에서 1은 이동할 수 있는 칸이고, 0은 이동할 수 없는 칸일 때,
 * (1,1)에서 출발하여 (N,M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구해보자.
 * 
 * 문제 조건
 * N과 M은 2 이상 100 이하다.
 * 각각의 수 들은 붙어서 입력으로 주어진다.
 * 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
 * 칸을 셀 때는 시작 위치와 도착 위치도 포함한다.
 * 
 * 문제 해결 방법
 * (0,0)에서 시작한다.
 * 델타배열을 이용하여 연결되어 있는 위치를 확인한다.
 * 연결되어 있다면 q에 넣는다.
 * 연결되어 있다면 이전 값에 1을 더한 값을 저장하고 방문체크를 해주자.
 * 4방향을 다 탐색하면 다음 q에있는 값을 빼내어 위 과정을 반복해보자.
 * 
 */

package Baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2178 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 정수 R과 C를 입력받아보자.
		int R = sc.nextInt();
		int C = sc.nextInt();

		// R*C크기의 배열을 만든다.
		int[][] arr = new int[R][C];

		// 방문체크를 하기 위해 R*C크기의 boolean 변수를 만든다.
		boolean[][] check = new boolean[R][C];

		// 배열에 값을 입력받자.
		for (int row = 0; row < R; row++) {

			// 문자열로 입력받은 후
			String str = sc.next();
			for (int col = 0; col < C; col++) {
				// char형으로 변환하여 배열에 저장한다.
				// 이때 아스키코드 값에서 48을 빼줘서
				// 문자 '0'과'1'을 숫자'0'과'1'로 만든다.
				arr[row][col] = str.charAt(col) - 48;
			}
		}

		// row와 col값을 저장할 q배열 2개를 만들어 보자.
		Queue<Integer> rowQ = new LinkedList<>();
		Queue<Integer> colQ = new LinkedList<>();

		// rowQ와 colQ에 0을 저장하고, 시작점 (0,0)은 방문체크를 해놓자.
		rowQ.offer(0);
		colQ.offer(0);
		check[0][0] = true;

		// 4방향 탐색을 위해 델타배열을 만들어보자.
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		// 큐가 빌 때 까지 반복해보자.
		while (!rowQ.isEmpty()) {
			// 큐에서 값을 하나씩 빼내서 4방 탐색을 할거다.
			// 맨 처음 nextRow와 nextCol은 시작점이 된다.
			int nextRow = rowQ.poll();
			int nextCol = colQ.poll();

			// 델타배열을 이용하여 현재 위치에서 4방탐색을 해보자.
			for (int i = 0; i < dr.length; i++) {
				int newRow = nextRow + dr[i];
				int newCol = nextCol + dc[i];

				// 배열의 범위 밖으로 벗어나는 경우, 확인한 값이 0인 경우,
				// 방문체크가 true인 경우엔 continue 하자.
				if (newRow < 0 || newCol < 0 || newRow >= R || newCol >= C || arr[newRow][newCol] == 0
						|| check[newRow][newCol] == true) {
					continue;
				}

				// 위의 조건에 걸리지 않는다면 방문하지 않은 배열 범위 내의 1 값 이므로
				// q에 저장하고 방문체크를 해주자.
				rowQ.offer(newRow);
				colQ.offer(newCol);
				check[newRow][newCol] = true;

				// 방문한 값에는 이전 값+1을 해주자.
				arr[newRow][newCol] = arr[nextRow][nextCol] + 1;
			}

		}

		// 도착점의 값이 최소값이 되므로 도착점을 출력한다.
		System.out.println(arr[R - 1][C - 1]);

	}
}
