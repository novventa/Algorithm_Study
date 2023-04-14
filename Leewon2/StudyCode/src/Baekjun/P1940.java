/* 문제
 * 주몽은 철기군이 입을 갑옷을 만들게 하였다. 갑옷을 만들던 중 아래와 같은 사실을 발견했다.
 * 1. 갑옷을 만드는 재료들은 각각 고유한 번호를 가지고 있다.
 * 2. 갑옷은 두 개의 재료로 만드는데 두 재료의 고유한 번호를 합쳐서 M이 되면 갑옷이 만들어진다.
 * N개의 재료와 M이 주어졌을 때, 몇개의 갑옷을 만들 수 있는지 구해보자. 
 * 
 * 
 * 
 * 조건
 * 재료의 수 N은 1 이상 15000 이하다.
 * 갑옷을 만드는데 필요한 수 M은 1 이상 1천만 이하다.
 * 갑옷은 두 개의 재료로 만들어진다.
 * 
 * 
 * 
 * 아이디어
 * 갑옷은 무조건 두개의 재료로만 이루어지므로
 * 2중 for문을 이용해 첫번째 갑옷과 두번째 갑옷의 합을 구해보자.
 * 갑옷들은 모두 고유한 값을 가지고 있으므로, 
 * 두 갑옷의 합이 M이 된다면, break한다. 
 * 
 */

package Baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class P1940 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 재료의 개수 N을 입력 받는다.
		int N = sc.nextInt();

		// 갑옷을 만드는데 필요한 수 M을 입력 받는다.
		int M = sc.nextInt();

		// 재료들의 고유번호를 저장할 배열을 만든다.
		int[] arr = new int[N];

		// 재료들의 고유번호를 입력 받자.
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// 만들 수 있는 갑옷의수를 세기 위한 변수
		int cnt = 0;

		// 재료는 무조건 2개의 합 이므로 start는 0부터 시작해서 N-1전까지,
		// move는 start+1부터 시작해서 N까지 반복하면 되겠다.
		for (int start = 0; start < N - 1; start++) {
			for (int move = start + 1; move < N; move++) {

				// 두 수의 합이 M 이라면 cnt를 늘려주자.
				// 숫자는 모두 고유한 번호이므로 M값과 같아지는 값을 찾으면 break 하자.
				if (arr[start] + arr[move] == M) {
					cnt++;
					break;
				}

			}
		}

		System.out.println(cnt);

	}
}