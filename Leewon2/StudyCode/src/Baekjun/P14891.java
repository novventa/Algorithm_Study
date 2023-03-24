/* 문제
 * 8개의 톱니를 가지고 있는 4개의 톱니바퀴가 있다. 톱니는 N극 또는 S극 중 하나를 나타낸다.
 * 톱니바퀴 ABCD가 있다. 
 * A를 시계방향으로 회전시킬 때, A와 B의 맞닿은 부분이 다른 극 이라면 B는 시계반대방향으로 회전시킨다.
 * 다음으로 B와 C가 맞닿은 부분을 확인하고, 서로 다른 극 이라면,
 * B가 시계 반대방향으로 회전했으므로 C는 시계방향으로 회전한다.
 * 톱니바퀴의 초기 상태와 회전시킨 방법이 주어졌을 때, 최종 톱니바퀴의 상태를 구하는 프로그램을 짜보자.
 * 
 * 
 * 조건
 * 톱니는 8개로 이루어져 있고, 4개의 톱니바퀴가 존재한다.
 * 톱니바퀴의 상태는 8개의 정수로 이루어져 있으며, 12시 방향부터 시계방향 순서대로 주어진다.
 * N극은 0, S극은 1로 나타낸다.
 * 회전 횟수 K는 1 이상 100 이하다.
 * 회전 방향이 1인 경우 시계방향이고, -1인 경우는 반시계 방향이다.
 * 
 * 
 * 해결 방법
 * 시작 톱니를 기준으로 앞 뒤를 확인해보자.
 * 1번 톱니와, 4번 톱니는 단방향으로 연결되어 있기 때문에 확인할 필요가 없다.
 * 톱니는 2번 과 6번이 맞물려있다.
 * 
 * 먼저 앞을 확인하는데, start의 2번 톱니와 start+1의 6번 톱니가 다른 극 이라면,
 * start+1도 회전할 수 있으므로 boolean 값을 true로 저장한다.
 * start의 톱니와 start+1의 톱니가 같은 극 이라면,
 * start+1은 회전할 수 없고, start+1 이후의 톱니바퀴 또한 회전할 수 없으므로 break를 한다.
 * 
 * 뒤는 start의 6번 톱니와 start-1의 2번 톱니를 비교한다.
 * 
 * 비교를 마치고 회전이 가능한 톱니바퀴는 start이거나, boolean 값이 true인 녀석들이다.
 * start가 시계방향으로 회전했다면, start+1은 반시계 방향으로 회전하고, start+2는 시계방향으로 회전한다.
 * 즉, start와 N번의 톱니를 더했을 때 짝수라면 start가 회전한 방향과 같은 방향으로 회전한다.
 * 
 * 시계방향으로 회전하는 경우는, 마지막 값 arr[i][7]을 따로 저장해둔 뒤, 값을 하나씩 뒤로 민다.
 * 마지막으로 arr[i][0]에 저장한 arr[i][7]을 삽입한다.
 * 
 * 반시계방향의 경우, arr[i][0]을 저장해둔 뒤, 값을 하나씩 앞으로 땡긴다.
 * 마지막으로 arr[i][7]에 저장한 arr[i][0]을 삽입한다.
 * 
 * 회전이 모두 끝나면, 점수를 계산해서 출력한다.
 * 
 */

package Baekjun;

import java.util.Scanner;

