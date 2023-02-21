package test;

import java.util.Scanner;

// SWEA
// 2007 패턴 마디의 길이
// D2

// 문제
// 마디 : 패턴에서 반복되는 부분
// 문자열을 입력받아 마디의 길이를 출력하시오

// 조건
// 각 문자열의 길이는 30이다
// 마디의 최대 길이는 10이다

public class SWEA_2007_패턴마디의길이_변지혜 {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		// 테스트케이스 개수 t 입력받기
		int t = sc.nextInt();
		
		// 테케 개수만큼 반복 실행
		for (int testCase = 1; testCase <= t; testCase++) {
			
			// 출력 양식
			sb.append("#").append(testCase).append(" ");
			
			// 길이 30인 문자열 입력받기
			String read = sc.next();
			
			// 검사할 문자열의 인덱스
			int idx = 1;
			
			// 문자열 길이만큼 검사
			outer : while (idx < 30) {
				
				// 현재 확인 한 문자열의 char가 문자열 첫 시작 char와 동일하다면
				// 0 ~ idx-1 까지 다 확인
				if (read.charAt(0) == read.charAt(idx)) {
					
					for (int idxCnt = 0; idxCnt < idx; idxCnt++) {
						if (read.charAt(0 + idxCnt) != read.charAt(idx + idxCnt)) {
							// 0~idx-1까지 문자열이 != idx~2*idx -1까지의 문자열이면
							// 이건 마디가 아니다
							// break하고 다음 idx 확인
							break;
						}
						
						// idxCnt == idx - 1 까지 다 확인하고 위의 if문을 탈출했다면
						// 0~idx-1까지 문자열이 == idx~2*idx -1까지의 문자열이라는 뜻
						// => idx-1 까지가 마디다!
						// => idx가 마디의 길이임
						if (idxCnt == idx - 1) {
							sb.append(idx).append("\n");
							break outer;
							
						}
					}
					
				}
				
				// 확인한 문자열의 char가 문자열 첫 시작 char가 아니면
				// 다음 char 확인하러감
				idx++;
			}
			
		}
		
		// 출력
		System.out.println(sb);
		
	}

}


