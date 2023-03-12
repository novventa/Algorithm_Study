package study_ssafy;

/*
 * 조합을 통해 문제를 해결한다
 * 
 * 1. 단어를 모두 받는다
 * 2. 단어 중 뽑아야하는 개수만큼 일단 전부 뽑는다
 *   -> 이때 조합으로 뽑는다
 * 3. 뽑은 단어가 모음이 1개이상 자음이 2개이상인지를 확인한다
 * 4. 맞다면 출력해준다
 * 
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class solution_1759_암호만들기_김현수 {

	// 뽑아야할 단어개수와, 전체 단어 개수를 받아올 변수
	static int passwordLength, wordNum;

	// 조합에 사용할 논리형
	static boolean isUsed[];

	// 전체 단어를 받아올 배열
	static char word[];

	// 뽑은 단어를 받아올 배열
	static char answerWord[];

	public static void main(String[] args) throws IOException {

		// 버퍼 리더 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Tokenizer 사용
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 뽑을 단어 개수 받아오기
		passwordLength = Integer.parseInt(st.nextToken());

		// 전체 단어 개수 받아오기
		wordNum = Integer.parseInt(st.nextToken());

		// 전체 단어와 뽑을 단어를 받을 배열 정의
		word = new char[wordNum];
		answerWord = new char[passwordLength];

		// 전체 단어를 배열에 넣기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < wordNum; i++) {
			word[i] = st.nextToken().charAt(0);
		}

		// 버퍼리더 종료
		br.close();

		// 단어 정렬
		Arrays.sort(word);

		// 조합에 사용할 논리형 정의
		isUsed = new boolean[wordNum];

		// 조합 사용
		backtracking(0, 0);

	}

	// 조합 메소드
	static void backtracking(int k, int start) {

		// 만약 원하는 만큼 뽑앗으면
		if (k == passwordLength) {

			// 모음개수를 세줄 변수
			int count = 0;

			// 전체를 돌면서 모음개수를 센다
			for (int i = 0; i < passwordLength; i++) {
				if (answerWord[i] == 'a' || answerWord[i] == 'e' || answerWord[i] == 'i' || answerWord[i] == 'o'
						|| answerWord[i] == 'u') {
					count++;
				}
			}

			// 만약 모음개수가 1개이상 이거나 (뽑을단어-2)이하이면 출력해준다
			if (count > 0 && count < passwordLength - 1) {
				for (int i = 0; i < passwordLength; i++) {
					System.out.print(answerWord[i]);
				}
				System.out.println();
			}
			// 메소드를 끝낸다
			return;
		}

		// 중복없이 순서없이 뽑는 반복문
		for (int i = start; i < wordNum; i++) {
			if (!isUsed[i]) {
				isUsed[i] = true;
				answerWord[k] = word[i];
				backtracking(k + 1, i + 1);
				isUsed[i] = false;
			}
		}

	}
}