public class P14891 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 톱니바퀴를 저장할 배열을 만들자.
		int[][] arr = new int[4][8];

		// 톱니바퀴의 정보를 입력 받자.
		for (int row = 0; row < 4; row++) {
			String str = sc.next();
			for (int col = 0; col < 8; col++) {
				// 띄어쓰기 없이 주어졌으므로, String으로 받은 후,
				// str.charAt(col)을 통해 문자로 변환시킨다.
				// 문자로 변환된 값을 Character.getNumericValue를 통해 숫자로 변환한다.
				arr[row][col] = Character.getNumericValue(str.charAt(col));
			}
		}

		// 회전횟수를 입력 받는다.
		int cnt = sc.nextInt();

		for (int idx = 0; idx < cnt; idx++) {
			// 시작 톱니바퀴를 입력 받는다.
			int start = sc.nextInt();

			// 인덱스를 이용하기 위해 start에 1을 빼자.
			start--;

			// 어디로 돌지 방향을 입력 받는다.
			int dir = sc.nextInt();

			// boolean 값이 계속 초기화 되야 하므로 여기에 선언하자.
			boolean[] check = new boolean[4];

			// 앞을 먼저 확인해보자. 4번은 확인할 필요가 없다.
			for (int i = start; i < 3; i++) {
				// 2번과 6번 극이 같은지 확인해보자.
				if (arr[i][2] == arr[i + 1][6]) {
					// 같다면, boolean 값을 false로 바꾸자.
					// 만약 false라면 다음 값은 어차피 돌아가지 않으므로 break하자.
					check[i + 1] = false;
					break;
				}
				// 다르다면? boolean 값을 true로 바꾸자.
				else {
					check[i + 1] = true;
				}
			}

			// 뒤를 확인해보자 0번은 확인할 필요가 없다.
			for (int i = start; i > 0; i--) {
				if (arr[i][6] == arr[i - 1][2]) {
					// 6번과 2번이 같다면, boolean 값을 false로 바꾸자.
					// 만약 false라면 다음 값은 어차피 돌아가지 않으므로 break하자.
					check[i - 1] = false;
					break;
				}
				// 다르다면? boolean 값을 true로 바꾸자.
				else {
					check[i - 1] = true;
				}
			}

			// 시계방향 이라면,
			if (dir == 1) {
				// 4개의 톱니바퀴 상태를 바꿔보자.
				for (int i = 0; i < 4; i++) {
					// start 녀석은 시계방향으로 돌아야한다.
					// start가 짝수라면, 짝수+짝수는 짝수이고,
					// start가 홀수라면, 홀수+홀수도 짝수이므로,
					// i+start를 2로 나눈 나머지가 0인 경우 start와 같은 방향으로 회전한다.
					if (i == start || (check[i] && (i + start) % 2 == 0)) {
						// 7번째를 저장해놓고 for문을 이용해 한칸씩 줄이자.
						int temp = arr[i][7];
						// 값을 하나씩 뒤로 밀자.
						for (int j = 7; j >= 1; j--) {
							arr[i][j] = arr[i][j - 1];
						}
						// 첫번째 인덱스에 temp를 저장한다.
						arr[i][0] = temp;
					}

					// start가 홀수라면 true인 녀석들 중 홀수는 start와 같은 방향으로 돌고
					// 짝수라면 시계 반대방향으로 돌아야 한다.
					// 0번째를 저장해놓고, 값을 앞으로 땡기자.
					else if (check[i]) {
						int temp = arr[i][0];
						for (int j = 0; j < 7; j++) {
							// 값을 하나씩 앞으로 땡기자.
							arr[i][j] = arr[i][j + 1];
						}
						// 마지막 인덱스에 temp를 저장한다.
						arr[i][7] = temp;
					}

				}
			}

			// 시계 반대방향 이라면
			else if (dir == -1) {
				for (int i = 0; i < 4; i++) {
					// start 녀석은 시계 반대방향으로 돌아야한다.
					if (i == start || (check[i] && (i + start) % 2 == 0)) {
						// 0번째를 저장해놓고 for문을 이용해 한칸씩 줄이자.
						int temp = arr[i][0];
						for (int j = 0; j < 7; j++) {
							arr[i][j] = arr[i][j + 1];
						}
						arr[i][7] = temp;
					}

					// true인 녀석들은 시계 방향으로 돌아야 한다.
					else if (check[i]) {

						int temp = arr[i][7];
						for (int j = 7; j >= 1; j--) {
							arr[i][j] = arr[i][j - 1];
						}
						arr[i][0] = temp;
					}
				}
			}

		}

		// 최종적으로 톱니바퀴의 위치가 정해졌다.
		// 12시 방향이 S극인지 확인하자. 12시 방향은 0번 인덱스이다.
		int sum = 0;
		if (arr[0][0] == 1)
			sum += 1;
		if (arr[1][0] == 1)
			sum += 2;
		if (arr[2][0] == 1)
			sum += 4;
		if (arr[3][0] == 1)
			sum += 8;

		System.out.println(sum);
	}
}