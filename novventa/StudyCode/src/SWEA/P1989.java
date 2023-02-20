package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1989 {
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스 횟수 입력받기
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 횟수만큼 반복한다.
		for (int tc = 1; tc < T + 1; tc++) {
			
			// 회문인지 확인할 문자열을 입력받는다.
			String normalStr = br.readLine();
			// 입력받은 문자열을 뒤집었을 때 저장할 변수를 생성한다.
			String reverseStr = "";
			
			// 입력받은 문자열을 한 글자씩 저장할 배열을 만든다.
			char[] arr = normalStr.toCharArray();
			
			// 가운데를 기준으로 뒤집기 위해 입력받은 문자열 길이의 반만큼 반복한다.
			for (int i = 0; i < normalStr.length() / 2; i++) {
				
				// 첫번째 반복에서 문자열의 첫번째 글자를 tmp에 저장하고
				char tmp = arr[i];
				// 마지막 글자에 첫번째 문자를 넣는다.
				arr[i] = arr[normalStr.length() - 1 - i];
				// 문자열의 마지막 글자에 tmp에 저장되어있던 첫번째 문자를 넣는다
				arr[normalStr.length() - 1 - i] = tmp;
				// 이를 문자열의 가운데까지 반복한다.
			}
			// 문자 하나씩 들어있는 배열을 문자열로 바꿔준다.
			reverseStr = String.valueOf(arr);
			
			// 회문이면 1 출력
			if (normalStr.equals(reverseStr))
				System.out.println("#" + tc + " " + 1);
			// 회문이 아니면 0 출력한다.
			else
				System.out.println("#" + tc + " " + 0);
		}
	}
}
