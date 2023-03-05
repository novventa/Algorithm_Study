package study_ssafy;

/*
 * 문제의 접근방식을 몰라서 검색을 통해 찾아봤습니다
 * stack과 boolean을 활용해 문제를 풀었습니다
 * 1. <,>를 만난 경우에는 논리형을 true로 바꾸어 주어서 그대로 출력해주고
 * 2. tag에서 빠져 나올 시 논리형을 false로 바꾸어 주면서 일반 단어들을 stack에 넣어 주었습니다
 * 3. 이후 공백을 만나면 stack에 쌓여있는 단어들을 출력 후 다시 진행하는 방식으로 문제를 풀었습니다
 * 
 * */
import java.util.Scanner;
import java.util.Stack;

public class solution_17413_단어뒤집기2_김현수 {
	public static void main(String[] args) {

		// 스캐너사용
		Scanner sc = new Scanner(System.in);

		// 문자열 받아오기
		String str = sc.nextLine();

		// 스캐너 사용 종료
		sc.close();

		// 출력을 위해 StringBuilder 사용
		StringBuilder sb = new StringBuilder();

		// tag 안에 있는지를 판별해줄 논리형
		boolean isTag = false;

		// 일반 단어를 넣을 stack
		Stack<Character> stack = new Stack<>();

		// 단어의 길이만큼 반복하면서
		for (int i = 0; i < str.length(); i++) {

			// 조건문의 순서가 매우 중요하다
			// 조건문의 처음을 isTag의 논리형으로 나누면
			// isTag의 경우 true와 false 두가지로만 나뉘기 때문에
			// 밑에있는 여러가지의 조건문이 실행 될 수가 없다.
			// 따라서 isTag와 관련된 조건문은 가장 마지막에 넣어주어야 한다

			// 만약 '<'를 만난다면
			// stack에 있는 원소를 모두 꺼내서 출력한다
			// tag시작지점 전까지는 단어가 뒤집어 져야 하기 때문이다
			if (str.charAt(i) == '<') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}

				// 단어를 뒤집은후 태그의 시작지점 또한 출력
				sb.append(str.charAt(i));

				// Tag가 시작 되므로 논리형을 true로 변경
				isTag = true;
			}
			// 만약 Tag가 끝난다면
			else if (str.charAt(i) == '>') {

				// Tag의 마지막을 출력해주고
				sb.append(str.charAt(i));

				// 논리형을 false로 변경
				isTag = false;
			}

			// 만약 논리형이 true라면 즉 Tag 안이라면 단어를 그대로 출력
			else if (isTag == true) {
				sb.append(str.charAt(i));
			}
			// 만약 공백이라면
			// stack에 단어가 있을 경우 단어 구분을 위해 stack에 있는 단어들을 뒤집어서 출력해준다.
			// 이때 Tag안에 공백은 위의 isTag==true에 포함되어서 신경쓸 필요 없다
			else if (str.charAt(i) == ' ') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(' ');

			}
			// 만약 Tag가 아니라면 stack에 단어를 담는다
			else if (isTag == false) {
				stack.add(str.charAt(i));
			}
		}

		// 반복문을 빠져나온 후에 만약 stack에 단어가 남아있다면 꺼내어 준다.
		// 약간 계산기 문제같네...?
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		// 출력해준다
		System.out.println(sb);
	}
}
