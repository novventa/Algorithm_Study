package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1215 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 10번만큼 반복한다.
		for (int T = 1; T < 11; T++) {

			// 회문의 길이를 입력받는다.
			int strLength = Integer.parseInt(br.readLine());

			// 글자판 2차원 배열을 생성한다.
			char[][] map = new char[8][8];

			// 글자판을 채운다.
			for (int r = 0; r < 8; r++) {
				String tmp = br.readLine();
				for (int c = 0; c < 8; c++) {
					map[r][c] = tmp.charAt(c);
				}
			}
			
			// 회문이 몇개 있는지 세기 위한 변수
			int cnt = 0;
			
			// 문자판의 크기는 8X8로 정해져 있다.
			// 회문인지 알아보기 위해서는 
			// 각 행에서 8 - 회문의 길이의 인덱스까지 탐색해보고
			// 각 열에서 8 - 회문의 길이의 인덱스까지 탐색해보면 된다. 
			for (int r = 0; r < 8-strLength+1; r++) {
				for (int c = 0; c < 8; c++) {
					// 스트링빌더 선언
					StringBuilder sb = new StringBuilder();
					// 해당 위치에서 회문의 길이만큼 행의 인덱스만 늘려가면서 탐색한다.
					for (int i = 0; i < strLength; i++) {
						sb.append(map[r + i][c]);
					}
					// 스트링빌더로 문자열을 만든 뒤
					// 일반 문자열과 뒤집은 문자열을 비교한다.
					String normalStr = sb.toString();
					String reverseStr = sb.reverse().toString();
					// 같으면 카운터에 1을 더한다.
					if (normalStr.equals(reverseStr))
						cnt += 1 ;
				}
			}
			
			// 위에서 행과 마찬가지로 열도 똑같이 한다.
			for (int r = 0; r < 8; r++) {
				for (int c = 0; c < 8-strLength+1; c++) {
					StringBuilder sb = new StringBuilder();
					// 해당 위치에서 회문의 길이만큼 열의 인덱스만 늘려가면서 탐색한다.);
					for (int i = 0; i < strLength; i++) {
						sb.append(map[r][c+i]);
					}
					// 스트링빌더로 문자열을 만든 뒤
					// 일반 문자열과 뒤집은 문자열을 비교한다.
					String normalStr = sb.toString();
					String reverseStr = sb.reverse().toString();
						if (normalStr.equals(reverseStr))
							cnt += 1 ;
				}
			}
			// 출력
			System.out.println("#" + T + " " + cnt);
		}
	}
}
