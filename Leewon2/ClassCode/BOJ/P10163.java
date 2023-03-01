// 문제 조건
// 색종이가 비스듬하게 놓이는 경우는 없다. => 모든 색종이는 평행이거나 수직이다.
// N장의 색종이는 1이상 100 이하다.
// 색종이가 놓이는 평면은 가로 최대1001칸, 세로 최대 1001칸이다.

// 문제 해결 방법
// 첫번째 색종이에는 1, 두번째는2 ...n까지 숫자를 덮어씌워서 해결한다.

// 1. 색종의 장수 N과, 왼쪽 아래의 숫자, 가로, 세로 크기를 입력 받는다.
// 2. 크기가 1001인 2차원 배열을 만든다.
// 3. 2중 for문을 이용하여 첫번째 색종이에 관한 정보는 1,
// 두번째는 2, 세번째는 3 ...n 까지 입력하고,
// 1의 갯수, 2의 갯수 ... n의 갯수를 세서 출력하자.

import java.util.Scanner;

public class P1244 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 색종이의 수를 입력 받는다.
		int paper = sc.nextInt();

		// (0,0)부터 (1000,1000)까지 있는 배열을 만들자.
		int[][] arr = new int[1001][1001];

		// 해당 행렬에서 색종이의 크기를 셀 변수를 만든다.
		int cnt = 0;

		// 배열을 탐색할 때, 탐색할 범위를 지정하기 위한 변수를 만든다.
		int maxR = 0;
		int maxC = 0;
		int minR = 1001;
		int minC = 1001;
		for (int idx = 1; idx <= paper; idx++) {
			// 시작점을 입력 받는다.
			int startRow = sc.nextInt();
			int startCol = sc.nextInt();

			// 너비와 높이를 입력 받는다.
			int rSize = sc.nextInt();
			int cSize = sc.nextInt();

			// 배열을 탐색할 때 메모리를 줄이기 위해 범위의 최솟값과 최댓값을 구해놓자.
			maxR = Math.max(maxR, startRow + rSize);
			maxC = Math.max(maxC, startCol + cSize);
			minR = Math.min(minR, startRow);
			minC = Math.min(minC, startCol);

			// 배열의 전체를 탐색할수는 없으니,,,
			// 왼쪽 아래의 시작점부터 시작점 + 가로&세로 크기만큼까지만 반복하자.
			for (int row = startRow; row < startRow + rSize; row++) {
				for (int col = startCol; col < startCol + cSize; col++) {
					// 해당 (row,col)에 idx값을 저장해주자.
					// 행렬의 (0,0)에 1이 저장되어 있어도
					// 두번째 색종이가 (0,0)을 포함한다면 값이 2로 바뀐다.
					arr[row][col] = idx;
				}
			}
		}
		// 배열을 탐색하여 1의 갯수, 2의갯수 ... n까지 몇개가 있는지 세어보자.
		for (int i = 1; i <= paper; i++) {
			// 결괏값을 저장할 변수를 만들자.
			int result = 0;

			// 범위를 행의 최솟값~최댓값, 열의 최솟값~최댓값 까지로 정한다.
			// 어차피 그 외의 값은 0이므로 배열의 전체를 탐색할 필요가 없다.
			for (int row = minR; row < maxR; row++) {
				for (int col = minC; col < maxC; col++) {

					// 해당 (row,col)이 i와 같다면, 결괏값에 1을 더한다.
					if (arr[row][col] == i)
						result++;
				}
			}
			// 출력
			System.out.println(result);

		}
	}

}
