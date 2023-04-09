package study_ssafy;

/*
 * 백트래킹을 사용해서 푼다
 * 
 * 1. 숫자를 모두 문자열로 바꾼다.
 * 2. 백트래킹을 사용해 나올 수 있는 모든 경우의 수를 만들어본다
 * 3. 최솟값을 구한다
 * */
import java.util.Scanner;

public class solution_2992_크면서작은수_김현수 {
	static int num;
	static int size, min;
	static boolean[] isUsed;

	public static void main(String[] args) {

		// 스캐너 사용
		Scanner sc = new Scanner(System.in);

		// 숫자 받아오기
		num = sc.nextInt();

		// 스캐너 종료
		sc.close();

		// 숫자를 문자열로 받아온다
		String tmp = Integer.toString(num);

		// 문자열 크기를 변수 정의
		size = tmp.length();

		// 최솟값을 저장할 변수
		min = Integer.MAX_VALUE;

		// 방문했는지 확인하는 논리형
		isUsed = new boolean[size];

		// 백트래킹
		backtracking(0, 0);

		// 결과 출력
		System.out.println(min == Integer.MAX_VALUE ? 0 : min);
	}

	// 백트래킹 메소드
	static void backtracking(int k, int sum) {

		// 다 뽑았다면
		if (k == size) {

			// 만약 기존 숫자보다 크면
			if (sum > num) {

				// 기존 숫자보다 큰 수들 중 가장 작은값을 구한다
				if (min > sum) {
					min = sum;
				}
			}

			// 메소드를 종료한다
			return;
		}

		// 백트래킹 메소드
		for (int i = 0; i < size; i++) {

			// 숫자를 뽑아준다
			if (!isUsed[i]) {

				// 사용 했다고 표시
				isUsed[i] = true;

				// 합 변수에 k번째 자리수를 더해준다
				sum += Math.pow(10, k) * (Integer.toString(num).charAt(i) - '0');

				// k+1번째 숫자를 뽑기위해 호출
				backtracking(k + 1, sum);

				// 합 변수에서 k번째 자리수를 뺀다
				sum -= Math.pow(10, k) * (Integer.toString(num).charAt(i) - '0');

				// 사용한했다고 표시
				isUsed[i] = false;
			}
		}
	}
}
