package study_ssafy2;

/*
 * 메모리 초과가 떠서 구글링을 해서 풀 수 있었습니다
 * 핵심적으로 알아야 할 것은 stack의 경우 pop이나 peek말고도 get을 통해 원소를 가져올 수 있다는 것.
 * get을 활용하면 stack에 문자열을 넣어두고 폭발하는 단어가 있는지 확인하기가 매우 쉽다.
 * 
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935_문자열폭발_김현수 {
	static String text, bombText;
	static int textSize, bombTextSize;
	static Stack<Character> stack;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// 전체 문자열과 폭발하는 문자열 받아오기
		text = br.readLine().trim();
		bombText = br.readLine().trim();

		// 전체 문자열 길이와 폭발하는 문자열 길이 저장
		textSize = text.length();
		bombTextSize = bombText.length();

		// stack 정의
		stack = new Stack<>();

		// 전체 문자열을 돌면서
		for (int i = 0; i < textSize; i++) {
			// 우선 stack에 넣는다
			stack.add(text.charAt(i));

			// 이때 stack의 크기가 폭발하는 문자열보다 크거나 같아지면
			if (bombTextSize <= stack.size()) {
				// 폭발하는 문자열인지 확인해줄 논리형
				boolean isSame = true;
				
				// 폭발하는 문자열 길이만큼 돌면서
				for (int index = 0; index < bombTextSize; index++) {
					
					// stack내부에 존재하는 단어와
					char textTmp = stack.get(stack.size() - bombTextSize + index);
					// 폭발하는 단어를 임시로 저장하고
					char bombTextTmp = bombText.charAt(index);
					
					// 두 단어가 서로 다르다면
					if (textTmp != bombTextTmp) {
						// 논리형을 false로 바꾸어주고 반복문을 종료한다
						isSame = false;
						break;
					}
				}
				
				// 이때 두문자열이 같다면
				if (isSame) {
					// 폭발하는 문자열 길이만큼 stack에서 빼준다
					for (int index = 0; index < bombTextSize; index++) {
						stack.pop();
					}
				}
			}
		}
		
		// 결과 출력
		StringBuilder sb = new StringBuilder();
		if (stack.size() == 0) {
			sb.append("FRULA");
		} else {
			for (char c : stack) {
				sb.append(c);
			}
		}
		System.out.println(sb);

	}

}
