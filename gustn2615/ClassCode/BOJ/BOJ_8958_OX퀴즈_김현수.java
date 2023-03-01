package study_ssafy;

/*
 * 조건문을 사용해서 
 * 1. O일시 점수를 올리면서 더해주고
 * 2. X일 경우 점수를 초기화 해주는 형식으로 문제를 푼다
 * 
 * */
import java.util.Scanner;

public class solution_8958_OX퀴즈_김현수 {
	public static void main(String[] args) {

		// 스캐너 사용
		Scanner sc = new Scanner(System.in);

		// 케이스 횟수 받아오기
		int T = sc.nextInt();

		// 케이스 횟수만큼 반복
		for (int tc = 0; tc < T; tc++) {

			// 총 점수 변수
			int totalScore = 0;

			// 문제를 맞았을 경우 해당 index의 점수를 나타낼 변수
			int score = 0;

			// OX를 문자배열로 저장
			char[] OX = sc.next().toCharArray();

			// 문자배열 길이만큼 반복하면서
			for (int i = 0; i < OX.length; i++) {

				// 만약 O라면 점수를 올리고
				// 총 점수에 더한다
				if (OX[i] == 'O') {
					score++;
					totalScore += score;
				}

				// X라면 점수를 초기화한다.
				else {
					score = 0;
				}
			}

			// 총 점수 출력
			System.out.println(totalScore);
		}

		// 스캐너 사용종료
		sc.close();
	}
}
