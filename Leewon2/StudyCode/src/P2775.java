import java.util.Scanner;

// 문제 조건
// 1<=층수(k), 호수(n)<=14
// 비어있는 집은 없고 0층 1호부터 시작하는데, 
// 0층의 i호에는 i명이 산다. 즉, 1호에는 1명, 2호에는 2명 .. i호에는 i명이 산다.
// a층의 b호에 살려면, a-1층의 1호부터 b호까지 사람들의 수의 합 만큼 데려와 살아야 한다.
// 예를 들어, 1층의 3호에 살기 위해서는,
// 0층의 1호 + 2호 + 3호 = 6명이 살아야 한다.

// 문제 해결 방법
// 층수를 i, 호수를 j로 생각했을 때,
// i번째 층수의 j번째 호수의 사람 수는,
// i-1번째 층수의 1호부터 j호수에 사는 사람의 합이다.
// 1. 테스트 케이스를 입력 받고, 테스트 케이스동안 반복하며
// 층수(k)와 호수(n)을 입력 받는다.
// 2. 0층의 정보를 저장한다.
// 3. 반복문을 이용하여 값을 저장한다.

public class P2775 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 1-1. 테스트 케이스를 입력 받는다.
		int tc = sc.nextInt();

		// 1-2. 테스트 케이스 동안 반복하며
		for (int idx = 0; idx < tc; idx++) {
			// 층수와 호수에 대한 정보를 입력 받는다.
			int floor = sc.nextInt();
			int number = sc.nextInt();

			// 층수를 행, 호수를 열로 생각하고 배열의 크기를 정한다.
			// 층수는 0층부터 시작하기 때문에 구하고자 하는 층수가 2층 이라면,
			// 3행을 만들어야 하므로, floor+1크기의 배열로 만든다.
			int[][] arr = new int[floor + 1][number];

			// 0층의 정보를 배열에 저장한다.
			for (int i = 0; i < number; i++) {
				arr[0][i] = i + 1;
			}

			// 3중 for문을 이용해 배열의 값을 채운다.
			// 0층의 값은 채웠기 때문에 1층부터 시작한다.
			// 마찬가지로 3행을 만들어야 하므로, 범위를 floor+1로 설정한다.
			for (int flo = 1; flo < floor + 1; flo++) {
				for (int num = 0; num < number; num++) {
					int sum = 0;

					// 다음은 호수를 구하기 위한 식으로,
					// 이전 층수의 호수의 합을 구한 후, 배열의 값으로 저장한다.
					for (int value = 0; value < num + 1; value++) {
						sum += arr[flo - 1][value];
					}
					arr[flo][num] = sum;
				}
			}

			// floor층 number 호수에 있는 사람의 수를 출력해보자.
			System.out.println(arr[floor][number - 1]);

		}

	}

}
