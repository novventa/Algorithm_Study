// 문제
// 딱지에는 별(4), 동그라미(3), 네모(2), 세모(1)이 있다.
// 별의 갯수가 많은쪽이, 같다면 동그라미가 많은쪽이 이긴다.
// 동그라미가 같으면 네모를 비교하고, 네모도 같다면 세모를 비교한다.
// A가 이겼다면 A를, B가 이겼다면 B를, 비겼다면 D를 출력하자.

// 문제 조건
// 총 라운드 수를 나타내는 N은 1이상 1000 이하다.
// A와 B가 내는 그림의 총 개수 a,b개는 1 이상 100 이하다.

// 문제 해결 방법
// 해시맵을 이용하여, 1은 1, 2는 101, 3은 10101, 4는 1010101를 저장한다.
// 2가 1개고 1이 100개면 1*100 = 100 으로 값은 같지만, 2가 1개 있는쪽이 이기므로 1을 더한 수를 저장하는 것이다.
// 값을 모두 더해서 더 큰 쪽을 출력하자. 같다면 D를 출력하자.
// 1. 해시맵을 이용하여, 1,2,3,4에대한 key, value값을 저장한다.
// 2. 총 라운드 수 N을 입력 받는다.
// 3. N번동안 A가 내는 딱지의 갯수 a와 a개의 숫자를,
// B가 내는 딱지의 갯수 b와 b개의 숫자를 입력 받는다.
// 4. a개, b개의 숫자의 합을 저장할 변수 aSum, bSum을 만든다.
// 5. aSum과 bSum에 숫자들의 합을 저장하고 비교한다.

package 수학1;

import java.util.HashMap;
import java.util.Scanner;

public class P14696 {
	public static void main(String[] args) {

		// 해시맵에 1,2,3,4에 대한 정보를 저장하자.
		HashMap<Character, Integer> hash = new HashMap<>();
		hash.put('1', 1);
		hash.put('2', 101);
		hash.put('3', 10101);
		hash.put('4', 1010101);

		Scanner sc = new Scanner(System.in);

		// 총 라운드 수 N을 입력받자.
		int N = sc.nextInt();

		// N번동안 A가 내는 딱지의 갯수 a와 a개의 숫자를,
		// B가 내는 딱지의 갯수 b와 b개의 숫자를 입력 받는다.
		for (int idx = 0; idx < N; idx++) {

			// a개, b개의 숫자의 합을 저장할 변수를 만든다.
			double aSum = 0;
			double bSum = 0;

			// 배열에 값을 입력 받으면서
			// aSum과 bSum에 숫자들의 합을 저장한다.

			// A가 내는 딱지의 갯수를 입력 받고
			int aCnt = sc.nextInt();
			// 딱지의 갯수 크기만큼의 배열을 만든다.
			char[] aArr = new char[aCnt];
			// 배열에 a개의 숫자를 넣어보자.
			for (int i = 0; i < aCnt; i++) {
				aArr[i] = sc.next().charAt(0);
				aSum += hash.get(aArr[i]);
			}

			// B가 내는 딱지의 갯수를 입력 받고
			int bCnt = sc.nextInt();
			// 딱지의 갯수 크기만큼의 배열을 만든다.
			char[] bArr = new char[bCnt];
			// 배열에 b개의 숫자를 넣어보자.
			for (int i = 0; i < bCnt; i++) {
				bArr[i] = sc.next().charAt(0);
				bSum += hash.get(bArr[i]);
			}
			if (aSum > bSum) {
				System.out.println('A');
			} else if (aSum < bSum) {
				System.out.println('B');
			} else {
				System.out.println('D');
			}

		}

	}
}
