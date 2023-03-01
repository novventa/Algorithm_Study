package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P8958 {
	public static void main(String[] args) throws IOException {
		
// OX퀴즈 브론즈2
// charAt으로 한 글자씩 탐색해서
// 연속되는 O만큼 점수를 더한다.
// 단, 연속될 수록 점수도 1씩 올라간다.
		
		
		// 버퍼드리더 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 횟수 입력받기
		int T = Integer.parseInt(br.readLine());
		// 테스트 케이스 횟수만큼 반복
		for(int tc=1;tc<=T;tc++) {
			// OX퀴즈 결과 입력받기
			String str = br.readLine();
			// 카운터 변수
			int cnt = 0;
			// 합을 저장할 변수
			int sum = 0;
			// OX퀴즈 결과를 하나씩 탐색
			for(int i=0;i<str.length();i++) {
				// 스트링에서 한 글자 떼서
				char tmp = str.charAt(i);
				// 글자가 O면
				if(tmp=='O') {
					// cnt를 1 더하고
					cnt++;
					// 합에다가 더해준다.
					sum += cnt;
					// 한 글자씩 탐색하다가 X를 만나면
				}else {
					// 카운터를 초기화한다.
					cnt=0;
				}
			}
			// 출력
			System.out.println(sum);	
			
		}
	}
}
