package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2798 {
	public static void main(String[] args) throws IOException {
		// 버퍼 리더 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// tokenizer 사용 문자열로 받아오는데 br.readLine으로 한줄을 받아서
		// 공백을 기준으로 나눠준다.
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 카드갯수와 부를 숫자 변수로 받아오기
		int cardCount = Integer.parseInt(st.nextToken());
		int maxNum = Integer.parseInt(st.nextToken());
		
		// 다음줄에 주어지는 숫자들을 문자열 배열로 받아온다.
		// split은 안쪽에 적어준 문자열을 기준으로 나눠서 문자열 배열에 넣어준다.
		String[] card = br.readLine().split(" ");

		// 세카드의 합을 담을 변수
		int sum = 0;
		// 세카드의 합과 딜러가 부른 숫자의 차이를 저장할 변수
		int minus = 900000;
		
		// 전체 카드 갯수에서 겹치치않게 3개를 뽑는 반복문
		for (int i = 0; i < cardCount; i++) {
			for (int j = 0; j < cardCount; j++) {
				// 순서가 있는 순열이므로
				// j랑 i같으면안된다.
				if (j != i) {
					for (int k = 0; k < cardCount; k++) {
						// 마찬가지로 i,j,k 모두가 같으면 안된다.
						if (k != j && k != i) {
							// 이제 세개의 수를 뽑았으므로 합을 구한다.
							sum = Integer.parseInt(card[i]) + Integer.parseInt(card[j]) + Integer.parseInt(card[k]);
							// 이때 부른 숫자와 합의 차이는 0 이상이여야하고
							// 또한 차이가 가장 작아야하므로 minus 값보다 작아야한다.
							if ((maxNum - sum) >= 0 && (maxNum - sum) <= minus) {
								// 이때 차이값을 마이너스에 저장해준다.
								minus = maxNum - sum;
							}
						}
					}
				}
			}
		}
		// 최대값에서 마이너스 뺀값을 출력
		System.out.println(maxNum - minus);
	}
}
