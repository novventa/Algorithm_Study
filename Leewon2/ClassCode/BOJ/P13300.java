// 문제
// 1학년 부터 6학년까지, 같은 성별과 묵을 방을 배정해야 한다.
// 한 반에 배정할 수 있는 최대 인원 수 K가 주어졌을 때
// 모든 학생을 배정하기 위해 필요한 방의 최소 갯수를 구하자.

// 문제 조건
// 학생 수 N은 1 이상 1000 이하다.
// 한 방에 배정할 수 있는 최대 인원 수 K는 1 이상 1000 이하다.
// 학년 Y는 1 이상 6이하다
// 성별 S는 여학생은 0, 남학생은 1로 나타낸다.

//문제 해결 방법
// 1. 학생수 N과 한 방에 배정할 수 있는 최대 인원수 K를 입력 받는다.
// 2. 학생의 성별과 학년을 입력 받는다.
// 3. 최소 방 갯수를 저장할 변수 sum을 선언한다.
// 4. 2중 for문을 이용하여 x학년의 y성별을 분리한다.
// 5. x학년의 y성별의 숫자를 센 다음 k로 나눈다.
// 6. ceil 함수를 이용해 나눈 수를 올림한 후 sum에 더한다.

import java.util.Scanner;

public class P1244 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 학생의 수를 입력 받자.
		int student = sc.nextInt();

		// 최대 인원수 max를 입력 받자.
		int max = sc.nextInt();

		// 최소 방 갯수를 입력 받자.
		int sum = 0;

		// 성별 크기와 학생 크기의 배열을 만들자
		// 학생의 크기는 student만큼, 성별은 2개이므로 2 크기로 정한다.
		int[][] arr = new int[student][2];

		// 학생의 정보를 배열에 저장하자
		for (int idx = 0; idx < student; idx++) {
			for (int idx2 = 0; idx2 < 2; idx2++) {
				arr[idx][idx2] = sc.nextInt();
			}
		}

		// 학년별, 성별별 학생의 수를 저장하기 위한 변수를 만든다.
		double cnt = 0;

		// 첫번째 for문은 학년을 의미한다.
		for (int idx = 1; idx <= 6; idx++) {
			// 두번째 for문은 성별을 의미한다.
			for (int idx2 = 0; idx2 < 2; idx2++) {
				// 학년과 성별이 바뀔 때 마다 cnt를 0으로 초기화 시킨다.
				cnt = 0;
				// 세번재 for문은 학년과 성별에 따라 수를 세는 것을 의미한다.
				for (int idx3 = 0; idx3 < student; idx3++) {
					// 배열의 첫번째는 성별, 두번째는 학년 이므로,
					// 성별을 나타내는 idx2와 같고, 학년을 나타내는 idx와 같다면,
					// x학년 y성별을 찾은 것이므로 cnt에 1을 더하자.
					if (arr[idx3][0] == idx2 && arr[idx3][1] == idx) {
						cnt++;
					}
				}
				// sum 변수에 ceil 함수를 이용하여 cnt를 max로 나눈 몫을 올림하여 더하자.
				sum += Math.ceil(cnt / max);

			}

		}

		// 출력
		System.out.println(sum);

	}
}
