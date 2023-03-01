// 문제 조건
// 직사각형을 만들 때 정사각형을 변형시키거나,
// 한 정사각형 위에 다른 정사각형을 놓을 수 없다.
// 직사각형은 길이가 1인 정사각형으로 꽉 차있어야 한다.
// n개의 정사각형의 범위는 1 이상 10,000 이하다.

// 문제 해결 방법
// 1. n을 입력받자.
// 규칙
// 2. 약수의 갯수 /2 한 값을 sum에 더한다.
// 3. 약수의 갯수 /2가 소숫점이 경우 올림을 한다.

// 4. 2중 for문을 이용하여, 첫번째 for문에서 i는 1부터 n까지 반복하고
// 두번째 for문은 1부터 i까지 반복한다.
// 5. 약수의 갯수를 구하고, 올림하는 함수인 ceil을 이용하여
// Math.ceil(약수의 갯수/2)한 값을 sum에 더하자.
// 6. sum을 출력해보자.

import java.util.Scanner;

public class P8320 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// n개의 숫자를 입력 받자.
		int n = sc.nextInt();

		// 만들수 있는 사각형의 갯수를 저장하기 위한 변수를 만들자.
		double sum = 0;

		// 첫번째 반복문은 1부터 n까지 반복해보자.
		for (double i = 1; i <= n; i++) {
			// 약수의 갯수를 더할 변수를 만든다.
			double cnt = 0;
			// 두번째 반복문은 1부터 i까지 반복해보자.
			for (double j = 1; j <= i; j++) {
				// i를 j로 나누었을 때 나누어 떨어진다면
				// j는 i의 약수이므로 cnt에 1을 더해보자.
				if (i % j == 0) {
					cnt++;
				}
			}
			// 두번째 반복문이 끝나면 약수의 갯수/2를 올림해서 sum에 더해보자.
			sum += Math.ceil(cnt / 2);
		}
		// int로 형변환을 한 후 sum을 출력해보자.
		System.out.println((int) sum);

	}
}
