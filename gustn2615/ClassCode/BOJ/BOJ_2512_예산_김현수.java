package study_ssafy2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2512_예산_김현수 {

	static int cityNum, totalBudget, sum, answer;
	static int[] cityBudget;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		// 지방의수
		cityNum = Integer.parseInt(br.readLine().trim());
		cityBudget = new int[cityNum];

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < cityNum; i++) {
			cityBudget[i] = Integer.parseInt(st.nextToken());
		}

		// 전체 예산
		totalBudget = Integer.parseInt(br.readLine().trim());

		// 이분탐색을 위해 정렬
		Arrays.sort(cityBudget);

		// 정답을 저장할 변수
		answer = 0;

		// 최저 예산과, 최고 가능한 예산으로 이분 탐색을 진행
		binarySearch(0, cityBudget[cityNum - 1]);

		// 결과출력
		System.out.println(answer);

	}

	static void binarySearch(int minBudget, int maxBudget) {

		// 최저예산이 최대 예산을 넘지 않을 때 까지만 진행
		while (minBudget <= maxBudget) {

			// 예산의 합을 저장할 변수
			sum = 0;

			// 현재 예산을 저장할 변수
			int nowBudget = (minBudget + maxBudget) / 2;

			// 전체 배열을 돌면서
			for (int i : cityBudget) {

				// 현재 예산보다 작다면 모든 예산 지불
				if (i < nowBudget) {
					sum += i;
				}

				// 현재 예산보다 많다면 현재 예산만 지불
				else {
					sum += nowBudget;
				}
			}

			// 전체 예산을 초과하면
			if (sum > totalBudget) {
				// 최대예산을 현재예산보다 1을 줄인다.
				maxBudget = nowBudget - 1;
			}

			// 전체 예산 보다 작다면
			else {

				// 최저 예산에서 1을 더하고
				minBudget = nowBudget + 1;

				// 예산의 최대값을 저장한다
				answer = Math.max(nowBudget, answer);
			}
		}

	}
}
