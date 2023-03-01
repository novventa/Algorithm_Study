// 문제
// 1번부터 N명의 사람이 원일 이루며 앉아있고, 양의 정수 K가 주어진다.
// 순서대로 K번째 사람을 제거하고, 남은 사람들로 계속해서 이 과정을 이어간다.
// 원에서 사람들이 제거되는 순서를(N,K)-요세푸스 순열이라고 한다.
// N과 K가 주어졌을 때 (N,K)-요세푸스 순열을 구해보자.

// 문제 조건
// N명의 사람은 1 이상 5000 이하다.
// 양의 정수 K는 1 이상 N 이하다.

// 문제 해결 방법
// 1번부터 N번까지 큐 배열에 넣고 사람들을 한명씩 빼서 뒤로 넣는다.
// 이때 K번째 빠지는 사람은 뒤로 다시 넣지 않고 요세푸스 순열로 넣는다.

// 1. N과 K를 입력받아보자.
// 2. 큐 배열을 생성 후 1부터 N까지의 숫자를 넣는다.
// 3. 큐 배열에서 1부터 K-1까지는 사람을 뺀 다음 뒤로 다시 넣고,
// K번째 사람은 요세푸스 순열로 넣는다.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1244 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 사람의 수를 입력 받자.
		int peopleCnt = sc.nextInt();

		// 양의 정수 K를 입력 받자.
		int k = sc.nextInt();

		// 큐 배열을 만들자.
		Queue<Integer> q = new LinkedList<>();

		// 1부터 n까지의 숫자를 큐 배열에 넣어보자.
		for (int i = 1; i <= peopleCnt; i++) {
			// offer : 큐에 삽입하는 메서드
			q.offer(i);
		}

		// StringBuilder를 이용해 출력한다.
		StringBuilder sb = new StringBuilder();
		sb.append("<");

		// 큐가 빌 때 까지 반복하자.
		while (!q.isEmpty()) {
			// i는 1부터 k까지 반복한다.
			for (int i = 1; i <= k; i++) {
				// i가 k와 같다면
				if (i == k) {
					// 큐에서 빼낸 후 sb에 추가하자.
					// poll : 큐에서 빼내는 메서드
					sb.append(q.poll()).append(", ");
				}
				// i가 k가 아닌 경우에는
				else {
					// 큐에서 빼낸 후 다시 뒤로 넣자.
					q.offer(q.poll());
				}

			}
		}
		// 반복문이 끝났을 때는 sb에 <1, 2, 3, 과 같은 형태로 들어있으므로,
		// sb.delete를 통해 마지막 콤마와 띄어쓰기를 삭제해주자.
		sb.delete(sb.length() - 2, sb.length());

		// sb에 >를 입력 후 출력한다.
		sb.append(">");
		System.out.println(sb);

	}
}
