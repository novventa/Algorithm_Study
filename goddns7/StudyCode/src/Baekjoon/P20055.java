package 백준;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P20055 {
	// 조건
	// 로봇은 올리는 위치(1)에만 올릴 수 있다
	// 로봇은 내리는 위치(N)에서 즉시 내린다
	// 로봇을 올리는 위치에 올리거나 어떤 칸으로 이동하면 해당 칸의 내구도는 1만큼 감소
	// 올리는 위치에 로봇을 올리거나 다른 칸으로 이동하려면 해당 칸의 내구도가 1이상 있어야 한다
	// 내구도=0인 칸의 개수>=K -> 종료
	// 로봇을 내리는 위치
	static int N;
	// 과정이 종료되기 위해 필요한 내구도=0인 칸의 개수
	static int K;
	// 컨베이어 벨트(1~2N)
	static int[] belt;
	// 로봇이 존재하는 위치(1~N)
	static boolean[] robot;
	// 내구성의 개수가 K개를 만족하는지 확인
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 로봇을 내리는 위치
		N = sc.nextInt();
		// 과정이 종료되기 위해 필요한 내구도=0인 칸의 개수
		K = sc.nextInt();

		belt = new int[2 * N]; // 초기화
		robot = new boolean[N]; // 초기화
		// Arrays.fill(robot, true); // true로 초기화(로봇 존재)
		// 내구도 입력
		for (int i = 0; i < 2 * N; i++) {
			belt[i] = sc.nextInt();
		}

		// 단계
		int result = 0;
		// 초기화
		flag = true;
		while (true) {
			// 단계 진행
			result++;
			// 1. 벨트와 로봇 함께 한 칸 회전
			moveBelt();
			// 2. 로봇을 이동시킨다
			// 조건: 이동하려는 칸의 내구도!=0, 로봇 존재x
			// 3. 올리는 위치의 내구도 !=0 -> 로봇 추가(=내구도 -1 감소시킴)
			// ==0 -> 그대로
			moveRobot();

			// 4. 내구도가 0인 칸의 개수가 K개 이상인지 확인
			check();
			// 내구도가 0인 칸의 개수가 K개 이상이면 반복문 종료
			if (!flag) {
				break;
			}
		}
		System.out.println(result);
		sc.close();

	}

	private static void moveRobot() {
		// 마지막은 떨어지므로 false로 만든다
		if (robot[N - 1]) {
			robot[N - 1] = false;
		}
		// 하나씩 뒤로 밀어서 넣는다
		for (int i = N - 2; i >= 0; i--) {
			// 현재 로봇이 있고, 다음에 로봇이 없고, 다음의 내구성이 1이상이면
			if (robot[i + 1] == false && robot[i] == true && belt[i + 1] >= 1) {
				// 현재 로봇을 다음으로 옮겨서
				// 현재는 로봇이 없고
				robot[i] = false;
				// 로봇은 다음으로 옮겨지고
				robot[i + 1] = true;
				// 다음의 내구성은 -1된다
				belt[i + 1] -= 1;
			}
		}
		// 올리는 위치의 내구도 !=0 -> 로봇 추가(=내구도 -1 감소시킴)
		if (robot[0] == false && belt[0] >= 1) {
			robot[0] = true;
			belt[0]--;
		}
	}

	private static void moveBelt() {
		// 복사본
		int copyB = belt[2 * N - 1];

		// 하나씩 뒤로 밀어서 넣는다
		for (int i = 2 * N - 1; i > 0 * N; i--) {
			belt[i] = belt[i - 1];
		}
		// 제일 끝의 값을 앞으로 갖고온다
		belt[0] = copyB;
		// 복사본
		boolean[] copyR = new boolean[N];
		// 복사하기
		for (int i = 0; i < N; i++) {
			copyR[i] = robot[i];
		}

		// 맨 앞은 로봇이 없어진다
		robot[0] = false;
		// 하나씩 뒤로 밀어서 넣는다
		for (int i = 1; i < N - 1; i++) {
			robot[i] = copyR[i - 1];
		}
		return;

//		// 복사본
//		int copyB = belt[2 * N - 1];
//
//		// 하나씩 뒤로 밀어서 넣는다
//		for (int i = 2 * N - 1; i > 0 ; i--) {
//			belt[i] = belt[i - 1];
//		}
//		// 제일 끝의 값을 앞으로 갖고온다
//		belt[0] = copyB;
//
//		for (int i = N - 1; i > 0; i--) {
//			robot[i] = robot[i - 1];
//		}
//		robot[0] = false;
	}

	private static void check() {
		int count = 0;
		for (int i = 0; i < 2 * N; i++) {
			if (belt[i] == 0) {
				count++;
			}
		}
		if (count >= K) {
			flag = false;

		}

		return;
	}
}
