package day0313;

import java.util.Scanner;

public class P10973 {
	// 해당 숫자를 입력받아 순열을 만든다
	static int num;
	// 순열 중 하나를 입력 받음
	static int[] per;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 해당 숫자를 입력받아 순열을 만든다
		num = sc.nextInt();
		// 주어지는 순열을 넣을 배열
		per = new int[num];
		// 배열에 주어지는 순열을 넣기
		for (int i = 0; i < num; i++) {
			per[i] = sc.nextInt();
		}

		// per의 원소가 1~num 범위에서 똑같은 횟수
		int count = 0;
		// per의 원소가 해당 인덱스+1과 같은 숫자라면 count++시켜준다
		for (int i = 0; i < num; i++) {
			if (per[i] == i + 1) {
				count++;
			}
		}
		// count가 per배열의 크기만큼의 수라면 오름차순 순열에서 첫번째 순서의 순열이기 때문에
		if (count == num) {
			// -1 출력
			System.out.println(-1);
			// 첫번째 순서의 순열이 아니라면 nextPermutation을 실행시킨다
		} else {
			if (nextPermutation()) {
				// nextPermutation을 실행시키고 나온 배열을 출력
				for (int i = 0; i < num; i++) {
					System.out.print(per[i] + " ");
				}
			}
		}
		sc.close();
	}

	private static boolean nextPermutation() {

		// per[i-1]>per[i]을 만족하는 가장 큰 i를 찾는다
		// 찾으면 해당 i-1을 switchIdx1에 넣는다
		int switchIdx1 = 0;
		// 가장 큰 i를 찾기 때문에 뒤에서부터 찾고, 찾으면 반복문 종료
		for (int i = num - 1; i >= 1; i--) {
			if (per[i] < per[i - 1]) {
				switchIdx1 = i - 1;
				break;
			}
		}
		// per[j]<per[switchIdx1]를 만족하는 가장 큰 j를 찾는다
		int switchIdx2 = 0;
		// 가장 큰 j를 찾기 때문에 뒤에서부터 찾고, 찾으면 반복문 종료
		for (int j = num - 1; j >= 1; j--) {
			if (per[j] < per[switchIdx1]) {
				switchIdx2 = j;
				break;
			}
		}

		// 찾은 두 개의 인덱스의 값을 swap 시켜준다
		swap(switchIdx1, switchIdx2);

		// 맨 끝의 인덱스를 last로 지정
		int last = num - 1;
		// switchIdx1 + 1의 인덱스를 first로 지정
		int first = switchIdx1 + 1;
		// first부터 배열의 끝까지 순열을 뒤집는다
		// last인덱스가 first와 같아지거나 first보다 작아지면 순열을 뒤집고 또 뒤집게 되므로 해당 과정을 진행시키지 않도록 조건문의 조건
		// 지정
		while (first < last) {

			// first는 증가시키고 last는 감소시키면서 양 끝에서 안쪽으로 들어가면서 각 두 수를 교환한다
			swap(first, last);
			first++;
			last--;
		}

		return true;
	}

	// 주어진 두 개의 인덱스의 값을 교환시키는 메서드
	private static void swap(int switchIdx1, int switchIdx2) {
		// 앞의 인덱스 원소의 값을 다른 변수에 저장해놓고
		int n = per[switchIdx1];
		// 뒤의 인덱스 원소의 값을 앞의 인덱스 원소의 값에 넣는다
		per[switchIdx1] = per[switchIdx2];
		// 뒤의 인덱스 원소의 값에 변수에 저장해놓은 앞의 인덱스 원소의 값을 넣는다
		per[switchIdx2] = n;
	}

}