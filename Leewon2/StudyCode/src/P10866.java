import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

// 문제 조건
// push_front X: 정수 X를 덱의 앞에 넣는다.
// push_back X: 정수 X를 덱의 뒤에 넣는다.
// pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
// pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
// size: 덱에 들어있는 정수의 개수를 출력한다.
// empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
// front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
// back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
// 1 <= N <= 10,000
// 1<= 주어지는 정수 <= 100,000
// 위의 조건 외의 명령은 주어지지 않는다.

// 문제 해결
// push_front X : offerFirst
// push_back X: offerLast
// pop_front : size가 0이면 -1을 출력, sysout(pollFirst)
// pop_back : size가 0이면 -1을 출력, 아니라면 sysout(pollLast)
// size : size를 출력
// empty : size가 0이라면 1을 출력, 아니라면 0을 출력
// front : size가 0이라면 -1을 출력, 아니라면 peekFirst
// back : size가 0이라면 -1을 출력, 아니라면 peekLast

// 덱 : 배열을 앞뒤에서 추가, 삭제가 자유로워 스택과 큐를 합한 것과 비슷하다.

public class P10866 {
	public static void main(String[] args) throws IOException {

		// 시간초과 문제를 해결하기 위해 버퍼드리더를 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 덱을 사용하고, 덱의 결괏값은 int이므로 Deque의 제네릭 타입은 Integer로 설정한다.
		Deque<Integer> deck = new LinkedList<>();

		// 버퍼드리더의 경우 모두 string으로 받기 때문에
		// Interger.parseInt를 통해 정수형으로 변환한다.
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {

			// method = br.readLine().split(" ")을 통해 공백을 기준으로 문자열을 나눈다.
			// 문자열을 나웠을 때, method[0]는 공백을 기준으로 앞, method[1]은 공백을 기준으로 뒤에있는 값이다.
			String[] method = br.readLine().split(" ");

			// 문자열의[0]이 push_front인 경우
			if (method[0].equals("push_front")) {
				// 문자열의[1]을 숫자형으로 변환하고
				int num = Integer.parseInt(method[1]);
				// offerFirst 함수를 이용해 덱의 앞에 저장한다
				// offerFrist : 덱의 맨 앞에 요소 저장
				deck.offerFirst(num);

			}

			// 문자열의[0]이 push_back인 경우
			if (method[0].equals("push_back")) {
				// 문자열의[1]을 숫자형으로 변환하고
				int num = Integer.parseInt(method[1]);
				// offerLast 함수를 이용해 덱의 맨 뒤에 저장한다
				// offerLast : 덱의 맨 뒤에 요소 저장
				deck.offerLast(num);
			}

			// 문자열의[0]이 front인 경우
			if (method[0].equals("front")) {
				// 덱의 크기가 0이라면 -1을 출력 (빈 배열이라면 -1 출력)
				if (deck.size() == 0) {
					System.out.println(-1);
					// 덱의 크기가 0이 아니라면
					// 가장 앞에있는 요소를 출력
					// peekFirst : 배열의 가장 앞 요소를 조회
				} else {
					System.out.println(deck.peekFirst());
				}
			}

			// 문자열의[0]이 back인 경우
			if (method[0].equals("back")) {
				// 덱의 크기가 0이라면 -1을 출력
				if (deck.size() == 0) {
					System.out.println(-1);
					// 덱의 크기가 0이 아니라면
					// 가장 뒤에있는 요소를 출력
					// peekLast : 배열의 가장 뒷 요소를 조회
				} else {
					System.out.println(deck.peekLast());
				}
			}

			// 문자열의[0]이 pop_front인 경우
			if (method[0].equals("pop_front")) {
				// 덱의 크기가 0이라면 -1을 출력
				if (deck.size() == 0) {
					System.out.println(-1);
					// 덱의 크기가 0이 아니라면
					// 가장 앞에있는 요소를 삭제하고 출력한다
					// pollFirst : 배열의 가장 앞 요소를 삭제
				} else {
					System.out.println(deck.pollFirst());
				}
			}

			// 문자열의[0]이 pop_back인 경우
			if (method[0].equals("pop_back")) {
				// 덱의 크기가 0이라면 -1일 출력
				if (deck.size() == 0) {
					System.out.println(-1);
					// 덱의 크기가 0이 아니라면
					// 가장 뒤에있는 요소를 삭제하고 출력한다
					// pollLast : 배열의 가장 뒷 요소를 삭제
				} else {
					System.out.println(deck.pollLast());
				}
			}

			// 문자열의[0]이 size인 경우
			if (method[0].equals("size")) {
				// 덱의 사이즈를 출력한다.
				// size : 덱의 크기
				System.out.println(deck.size());
			}

			// 문자열의[0]이 empty인 경우
			if (method[0].equals("empty")) {
				// 덱의 크기가 0이라면 -1일 출력
				if (deck.size() == 0)
					System.out.println(1);
				// 덱의 크기가 0이 아니라면 0을 출력
				else
					System.out.println(0);
			}
		}
	}
}
