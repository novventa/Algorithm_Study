package study_ssafy2;

/*
 * 우선순위 큐를 활용한다.
 * 우선순위 큐에 카드 묶음 수를 넣고 빼내면
 * 가장 작은 카드 묶음의 개수가 나오게 되므로
 * 두개의 묶음을 뽑아서 더해가면 가장 최소로 비교해야하는 횟수를 알 수 있다.
 * 이때 두개의 묶음을 뽑아서 합쳐 준 후 우선순위 큐에 다시 넣어주어야 한다.
 * */
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1715_카드정렬하기_김현수 {
	static int N;
	static PriorityQueue<Integer> pq;

	public static void main(String[] args) {
		
		// 스캐너 사용
		Scanner sc = new Scanner(System.in);

		// 카드 묶음 수 받아오기
		N = sc.nextInt();
		
		// 우선순위큐 정의
		pq = new PriorityQueue<>();

		// 우선 순위 큐에 카드를 넣고
		for (int i = 0; i < N; i++) {
			pq.offer(sc.nextInt());
		}

		// 스캐너 사용종료
		sc.close();

		// 비교 횟수를 더해줄 변수
		int sum = 0;
		
		// 우선순위큐의 크기가 1이 될때 까지 반복
		while (pq.size() != 1) {
			
			// 두개의 묶음을 꺼내서 합친다
			int tmp = pq.poll() + pq.poll();
			
			// 비교횟수에 더해주고
			sum += tmp;
			
			// 우선순위큐에 넣어준다
			pq.offer(tmp);
		}

		// 결과 출력
		System.out.println(sum);

	}
}
