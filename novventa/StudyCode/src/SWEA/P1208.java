package SWEA;

import java.util.Scanner;

public class P1208 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스만큼 반복
		for(int T=1; T<11;T++) {
			
			int [] boxes = new int[100];
			int dumpCnt = sc.nextInt();

			// 상자 개수 입력 받기
			for(int i=0; i<100;i++) {
				boxes[i] = sc.nextInt();
			}
			
			// 상자개수를 오름차순으로 정렬
			for(int i=0; i<99;i++) {
				int minIdx = i;
				for(int j=i+1; j<100;j++) {
					if(boxes[j]<boxes[minIdx]) {
						minIdx = j;
					}
				}
				int tmp = boxes[minIdx];
				boxes[minIdx] = boxes[i];
				boxes[i] = tmp;
			}
			
			// 덤프할 수 있는 숫자만큼 반복한다.
			for(int i=0;i<dumpCnt;i++) {
				// 이미 정렬되어있으므로 최소값 +1, 최대값 -1
				boxes[0]++;
				boxes[99]--;
				
				// 다시 오름차순으로 정렬한다.
				for(int j=0; j<99;j++) {
					int minIdx = j;
					for(int k=j+1; k<100;k++) {
						if(boxes[k]<boxes[minIdx]) {
							minIdx = k;
						}
					}
					int tmp = boxes[minIdx];
					boxes[minIdx] = boxes[j];
					boxes[j] = tmp;
				}					
				// 이렇게 반복하면 덤프 카운트가 끝날 때 까지 평탄화를 한다.
			}
			
			// 출력
			System.out.println("#"+T+" "+(boxes[99]-boxes[0]));
		
		}
	}
}
