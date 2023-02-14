package Baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2164 {
	static Queue q = new LinkedList(); // Queue를 생성한다. Queue는 인터페이스 이기 때문에 LinkedList로 객체를 생성해준다.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 카드의 개수를 나타내는 변수 N을 입력받는다.
		
		for(int i = 1; i <= N; i++) { // 카드는 1부터 N까지 적혀있고, 차례대로 쌓여있기 때문에,
			q.offer(i); // offer 메서드를 통해 순차적으로 요소를 저장한다.
		}
		for(int i = 1; i <= (N-1); i++) {
			q.poll(); // 카드를 버리기 위해 poll 메서드를 사용하고, => 1
			if(q.size() == 1) { // 만약 카드가 한 장 남았다면(큐의 크기가 1이라면), => 4
				break; // 반복문을 멈춘다. => 5
			}
			q.offer(q.peek()); q.poll(); // 가장 앞에 있는 카드를 확인하고(peek()), => 2
			// 맨 뒤로 보내기 위해(offer(), poll()) 다음과 같은 매서드를 사용한다. => 3
		}
		System.out.println(q.peek()); // 남은 카드를 확인한다.
	}
}
