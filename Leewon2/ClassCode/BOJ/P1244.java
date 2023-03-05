// 문제 조건
// 스위치의 갯수는 100개 이하인 양의 정수다.
// 스위치가 켜져있으면 1, 꺼져있으면 0이다.
// 학생수는 100 이하인 양의 정수다.
// 남학생은 1, 여학생은 2로 표시한다.
// 학생이 받은 수는 스위치 개수 이하인 양의 정수다.

// 문제 해결 방법
// 남학생의 경우 반복문을 이용해 입력받은 위치의 배수는 스위치 상태를 바꾼다.
// 여학생의 경우 자신의 스위치 상태를 변경하고,
// 반복문을 이용해 양 옆이 대칭인지 확인한다.
// 양 옆이 대칭이라면 스위치 상태를 변경하고 다음이 대칭인지 확인한다.

import java.util.Scanner;

public class P1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 스위치의 개수를 입력 받는다.
		int switchCnt = sc.nextInt();

		// 스위치의 갯수 크기의 배열을 만든다.
		int[] arr = new int[switchCnt];

		// 배열에 스위치의 상태를 입력 받는다.
		for (int i = 0; i < switchCnt; i++) {
			arr[i] = sc.nextInt();
		}

		// 학생의 수를 입력 받는다.
		int personCnt = sc.nextInt();

		// 학생의 수만큼 반복하며, 성별과 스위치의 위치를 입력 받는다.
		for (int i = 0; i < personCnt; i++) {
			int gender = sc.nextInt();
			int location = sc.nextInt();

			// 성별이 남자인 경우
			if (gender == 1) {
				// 반복문을 이용해 location의 배수는 스위치의 상태를 바꾼다.
				for (int k = 1; k < switchCnt + 1; k++) {
					// k가 location의 배수라면
					if (k % location == 0) {
						// arr의 k-1번째의 스위치를 변경한다.
						if (arr[k - 1] == 0) {
							arr[k - 1] = 1;
						} else {
							arr[k - 1] = 0;
						}
					}
				}
			}
			// 성별이 여성인 경우
			else {
				// 자신의 위치의 스위치 값을 바꾼다.
				if (arr[location - 1] == 0) {
					arr[location - 1] = 1;
				} else {
					arr[location - 1] = 0;
				}

				// 여성의 경우 자신을 기준으로 양 옆이 대칭이면 수를 바꾸고
				// 그 다음 숫자도 대칭이면 계속 바꾼다.

				for (int k = 1; k < switchCnt + 1; k++) {
					// 종료조건 : 인덱스의 범위를 벗어나는 경우 반복문을 빠져나온다.
					if (location - 1 - k < 0 || location - 1 + k >= switchCnt) {
						break;
					}

					// 양 옆이 대칭인지 확인한다
					if (arr[location - 1 - k] == arr[location - 1 + k]) {
						// 대칭이라면, 스위치를 바꾼다.
						if (arr[location - 1 - k] == 0) {
							arr[location - 1 - k] = 1;
							arr[location - 1 + k] = 1;
						} else {
							arr[location - 1 - k] = 0;
							arr[location - 1 + k] = 0;
						}
					}
					// 대칭이 아니라면 반복문을 빠져나온다.
					else {
						break;
					}
				}

			}

		}
		// 출력 형식에 맞춰 출력한다.
		for (int i = 0; i < switchCnt; i++) {
			if (i % 20 == 19) {
				System.out.println(arr[i]);
			} else {
				System.out.print(arr[i] + " ");
			}
		}

	}

}
