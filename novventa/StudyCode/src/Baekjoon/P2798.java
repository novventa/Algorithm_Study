package Baekjoon;

import java.util.Scanner;

public class P2798 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 카드 개수 입력받기
		
		int M = sc.nextInt(); // 목표 숫자 입력받기
		
		int[] cards = new int[N]; // 주어진 카드를 넣을 배열 생성
		
		// 카드 배열 채우기
		for(int i=0;i<N;i++) {
			cards[i] = sc.nextInt();
		}
		
		int maxSum = -1; // 3장의 카드 합이 최대일 때의 변수
		
		int sum = 0; // 3장의 카드 합 변수
		
		// 3장 완전 탐색하기
		for(int i=0;i<N;i++) {
			// 첫번째는 아무거나
			for(int j=0;j<N;j++) {
				// 두번째는 첫번째거 뺴고
				if(j != i) {
					for(int k=0; k<N; k++) {
						// 세번째는 첫번째 두번째거 뺴고
						if((k != i) && (k != j)) {
							// 3개의 수를 더해본다.
							sum = cards[i] + cards[j] + cards[k];
							// 합이 목표값과 같다면 break;
							if(sum == M) {
								maxSum = sum;
								break;
							}
							// 목표값과 같지 않지만
							// 최대합보다 합이 크고, 목표값보다 작다면
							// 최대합을 갱신
							if(sum>maxSum && M>sum)
								maxSum = sum;
						}
					}
				}
			}
		}
		// 출력
		System.out.println(maxSum);
		
	}
}
