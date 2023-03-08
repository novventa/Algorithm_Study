import java.util.Arrays;
import java.util.Scanner;

// 문제
// 길이가 N인 정수 배열 A와 B가 있다.
// S = A[0]*B[0] + .... A[N-1] * B[N-1]이라고 정의할 때,
// S 값을 가장 작게 만들어 본다.

// 문제 조건
// 길이 N은 50 이하인 자연수이다.
// A와 B의 각 원소는 0이상 100 이하인 정수다.

// 문제 해결 방법
// 배열 원소의 곱이 최솟값이 되려면, 최대값*최소값 + 최대값-1 * 최소값+1 ... 순으로 만들어야 하므로
// 배열 A는 오름차순으로, 배열 B는 내림차순으로 정렬 후 각 원소들을 곱한 후 더해보자.
// 1. N을 입력 받고 N크기의 배열 2개를 만든다.
// 2. N크기의 배열 2개에 값을 입력 받는다.
// 3. A는 오름차순으로 정렬하고, B는 내림차순으로 정렬한다.
// 4. 각 원소들을 곱한 후 더한다.
// 5. 출력

public class P1026 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 1. n을 입력 받는다.
		int n = sc.nextInt();

		// 2. n크기의 배열 A와 B를 만든다.
		int[] A = new int[n];
		int[] B = new int[n];

		// A와 B 배열에 값을 입력 받는다.
		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			B[i] = sc.nextInt();
		}

		// 3. A는 Arrays.sort 함수를 이용해 오름차순으로 정렬한다.
		Arrays.sort(A);

		// 4. B는 버블정렬을 이용하여 내림차순으로 정렬한다.
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (B[i] > B[j]) {
					int temp = B[i];
					B[i] = B[j];
					B[j] = temp;
				}

			}
		}

		// 각 원소들의 곱을 더해 저장해줄 변수를 만든다.
		int sum = 0;

		// 각 원소들의 곱을 sum에 더하자.
		for (int i = 0; i < n; i++) {
			sum += A[i] * B[i];
		}

		// 5. 출력
		System.out.println(sum);

	}
}
