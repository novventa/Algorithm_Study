// 문제 조건
// N명의 사람은 3 이상 50 이하인 자연수이다.
// 공을 받는 횟수 M은 50 이하인 자연수이다.
// L번째 있는 사람은 N-1 이하인 자연수이다.

// 문제 풀이 방법
// 1번부터 시작하므로 m번 받는 사람은 무조건 1번이다.
// 한 사람이 공을 받은 횟수가 홀수이면 시계방향으로,
// 짝수이면 반시계 방향으로 공을 던지지만, 이건 사실 의미가 없다.

// N명의 사람 중 L번째 사람에게 공을 던져 다시 1번으로 돌아오기까지
// 공을 던지는 횟수를 n번 이라고 한다면,
// n은 N을 N과 L의 최대공약수로 나눈 수 이다. n = N/(N과L의 최대공약수)
// 즉, N을 최대 공약수로 나눈 횟수만큼 공을 던지면 다시 1번으로 돌아간다. 

// 첫번째 사람이 공을 쥐고 시작하므로 n*(m-1)을 한다.

import java.util.Scanner;

public class P1592 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 사람의 수, 공을 받을 횟수 m,
		// 어디로 공을 던질지 정하는 변수를 입력 받는다.
		int peopleCnt = sc.nextInt();
		int mCnt = sc.nextInt();
		int L = sc.nextInt();

		// 최대공약수를 구해보자
		int big = 0;
		// L은 항상 peopleCnt보다 작기 때문에 L이 작은수가 된다.
		// 작은수를 기준으로 반복하자
		for (int i = 1; i <= L; i++) {
			// 사람의 수와 L을 나누었을때 모두 나머지가 없다면
			if (peopleCnt % i == 0 && L % i == 0) {
				// 최대공약수에 저장한다.
				// i값이 커지면서 big 값이 갱신되기 때문에
				// 다른 변수를 이용해 최댓값을 찾을 필요가 없다.
				big = i;
			}
		}
		// peopleCnt를 최대 공약수로 나눈 값과
		// mCnt-1 값을 곱해주자.
		System.out.println((peopleCnt / big) * (mCnt - 1));
	}

}
