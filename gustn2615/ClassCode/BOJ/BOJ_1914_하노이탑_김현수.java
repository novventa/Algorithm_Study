package study_ssafy;

/*
 * 재귀 호출을 통해 문제를 해결한다
 * 
 * 하노이 탑의 점화식을 생각해 본다면 
 * N개의 탑을 1->3 으로 옮기기 위해서는 
 * 1. 가장 밑부분의 원판은 가만히 둔채로 N-1개의 원판을 중간으로 옮겨야한다
 * 2. 이후 가장 밑부분의 원판을 3번으로 옮긴다.
 * 3. 마지막으로 N-1개의 원판을 3번으로 옮기면 된다
 * 즉 A_n=A_(n-1)+1+A_(n-1) => A_n=2A_(n-1)+1 이 되므로
 *    A_n=2^N-1 을 만족하게 된다.
 *    
 *    - 이때 N이 100까지 이므로 BigInteger 함수를 사용한다.
 *    - 하노이 탑이 진행 될때 옮겨지는 위치는 재귀함수를 통해 구현한다.
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class solution_1914_하노이탑_김현수 {

	// 변수 선언
	static int N;

	// 버퍼와 StirngBuilder 정의
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		// 스트링 빌더 정의
		sb = new StringBuilder();

		// 원판의 개수 받아오기
		N = Integer.parseInt(br.readLine().trim());

		// N이 20초과이면 biginteger를 사용해서 값을 구해준다
		if (N > 20) {
			sb.append(new BigInteger("2").pow(N).subtract(BigInteger.ONE));
		}

		// 20이하라면 과정을 나타내준다
		else {

			// 총 움직인 횟수를 구하고
			sb.append((int) Math.pow(2, N) - 1).append("\n");

			// 과정을 구해준다
			hanoi(N, 1, 2, 3);
		}

		// 결과 출력
		System.out.println(sb);
	}

	static void hanoi(int N, int start, int mid, int to) {

		// N이 1이라면 1 -> 3 번으로 옮겨주고 종료한다
		if (N == 1) {
			sb.append(start).append(" ").append(to).append("\n");
			return;
		}

		// 1->3으로 옮긴다고 가정할때
		// 1. 하노이탑 맨위의 N-1개를 시작지점에서 중간지점으로 옮긴다
		hanoi(N - 1, start, to, mid);

		// 2. 1번에 남아있는 맨 아래 블럭을 3 번으로 옮긴다.
		sb.append(start).append(" ").append(to).append("\n");

		// 3. 이제 중간의 N-1개의 탑을 3번으로 옮긴다
		hanoi(N - 1, mid, start, to);
	}

}
