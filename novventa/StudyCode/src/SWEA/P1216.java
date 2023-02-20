package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1216 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 10번만큼 반복
		for (int T = 1; T < 11; T++) {

			// 100X100의 문자판 2차원배열 생성
			char[][] map = new char[100][100];

			int maxLength = 0;

			// tc번호 입력받기
			br.readLine();

			// 문자판 채우기
			for (int r = 0; r < 100; r++) {
				String tmp = br.readLine();
				for (int c = 0; c < 100; c++) {
					map[r][c] = tmp.charAt(c);
				}
			}

			// 행 확인
			// 행 끝에서 하나씩 줄여가면서 회문인지 판단한다. 
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					// 끝 인덱스를 하나씩 줄여간다.
					for (int del = 100; del >= c; del--) {
						// 스트링빌더에 넣어서 문자열을 만든다.
						StringBuilder sb = new StringBuilder();
						int strLength = 0;
						for (int i = c; i < del; i++) {
							sb.append(map[r][i]);
						}
						// 정상 문자열을 만들고
						String normalStr = sb.toString();
						// 뒤집은 문자열을 만든다.
						String reverseStr = sb.reverse().toString();
						
						// 두 문자열이 같으면 길이를 저장하고
						// 최대 길이와 비교해본다.
						if (normalStr.equals(reverseStr)) {
							strLength = normalStr.length();
							if (strLength >= maxLength)
								maxLength = strLength;
						}
					}
				}
			}
			// 열 확인
			// 행과 마찬가지로 열도 끝에서부터 하나씩 줄여가면서 확인해본다.
			for (int c = 0; c < 100; c++) {
				for (int r = 0; r < 100; r++) {
					// 끝 인덱스를 하나씩 줄여간다.
					for (int del = 100; del >= r; del--) {
						// 스트링빌더에 넣어서 문자열을 만든다.
						StringBuilder sb = new StringBuilder();
						int strLength = 0;
						for (int i = r; i < del; i++) {
							sb.append(map[i][c]);
						}
						// 정상 문자열을 만들고
						String normalStr = sb.toString();
						// 뒤집은 문자열을 만든다.
						String reverseStr = sb.reverse().toString();
						// 두 문자열이 같으면 길이를 저장하고
						// 최대 길이와 비교해본다.
						if (normalStr.equals(reverseStr)) {
							strLength = normalStr.length();
							if (strLength >= maxLength)
								maxLength = strLength;
						}
					}
				}
			}
			// 출력
			System.out.println("#" + T + " " + maxLength);
		}
	}
}
