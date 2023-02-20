
// 1부터 연속적으로 번호가 붙어있는 스위치들이 있다. 스위치는 켜져 있거나 꺼져있는 상태이다.
// ‘1’은 스위치가 켜져 있음을, ‘0’은 꺼져 있음을 나타낸다.
// 학생들은 자신의 성별과 받은 수에 따라 아래와 같은 방식으로 스위치를 조작하게 된다.
// 남학생은 스위치 번호가 자기가 받은 수의 배수이면, 그 스위치의 상태를 바꾼다. 즉, 스위치가 켜져 있으면 끄고, 꺼져 있으면 켠다. 
// 여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서, 그 구간에 속한 스위치의 상태를 모두 바꾼다.
// 이때 구간에 속한 스위치 개수는 항상 홀수가 된다.
// 스위치들의 마지막 상태를 출력하는 프로그램을 작성하시오.

package Baekjun;

import java.util.Scanner;

public class P1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int S = sc.nextInt(); // 스위치의 개수를 뜻하는 변수 S를 입력 받는다.
		int[] light = new int[S]; // 스위치의 on, off 상태를 나타낼 크기가 S인 배열 light를 생성한다.

		for (int idx = 0; idx < S; idx++) { // 스위치의 상태를 배열 light에 입력 받는다.
			light[idx] = sc.nextInt();
		}
		int student = sc.nextInt(); // 학생의 수를 입력 받는다.

		int[][] data = new int[student][2]; // 학생의 정보(성별과 숫자)를 저장할 2차원 배열 data를 생성한다.
		for (int row = 0; row < student; row++) {
			for (int col = 0; col < 2; col++) {
				data[row][col] = sc.nextInt(); // 학생의 정보를 순차적으로 입력 받는다.
			}
			int Idx = data[row][1] - 1; // 입력받은 스위치의 숫자(여기서는 data[row][1])에 해당하는 인덱스를 나타내는 변수 Idx를 선언한다.
			int rIdx = data[row][1]; // 해당 인덱스의 우측 인덱스를 나타내는 변수 rIdx를 선언하고,
			int lIdx = data[row][1] - 2; // 마찬가지로 해당 인덱스의 좌측 인덱스를 나타내는 변수 lIdx를 선언한다.

			if (data[row][0] == 1) { // 만약 data[row][0]이 1이라면,(남학생 이라면)
				while (Idx <= (S - 1)) { // 인덱스 값이 범위를 넘지 않는 선에서, while문을 실행한다.
					if (light[Idx] == 0) { // 해당 스위치의 상태를 변경하고,
						light[Idx] = 1;
						Idx += data[row][1]; // 인덱스 값을 해당 인덱스 값만큼 증가(배수) 시킨다.
					} else if (light[Idx] == 1) {
						light[Idx] = 0;
						Idx += data[row][1];
					}
				}
			} else if (data[row][0] == 2) { // 만약 data[row][0]이 2라면,(여학생 이라면)
				if (light[Idx] == 0) { // 해당 스위치의 상태를 변경하고,
					light[Idx] = 1;
					while (rIdx <= (S - 1) && lIdx >= 0 && light[rIdx] == light[lIdx]) { // 해당 스위치의 좌측과 우측 스위치가 범위를 넘지 않고,
						// 두 값이 같다는 가정하에,
						if (light[rIdx] == 0 && light[lIdx] == 0) { // 스위치의 상태를 변경하도록 한다.
							light[rIdx] = 1;
							light[lIdx] = 1;
							rIdx++; // 우측인덱스 값과
							lIdx--; // 좌측 인덱스 값을 증가 및 감소 시켜, 다음 인덱스 값을 다시 한번 비교, 조건에 부합하면 반복실행 하도록 한다.
						}
						else if(light[rIdx] == 1 && light[lIdx] == 1) {
							light[rIdx] = 0;
							light[lIdx] = 0;
							rIdx++;
							lIdx--;
						}
					}
				} else if (light[Idx] == 1) {
					light[Idx] = 0;
					while (rIdx <= (S - 1) && lIdx >= 0 && light[rIdx] == light[lIdx]) {
						if (light[rIdx] == 0 && light[lIdx] == 0) {
							light[rIdx] = 1;
							light[lIdx] = 1;
							rIdx++;
							lIdx--;
						}
						else if(light[rIdx] == 1 && light[lIdx] == 1) {
							light[rIdx] = 0;
							light[lIdx] = 0;
							rIdx++;
							lIdx--;
						}
					}
				}
			}
		}

		for (int idx = 0; idx < S; idx++) { // 스위치의 상태를 20개씩 출력해야하기 때문에,
			if(idx == 19 || idx == 39 || idx == 59 || idx == 79) { // 20번째에 해당하는 인덱스 값은 개행을 하고,
				System.out.println(light[idx]);
			}
			else if(idx == (S - 1)) { // 마지막 인덱스 값은 띄어쓰기를 붙이지 않은 상태로 출력한다.
				System.out.print(light[idx]);
			}
			else {
				System.out.print(light[idx] + " ");
			}
		}
	}
}
