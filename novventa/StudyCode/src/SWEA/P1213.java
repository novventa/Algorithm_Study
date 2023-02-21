package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1213 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스 10번만큼 반복
		for (int T = 1; T < 11; T++) {
			
			// 테스트 케이스 번호 입력받기
			int tc = Integer.parseInt(br.readLine());
			
			// 몇번 나왔는지 찾아야하는 문자열과 탐색목표 문자열 입력받기
			String keyword = br.readLine();
			String searchStr = br.readLine();

			// 입력받은 문자열을 한글자씩 배열에 저장한다.
			char[] string = searchStr.toCharArray();
			char[] key = keyword.toCharArray();

			// 탐색 키워드가 몇번 나오는지 세는 변수
			int times = 0;
			
			// 목표 문자열의 길이 - 키워드의 길이 만큼 반복한다.
			for (int i = 0; i < string.length - keyword.length() + 1; i++) {
				// 목표 문자열을 하나씩 탐색하다가 키워드의 첫 글자와 같은 글자가 나오면
				if (string[i] == key[0]) {
					// 카운터를 1로 바꾼다.
					int sameCnt = 1;
					// 이어서 목표 문자열에서 남은 글자들을 탐색한다.
					for (int j = 1; j < keyword.length(); j++) {
						// 만약 다음 글자가 키워드와 다르다면
						if (string[i + j] != key[j]) {
							// 카운터를 0으로 만들고 break;
							sameCnt = 0;
							break;
						}
					}
					// 반복이 끝날 때 마다 카운터를 더해준다.
					times += sameCnt;
				}
			}
			// 출력
			System.out.println("#" + T + " " + times);
		}
	}
}
