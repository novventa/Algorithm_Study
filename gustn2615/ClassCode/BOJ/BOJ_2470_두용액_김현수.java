package study_ssafy2;

/*
 * 정렬 후에 두 용액을 선택한다
 * 1. 맨앞과 맨뒤의 용액을 선택 후 특성값을 구한다.
 * 2. 특성값이 양수이면 맨뒤의 용액에서 한칸 앞의 용액을 선택 후 특성값을 확인한다.
 * 3. 특성값이 음수이면 맨 앞의 용액에서 한칸 뒤의 용액을 선택 후 특성값을 확인한다.
 * 4. 특성값이 0 이면 두 용액을 출력한다.
 * 5. 특성값이 0에 가장 가까워 질때까지 반복한다.
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470_두용액_김현수 {
	
	// 변수 정의
	static int num, min, startPosition, endPosition;
	static int[] solution;

	// BufferedReader, Stringtokenizer 사용
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		// 용액의 개수
		num = Integer.parseInt(br.readLine().trim());

		// 용액을 담을 배열
		solution = new int[num];

		st = new StringTokenizer(br.readLine().trim());

		for (int i = 0; i < num; i++) {
			solution[i] = Integer.parseInt(st.nextToken());
		}

		// 용액을 오름차순 정렬
		Arrays.sort(solution);

		// 처음과 마지막 시작위치 저장
		startPosition = 0;
		endPosition = num - 1;
		
		// 특성값을 저장할 변수(0에 가까워지면 되므로 절대값으로 저장)
		min = Integer.MAX_VALUE;

		// 두 용액을 찾는 메소드
		binarySearch(min, startPosition, endPosition);

		// 출력
		System.out.println(solution[startPosition] + " " + solution[endPosition]);

	}

	// 두 용액을 찾는 메소드
	private static void binarySearch(int value, int start, int end) {
		// 두용액이 겹치지 않을 때 까지 반복 할 것이다.
		if (start < end) {

			// 두 용액의 특성값을 구한다
			int sum = solution[start] + solution[end];
			
			// 특성값의 절대값을 저장
			int tmp = Math.abs(sum);

			// 만약 특성값이 현재 저장된 특성값보다 작으면
			if (tmp < value) {
				// 그 정보들을 저장한다
				min = tmp;
				startPosition = start;
				endPosition = end;
			}

			// 만약 특성값이 양수이면
			if (sum > 0) {
				// 맨 끝쪽 용액보다 한칸 앞쪽 용액을 선택해보고
				binarySearch(min, start, end - 1);
			} 
			// 음수이면
			else if (sum < 0) {
				// 맨 앞쪽보다 한칸 뒤쪽 용액을 선택한다
				binarySearch(min, start + 1, end);
			} 
			// 0이라면 정답이므로 메소드를 끝낸다.
			else
				return;

		}

	}
}
