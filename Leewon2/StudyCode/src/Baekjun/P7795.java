/* 문제
 * 두 종류의 생명체 A와 B가 존재하고 A는 B가 자신보다 작다면 B를 먹는다.
 * 예를 들어, A가 {1,2,3}이고, B가 {1,2}라면, A가 B를 먹을 수 있는 쌍의 갯수는
 * (3-2) (3-1) (2-1)로 3가지가 있다.
 * A와 B의 크기가 주어졌을 때, A의 크기가 B보다 큰 쌍이 몇개나 있는지 구해보자.
 * 
 * 
 * 
 * 조건
 * A와 B의 크기는 1 이상 20000 이하다.
 * 
 * 
 * 
 * 아이디어
 * A배열과 B배열을 만들고 A와 B의 정보를 담는다.
 * A와 B를 오름차순으로 정렬하고,
 * A와 B를 비교한다. A가 크다면, cnt를 하나 늘리고 다음 B와 비교한다.
 * 크기를 오름차순으로 정렬하므로 A가 B보다 작거나 같아지는 순간에는 break하자.
 * 
 */

package Baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class P7795 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// testcase 입력 받고
		int testcase = sc.nextInt();

		// testcase동안 반복해보자.
		for (int tc = 0; tc < testcase; tc++) {
			// A,B를 입력 받자.
			int A = sc.nextInt();
			int B = sc.nextInt();

			// A크기, B크기로 배열 2개를 만들자.
			int[] arrA = new int[A];
			int[] arrB = new int[B];

			// 배열에 값을 담자.
			for (int i = 0; i < A; i++) {
				arrA[i] = sc.nextInt();
			}
			for (int i = 0; i < B; i++) {
				arrB[i] = sc.nextInt();
			}

			// 오름차순으로 정렬한다.
			Arrays.sort(arrA);
			Arrays.sort(arrB);

			// 자신보다 작은 숫자를 세어줄 변수를 만든다.
			int cnt = 0;

			// 2중 for문을 이용해 두 값을 비교해보자.
			// 오름차순으로 정렬했으므로, 만약 a가 b보다 작다면,
			// 다음 값 부터는 볼 필요도 없이 a가 b보다 작으므로 break 하자.
			for (int a = 0; a < A; a++) {
				for (int b = 0; b < B; b++) {
					if (arrA[a] > arrB[b])
						cnt++;
					else
						break;
				}
			}
			System.out.println(cnt);

		}
	}
}