/* 문제
 * 정사각형 모양의 지도에서 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
 * 지도에서 연결된 집의 모임인 단지를 정의하려고 한다.
 * 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
 * 이때, 대각선상에 집이 있는 경우는 연결된 것이 아니다.
 * 단지 수를 출력하고 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하자.
 * 
 * 
 * 문제 조건
 * 지도의 크기 N은 5 이상 25 이하다.
 * 
 * 
 * 문제 해결 방법
 * BFS를 이용하여 해결해보자.
 * N*N크기의 배열을 만들고 값을 입력 받는다.
 * 방문체크를 하기 위해 N*N 크기의 boolean 타입의 배열도 만든다.
 * 시작점을 찾아보자.
 * 반복문을 이용해 방문체크가 false이고 값이 1이라면, 시작점으로 삼는다.
 * 시작점에서 큐와 델타배열을 이용해 상하좌우를 탐색한다.
 * 상하좌우에 값이 1이고 방문체크가 false라면 방문체크를 true로 바꾸고 카운트를 늘린다.
 * 마지막에 오름차순으로 출력해야 하므로 카운트할 값을 하나의 배열에 저장해두자.
 * 반복문이 끝나면 하나의 단지를 찾은 것 이므로 단지의 갯수에 하나를 더하자.
 * 
 * 
 */

package Baekjun;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2667 {
	static int size;
	static int[][] map;
	static boolean[][] check;
	static Queue<Integer> houseCnt = new LinkedList<>();
	static int vilageCnt;

	public static void bfs(int row, int col) {

		// row와 col을 저장할 큐 배열 2개를 선언한다.
		Queue<Integer> rowQ = new LinkedList<>();
		Queue<Integer> colQ = new LinkedList<>();

		// row와 col값을 q에 저장한다.
		rowQ.offer(row);
		colQ.offer(col);
		// 방문체크도 해주자.
		check[row][col] = true;

		// 자기 자신이 들어왔으므로 cnt에 1을 저장한다.
		int cnt = 1;

		// 델타배열을 선언하자.
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		// 큐가 빌 때 까지 반복해보자.
		while (!rowQ.isEmpty()) {
			// rowQ와 colQ에서 값을 하나씩 꺼내고,
			int rowPoll = rowQ.poll();
			int colPoll = colQ.poll();

			// 델타배열을 이용해 4방 탐색을 해보자.
			for (int i = 0; i < 4; i++) {
				int newRowPoll = rowPoll + dr[i];
				int newColPoll = colPoll + dc[i];

				// 범위가 벗어나는 경우 continue 해주자.
				if (newRowPoll < 0 || newRowPoll >= size || newColPoll < 0 || newColPoll >= size)
					continue;

				// 범위도 벗어나지 않고, 값은 1이며 방문하지 않은곳 이라면
				else if (map[newRowPoll][newColPoll] == 1 && !check[newRowPoll][newColPoll]) {
					// 체크표시를 해주고
					check[newRowPoll][newColPoll] = true;
					// cnt도 하나 늘려주고
					cnt++;
					// q에다가 넣자.
					rowQ.offer(newRowPoll);
					colQ.offer(newColPoll);
				}
			}
		}
		// while문이 끝났으면, cnt를 houseCnt배열에 넣자.
		houseCnt.offer(cnt);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 지도의 크기 n을 입력 받자.
		size = sc.nextInt();

		// 지도 크기의 배열을 만들자.
		map = new int[size][size];

		// 방문체크를 위해 지도 크기의 boolean 타입의 배열도 만든다.
		check = new boolean[size][size];

		// 단지 수를 저장할 변수를 만들자.
		int vilageCnt = 0;

		// 값을 입력 받아 보자.
		for (int row = 0; row < size; row++) {
			// 숫자가 붙어있으므로 string 타입으로 입력 받고 나눠보자.
			String str = sc.next();
			for (int col = 0; col < size; col++) {
				// 문자열을 char형으로 변환하고
				// char형 데이터를 int 형태로 바꿔보자.
				map[row][col] = Character.getNumericValue(str.charAt(col));
			}
		}

		// 시작점을 찾아보자.
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				// 배열에 값이 1이고, 방문하지 않은 곳 이라면 시작점이 된다.
				if (map[row][col] == 1 && !check[row][col]) {
					bfs(row, col);
					vilageCnt++;
				}
			}
		}

		// 단지 수를 먼저 출력하자.
		System.out.println(vilageCnt);

		// 오름차순으로 출력하기 위해 houseCnt 큐 배열에 담겨있는 정보를
		// 1차원 배열로 옮겨보자.
		// 크기는 큐 크기로 한다.
		int[] arr = new int[houseCnt.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = houseCnt.poll();
		}

		// Arrays.sort를 이용해 오름차순으로 정렬하자.
		Arrays.sort(arr);

		// 단지내의 집 수를 출력 해보자.
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

}
