//문제 조건
//전체 사람 수 N은 2이상 50 이하다.
//몸무게와 키는 10 이상 200 이하다.
//키와 몸무게가 모두 크면 덩치가 크다고 할 수 있다.

//문제 해결 방법
//사람의 수 N을 입력 받고, 키와 몸무게를 배열에 저장한다.
//브루트 포스로 한명씩 전체를 비교한다.
//모든 사람의 등수는 5등으로 고정시켜 놓고 몸무게와 키가 높다면 1을 더하고
//몸무게는 크되 키가 작거나 반대의 경우 둘 다 1을 더해준다.
//키와 몸무게가 모두 작으면 등수는 유지된다.

import java.util.Scanner;

public class P7568 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 전체 사람의 수 N을 입력 받는다.
		int N = sc.nextInt();

		// 등수를 저장하기 위한 변수를 만든다.
		int grade = 0;

		// 행은 사람의 수 크기를,
		// 열은 키와 몸무게 정보만 있으면 되므로 2로 설정한다.
		int[][] arr = new int[N][2];

		// col의 0번지에는 몸무게 정보를, 1번지에는 키 정보를 입력 받는다.
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < 2; col++) {
				arr[row][col] = sc.nextInt();
			}
		}

		// 전체를 비교해야 하므로, 사람의 수만큼 반복한다.
		for (int row = 0; row < N; row++) {

			// 점수는 사람의 수로 고정시킨다.
			// 사람이 5명이라면, 처음 등수는 5로 설정한다.
			grade = arr.length;

			// 사람이 바뀔때 마다 등수는 초기화가 된다.
			// 첫번째 사람은 첫번째 사람을 기준으로 등수를 설정하고,
			// 두번째 사람은 두번째 사람을 기준으로 등수를 설정한다.
			// (1,2) ≠ (2,1) 즉, 순서에 의미가 있으므로
			// 0부터 N까지 반복한다.
			for (int compare = 0; compare < N; compare++) {

				// 몸무게와 키가 모두 크다면 등수를 하나 올린다.
				if (arr[row][0] > arr[compare][0] && arr[row][1] > arr[compare][1])
					grade--;

				// 몸무게와 키가 모두 작거나, 자기 자신과 비교하는 경우는 continue 한다.
				else if ((arr[row][0] < arr[compare][0] && arr[row][1] < arr[compare][1]) || row == compare)
					continue;

				// 그 외의 경우는 둘 중 하나는 크고, 하나는 작은 경우 이므로
				// 등수를 하나 올린다.
				else
					grade--;

			}

			// 출력 형식에 맞춰 출력한다.
			System.out.print(grade + " ");
		}

	}

}
