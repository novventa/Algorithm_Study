package study_ssafy2;

/*
 * DP를 사용해서 문제를 해결한다
 * 
 * 1. DP[N+1][K+1]인 이차원 배열을 만든다.
 * 2. 이때 N=1일 때 DP의 값은 주어진 K의 값과 같다
 *    즉, DP[1][1]=1  DP[1][2]=2 DP[1][3]=3
 * 3. 그 외에는 DP[N][K]=DP[N-1][K]+DP[N][K-1] 을 만족한다
 * 
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2225_합분해_김현수 {
	static int N, K;
	static long[][] dp;

	public static void main(String[] args) throws IOException {

		// 버퍼리더 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		// 정수 N과 정수 N을 만들 숫자의 개수 K받아오기
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 버퍼 사용 종료
		br.close();

		// dp 배열 만들기
		dp = new long[N + 1][K + 1];

		// 전체를 돌면서
		for (int row = 1; row < N + 1; row++) {
			for (int col = 1; col < K + 1; col++) {
				// N=1일때는 K값과 같으므로 넣어주고
				if (row == 1) {
					dp[row][col] = col;
				}

				// N이 1이 아닐때는 점화식을 넣어준다
				// 이때 10억으로 나눈 나머지 값을 넣어준다.
				// 마지막 답을 구할 때 나누어주면 LONG값을 넘어가기 때문에 계산이 되지 않는다
				else {
					dp[row][col] = (dp[row - 1][col] + dp[row][col - 1]) % 1000000000;
				}
			}
		}

//		for (long[] arr : dp)
//			System.out.println(Arrays.toString(arr));

		// 결과출력
		System.out.println(dp[N][K]);

	}
}
