package study_ssafy;

/*
 * 위에서 아래쪽으로 내려갈 때 2칸을 내려가야지만 선택지가 2가지가 된다
 * 예를 들어 6층짜리 계단에서 2층을 내려가면 4층이고 
 * 이때 4층에서 아래로 갈 수 있는 경우의 수가 2가지 이다.
 * 
 * 하지만 6층짜리 계단에서 1층을 내려가면 5층이고 
 * 이때 5층에서 선택할 수 있는 경우의 수는 오직 3층으로 가는 1가지 뿐이다.
 * 
 * DP의 경우 선택지가 정해진 것은 값이 정해져 있으므로 따로 확인할 필요가 없고
 * 선택지가 두가지인 경우의 K에 대해서만 그 값을 결정해주면 된다.
 * 
 * 따라서 DP[K]를 구하려면 아래 두가지 선택지 뿐이다
 * 1. DP[K-2]+stair[k] 
 * 2. DP[K-3]+stair[k-1]+stair[k] 
 * 		=> DP[K-3]인 이유는 DP[K]의 입장에서 K-1번째 계단을 선택하면
 * 		   이미 K-3번째로 내려가야한다. 따라서 DP[K-3]을 선택해주어야한다
 * 
 * 
 * */
import java.util.Scanner;

public class solution_2579_계단오르기_김현수 {
	static int[] stair;
	static int[] stairSum;
	static int N;

	public static void main(String[] args) {
		
		// 스캐너 사용
		Scanner sc = new Scanner(System.in);
		
		// 계단 수 받아오기
		N = sc.nextInt();
		
		// 계단에 숫자를 채워줄 배열
		stair = new int[N + 1];
		
		// 계단 합의 최대값을 저장해줄 DP배열
		stairSum = new int[N + 1];
		
		// 계단에 숫자를 채워준다
		for (int i = 1; i <= N; i++) {
			stair[i] = sc.nextInt();
		}
		// 스캐너를 종료한다
		sc.close();
		
		// 1,2층 계단의 합은 정해져있으므로 넣어준다
		stairSum[1]=stair[1];
		if (N>=2) {
			stairSum[2]=stair[1]+stair[2];
		}
			
		
		// 3층부터는 DP를 사용한다
		for(int i=3;i<=N;i++) {
			stairSum[i]=Math.max(stairSum[i-2], stairSum[i-3]+stair[i-1])+stair[i];
		}
		
		// 결과 출력
		System.out.println(stairSum[N]);

	}

}
