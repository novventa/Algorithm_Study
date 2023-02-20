package test;

import java.util.Scanner;

// SWEA
// 1215 회문1
// D3

// 문제
// 8*8 글자판에서 제시된 길이를 가진 회문의 개수를 구하시오

// 조건
// 칸에 들어가는 char는 A, B, C 중 하나이다
// 가로 세로만 카운트한다 => 대각선X
// 직선으로만 카운트한다

// 풀이
// if 찾아야 하는 회문의 길이가 1이면
//		확인하지말고 64출력하기
//		=> A도 길이가 1인 회문이라는 문제 조건에 따라서
// else
// 	1. 가로줄에 대해 다 찾는다
// 	2. 세로줄에 대해 다 찾는다
// 		모든 칸에 대해 초기 boolean = true
// 		시작 인덱스에서 for문 돌려서
// 		idx < 찾아야 할 회문 길이 / 2 만큼 진행
// 		[현재 인덱스 + idx] != [현재 인덱스 + 찾아야 할 회문 길이 - 1 - idx] 이면 false break;
//		한 점에서 돌아간 for문이 다 돌았을 때 여전히 true면 회문카운트++

public class SWEA_1215_회문1_변지혜 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		// 테스트케이스 10번 만큼 반복
		for (int testCase = 1; testCase <= 10; testCase++) {
			// 출력양식
			sb.append("#").append(testCase).append(" ");
			
			// 찾아야 하는 회문의 길이 conditionLenght 입력받기
			int conditionLength = sc.nextInt();
			
			// 8*8 단어판 map 공간 만들기
			char[][] map = new char[8][8];
			
			// map에 A, B, C 입력받기
			for (int row = 0; row < 8; row++) {
				String read = sc.next();
				for (int col = 0; col < 8; col++) {
					map[row][col] = read.charAt(col);
				}
			}
			
			// 만약 찾아야 하는 회문의 길이가 1이면 map 확인하지 말고 그냥 64 출력
			// 시간 절약
			if (conditionLength == 1) {
				sb.append("64").append("\n");
				continue;
			}
			
			// 찾야야 하는 회문의 길이가 1이 아니면
			// 전체 map검사...
			
			// 회문인지 아닌지 저장할 boolean isPalindrome 만들기
			boolean isPalindrome = true;
			
			// 회문 개수를 저장할 palindromeCnt 만들기
			int palindromeCnt = 0;
			
			// 가로 줄 확인하기
			for (int row = 0; row < 8; row++) {
				// outOfBounds 걸리지 않게 최대 범위 설정
				for (int col = 0; col < 8 - conditionLength + 1; col++) {
					// 모든 칸에 대해 확인 시작 할 때 true로 전제하고 시작
					isPalindrome = true;
					
					// 현재 칸에 대해 주어진 길이 만큼의 회문이 아니라면
					// false 하고 검사 종료
					for (int idx = 0; idx < conditionLength / 2; idx++) {
						if (map[row][col + idx] != map[row][col + conditionLength - 1 - idx]) {
							isPalindrome = false;
							break;
						}
					}
					
					// 현재 칸에서 주어진 회문 길이 만큼 확인 다 했는데
					// isPalindrome = true라면
					// 조건을 만족하는 회문이다!
					// 회문 카운트++
					if (isPalindrome) {
						palindromeCnt++;
					}
				}
			}
			
			// 세로 줄 확인하기
			for (int col = 0; col < 8; col++) {
				for (int row = 0; row < 8 - conditionLength + 1; row++) {
					isPalindrome = true;
					
					for (int idx = 0; idx < conditionLength / 2; idx++) {
						if (map[row + idx][col] != map[row + conditionLength - 1 - idx][col]) {
							isPalindrome = false;
							break;
						}
					}
					
					if (isPalindrome) {
						palindromeCnt++;
					}
				}
			}
			
			// 가로 세로 줄 다 확인했으면
			// 조건 길이를 만족하는 회문 갯수 출력
			sb.append(palindromeCnt).append("\n");
		}
		
		// 출력
		System.out.println(sb);
	}
}





