
// 요세푸스 문제는 다음과 같다.
// 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다.
// 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
// 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
// N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

package Baekjun;

// 지난번 풀이에서, 메서드를 효율적으로 사용하는 것이 좋겠다는 피드백과,
// 배열을 생성해, 순열을 저장하는 것 보다는 LinkedList를 통해 순열을 저장하는 것이 편리할 것 같다는 피드백을 받았습니다.
// 해당 피드백을 적용해 코드를 짜 보았습니다.
// 큐를 생성해,
// 큐에 사람들의 번호를 입력 받고,
// 특정 번호에 해당되는 사람의 번호를 제거하면서, 해당 번호를 LinkedList에 순차적으로 저장한 뒤,
// 최종 값을 출력해보자.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1158 {
	
	static Queue q = new LinkedList(); // 사람들의 번호를 저장할 Queue q를 생성한다.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 사람 수 N을 입력 받는다.
		int K = sc.nextInt(); // 제거할 순번 K를 입력 받는다.
		
		LinkedList sequence = new LinkedList(); // 제거 대상의 번호를 순서대로 저장할 LinkedList sequence를 생성한다.
		
		for(int number = 1; number <= N; number++) { // 반복문을 사용해 1부터 N까지 실행한다.
			q.offer(number); // offer 메서드를 사용해서, q에 숫자를 순차적으로 저장한다. => {1, 2, 3, ... , N}
		}
		while(q.size() != 0) { // 큐의 크기가 0이 될 때까지, while문을 반복 실행한다. 
			for(int idx = 0; idx < (K-1); idx++) { // for문을 통해 맨 앞에 저장된 요소부터 K-1 번째 저장된 요소까지 
				q.offer(q.poll()); // poll과 offer 메서드를 통해, 큐의 뒤쪽으로 넘기고, => {K, K+1, ..., N, 1, 2, ..., K-1}
			}
			sequence.add(q.poll()); // 맨 앞에 K 번째 요소가 오면, poll 메서드를 사용해, 해당 값을 확인해 sequence에 저장하고, 큐에서는 삭제한다.
		} // q => {K}, sequence => {K+1, ..., N, 1, 2, ..., K-1}
		
		System.out.print("<"); // 출력 형식에 맞춰 값을 출력한다.
		for(int idx = 0; idx < sequence.size()-1; idx++) {
			System.out.print(sequence.get(idx) + ", ");
		}
		System.out.print(sequence.get(sequence.size()-1)+ ">");
	}
}
