package day0216;

import java.util.Scanner;

public class P8958 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 테스트 케이스의 개수
		int testCase = sc.nextInt();
		// 테스트 케이스의 개수만큼 문자열 받기
		String[] a = new String[testCase];

		for (int i = 0; i < testCase; i++) {
			a[i] = sc.next();
		}

		for (int i = 0; i < a.length; i++) {

			int count = 0;
			// 총 count의 합
			int sum = 0;

			for (int j = 0; j < a[i].length(); j++) {
				// O이 나오면 count를 세고
				if (a[i].charAt(j) == 'O') {
					count++;
					// X이 나오면 count를 0으로 초기화 시킨다
				} else if (a[i].charAt(j) == 'X') {
					count = 0;
				}
				// count 값을 계속 더해준다
				sum += count;
			}
			System.out.println(sum);
		}

	}
}