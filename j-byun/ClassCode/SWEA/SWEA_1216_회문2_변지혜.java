package test;

import java.util.Scanner;

// SWEA
// 1216 회문2
// D3

// 문제
// 회문 palindrome
// 100*100 글자판에서 가장 긴 회문 찾기

// 조건
// 각 칸에는 A, B, C 중 하나 입력
// 가로, 세로에 대해 직선으로만 확인
// 대각선 안됨

// 풀이
// A도 길이1인 회문이니까 max회문 길이 초기값 1로 정하기
// 가로, 세로에 대해...
// 인덱스 0번부터 시작해서... 마지막 인덱스와 값이 일치하는지 비교
//		불일치하면 마지막-1 인덱스와 값이 일치하는지 비교
//		... 지금 + 1 인덱스까지 비교
//	일치한다면...
//	앞 인덱스에 + i, 뒤 인덱스에 - i 해가면서 비교
//		중간에 틀리면 false break;
//		앞 인덱스에 + i <= 뒤 인덱스에 - i 까지 비교했는데 다 true면...
// 처음 비교 시작한 [마지막 - n 인덱스] - 시작인덱스 + 1 이랑 maxLength 비교해서 큰걸로 maxLength 업데이트
// 배열 다 확인하고 maxLength 반환

public class SWEA_1216_회문2_변지혜 {

	static int[][] map = new int[100][100];
	static int maxPLength;
	static boolean isEqual;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		// 테케 10개만큼 반복
		for (int testCase = 1; testCase <= 10; testCase++) {
			// 출력양식
			sb.append("#").append(testCase).append(" ");

			// 테케 번호 입력받기
			int t = sc.nextInt();

			// map에 char 입력받기
			for (int row = 0; row < 100; row++) {
				// 한 줄로 입력받아서
				String read = sc.next();

				// char별로 끊어서 map에 넣기
				for (int col = 0; col < 100; col++) {
					map[row][col] = read.charAt(col);
				}
			}
			
			// 가로세로 탐색한 것 중 더 큰 값 출력
			maxPLength = Math.max(rowPalindrome(map), colPalindrome(map));
			
//			maxPLength = rowPalindrome(map);
			
			sb.append(maxPLength).append("\n");

		}

		// 출력
		System.out.println(sb);
	}

	// 가로탐색
	private static int rowPalindrome(int[][] map) {
		// 일단 회문 없으면 A 하나도 회문이라 최대길이 1로 지정
		maxPLength = 1;

		// map 가로방향으로 탐색
		for (int row = 0; row < 100; row++) {
			for (int col = 0; col < 100; col++) {
				// 현재 칸에 대해...
				// 일단 두 값이 일치하는지 확인할 isEqual을 true로 초기 설정하고...
				// 같은 행 제일 마지막 char와 비교
				for (int endCol = 99; endCol > col &&  endCol >= col +  maxPLength; endCol--) {
					isEqual = true;

					// 앞에서 cnt만큼 더한 애랑 뒤에서 cnt만큼 더한 애랑 비교해가면서...
					// 계속 일치하면 true, 하나라도 불일치하면 false break;
					for (int colCnt = 0; col + colCnt < endCol - colCnt; colCnt++) {
						if (map[row][col + colCnt] != map[row][endCol - colCnt]) {
							isEqual = false;
							break;
						}
					}

					// for문 끝났는데 true면...
					// col~endcol까지가 회문임
					if (isEqual) {
						if (endCol - col + 1 > maxPLength) {
							maxPLength = endCol - col + 1;
						}

					}
				}
			}
		}

		return maxPLength;
	}

	// 세로탐색
	private static int colPalindrome(int[][] map) {
		maxPLength = 1;

		for (int col = 0; col < 100; col++) {
			for (int row = 0; row < 100; row++) {

				for (int endRow = 99; endRow > row && endRow >= row +  maxPLength; endRow--) {
					isEqual = true;

					for (int rowCnt = 0; row + rowCnt < endRow - rowCnt; rowCnt++) {
						if (map[row + rowCnt][col] != map[endRow - rowCnt][col]) {
							isEqual = false;
							break;
						}
					}

					if (isEqual) {
						if (endRow - row + 1 > maxPLength) {
							maxPLength = endRow - row + 1;
						}

					}
				}
			}
		}

		return maxPLength;
	}

}
