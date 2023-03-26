import java.util.Scanner;


/**
 * @author jhye.byun
 * SWEA 1217 거듭 제곱 D3 분할정복
 * 
 * 문제
 * N, M이 주어질 때, N의 M 거듭제곱을 구하자.
 * 
 * 조건
 * 10개의 데스트 케이스
 * 결과 값은 Integer범위를 넘어가지 않는다.
 * 
 * 풀이
 * 1. M+1 크기의 배열을 만들어서
 * 2. 각 칸에 N의 (해당 칸 인덱스) 거듭제곱 값을 저장하자.
 */

public class SWEA_1217_거듭제곱_변지혜 {
	
	static int[] memo; 
	
	private static int pow(int num, int power) {
		// num의 power 제곱을 구하는 method
		// 실행시간 절약을 위해 이미 구했던 제곱값은 memo 배열에 저장해놓고 사용하자
		
		// 0제곱일 때는 1을 반환하자
		if (power == 0) {
			memo[power] = 1;
		}
		
		// 이미 구한 값이 있으면 
		if (memo[power] != 0) return memo[power];
		
		// M이 짝수라면
		if (power % 2 == 0)
			// N의 M/2제곱을 두 번 구해서 곱해주자
			memo[power] = pow(num, power / 2) * pow(num, power / 2);
		// M이 홀수라면
		else
			// N의 M/2제곱을 두 번 구해서 곱해준 값에 N을 한 번 더 곱해주자
			memo[power] = num * pow(num, power / 2) * pow(num, power / 2);
			
		return memo[power];
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int testCase = 10; // 테스트케이스 10개
		
		for (int tc = 1; tc <= testCase; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int tcNum = sc.nextInt();
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			memo = new int[M + 1]; // 0~M제곱 까지의 결과값을 저장할 memo배열
			
			sb.append(pow(N, M)).append("\n");
		}
		System.out.println(sb);
	}

}
