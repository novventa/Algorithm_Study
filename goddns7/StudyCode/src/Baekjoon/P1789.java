package 백준;

import java.util.Scanner;

public class P1789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1~어떤 수까지의 합이 sum보다 a만큼 커질 때
		// 1~어떤 수까지의 합 - a = sum 이다
		// 즉, 1~어떤 수의 개수 - 1(a에 해당하는 수) 만큼의 수들을 더해주면 된다는 의미

		long sum = sc.nextLong();
		long total = 0;
		long result = 0;
		for (long i = 1; ; i++) {
			if (total > sum) {
				break;
			}
			total += i;
			result++;
		}

		System.out.println(result - 1);

		sc.close();
	}
}




