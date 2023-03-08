
//        7
//      3   8
//    8   1   0
//  2   7   4   4
//4   5   2   6   5

// 위 그림은 크기가 5인 정수 삼각형의 한 모습이다.
// 맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라. 
// 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.
// 삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.

package Baekjun;

// 이차원 배열을 생성하고, 수를 입력 받자.
// Dynamic Programming을 통해, 경로의 최대값을 계산하자.
// 값을 출력하자.

import java.util.Arrays;
import java.util.Scanner;

public class P1932 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 삼각형의 크기 n을 입력 받는다.

		int[][] map = new int[n][n]; // 수를 입력 받을 n x n 크기의 이차원 배열 map을 생성한다.
		int[][] DP = new int[n][n]; // 각 위치에서의 최대값을 저장할 배열 DP를 생성한다.

		for (int row = 0; row < n; row++) { // 이중 for문을 통해 map 배열에 수를 입력 받는다.
			for (int col = 0; col <= row; col++) { // => 삼각형 모양의 배열이기 때문에, 열의 조건식을 col <= row로 설정한다.
				map[row][col] = sc.nextInt();
			}
		}
		
		DP[0][0] = map[0][0]; // 0일 때는 최대값이 하나이기 때문에, map[0][0]의 값을 바로 대입한다. 
		
		if(n >= 2) { // 런타임 에러 발생을 방지하기 위해, n이 2 이상이라는 조건을 설정한다. 
			DP[1][0] = map[0][0] + map[1][0]; // row가 1일 때의 최대값도 각각 하나이기 때문에, 값을 대입한다.
			DP[1][1] = map[0][0] + map[1][1];
		}
		
		for (int row = 2; row < n; row++) { // row가 2일 때에는, 조건을 세 가지로 나누어 연산한다. 
			for (int col = 0; col <= row; col++) {
				if (col == 0) { // col = 0인 경우,(맨 왼쪽)
					DP[row][col] = DP[row - 1][col] + map[row][col]; // 이전 행의 DP 값과 선택된 2차원 배열의 요소값의 합을 DP 값에 대입한다.
				} else if (col == row) { // col = row인 경우, (맨 오른쪽)
					DP[row][col] = DP[row - 1][col - 1] + map[row][col]; // 이전 행의 (col-1)의 DP값과 선택된 2차원 배열의 요소값의 합을 DP 값에 대입한다.
				} else { // 나머지 경우,(맨 왼쪽도, 오른쪽도 아닌 경우)
					DP[row][col] = Math.max(DP[row - 1][col - 1], DP[row - 1][col]) + map[row][col]; // 이전 행의 DP값 두 개를 비교하고, 더 큰 값과 선택된 2차원 배열의 요소값의 합을 DP 값에 대입한다.
				}
			}
		}
		// DP 배열의 마지막 행에는 선택할 수 있는 최대값이 저장 되어있을 것이다.
		int[] arr = new int[n]; // 크기가 n인 배열 arr를 생성하고,
		for (int idx = 0; idx < n; idx++) {
			arr[idx] = DP[n - 1][idx]; // arr에 DP의 마지막 행의 값을 순차적으로 대입한다. 
		}
		Arrays.sort(arr); // arr를 Arrays.sort 메서드를 통해 오름차순으로 정렬한 뒤,
		System.out.println(arr[n - 1]); // 배열의 마지막 값(최대값)을 출력한다.

	}
}
