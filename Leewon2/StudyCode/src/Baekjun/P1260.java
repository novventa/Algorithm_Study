/* 문제
 * 그래프를 DFS와 BFS로 탐색한 결과를 출력해보자.
 * 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고
 * 더 이상 방문할 수 있는 점이 없다면 종료하자.

 * 문제 조건
 * 정점의 개수 N은 1 이상 1,000 이하다.
 * 간선의 개수 M은 1 이상 10,000 이하다.
 * 두 정점 사이에 여러 개의 간선이 있을 수 있고 입력으로 주어지는 간선은 양방향이다.

 * 문제 해결 방법
 * 재귀함수를 이용하여 DFS탐색을 해본다.
 * DFS는 깊이 우선 탐색이므로 연결되어 있는 모든 정점을 확인한 후 다음 스텝으로 넘어가야 한다.
 * 시작점과 연결되어 있는 정점찾아보자.
 * 시작점과 연결되어 있고, 방문하지 않았다면 출력 후 방문표시한다.
 * 방문표시 후 재귀함수를 통해 다음 정점과 연결되어 있는지 확인한다.
 * 
 * 큐를 이용하여 BFS탐색을 해본다.
 * BFS는 루트 노드와 연결되어 있는 모든 정점을 확인한 후 다음 스텝으로 넘어가야 한다.
 * 시작점을 q배열에 넣는다. 
 * q배열이 빌 때 까지 반복하는데, 루트 노드와 연결되어 있고 방문체크가 false라면,
 * q에 넣어주고 방문체크를 true로 바꿔준다.

 */

package Baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1260 {
	static boolean[] checkBFS;
	static boolean[] checkDFS;
	static int n;
	static int m;
	static int start;
	static int[][] arr;

	// DFS 메소드를 만들어보자.
	public static void DFS(int data) {

		// DFS는 노드와 연결되어 있는 하나의 노드를 찾은 후,
		// 찾은 노드와 연결되어 있는 다른 노드를 찾는 것을 반복하는 방법이다.
		for (int i = 1; i < n + 1; i++) {
			// 노드와 연결되어 있고, 방문체크가 false라면,
			if (checkDFS[i] == false && arr[data][i] == 1) {
				// 출력 후에 방문체크를 true로 바꿔준다.
				System.out.print(i + " ");
				checkDFS[i] = true;

				// 재귀함수를 통해 찾은 노드와 연결되어 있는 노드가 있는지 확인해보자.
				DFS(i);
			}
		}
	}

	// BFS 메소드를 만들어보자.
	public static void BFS(int data) {

//		이건 왜 안될까? 생각해보자!
//		Stack<Integer> stack = new Stack<>();
//
//		System.out.print(data + " ");
//		checkBFS[data] = true;
//		stack.push(data);
//
//		while (stack.size() != n) {
//			for (int i = 1; i <= n; i++) {
//				if (checkBFS[i] == false && arr[stack.peek()][i] == 1) {
//					System.out.print(i + " ");
//					checkBFS[i] = true;
//					stack.push(i);
//				}
//			}
//
//		}

		// 큐 배열을 선언하고, 입력받은 값을 큐에 저장후에 출력한다.
		Queue<Integer> q = new LinkedList<>();
		q.offer(data);
		System.out.print(data + " ");

		// 처음 값을 방문체크 한다.
		checkBFS[data] = true;

		// q가 빌 때 까지 반복해보자.
		while (!q.isEmpty()) {
			// 입력받은 data 값이 1 이라면, 첫번째 poll 값은 1이 된다.
			// 1과 연결되어 있는 모든 정점을 확인했으면, 다음으로 q 배열에 들어있는 값을 꺼내고
			// 다음으로 들어가 있는 값과 연결되어 있는 정점을 확인한다.
			int poll = q.poll();

			// 배열에서 꺼낸 값과 연결되어 있는 정점이고, 방문체크가 false라면
			// q에 넣어주고 방문체크를 해주자.
			for (int i = 1; i <= n; i++) {
				if (checkBFS[i] == false && arr[poll][i] == 1) {
					q.offer(i);
					checkBFS[i] = true;
					// 방문체크 후 출력한다.
					System.out.print(i + " ");
				}
			}
		}

	}

	// main 메소드를 작성해보자.
	public static void main(String[] args) {

		// 스캐너를 이용해 정점의 갯수 n, 간선의 갯수 M, 탐색을 시작할 정점의 번호 start를 입력 받는다.
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();

		// BFS와 DFS에서 방문체크를 하기 위해 n+1크기의 boolean 배열을 선언한다.
		// 인덱스를 이용해 문제를 해결하기 위해 배열의 크기를 n+1로 설정한다.
		checkBFS = new boolean[n + 1];
		checkDFS = new boolean[n + 1];

		// m개의 연결되어 있는 정점의 번호를 입력받기 위해 row와 col을 선언한다.
		int row;
		int col;

		// 1번 인덱스부터 사용하기 위해 배열의 크기를 n+1로 하자.
		arr = new int[n + 1][n + 1];

		// row와 col에 값을 입력 받고,
		// 연결되어 있다는 표시를 위해 배열의 arr[row][col]과 arr[col][row]를 1로 표시하자.
		for (int i = 0; i < m; i++) {
			row = sc.nextInt();
			col = sc.nextInt();
			arr[row][col] = 1;
			arr[col][row] = 1;
		}

		// DFS와 BFS를 호출해보자.

		// DFS는 재귀함수를 이용하기 때문에 호출 전에 시작점을 true로 바꾸고 출력하자.
		checkDFS[start] = true;
		System.out.print(start + " ");
		DFS(start);

		// 출력 양식에 맞추기 위해 개행을 해보자.
		System.out.println();

		BFS(start);

	}
}
