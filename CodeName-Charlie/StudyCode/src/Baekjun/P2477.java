
// 시골에 있는 태양이의 삼촌 댁에는 커다란 참외밭이 있다. 문득 태양이는 이 밭에서 자라는 참외가 도대체 몇 개나 되는지 궁금해졌다.
// 유레카! 1m2의 넓이에 자라는 참외 개수를 헤아린 다음, 참외밭의 넓이를 구하면 비례식을 이용하여 참외의 총개수를 구할 수 있다.
// 1m2의 넓이에 자라는 참외의 개수는 헤아렸고, 이제 참외밭의 넓이만 구하면 된다. 
// 참외밭은 ㄱ-자 모양이거나 ㄱ-자를 90도, 180도, 270도 회전한 모양(┏, ┗, ┛ 모양)의 육각형이다.
// 다행히도 밭의 경계(육각형의 변)는 모두 동서 방향이거나 남북 방향이었다. 밭의 한 모퉁이에서 출발하여 밭의 둘레를 돌면서 밭경계 길이를 모두 측정하였다.
// ...
// 1m2의 넓이에 자라는 참외의 개수와, 참외밭을 이루는 육각형의 임의의 한 꼭짓점에서 출발하여 반시계방향으로 둘레를 돌면서 지나는 변의 방향과 길이가 순서대로 주어진다.
// 이 참외밭에서 자라는 참외의 수를 구하는 프로그램을 작성하시오.

package Baekjun;

// 답을 도출하는 방법 : 큰 직사각형의 넓이에서 작은 직사각형의 넓이를 뺀 다음 참외의 개수를 곱한다.
// 큰 직사각형의 넓이는 어떻게 도출할까?
// => 동서남북 중 한 번씩만 나온 변 두 개를 곱하자. 
// 작은 직사각형의 넓이는 어떻게 도출할까?
// => 동서남북 중 두 번씩 나온 변에 대해,
// 조건(큰 직사각형을 이루는 변과 떨어져 있다. + 임의로 시작하기 때문에 발생할 수 있는 경우의 수)을 적용해 도출해낸다. 


import java.util.Scanner;

