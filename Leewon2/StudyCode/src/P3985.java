import java.util.Scanner;

// 문제 조건
// 롤 케이크의 길이 L은 1 이상 1000 이하다.
// 방청객의 수 N은 1 이상 1000 이하다.

// 문제 해결 방법
// 롤케이크의 길이+1 만큼의 배열을 만들자.
// 배열의 인덱스를 활용해서 인덱스의 값이 0이 아닐때만 카운트를 해보자.
// 인덱스가 0인 경우에는 1로 바꾸고 카운트를 하자.
// 인덱스가 1인 경우에는 카운트를 하지 못한다.
// 실제로 가장 많이 받은 방청객의 번호를 출력하고,
// 많이 받을것으로 예상된 방청객의 번호를 출력해보자.

public class P3985 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 롤케이크의 길이를 입력받아보자.
		int rollCake = sc.nextInt();

		// 배열의 인덱스를 활용해 문제를 해결하기 위해 배열의 크기를 롤케이크의 길이+1로 한다.
		int[] arr = new int[rollCake + 1];

		// 사람의 수를 입력 받아보자.
		int peopleCnt = sc.nextInt();

		// expect : 많이 받을 것으로 기대된 사람의 기대 갯수
		int expect = 0;

		// max : 실제로 많이 받은 사람이 받은 갯수
		int max = 0;

		// maxIdx : 실제로 많이 받은 사람의 인덱스
		int maxIdx = 0;

		// exMaxIdx : 많이 받을 것으로 기대된 사람의 인덱스
		int exMaxIdx = 0;

		for (int idx = 0; idx < peopleCnt; idx++) {
			// cnt : 실제로 많이 받은 사람이 몇개를 받았는지 세는 변수
			int cnt = 0;
			// cnt2 : 많이 받을 것으로 기대된 사람의 갯수
			int cnt2 = 0;

			// 방청객이 적어낸 숫자 2개를 입력받아 보자.
			int p = sc.nextInt();
			int k = sc.nextInt();

			// 자신이 기대하는 수는 k-p+1이 된다.
			cnt2 = k - p + 1;

			for (int i = p; i <= k; i++) {
				// 배열의 인덱스가 0이라면
				if (arr[i] == 0) {
					// 배열에 1 값을 더하고
					arr[i]++;
					// 숫자도 세주자
					cnt++;
				}
			}
			// 반복문이 끝나고 다음 숫자가 들어왔을 때
			// 배열에 1 값이 차있으면 카운트 되지 않는다.

			// 기대값을 변경하자.
			// cnt2가 expect보다 크다면
			if (expect < cnt2) {
				// expect에 cnt2를 저장하자.
				expect = cnt2;
				// 인덱스도 저장해야 하므로, 기대하는 최대값의 인덱스도 저장하자
				exMaxIdx = idx + 1;
			}

			// 최댓값을 변경하자.
			// cnt가 max보다 크면
			if (max < cnt) {
				// max에 cnt를 저장하자.
				max = cnt;
				// 인덱스도 저장해야 하므로, 최대값의 인덱스도 저장하자
				maxIdx = idx + 1;
			}

		}
		// 기대한 최댓값과, 실제 최댓값을 받은 방청객의 번호를 출력하자.
		System.out.println(exMaxIdx);
		System.out.println(maxIdx);
	}
}
