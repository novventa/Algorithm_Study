package 백준;

import java.util.Scanner;

public class P1057 {
	// 참가자 수
	static int participantNum;
	// 참가자 수들의 배열
	static int[] participant;
	// 김지민 번호
	static int kimNum;
	// 임한수 번호
	static int limNum;
	// 라운드 횟수
	static int count;

	public static void main(String[] args) {
		//한 라운드를 진행할 때마다 다음 라운드에서의 본인 번호는
		//짝수의 경우 /2를 한 값이, 홀수의 경우 +1을 하고 /2를 한 값이다
		//그리고 두 명의 참가자는 다음 라운드의 번호가 같아질 때 대결하게 된다.
		//그래서 /2 또는 +1 이후 /2를 하여 값이 같아질 때까지 값을 구한다
		Scanner sc = new Scanner(System.in);

		// 참가자 수
		participantNum = sc.nextInt();
		// 참가자 수들의 배열
		participant = new int[participantNum];
		// 김지민 번호
		kimNum = sc.nextInt();
		// 임한수 번호
		limNum = sc.nextInt();
		// 0부터 시작
		count = 0;
		// 둘의 번호가 같아질 때까지 반복
		while (kimNum != limNum) {
			// 짝수라면
			if (kimNum % 2 == 0) {
				// 2로 나눈 값
				kimNum /= 2;
			// 홀수라면
			} else {
				// 1을 더해서 2로 나눈 값
				kimNum = (kimNum + 1) / 2;
			}
			// 짝수라면
			if (limNum % 2 == 0) {
				// 2로 나눈 값
				limNum /= 2;
			// 홀수라면
			} else {
				// 1을 더해서 2로 나눈 값
				limNum = (limNum + 1) / 2;
			}
			// 라운드 한번 진행
			count++;
		}
		System.out.println(count);
		sc.close();
	}

}