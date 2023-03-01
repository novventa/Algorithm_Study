// 문제 조건
// 사람의 수 N은 1 이상 1000 이하다.
// 돈을 인출하는데 걸리는 시간 p는 1 이상 1000 이하다.
// 각 사람이 돈을 인출하는데 걸리는 시간이 주어졌을 때,
// 돈을 인출하는데 필요한 시간이 최소가 되도록 하자.

// 문제 해결 방법
// 인출하는데 걸리는 시간이 누적해서 더해진다.
// 작은 숫자부터 더해가면 되므로 오름차순으로 정렬 후 문제를 해결하자.

// 1. 사람의 수 N과 N개의 숫자를 입력 받는다.
// 2. N개의 숫자를 정렬한다.
// 3. Pi까지의 합을 저장하는 변수와, P1 부터 Pi까지의 합을 저장하는 변수를 만들자.
// 4. 정렬된 N개의 숫자를 순차적으로 더한다.
// 5. 순차적으로 더한 수를 cnt에, cnt들의 합을 sum 변수에 저장하자.

import java.util.Arrays;
import java.util.Scanner;

public class P1244 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 사람의 수를 입력 받는다.
		int peopleCnt = sc.nextInt();

		// 사람의 수 크기의 배열을 만든다.
		int[] arr = new int[peopleCnt];

		// peopleCnt 만큼의 숫자를 입력 받고 배열에 저장하자.
		for (int idx = 0; idx < peopleCnt; idx++) {
			arr[idx] = sc.nextInt();
		}

		// 배열을 정렬하자.
		Arrays.sort(arr);

		// Pi까지의 합을 저장할 변수 cnt를 선언한다
		int cnt = 0;

		// cnt의 합을 저장할 변수 sum을 선언한다.
		int sum = 0;

		for (int idx = 0; idx < arr.length; idx++) {

			// idx번째 사람이 돈을 인출하는데 걸리는 시간
			cnt += arr[idx];

			// idx번째 까지 돈을 인출하는데 걸린 시간
			sum += cnt;
		}

		System.out.println(sum);
	}

}
