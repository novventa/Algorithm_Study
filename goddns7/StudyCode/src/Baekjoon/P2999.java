package day0223;

import java.util.Scanner;

public class P2999 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//문자열을 입력받음
		String line = sc.next();
		//문자열을 문자로 나눠서 넣을 배열 생성
		char[] word = line.toCharArray();

		// R의 값 중 가장 큰 값
		int maxR = 0;
		// C의 값 중 가장 큰 값
		int maxC = 0;
		
		for (int R = 1; R <= word.length; R++) {
			for (int C = R; C <= word.length; C++) {
				if (R * C == word.length) {
					maxC = C;
					if (R > maxR) {
						maxR = R;
					}
				}
			}
		}

		//word의 문자들을 넣을 2차원 배열 생성
		char[][] arr = new char[maxC][maxR];

		//인덱스의 값
		int i = 0;
		
		//word의 문자들을 2차원 배열에 대입하기
		for (int row = 0; row < maxC; row++) {
			for (int col = 0; col < maxR; col++) {
				arr[row][col]=word[i++];
			}
		}

		//행과 열을 바꿔서 출력
		for (int col = 0; col < maxR; col++) {
			for (int row = 0; row < maxC; row++) {
				System.out.print(arr[row][col]);
			}
		}

		sc.close();
	}
}




