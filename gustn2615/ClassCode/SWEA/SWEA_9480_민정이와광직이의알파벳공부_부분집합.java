package swExpert_study;

import java.util.HashMap;
import java.util.Scanner;

public class SWEA_9480_민정이와광직이의알파벳공부_부분집합 {

	// 부분집합을 표현할 논리형
	static boolean isUsed[];

	// 단어를 뽑아줄 배열
	static String words[];

	// 알파벳을 저장할 HashMap 정의
	static HashMap<Character, Integer> alphabet;

	// 변수 설정
	static int T, N, cnt;

	public static void main(String[] args) {

		// 스캐너 사용
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 횟수 받아오기
		T = sc.nextInt();

		// 테스트 케이스 횟수만큼 반복
		for (int tc = 1; tc <= T; tc++) {

			// 단어 개수 받아오기
			N = sc.nextInt();

			// 단어 넣을 배열 크기 정의
			words = new String[N];

			// 부분집합을 나타낼 논리형 크기 정의
			isUsed = new boolean[N];

			// 알파벳이 다있는지 세줄 변수
			cnt = 0;

			// 배열에 단어를 넣는다
			for (int i = 0; i < N; i++) {
				words[i] = sc.next();
			}

			// 부분집합을 만들어두고
			// 알파벳이 26개가 다 존재하는지 확인한다
			subset(0);

			// 결과출력
			System.out.printf("#%d %d\n", tc, cnt);
		}

		// 스캐너 사용 종료
		sc.close();
	}

	// 부분집합을 찾는다
	static void subset(int k) {

		// 모든 원소를 다 돌았으면
		if (k == N) {
			// 알파벳이 26개 존재하는지 확인
//			System.out.println(Arrays.toString(isUsed));
			isAlphabet();
			return;
		}

		// 부분집합을 구하는 재귀함수
		// 배열에서 true인 경우에만 단어를 사용한다
		subset(k + 1);
		isUsed[k] = true;
		subset(k + 1);
		isUsed[k] = false;

	}

	// 단어가 26가지 존재하는지 확인
	static void isAlphabet() {

		// hashmap정의
		alphabet = new HashMap<>();

		// 반복문을 돌면서
		for (int i = 0; i < N; i++) {
			// 논리형이 true인 index에 대해서
			if (isUsed[i]) {

				// 단어를 haspmap에 넣어준다
				for (int j = 0; j < words[i].length(); j++) {
					alphabet.put(words[i].charAt(j), i);
				}
			}
		}

		// 이때 size가 26개이면 카운트 한다.
		if (alphabet.size() == 26) {
			cnt++;
		}

	}
}
