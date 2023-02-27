package day0216;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1158 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// N명의 사람(1~N번)
		int N = sc.nextInt();
		// K번째 사람을 제거
		int K = sc.nextInt();

		// 사람들을 넣는 큐 생성
		Queue<Integer> queue = new LinkedList<>();
		// 결과 값 출력을 위한 큐 생성(K번째에 순서대로 해당)
		Queue<Integer> result = new LinkedList<>();

		// 1명의 사람은 그대로 출력
		if (N == 1) {
			System.out.println("<1>");
		} else {
			// 사람이 2명 이상일 경우
			// 큐에 값 대입
			for (int i = 0; i < N; i++) {
				queue.add(i + 1);
			}

			// 큐가 비워질 때까지
			while (!queue.isEmpty()) {
				// K번째 전까지 큐에서 뽑아서 다시 뒤로 넣는다
				for (int i = 1; i < K; i++) {
					queue.add(queue.poll());
				}
				// K번째 때에는 큐에서 뽑아 결과 출력을 위한 큐에 넣는다
				// 해당 과정을 반복하면 K배수 번째 때마다 결과 출력을 위한 큐에 넣을 수 있다.
				result.add(queue.poll());
			}

			System.out.print("<");

			for (int i = 1; i < N; i++) {
				System.out.print(result.poll());
				System.out.print(", ");
			}
			System.out.print(result.poll() + ">");

		}

		sc.close();
	}
}
