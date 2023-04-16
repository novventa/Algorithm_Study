package study_ssafy2;

/*
 * A,B 배열을 정렬한 후에
 * 가장 큰수 부터 비교해 가면서 먹을 수 있는 먹이를 찾는다
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7795_먹을것인가먹힐것인가_김현수 {
	static int T, aSize, bSize;
	static int[] A, B;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		// 테스트 케이스 횟수 받아오기
		T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine().trim());
			aSize = Integer.parseInt(st.nextToken());
			bSize = Integer.parseInt(st.nextToken());

			A = new int[aSize];
			B = new int[bSize];

			// A 배열 받아오기
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < aSize; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}

			// B 배열 받아오기
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < bSize; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			// A, B 배열 오름차순 정리
			Arrays.sort(A);
			Arrays.sort(B);

			// A배열을 기준으로 B배열의 숫자들을 비교할 때
			// 비교를 시작할 B배열의 index를 저장해줄 변수
			int index = bSize - 1;

			// 먹을 수 있는 쌍을 세어줄 변수
			int count = 0;

			// A배열의 가장 큰수부터 돈다
			for (int i = aSize - 1; i >= 0; i--) {

				// B배열은 index 값부터 돈다
				// 비교하려는 A배열의 숫자가 점점 작아 지므로
				// B배열에서 비교를 시작하는 index 또한 작아져야한다
				for (int j = index; j >= 0; j--) {

					// 만약 A배열 숫자가 크다면
					if (A[i] > B[j]) {

						// 먹을 수 있는 쌍을 세어주고
						count += j + 1;

						// 현재 index를 저장한다
						index = j;

						// 반복문을 종료하고 다음 A배열의 수로 이동한다
						break;
					}
				}
			}

			// 결과 출력
			System.out.println(count);

		}
		// 테스트 케이스 끝
		br.close();

	}

}
