import java.util.Scanner;

public class P1193 {

	// 문제 조건
	// 1<=X<=10,000,000

	// 문제 해결 방법
	// 분모>=분자인 경우 분모에 1을 더한다.
	// 그 다음 분모가 1이 될 때 까지 분모에는 1을빼고, 분자에는 1을 더한다
	// 분모<분자 경우는 분자에 1을 더하고 분자가 1이 될 때 까지 분자에는 1을빼고, 분모에는 1을 더한다
	// 위 과정에서 cnt(이동 횟수)와 X 값이 같아지면 출력한다.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		// bunja, bunmo : 분자, 분모
		// cnt : 이동 횟수를 나타내는 변수
		int bunja = 1, bunmo = 1, cnt = 1;

		// X가 1인 경우를 처리하기 위한 코드
		if (cnt == x) {
			System.out.println(bunja + "/" + bunmo);
		}

		// while문을 여러번 실행하기 위한 반복문
		for (int i = 0; i < x; i++) {

			// 메모리를 위해 cnt와 x가 같아지면 break.
			if (cnt == x) {
				break;
			}

			// 분모 >= 분자인 경우 오른쪽으로 이동한다.
			// 오른쪽으로 이동하는 것은 분모가 1 커지는 것과 같다.
			if (bunmo >= bunja) {
				// 1번 이동을 했으니 cnt++
				// 이동한 후 분모에 1을 더해준다.
				cnt++;
				bunmo++;

				// 이동했을 때 cnt와 x가 같다면 출력
				if (cnt == x) {
					System.out.println(bunja + "/" + bunmo);
					break;
				}

				// 분모>=분자인 경우, 분모가 1이 될 때 까지 반복
				while (bunmo != 1) {
					// 분모에는 1을 빼고 분자에는 1을 더한다.
					bunmo--;
					bunja++;
					// 이동했으니 cnt++
					cnt++;
					// cnt와 x값이 같다면 출력
					if (cnt == x) {
						System.out.println(bunja + "/" + bunmo);
						break;
					}
				}
			}

			// 분모 < 분자인 경우 아랫쪽으로 이동한다.
			// 아랫쪽으로 이동하는 것은 분자가 1 커지는 것과 같다.
			else {
				// 1번 이동을 했으니 cnt++
				// 이동한 후 분자에 1을 더해준다.
				cnt++;
				bunja++;
				if (cnt == x) {
					System.out.println(bunja + "/" + bunmo);
					break;
				}

				// 분모<분자인 경우, 분자가 1이 될 때 까지 반복
				while (bunja != 1) {
					// 분모에는 1을 더해주고, 분자에는 1을 빼준다.
					bunmo++;
					bunja--;
					// 이동했으니 cnt++
					cnt++;
					// cnt와 x값이 같다면 출력
					if (cnt == x) {
						System.out.println(bunja + "/" + bunmo);
						break;
					}
				}

			}

		}

	}
}
