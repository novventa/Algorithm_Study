package day0308;

import java.util.Scanner;

public class P2579 {
	// 계단의 수
	static int stairsNum;
	// 계단의 점수 정보를 갖고 있는 배열
	static int[] stairs;

	// 해당 계단의 최고 점수를 갖고 있는 배열
	static int[] stairMax;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 계단의 수
		stairsNum = sc.nextInt();

		// 계단의 점수 정보를 갖고 있는 배열
		stairs = new int[stairsNum];

		// 해당 계단에서의 최대 점
		stairMax = new int[stairsNum];
		// 각 계단의 점수를 입력한다
		for (int i = 0; i < stairsNum; i++) {
			stairs[i] = sc.nextInt();
		}

		// 최고층까지 한 층마다 최대 값을 정한다
		for (int i = 0; i < stairsNum; i++) {
			// 자기 층 하나만 더해준다(선택지x)
			if (i == 0) {
				stairMax[0] = stairs[0];
				// 1층과 2층만 더해준다(선택지x)
			} else if (i == 1) {
				stairMax[1] = stairs[0] + stairs[1];
				// 3층의 경우 1층+3층과 2층+3층을 비교해서 더 큰 값이 최대값이다.
			} else if (i == 2) {
				stairMax[i] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
				// 4층부터는 (자기 층 -2)층 에서 두 칸 뛰고 올라오는 경우와 (자기 층 - 3)층에서 2층 뛰고 자기 층에 도달하는 경우 두 가지를
				// 비교해야 한다.
			} else if (i >= 3) {
				if (stairMax[i - 3] + stairs[i - 1] + stairs[i] > stairMax[i - 2] + stairs[i]) {
					stairMax[i] = stairMax[i - 3] + stairs[i - 1] + stairs[i];
				} else {
					stairMax[i] = stairMax[i - 2] + stairs[i];
				}

			}
		}

		System.out.println(stairMax[stairsNum - 1]);
		sc.close();
	}

}




