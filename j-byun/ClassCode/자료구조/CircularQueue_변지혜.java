
// 원형 큐
public class Queue {
	int size = Integer.MAX_VALUE;
	int[] arr = new int[size];
	int front = 0, rear = 0;

	public boolean isEmpty() {
		return front == rear;
	}

	public boolean isFull() {
		return (rear + 1) % size == front;
	}

	public void enQueue(int item) {
		if (isFull()) {
			System.out.println("큐가 가득차서 더 이상 입력할 수 없습니다.");
			return;
		}

		rear = (rear + 1) % size;
		arr[rear] = item;
	}

	public int deQueue() {
		if (isEmpty()) {
			System.out.println("큐가 비어있어 뺄 수 있는 값이 없습니다");
			return Integer.MIN_VALUE;
		}

		front = (front + 1) % size;
		return arr[front];
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("큐가 비어있어 조회할 수  있는 값이 없습니다");
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
			System.out.println("큐가 비어있어 출력할 수  있는 값이 없습니다");
			return;
		}
		
		for (int idx = front + 1; idx <= rear; idx++) {
			idx %= size;
			System.out.print(arr[idx] + " ");
		}
		System.out.println();
	}

}
