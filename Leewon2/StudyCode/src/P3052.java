import java.util.Scanner;

// 문제 조건
// 첫째 줄 부터 열번째 줄 까지 숫자가 한 줄에 하나씩 주어진다.
// 숫자는 1000보다 작거나 같고, 음수가 아닌 정수다.

// 문제 해결 방법
// 1. 10개의 정수를 입력 받고
// 2. 42크기의 배열을 만들어보자.
// 3. 10개의 정수를 42로 나누고, 나머지를 42크기의 배열의 인덱스에 저장해보자.
// 4. 인덱스의 크기가 0이라면 conintue를 하고,
// 5. 인덱스의 크기가 1이상 이라면 cnt를 하나씩 늘려보자.
// 6. cnt를 출력해보자.

public class P3052 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 42로 나누었을 때 나머지가 42는 안된다.
		// 0부터 41까지 필요하므로 42 크기로 배열을 만들자.
		int[] arr = new int[42];

		// 10개의 정수를 입력 받자.
		for (int i = 0; i < 10; i++) {

			int num = sc.nextInt();

			// num을 42로 나눈 나머지 값을 배열의 인덱스로 사용하고 1을 더해보자.
			arr[num % 42]++;

		}
		// 1이상인 숫자를 셀 변수
		int cnt = 0;

		// 0부터 41까지 반복하면서 숫자가 1 이상이라면 cnt를 늘려보자.
		for (int i = 0; i <= 41; i++) {
			// 배열의 i번째 요소가 0이 아니라면 cnt를 늘려보자.
			if (arr[i] != 0)
				cnt++;
		}

		// cnt를 출력하자
		System.out.println(cnt);

	}
}
