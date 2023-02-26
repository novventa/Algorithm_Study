package day0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

		// 스위치 개수
		int switchNum = Integer.parseInt(sc.readLine());
		// 스위치 상태 배열
		int[] switchState = new int[switchNum];
		
		String[] line = sc.readLine().split(" ");

		for (int i = 0; i < switchNum; i++) {
			switchState[i] = Integer.parseInt(line[i]);
		}

		// 학생 수
		int studentNum = Integer.parseInt(sc.readLine());

		// 학생의 성별, 학생이 받은 수
		int[][] student = new int[studentNum][2];

		for (int i = 0; i < studentNum; i++) {
			line = sc.readLine().split(" ");

			for (int j = 0; j < 2; j++) {
				student[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		for (int i = 0; i < studentNum; i++) {
			// 남학생의 경우
			if (student[i][0] == 1) {
				// 해당 번호의 배수의 스위치 번호들이 반대의 값이 나올 수 있도록
				int b = 1;
				while (student[i][1] * b - 1 < switchNum) {
					// 반대로 출력
					switchState[student[i][1] * b - 1] = switchState[student[i][1] * b - 1] == 0 ? 1 : 0;

					b++;
				}
			} else {
				// 여학생의 경우
				if (student[i][1] == 1 || student[i][1] == switchNum) {
				//좌우대칭이 아닌 경우
					switchState[student[i][1] - 1] = switchState[student[i][1] - 1] == 0 ? 1 : 0;
					
				} else {
				//좌우대칭인 경우
					switchState[student[i][1] - 1] = switchState[student[i][1] - 1] == 0 ? 1 : 0;
					// 움직이는 정도
					int g = 1;
					while (true) {
						//범위 안에 있을 때
						if (student[i][1] + g - 1 < switchNum && student[i][1] - g - 1 > -1) {
							//좌우대칭이면
							if (switchState[student[i][1] + g - 1] == switchState[student[i][1] - g - 1]) {
								//반대의 값으로 바꿈
								switchState[student[i][1] + g - 1] = switchState[student[i][1] + g - 1] == 0 ? 1 : 0;
								switchState[student[i][1] - g - 1] = switchState[student[i][1] - g - 1] == 0 ? 1 : 0;
								g++;
							}
							//좌우대칭이 아니면
							else {
								break;
							}
						//범위 안에 없을 때
						} else {
							break;
						}

					}
				}
			}
		}
		//20단위로 출력
		for (int s = 0; s < switchNum; s++) {
			System.out.print(switchState[s] + " ");
			if ((s + 1) % 20 == 0) {
				System.out.println();
			}
		}

		sc.close();

	}
}
