package test;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// SWEA
		// 1979 어디에 단어가 들어갈 수 있을까
		// D2
		
		// 문제
		// N*N 크기의 단어 퍼즐
		// 입력으로 단어 퍼즐 모양 주어짐
		// 주어진 퍼즐 모양에서 특정 길이 K를 갖는 단어가 들어갈 수 있는 자리의 수 출력
		//		K의 길이 == 빈 칸 길이 여야된다!!! (K < 빈칸 안됨)
		
		// 5 <= N <= 15
		// 2 <= K <= N
		
		// 첫 줄에 테스트케이스 개수 T 입력
		// 다음 줄 부터 각 테스트 케이스가 주어지는데
		//		테케의 첫 줄에는 N과 K가 주어짐
		//		테케의 두 번째 줄부터 퍼즐 모양이 2차원 배열의 정보 0, 1로 주어짐
		//			흰색(입력가능한 칸)==1, 검은색(입력 불가능한 칸)==0
		
		// 풀이
		// 길이가 n인 카운트배열을 만들어서
		// 단어 길이가 1일 때, 2일 때, ... n일 때 카운트 배열의 해당 인덱스를 ++ 해준다
		//	=> 카운트 배열의 k번째 인덱스의 값을 출력해준다
		
		// map의 가로 줄에 대해...
		//	1을 찾으면 ++
		//	오른쪽으로 진행하며 1 찾으면 계속 ++ 하다가
		//	0찾으면 [지금까지 ++한 값 - 1] 을 카운트 배열의 해당 인덱스로 받아 ++시키고
		//		=> 배열 인덱스는 0부터 시작하니까
		//	다음 가로 줄에 대해 찾으러 가기 위해 continue한다
		
		// map의 세로 줄에 대해서도 동일하게 진행한다
		
		// 카운트배열을 다 ++ 시키고 나서
		// 카운트배열[k - 1]을 출력하면
		// 그 값이 곧 k길이의 단어를 저장할 수 있는 공간의 개수이다
		
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 개수 t 입력받기
		int t = sc.nextInt();
		
		// 테스트케이스 개수만큼 반복 진행
		for (int testCase = 1; testCase <= t; testCase++) {
			
			// 퍼즐의 가로 세로 길이 n을 puzzleSize로 받는다
			int puzzleSize = sc.nextInt();
			// 퍼즐에 넣고 싶은 단어의 길이 k를 wordSize로 받는다
			int wordSize = sc.nextInt();
			
			// puzzleSize * puzzleSize 크기의 2차원 배열 puzzle을 만들어준다
			int[][] puzzle = new int[puzzleSize][puzzleSize];
			
			// 퍼즐에 빈칸을 나타내는 정보 0, 1을 받는다
			for (int row = 0; row < puzzleSize; row++) {
				for (int col = 0; col < puzzleSize; col++) {
					puzzle[row][col] = sc.nextInt();
				}
			}
			
			// 퍼즐에 넣을 수 있는 단어의 길이 개수를 저장할 카운트 배열을 만들어준다
			// K <= N 이라는 조건에 따라 N==puzzleSize의 크기로 만들어준다
			int[] wordCount = new int[puzzleSize];
			
			// 연속된 1의 개수를 카운트 할 spaceCnt를 만들어준다
			int spaceCnt = 0;
			
			// 퍼즐의 가로 줄을 순회하며
			// 연속된 1의 개수를 카운트한다
			// 0을 만나면 카운트를 종료하고 wordCount에서 카운트-1 인덱스를 찾아 ++해준다
			for (int row = 0; row < puzzleSize; row++) {
				// 가로로 연속된 공간만 확인할 거니까 row가 바뀔 때 마다 sapceCnt를 초기화한다
				spaceCnt = 0;
				
				for (int col = 0; col < puzzleSize; col++) {
					// 현재 칸이 1이면
					if (puzzle[row][col] == 1) {
						// 연속된 1의 개수를 저장할 spaceCnt를 ++ 해준다
						spaceCnt++;
						} else if (puzzle[row][col] == 0) {
							// 현재 칸이 0 이면
							// spaceCnt값이 존재할 때
							//		=> spaceCnt가 0 이면 indexOutofBounds error발생하니까
							if (spaceCnt != 0) {
								// 여태까지의 spaceCnt - 1 을 인덱스로 받는 wordCnt 배열의 값을 ++ 해주고
								wordCount[spaceCnt - 1]++;
								// spaceCnt를 초기화한다
								spaceCnt = 0;
							}
					}
				}
				// 한 줄이 끝났을 때
				// 한 줄의 끝이 1 이면 그 때 까지의 spaceCnt 값이 저장되지 않았으니까
				// 저장하고 다음 줄로 넘어간다
				if (spaceCnt != 0) {
					// 여태까지의 spaceCnt - 1 을 인덱스로 받는 wordCnt 배열의 값을 ++ 해주고
					wordCount[spaceCnt - 1]++;
					// spaceCnt를 초기화한다
					spaceCnt = 0;
				}
			} // 가로 공간을 다 찾았다

			// 그럼 이제 세로 공간을 찾아준다
			// 가로 공간 찾을 때랑 똑같은데 for문의 row col 중첩 순서만 바꿔주면 된다
			for (int col = 0; col < puzzleSize; col++) {
				// 세로로 연속된 공간만 확인할 거니까 col이 바뀔 때 마다 sapceCnt를 초기화한다
				spaceCnt = 0;
				
				for (int row = 0; row < puzzleSize; row++) {
					// 현재 칸이 1이면
					if (puzzle[row][col] == 1) {
						// 연속된 1의 개수를 저장할 spaceCnt를 ++ 해준다
						spaceCnt++;
						} else if (puzzle[row][col] == 0) {
							// 현재 칸이 0 이면
							// spaceCnt값이 존재할 때
							//		=> spaceCnt가 0 이면 indexOutofBounds error발생하니까
							if (spaceCnt != 0) {
								// 여태까지의 spaceCnt - 1 을 인덱스로 받는 wordCnt 배열의 값을 ++ 해주고
								wordCount[spaceCnt - 1]++;
								// spaceCnt를 초기화한다
								spaceCnt = 0;
							}
					}
				}
				// 한 줄이 끝났을 때
				// 한 줄의 끝이 1 이면 그 때 까지의 spaceCnt 값이 저장되지 않았으니까
				// 저장하고 다음 줄로 넘어간다
				if (spaceCnt != 0) {
					// 여태까지의 spaceCnt - 1 을 인덱스로 받는 wordCnt 배열의 값을 ++ 해주고
					wordCount[spaceCnt - 1]++;
					// spaceCnt를 초기화한다
					spaceCnt = 0;
				}
			} // 세로 공간도 다 찾았다
			
			// 그럼이제 wordCount 배열에 해당 index+1 길이의 단어를 저장할 수 있는 공간이 들어가 있으므로
			// wordCount[wordSize - 1]을 출력하면 우리가 원하는 wordSize길이의 단어를 넣을 수 있는 공간의 개수가 나온다
			
			// 출력
			System.out.printf("#%d %d", testCase, wordCount[wordSize - 1]);
			System.out.println();
			
			
		}
		
		

		
	}
}




