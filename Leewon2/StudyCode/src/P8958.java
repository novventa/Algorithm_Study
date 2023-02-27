// 문제 조건
// 길이가 0보다 크고 80보다 작은 문자열이 주어진다.
// 문자열은 O와 X만으로 이루어져 있다.

// 문제 해결 방법
// 1. 테스트 케이스를 입력 받는다.
// 2. 테스트 케이스 동안 주어지는 문자열을 입력 받는다.
// 3. 주어지는 문자열을 char 배열로 저장한다.
// 4. O가 나오면 cnt에 1을 더하고 sum에 더한다..
// 5. X가 나오면 cnt를 0으로 초기화 시킨다.
// 6. sum을 출력한다.

import java.util.Scanner;

public class P8958 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 테스트 케이스를 입력 받는다.
		int tc = sc.nextInt();

		for (int idx = 0; idx < tc; idx++) {
			// O가 연속적으로 나왔을 때 값을 저장하는 변수를 만들어보자.
			int cnt = 0;

			// 점수를 저장할 변수를 만들자.
			int sum = 0;

			// 문자열을 입력 받자.
			String str = sc.next();
			// toCharArray를 이용해 str을 char 배열로 바꿔보자.
			char[] s = str.toCharArray();

			// 배열의 길이만큼 반복해보자.
			for (int i = 0; i < s.length; i++) {
				// 배열의 i번째 요소가 O라면
				// cnt에 1을 더한 후 sum에 더해보자.
				if (s[i] == 'O')
					sum += ++cnt;
				// 배열의 i번째 요소가 X인 경우
				else
					// cnt를 0으로 초기화 시킨다.
					cnt = 0;

			}
			// 점수를 출력해보자.
			System.out.println(sum);
		}

	}
}
