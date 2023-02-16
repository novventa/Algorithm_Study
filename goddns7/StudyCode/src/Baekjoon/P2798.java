package day0213;

import java.util.Scanner;

public class P2798 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 3가지 수를 뽑고, 그 수들의 총 합을 구한 뒤,
		// 정해진 범위 안에 해당 되는 것들 중 가장 큰 값을 찾으려고한다.

		// 카드의 개수
		int card = sc.nextInt();
		// 넘으면 안되는 수
		int limit = sc.nextInt();

		// 카드의 값이 들어가는 배열
		int[] arr = new int[card];

		// 배열에 카드 값 대입
		for (int i = 0; i < card; i++) {
			arr[i] = sc.nextInt();
		}

		// 3개의 값의 합들을 모아 놓은 배열
		int[] sum = new int[1000000];

		// sum의 배열에서 서로 다른 세 가지를 뽑아 더한 값을 sum 배열의 원소로 넣는다.
		int s = 0;
		// 모든 원소 중 하나를 택
		for (int i = 0; i < card; i++) {
			// 모든 원소 중 하나를 택
			for (int j = 0; j < card; j++) {
				// i와 다른 원소를 택했다면
				if (j != i) {
					// 모든 원소 중 하나를 또 택
					for (int k = 0; k < card; k++) {
						// i와 j와 다른 원소를 택했다면
						if (k != i && k != j) {
							// 서로 다른 원소를 택하고 총 합을 구해 sum의 배열의 원소의 값으로 넣는다.
							sum[s++] = arr[i] + arr[j] + arr[k];
						}
					}
				}
			}
		}

		// M을 넘지 않는 값만 모아 최대값을 찾는다.
		int max = 0;
		for (int q = 0; q < 1000000; q++) {
			// M을 넘지 않는 값이고
			if (sum[q] <= limit) {
				// max보다 크다면
				if (sum[q] > max) {
					// 그 값은 max의 값이 된다.
					max = sum[q];
				}
			}
		}

		System.out.println(max);

		sc.close();
	}
}



