/* 문제
 * 정수 n이 주어졌을 때, n을 1,2,3의 합으로 나타내는 방법의 수를 구해보자.
 * 
 * 
 * 조건
 * n은 0 이상 11 이하다.
 * 
 * 
 * 문제 풀이 방법
 * 중복순열을 이용해 풀어보자.
 * 
 */

package Baekjun;

import java.util.Scanner;

public class P9095 {

	// 1,2,3을 이용해 만드므로, arr에 1,2,3을 저장해 놓자.
	static int[] arr = { 1, 2, 3 };

	// 결괏값을 저장할 배열을 만들자.
	static int[] result;

	// 결괏값 배열의 합을 저장할 변수를 만들자.
	static int sum;

	// 입력받는 숫자
	static int num;

	// 1,2,3의 합으로 나타낼 수 있다면 카운트 해줄 변수를 만들자.
	static int cnt;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 수를 입력 받자.
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			// 숫자를 입력 받자.

			// sum, cnt는 0으로 초기화 한다.
			sum = 0;
			cnt = 0;

			// 숫자를 입력 받자.
			num = sc.nextInt();

			// 결과값으 저장할 배열의 크기를 num 크기만큼한다.
			// 예를 들어 num이 10인 경우, 최솟값 1로 10을 만들려면
			// 1이 10개가 필요하다. 그 다음 조합부터는 10개를 초과하지 않으므로
			// 배열의 크기를 num으로 지정한다.
			result = new int[num];

			// 반복문을 이용해 1개부터 num개 까지의 조합을 뽑아보자.
			for (int j = 1; j <= result.length; j++) {

				// 재귀함수 호출
				perm(j, 0);
			}
			System.out.println(cnt);
		}
	}

	public static void perm(int choose, int idx) {
		// 기저조건
		// choose개 뽑았다면 확인해보자.
		if (idx == choose) {

			// 결괏값을 저장한 배열에 있는 요소들의 합을 구한다.
			for (int i = 0; i < result.length; i++) {
				sum += result[i];
			}

			// 그 합이 num과 같다면 cnt를 늘려주자.
			if (sum == num)
				cnt++;

			// 사용했으니, sum은 0으로 초기화 시키자.
			sum = 0;

			// 나를 호출한 녀석으로 돌아가자.
			return;
		}

		// 재귀조건
		// 중복순열을 짜보자.
		for (int i = 0; i < arr.length; i++) {
			result[idx] = arr[i];
			perm(choose, idx + 1);
		}
	}
}
