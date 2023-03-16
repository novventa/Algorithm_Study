/* 문제
 * 강을 가로지르는 하나의 차선으로 된 다리가 있다.
 * 다리 위에는 w대의 트럭이 동시에 올라갈 수 있는데, 올라가있는 트럭의 무게의 합은
 * 다리의 최대하중 L보다 작거나 같아야 한다.
 * 다리의 길이와, 다리의 최대하중, 다리를 건너려는 트럭들의 무게가 순서대로 주어졌을 때,
 * 모든 트럭이 다리를 건너는 최단시간을 구해보자.
 * 
 * 
 * 문제 조건
 * 다리를 건너는 트럭의 수 n은 1 이상 1000 이하다.
 * 다리의 길이 w는 1 이상 100 이하다.
 * 다리의 최대하중 L은 10 이상 1000 이하다.
 * 
 * 
 * 문제 해결 방법
 * 1. 첫번째 트럭은 아무런 제약 없이 출발하므로 q1에서 하나를 빼서 q2에 저장한다.
 * 2. q1이 빌 때 까지 반복하는데 q2 배열의 합 + q1의 가장 첫번 째 값(peek)가 최대하중보다 작다면
 * q1에서 하나 더 빼내어 q2에 저장한다.
 * 3. 위의 값이 최대하중보다 크다면, 0을 추가한다.
 * 4. 트럭이 다리를 다 지나가면, q2배열에서 첫번째 값을 빼준다.
 * 5. 값을 빼준 후 q1이 빌 때 까지 다시 2~4 과정을 반복해보자. 
 * 
 */

package Baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P13335 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 트럭의 수를 입력받자.
		int truckCnt = sc.nextInt();

		// 다리의 길이를 입력 받자.
		int bridgeLen = sc.nextInt();

		// 다리의 최대하중을 입력 받자.
		int bridgeWeight = sc.nextInt();

		// 큐 배열 2개를 만들자.
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		// 트럭 무게 정보를 입력 받자.
		for (int i = 0; i < truckCnt; i++) {
			q1.offer(sc.nextInt());
		}

		// 첫번째 트럭은 아무런 제약 없이 출발하므로 q2배열에 q1의 가장 앞에있는 값을 저장하자.
		q2.offer(q1.peek());

		// q2 배열의 합을 계속 구할수는 없으니,,,
		// 변수를 하나 만들어서 q2 배열의 합을 저장해보자.
		// q1에서 가장 앞에 있는 값을 꺼내어 q2Sum 변수에 저장한다.
		int q2Sum = q1.poll();

		// 다리의 길이가 변하지 않도록 len 변수에 따로 저장한다.
		int len = bridgeLen;

		// 최단시간을 저장하기 위한 변수를 만들고 첫번째 트럭이 출발 했으니 1을 저장한다.
		int sum = 1;

		// q1이 빌 때 까지 반복해보자.
		while (!q1.isEmpty()) {

			// 출발했으니 len을 하나 빼준다.
			len--;

			// len이 0이 되었다는 것은 트럭 한대가 다리를 다 지나간 것이므로
			// q2에서 값을 하나 빼고, q2Sum에서 그 값을 빼주자.
			if (len == 0) {
				q2Sum -= q2.poll();
				// 아직 남아있는 트럭들이 있으므로 len을 1로 초기화 시킨다.
				len = 1;
			}

			// q1이 비어있지 않고, poll 값과 q1을 더한 값이 bridgeWeight보다 작거나 같다면
			if (!q1.isEmpty() && q2Sum + q1.peek() <= bridgeWeight) {

				// q2에 q1의 가장 앞에 있는 값을 저장한다.
				q2.offer(q1.peek());

				// q1에서 값을 하나 꺼내어 q2Sum에 더한다.
				q2Sum += q1.poll();
			}

			// q1이 비었거나, q2Sum값과 q1을 더한 값이 bridgeWeight보다 크다면
			// 0을 추가한다.
			else {
				q2.offer(0);

			}
			// 위 과정이 1회 반복되었으니, 트럭들이 한칸씩 이동했으므로
			// sum에 1을 더해주자.
			sum++;
		}

		// while문은 마지막 트럭이 빠져나올때 까지 기다리지 않으므로,
		// sum에 다리의 길이만큼 더해서 출력하자.
		System.out.println(sum + bridgeLen);
	}
}
