// 문제 조건
// 참외밭의 모든 각은 90도의 배수이다.
// 밭의 경계는 동서남북 방향 중 하나이다.
// 1m^2의 넓이에 자라는 참외의 갯수는 1이상 20 이하다.
// 변의 길이는 1이상 500이하의 정수로 주어진다.
// 동 서 남 북 순으로 1, 2, 3, 4로 나타낸다.

// 문제 해결 방법
// 1-1. 입력받는 숫자크기로 방향과 길이를 저장할 배열 2개를 만들자.
// 1-2. 가로와 세로의 최댓값을 찾는다.
// 1-3. 최댓값을 곱해 넓이를 구해논다.
// 2. 길이가 가로의 최댓값 혹은 세로의 최댓값과 연결되어 있지 않다면,
// 빈 사각형의 한 변이 된다.
// 3. 넓이에서 빈 사각형을 빼보자.

import java.util.Scanner;

public class P2477 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 참외 갯수를 입력 받자.
		int n = sc.nextInt();

		// 최댓값을 저장할 변수를 만든다.
		int maxRow = 0;
		int maxCol = 0;

		// 방향과 길이를 저장할 변수 2개를 만드낟.
		int[] directionArr = new int[6];

		// 앞 뒤를 확인하기 위해 크기가 8인 배열을 만든다.
		int[] lenArr = new int[8];

		// 앞 뒤를 확인하기 위해 크기가 8인 배열에
		// 1부터 6까지 값을 넣는다.
		for (int i = 0; i < 6; i++) {
			directionArr[i] = sc.nextInt();
			lenArr[i + 1] = sc.nextInt();
			// 가로와 세로의 최댓값을 구해 저장해보자.
			if (directionArr[i] == 1 || directionArr[i] == 2) {
				if (lenArr[i + 1] > maxRow)
					maxRow = lenArr[i + 1];
			} else {
				if (lenArr[i + 1] > maxCol)
					maxCol = lenArr[i + 1];
			}
		}
		// 50 160 30 60 20 100이 주어지는 경우
		// 100 50 160 30 60 20 100 50으로 바꿔보자
		lenArr[0] = lenArr[6];
		lenArr[7] = lenArr[1];

		// 넓이를 저장할 변수를 만들자.
		int sum = maxRow * maxCol;

		// 빈 사각형을 구할 변수를 만든다.
		int quad = 1;

		// direction이 1혹은 2인 경우(가로인 경우)
		// 배열의 앞 뒤를 확인하여 세로의 최댓값과 연결되어 있는지 확인한다.
		// 배열의 0번과 7번 인덱스에는 6번과 1번의 인덱스 값이 들어있다.
		// 0번과 7번 인덱스는 값을 비교하기 위한 것이기 때문에
		// 범위를 1부터7까지로 한다.
		for (int i = 1; i < 7; i++) {
			// 가로인 경우
			if (directionArr[i - 1] == 1 || directionArr[i - 1] == 2) {
				// 앞뒤 값은 무조건 세로인데,
				// 이 값들 중 세로의 최댓값과 일치하는 값이 없고, 자기 자신이 가로의 최댓값이 아니라면
				// 빈 사각형의 한 변이므로 quad에 곱한다.
				if (lenArr[i - 1] != maxCol && lenArr[i + 1] != maxCol && lenArr[i] != maxRow) {
					quad *= lenArr[i];
				}
			}
			// 세로인 경우
			else if (directionArr[i - 1] == 3 || directionArr[i - 1] == 4) {
				if (lenArr[i - 1] != maxRow && lenArr[i + 1] != maxRow && lenArr[i] != maxCol) {
					quad *= lenArr[i];
				}
			}
		}

		// 전체 넓이에서, 빈 사각형을 빼고, n을 곱하여 출력하자.
		System.out.println((sum - quad) * n);
	}
}
