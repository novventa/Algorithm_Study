package day0216;

import java.util.Scanner;

public class P2839 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 배달해야 하는 킬로그램 수
		int N = sc.nextInt();
		// 봉지의 최소 개수
		int count = 0;

		while (N > 0) {
			// 5로 나눠지지 않으면 그 다음 최선책인 3봉투로 옮기는 것을 생각해서
			// count++해주고, N-3을 해준다
			if (N % 5 != 0) {
				N -= 3;
				count++;
				// 5로 나눠지면 가장 적은 봉지의 수를 가질 수 있는 경우라 바로 결과 출력
			} else if (N % 5 == 0) {
				count += N / 5;
				break;
			}
		}

		// N이 음수면 5와 3으로 나눠지지 않는 경우이기 때문에 -1을 출력
		if (N < 0) {
			count = -1;
		}

		System.out.println(count);

		sc.close();
	}
}
