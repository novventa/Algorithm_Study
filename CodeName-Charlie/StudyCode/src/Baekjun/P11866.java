
// 요세푸스 문제는 다음과 같다.
// 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
// 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
// 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
// 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
// N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

package Baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P11866 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // N명의 사람을 나타내는 변수 N을 스캐너로 입력 받는다.
		int K = sc.nextInt(); // 변수 K를 입력 받는다.
		sc.close(); // 스캐너를 닫는다.
		
		int[] arr = new int[N]; // 수열을 저장할 배열 arr를 생성한다.
		
		for(int i = 1; i <= N; i++) { // 반복문을 통해 Queue에 1부터 N까지의 숫자를 순차적으로 저장한다.
			q.offer(i);
		}
		int idx = 0; // 배열의 인덱스를 나타낼 변수를 선언하고 0으로 초기화 한다.
		while(q.size() != 0) { // while문을 Queue의 크기가 0이 될 때까지 반복한다.
			for(int i = 0; i < (K-1); i++) { // 변수 K-1만큼의 사람을 넘기고 
				q.offer(q.peek()); // (peek메서드로 확인 후, offer메서드로 뒤에 추가한 뒤,
				q.poll(); // poll메서드를 통해 앞에서 제거),
			}
			arr[idx] = (int) q.peek(); // K번째 사람을 확인해 배열에 넣고,
			q.poll(); // 제거한 뒤,
			idx++; // 배열의 인덱스 값을 1 증가시킨다.
		}
		System.out.print("<"); // 규칙에 맞게 수열을 출력한다.
		for(int i = 0; i < (N-1); i++) {
			System.out.print(arr[i]+ ", ");
		}
		System.out.print(arr[N-1]+">");
	}
	static Queue q = new LinkedList(); // Queue를 생성한다.
}
