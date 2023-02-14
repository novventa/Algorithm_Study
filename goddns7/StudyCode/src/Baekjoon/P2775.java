package day0213;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//아래처럼 진행되기 때문에 전 층에서 원하는 호수까지 다 더해줘야 한다.
//		0층 - 1 2 3 
//		1층 - 1 3(1+2) 6(1+2+3)
//		2층 - 1 4(1+3) 10(1+3+6)
//		3층 - 1 5(1+4) 15(1+4+10)
		Scanner sc = new Scanner(System.in);

		// 테스트케이스
		int testCase = sc.nextInt();

		for (int t = 0; t < testCase; t++) {
			// k층
			int k = sc.nextInt();
			// n호
			int n = sc.nextInt();

			// 0층부터 k층까지, 1호부터 n호까지
			int[][] arr = new int[k + 1][n];
			
			//0층의 경우 1, 2, 3...으로 증가하므로 아래의 식 대입
			for (int i = 0; i < n; i++) {
				arr[0][i] = i + 1;
			}

			// 전 층의 1호부터 현재까지의 호수까지 모든 거주민의 수를 합하면 현재 층의 현재 호수에 거주하는 사람의 인원

			// 1층 이상의 경우

			//f: 층, j: f층에서의 호수, i: f-1층에서의 호수
			for(int f = 1; f<=k; f++) {
				for (int j = 0; j < n; j++) {
					for (int i = 0; i <= j; i++) {
						//f-1층에서의 0부터 j까지의 호수 인원을 모두 합한다 = > f층에서 j호수의 인원
						arr[f][j] += arr[f - 1][i];
					}
				}
			}
			//호수의 경우 1호부터 시작하기 때문에 n호수는 n-1의 호수로 대입해야한다
			System.out.println(arr[k][n - 1]);
		}
		sc.close();

	}
}













