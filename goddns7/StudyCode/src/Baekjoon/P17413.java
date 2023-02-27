package day0216;

import java.util.Scanner;
import java.util.Stack;

public class P17413 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder stringBuilder = new StringBuilder();

		Stack<Character> stack = new Stack<>();
		// 문자열 한 줄을 다 입력받음
		String line = sc.nextLine();

		// change = 0이면 뒤집어서 출력, change=1이면 뒤집어서 출력x
		int change = 0;

		for (char ch : line.toCharArray()) {
			// 공백을 만나면
			if (ch == ' ') {
				// 이전의 실행으로 인해 stack에 무언가 있다면
				while (!stack.isEmpty()) {
					// stack에 들어있는 것을 빼서 출력할 것에 넣는다
					stringBuilder.append(stack.pop());
				}
				// 만났던 공백도 이어서 출력할 것에 넣는다
				stringBuilder.append(ch);
			// <를 만났다면
			} else if (ch == '<') {
				// 이전의 실행으로 인해 stack에 무언가 있다면
				while (!stack.isEmpty()) {
					// stack에 들어있는 것을 빼서 출력할 것에 넣는다
					stringBuilder.append(stack.pop());
				}
				// <>안에 있는 것들은 뒤집어서 출력하지 않으므로 change =1 로 바꾸기
				change = 1;
				// 만났던 <을 이어서 출력할 것에 넣는다
				stringBuilder.append(ch);
			// >를 만났다면
			} else if (ch == '>') {
				// <>이후의 것들은 뒤집어서 출력하므로 change=0으로 바꾸기
				change = 0;
				// 만났던 >을 이어서 출력할 것에 넣는다
				stringBuilder.append(ch);
			} else {
				// change =0 이면 뒤집어서 출력하기 위해 stack에 넣는다
				if (change == 0) {
					stack.push(ch);
				// change =1이면 뒤집어서 출력하지 않으므로 그대로 출력할 것에 넣기
				} else {
					stringBuilder.append(ch);
				}
			}
		}

		//위의 반복문을 실행하고 stack이 비어있지 않다면
		while (!stack.isEmpty()) {
			//남은 것들을 모두 빼내어서 출력할 것에 넣는다
			stringBuilder.append(stack.pop());
		}

		System.out.println(stringBuilder);
		sc.close();
	}
}