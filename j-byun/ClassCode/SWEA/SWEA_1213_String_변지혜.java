package test;

import java.util.Scanner;

// SWEA
// 1213 String
// D3

// 문제
// 주어지는 영어 문장에서 특정한 문자열의 개수를 반환하시오

// 조건
// 테케 10개
// 문장길이 <= 1000
// 검색할 문자열 길이 <= 10
// 한 문장에서 하나의 문자열만 검색

// 풀이
// while문 돌려서 (idx <= 문자열길이 - 찾는 문자열 길이) 까지 확인
// true면 카운트++
// false면 continue

public class SWEA_1213_String_변지혜 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		// 테케 10개
		for (int testCase = 1; testCase <= 10; testCase++) {
			// 테케 번호 입력받기
			int t = sc.nextInt();
			
			// 출력 양식
			sb.append("#").append(testCase).append(" ");

			// 찾을 문자열 입력받기
			String find = sc.next();

			// 검색할 문장 입력받기
			String text = sc.next();

			// text에서 find를 찾자!

			// 문장에서 찾을 인덱스 번호
			int textIdx = 0;

			// 찾을 단어 find에서 찾을 인덱스 번호
			int findIdx = 0;

			// find단어를 찾은 횟수 카운트
			int matchCnt = 0;

			// 현재 char에서부터 find 단어와 일치하는 지 여부를 나타낼 isEqual
			boolean isEqual = true;

			// while문을 돌면서 일치여부 탐색
			// textIdx는 text길이 - find길이와 같을 때 까지만 ++
			while (textIdx <= text.length() - find.length()) {
				// 한 char에서 확인 시작할 때 true로 가정하고 시작
				isEqual = true;

				// 현재 char가 일치한다면...
				if (text.charAt(textIdx) == find.charAt(findIdx)) {

					// 찾을 단어 길이만큼 돌면서 탐색
					while (++findIdx < find.length()) {
						// 탐색하면서 하나라도 일치하지 않으면
						// false넣고 break
						if (text.charAt(textIdx + findIdx) != find.charAt(findIdx)) {
							isEqual = false;
							break;
						}
					}
					
					// 단어 길이만큼 확인해봤는데 다 일치하면
					// 단어 하나 찾은거니까
					// 매치카운트++
					if (isEqual) {
						matchCnt++;
					}

				}
				
				// 한 char에서 시작된 탐색이 끝났을 때...
				// 1. 찾을 단어 수 만큼 다 확인해봤거나
				// 2. 그 전에 일치하지 않아서 끝났다면
				
				// 다음 단어부터 다시 찾으러 간다
				textIdx++;
				findIdx = 0;
			}
			
			// 출력 양식
			sb.append(matchCnt).append("\n");
		}

		// 출력
		System.out.println(sb);
	}
}
