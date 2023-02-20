package test;


public class Stack_변지혜 {
	static int[] arr = new int[20];
	static int top = -1;
	
	public static void main(String[] args) {
		
		// 메인에서 메소드 테스트
		
		
	}
	
	private static void push(int x) {
		if (top == arr.length - 1) {
			System.out.println("stack overflow");
		}
		arr[++top] = x;
	}
	
	private static int pop() {
		if (top == -1) {
			System.out.println("stack is empty");
			return -1;
		}
		return arr[top--];
	}
	
	private static void print() {
		for (int idx = top; idx >= 0; idx--) {
			System.out.print(arr[idx] + " ");
		}
		System.out.println();
	}
	
	private static boolean isEmpty() {
		return top == -1;
	}
	
	private static boolean isFull() {
		return top == arr.length - 1;
	}

}


