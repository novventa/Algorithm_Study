/* 문제
 * 산성과 알칼리성 용액이 있다.
 * 산성은 1부터 10억까지, 알칼리성은 -1 부터 -10억까지의 정수로 나타낸다.
 * 두 용액의 합이 0에 가장 가깝게 하고싶을 때, 두 용액을 오름차순으로 출력해보자.
 * 
 * 
 * 조건
 * 전체 용액의 수 N은 2 이상 10만 이하다.
 * N개의 용액들의 특성값은 모두 다르다.
 * 
 * 
 * 아이디어
 * 절대값을 기준으로 오름차순으로 정렬 후
 * 나의 앞 뒤와 비교해서 가장 작은 값을 찾아보자.
 * 2차원 배열로 만들고, 뒷부분은 부호로 쓴다.
 * 
 */

package Baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P2470 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N을 입력 받는다.
		int N = Integer.parseInt(br.readLine());

		// 배열의 크기를 정하자.
		long[][] arr = new long[N][2];

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 배열에 값을 입력 받는다.
		for (int i = 0; i < N; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
			// 양수면 1로 저장, 음수면 0으로 저장
			if (arr[i][0] > 0)
				arr[i][1] = 1;
			else
				arr[i][1] = -1;

			// 값을 절대값으로 갱신
			arr[i][0] = Math.abs(arr[i][0]);
		}

		// 오름차순으로 정렬
		Arrays.sort(arr, new Comparator<long[]>() {

			@Override
			public int compare(long[] o1, long[] o2) {
				// TODO Auto-generated method stub
				return (int) (o1[0] - o2[0]);
			}

		});

		long sum = Long.MAX_VALUE;

		// 값 빼낼 때 쓸거다.
		PriorityQueue<Long> pq = new PriorityQueue<>();

		// 자기 앞뒤랑 비교해보자.
		for (int i = 0; i < N - 1; i++) {
			// 자신의 부호와 곱해서, 다음 것과 비교한다.
			// sum보다 작으면 갱신
			long compare = arr[i][0] * arr[i][1] + arr[i + 1][0] * arr[i + 1][1];
			if (Math.abs(compare) < sum) {
				// 값 갱신됐으니 pq 비우고
				pq.clear();
				sum = Math.abs(compare);
				// 다시 추가
				pq.offer(arr[i][0] * arr[i][1]);
				pq.offer(arr[i + 1][0] * arr[i + 1][1]);

			}
		}

		System.out.print(pq.poll() + " " + pq.poll());

	}
}
