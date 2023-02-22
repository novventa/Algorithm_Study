
// 큐
// 원형 큐
// 배열로 구현하기

public class Queue_변지혜 {

	static int size = 10;
	static int[] queue = new int[size];
	static int front = 0, rear = 0;
	// front 인덱스는 항상 비워두기
	// => 큐 크기가 size - 1일 때 꽉 찬 것

	public static void main(String[] args) {

		// 메인에서 메소드 테스트
		enqueue(queue, 1);
		enqueue(queue, 2);
		enqueue(queue, 3);
		dequeue(queue);

		print(queue);
		
		System.out.println(size(queue));
		
	}

	// isFull
	private static boolean isFull(int[] queue) {
		return (rear + 1) % size == front;
	}

	// isEmpty
	private static boolean isEmpty(int[] queue) {
		return front == rear;
	}

	// enque
	// rear++하고 값 넣기 => 현재 rear에는 값 있음
	private static void enqueue(int[] queue, int x) {
		if (isFull(queue)) {
			System.out.println("큐가 가득 차서 더 이상 값을 넣을 수 없습니다.");
			return;
		}

		rear = (rear + 1) % size;
		queue[rear] = x;
	}

	// deque
	// front++하고 값 빼기 => 현재 front에는 값 없음
	private static int dequeue(int[] queue) {
		if (isEmpty(queue)) {
			System.out.println("큐가 비어있어서 삭제할 값이 없습니다.");
			return -2000000000;
		}

		front = (front + 1) % size;
		return queue[front];
	}

	// peek
	private static int peek(int[] queue) {
		if (isEmpty(queue)) {
			System.out.println("큐가 비어있어서 조회할 값이 없습니다.");
			return -2000000000;
		}
		
		return queue[rear];
	}

	// print
	private static void print(int[] queue) {
		if (isEmpty(queue)) {
			System.out.println("큐가 비어있어서  출력할 값이 없습니다.");
			return;
		}
		
		for (int idx = (front + 1) % size; idx <= rear; idx++) {
			System.out.println(queue[idx]);
		}
	}

	// size
	private static int size(int[] queue) {
		return rear - front;
	}
}
