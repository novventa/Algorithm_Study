
public class Stack {
	int size = Integer.MAX_VALUE;
	int[] arr = new int[size];
	int top = -1;
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == size - 1;
	}
	
	public void push(int item) {
		if (isFull()) {
			System.out.println("스택이 가득차서 더 이상 입력할 수 없습니다.");
			return;
		}
		
		arr[++top] = item;
	}
	
	public int pop() {
		if (isEmpty()) {
			System.out.println("스택이 비어있어 뺄 수 있는 값이 없습니다");
			return Integer.MIN_VALUE;
		}
		
		return arr[top--];
	}
	
	public int peek() {
		if (isEmpty()) {
			System.out.println("스택이 비어있어 조회할 수 있는 값이 없습니다");
			return Integer.MIN_VALUE;
		}
		
		return arr[top];
	}
	
	public int size() {
		return top + 1;
	}
	
	public void print() {
		if (isEmpty()) {
			System.out.println("큐가 비어있어 출력할 수  있는 값이 없습니다");
			return;
		}
		
		for (int idx = top; idx >= 0; idx--) {
			System.out.print(arr[idx] + " ");
		}
		System.out.println();
	}

}
