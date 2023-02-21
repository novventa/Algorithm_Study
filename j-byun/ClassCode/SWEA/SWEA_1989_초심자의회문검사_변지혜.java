package test;

import java.util.Scanner;

// SWEA
// 1989 초심자의 회문 검사
// D2

// 문제
// 문자 순서 뒤집어도 똑같은 것 : 회문
// 입력된 단어가 회문이면 1, 아니면 0 출력

// 조건
// 3 <= 단어 길이 <= 10

// 풀이
// for문을 문자열의길이 /2 만큼 돌려서
// 		[인덱스]번째의 char와 [문자열의 길이 - 인덱스 - 1] 번째의 char가 일치하면 계속 검사
// 초기 boolean을 true로 해놓고
//		비교 결과가 일치하지 않으면
// 		false로 바꾸고 바로 break;

public class SWEA_1989_초심자의회문검사_변지혜 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		// 테스트케이스 개수 t 입력받기
		int t = sc.nextInt();
		
		// 테스트케이스 개수만큼 반복
		for (int testCase = 1; testCase <= t; testCase++) {
			// 출력양식
			sb.append("#").append(testCase).append(" ");
			
			// 문자열 입력받아서 char배열로 바꾸기
			String stringText = sc.next();
			char[] text = stringText.toCharArray();
			
			// 문자열의 길이를 size에 저장하기
			int size = text.length;
			
			// 문자열의 [idx]번째와 [text.length - idx - 1]번째가 일치하는 지 여부를 나타낼 boolean isEqual 만들기
			boolean isEqual = true;
			
			// 문자열을 반 갈라서 확인해보자
			// 문자열을 반으로 접었을 때 대칭이 되는 부분끼리 일치하는 지 확인
			// 대칭이 되는 모든 부분이 일치하면 boolean isEqual이 계속 true,
			// 하나라도 일치하지 않으면 false
			for (int idx = 0; idx < size / 2; idx++) {
				if (text[idx] != text[size - idx - 1]) {
					isEqual = false;
					break;
				}
			}
			
			// 문자열 반 갈라서 모든 대칭 자리 확인했을 때
			// 대칭 자리의 char끼리 모두 일치하면 1출력
			// 하나라도 불일치하면 0출력
			if (isEqual) {
				sb.append("1").append("\n");
			} else {
				sb.append("0").append("\n");
			}
			
		}
		
		// 출력
		System.out.println(sb);
		
	}
}





