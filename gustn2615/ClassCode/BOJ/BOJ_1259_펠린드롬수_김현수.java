package study_ssafy2;

/*
 * 재귀를 사용해 숫자가 펠린드롬 수인지 확인한다.
 * 재귀 호출을 할때 return값으로 함수를 줄 수 있음을 꼭 기억하자!!
 * 
 * */
import java.util.Scanner;

public class BOJ_1259_펠린드롬수_김현수 {
	static String num;

	public static void main(String[] args) {
		// 스캐너 사용
		Scanner sc = new Scanner(System.in);

		// 계쏙 반복
		while (true) {

			// 숫자를 받아오자
			int tmp = sc.nextInt();

			// 0이면 반복문 종료
			if (tmp == 0) {
				break;
			}

			// 숫자를 문자열로 바꾼다
			num = Integer.toString(tmp);

			// 답을 저장할 문자열
			String answer = "no";

			// 만약 펠린드롬 수라면
			if (isPossible(0, num.length() - 1)) {
				// yes 저장
				answer = "yes";
			}

			// 결과 출력
			System.out.println(answer);
		}

		// 스캐너 종료
		sc.close();
	}

	// 펠린드롬수인지를 확인해주는 메소드
	static boolean isPossible(int start, int end) {

		// 만약 시작 지점 index가 더 커진다면 펠른드롬수가 맞다
		if (start >= end) {
			return true;
		}

		// 만약 앞뒤 숫자가 같다면
		else if (num.charAt(start) == num.charAt(end)) {

			// 다음 숫자를 확인한다
			return isPossible(start + 1, end - 1);
		}

		// 같지않다면 false를 반환한다
		else {
			return false;
		}

	}
}
