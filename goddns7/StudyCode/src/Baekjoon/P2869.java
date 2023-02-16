package day0213;

import java.util.LinkedList;
import java.util.Queue;

import java.util.Scanner;

public class P2869 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// N을 입력받음
		int N = sc.nextInt();
		int K = sc.nextInt();

		// int형 queue 선언
		Queue<Integer> queue = new LinkedList<Integer>();
		// 결과출력용
		Queue<Integer> result = new LinkedList<Integer>();
		// 1부터 N까지의 수를 하나씩 추가함
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		// N=1의 경우 실행하지 않기 때문에 그대로 출력
		if (queue.size() == 1) {
			result = queue;
			// N=1이 아닌 경우

			// 올라가는 A
			int a = sc.nextInt();
			// 떨어지는 B
			int b = sc.nextInt();
			// 높이
			int v = sc.nextInt();

			// 걸리는 날
			int count = 0;

			// 전제: 떨어지는 b는 올라가는 a보다 무조건 하루 더 적게 적용됨
			// a*걸리는 날 - b*(걸리는날 -1) >= v를 만족하면서
			// 나머지가 없다면 그대로,
			// 나머지가 있다면 +1을 더해주면 걸리는 날을 구할 수 있다.
			if ((v - b) % (a - b) == 0) {
				count = (v - b) / (a - b);
			} else {
				// 큐의 원소 개수가 1이 아니라면 1이 될때까지 진행
				while (!queue.isEmpty()) {
					// K전까지 삭제
					for (int n = 1; n < K; n++) {
						queue.offer(queue.poll());
					}
					// K는 result에 추가
					result.offer(queue.poll());
				}

				count = ((v - b) / (a - b)) + 1;
			}
			System.out.print("<");
			// 추가한 것들 하나씩 출력
			for (int i = 1; i < N; i++) {
				System.out.print(result.poll() + ", ");
			}
			System.out.print(result.poll());
			System.out.print(">");

			System.out.println(count);
			sc.close();
		}
	}
}