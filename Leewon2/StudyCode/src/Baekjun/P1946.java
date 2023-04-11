/* 문제
 * 신규 사원 채용을 진행하는데, 인재 선발은 1차 서류심사와 2차 면접시험으로 이루어져 있다.
 * 다른 모든 지원자와 비교했을 때, 1차와 2차 시험 중 적어도 하나가 다른 지원자보다 떨어지지 않는
 * 지원자만 선발한다. 즉, A의 1,2차 성적이 B의 1,2차 성적보다 모두 떨어진다면, A는 선발되지 않는다.
 * 이러한 조건을 만족하면서, 신규 사원 채용에서 선발될 수 있는 신입사원의 최대 인원을 구해보자.
 * 
 * 
 * 조건
 * 테스트 케이스 T는 1 이상 20 이하다.
 * 지원자의 수 N은 1 이상 10만 이하다.
 * 1차, 2차 심사 모두 1위부터 N위까지 동석차는 존재하지 않는다.
 * 
 * 
 * 
 * 아이디어
 * 1차 심사를 기준으로 오름차순으로 정렬해보자.
 * 1차 심사의 1등은 고려대상이 아니다.
 * 1차 심사의 2등은 1차 심사의 1등보다 2차 심사의 등수가 높다면 선발 될 수 있다.
 * 마찬가지로 3등은, 1,2등의 2차심사와 비교한다.
 * 오름차순으로 정렬했으므로, 다음 수는 무조건 위의 값들보다 무조건 크므로,
 * 위의 값들과 2차 심사만 비교하면된다.
 * 위의 값들 중 2차 심사가 가장 작은 값을 min으로 저장해 둔 다음
 * 그 수 보다 크면 포함시키지 않고, 작다면 포함시키고 min 값을 갱신해보자. 
 * 
 * 
 * 
 */
package Baekjun;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P1946 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// testcase를 입력 받는다.
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {

			// 지원자 수 N을 입력 받는다.
			int N = sc.nextInt();

			// N명의 1차,2차 심사 등수를 저장해야 하므로 N*2 크기로 배열을 만들자.
			int[][] arr = new int[N][2];

			boolean[] noMoreCheck = new boolean[N];

			// 1차 심사와 2차 심사를 입력 받아보자.
			for (int row = 0; row < N; row++) {
				arr[row][0] = sc.nextInt();
				arr[row][1] = sc.nextInt();
			}

			// 1차 심사를 기준으로 오름차순으로 정렬해보자.
			Arrays.sort(arr, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o1[0] - o2[0];
				}

			});

			// 선발할 수 있는 신입사원의 수를 저장할 변수를 만들자.
			// 배열의 첫번째는 1등이므로 무조건 배열에 포함된다.
			int cnt = 1;

			// 1등의 2차심사 점수를 min 값으로 저장해둔다.
			int min = arr[0][1];

			// i는 1부터 N까지 반복하는 반복문을 만들어보자.
			for (int i = 1; i < N; i++) {
				// i번째의 2차 등수가 min보다 작다면, 갱신 후 cnt를 늘려보자.
				if (arr[i][1] < min) {
					min = arr[i][1];
					cnt++;
				}
			}

			System.out.println(cnt);
		}

	}
}