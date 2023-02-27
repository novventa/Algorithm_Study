package day0216;

import java.util.Scanner;

public class P13300 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 참가하는 학생 수
		int num = sc.nextInt();
		// 한 방에 배정할 수 있는 최대 인원 수
		int maxNum = sc.nextInt();

		// col: 여, 남 row: 학년
		int[][] student = new int[6][2];

		for (int i = 0; i < num; i++) {
			// 학생의 성별(여 : 0, 남 : 1)
			int gender = sc.nextInt();
			// 학생의 학년
			int grade = sc.nextInt();

			student[grade - 1][gender]++;
		}

		// 필요한 방의 수
		int roomNum = 0;
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 2; col++) {
				// 모든 학생의 배열 중 한명이라도 있다면
				while (student[row][col] > 0) {
					// 학생들의 수가 최대 배정 인원수보다 적거나 같을 때
					if (student[row][col] > 0 && student[row][col] <= maxNum) {
						// 필요한 방의 수 +1 해준다
						roomNum++;
						// 또, 방에 들어간 인원들은 모두 지워준다.
						student[row][col] = 0;
						// 학생들의 수가 최대 배정 인원수보다 많다면
					} else if (student[row][col] > maxNum) {
						// 가능한 최대한으로 배정시키고 남은 인원들만 남긴다
						// (남은 인원들은 while반복문을 통해 처리)
						student[row][col] -= maxNum;
						// 일단 배정시킨 방의 수를 세어주기 위해 +1 한다.
						roomNum++;
					}
				}
			}
		}

		System.out.println(roomNum);

		sc.close();
	}
}
