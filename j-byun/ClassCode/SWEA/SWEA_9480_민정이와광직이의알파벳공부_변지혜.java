import java.util.Scanner;

// 9480 민정이와 광직이의 알파벳 공부
// D3

// 문제
// n개의 단어가 주어질 때,
// 해당 단어들을 활용해서 a~z까지 26개의 알파벳 소문자를 모두 포함하는 단어세트를 만들자
// 만들 수 있는 단어 세트의 최대 개수를 구하시오

// 구글링해보고 푼 것
// 아직 이해 못함

public class SWEA_9480_민정이와광직이의알파벳공부_변지혜 {
	static int maxSetCnt;

	public static void combination(boolean[][] word, boolean[] visited, int start, int depth, int maxDepth, int size) {
		// 단어 세트를 만들 수 있는 조합을 확인하는 method

		if (depth == maxDepth) { // 현재 확인할 개수 만큼의 단어를 뽑았을 때
			checkWordSet(word, visited, size); // 뽑은 단어들로 단어 세트를 만들 수 있는지 확인해보자
			return;
		}

		for (int idx = start; idx < size; idx++) { // 백트래킹
			if (visited[idx])
				continue; // 현재 단어가 사용 됐다면 다음 단어 확인하러 가기
			visited[idx] = true; // 현재 단어가 사용되지 않았다면 사용하고
			combination(word, visited, idx + 1, depth + 1, maxDepth, size); // 다음 단어 사용할 지 말지 확인하러 가기
			visited[idx] = false; // 이번 조합이 끝났으면 다시 현재 단어 미사용 상태로 돌려주기
		}

	}

	public static void checkWordSet(boolean[][] word, boolean[] visited, int size) {
		// 현재 사용한 단어들의 조합으로 a~z까지 하나 이상 포함하는 단어 세트를 만들 수 있는지 확인하는 method

		boolean isWordSet = true; // 현재 조합한 단어 세트에 알파벳 a~z까지가 모두 포함되어 있는지 여부를 나타냄, 일단 true로 가정하고 시작

		for (char alph = 'a'; alph <= 'z'; alph++) { // a~z까지의 알파벳이 포함되어 있는지 확인

			boolean isContain = false; // 일단 현재 알파벳이 포함되지 않았다고 가정하고

			for (int wordIdx = 0; wordIdx < size; wordIdx++) { // 현재 조합한 단어 세트를 확인하자
				if (visited[wordIdx] && word[wordIdx][alph - 'a']) // 현재 단어가 사용되지 않았다면 확인하지 않기
					isContain = true;
			}

			if (!isContain) { // 사용한 모든 단어를 확인했는데 현재 알파벳이 포함되지 않았다면
				isWordSet = false; // 현재의 조합은 단어 세트가 될 수 없다
				return; // 다른 알파벳 더 확인할 필요 없음
			}
		}
		
		if (isWordSet) // a~z까지 다 확인했는데 모든 알파벳을 포함하고 있다면
			maxSetCnt++; // 현재 뽑은 단어 조합은 단어 세트가 될 수 있으니 단어 세트 개수 +1 해주기

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기

		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복 실행

			int wordCnt = sc.nextInt(); // 알고있는 단어의 개수 입력받기

			boolean[][] word = new boolean[wordCnt][26]; // 알고있는 단어에 포함된 알파벳 저장하기

			for (int cnt = 0; cnt < wordCnt; cnt++) {
				String line = sc.next();

				for (int idx = 0; idx < line.length(); idx++) {
					word[cnt][line.charAt(idx) - 'a'] = true; // 현재 단어에 포함된 알파벳은 true로 표현하기
				}
			}

			maxSetCnt = 0; // 만들 수 있는 최대 단어 세트 개수 저장할 공간

			boolean[] visited = new boolean[wordCnt]; // 해당 단어의 사용 여부를 표시할 boolean 배열

			for (int idx = 1; idx <= wordCnt; idx++) {
				combination(word, visited, 0, 0, idx, wordCnt); // 만들 수 있는 단어 세트 조합 확인하기
			}

			System.out.printf("#%d %d\n", tc, maxSetCnt);
		}

	}

}
