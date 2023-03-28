package 백준;
import java.util.Scanner;

public class P9095 {
	//1,2,3의 합으로 나타내는 방법의 수
	static int total = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 테스트케이스의 수
		int testCase = sc.nextInt();

		for (int tc = 1; tc <= testCase; tc++) {
			// 입력 받는 수
			int n = sc.nextInt();
			//해당 메소드의 반환값을 total의 값으로 지정
			total=dp(n);
			
			System.out.println(total);
		}

		sc.close();
	}

	private static int dp(int num) {
		//1 => 1
		if (num == 1) {
			return 1;
		//2 => 1+1 / 2
		} else if (num == 2) {
			return 2;
		//3 => 1+1+1 / 2+1 / 1+2 / 3
		} else if (num == 3) {
			return 4;
		//4부터는 그 전의 3단계를 다 더한 값이다
		} else {
			return dp(num - 1) + dp(num - 2) + dp(num - 3);
		}
	}

}