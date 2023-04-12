/* 문제
 * 세준이는 양수, +, -, 괄호를 가지고 식을 만든 후 괄호를 모두 지웠다.
 * 그리고 나서 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
 * 이 식의 값을 최소로 만드는 프로그램을 작성해보자.
 * 
 * 
 * 
 * 조건
 * 식은 '0~9', '+', '-'로만 이루어져 있다.
 * 처음과 마지막 문자는 숫자이다.
 * 두 개 이상의 연산자가 연속되게 나타나지 않는다.
 * 5자리보다 많이 연속되는 숫자는 없다.
 * 수는 0으로 시작할 수 있다.
 * 입력으로 주어지는 식의 길이는 50 이하다.
 * 
 * 
 * 
 * 아이디어
 * 값이 최소가 되기 위해서는, +값은 모두 묶어보자.
 * 예를 들어 55+40-50+40-15+35+20-10인 경우 (55+40) - (50+40) - (15+35+20) - 10이 된다.
 * 이 식을 분배법칙을 이용해 바꿔보면, 55-50-40-15-35-20-10이 된다.
 * 여기서 규칙은, 문자열에 -기호가 하나라도 있으면, 첫번째 - 기호가 나오기 전까지 모두 더한다.
 * 첫번째 - 기호가 나오기 전까지 모두 더한 값을 큐에 넣는다. 다음으로는 모든 수를 큐에 넣고,
 * 첫번째 값에서 빼내서 모두 빼면 된다.
 * 
 * - 기호가 하나도 없으면 모든 값을 더하면 된다.
 * 
 * 문자열 형태로 입력 받은 후 char 형태로 바꿔서 저장하자.
 * char 형태로 저장한 배열을 다시 int 타입으로 바꾸자.
 * 반복문을 이용해 int 배열을 돌면서 - 기호가 나오기 전까지 sum에 더한다.
 * - 기호가 나오면, sum을 큐에 추가하고, sum을 초기화 시킨다.
 * 다음으로는 모두 큐에 넣는다.
 * 큐의 맨 앞의 값에서 모든 값을 빼보자.
 * 
 * 
 * 아이디어 요약
 * 빼기(-) 기호가 하나라도 있으면, 처음으로 - 기호가 나오기 전까지 모두 더한 후 큐에 넣는다.
 * - 기호가 나온 후로는 모두 큐에 담는다.
 * 큐의 첫번째 값에서 모든 값을 빼준다.
 * 
 * 빼기(-) 기호가 하나도 없으면 모든 값을 더하면 된다.
 * 
 */

package Baekjun;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1541 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Queue<Integer> q = new LinkedList<>();

		// 문자열을 입력 받는다.
		String str = sc.next();

		// 숫자를 q에 저장하기 위해 num 변수를 선언한다.
		String num = "";

		char[] arr = new char[str.length()];
		// 문자열을 char 형태로 바꿔보자.
		for (int i = 0; i < arr.length; i++) {
			arr[i] = str.charAt(i);
			// -기호가 있다면 true로 바꾸자.
		}
		// char형을 int 배열로 바꿔보자. +는 -1로, -는 -2로 표현하자.
		int[] intArr = new int[arr.length + 1];
		int idx = 0;

		// int배열을 -100으로 채워놓자.
		Arrays.fill(intArr, -100);

		// 반복문을 이용해 INT 배열에 값을 채운다.
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '+') {
				// INT 배열에 값을 추가 후 num은 초기화 시킨다.
				intArr[idx++] = Integer.parseInt(num);
				num = "";
			} else if (arr[i] == '-') {
				intArr[idx++] = Integer.parseInt(num);
				num = "";
				intArr[idx++] = -2;
			} else {
				num += arr[i];
			}
		}

		// 마지막 값은 추가되지 않으므로 한번 추가시켜주자.
		intArr[idx] = Integer.parseInt(num);

		// -100이 나오기 전까지 반복해보자.
		// 첫번째로 - 가 나오는 순간을 기록하자.
		boolean findMinus = false;
		int sum = 0;
		for (int i = 0; i < intArr.length; i++) {

			// -100이 나오면 반복문을 빠져나오자.
			if (intArr[i] == -100) {
				// 반복문을 빠져나오기 전에
				// 모두 +인 경우 sum 값이 큐에 들어가있지 않으므로
				// -가 없는 경우에 q에 sum 값을 넣어주자.
				if (!findMinus) {
					q.offer(sum);
				}
				break;

			}

			// -100이 아닌 경우
			else {
				// 첫번째 -가 발견되지 않았고, 이번 값이 -라면
				// 첫번째 -를 발견한 것이므로
				if (!findMinus && intArr[i] == -2) {
					// q에 sum 값을 넣고,
					q.offer(sum);
					// minus 찾았다고 표시해주자.
					findMinus = true;
				}
				// 첫번째 - 값을 찾지 못했다면
				// sum에 값을 계속 더해주자.
				if (!findMinus)
					sum += intArr[i];

				// 첫번째 - 값을 찾았다면
				else {
					// - 기호는 -2로 표시되어 있으므로,
					// 값이 양수인 경우만 큐에 넣는다.
					if (intArr[i] >= 0) {
						q.offer(intArr[i]);
					}
				}
			}
		}

		// 첫번째 값을 큐에서 빼내고
		int result = q.poll();

		// 큐가 빌 때 까지 모두 빼보자.
		while (!q.isEmpty()) {
			result -= q.poll();
		}
		System.out.println(result);

	}
}
