package day0308;

import java.util.Arrays;
import java.util.Scanner;

public class P1026 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 배열의 길이
		int size = sc.nextInt();

		// 배열 A
		int[] A = new int[size];
		// 배열 B
		int[] B = new int[size];
		// 배열 A에 해당 값 대입
		for (int i = 0; i < size; i++) {
			A[i] = sc.nextInt();
		}
		// 배열 B에 해당 값 대입
		for (int i = 0; i < size; i++) {
			B[i] = sc.nextInt();
		}

		// A를 먼저 오름차순으로 바꾼다
		Arrays.sort(A);
		// 새로운 배열 생성
		int[] BCopy = new int[size];
		// 배열 B의 값을 그대로 복사
		for (int i = 0; i < size; i++) {
			BCopy[i] = B[i];
		}
		// BCopy 배열을 오름차순으로 바꾼다
		Arrays.sort(BCopy);

		// 최종 최솟값
		int sum = 0;
		// A의 인덱스
		int idx = 0;
		// BCopy의 인덱스
		int index = size - 1;

		// S가 최소값으로 나오려면 A의 최솟값과 B의 최대값이 곱해져야하고, A의 최대값과 B의 최솟값이 곱해져야 한다.
		// 즉, 재배열한 A와 BCopy의 값을 하나는 뒤에서부터, 하나는 앞에서부터 서로 곱해준다
		while (idx < size && index >= 0) {
			sum += BCopy[index] * A[idx];
			idx++;
			index--;
		}

		System.out.println(sum);
		sc.close();
	}

}


