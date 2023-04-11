/* 문제
 * 문제를 변환하여 답을 구해보자.
 * 예를 들어 3의 배수를 구하고 싶은데, 1107 이 있다면, 각 자릿수의 합을 먼저 구한다
 * 1+1+0+7 = 9 이고, 9는 3의 배수이므로, 1107 또한 3의 배수이다.
 * 알고 있는 3의 배수가 한 자리 수 밖에 없다고 가정하자.
 * 위와 같이 문제를 변환시켜서 해결하고자 할 때, 
 * 몇 번의 과정을 거쳐야 3의 배수인지 아닌지 구하는 프로그램을 작성해보자. 
 * 
 * 
 * 조건
 * 자연수 X는 백반 이하이고, 숫자는 0으로 시작하지 않는다.
 * 
 * 
 * 아이디어
 * 주어지는 숫자를 int가 아닌 String 형태로 받아보자.
 * String 형태로 받은 후 각 자릿수를 char형태로 바꾼다.
 * char 형태로 바꾼 후 문자 0 을 빼면 숫자가 된다.
 * X가 한자리 수가 된다면, 3의 배수인지 아닌지 판별하고
 * 한자리수가 아니라면 각 자릿수를 더해서 넘겨주자.
 * 
 * 
 */

package Baekjun;

import java.util.Scanner;

public class P1769 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 숫자 N을 문자열로 입력 받는다.
		String N = sc.next();

		// 몇 번의 변환을 거쳤는지 저장할 변수를 만들자.
		int cnt = 0;

		// 각 자릿수의 합을 저장할 변수를 만들자.
		int sum = 0;

		// 문자열의 길이가 1이 될 때 까지 반복할거다.
		while (true) {

			// 각 자릿수의 합을 저장하는 변수를 0으로 초기화 시키자.
			sum = 0;

			// 문자열의 길이가 1이라면,
			if (N.length() == 1) {

				// 변환 횟수를 출력하고, 3의 배수라면 YES를, 아니라면 NO를 출력하자.
				System.out.println(cnt);
				if ((N.charAt(0) - '0') % 3 == 0) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
				break;
			}

			// 자릿수가 1이 아니라면
			else {
				// 각 자릿수의 합을 구해야하므로, 범위는 N의 길이가 된다.
				for (int i = 0; i < N.length(); i++) {
					// 각 자릿수을 char형태로 변환 후 문자 0을 빼서 sum에 더하자.
					// 반복문이 끝나면, sum에는 각 자릿수의 합이 저장된다.
					sum += N.charAt(i) - '0';
				}
				// 한 번 변환 했으니 변환 횟수를 늘리자.
				cnt++;

				// 위의 과정에서 N은 아무런 변화가 없었다.
				// 각 자릿수의 합을 다시 N에 저장해야 하는데,
				// 각 자릿수의 합은 sum 변수에 저장되어 있다.
				// sum 변수는 int 타입 이므로, String 타입으로 변환 후 N에 저장하자.
				N = Integer.toString(sum);
			}
		}

	}
}
