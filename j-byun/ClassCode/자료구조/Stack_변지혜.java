
public class Stack_변지혜 {
	public static int size = Integer.MAX_VALUE;
	public static int[] arr = new int[size];
	public static int top = -1;
	
	public static boolean isEmpty() {
		return top == -1;
	}
	
	public static boolean isFull() {
		return top == size - 1;
	}
	
	public static void push(int item) {
		if (isFull()) {
			System.out.println("스택이 가득차서 더 이상 입력할 수 없습니다.");
			return;
		}
		
		arr[++top] = item;
	}
	
	public static int pop() {
		if (isEmpty()) {
			System.out.println("스택이 비어있어 뺄 수 있는 값이 없습니다");
			return Integer.MIN_VALUE;
		}
		
		return arr[top--];
	}
	
	public static int peek() {
		if (isEmpty()) {
			System.out.println("스택이 비어있어 조회할 수 있는 값이 없습니다");
			return Integer.MIN_VALUE;
		}
		
		return arr[top];
	}
	
	public static int size() {
		return top + 1;
	}
	
	public static void print() {
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
