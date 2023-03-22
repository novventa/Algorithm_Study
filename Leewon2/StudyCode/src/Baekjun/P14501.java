/* 문제
* 백준이는 퇴사하려고 한다.
* 오늘부터 N+1일째 되는 날 퇴사하는데, 남은 N일 동안 최대한 많은 상담을 하려고 한다.
* 상담을 완료하는데 걸리는 기간 T와 받을 수 있는 금액 P가 주어졌을 때,
* 백준이가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성해보자.
* 
* 
* 문제 조건
* N은 1이상 15 이하다.
* 상담을 완료하는데 걸리는 기간 T는 1 이상 5 이하다.
* 받을 수 있는 금액 P는 1 이상 1000 이하다.
* 만약 마지막 날의 T가 2 라면, N+1일에 일이 끝이나므로, 마지막날의 일은 못한다.
* 백준이는 N+1일에 퇴사해야 하기 때문에, N일째 되는날 까지만 일을 한다.
* 1은 하루만에 끝나므로 가능하다
* 
* 
* 문제 해결 방법
* 부분집합을 이용하여 제한된 범위 내에서 가능한 모든 경우의 수를 확인해보자.
* 
* 
*/

package Baekjun;

import java.util.Scanner;

public class P14501 {
	static int[] workingDay;
	static int[] pay;
	static boolean[] check;
	static int day;
	static int sumDay;
	static int sumPay;
	static int maxPay;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// day일 까지만 일을 한다!
		day = sc.nextInt();

		// 방문체크를 하기 위해 boolean 배열을 만들자.
		check = new boolean[day];
		workingDay = new int[day];
		pay = new int[day];

		// 걸리는 일 수와 받을 수 있는 금액을 입력 받자.
		for (int i = 0; i < day; i++) {
			workingDay[i] = sc.nextInt();
			pay[i] = sc.nextInt();
		}

		recursion(0);
		System.out.println(maxPay);

	}

	// 부분 조합을 이용하여 workingDay가 day를 넘지 않도록 코드를 짜보자.
	public static void recursion(int idx) {

		// 기저조건
		// idx와 day가 같아진다는 것은 하나의 부분조합이 완성되었으므로 판단을 해보자.
		if (idx == day) {
			for (int i = 0; i < day; i++) {

				// true로 올라온 것 들의 day와 pay를 더해야겠지??
				if (check[i]) {

					// i랑 workingDay[i] -1 이 day보다 크거나 같다는 말은,
					// day가 7일이고, i가 5일인데, 5일째에 총 10일이 걸리는 일을 맡았다면?
					// 해결할 수 없으므로 break를 한다.
					if (i + workingDay[i] - 1 >= day)
						break;

					// 그 외의 경우는 pay와 day를 각각 더해서 저장하자.
					sumPay += pay[i];
					sumDay += workingDay[i];

					// i는 workingDay만큼 이동해야한다.
					i += workingDay[i] - 1;
				}

			}
			// pay의 최댓값을 찾아서 저장하자.
			if (sumDay <= day) {
				maxPay = Math.max(maxPay, sumPay);
			}

			// sumPay와 sumDay를 0으로 초기화 시키자.
			sumPay = sumDay = 0;
			return;
		}

		// 나를 사용하고,
		check[idx] = true;
		// 다음을 확인하러 가보자.
		recursion(idx + 1);
		// 나를 사용하지 않고
		check[idx] = false;
		// 다음을 확인하러 가보자.
		recursion(idx + 1);

	}
}