package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1541 {
	// 이 문제를 풀기 위해서는
	// 덧셈을 제일먼저 계산하고 다음에 뺄셈을 계산해야 한다.
	// 따라서 뺄셈을 기준으로 나누고
	// 파트들을 더한 뒤 뺄셈을 계산한다.
	
	
	public static void main(String[] args) throws IOException {

		// 버퍼드리더 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 최솟값 설정
		int min = Integer.MAX_VALUE;
		// 문자열 배열로 입력받고 빼기를 기준으로 나눈다
		String[] arr = br.readLine().split("-");

		// 문자열 길이만큼 반복
		for (int i = 0; i < arr.length; i++) {
			// 임시 값 설정
			int tmp = 0;
			// 빼기를 기준으로 나눈 파트에서 또 덧셈을 기준으로 나눈다
			String[] add = arr[i].split("\\+");

			// 임시값에 더해준다.
			for (int j = 0; j < add.length; j++) {
				tmp += Integer.parseInt(add[j]);
			}

			// 처음 비교할 때 갱신하기 위해
			if (min == Integer.MAX_VALUE)
				min = tmp;
			// 두번째부터는 빼준다.
			else
				min -= tmp;

		}

		// 출력
		System.out.println(min);
	}

}
