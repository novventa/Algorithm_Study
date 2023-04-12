/* 문제
 * Hamming Distance란 길이가 같은 두 DNA가 있을 때, 각 위치의 문자가 다른 것의 개수이다. 
 * 예를 들어 AGCAT와 GGAAT는 첫 번째 글자와 세 번째 글자가 다르므로 Hamming Distance는 2이다.
 * DNA의 수 N과 문자열의 길이 M이 주어질 때, 
 * Hamming Distance의 합이 가장 작은 DNA를 구하고 Hamming Distance의 합을 구해보자.
 * 
 * 
 * 
 * 조건
 * DNA의 수 N은 1 이상 1000 이하다.
 * 문자열의 길이 M은 1 이상 50 이하다.
 * Hamming Distance의 합이 같은 DNA가 여러 개 있을 때는 사전순으로 가장 앞에 있는 것을 출력한다.
 * 
 * 
 * 
 * 아이디어
 * Hamming Distance의 합이 최소가 되기 위해서는
 * 각 열마다 가장 많이 들어있는 문자가 무엇인지 알아내야 한다.
 * 
 * 주어지는 입력을 char형태로 입력 받아서 2차원 배열에 저장한다.
 * A, C, G, T 총 4개의 문자가 존재하므로, 4 크기의 INT 배열을 만든다.
 * A=0, C=1, G=2, T=3으로 생각하고, 열 순회를 하며 A가 나오면 0번 인덱스를 늘리고,
 * C가 나오면 1번 인덱스를 늘리는 과정을 반복해보자.
 * 열에 저장된 문자에 따라 index를 늘려 가장 많이 들어있는 문자를 찾는다.
 * 
 * 가장 많이 들어있는 문자를 찾으면, HashMap을 이용해 인덱스 번호에 따라 result 배열에 더해준다. 
 * 열 순회를 마치면 result 배열에는 DNA의 정보가 들어있다.
 * 이제 행 순회를 하며 DNA의 정보와 일치하지 않는 문자가 몇개인지 세어보자.
 * 
 */

package Baekjun;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class P1969 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// HashMap을 이용하여 인덱스 번호에 맞는 문자열을 저장하자.
		HashMap<Integer, Character> hash = new HashMap<>();
		hash.put(0, 'A');
		hash.put(1, 'C');
		hash.put(2, 'G');
		hash.put(3, 'T');

		// DNA의 수
		int N = sc.nextInt();

		// 문자열의 길이
		int M = sc.nextInt();

		// 입력받을 N*M 크기의 2차원 배열
		char[][] arr = new char[N][M];

		// DNA를 저장할 char 배열
		char[] result = new char[M];

		// 정답을 담을 문자열
		String ans = "";

		// char형태로 입력 받자.
		for (int row = 0; row < N; row++) {
			String str = sc.next();
			for (int col = 0; col < M; col++) {
				arr[row][col] = str.charAt(col);
			}
		}

		for (int col = 0; col < M; col++) {
			// A, C, G, T순
			// compare 배열 초기화
			int[] compare = new int[4];

			// switch case문을 이용해
			// A,C,G,T인 경우에 compare배열의 인덱스에 값을 추가한다.
			for (int row = 0; row < N; row++) {
				switch (arr[row][col]) {
				case 'A':
					compare[0]++;
					break;
				case 'C':
					compare[1]++;
					break;
				case 'G':
					compare[2]++;
					break;
				case 'T':
					compare[3]++;
					break;
				}
			}

			// 최대값과 최대값의 인덱스를 0으로 초기화
			int max = 0;
			int maxIdx = 0;

			// 1개의 열 순회 후 max값을 찾아보자.
			for (int i = 0; i < 4; i++) {
				if (compare[i] > max) {
					max = compare[i];
					maxIdx = i;
				}
			}
			// 최대값이 들어있는 인덱스를 찾았으면, result 배열에 저장한다.
			result[col] = hash.get(maxIdx);
		}

		// DNA를 구했으니, 비교해서 몇개가 다른지 세보자.
		int cnt = 0;
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				if (arr[row][col] != result[col])
					cnt++;
			}
		}

		// ans 문자열에 정답을 담자.
		for (int i = 0; i < M; i++) {
			ans += result[i];
		}
		System.out.println(ans);
		System.out.println(cnt);

	}
}
