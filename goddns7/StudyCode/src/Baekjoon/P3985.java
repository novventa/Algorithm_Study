package day0216;

import java.util.Scanner;

public class P3985 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 롤 케이크의 길이
		int cakeLength = sc.nextInt();
		// 롤 케이크의 배열
		int[] cake = new int[cakeLength];
		// 방청객의 수
		int num = sc.nextInt();

		// 가장 많이 받을 거라고 예상되는 사람의 번호
		int expectNum = 0;
		// 예상되는 케이크의 크기
		int expectCake = 0;
		// 예상되는 가장 많이 받는 케이크 크기
		int maxexpectCake = 0;

		for (int i = 1; i <= num; i++) {

			// 방청객이 원하는 조각의 수1,2
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();

			// 케이크에 해당 방청객 번호 작성
			for (int j = num1; j <= num2; j++) {
				// 해당 케이크를 받은 사람이 없다면
				// = 해당 케이크에 방청객 번호가 적혀 있지 않다면
				if (cake[j - 1] == 0) {
					// 해당 케이크에 방청객 번호를 작성한다
					cake[j - 1] = i;
				}
			}
			// 예상되는 케이크는 해당 방청객 번호가 원하는 케이크의 범위의 크기
			expectCake = num2 - num1 + 1;
			// 예상되는 가장 많이 받는 케이크 크기 찾기
			if (maxexpectCake < expectCake) {
				maxexpectCake = expectCake;
				// 예상되는 가장 많이 받는 케이크가 정해질 때의 방청객 번호
				expectNum = i;
				// 가장 많은 조각을 받도록 예상되는 방청객이 또 있다면
			} else if (maxexpectCake == expectCake) {
				// 번호가 작은 사람의 번호를 출력
				if (expectNum > i) {
					expectNum = i;
				}
			}
		}
		// 가장 많이 받는 케이크의 수
		int max = 0;
		// 방청객의 번호
		int numP = 1;
		// 실제로 가장 많은 조각을 받은 방청객의 번호
		int maxNum = 0;

		while (numP <= num) {
			// 해당 방청객이 받는 실제 케이크의 수
			int count = 0;
			for (int i = 0; i < cakeLength; i++) {
				// 케이크의 번호 값이 해당 방청객의 번호와 같다면
				if (cake[i] == numP) {
					// count를 센다
					count++;
				}
			}
			// 가장 많이 받는 케이크의 조각 수 구하기
			if (max < count) {
				max = count;
				// 가장 많이 받을 때의 방청객의 번호
				maxNum = numP;
				// 가장 많이 받는 방청객이 여러명이면
			} else if (max == count) {
				// 번호가 작은 사람을 출력
				if (maxNum > numP) {
					maxNum = numP;
				}
			}
			// 방청객 1번부터 모두 검열하기 위해 +1씩 증가시킴
			numP++;
		}
		System.out.println(expectNum);
		System.out.println(maxNum);
		sc.close();
	}
}
