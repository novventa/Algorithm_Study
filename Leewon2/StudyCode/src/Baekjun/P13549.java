/* 문제
 * 수빈이는 동생과 숨바꼭질을 하고 있다.
 * 수빈이는 N에 있고, 동생은 K에 있다.
 * 수빈이는 걷거나 순간이동을 할 수있는데, 걸을 때는 1초 후에 +-1 만큼 이동하고
 * 순간이동을 할 때는 0초 후에 2배만큼 이동한다.
 * 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간을 구해보자.
 * 
 * 
 * 
 * 문제 조건
 * 수빈이의 현재 위치 N과 동생의 위치 K는 0 이상 100,000 이하다.
 * N과 K는 정수이다.
 * 
 * 
 * 
 * 문제 해결 방법
 * 큐 배열(q)과 일반 배열(check)을 이용해 해결해보자.
 * 큐 배열에는 수빈이의 위치를 넣고, 일반 배열에는 위치를 몇번만에 갈 수 있는지 표시한다.
 * 
 * 가장 먼저 수빈이의 위치를 큐에 넣고, check[수빈이의 위치]=1로 설정한다.
 * 큐에서 값을 하나 빼내고, 빼낸 값을 -1, *2, +1을 순차적으로 한다.
 * check[빼낸값 -1, +1]은 1회 이동한 것 이므로 기존 cnt값에서 1을 더한 값을 저장하고
 * check[빼낸 값 *2]는 순간이동을 한 것이므로, 기존 cnt값을 그대로 저장한다.
 * 현재 저장되어 있는 check[빼낸 값-1]보다 새로 계산한 값이 작다면 값을 갱신한다.
 * 큐에서 꺼낸 값과 동생의 위치가 같다면, check[동생위치]를 출력하자.
 * 
 */

package Baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P13549 {
	/*
	 * static 영역에 큐 배열을 선언하자 poll : 큐에서 꺼낸 값 cnt : 수빈이의 이동 횟수 check[] : 수빈이의 위치 인덱스에
	 * 이동 횟수를 저장할 배열
	 */
	static Queue<Integer> q = new LinkedList<>();
	static int poll;
	// cnt를 0으로 설정할 경우, 아래의 if문에서 값이 제대로 출력되지 않아
	// cnt를 1로 설정한 후, 결과값에서 1을 빼주자.
	static int cnt = 1;
	static int[] check = new int[100001];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 수빈이와 동생의 값을 입력 받는다.
		int subin = sc.nextInt();
		int sister = sc.nextInt();

		// 수빈이의 현재 위치를 큐에 저장한다.
		q.offer(subin);
		// 수빈이의 현재 위치 인덱스에 cnt값을 저장한다.
		check[subin] = cnt;

		graph(sister);
	}

	public static void graph(int data) {

		// 동생과 만날때 까지 가보자.
		outer: while (true) {

			// q 배열에서 값을 하나 꺼내고, poll에 저장하자.
			poll = q.poll();

			// 꺼낸 값 인덱스의 이동 횟수를 cnt에 저장한다.
			cnt = check[poll];

			// 1. -1로 가는 경우
			// 배열의 범위를 벗어나지 않도록 조건을 설정해보자.
			if (poll - 1 >= 0) {
				// 배열의 범위가 벗어나지 않고
				// 이동을 했을 때 그 인덱스의 값이 0이거나
				// 저장되어 있는 값보다, 저장할 값이 작다면
				// q배열에 값을 넣어주고, check 배열의 cnt 값도 갱신한다.
				if (check[poll - 1] == 0 || check[poll - 1] > cnt + 1) {
					q.offer(poll - 1);
					check[poll - 1] = cnt + 1;
				}
			}

			// 2. *2로 가는 경우
			if (poll * 2 < 100001) {
				// 배열의 범위가 벗어나지 않고
				// 이동을 했을 때 그 인덱스의 값이 0이거나
				// 저장되어 있는 값보다, 저장할 값이 작다면
				// q배열에 값을 넣어주고, check 배열의 cnt 값도 갱신한다.
				if (check[poll * 2] == 0 || check[poll * 2] > cnt) {
					q.offer(poll * 2);
					check[poll * 2] = cnt;

				}

			}

			// 3. +1로 가는 경우
			if (poll + 1 < 100001) {
				// 배열의 범위가 벗어나지 않고
				// 이동을 했을 때 그 인덱스의 값이 0이거나
				// 저장되어 있는 값보다, 저장할 값이 작다면
				// q배열에 값을 넣어주고, check 배열의 cnt 값도 갱신한다.
				if (check[poll + 1] == 0 || check[poll + 1] > cnt + 1) {
					q.offer(poll + 1);
					check[poll + 1] = cnt + 1;

				}

			}

//				System.out.print("현재 꺼낸 값 : " + poll + " 현재 root : "+root + " 현재 cnt : "+cnt + " 해당 check값 : " + check[poll]);
//				System.out.println();

			// 꺼낸 값과 동생의 위치가 같다면,
			if (poll == data) {
				// 꺼낸 값 인덱스의 이동 횟수에서 -1을 하고 출력하자.
				System.out.println(check[poll] - 1);
				// 가장 빠른 시간을 찾았으니 while문을 빠져나가자.
				break outer;

			}

		}

	}
}
