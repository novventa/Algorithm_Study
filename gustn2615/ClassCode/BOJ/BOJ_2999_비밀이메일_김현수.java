package study_ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solution_2999_비밀이메일_김현수 {
	public static void main(String[] args) throws IOException {
		// 버퍼리더 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 문자배열로 받아오기
		char[] word = br.readLine().toCharArray();
		// 버퍼리더 종료
		br.close();
		// 단어의 길이 변수로 저장
		int size = word.length;
		// 행값을 구하기 위해 변수 지정
		int R = 0;
		// R<=C 일띠 R*C가 size가 되는 값을 찾는다.
		// 이때 R은 가장 큰값이여야 한다.
		for (int i = 1; i <= size / 2; i++) {
			if (size % i == 0) {
				int quotient = size / i;
				if (i <= quotient) {
					R = i;
				}
			}
		}
//		System.out.println(R);
		// 열값을 저장한다.
		int C = size / R;
		// 암호문을 받아올 배열
		char[][] password = new char[R][C];
		// 배열의 index를 나타내는 변수
		int index = 0;
		// 문제 자체에서 주어진 암호문은 왼쪽부터 위에서 아래로 읽은 암호문이다.
		// 따라서 row부터 단어를 넣어주면 된다.
		for (int col = 0; col < C; col++) {
			for (int row = 0; row < R; row++) {
				password[row][col] = word[index++];
			}
		}
		// 넣어준 암호문을 row => col 방향으로 읽어 주기만 하면 완성
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				System.out.print(password[row][col]);
			}
		}

	}

}
