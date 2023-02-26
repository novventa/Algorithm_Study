package SWEA;

import java.util.Scanner;

public class P1859 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 입력받기
		int T = sc.nextInt();
		// 테스트 케이스만큼 반복
		for(int tc=1;tc<T+1;tc++) {
			// 일 수 입력받기
			int N = sc.nextInt();
			// 일 수 만큼 비용을 저장할 배열 생성
			int[] cost = new int[N];
			// 배열에 비용 저장
			for(int i=0;i<N;i++) {
				cost[i] = sc.nextInt();
			}
			// 답으로 출력할 이익
			long profit = 0;
			// 뒤에서부터 탐색한다.
			// 앞의 날의 매매가가 현재 매매가보다 작으면 비용을 계속 더해간다.
			// 매매가가 커지면 계속 더해준 비용을 이익에 더해준다.
			// 앞에서 사기 위해 쓴 비용은 빼준다.
			// i가 파는 날, j가 사는 날
			for(int i=N-1;i>=0;i--) {
				// 사는 날이 파는 날보다 하루 전
				int j = i - 1;
				// 임시로 저장할 사거나 파는데 드는 총 비용
				int tmpCost = 0;
				// 사는 날의 비용이 파는 날의 비용보다 클 동안
				while(j>=0 && cost[i]>cost[j]) {
					// 판매한 비용은 더하고
					tmpCost += cost[i];
					// 구매한 비용은 뺴준다.
					tmpCost -= cost[j];
					// 일자 옮기기
					j--;
				}
				// 비용 더해주기
				profit += tmpCost;
				// 일자 옮기기
				i=j+1;
			}
			// 출력
			System.out.println("#"+tc+" "+profit);
		}
	}
}
