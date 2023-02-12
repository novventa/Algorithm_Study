package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solution_10870_피보나치 {
	public static void main(String[] args) throws IOException {
		// 버퍼리더로 입력값을 받는다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 피보나치 수열의 몇번째를 받을건지 구한다.
		int N = Integer.parseInt(br.readLine());
		// 숫자를 읽어왔으므로 종료한다.
		br.close();
		// 피보나치 수열을 담을 배열을 정의한다.
		// N번째 피보나치 수열을 찾으려면 배열의 사이즈는 N+1이다
		int[] arr = new int[N + 1];

		// 피보나치 수열을 담는다
		for (int i = 0; i < N + 1; i++) {
			arr[i] = Fibonacci(i);
		}
		// 피보나치 수열의 배열을 확인해보면
		// 11개의 피보나치 수열이 담겨있다.
//		System.out.println(Arrays.toString(arr));

		// N-1과 N-1값을 알고있으므로 N번째 값을 구할 수 있다.
		System.out.println(arr[N]);
	}

	public static int Fibonacci(int N) {
		// 0번째는 0
		if (N == 0) {
			return 0;
		}
		// 1번째는 1
		if (N == 1) {
			return 1;
		}
		// 그 이후는 이전의 두개값을 더한다.
		else {
			return Fibonacci(N - 1) + Fibonacci(N - 2);
		}
	}
}
