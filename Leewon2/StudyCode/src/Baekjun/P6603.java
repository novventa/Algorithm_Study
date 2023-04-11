/* 문제
 * 로또 번호를 선택하는데, 49가지 수 중 k개의 수를 골라 집합 S를 만든 다음
 * 그 수를 가지고 번호를 선택한다. 이때, 수를 고르는 모든 방법을 구하는 프로그램을 작성해보자.
 * 예를 들어, k = 7, S = {1,2,5,6,7,8,9}가 될 수 있고 
 * 1 2 3 4 5 6 
 * 1 2 3 4 5 7 
 * 1 2 3 4 6 7 
 * 1 2 3 5 6 7 
 * 1 2 4 5 6 7 
 * 1 3 4 5 6 7 
 * 2 3 4 5 6 7로 총 7가지의 경우의 수를 출력할 수 있다.
 * 
 * 
 * 조건
 * k는 7이상 12이하인 수다.
 * S의 원소는 오름차순으로 주어진다.
 * 입력의 마지막에는 0이 주어진다.
 * 
 * 
 * 아이디어
 * 조합을 이용해 모든 경우의 수를 출력해보자.
 * 
 */

package Baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class P6603 {

	// k : k개의 수
	static int k;

	// check : 조합을 만들 때 사용여부를 판단할 boolean 타입의 배열
	static boolean[] check;

	// arr : 집합 S를 저장할 배열
	static int[] arr;

	// result : 완성된 조합을 저장할 배열
	static int[] result;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 몇 번의 입력이 주어질지 모르므로 무한 반복을 이용하자.
		while (true) {

			// k를 입력 받고 0이 입력된다면 반복문을 빠져나가자.
			k = sc.nextInt();
			if (k == 0)
				break;

			// static 영역에서 선언한 변수들을 모두 초기화 시키자.
			check = new boolean[k];
			arr = new int[k];
			result = new int[6];

			// 집합 S를 입력 받자.
			for (int i = 0; i < k; i++) {
				arr[i] = sc.nextInt();
			}

			// 재귀함수 호출 후 개행을 한다.ㄴ
			recursion(0, 0);
			System.out.println();
		}
	}

	// 조합을 짜는 메서드를 만들어보자.
	public static void recursion(int idx, int start) {

		// 기저조건
		// 6개의 수를 고른 후 출력해야 하므로,
		// idx가 6이 될 때 조건에 맞춰 출력해보자.
		if (idx == 6) {

			// 완성된 조합이 저장된 배열에서 출력해보자.
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}

		// 조합을 작성해보자.
		// 순열이 아니므로, (1,2)와 (2,1)은 같은 의미 이므로,
		// i가 다시 0부터 시작할 필요 없이 start 부터 시작한다.
		for (int i = start; i < k; i++) {

			// 방문체크가 되어있지 않다면,
			if (!check[i]) {
				// 조합 배열에 저장하자.
				result[idx] = arr[i];
			}
			// 방문체크 후
			check[i] = true;
			// 다음을 확인하러 가보자.
			recursion(idx + 1, i + 1);
			// 사용 후 방문체크를 해제해주자.
			check[i] = false;
		}
	}
}