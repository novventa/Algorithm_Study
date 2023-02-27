package day0216;

import java.util.Scanner;

public class P10158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 격자공간의 가로의 길이
		int xUp = sc.nextInt();
		// 격자공간의 세로의 길이
		int yUp = sc.nextInt();
		// 초기 위치의 x 좌표값
		int x = sc.nextInt();
		// 초기 위치의 y 좌표값
		int y = sc.nextInt();
		// 개미가 움직일 시간 t
		int time = sc.nextInt();

		// 시간을 똑같이 복사해둔다
		int timeCopy = time;

		// !개미가 움직일 때의 X좌표와 Y좌표를 따로 생각한다

		// t시간 후의 개미의 위치 x좌표
		int resultX = 0;
		// 개미가 끝으로 가기위해 움직여야 하는 거리보다 개미가 움직이는 시간이 더 적다면
		if (time <= xUp - x) {
			// t시간 후의 개미의 위치 좌표는 현재 개미의 위치 + 시간이다.
			resultX = x + time;
			// 개미가 끝으로 가기위해 움직여야 하는 거리보다 개미가 움직이는 시간이 더 많다면
		} else {
			// 주어진 시간에서 개미가 먼저 끝으로 가기 위한 시간(거리와 정비례)을 뺴준다
			time -= xUp - x;
			// 1. 빼주고 남은 시간을 격자 공간의 가로 길이로 나눈 나머지가 홀수라면
			// 즉, 오른쪽방향으로 이동하고 있다면
			if ((time / xUp) % 2 != 0) {
				// t시간 후의 개미의 위치 좌표는 시간을 격자 공간의 가로 길이로 나눈 나머지이다.
				// 나머지는 시간을 가로의 길이만큼 움직이고 오른쪽 방향으로 남은 나머지만큼 이동하는 거리이기 때문이다.
				resultX = time % xUp;
			// 2. 빼주고 남은 시간을 격자 공간의 가로 길이로 나눈 나머지가 짝수라면
			// 즉, 왼쪽방향으로 이동하고 있다면
			} else {
				// 1.의 경우와 다르게 왼쪽방향으로 이동하기 때문에 전체 가로 길이에서 가는 만큼 빼줘야 
				// 개미의 현재 x좌표 값을 구할 수 있다.
				resultX = xUp - (time % xUp);
			}
		}

		// (x와 마찬가지로 진행)
		// t시간 후의 개미의 위치 y좌표
		int resultY = 0;
		if (timeCopy <= yUp - y) {
			resultY = y + timeCopy;
		} else {
			timeCopy -= yUp - y;
			if ((timeCopy / yUp) % 2 != 0) {
				resultY = timeCopy % yUp;
			} else {
				resultY = yUp - (timeCopy % yUp);
			}
		}

		System.out.println(resultX + " " + resultY);

		sc.close();
	}

}