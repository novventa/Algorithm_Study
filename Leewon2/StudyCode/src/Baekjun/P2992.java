/* 문제
 * 정수 X가 주어졌을 때, X와 구성이 같으면서 X보다 큰 수 중 가장 작은 수를 출력해보자.
 * 구성이 같다는 것은, 각 자리수가 같다는 것이다.
 * 예를 들어, 123과 321은 구성이 같지만, 123과 432, 123과 1234는 구성이 다르다.
 * 
 * 
 * 
 * 조건
 * X는 1 이상 100만-1 이하다.
 * 
 * 
 * 
 * 아이디어
 * 최솟값을 저장할 변수 min에 INF를 저장한다.
 * 주어지는 수를 문자열로 입력 받은 후 char로 변환시키고 숫자 형태로 배열에 저장해보자.
 * 순열을 이용해 가능한 모든 경우의 수를 확인해보자.
 * 자기 자신보다 작은 수를 min 값에 저장하고 출력해보자.
 * min값이 INF라면, 0을 출력해보자.
 * 
 */

package Baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class P2992 {

	// X : 주어지는 숫자를 문자열로 입력 받을 변수
	static String X;

	// arr : 문자열을 char형으로 변환 후 숫자 형태로 저장할 배열
	static int[] arr;

	// result : 완성된 순열을 저장할 배열
	static int[] result;

	// check : 순열을 만들 때 사용여부를 판단할 boolean 배열
	static boolean[] check;

	// min : 최소값을 저장할 변수
	static int min;

	// INF : 매우 큰 정수를 저장할 변수
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 주어지는 숫자를 문자열로 입력 받는다.
		X = sc.next();

		// static 영역에서 선언한 변수들을 초기화 시키자.
		// arr/result/check의 크기를 문자열의 길이로 한다.
		arr = new int[X.length()];
		check = new boolean[X.length()];
		result = new int[X.length()];
		// min에는 INF 값을 저장하자.
		min = INF;

		// arr에 숫자를 저장하자.
		for (int i = 0; i < X.length(); i++) {
			// Character.getNumericValue : char to Int
			// String.charAt : String to Char
			arr[i] = Character.getNumericValue(X.charAt(i));
		}
		permutation(0);

		// 삼항 연산자를 이용해 출력해보자.
		System.out.println((min < INF) ? min : 0);

	}

	// 순열 메서드를 만들어보자.
	public static void permutation(int idx) {
		// 기저조건
		// 순열을 완성했다면
		if (idx == result.length) {
			String sum = "";
			// 반복문을 이용해 숫자를 문자열로 저장해보자.
			for (int i = 0; i < result.length; i++) {
				sum += Integer.toString(result[i]);
			}
			// sum을 다시 숫자로 변환하자.
			// Integer.pareInt : Int to String
			int compare = Integer.parseInt(sum);
			// 순열로 얻은 값이 기존 X보다 크다면
			if (compare > Integer.parseInt(X)) {
				// 최소값을 갱신하자.
				min = Math.min(compare, min);
			}

			return;
		}

		// 재귀조건
		for (int i = 0; i < arr.length; i++) {
			if (!check[i]) {
				check[i] = true;
				result[idx] = arr[i];
				permutation(idx + 1);
				check[i] = false;
			}
		}

	}

}