public class P2477 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt(); // 1m^2의 넓이에 자라는 참외의 개수를 나타내는 변수 K를 입력 받는다.

		int[][] melonField = new int[6][2]; // 참외밭 넓이에 대한 정보를 입력 받을 2차원 배열 melonField를 생성한다. 
		int[] direction = new int[4]; // 참외밭 경계의 방향(동서남북)이 몇번 나왔는지를 저장할 크기가 4인 배열 direction을 생성한다. 

		for (int row = 0; row < 6; row++) { 
			for (int col = 0; col < 2; col++) { // 이중 for문을 사용해
				melonField[row][col] = sc.nextInt(); // 참외밭의 넓이에 대한 정보를 생성해둔 배열 melonField에 입력 받는다. 
			}
		}
		for(int row = 0; row < 6; row++) { 
			direction[melonField[row][0] - 1]++; // melonField의 열의 인덱스가 0인 값들은 참외밭 경계의 방향을 나타내기 때문에, 이를 세어 direction 배열에 저장한다.
		}

		int[] bigSquareLineIdx = new int[2]; // 배열 bigSquareLineIdx를 생성해, 큰 직사각형을 이루는 경계선의 방향(동서남북)을 저장한다.
		int i = 0; // bigSquareLineIdx 배열의 인덱스를 임시로 나타내줄 변수 i를 선언하고 0으로 초기화한다.
		int bigSquare = 1; // 큰 직사각형의 넓이를 나타낼 변수 bigSquare를 선언하고 1로 초기화한다.(각 변을 곱했을 때에 넓이에 영향을 주지 않게끔...)
		for (int idx = 0; idx < 4; idx++) { // for문을 통해 direction 배열을 탐색한다.
			if (direction[idx] == 1) { // direction배열의 요소값이 1이면 해당 인덱스는, 큰 직사각형을 이루는 변의 방향값이다. 
				bigSquareLineIdx[i] = idx + 1; // 해당 인덱스를 미리 생성해둔 bigSquareLineIdx의 요소로 저장한다.
				// 여기서, idx는 0부터 시작하기 때문에 1부터 시작하는 방향값과 맞추기 위해 1을 더해 저장해야한다.
				i++;
				for (int row = 0; row < 6; row++) { // for문을 통해,
					if (melonField[row][0] == (idx + 1)) { // direction 배열에서 요소값이 1인 인덱스에 1을 더한 값
						// (동서남북 중 한번만 나타난 방향이자 큰 직사각형의 변에 해당하는 방향)
						bigSquare *= melonField[row][1]; // 과 동일한 요소값을 가진 요소와 동일한 행 값을 가지며, 열값이 1인 (변의 길이를 나타낸다.)
						// 요소값을 bigSquare에 곱한다.(두 개가 나오며, 각각이 변에 해당된다.) 
					}
				}
			}
		}
		int smallSquare = 1; // 작은 직사각형의 넓이를 나타내는 변수 smallSquare를 선언 및 초기화한다.
		// (여기서는 해당 변수에 바로 값을 대입할 것이기 때문에, 값을 초기화를 1로 하지 않아도 괜찮다.)
		for (int row = 0; row < 6; row++) { // for문을 통해 행을 탐색한다.
			if (melonField[row][0] == bigSquareLineIdx[0] || melonField[row][0] == bigSquareLineIdx[1]) { // 해당 값이 큰 직사각형을 이루는 변 중 하나라면,
				if (row == 0) { // 행의 인덱스 값이 0 인경우
					if (melonField[row + 1][0] == bigSquareLineIdx[0] // 큰 직사각형을 이루는 또 다른 변이 배열의 바로 아래에 존재하는 경우,
							|| melonField[row + 1][0] == bigSquareLineIdx[1]) {
						smallSquare = melonField[3][1] * melonField[4][1]; // 작은 직사각형을 이루는 변은 행의 인덱스값이 3이고, 4인 경우이다.
						// 해당 변 두개를 곱해, 그 값을 작은 직사각형의 넓이에 저장하고,
						break; // 반복문을 종료한다.
					} else if (melonField[row + 1][0] != bigSquareLineIdx[0] // 만약 큰 직사각형을 이루는 또 다른 변이 배열의 바로 아래에 존재하지 않는다면,
							&& melonField[row + 1][0] != bigSquareLineIdx[1]) {
						smallSquare = melonField[2][1] * melonField[3][1]; //  작은 직사각형을 이루는 변은 행의 인덱스값이 2이고, 3인 경우이다.
						// 해당 변 두개를 곱해, 그 값을 작은 직사각형의 넓이에 저장하고,
						break; // 반복문을 종료한다.
					}
				}
				if(row == 1) { // 같은 방법으로 행의 인덱스 값이 1인 경우, 2인 경우... 6인 경우까지 조건을 만든다.
					if (melonField[row + 1][0] == bigSquareLineIdx[0]
							|| melonField[row + 1][0] == bigSquareLineIdx[1]) {
						smallSquare = melonField[4][1] * melonField[5][1];
						break;
					} else if (melonField[row + 1][0] != bigSquareLineIdx[0]
							&& melonField[row + 1][0] != bigSquareLineIdx[1]) {
						smallSquare = melonField[3][1] * melonField[4][1];
						break;
					}
				}
				if(row == 2) {
					if (melonField[row + 1][0] == bigSquareLineIdx[0]
							|| melonField[row + 1][0] == bigSquareLineIdx[1]) {
						smallSquare = melonField[0][1] * melonField[5][1];
						break;
					} else if (melonField[row + 1][0] != bigSquareLineIdx[0]
							&& melonField[row + 1][0] != bigSquareLineIdx[1]) {
						smallSquare = melonField[4][1] * melonField[5][1];
						break;
					}
				}
				if(row == 3) {
					if (melonField[row + 1][0] == bigSquareLineIdx[0]
							|| melonField[row + 1][0] == bigSquareLineIdx[1]) {
						smallSquare = melonField[0][1] * melonField[1][1];
						break;
					} else if (melonField[row + 1][0] != bigSquareLineIdx[0]
							&& melonField[row + 1][0] != bigSquareLineIdx[1]) {
						smallSquare = melonField[0][1] * melonField[5][1];
						break;
					}
				}
				if(row == 4) {
					if (melonField[row + 1][0] == bigSquareLineIdx[0]
							|| melonField[row + 1][0] == bigSquareLineIdx[1]) {
						smallSquare = melonField[1][1] * melonField[2][1];
						break;
					} else if (melonField[row + 1][0] != bigSquareLineIdx[0]
							&& melonField[row + 1][0] != bigSquareLineIdx[1]) {
						smallSquare = melonField[0][1] * melonField[1][1];
						break;
					}
				}
				if(row == 5) {
					if (melonField[row - 1][0] == bigSquareLineIdx[0]
							|| melonField[row - 1][0] == bigSquareLineIdx[1]) {
						smallSquare = melonField[1][1] * melonField[2][1];
						break;
					} else if (melonField[row - 1][0] != bigSquareLineIdx[0]
							&& melonField[row - 1][0] != bigSquareLineIdx[1]) {
						smallSquare = melonField[2][1] * melonField[3][1];
						break;
					}
				}
			}
		}
		System.out.println((bigSquare - smallSquare) * K); // 참외의 개수를 도출하는 식((큰 직사각형 - 작은 직사각형) * 참외밭 1m^2당 참외의 개수)을 바탕으로 답을 출력한다.
	}
}
