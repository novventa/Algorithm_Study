package study;

/*
 *  큐는 앞과 뒤가 열려있는 배열이다.
 *  따라서 원탁에 앉는 경우 queue를 통해 문제를 쉽게 풀 수 있다.
 *  offer을 통해 원탁에 첫번째 앉은 사람을 뽑아내고
 *  이를 poll을통해 맨뒤로 다시 보내면서
 *  원탁의 시작 지점에 앉은 사람 맨뒤로 보내면서
 *  원탁 시작지점의 사람을 바꿀 수있다.
 *
 *  */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class solution_11866_요세푸스 {
	public static void main(String[] args) {

		// 스캐너로 입력받는다
		Scanner sc = new Scanner(System.in);
		// N과 K 값을 받는다.
		int N = sc.nextInt();
		int K = sc.nextInt();
		sc.close();
		// 사용할 Queue를 정의
		Queue<Integer> roundPerson = new LinkedList<>();

		// Queue에 사람숫자 추가.
		for (int i = 0; i < N; i++) {
			roundPerson.offer(i + 1);
		}

		// 밖으로 빠지는 사람의 수 저장할 배열
		int[] outPerson = new int[N];
		// outPerson에 사용할 index 저장할 배열
		int num = 0;

		// N은 원탁에 앉아있는 사람들의 size이므로
		// N이 1일때 까지 반복한다.
		while (N > 0) {
			// K번째 사람을 빼내야 하므로
			// K-1번째 사람까지는 빼낸후 뒤쪽에 추가해준다.
			for (int idx = 0; idx < K - 1; idx++) {
				roundPerson.offer(roundPerson.poll());
			}

			// 이후 K번째 사람은 빼내면서 outPerson 배열에 넣는다.
			// 후위 연산자를 통해 num을 늘린다.
			outPerson[num++] = roundPerson.poll();
			// 사람이 한명 빠졌으므로 size값을 줄인다.
			N--;
		}

		// outPerson의 size를 변수로 지정
		// for문에서 계속 값을 불러오는 것을 막기위해
		int size = outPerson.length;

		// 형식에 맞게 출력
		System.out.print("<");
		for (int i = 0; i < size - 1; i++) {
			System.out.print(outPerson[i] + ", ");
		}
		System.out.print(outPerson[size - 1] + ">");
	}
}
