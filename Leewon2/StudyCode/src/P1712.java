import java.util.Scanner;

public class P1712 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// n대를 팔 때 수입이 총 비용보다 많아지는 순간을 손익분기점이라 한다.
		// 이를 식으로 표현하면,
		// (A+n*B) - n*C > 0 인 순간을 구하면 된다.
		// 식을 정리하면, A+n(B-C) -> n(B-C)=-A
		// -> n = A/(C-B)가 된다.
		// 이때, 많아지는 순간을 구해야 하기 때문에
		// A/(C-B)에 1을 더한 값을 구해준다.

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		// B가 C보다 크거나 같으면 몇개를 팔아도 손해 이므로 -1 출력
		if (B >= C) {
			System.out.println(-1);
		} else {
			System.out.println(A / (C - B) + 1);
		}
	}

}