
package study_ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solution_2292_벌집 {
	public static void main(String[] args) throws IOException {
		// 버퍼 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 찾을 번호 받아오기
		int N = Integer.parseInt(br.readLine());
		// 벌집의 규칙은 등비 수열이므로 등비수열의 합을 구하면 된다.
		// 등비수열의 항번호와 등비수열의 합을 담을 변수를 정의한다.
		int i = 0;
		int sum = 0;
		// 1. 반복문을 돌린다.
		while (true) {
			// 항을 1늘리고
			i++;
			// 우선 등비 수열이지만 등비수열 합으로 구하지 않을 것이다.
			// 1 6 12 이런식으로 늘어나면서 이것들의 6으로 나눈 몫을 구해보면
			// 1 1 2 3 4 이런식으로 늘어나기 때문에
			// 첫번째 항만 빼면 공차가 1인 등차수열이므로 등차수열의 합을 구한다.
			sum = i * (i + 1) / 2;
			// 이후 등차수열의 합에 6을 곱하고 첫번째 항인 1을 더해준다.
			sum = (sum * 6 + 1);
			// 2. 이때 등비수열의 합이 구하는 수보다 크면 반복문을 빠져나온다.
			if (sum >= N) {
				break;
			}
		}
		// 만약 N이 1이면 1을 출력한다.
		if (N==1) {
			System.out.println(1);
		}
		// 그외의 경우에는 i+1을 출력해준다.
		else {
			System.out.println(i + 1);
		}
		
	}
}
