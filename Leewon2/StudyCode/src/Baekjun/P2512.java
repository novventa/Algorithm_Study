/* 문제
 * 국가의 예산을 분배하고자 한다.
 * 1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정한다.
 * 2. 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정한다. 
 * 상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정한다. 
 * 여러 지방의 예산요청과 국가예산의 총액이 주어졌을 때, 위의 조건을 모두 만족하도록 예산을 배정해보자.
 * 
 * 
 * 조건
 * 지방의 수 N은 3 이상 1만 이하의 자연수이다.
 * N개의 예산 요청 금액은 각각 1 잇아 10만 이하의 자연수이다.
 * 총 예산은 N이상 10억 이하의 자연수이다.
 * 
 * 
 * 아이디어
 * 상한액보다 큰 금액은 모두 상한액을 지급하므로, 상한액보다 큰 금액은 상한액이 될 수 없다.
 * N개의 수를 오름차순으로 정렬한다.
 * 정렬 후 가운데 값을 확인해보자.
 * 가운데 값 보다 작은 값들은 그 값들을 더하고, 나머지 값들은 상한액을 더한다.
 * 모두 더한 후, 예산과 비교해보자.
 * 모두 더한 값이 예산보다 크다면, 상한액은 처음에 구한 값 보다 왼쪽에 있다는 것이고
 * 모두 더한 값이 예산보다 작다면, 상한액은 처음에 구한 값 보다 오른쪽에 있다는 것이다.
 * 예산보다 큰 경우는 left값을 mid+1로, 작은 경우는 right값을 mid로 정하자.
 * left가 right보다 커지는 순간까지 반복해보자.
 * 
 */

package Baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2512 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 지방의 수 N을 입력 받자.
		int N = Integer.parseInt(br.readLine());

		// 지방의 예산들을 담을 배열을 만들자.
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 배열에 값을 입력 받자.
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 총 예산을 입력 받자.
		int M = Integer.parseInt(br.readLine());

		// 오름차순으로 정렬한다.
		Arrays.sort(arr);

		// 왼쪽엔 0을, 오른쪽엔 배열의 가장 마지막 값을 저장한다.
		int left = 0;
		int right = arr[N - 1];

		// 왼쪽이 오른쪽보다 커지는 순간까지 반복할거다.
		while (left <= right) {
			// 가운데 값을 구해보자.
			// 여기서 가운데 값은 임의의 상한액을 의미한다.
			int mid = (left + right) / 2;

			// 예산들의 합을 더해줄 변수를 만들자.
			long sum = 0;

			// 반복문을 이용하여, sum 값을 구해보자.
			// 상한액보다 큰 금액은 상한액이 되므로, math.min 메서드를 이용해보자.
			for (int i = 0; i < N; i++) {
				sum += Math.min(arr[i], mid);
			}

			// 예산들의 합을 구했다.
			// 예산들의 합이 M보다 큰 경우
			if (sum > M) {
				// 오른쪽 값을 mid-1로 한다.
				// mid로 하면, left가 right보다 작아지지 않고, 같아지는게 최대가 된다.
				right = mid - 1;
			}
			// 예산들의 합이 M보다 작은 경우
			else {
				// 위와 같은 이유
				left = mid + 1;
			}
		}

		System.out.println(right);

	}
}
