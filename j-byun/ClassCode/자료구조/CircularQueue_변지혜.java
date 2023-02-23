
// 원형 큐
public class CircularQueue_변지혜 {
	public static int size = Integer.MAX_VALUE;
	public static int[] arr = new int[size];
	public static int front = 0, rear = 0;

	public static boolean isEmpty() {
		return front == rear;
	}

	public static boolean isFull() {
		return (rear + 1) % size == front;
	}

	public static void enQueue(int item) {
		if (isFull()) {
			System.out.println("큐가 가득차서 더 이상 입력할 수 없습니다.");
			return;
		}

		rear = (rear + 1) % size;
		arr[rear] = item;
	}

	public static int deQueue() {
		if (isEmpty()) {
			System.out.println("큐가 비어있어 뺄 수 있는 값이 없습니다");
			return Integer.MIN_VALUE;
		}

		front = (front + 1) % size;
		return arr[front];
	}

	public static int peek() {
		if (isEmpty()) {
			System.out.println("큐가 비어있어 조회할 수  있는 값이 없습니다");
			return Integer.MIN_VALUE;
		}
		
		return arr[(front + 1) % size];
	}
	
	public static int size() {
		return rear - front;
	}
	
	public static void print() {
		if (isEmpty()) {
			System.out.println("큐가 비어있어 출력할 수  있는 값이 없습니다");
			return;
		}
		
		for (int idx = front + 1; idx <= rear; idx++) {
			idx %= size;
			System.out.println(arr[idx]);
		}
	}

}
