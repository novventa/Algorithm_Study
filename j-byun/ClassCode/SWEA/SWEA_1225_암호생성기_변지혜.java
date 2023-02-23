import java.util.Scanner;

// 1225 암호생성기
// D3

// 문제
// 다음 조건에 따라 n개의 수를 처리하면 8자리의 암호가 생성된다!
// 1. 8개의 숫자 입력
// 2. 첫번째 숫자-1해서 맨뒤로 보내기
// 3. 다음 첫번째 숫자-2 해서 맨뒤로 보내기
// 4. 다음은 -3, -4, -5 / 까지하고 다시 1~5 돌기
// 	=> 숫자-a 한게 < 0 일경우 얘는 0으로 저장해서 맨뒤로 보내고 프로그램 종료
//		=> 프로그램 종료 후 남은 8자리의 수가 암호임

// 조건
// 주어지는 수는 모두 int범위 내
// 마지막 암호 배열은 모두  한 자리 수

// 풀이
// 큐에 8개의 수 차례대로 입력받기
// int num = 1;
// while () 동안
// 큐에서 값 뽑아서 - num++하고 다시 큐에 넣기 반복
// 마지막에 넣은 값이 < 0이면 0으로 바꿔서 집어넣기
// 마지막에 넣은 값이 0보다 작으면 while문 종료
//	=> 큐에서 차례대로 뽑아서 출력

public class SWEA_1225_암호생성기_변지혜 {
	static StringBuilder sb = new StringBuilder();
	static Scanner sc = new Scanner(System.in);

	static Queue password;

	public static void receiveNums() { // 8개의 숫자를 암호 큐에 입력받는 method
		password = new Queue(20); // 숫자를 입력받을 password 큐 만들기

		for (int idx = 0; idx < 8; idx++) { // 8개의 숫자 차례대로 큐에 입력받기
			password.enQueue(sc.nextInt());
		}
	}

	public static void encryptNums() { // 입력된 숫자 암호화 진행하기
		int num = 1; // 뺄 숫자는 1부터 시작
		int current = password.peek();

		while (current != 0) { // 마지막으로 넣은 숫자가 0이면 종료
			current = password.deQueue(); // 큐의 제일 앞 숫자를 꺼내서

			current -= num++; // 뺄 만큼 빼고
			
			if (num == 6) // 이 때 빼줄 숫자가 6이 되면
				num = 1; // 다시 1로 돌아가기

			if (current < 0) // 빼고나서의 값이 0보다 작아지면
				current = 0; // 0으로 만들어버리고

			password.enQueue(current); // 큐의 맨 뒤에 값 넣기
			
		}
	}

	public static void main(String[] args) {

		for (int tc = 1; tc <= 10; tc++) { // 테스트케이스 10개만큼 반복 실행
			int testCase = sc.nextInt(); // 테스트케이스 번호 입력받기

			sb.append("#").append(tc).append(" "); // 출력 양식

			receiveNums(); // 숫자 8개 입력받기

			encryptNums(); // 숫자 암호화 진행하기

			password.print();// 암호화 끝난 숫자 출력문자에 더하기

//			sb.append("\n"); // 테스트케이스 하나 끝나면 개행 => print method에 개행 넣어놔서 생략
		}

		System.out.println(sb); // 출력
	}

	// 원형 큐
	public static class Queue {
		int size;
		int[] arr;
		int front = 0, rear = 0;

		public Queue(int size) {
			super();
			this.size = size;
			this.arr = new int[size];
		}

		public boolean isEmpty() {
			return front == rear;
		}

		public boolean isFull() {
			return (rear + 1) % size == front;
		}

		public void enQueue(int item) {
			if (isFull()) {
				sb.append("큐가 가득차서 더 이상 입력할 수 없습니다.");
				return;
			}

			rear = (rear + 1) % size;
			arr[rear] = item;
		}

		public int deQueue() {
			if (isEmpty()) {
				sb.append("큐가 비어있어 뺄 수 있는 값이 없습니다");
				return Integer.MIN_VALUE;
			}

			front = (front + 1) % size;
			return arr[front];
		}

		public int peek() {
			if (isEmpty()) {
				sb.append("큐가 비어있어 조회할 수  있는 값이 없습니다");
				return Integer.MIN_VALUE;
			}

			return arr[(front + 1) % size];
		}

		public int size() {
			if (rear >= front) {
				return rear - front;
			} else {
				return rear - front + size;
			}
		}

		public void print() {
			if (isEmpty()) {
				sb.append("큐가 비어있어 출력할 수  있는 값이 없습니다");
				return;
			}

			for (int idx = front + 1; (idx % size) != rear; idx++) {
				idx %= size;
				sb.append(arr[idx] + " ");
			}
			sb.append(arr[rear]);
			sb.append("\n");
		}

	}

}
