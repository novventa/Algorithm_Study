package study_ssafy;

/*
 * 초반에 에라토스테네스의 체를 사용해 문제를 풀었습니다
 * 하지만 int형이 10억개의 크기를 가져야해서 메모리가 부족한 현상이 있었습니다
 * 하여 구글링을 통해 좀 더 효율적인 방법을 찾아 보았습니다
 * 
 * 1. 전체 숫자를 배열에 받아온 후
 * 2. 가로수간의 거리 차이들을 구한 후
 * 3. 그 거리 차이들의 최대 공약수를 구하면 그 공약수 가 가로수들의 최대 거리가 된다.
 * 4. 따라서 최대공약수를 통해 가로수의 전체 개수를 구할 수 있다.
 * 
 * */
import java.util.Scanner;

public class solution_2485_가로수_김현수 {

	// 전역변수로 설정
	static int N;
	static int[] nums;

	public static void main(String[] args) {
		// 스캐너 사용
		Scanner sc = new Scanner(System.in);

		// 가로수 개수 받아오기
		N = sc.nextInt();

		// 가로수 위치를 넣을 배열 정의
		nums = new int[N];

		// 가로수 위치를 배열에 담기
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}

		// 스캐너 종료
		sc.close();

		// 최대공약수를 담을 변수
		int gcd = 0;

		// 가로수의 거리차이를 구하기 위해 반복문 사용
		for (int i = 1; i < N; i++) {
			// 내앞의 가로수와의 거리차이를 변수로 저장
			int distance = nums[i] - nums[i - 1];

			// 여태까지 구한 최대공약수와 거리를 사용해서 두수의 최대공약수를 구한다
			gcd = GCD(distance, gcd);
		}

		// 결과 출력
		// 전체 가로수의 개수 = ((마지막 가로수의 거리)-(첫번째 가로수의 거리))/(최대 공약수) + 1
		System.out.println((nums[N - 1] - nums[0]) / gcd + 1 - N);
	}

	// 최대공약수 메소드
	static int GCD(int a, int b) {

		// 만약 b가 0이라면
		// a가 최대공약수이다.
		if (b == 0) {
			return a;
		}
		// 만약 b가 0이아니라면
		// a%b가 0일때 까지 자기 자신 메소드 호출
		else {
			return GCD(b, a % b);
		}
	}
}
