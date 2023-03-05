// 문제
// 문자열 S가 주어졌을 때, 문자열에서 단어만 뒤집는다.
// 알파벳 소문자, 숫자(0-9), 공백, 특수문자(< , >)로만 이루어져 있다.
// 특수문자의 경우 '<' 가 먼저 등장하며 '<' 과 '>'의 갯수는 같다.
// <>를 태그라고 부르며, 태그와 단어 사이에는 공백이 없다.
// 태그에는 알파벳 소문자와 공백만 있다.

// 문제 조건
// 문자열 S의 길이는 100,000 이하다.

// 문제 해결 방법
// 덱을 이용해 해결해보자.
// 태그와 태그 사이의 문자는 큐(FIFO), 나머지는 스택(LIFO)로 해결한다.
// 태그 사이에 있는 문자가 아닌 경우, 공백이나 태그를 만나면 출력하자.
// 1. 문자열 S를 입력 받는다.
// 2. 덱 배열을 선언한다.
// 3. 태그와 태그 사이에 있는 문자열은 들어간대로 나오게 하고,
// 나머지는 마지막에 들어간 문자가 처음에 나오도록 한다.

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class P17413 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 덱을 선언 해보자.
		Deque<Character> deque = new LinkedList<>();

		// 문자열 S를 입력 받자.
		String s = sc.nextLine();

		// 문자열 S를 char형 배열에 저장해보자.
		char[] str = s.toCharArray();
		// 앞에 담을지, 뒤에 담을지 결정하기 위해 boolean 타입의 변수를 만든다.
		boolean frontBack = false;

		// StringBuilder로 출력하자.
		StringBuilder sb = new StringBuilder();

		for (int idx = 0; idx < s.length(); idx++) {
			// true인 경우 앞에 담는다.
			if (frontBack) {
				deque.add(str[idx]);
				// '>'를 만나면
				if (str[idx] == '>') {
					// 덱이 빌 때 까지
					while (!deque.isEmpty()) {
						// sb에 저장하자.
						sb.append(deque.removeFirst());
					}
					// 태그가 닫혔으니, boolean 값을 false로 바꾸자.
					frontBack = false;
				}
			}

			// 공백 혹은 마지막 문자열을 만나면 가장 늦게 덱에 담은 것 부터 꺼내주자.
			else if (str[idx] == ' ' || idx == str.length - 1 || str[idx] == '<') {
				// 공백이라면 가장 처음에 입력한다.
				if (str[idx] == ' ') {
					deque.push(str[idx]);
				}
				// 마지막 문자열이면 마지막에 입력한다.
				else if (idx == str.length - 1) {
					deque.add(str[idx]);
				}
				// 덱이 빌 때 까지
				while (!deque.isEmpty()) {
					// 가장 늦게 들어간 것 부터 꺼내보자
					sb.append(deque.pollLast());
				}
				// 열린태그라면 덱이 비워지고 boolean값을 true로 바꾼 후 덱에 저장하자.
				if (str[idx] == '<') {
					frontBack = true;
					deque.add(str[idx]);
				}

			}

			// 열린 태그를 만나면,
			else if (str[idx] == '<') {
				// 덱의 첫번째에 담고 boolean 값을 true로 바꿔준다.
				deque.add(str[idx]);
				frontBack = true;
			}

			// 일반 문자열인 경우
			else {
				// 덱의 마지막에 삽입해주자.
				deque.add(str[idx]);

			}
		}
		System.out.println(sb);
	}
}
