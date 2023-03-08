
// 계단 오르기 게임은 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임이다.
// 각각의 계단에는 일정한 점수가 쓰여 있는데 계단을 밟으면 그 계단에 쓰여 있는 점수를 얻게 된다.
// 계단 오르는 데는 다음과 같은 규칙이 있다.
// 1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
// 2. 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
// 3. 마지막 도착 계단은 반드시 밟아야 한다.
// 따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다. 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.
// 각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.

package Baekjun;

import java.util.Scanner;

public class P2579 {
 
	static Integer dp[]; // 계단 점수의 최대값을 저장할 배열 dp를 선언한다. 
	static int arr[]; // 계단의 점수를 입력할 배열 arr를 선언한다.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 계단의 수 N을 입력 받는다.
		
		dp = new Integer[N + 1]; // dp와
		arr = new int[N + 1]; // arr 배열을 크기 N+1로 생성한다.
		
		for(int idx = 1; idx <= N; idx++) { // arr 배열에 계단의 점수를 입력 받는다.
			arr[idx] = sc.nextInt();
		}
		
		dp[0] = arr[0];	// 디폴트값이 null이므로 0으로 초기화 해주어야한다.
		dp[1] = arr[1]; // dp[1] = arr[1]로 대입한다.
		
		if(N >= 2) {
			dp[2] = arr[1] + arr[2]; // N이 2인 경우 dp[N]을 arr[1] + arr[2]로 따로 설정한다.
		}
		
		System.out.println(find(N)); // find 메서드에 매개변수 N일 때의 값을 출력한다. 
		
	}
	
	static int find(int N) {
		// 아직 탐색하지 않는 N번째 계단일 경우
		if(dp[N] == null) {
			dp[N] = Math.max(find(N - 2), find(N - 3) + arr[N - 1]) + arr[N]; 
		} // 규칙성에 따라서 N-2 번째 계단 점수의 최대값과 N-1 번째 계단의 점수와 N-3 번째 계단의 점수의 최대값의 합을 비교해 큰 값을 dp[N] 배열에 저장한다. 
		
		return dp[N]; // dp를 반환한다.
	}
	
}
