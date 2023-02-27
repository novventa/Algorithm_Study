package day0216;

import java.util.Scanner;

public class P8320 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();

		// 총 직사각형의 개수
		int sum = 0;

		//직사각형 변의 길이가 될 수 있는 경우는 직사각형 개수의 약수들이다.
		for (int i = 1; i <= num; i++) {
			// 홀수의 경우 만들 수 있는 직사각형은 1개뿐(제곱 수 제외)
			if (i == 1) {
				sum += 1;
			// 짝수의 경우 만들 수 있는 직사각형의 경우
			} else {
				int n = 1;
				int limit = i;
				while (n < limit) {

					// 1부터 하나씩 증가하면서 i와 나눠서 나머지가 0이면 직사각형 한 변의 길이가 될 수 있다
					if (i % n == 0) {
						sum += 1;
						// 가로 세로의 길이가 중복되지 않도록 지정(회전의 경우)
						limit = i / n;
					}
					n++;
				}
			}

		}

		System.out.println(sum);
		sc.close();

	}
}