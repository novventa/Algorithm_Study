package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1244
		// 스위치 켜고 끄기
		// 실버4
		
		// 남학생은 스위치번호가 자기가 받은 수의 배수이면, 그 스위치 상태를 바꾼다
		// 여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서
		//	그 구간에 속한 모든 스위치의 상태를 바꾼다
		
		// 마지막 스위치들의 상태를 출력하시오

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 스위치의 개수 n 입력받기
		int n = Integer.parseInt(br.readLine());

		// n의 크기를 갖는 배열 onOff 만들기
		int[] onOff = new int[n];

		// onOff 배열 값 입력받기

		String[] s = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			onOff[i] = Integer.parseInt(s[i]);
		}

//				System.out.println(Arrays.toString(onOff));

		// 학생 정보 입력받기
		// 학생의 수 student 입력받기
		int student = Integer.parseInt(br.readLine());

		for (int stCnt = 0; stCnt < student; stCnt++) {
			String[] std = br.readLine().split(" ");

			// 성별 입력받기
			// 남학생 : 1, 여학생 : 2
			int gender = Integer.parseInt(std[0]);
			// 학생이 받은 스위치 번호 입력받기
			int num = Integer.parseInt(std[1]);

			// 남학생일 때
			if (gender == 1) {
				for (int i = num - 1; i < onOff.length; i += num) {
					// 입력받은 num의 배수 번 째 스위치에 대해
					// 스위치가 0이면 1로
					if (onOff[i] == 0) {
						onOff[i] = 1;
					} else if (onOff[i] == 1) {
						// 스위치가 1이면 0으로 바꾼다
						onOff[i] = 0;
					}
				}

			} else if (gender == 2) {
				// 여학생일 때
				for (int i = 1; i < (onOff.length / 2) + 1; i++) {
					// 입력받은 num의 좌우 대칭 자리가 동일하지 않거나
					// onOff[idx]에서 idx의 범위가 0 <= idx < onOff.length 를 벗어날 경우
					if (((num - 1) - i) < 0 || ((num - 1) + i) >= onOff.length
							|| (onOff[(num - 1) - i] != onOff[(num - 1) + i])) {
						// 그 사이 값까지 스위치 상태를 다 바꿔준다
						for (int changeIdx = (num - i); changeIdx < ((num - 1) + i); changeIdx++) {
							// 스위치가 0이면 1로
							if (onOff[changeIdx] == 0) {
								onOff[changeIdx] = 1;
							} else if (onOff[changeIdx] == 1) {
								// 스위치가 1이면 0으로 바꾼다
								onOff[changeIdx] = 0;
							}

						}
						break;
						// 대칭자리의 값이 다르거나 배열의 범위를 벗어나는 경우를 한 번만 찾으면 그 다음은 고려하지 않음
					}
				}
			}

//					System.out.println(Arrays.toString(onOff));
		}
		br.close();

		// 배열 요소들 출력
		// 한 줄에 20개씩 출력
		int idx = 0;

		for (int row = 0; row < (onOff.length / 20 + 1); row++) {
			for (int i = 0; idx < onOff.length && i < 20; i++) {
				System.out.print(onOff[idx++] + " ");
			}
			System.out.println();
		}

	}

}
