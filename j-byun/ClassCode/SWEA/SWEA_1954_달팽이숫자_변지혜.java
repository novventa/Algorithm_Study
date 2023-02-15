package test;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// SWEA
		// 1954 달팽이 숫자
		// D2
		
		// 문제
		// 달팽이는 1부터 N*N까지의 숫자가 시계방향으로 이루어져 있다
		// 정수 N을 입력받아 N*N크기의 2차원배열 달팽이를 출력하시오
		
		// 풀이
		// 달팽이[][]에 현재 값을 넣어주는데...
		// row == 0, col == 0에서 시작
		// col++ 하다가 col+1이 >= n이거나 달팽이[row][col+1]이 0이 아니면 row++하고,
		// row++ 하다가 row+1이 >= n이거나 달팽이[row+1][마지막col]이 0이 아니면 col--하고,
		// col-- 하다가 col+1이 < 원래col이거나 달팽이[마지막row][col+1]이 0이 아니면 row--하고,
		// row-- 하다가 row-1이 <= 원래row거나 달팽이[row-1][마지막col]이 0이 아니면 다시 col++
		
		// 0,0 -> 1,1 -> 2,2 로 시작점 row, col이 한 바퀴 돌 때마다 같이 ++ 돼야함
		// 첫 번째 for문에 row, col 둘 다 넣어줄 것
		
		// num=1에서부터 넣고 ++해주다가 num++ > n*n이면 종료하고 달팽이출력
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 개수 t 입력받기
		int t = sc.nextInt();
		
		for (int testCase = 1; testCase <= t; testCase++) {
			// 달팽이의 가로 세로 사이즈 n 입력받기
			int snailSize = sc.nextInt();
			
			// 달팽이의 최대 크기 n*n 정하기
			int maxSnailCount = snailSize * snailSize;
			
			// 1부터 ++ 해가며 달팽이에 넣을 값을 저장하는 snailCount 만들기
			int snailCount = 1;
			
			// n*n사이즈 2차원 배열 달팽이 만들기
			int[][] snail = new int[snailSize][snailSize];
			
			// 0,0에서 시작해서 한바퀴 돌고나면 1,1 -> 2,2 로 row, col 다 ++ 해가면서 달팽이에 입력넣기
			// for문이 돌 때마다 row, col은 대각선방향으로 나아가는데...
			// for문이 돌 때마다 대각선 기준으로 두 값이 추가되니 (for문이 돌 때 마다 사각형 모양 하나가 채워지는 것)
			// row와 col 최대는 snailSize / 2까지만 가면 된다
			//		=> 최대치를 snailSize까지 해도 어차피 안에 있는 네개 의 for문에서 snail[][] == 0이 아니기 때문에 바뀔건 없지만
			//			쓸데없는 메모리 낭비를 줄이기 위해 최대값을 /2로 정한다
			//		=> snailSize가 홀수 일 경우를 위해 = 등호 포함해주기
			outer : for (int row = 0, col = 0; row <= snailSize / 2 && col <= snailSize / 2; row++, col++) {
				// 현재 row, col값을 나타낼 변수 만들기
				int currentRow = row;
				int currentCol = col;
				
				// 1. row는 고정, col++ 하면서 입력넣기
				for (int colPlus = currentCol; colPlus < snailSize && snail[currentRow][colPlus] == 0; colPlus++) {
					// col값이 바뀌었으니까 현재 col값 저장해주기
					currentCol = colPlus;
					
					// 달팽이에 현재 달팽이카운트 넣고나서 ++ 해주는데...
					snail[currentRow][currentCol] = snailCount++;
					// ++ 한 후의 달팽이 카운트가 최대달팽이카운트를 초과했을 경우 값 입력 종료하기
					//		=> break outer;
					if (snailCount > maxSnailCount) {
						break outer;
					}
				} // colPlus값이 달팽이 사이즈를 벗어났거나, 이미 그 칸에 입력된 값이 존재하면 for문 종료
				
				// 2. [현재row][1에서 col++하면서 마지막으로 업데이트된 현재col값] 에서부터 row++ 하면서 입력넣기
				for (int rowPlus = currentRow + 1; rowPlus < snailSize && snail[rowPlus][currentCol] == 0; rowPlus++) {
					// row값이 바뀌었으니까 현재 row값 저장해주기
					currentRow = rowPlus;
					
					// 달팽이에 현재 달팽이카운트 넣고나서 ++ 해주는데...
					snail[currentRow][currentCol] = snailCount++;
					// ++ 한 후의 달팽이 카운트가 최대달팽이카운트를 초과했을 경우 값 입력 종료하기
					//		=> break outer;
					if (snailCount > maxSnailCount) {
						break outer;
					}
				} // rowPlus값이 달팽이 사이즈를 벗어났거나, 이미 그 칸에 입력된 값이 존재하면 for문 종료
				
				// 3. [2에서 row++하면서 마지막으로 업데이트된 현재row값][1에서 col++하면서 마지막으로 업데이트된 현재col값] 에서부터 col--하면서 입력넣기
				for (int colMinus = currentCol - 1; colMinus >= 0 && snail[currentRow][colMinus] == 0; colMinus--) {
					// col값이 바뀌었으니까 현재 col값 저장해주기
					currentCol = colMinus;
					
					// 달팽이에 현재 달팽이카운트 넣고나서 ++ 해주는데...
					snail[currentRow][currentCol] = snailCount++;
					// ++ 한 후의 달팽이 카운트가 최대달팽이카운트를 초과했을 경우 값 입력 종료하기
					//		=> break outer;
					if (snailCount > maxSnailCount) {
						break outer;
					}
				} // colMinus값이 0보다 작거나 (== 달팽이를 벗어남), 이미 그 칸에 입력된 값이 존재하면 for문 종료
				
				// 4. [2에서 row++하면서 마지막으로 업데이트된 현재row값][3에서 col--하면서 마지막으로 업데이트된 현재col값] 에서부터 row--하면서 입력넣기
				//		--해나가다보면 outer for문의 row와 만나게 되는데,
				//			그 전까지만 가면됨! => 조건을 outer for문의 row보다 클 때 까지만 지정하기
				for (int rowMinus = currentRow - 1; rowMinus > row && snail[rowMinus][currentCol] == 0; rowMinus--) {
					// row값이 바뀌었으니까 현재 row값 저장해주기
					currentRow = rowMinus;
					
					// 달팽이에 현재 달팽이카운트 넣고나서 ++ 해주는데...
					snail[currentRow][currentCol] = snailCount++;
					// ++ 한 후의 달팽이 카운트가 최대달팽이카운트를 초과했을 경우 값 입력 종료하기
					//		=> break outer;
					if (snailCount > maxSnailCount) {
						break outer;
					}
				} // rowMinus값이 outer for문의 row보다 작거나, 이미 그 칸에 입력된 값이 존재하면 for문 종료
				//		=> 이제 row+1, col+1해서 다시 시계방향으로 for문 네 번 돌기
				
			}
			// for문 다 돌았으면 달팽이에 모든 값이 채워졌다
			
			// 출력
			System.out.printf("#%s", testCase);
			System.out.println();
			// for문 돌면서 달팽이 출력
			for (int row = 0; row < snailSize; row++) {
				for (int col = 0; col < snailSize; col++) {
					System.out.print(snail[row][col] + " ");
				}
				System.out.println();
			}
			
		}
		
	}
}




