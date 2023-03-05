import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// SWEA
// 1224 계산기3
// D4

// 스택을 써서 표현식을 바꾸고
// 그걸 계산해서 제출할 것

// 문제
// 문자열로 이루어진 계산식이 주어질 때,
// 이 계산식을 후위 표기식으로 바꾸어 계산하라

// 조건
// 연산자는 +, *, ()
// 숫자는 0~9까지의 정수만 있다

// 풀이
// 중위표기법 -> 후위표기법으로 변환 후
// 후위표기법 -> 계산해서 출력

public class SWEA_1224_계산기3_변지혜_2 {

	// 연산자의 우선순위를 저장할 hashMap
	static HashMap<Character, Integer> opPriority = new HashMap<Character, Integer>() {
		{
			put('(', 0);
			put('+', 1);
			put('-', 1);
			put('*', 2);
			put('/', 2);
		}
	};

	static int length; // 중위계산식의 길이
	static String infix; // 중위계산식
	static int result; // 계산 결과값

	static Queue<Character> postfix; // 후위계산식
	static Stack<Character> opsStack; // 연산자 스택
	static Stack<Integer> numStack; // 숫자 스택

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		// 테스트케이스 10개만큼 반복
		for (int tc = 1; tc <= 10; tc++) {

			// 출력 양식
			sb.append("#").append(tc).append(" ");

			// 계산식의 길이 입력받기
			length = sc.nextInt();

			// 중위표기법 계산식 입력받기
			infix = sc.next();

			// 중위표기법 -> 후위표기법으로 변환
			infixToPostfix();

			// 후위표기법 -> 계산하기
			calculatePostfix();

			// 계산 결과 출력
			sb.append(result).append("\n");

		}

		// 출력
		System.out.println(sb);
	}

	// 중위계산식 -> 후위계산식으로 변환
	private static void infixToPostfix() {
		postfix = new LinkedList<Character>();
		opsStack = new Stack<>();

		char current; // 현재 char를 저장할 공간
		char before; // 이전 char를 저장할 공간

		for (int idx = 0; idx < length; idx++) { // 계산식 길이만큼 반복 확인
			current = infix.charAt(idx); // 지금 확인할 char

			if (Character.isDigit(current)) { // 현재 char이 숫자면
				postfix.offer(current); // 바로 후위계산식에 넣기
				continue;

			} else { // 현재 char이 연산자면
				if (opsStack.isEmpty()) { // 연산자 스택이 비어있을 경우 바로 넣어주기
					opsStack.push(current);
					continue;
				}

				if (current == '(') { // 현재 char이 여는 괄호 '('라면 
					opsStack.push(current); // 바로 연산자 스택에 넣어주기
					continue;
				}
				
				if (current == ')') { // 연산자 스택이 비어있지 않고, 현재 연산자가 닫는 괄호 ')' 라면
					before = opsStack.peek();

					while (before != '(') { // 여는 괄호 '('가 나오기 전까지
						before = opsStack.pop();
						postfix.offer(before); // 연산자 스택에 쌓인 연산자 차례대로 꺼내서 후위계산식에 넣기
						before = opsStack.peek();
					}

					opsStack.pop(); // 여는 괄호 전까지의 연산자 다 꺼냈으면 여는 괄호 꺼내서 버리기
					continue;

				} else { // 연산자 스택이 비어있지 않고, 현재 연산자가 닫는 괄호가 아니라면
					before = opsStack.peek();

					while (opPriority.get(current) <= opPriority.get(before)) { // 내가 우선순위가 제일 높아질 때 까지
						before = opsStack.pop();
						postfix.offer(before); // 연산자 스택에 쌓인 연산자 차례대로 꺼내서 후위계산식에 넣기

						if (opsStack.isEmpty())
							break; // 연산자 스택에서 더 이상 꺼낼 연산자가 없으면 바로 나를 넣으면 되니까 break

						before = opsStack.peek();
					}

					opsStack.push(current); // 이제 내 우선순위가 제일 높으니까 연산자 스택에 넣기
					continue;

				}
			}
		}

		while (!opsStack.isEmpty()) { // 계산식 확인이 끝났으면 연산자 스택에 남은 연산자를 차례대로 후위계산식에 넣기
			current = opsStack.pop();
			postfix.offer(current);
		}

	}

	// 후위계산식 -> 계산하기
	private static void calculatePostfix() {
		numStack = new Stack<>();

		char current; // 현재 char를 저장할 공간
		int rightOperand; // 오른쪽 피연산자를 저장할 공간
		int leftOperand; // 왼쪽 피연산자를 저장할 공간
		int opResult = 0; // 연산 결과를 저장할 공간

		while (!postfix.isEmpty()) {
			current = postfix.poll();

			if (Character.isDigit(current)) { // 후위계산식에서 뽑아낸 문자가 숫자면
				numStack.push(current - '0'); // 숫자스택에 넣어주기
				continue;

			} else { // 후위계산식에서 뽑아낸 문자가 연산자면 연산자 종류별로 나눠서 연산하기
				rightOperand = numStack.pop(); // 연산자 기준 오른쪽에서 연산할 값 먼저 뽑고
				leftOperand = numStack.pop(); // 그 다음 뽑은 값은 연산자 기준 왼쪽에서 연산할 값

				if (current == '+')
					opResult = leftOperand + rightOperand;

				else if (current == '-')
					opResult = leftOperand - rightOperand;

				else if (current == '*')
					opResult = leftOperand * rightOperand;

				else if (current == '/')
					opResult = leftOperand / rightOperand;

				numStack.push(opResult); // 연산 결과값을 숫자스택에 다시 넣어주기
			}
		}

		// 후위계산식이 비었으면 숫자스택에 최종 계산값이 들어있다
		result = numStack.pop(); // 숫자스택에 있는 최종 계산값 꺼내서 result에 넣어주기

	}

}
