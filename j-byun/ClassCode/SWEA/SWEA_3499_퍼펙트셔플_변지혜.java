import java.util.Scanner;

// 3499 퍼펙트 셔플
// D3

// 문제
// 카드 덱을 절반으로 나누고 나눈 것들에서 교대로 카드를 뽑아 새로운 덱을 만드는 것
// n개의 카드 -> n이 홀수면 먼저놓는 쪽에 한 장이 더 들어감

// 풀이
// origin큐에 입력받고
// math.ceil n/2 만큼 half1에 넣고
// 나머지는 origin큐가 빌 때 까지 half2에 넣기

// 다시 half1, half2가 다 빌 때 까지 한 번 씩 dequeue해서 origin에 enqueue하기

public class SWEA_3499_퍼펙트셔플_변지혜 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt(); // 테스트케이스 개수 입력받기

		for (int testCase = 1; testCase <= t; testCase++) { // 테케 개수만큼 반복

			double length = sc.nextDouble(); // 카드 덱의 길이 입력받기

			Queue origin = new Queue(); // 원래의 카드 덱을 입력받을 origin큐 만들기

			for (int idx = 0; idx < length; idx++) { // 카드 덱 길이만큼 origin큐에 카드정보 입력넣기
				origin.enqueue(sc.next());
			}
			
			Queue half1 = new Queue(); // 카드를 반 나눠서 저장할 덱 두개 만들고
			Queue half2 = new Queue();
			
			String card; // 하나 뽑아낸 카드 저장할 공간

			for (int idx = 0; idx < Math.ceil(length / 2); idx++) { // 카드의 절반을 half에 넣기
				card = origin.dequeue();
				half1.enqueue(card);
			}
			
			while (!origin.isEmpty()) { // origin에 남은 나머지 카드를 다 half2에 넣기
				card = origin.dequeue();
				half2.enqueue(card);
			}
			
			while (!half1.isEmpty() || !half2.isEmpty()) { // 반으로 나눈 두 큐가 빌 때 까지
				if (!half1.isEmpty()) { // half1에 남은 카드가 있으면
					card = half1.dequeue(); // half1에서 카드 뽑아서
					origin.enqueue(card); // origin에 다시 넣어줌
				}

				if (!half2.isEmpty()) { // half2에 남은 카드가 있으면
					card = half2.dequeue(); // half2에서 카드 뽑아서
					origin.enqueue(card); // origin에 다시 넣어줌
				}
			}

			System.out.print("#" + testCase + " "); // 출력양식
			origin.print(); // origin 카드 덱 출력
			System.out.println(); // 개행
		}

	}

	private static class Queue { // 배열로 큐 구현

		int size = 3000;
		String[] queue = new String[size];
		int front = -1;
		int rear = -1;

		// isFull
		public boolean isFull() {
			return rear + 1 == size;
		}

		// isEmpty
		private boolean isEmpty() {
			return front == rear;
		}

		// enque
		// rear++하고 값 넣기 => 현재 rear에는 값 있음
		public void enqueue(String x) {
			if (isFull()) {
				System.out.println("큐가 가득 차서 더 이상 값을 넣을 수 없습니다.");
				return;
			}

			rear = rear + 1;
			queue[rear] = x;
		}

		// deque
		// front++하고 값 빼기 => 현재 front에는 값 없음
		public String dequeue() {
			if (isEmpty()) {
				System.out.println("큐가 비어있어서 삭제할 값이 없습니다.");
				return null;
			}

			front = front + 1;
			return queue[front];
		}

		// print
		public void print() {
			if (isEmpty()) {
				System.out.println("큐가 비어있어서  출력할 값이 없습니다.");
				return;
			}

			for (int idx = front + 1; idx <= rear; idx++) {
				System.out.print(queue[idx] + " ");
			}
		}

	}

}
