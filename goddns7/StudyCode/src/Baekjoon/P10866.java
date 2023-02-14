package day0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P2775 {

	static Deque<Integer> dq = new ArrayDeque<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(sc.readLine());

		for (int i = 0; i < N; i++) {
			String order = sc.readLine();

			String[] arr = new String[2];

			arr = order.split(" ");

			if (arr[0].equals("push_back")) {
				push_back(Integer.parseInt(arr[1]));
			} else if (arr[0].equals("push_front")) {
				push_front(Integer.parseInt(arr[1]));
			} else if (arr[0].equals("pop_front")) {
				System.out.println(pop_front());
			} else if (arr[0].equals("pop_back")) {
				System.out.println(pop_back());
			} else if (arr[0].equals("size")) {
				System.out.println(size());
			} else if (arr[0].equals("empty")) {
				System.out.println(empty());
			} else if (arr[0].equals("front")) {
				System.out.println(front());
			} else {
				System.out.println(back());
			}
		}

		sc.close();
	}

	static void push_back(int x) {
		dq.add(x);
	}

	static void push_front(int x) {
		dq.addFirst(x);
	}

	static int pop_front() {
		if (dq.size() != 0) {
			return dq.removeFirst();
		} else {
			return -1;
		}
	}

	static int pop_back() {
		if (dq.size() != 0) {
			return dq.removeLast();
		} else {
			return -1;
		}
	}

	static int size() {
		return dq.size();
	}

	static int empty() {
		if (dq.size() == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	static int front() {
		if (dq.size() != 0) {
			return dq.getFirst();
		} else {
			return -1;
		}
	}

	static int back() {
		if (dq.size() != 0) {
			return dq.getLast();
		} else {
			return -1;
		}
	}
}
