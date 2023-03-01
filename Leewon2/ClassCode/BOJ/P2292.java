import java.util.Scanner;

public class P2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// n을 입력 받는다.
		int n = sc.nextInt();
		// 숫자들의 합을 저장해놀 변수를 선언한다.
		int sum = 1;

		// 반복문을 이용하여 문제를 해결해보자.
		// 반복문의 범위는 크게 잡는다.
		for (int i = 1; i < 100000; i++) {
			// n이 1일땐,
			if (n == 1) {
				// 1을 출력하고 반복문을 빠져나온다.
				System.out.println(1);
				break;
			}
			// sum에 6*i를 한 뒤
			sum += 6 * i;
			// n이 sum보다 작다면
			if (n <= sum) {
				// i+1을 출력한 후, 반복문을 빠져나온다.
				System.out.println(i + 1);
				break;
			}

		}
	}
}
