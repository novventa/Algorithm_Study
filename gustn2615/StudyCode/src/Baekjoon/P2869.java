package Baekjoon;

import java.util.Scanner;

public class P2869 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 스캐너로 세개의 수 입력받기
		int up = sc.nextInt();
		int down = sc.nextInt();
		int height = sc.nextInt();

		// 만약 V만큼 다 올라갔다면 그날 밤에 내려오지는 않으므로
		// A x day - B x (day-1) >= V 가되는 day를 찾으면 된다.
		int day = ((height - down) / (up - down));
		// 이때 양쪽 수식이 같아지면 즉 왼쪽식이 높이와 같으면
		// day값만 출력한다.
		if (((height - down) % (up - down)) == 0) {
			System.out.println(day);
		} 
		// 왼쪽 수식이 더 커지게 되면 int형은 버림이 되므로
		// day의 값에 1을 더한 후 출력한다.
		else {
			System.out.println(((height - down) / (up - down)) + 1);
		}

	}
}