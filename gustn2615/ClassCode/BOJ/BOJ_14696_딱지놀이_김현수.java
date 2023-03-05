package study_ssafy;

/*
 * 카운팅 배열을 사용한다.
 * A, B가 받는 카드의 숫자별로 카운팅을 해서
 * 각각의 카드의 개수를 비교해서 누가 이겼는지를 판별하면 된다.
 * 
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution_14696_딱지놀이_김현수 {
	public static void main(String[] args) throws IOException {

		// 버퍼 리더 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 게임횟수 받아오기
		int gameNum = Integer.parseInt(br.readLine());

		// 게임 횟수만큼 반복하면서
		for (int i = 0; i < gameNum; i++) {

			// a와 b의 카드 번호를 카운팅 해줄 배열
			int[] aCard = new int[5];
			int[] bCard = new int[5];

			// tokenizer사용
			StringTokenizer st = new StringTokenizer(br.readLine());

			// a카드에 있는 전체 모양의 개수
			int aShapeCount = Integer.parseInt(st.nextToken());

			// 모양별 개수를 카운팅
			for (int index = 0; index < aShapeCount; index++) {
				aCard[Integer.parseInt(st.nextToken())]++;
			}

			st = new StringTokenizer(br.readLine());

			// b카드에 있는 전체 모양의 개수
			int bShapeCount = Integer.parseInt(st.nextToken());

			// 모양별 개수를 카운팅
			for (int index = 0; index < bShapeCount; index++) {
				bCard[Integer.parseInt(st.nextToken())]++;
			}

			// 밑에 반복문에서 승리가 결정이 안나면 D출력
			char answer = 'D';

			// 4번 모양이 가장 강하므로 4번부터 시작
			for (int index = 4; index > 0; index--) {

				// a가 숫자가 많으면 A가 승리 후 멈춤
				if (aCard[index] > bCard[index]) {
					answer = 'A';
					break;
				}

				// b가 숫자가 많으면 B가 승리 후 멈춤
				else if (aCard[index] < bCard[index]) {
					answer = 'B';
					break;
				}

			}
			System.out.println(answer);
		}
		br.close();
	}
}
