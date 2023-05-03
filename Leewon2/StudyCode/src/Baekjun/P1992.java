package Baekjun;

import java.util.Scanner;
import java.util.Stack;

public class P1992 {

	static int N;

	static int[][] arr;

	static StringBuilder sb;

	static boolean check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// N 입력 받기
		N = sc.nextInt();

		// 배열 크기 정해서 저장.
		arr = new int[N][N];

		sb = new StringBuilder();

		// 배열에 값 입력
		// 공백 없이 주어지므로
		for (int row = 0; row < N; row++) {
			// 문자열로 입력 받고
			String str = sc.next();
			for (int col = 0; col < N; col++) {
				// char형으로 바꾼 후 int로 변경
				arr[row][col] = Character.getNumericValue(str.charAt(col));
			}
		}

		conquer(0, 0, N);
		System.out.println(sb);

	}

	private static void conquer(int r, int c, int size) {
		// 사각형이 같은지 판단
		same(r, c, size);

		// 모두 같다면?
		if (check) {
			// 기준값을 sb에 연결
			if (arr[r][c] == 1) {
				sb.append(1);
			} else {
				sb.append(0);
			}
		}
		// 다르다면?
		else {
			// 2,1,3,4 순으로 확인
			// 2번 확인하기 전에 ( 연결
			// 4번 확인하고 )연결
			sb.append('(');

			// size 2로 나누기
			size /= 2;
			// 2사분면 확인
			conquer(r, c, size);
			// 1사분면 확인
			conquer(r, c + size, size);
			// 3사분면 확인
			conquer(r + size, c, size);
			// 4사분면 확인
			conquer(r + size, c + size, size);

			// 4사분면 확인했으니 ) 연결
			sb.append(')');
		}
	}

	// 사각형이 모두 같은지 알아보자.
	private static void same(int r, int c, int size) {
		// 모두 같다고 생각
		check = true;
		// 첫번째 값을 기준
		int standard = arr[r][c];

		outer: for (int row = r; row < r + size; row++) {
			for (int col = c; col < c + size; col++) {
				// 기준값과 다르면
				if (arr[row][col] != standard) {
					// check를 false로 바꾸고 break
					check = false;
					break outer;
				}
			}
		}
	}
}
