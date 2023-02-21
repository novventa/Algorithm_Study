import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// SWEA
// 1222 계산기1
// D4

// 스택을 써서 표현식을 바꾸고
// 그걸 계산해서 제출할 것

// 문제
// 문자열로 이루어진 계산식이 주어질 때,
// 이 계산식을 후위 표기식으로 바꾸어 계산하라

// 조건
// 연산자는 +만 있다
// 숫자는 0~9까지의 정수만 있다

// 풀이
// 중위표기법 -> 후위표기법으로 변환 후
// 후위표기법 -> 계산해서 출력

// 0. 문자열 읽기
// idx % 2 == 0 (짝수일 때)
//	=> 숫자
//	중위표기식 스택에 넣기
// idx % 2 == 1 (홀수일 때)
//	=> 연산자
//	연산자 스택에 들어있는 애랑 우선순위 비교해서 처리

// 1. 중위표기법 -> 후위표기법
//	후위표기법 수식은 앞에서부터 읽어서 계산해야되니까 스택말고 큐로 만들기
// for 중위표기식의 길이만큼
//	중위표기식에서 토큰 읽기
//	읽은 토큰이 피연산자면 중위표기법 문자열에 집어넣기
//	읽은 토큰이 연산자일 때...
//		스택의 top에 있는 연산자보다 우선순위가 높을 때 까지 스택의 연산자 pop해서 중위표기법 문자열에 집어넣고,
//			현재 연산자가 우선순위가 더 높으면 그 때 스택에 push하기
//		스택이 비어있으면 바로 연산자를 넣는다
//	계산식의 길이만큼 확인한 후, 연산자 스택에 남아있는건 다 위에서부터 차례대로 pop해서 후위표기법 문자열에 넣는다

// 2. 후위표기법 -> 수식 계산
// while 후위표기법 큐가 !empty일 때
// 피연산자를 만나면 숫자 스택에 push
// 연산자를 만나면...
//	char op = 후위표기법queue.poll();
//	int b = 숫자stack.pop() - '0';
//	int a = 숫자stack.pop() - '0';
//	a op b => a + b
//		문제에 주어진 연산자는 +밖에 없으니까
//	계산한 a+b를 다시 숫자 스택에 push
//	while문이 다 끝나면 마지막 계산한 결과값이 숫자스택에 들어있으니...
//		우리가 원하는 결과값은 sysout 숫자stack.pop()

//	if stack.peek이 >= '0' && <= '9'	=>	이건 숫자
//	if stack.peek이 == '+'	=> +연산자

public class SWEA_1222_계산기1_변지혜 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		// 테케 10개만큼 반복
		for (int tc = 1; tc <= 10; tc++) {
			
			// 출력양식
			sb.append("#").append(tc).append(" ");
			
			// 입력받은 중위표기법 문자열 -> 후위표기법으로 바꿔서 표현할 queue공간 만들기
			Queue<Character> postfix = new LinkedList<Character>();
			
			// 중위표기법 -> 후위표기법 변환 시 연산자를 저장할 stack공간 만들기
			Stack<Character> operator = new Stack<>();
			
			// 후위표기법 -> 수식 계산 시 피연산자를 저장할 stack공간 만들기
			Stack<Integer> nums = new Stack<>();
			
			// 문자열 계산식의 길이 입력받기
			int length = sc.nextInt();
			
			// 문자열 읽어오기
			String read = sc.next();
			
			
			// 1. 중위표기법 -> 후위표기법으로 변환하기
			// 문자열 길이만큼 반복
			for (int idx = 0; idx < length; idx++) {
				
				if (idx % 2 == 0) {
					// 숫자일 때...
					// 후위표기식 큐에 넣기
					postfix.offer(read.charAt(idx));
					
				} else if (idx % 2 == 1) {
					// 연산자 일 때...
					// 연산자 스택이 비었는지 확인
					
					if (operator.isEmpty()) {
						// 연산자 스택이 비어있다면...
						// 연산자 스택에 push
						operator.push(read.charAt(idx));
						
					} else {
						// 연산자 스택이 비어있지 않다면...
						// 문제에서 사용된 연산자는 + 밖에 없으므로
						// 연산자 스택에 들어있던 +가 우선순위가 더 높다
						// 그러므로 연산자 스택에서 pop해서 후위표기식 스택에 넣고
						// 현재 연산자는 연산자 스택에 push하기
						postfix.offer(operator.pop());
						operator.push(read.charAt(idx));
						
					}
				}
			} // 중위표기법 -> 후위표기법으로 변환 완료
			
			
			// 연산자 스택에 남아있는 연산자는...
			// 위에서부터 차례대로 뽑아서 후위표기식 큐에 넣어준다
			while (!operator.isEmpty()) {
				postfix.offer(operator.pop());
			}
			
			
			// 2. 후위표기법 -> 수식 계산하기
			// 후위표기법 스택이 empty할 때 까지 반복
			while (!postfix.isEmpty()) {
				
				if (postfix.peek() >= '0' && postfix.peek() <= '9') {
					// 피연산자를 만나면...
					// 숫자 스택에 push
					nums.push(postfix.poll() - '0');
					
				} else {
					// 연산자를 만나면...
					char plus = postfix.poll();
					int b = nums.pop();
					int a = nums.pop();
					
					nums.push(a + b);
				}
			}
			
			
			// while문이 다 끝나면 마지막 계산한 결과값이 숫자스택에 들어있으니...
			// 우리가 원하는 결과값은 sysout 숫자stack.pop()
			sb.append(nums.pop()).append("\n");
			
		}
		
		// 출력
		System.out.println(sb);
	}

}


