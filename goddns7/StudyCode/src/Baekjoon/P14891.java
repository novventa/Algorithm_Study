package 백준;

import java.util.Arrays;
import java.util.Scanner;

public class P14891 {
	// N극 :0, S극: 1
	// 왼쪽 톱니바퀴의 3번톱니는 오른쪽 톱니바퀴의 7번톱니와 맞닿아있다
	// -맞닿은 톱니가 같은 극이면 회전x
	// -맞닿은 톱니가 다른 극이면 서로 다른 방향으로 회전

	static int[][] gear = new int[4][8]; // 톱니바퀴

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int j = 0; j < 4; j++) {
			// 한 줄을 입력받고 숫자를 하나로 쪼개고
			String[] line = sc.nextLine().split("");
			// 톱니바퀴 배열에 값 입력
			for (int i = 0; i < 8; i++) {
				gear[j][i] = Integer.parseInt(line[i]);
			}
		}

		// 회전 횟수
		int rotateNum = sc.nextInt();

		// 주어진 회전 횟수만큼 회전을 진행
		for (int i = 0; i < rotateNum; i++) {

			// 회전시킨 톱니바퀴의 번호
			int rotatedGearNum = sc.nextInt();
			// 회전 방향(1:시계, -1:반시계)
			int rotateDirection = sc.nextInt();

			int now = rotatedGearNum - 1;

			int copyDirection = rotateDirection;
			int[] copyGear = new int[8];
			int copyNow = now;

			for (int j = 0; j < 8; j++) {
				copyGear[j] = gear[now][j];
			}

			// 해당 톱니바퀴 먼저 회전시킨다
			if (rotateDirection == 1) {
				clockwise(now);
			} else {
				counterclockwise(now);
			}

			// 해당 톱니바퀴의 오른쪽 톱니바퀴들 확인
			while (now < 3 && now >= 0) {

				int compare = gear[now + 1][2];
				// 다른 극이면
				if (copyGear[2] != gear[now + 1][6]) {
					if (rotateDirection == -1) {
						clockwise(now + 1); // 시계방향으로 회전
					} else {

						counterclockwise(now + 1); // 반시계방향으로 회전
					}
					// 같은 극이면 반복문 종료
				} else {
					break;
				}
				now++;
				rotateDirection = -rotateDirection;
				copyGear[2] = compare;
			}
			now = copyNow;
			rotateDirection = copyDirection;
			// 해당 톱니바퀴의 왼쪽 톱니바퀴들 확인
			while (now <= 3 && now >= 1) {

				int compare = gear[now - 1][6];
				// 다른 극이면
				if (copyGear[6] != gear[now - 1][2]) {
					if (rotateDirection == -1) {
						clockwise(now - 1); // 시계방향으로 회전
					} else {
						counterclockwise(now - 1); // 반시계방향으로 회전
					}
					// 같은 극이면 반복문 종료
				} else {
					break;
				}
				now--;
				rotateDirection = -rotateDirection;
				copyGear[6] = compare;
			}

			System.out.println(Arrays.deepToString(gear));
		}
		// 네 톱니바퀴의 점수의 합
		int score = 0;

		for (int i = 0; i < 4; i++) {
			if (gear[i][0] == 1) {
				score += Math.pow(2, i);
			}
		}
		System.out.println(score);
		sc.close();

	}

	// 시계 방향으로 회전
	public static void clockwise(int gearNum1) {
		// 복사본 생성
		int[] copy = new int[8];
		// 복사하기
		for (int i = 0; i < 8; i++) {
			copy[i] = gear[gearNum1][i];
		}
		// 맨 뒤의 값을 맨 앞으로 옮기고
		gear[gearNum1][0] = copy[7];
		// 나머지 값들은 한칸씩 뒤로 밀어서 입력
		for (int i = 1; i < 8; i++) {
			gear[gearNum1][i] = copy[i - 1];
		}

	}

	// 반시계 방향으로 회전
	public static void counterclockwise(int gearNum2) {
		// 복사본 생성
		int[] copy = new int[8];
		// 복사하기
		for (int i = 0; i < 8; i++) {
			copy[i] = gear[gearNum2][i];
		}
		// 맨 앞의 값을 맨 뒤로 옮기고
		gear[gearNum2][7] = copy[0];
		// 나머지 값들은 한칸씩 앞으로로 밀어서 입력
		for (int i = 0; i < 7; i++) {
			gear[gearNum2][i] = copy[i + 1];
		}
	}
}
