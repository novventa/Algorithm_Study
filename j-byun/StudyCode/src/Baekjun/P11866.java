import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Stream;

public class Main {
	// 큐
	// 11866 요세푸스 문제 0
	// 실버5
	
	// k번째 사람 제거
	// k보다 앞 사람들은 큐의 제일 뒤에 다시 넣기
	// k번째 제거했으면 k+1부터 다시 k번째 사람 제거
	// 큐가 다 비면 제거한 순서대로 값 출력

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		
		// n명의 사람, k번째 사람 제거 => 입력값 받기
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);

		br.close();
		
		// 크기가 n인 queue 만들기
		Queue<Integer> people = new LinkedList<>();
		
		// 큐에 1부터 n까지 차례로 입력넣기
		for (int i = 1; i <= n; i++) {
			people.offer(i);
		}
		
		// 출력된 큐 값을 저장할 새로운 큐 만들기
		Queue<Integer> result = new LinkedList<>();
		
		// 큐가 빌 때 까지 반복
		while (!people.isEmpty()) {
			// k-1번 만큼 큐의 맨 앞 값을 빼서 맨 뒤에 넣고
			for (int i = 0; i < k - 1; i++) {
				people.offer(people.poll());
			}
			// k번째 값은 빼서 result 결과 배열에 넣는다
			result.offer(people.poll());
		} 
		// 큐가 비면 필요한 결과 값은 result 배열에 차례대로 들어있다
		
//		Stream.of(result.toString()).forEach(System.out::println);

		// 양식 맞춰서 출력하기
		System.out.print("<");
		for (int i = 0; i < n; i++) {
			if (i == n - 1) {
				System.out.print(result.poll());
			} else {
				System.out.print(result.poll() + ", ");
			}
		}
		System.out.print(">");
		
		
	}
}



