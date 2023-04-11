package study_ssafy;

/*
 * 1. 49개 중 뽑은 숫자를 배열로 만든다
 * 2. 뽑은 숫자 중 조합으로 6가지를 뽑는다
 * 3. 출력한다
 * 4. 입력값이 0이되면 종료한다
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class solution_6603_로또_김현수 {
	static int N;
	static int[] arr;
	static int[] selcted;

	public static void main(String[] args) throws IOException {

		// 버퍼리더 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// N==0이 될때까지 반복한다
		while (true) {

			// StringTokenizer 사용
			st = new StringTokenizer(br.readLine().trim());

			// 49개중 뽑은 숫자의 개수 받아오기
			N = Integer.parseInt(st.nextToken());

			// 0이 되면 반복문 종료
			if (N == 0) {
				break;
			}

			// 전체 숫자를 받아올 배열
			arr = new int[N];

			// 6개의 숫자를 뽑을 배열
			selcted = new int[6];

			// 숫자를 받아온다
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// 조합으로 뽑는다
			backtracking(0, 0);

			// 한칸 띄어준다
			System.out.println();
		}
	}

	// 6개의 번호를 뽑아줄 메소드
	static void backtracking(int k, int start) {

		// 6개의 번호를 뽑앗다면
		if (k == 6) {

			// 정렬한다
			Arrays.sort(selcted);

			// 뽑아주고
			for (int i : selcted)
				System.out.print(i + " ");

			// 한줄을 뽑았다면 한칸을 띄워준다
			System.out.println();

			// 메소드를 종료한다
			return;
		}

		// 조합 메소드
		for (int i = start; i < N; i++) {
			selcted[k] = arr[i];
			backtracking(k + 1, i + 1);
		}

	}
}
