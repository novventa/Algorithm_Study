import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	// 스택
	// 9012 괄호
	// 실버4

	// 문자열에서 () 인접한 완성형 괄호 빼버리기
	// 다 뺐을 때 )나 ( 하나라도 남으면 NO 출력,
	// 다 짝 있는 괄호여서 모든 괄호가 빠져나갔으면 YES 출력
	// ))(( 이런 경우 짝이 안맞으니까 NO 출력

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		// 풀이 2 => 풀이 1 에서 무식하게 풀어서 다시 풀었음

		// 테스트케이스 t만큼 반복
		outer: for (int testCase = 0; testCase < t; testCase++) {
			String s = br.readLine();

			// 새로운 테스트 케이스 실행될 때 마다 스택 초기화
			Stack<Character> bracket = new Stack<>();

			// 입력된 문자열 길이만큼 확인
			for (int idx = 0; idx < s.length(); idx++) {
				// 문자열의 idx번째 괄호가 여는 괄호면
				// 스택에 push
				if (s.charAt(idx) == '(') {
					bracket.push('(');
				} else {
					// 문자열의 idx번째 괄호가 닫는 괄호면
					// 스택에서 pop -> 여는 괄호 하나를 빼버림
					// -> () 얘네 둘이 세트로 날려버릴거니까!
					if (bracket.isEmpty()) {
						// 근데 만약에 스택이 비어있는 상태면
						// 1. 문자열의 제일 처음이 닫는 괄호 ) 로 시작하거나
						// 2. 앞에 나왔던 여는 괄호(의 개수보다 닫는 괄호) 의 개수가 많거나
						// => 결국 짝이 맞을 수 없음!!
						// -> no출력하고 다음 테스트 케이스로 넘어가기
						System.out.println("NO");
						continue outer;
					}
					// 위의 if문에 안걸렸으면 스택에 뺄 수 있는 여는 괄호( 가 있는거니까 pop하기
					bracket.pop();
				}
			}

			// for문 다 돌았는데
			// 스택이 비어있으면 괄호 세트()가 잘 맞아서 남는게 없는거니까
			// yes 출력
			if (bracket.isEmpty()) {
				System.out.println("YES");
			} else {
				// for문 다 돌았는데 스택이 비어있지 않으면
				// 여는 괄호(가 더 많은 경우임
				// => 결국 짝 안맞는건 똑같으니 no프린트
				System.out.println("NO");
			}
		}
		br.close();

//		// 풀이 1 => 무식하게 풀었음
//
//		// 입력 문자열 개수 t만큼 반복
//		outer: for (int testCase = 0; testCase < t; testCase++) {
//			String s = br.readLine();
//
//			Stack<Character> bracket = new Stack<>();
//
//			// 괄호 하나씩 스택에 쌓기
//			for (int i = 0; i < s.length(); i++) {
//				bracket.push(s.charAt(i));
//			}
//
//			// 스택의 제일 마지막이 ( 여는 괄호면 no
//			if (bracket.peek() == '(') {
//
//				System.out.println("NO");
//				continue outer;
//			}
//
//			// ( : -1, ) : +1 카운트 할 cnt 선언
//			// stack은 뒤에서부터 빼니까 ) 를 +1로 정의, cnt가 음수가 되는 즉시 break;
//			int cnt = 0;
//
//			// 괄호 개수 세기
//			int size = bracket.size();
//
//			// 괄호의 개수 -1 만큼 카운트하기
//			for (int idx = 0; idx < size - 1; idx++) {
//				if (bracket.peek() == '(') {
//					bracket.pop();
//					cnt--;
//					if (cnt < 0) {
//						System.out.println("NO");
//						continue outer;
//					}
//				} else if (bracket.peek() == ')') {
//					bracket.pop();
//					cnt++;
//				}
//			}
//
//			// 제일 마지막으로 남은 괄호는 제일 첫 번째 괄호이므로
//			// 남은게 ) 닫는 괄호라면 no 출력
//			if (bracket.peek() == ')') {
//				System.out.println("NO");
//				continue;
//			} else if (bracket.peek() == '(') {
//				// 남은게 ( 여는 괄호면 마저 카운트하기
//				bracket.pop();
//				cnt--;
//				if (cnt < 0) {
//					System.out.println("NO");
//					continue outer;
//				}
//			}
//
//			// 카운트 0 이면 개수 잘 맞게 닫혔으므로 yes출력
//			if (cnt == 0) {
//				System.out.println("YES");
//				continue;
//			} else {
//				// 여기까지 왔는데 카운트가 0이 아니면 (= 양수이면)
//				// ) 닫는 괄호의 개수가 더 많은거니까 no출력
//				System.out.println("NO");
//				continue;
//			}
//
//		}
//
//		br.close();

	}
}



