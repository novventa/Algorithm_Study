import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 문제 조건
// 1 <= K <= N <= 1,000

// 문제 해결 방법
// 1. 배열에 1부터 n까지 수를 넣는다.
// 2-1. 1부터 n 까지 중 k와 일치하지 않으면 꺼낸 후 맨 뒤로 넣는다.
// 2-2. 1부터 n 까지 중 k와 일치하는 수를 만나면 꺼내어 출력한다.

public class P11866 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Queue queue = new LinkedList();
		// q 배열에서 k번째 수를 꺼낼 때 queue에 저장한다.
		Queue newQueue = new LinkedList();

		// 사람의 수와 k를 입력 받는다.
		int peopleCnt = sc.nextInt();
		int k = sc.nextInt();

		// 1. 1부터 사람의 수만큼 배열에 넣는다.
		for (int i = 1; i < peopleCnt + 1; i++) {
			queue.offer(i);
		}

		// 무한 반복을 이용해 배열이 null이 될 때 까지 반복한다.
		while (true) {
			for (int i = 1; i < k + 1; i++) {
				// i는 1부터 k+1까지 무한 반복한다.
				// queue.poll() : 가장 앞에있는 값을 빼낸다
				// queue.offer(object) : 맨 뒤에 값을 넣는다.
				// i와 k가 같지 않다면, 가장 앞에있는 값을 빼낸 후
				// 그 값을 다시 맨 뒤로 보낸다.
				if (i != k) {
					queue.offer(queue.poll());
				}
				// i와 k가 같다면, 가장 앞에있는 값을 빼낸 후
				// 그 값을 newQueue에 저장한다.
				else {
					newQueue.offer(queue.poll());
				}
			}

			// 종료 조건
			if (queue.isEmpty())
				break;
		}

		// 출력 형식에 맞춰 출력한다.
		System.out.print("<");
		for (int i = 0; i < peopleCnt - 1; i++) {
			// newQueue에 있는 값을 맨 앞부터 하나씩 출력하고
			// 출력 형식을 맞추기 위해 마지막 값은 따로 출력한다.
			System.out.print(newQueue.poll() + ", ");
		}
		System.out.print(newQueue.poll() + ">");
	}
}
