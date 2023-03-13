/* 문제
 * 도로 한 편에 임의의 간격으로 가로수가 심어져 있다.
 * 이 가로수들이 모두 같은 간격이 되도록 할 때, 새로 심어야 하는 가로수의 최소 갯수를 찾아보자.
 * 
 * 
 * 문제 조건
 * 이미 심어져 있는 가로수 갯수 N은 3이상 100,000 이하다.
 * 가로수의 위치를 나타내는 정수는 10억 이하다.
 * 
 * 
 * 문제 해결 방법
 * 첫번째 가로수와 두번째 가로수의 차이 = 1번
 * 두번째 가로수와 세번째 가로수의 차이 = 2번 이라고 할 때,
 * 1번과 2번의 최대 공약수 X를 구한다.
 * X와 3번의 최대 공약수를 구한다.
 * X와 4번 ... X와 n번의 최대 공약수를 구한다.
 * 주어지는 값 중 (최댓값 - 최솟값)/최대공약수를 하면 총 심어야 하는 갯수이므로,
 * (최댓값 - 최솟값)/최대공약수 - 현재 심은 가로수의 갯수 +1 을 해주자.
 * 
 */

package Baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class P2485 {
	// 유클리드 호제법 : x와 y가 있을 때(x>y), x를 y로 나눈다.
	// 나누어 떨어지지 않으면, x = x%y를 한다.
	// 이번엔 y가 x보다 커졌으므로 y가 큰수가 된다.
	// 편의를 위해 y에 x%y를 대입하고, x에 y를 대입하면
	// 다시 x>y가 되므로 같은 방법을 계속 반복한다.
	// x가 y로 나누어 떨어진다면, 그 값이 최대공약수가 된다.

	// 유클리드 호제법을 이용하여 최대공약수를 구하는 메소드를 만들어보자.
	public static int gcd(int x, int y) {
		// x를 y로 나누었을 때 나누어 떨어진다면 최대공약수가 되므로
		// x와 y가 나누어 떨어질 때 까지 반복하자.
		// 왼쪽을 큰 수로 두기 위해 y가 크다면 자리를 바꾸자.
		if (x < y) {
			int temp = x;
			x = y;
			y = temp;
		}

		// 정렬을 했으므로, x가 y보다 크다.
		// x를 y로 나눈 값이 0이 아니라면,
		while (x % y != 0) {

			// 큰수%작은수를 한다.
			// 큰수를 좌변에 두기 위해 자리를 바꾸자.
			int temp = x % y;
			x = y;
			y = temp;

		}
		// 나누어 떨어진다면, 작은수 y가 최대 공약수가 된다.
		return y;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 현재 심어져 있는 가로수의 수를 구하자.
		int treeCnt = sc.nextInt();

		// 심어져 있는 가로수의 값을 입력받기 위해 배열을 만들자.
		int[] arr = new int[treeCnt];

		// 현재 심어져 있는 가로수를 입력 받자.
		for (int i = 0; i < treeCnt; i++) {
			arr[i] = sc.nextInt();
		}

		// 정렬을 하자.
		Arrays.sort(arr);

		// 최대 공약수를 구해보자.
		// 첫번째 값은 arr[1]-arr[0]이 된다.
		// arr[1]-arr[0] 값과, arr[2]-arr[1]의 최대 공약수를 구하고
		// 그 최대 공약수와 arr[3]-arr[2]를 구하는 식으로 반복한다.
		int maxgcd = arr[1] - arr[0];

		// 0번과 1번의 차이는 구했으니,,,
		// 1번과 2번 차이를 구하고, 두 수의 최대공약수를 구하자.
		for (int i = 2; i < treeCnt; i++) {
			maxgcd = gcd(maxgcd, arr[i] - arr[i - 1]);
		}

		// (최댓값 - 최솟값)/gcd - treeCnt+1을 하면 된다.
		int cnt = (arr[treeCnt - 1] - arr[0]) / maxgcd - treeCnt + 1;

		System.out.println(cnt);
	}
}
