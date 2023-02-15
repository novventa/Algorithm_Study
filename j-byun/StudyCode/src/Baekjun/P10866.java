package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {
		// 덱
		// 10866 덱
		// 실버4
		
		// Deque (Double-Ended Queue)
		// 큐의 양쪽으로 엘리먼트의 삽입과 삭제 가능한 자료구소
		// 입출력 방향에 따라 스택or큐 로 사용할 수 있다
		// 한 쪽으로만 입력 가능한 덱 : 스크롤 scroll
		// 한 쪽으로만 출력 가능한 덱 : 셸프 shelf
		// 선언 : Deque<자료형> deque = new LinkedList<>();
		// ArrayDeque, LinkedBlockingDeque, ConcurrentLinkedDeque, LinkedList 다 사용가능
		// 위의 클래스들은 모두 덱 인터페이스를 구현한 클래스임
		
		// push_front X : 정수 X를 덱의 앞에 넣기 == offerFirst()
		// push_back X : 정수 X를 덱의 뒤에 넣기 == offerLast()
		// pop_front : 덱의 가장 앞에 있는 수를 빼고 그 수 출력하기 == sysout(pollFirst())
		//			 : 만약 덱에 들어있는 정수가 없는 경우 -1 출력
		// pop_back : 덱의 가장 뒤에 있는 수를 빼고 그 수 출력하기 == sysout(pollLast())
		//			: 만약 덱에 들어있는 정수가 없는 경우 -1 출력
		// size : 덱에 들어있는 정수의 개수 출력 == .size()
		// empty : 덱이 비어있으면 1, 아니면 0 출력 == .isempty()
		// front : 덱의 가장 앞에 있는 정수 출력 == sysout(peekFirst())
		//		 : 만약 덱에 들어있는 정수가 없는 경우 -1 출력
		// back : 덱의 가장 뒤에 있는 정수 출력 == sysout(peekLast)
		//		: 만약 덱에 들어있는 정수가 없는 경우에는 -1 출력
		
		// 명령의 수 n 입력받고
		// 둘째 줄 부터 n개의 명령이 한 줄에 하나씩 주어진다
		// 1 <= X <= 100000
		
		// 스캐너는 시간초과떠서 버퍼드리더로 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 명령의 수 n 입력받기
		int n = Integer.parseInt(br.readLine());
		
		// 값을 저장할 덱 만들기
		Deque<Integer> intDeque = new ArrayDeque<>();
		
		// 명령을 n번 수행해야 하니까 n번만큼 반복
		for (int i = 0; i < n; i++) {
			
			// 명령 입력받기
			// 명령을 띄어쓰기 기준으로 분리해서
			String[] s = br.readLine().split(" ");
			
			// 앞의 문자열은 command로 저장하고
			String command = s[0];
			
			// 뒤의 int는 int x에 저장하는데
			// int 입력값이 없는 경우를 위해 초기값을 0으로 선언하고
			int x = 0;
			
			// int 입력값이 있다면 입력값으로 업데이트 해준다
			if (s.length == 2) {
				x = Integer.parseInt(s[1]);
			}
			
			// 덱프로그램 실행하기
			DequeProgram(intDeque, command, x);
			
		}
		
	}
	
	// 입력된 명령어에 맞는 행동을 실행하는 DequeProgram 메소드 만들기
	public static void DequeProgram(Deque<Integer> deque, String command, int x) {
		
		if (command.equals("push_front")) {
			deque.offerFirst(x);
		}
		
		if (command.equals("push_back")) {
			deque.offerLast(x);
		}
		
		if (command.equals("pop_front")) {
			if (deque.isEmpty()) {
				System.out.println("-1");
			} else {
				System.out.println(deque.pollFirst());
			}
		}
		
		if (command.equals("pop_back")) {
			if (deque.isEmpty()) {
				System.out.println("-1");
			} else {
				System.out.println(deque.pollLast());
			}
		}
		
		if (command.equals("size")) {
			System.out.println(deque.size());
		}
		
		if (command.equals("empty")) {
			if (deque.isEmpty()) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
		}
		
		if (command.equals("front")) {
			if (deque.isEmpty()) {
				System.out.println("-1");
			} else {
				System.out.println(deque.peekFirst());
			}
		}
		
		if (command.equals("back")) {
			if (deque.isEmpty()) {
				System.out.println("-1");
			} else {
				System.out.println(deque.peekLast());
			}
		}
		
	}

}






