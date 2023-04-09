/* 문제
 * 여러 사람들에 대한 부모 자식들 간의 관계다 주어졌을 때,
 * 주어진 두 사람의 촌수를 계산하는 프로그램을 작성해보자.
 * 
 * 
 * 
 * 조건
 * 사람의 수 n은 1 이상 100 이하다.
 * 부모 자식간의 관계를 나타내는 두 번호 x,y중 x는 부모, y는 자식을 의미한다.
 * 각 사람의 부모는 최대 한 명만 주어진다.
 * 촌수가 없다면 -1을 출력하자.
 * 
 * 
 * 
 * 아이디어
 * dfs를 이용해 해결해보자.
 * 문제에서 주어지는 부모와 자식간의 관계는 사실상 의미가 없으므로 양방향으로 생각하자.
 * 입력에서 요구한 두 사람의 번호 중 하나의 번호부터 시작한다.
 * 1. 반복문을 돌며 번호와 연결되어 있는 다른 번호로 간다.
 * 2. 1번 과정을 반복하고, 연결되어 있는 번호가 없다면 return하여 돌아간다.
 * 3. return후 다시 번호와 연결되어 있는지 확인한다.
 * 4. 부모는 최대 1명이므로, 한 번호에서 다른 번호로 갈 수 있는 최대 루트는 1가지 뿐이다.
 * 5. 탐색할 곳이 없고, 찾지도 못했다면, -1을 출력하자.
 * 
 */

package Baekjun;

import java.util.Scanner;

import javax.security.sasl.RealmCallback;

public class P2644 {

	// n : 사람의 수
	static int n;

	// arr : 관계를 저장하기 위해 2차원 배열
	static int[][] arr;

	// x,y : 촌수를 구해야할 두 수
	static int x;
	static int y;

	// check : 방문여부를 체크할 변수
	static boolean[] check;

	// realation : 촌수를 저장할 변수
	static int relation;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 사람의 수 n을 입력 받자.
		n = sc.nextInt();

		// 관계를 저장하기 위해 n+1 크기의 2차원 배열을 입력 받는다.
		arr = new int[n + 1][n + 1];

		// 방문 여부를 체크할 배열의 크기를 n+1로 한다.
		check = new boolean[n + 1];

		// 촌수를 계산해야 하는 서로 다른 두 사람의 번호를 입력 받는다.
		x = sc.nextInt();
		y = sc.nextInt();

		// 부모 자식들 간의 관계 m을 입력 받는다.
		int m = sc.nextInt();

		// 부모 자식들 간의 관계를 입력 받자.
		for (int i = 0; i < m; i++) {
			int left = sc.nextInt();
			int right = sc.nextInt();
			// 서로 연결되어 있음을 확인하기 위해 1을 저장하자.
			arr[left][right] = 1;
			arr[right][left] = 1;
		}

		// 촌수를 -1로 해놓자.
		relation = -1;

		// 시작점은 true로 바꾸자.
		check[x] = true;

		// dfs 수행
		dfs(x, 1);
		System.out.println(relation);
	}

	// 깊이우선탐색을 진행해보자.
	// 파라미터 값으로는 시작점과 촌수를 계산할 cnt를 저장한다.
	public static void dfs(int start, int cnt) {
		for (int i = 1; i < n + 1; i++) {
			// 자신과 연결되어 있는 곳으로 가보자.
			if (!check[i] && arr[start][i] == 1) {

				// 들렸으니 방문체크 하자.
				check[i] = true;
				// y를 찾았으면 relation에 cnt를 저장하자.
				if (i == y) {
					relation = cnt;
				}
				// y가 아닌 다른 번호라면?
				// 다시 자신과 연결된 번호로 가보자.
				else {
					dfs(i, cnt + 1);
				}
			}
		}
	}
}
