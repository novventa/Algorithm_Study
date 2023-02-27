package day0216;

import java.util.Scanner;

public class P14696 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 총 라운드 수
		int round = sc.nextInt();

		// 라운드 반복
		for (int i = 0; i < round; i++) {

			// A가 내는 딱지 속 그림의 총 개수
			int cntA = sc.nextInt();
			// A가 내는 딱지 속 그림의 종류
			int[] pictureA = new int[cntA];
			for (int j = 0; j < cntA; j++) {
				pictureA[j] = sc.nextInt();
			}

			// A가 갖는 해당 그림의 개수
			int countA4 = 0; // 별
			int countA3 = 0; // 동그라미
			int countA2 = 0; // 네모
			int countA1 = 0; // 세모

			for (int j = 0; j < cntA; j++) {
				// 별 그림이 나오면
				if (pictureA[j] == 4) {
					// count 증가시키기
					countA4++;
					// 동그라미 그림이 나오면
				} else if (pictureA[j] == 3) {
					// count 증가시키기
					countA3++;
					// 네모 그림이 나오면
				} else if (pictureA[j] == 2) {
					// count 증가시키기
					countA2++;
					// 세모 그림이 나오면
				} else if (pictureA[j] == 1) {
					// count 증가시키기
					countA1++;
				}
			}

			// B가 내는 딱지 속 그림의 총 개수
			int cntB = sc.nextInt();
			// A가 내는 딱지 속 그림의 종류
			int[] pictureB = new int[cntB];

			for (int j = 0; j < cntB; j++) {
				pictureB[j] = sc.nextInt();
			}

			// B가 갖는 해당 그림의 개수
			int countB4 = 0; // 별
			int countB3 = 0; // 동그라미
			int countB2 = 0; // 네모
			int countB1 = 0; // 세모

			for (int j = 0; j < cntB; j++) {
				// 별 그림이 나오면
				if (pictureB[j] == 4) {
					// count 증가시키기
					countB4++;
					// 동그라미 그림이 나오면
				} else if (pictureB[j] == 3) {
					// count 증가시키기
					countB3++;
					// 네모 그림이 나오면
				} else if (pictureB[j] == 2) {
					// count 증가시키기
					countB2++;
					// 세모 그림이 나오면
				} else if (pictureB[j] == 1) {
					// count 증가시키기
					countB1++;
				}
			}
			// 우선순위(별>동그라미>네모>세모)대로 많은게 순위가 높다
			// 별의 개수가 많은 것이 출력됨
			if (countA4 > countB4) {
				System.out.println('A');
			} else if (countA4 < countB4) {
				System.out.println('B');
				// 별의 개수 같을 때
			} else {
				// 동그라미 개수가 많은 것이 출력됨
				if (countA3 > countB3) {
					System.out.println('A');
				} else if (countA3 < countB3) {
					System.out.println('B');
					// 동그라미 개수가 같을 때
				} else {
					// 네모 개수가 많은 것이 출력됨
					if (countA2 > countB2) {
						System.out.println('A');
					} else if (countA2 < countB2) {
						System.out.println('B');
						// 네모 개수가 같을 때
					} else {
						// 세모 개수가 많은 것이 출력됨
						if (countA1 > countB1) {
							System.out.println('A');
						} else if (countA1 < countB1) {
							System.out.println('B');
							// 세모의 개수까지 같으면 무승부 출력
						} else {
							System.out.println('D');
						}
					}
				}
			}

		}

		sc.close();
	}
}
