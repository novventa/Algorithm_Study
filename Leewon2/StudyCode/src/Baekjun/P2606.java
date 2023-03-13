/* 문제
* 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.
* 1번 컴퓨터를 통해 우머 바이러스에 걸리게 되는 컴퓨터의 수를 출력해보자.
* 
* 문제 조건
* 컴퓨터의 수는 100 이하다.
* 컴퓨터의 번호는 1부터 차례대로 매겨진다.
* 
* 
* 문제 해결 방법
* BFS를 이용해 연결되어 있는 곳을 true로 바꿔주고
* true의 갯수를 세어보자.
* 
*/

package Baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2606 {
	// computer : 컴퓨터의 수
	// arr : 컴퓨터 쌍의 값을 저장할 배열
	// check : 방문체크를 표시할 boolean 타입의 배열
	// cnt : 연결되어 있는 수를 저장할 변수
	static int computer;
	static int[][] arr;
	static boolean[] check;
	static int cnt;

	// bfs 메서드를 만들어보자.
	public static int bfs() {

		// 큐를 선언하고
		Queue<Integer> q = new LinkedList<>();

		// 1부터 시작하므로 q에 1을 담고, 1번째 인덱스에 방문표시를 해주자.
		q.offer(1);
		check[1] = true;

		// 큐가 빌 때 까지 반복해보자.
		while (!q.isEmpty()) {
			// q에서 하나를 꺼내고 변수에 저장한다.
			int poll = q.poll();

			// 꺼낸 값과 연결되어 있는 값을 찾기 위해서 for문을 사용한다.
			for (int i = 1; i <= computer; i++) {
				// i번째에 방문하지 않았고, 꺼낸 값과 연결되어 있다면
				if (check[i] == false && arr[poll][i] == 1) {
					// 방문표시를 해주고
					check[i] = true;
					// 큐에 집어넣는다.
					q.offer(i);
					// 하나 찾았으니 cnt에 1을 더한다.
					cnt++;
				}
			}
		}
		// cnt를 반환하자.
		return cnt;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 컴퓨터의 수를 입력 받는다.
		computer = sc.nextInt();
		// 1번 인덱스부터 활용하기 위해 computer에 1을 더한 크기로 배열의 크기를 정한다.
		arr = new int[computer + 1][computer + 1];

		// 방문표시를 체크할 boolean 타입의 배열도 만들자.
		// 컴퓨터의 수 +1 로 만들면 컴퓨터의 수 까지 담을 수 있다.
		check = new boolean[computer + 1];

		// 직접 연결되어 있는 쌍의 갯수를 입력 받는다.
		int count = sc.nextInt();

		// 왼쪽과 오른쪽 값을 저장할 변수를 선언해놓자.
		int left;
		int right;

		// 쌍의 값들을 입력받아보자.
		for (int i = 0; i < count; i++) {
			left = sc.nextInt();
			right = sc.nextInt();

			// 양방향에 1을 입력 하자.
			arr[left][right] = 1;
			arr[right][left] = 1;
		}

		System.out.println(bfs());

	}
}
