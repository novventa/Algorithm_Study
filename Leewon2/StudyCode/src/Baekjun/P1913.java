/* 문제
 * 홀수인 자연수 N이 주어진다. 1부터 N^2까지의 자연수를 달팽이 모양으로 N*N의 표에 채우고자 한다.
 * N이 주어졌을 때, N*N 크기의 2차원 배열을 출력한다.
 * 또, 하나의 자연수가 주어졌을 때, 그 좌표도 함께 출력하는 프로그램을 작성해보자.
 * 
 * 
 * 조건
 * 자연수 N은 홀수이다
 * N은 3 이상 999 이하다.
 * 자릿수를 맞춰 출력할 필요는 없다.
 * 
 * 
 * 아이디어
 * N/2 자리를 시작점으로 잡는다.
 * 시작점부터 차례대로, 상우하좌 순으로 숫자를 증가시키며 나아가보자.
 * N이 7인 경우, N/2는 3이 되고, (3,3)이 시작점이 된다.
 * 시작점이 (3,3)이라는 것은 위와 왼쪽에 0,1,2행/열이 존재하고,
 * 아래와 오른쪽에 4,5,6행/열이 존재하므로 총 3번 반복하면 되는데, 이는 N/2와 같다. 
 * N/2만큼 반복하면서 달팽이가 회전하는 기준을 정하고 델타배열을 이용해 달팽이가 달팽이를 돌려보자. 
 * 
 * 달팽이는 아래와 같이 돌아야 하는데, 가운데를 기준으로, 3*3이 되었을 때 한 칸 위로 올라간다.
 * 3*3은, (2,2) 부터 (4,4) 까지이고, 이를 식으로 표현하면 N/2-1 ~ N/2+1이 된다.
 * 다음으로 5*5가 되었을 때 한 칸 올라간다.
 * 5*5는 (1,1) 부터 (5,5) 까지이고, 이를 식으로 표현하면 N/2-2 ~ N/2+2가 되므로,
 * 반복문의 범위를 N/2-i ~ N/2+i로 설정한다.
49 26 27 28 29 30 31
48 25 10 11 12 13 32
47 24  9  2  3 14 33
46 23  8  1  4 15 34
45 22  7  6  5 16 35
44 21 20 19 18 17 36
43 42 41 40 39 38 37
 * 
 * 
 * 
 */

package Baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1913 {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 시간초과 방지를 위해 buffered를 사용하자.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 자연숫 N을 입력 받는다.
		int N = Integer.parseInt(br.readLine());
		// 찾을 수도 입력 받는다.
		int findNum = Integer.parseInt(br.readLine());

		// 시작점을 N/2로 저장하자.
		int startR = N / 2;
		int startC = N / 2;

		// N*N 크기의 2차원 배열을 만들고 map이라고 선언한다.
		int[][] map = new int[N][N];

		// 숫자를 늘려줄 변수를 만들자.
		int idx = 1;

		// 시작점에는 1을 저장한다.
		map[startR][startC] = idx;

		// N이 7인 경우 3번 반복하고, 시작점은 (3,3)이 된다.
		// 위와 왼쪽은 0,1,2행/열을 확인하고, 오른쪽과 아래는 4,5,6행/열을 확인하면 되므로
		// 총 3번만 확인하면 되므로 N/2까지 반복한다.
		for (int i = 1; i <= N / 2; i++) {

			// 델타배열을 이용해 회전해보자.
			for (int dir = 0; dir < dr.length; dir++) {

				// 무한반복을 이용해 달팽이가 얼마나 앞으로 나아갈지는 정하지 않는다.
				while (true) {
					// 범위를 벗어나지 않는 경우 앞으로 나아가보자.
					// 주석참고
					if (startR + dr[dir] >= N / 2 - i && startR + dr[dir] <= N / 2 + i && startC + dc[dir] >= N / 2 - i
							&& startC + dc[dir] <= N / 2 + i) {
						// 한 칸 앞으로 나가보자.
						startR += dr[dir];
						startC += dc[dir];

						// 앞으로 나간 좌표에 몇번째인지 저장하자.
						map[startR][startC] = ++idx;
					}
					// 달팽이가 범위를 벗어나는 경우 무한반복을 탈출하자.
					// while문을 빠져나오면, dir이 하나 증가하고 이는 회전했다는 의미이다.
					else {
						break;
					}
				}
			}
		}

		// 위의 반복문은 위로 올라가는 것 부터 시작했으므로,
		// 반복문이 끝난다면, 마지막에는 위로 올라가지 못하고 끝나있다.
		// 나머지를 채워주자.
		for (int i = N - 2; i >= 0; i--) {
			map[i][0] = ++idx;
		}

		// StringBuilder를 이용해 한번에 출력해보자.
		StringBuilder sb = new StringBuilder();

		// map 전체를 탐색해보자.
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				// map에 저장된 값을 하나씩 출력하자.
				sb.append(map[row][col] + " ");

				// 만약에 찾고자 하는 수를 찾았다면
				// 정보를 저장해놓자.
				if (map[row][col] == findNum) {
					startR = row;
					startC = col;
				}
			}
			sb.append("\n");
		}
		// 출력 형식에 맞춰 출력해보자.
		System.out.print(sb);
		System.out.print((startR + 1) + " " + (startC + 1));
//      for (int[] list : map) {
//         System.out.println(Arrays.toString(list));
//      }

	}
}