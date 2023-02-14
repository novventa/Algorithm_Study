package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class P9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 케이스 횟수를 받아온다.
		int T = Integer.parseInt(br.readLine());

		// 테스트 케이스 횟수 만큼 반복한다
		for (int i = 0; i < T; i++) {
			
			// 스택을 사용하기 위해 정의한다
			// 케이스를 진행할 때 마다 stack을 초기화 해줘야 하므로
			// for문 안에서 stack을 정의해야한다
			// String 문자열을 char로 가져오므로 타입은 char로지정
			Stack<Character> stack = new Stack<>();
			
			// 괄호의 문자열을 받아오기위해 한줄 전체를 읽어온다
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 괄호의 문자열을 받아 저장
			String vps = st.nextToken();

			// 문자열의 사이즈를 저장
			final int size = vps.length();
			
			// 문자열의 첫 index부터 반복문을 돌리면서
			// 1. "("일 경우 stack에 넣어주고
			// 2. ")"일 경우 stack에서 빼준다.
			// 3. 이후 stack이 비었다면 vps이다.
			try {
				for (int j = 0; j < size; j++) {
					char tmp = vps.charAt(j);
					
					// 만약 문자가 '(' 이면 push로 넣어준다 
					if (tmp == '(') {
						stack.push(tmp);
					} 
					// 만약 문자가 ')' 이면 poll로 빼낸다
					else {
						stack.pop();
					}
				}
				
				// 비었으면 VPS문자열 이므로 YES 출력
				if (stack.isEmpty()) {
					System.out.println("YES");
				} 
				// 원소가 남아 있으면 NO 출력
				else {
					System.out.println("NO");
				}
			} 
			// 그외에 ')'가 더 많아서 POP이 되지않아 에러가 발생하면
			// NO 출력
			catch (EmptyStackException e) {
				
				System.out.println("NO");
			}

		}
		br.close();

	}
}

