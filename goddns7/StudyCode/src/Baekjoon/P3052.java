package day0216;

import java.util.Scanner;

public class P3052 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 값을 입력받을 배열
		int[] arr = new int[10];
		// 값을 입력받아 배열에 넣기
		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
		}
		// 42로 나눴을 때 나머지로 나올 수 있는 경우는 0~41까지 총 42개이므로
		// 배열의 크기를 42로 한다
		int[] rest = new int[42];

		int index = 0;
		// 원소의 값을 42로 나눈 값을 인덱스와 그 인덱스의 값으로 정했을 떄
		// 해당 인덱스의 값을 +1 시킨다.
		for (int i = 0; i < 10; i++) {
			index = arr[i] % 42;
			rest[index]++;
		}

		int count = 0;
		for (int i = 0; i < 42; i++) {
			// rest 배열에서 값이 증가된 원소들은 서로 다른 나머지의 종류들이므로
			// 0이 아닌 값이 있으면 count의 1을 증가시켜준다
			if (rest[i] != 0)
				count++;
		}
		System.out.println(count);

		sc.close();
	}
}
