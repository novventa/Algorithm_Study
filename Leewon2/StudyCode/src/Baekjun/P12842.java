/* 문제
 * 튀김소보루 n개와 회원의 수 m명이 있다.
 * m명의 사람들은 각각 x초마다 하나씩 집어 먹는다.
 * s는 영선이가 돌아왔을 때 남아 있던 튀김 소보루의 개수일 때,
 * 마지막으로 소보루를 집어 든 사람의 번호를 출력해보자.
 * 
 * 
 * 조건
 * 소보루의 갯수 n 은 1 이상 10만 이하의 자연수이다.
 * 남은 소보루의 개수 s 는 0 이상 n-1개 이다.
 * 사람의 수 m은 1 이상 10만 이하의 자연수이다.
 * 빵을 먹는 속도 t는 1 이상 1000 이하이다.
 * 
 * 
 * 아이디어
 * 사람들이 소보루를 먹은 갯수를 구하자.
 * 소보루를 먹은 갯수는 n-s가 된다.
 * 첫번째는 m만큼의 사람이 모두 한개씩 집는다.
 * n-s가 m보다 작다면 첫번째에 모두 먹은것이다.
 * 그렇지 않다면 2중 for문을 이용해 1초가 지난 후 집을 수 있는 사람이 있다면 cnt를 늘려보자.
 * 
 * 
 */

package Baekjun;

import java.util.Scanner;

public class P12842 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 사온 소보로의 갯수
		int n = sc.nextInt();

		// 남은 소보로의 갯수
		int s = sc.nextInt();

		// 먹은 소보로의 갯수
		int ate = n - s;

		// m명의 사람 입력
		int m = sc.nextInt();

		// m 명의 사람이 소보로를 먹는데 걸리는 시간을 담을 배열
		int[] arr = new int[m + 1];

		// 배열에 값을 입력 받자.
		for (int i = 1; i <= m; i++) {
			arr[i] = sc.nextInt();
		}

		StringBuilder sb = new StringBuilder();

		// 시간초를 셀 변수
		int time = 1;

		// 남은 소보로의 갯수가 사람의 수보다 작거나 같다면
		if (ate <= m) {
			// n-s를 저장
			sb.append(ate);
		}

		// 그렇지 않다면
		else {
			ate -= m;
			// 브루트포스 이용
			// 무한 반복하고
			outer: while (true) {
				// m명의 사람들을 모두 확인해보자.
				for (int i = 1; i <= m; i++) {
					// time을 각각의 시간초로 나누었을 때 나머지가 0이라면
					if (time % arr[i] == 0) {
						// 남은 갯수를 하나 줄이자.
						ate--;
						// 남은 갯수가 0이 된다면
						if (ate == 0) {
							// sb에 저장하고 반복문을 탈출하자.
							sb.append(i);
							break outer;
						}
					}
				}
				// for문이 끝나면 시간초를 하나 늘린다.
				time++;
			}
		}

		System.out.println(sb);

	}
}
