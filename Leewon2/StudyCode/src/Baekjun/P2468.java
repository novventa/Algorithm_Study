/* 문제
 * 지역의 높이가 적혀있는 N*N 크기의 2차원 배열이 주어진다.
 * 장마철에 비가 내리는 양이 x라고 했을 때, 높이가 x이하인 지역은 모두 물에 잠긴다.
 * 비의 양에 따른 모든 경우를 다 조사해 본다.
 * 이때, 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 구해보자.
 * 안전한 영역은 물에 잠기지 않는 지점들이 위,아래,오른쪽,왼쪽으로 인접해 있으며 그 크기가 최대인 영역을 말한다. 
 * 
 * 
 * 
 * 조건
 * N은 2 이상 100 이하의 정수다.
 * 높이는 1 이상 100 이하의 정수다.
 * 
 * 
 * 
 * 아이디어
 * 브루트포스를 이용해 모든 경우의 수를 탐색해보자.
 * 높이가 10,20,30,40,50과 같이 뒤죽박죽으로 있을 때, 비의 양이 1부터 50까지 모두 탐색하지 않고,
 * 10, 20, 30 순으로 탐색할 수 있도록 하기 위해 높이 값 정보를 중복되지 않게 배열에 저장해놓자.
 * 
 * ### 비의 양 ###
 * 1. 비의양 = 높이가 저장되어 있는 배열의 크기만큼 반복한다.
 * 
 * ### 완전탐색 ###
 * 2. 방문체크가 되어있지 않은 곳을 시작점으로 잡는다.
 * 3-1. 시작점과 연결되어있고 잠겨있지 않은 곳들은 모두 방문표시를 한다.
 * 3-2. 잠겨있는 곳을 매번 방문표시를 하면 메모리 차지가 심하므로,
 * i(비의양)보다 크고, 방문체크되지 않은 곳을 방문한다.
 * 4. 방문이 모두 끝나면 하나의 영역을 찾은 것이므로 cnt를 하나 늘려준다.
 * 5. 배열을 모두 탐색하고, cnt와 max값을 비교한다.
 * 
 */

package Baekjun;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P2468 {

	// N : 지역의 크기
	static int N;

	// arr : 지역의 높이를 저장핼 2차원 int 배열
	static int[][] arr;

	// check : 방문여부를 체크할 2차원 boolean 배열
	static boolean[][] check;

	// height : 높이 정보를 저장할 배열
	static int[] height;

	// cnt : 영역의 갯수를 셀 변수
	static int cnt;

	// maxCnt : 영역의 갯수가 최대인 수를 저장할 변수
	static int maxCnt;

	// 델타배열
	static final int[] dr = { 1, -1, 0, 0 };
	static final int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		// 배열의 크기를 정하자.
		arr = new int[N][N];

		// 배열에 값을 입력 받자.
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				arr[row][col] = sc.nextInt();

				// 우선순위 큐에 값이 저장되어 있지 않다면 값을 저장해주자.
				if (!pq.contains(arr[row][col]))
					pq.offer(arr[row][col]);

			}
		}

		// 높이 정보를 배열로 옮겨보자.
		height = new int[pq.size()];
		int idx = 0;
		while (!pq.isEmpty()) {
			height[idx++] = pq.poll();
		}

		// 높이가 모두 1인경우는 고려하지 않았으므로 maxCnt에 1을 저장한다.
		maxCnt = 1;

		for (int i = 0; i < height.length; i++) {
			// 방문체크를 초기화 시키자.
			check = new boolean[N][N];
			cnt = 0;

			// 부르트포스를 이용해보자.
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					// 높이보다 작고, 방문체크가 되어있지 않은 곳만 시작점이 될 수 있다.
					if (!check[row][col] && arr[row][col] > height[i]) {
						check[row][col] = true;
						dfs(row, col, height[i]);
						// 수행이 끝났다면 영역을 하나 찾은 것이므로 cnt를 하나 늘리자.
						cnt++;
					}
				}
			}

			// 최대값을 갱신하자.
			maxCnt = Math.max(maxCnt, cnt);
		}
		System.out.println(maxCnt);

	}

	// dfs를 이용해 연결되어 있는 모든 점을 방문체크하자.
	private static void dfs(int row, int col, int height) {

		// 델타배열을 이용해 사방탐색을 진행해보자.
		for (int dir = 0; dir < dr.length; dir++) {
			int newR = row + dr[dir];
			int newC = col + dc[dir];

			// 범위를 벗어나는 경우 continue 해주자.
			if (newR < 0 || newC < 0 || newR >= N || newC >= N || arr[newR][newC] <= height) {
				continue;
			}
			// 범위를 벗어나지 않고, 방문표시가 되어있지 않은 곳은
			// 방문표시를 해주자.
			if (!check[newR][newC]) {
				check[newR][newC] = true;
				// 방문표시 후 다시 연결되어 있는 점이 있는지 확인하자.
				dfs(newR, newC, height);
			}
		}
	}
}
