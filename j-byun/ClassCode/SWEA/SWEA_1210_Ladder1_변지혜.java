package test;

import java.util.Scanner;

public class SWEA_1210_Ladder1_변지혜 {
	public static void main(String[] args) {
		// SWEA
		// 1210 Ladder1
		// D4
		
		// 문제
		// 사다리 그려서 게임할건데
		// 어느 사다리를 골라야 X표시에 도착하는지?
		
		// 좌우에 1이 나타나면 방향전환
		//		그럼 좌우로 가다가...
		//		아래에 1이 나타나면 아래로 방향전환
		//			가다가 좌우 발견하면 또 방향전환 ... 반복
		
		// 도착점 x는 2로 주어짐
		
		// 풀이
		// 마지막 행에서 2로 표현된 X 찾기
		// X에서 시작해서 위로 올라가기
		//		while (row > 0) row--
		// 위로 가다가 좌우 1 만나면 방향 전환
		//		if (ladder[col + 1] == 1 || ladder[col - 1] == 1)
		//			col값 업데이트하고 col 방향으로 진행
		//		좌우로 가다가 0만나면 위로 방향전환
		//			업데이트 된 row,col값에서 while문 다시 시작
		//			반복
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		
		// 테스트케이스 10개 만큼 반복
		for (int testCase = 1; testCase <= 10; testCase++) {
			// 테스트 케이스 번호 입력받기
			int tc = sc.nextInt();
			
			// 100*100 크기의 사다리 배열 만들기
			int[][] ladder = new int[100][100];
			
			// 사다리 배열에 사다리 정보를 표현하는 1, 0 입력받기
			for (int row = 0; row < 100; row++) {
				for (int col = 0; col < 100; col++) {
					ladder[row][col] = sc.nextInt();
				}
			}
			
			// 현재 진행중인 좌표의 위치를 나타낼 currentRow, currentCol 변수를 만들어준다
			// 99행의 x위치부터 시작할거니까 currentRow = 99
			int currentRow = 99;
			int currentCol = 0;
			
			// 마지막 행에서 도착지 X로 표현된 2 찾기
			for (int col = 0; col < 100; col++) {
				// 도착지 2를 찾으면
				if (ladder[currentRow][col] == 2) {
					// 그 때의 col 값을 현재col에 저장해준다
					currentCol = col;
				}
			}
			
			// 도착지 2의 위치인 ladder[currentRow][currentCol]에서 시작해서
			// currentRow가 0이 되면 break;
			while (currentRow > 0) {
				// 현재 위치 기준 좌우에 1이 있으면 방향을 전환한다
				// 좌 : col - 1
				// col-- 하다가 벽을 만나면 else로 가서 currentRow--한다
				if (currentCol - 1 >= 0 && ladder[currentRow][currentCol - 1] == 1) {
					// 0을 만날 때 까지 계속 좌측으로 진행한다
					// 0을 만나거나 벽을 만나면...
					// 	위로 올라가야 하니 currentRow-- 해준다
					while (currentCol - 1 >= 0 && ladder[currentRow][currentCol - 1] == 1) {
						currentCol--;
					} // 0이나 벽을 만나면 while문을 벗어나서...
					// currentRow--해주고 바깥 while문을 다시 돈다
					currentRow--;
					
				} else if (currentCol + 1 < 100 && ladder[currentRow][currentCol + 1] == 1) {
					// 우 : col + 1
					// col++ 하다가 벽을 만나면 else로 가서 currentRow--한다
					// 우측 방향에 대해서도 좌측과 동일하게 0을 만나거나 벽을 만날 때 까지 진행하다가
					// 	둘 중 하나랑 만나면 위로 올라가기 위해 currentRow--해준다
					while (currentCol + 1 < 100 && ladder[currentRow][currentCol + 1] == 1) {
						currentCol++;
					} // 0이나 벽을 만나면 while문을 벗어나서...
					// currentRow--해주고 바깥 while문을 다시 돈다
					currentRow--;
					
				} else {
					// 좌우에 1로 표현된 사다리가 없으면 그냥 계속 위로 진행한다
					currentRow--;
				}
				
			} // while문을 벗어났다는 건 currentRow == 0 이 됐을 때다
			// 이때 currentCol값이 우리가 원하는 출력 값!!
			
			// 출력 양식
			sb.append("#").append(tc).append(" ").append(currentCol).append("\n");
		}
		
		// 출력
		System.out.println(sb);

	}
}


