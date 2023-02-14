package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2164 {
	public static void main(String[] args) {
		// Scanner로 입력받기
		Scanner sc = new Scanner(System.in);

		// Queue 정의
		Queue<Integer> card = new LinkedList<>();

		// 카드의 개수 받아오기
		int N = sc.nextInt();
		
		// 받은 후 스캐너 종료
		sc.close();
		
		// 큐로 카드 배열에 추가하기
		for (int i = 0; i < N; i++) {
			card.offer(i + 1);
		}
		
		// card size 를 변수에 저장		
		int size = card.size();
		
		// 아래 반복문을 queue의 size가 1이 될때까지 반복한다
		while (size > 1) {
			
			// poll을 통해 맨앞에 있는 카드를 하나 버린다
			card.poll();
			// queue는 사이즈가 늘어났다 줄어든다고
			// size가 줄어들지 않고 유지 되기때문에 원소를 뺏을 시 size를 줄여야한다
			size--;
			
			// 그 후 맨위에 있는 카드를 밑으로 보내기 위해
			// poll로 맨위 카드를 빼와서 변수에 저장한다
			int tmp = card.poll();

			// 이후 offer로 아랫부분에 다시 넣어준다.
			card.offer(tmp);
			
		}
		// size가 1이므로 카드가 한개가 남았을 때이다.
		// peek를 통해 하나남은 카드를 출력한다.
		System.out.println(card.peek());
	}
}
