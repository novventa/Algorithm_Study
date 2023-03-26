/* 문제
 * N명의 사람들이 축구를 하고자 한다. N은 짝수이고, N/2명으로 이루어진 스타트팀과 링크님으로 나뉜다.
 * N명에게는 능력치가 존재한다. 능력치는 i번째와 j번째 사람이 같은 팀 일 때 팀에 더해지는 능력치이다.
 * 즉 Sij+Sji이다. 축구를 재밌게 하기 위해 능력치의 차이가 최소가 되도록 프로그램을 짜보자.
 * 
 * 
 * 
 * 문제 조건
 * N은 4이상 20 이하인 수다.
 * 
 * 
 * 
 * 문제 해결 방법
 * 조합을 이용하여 N/2개를 뽑아보자.
 * 뽑힌 수에 적힌 값들과 안뽑힌 수들의 값들을 비교해보자.
 */

package Baekjun;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P14889 {

	// N : 축구를 하기 위해 모인 사람의 수
	static int N;

	// arr : 능력치를 저장할 배열
	static int[][] arr;

	// min : 최솟값을 저장할 변수
	static int min;

	// 스타트팀 배열과 링크팀의 배열
	static int[] startTeam;
	static int[] linkTeam;

	// 스타트팀과 링크팀의 능력치의 합을 저장할 변수
	static int sumStartTeam;
	static int sumLinkTeam;

	// 부분집합을 이용해 정보를 저장하고 능력치의 합을 구하기 위한 변수
	static int[] partitionStart;
	static int[] partitionLink;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 사람의 수 N을 입력 받자.
		N = sc.nextInt();

		// N*N크기의 배열을 만든다.
		arr = new int[N][N];

		// 스타트팀과 링크팀은 각각 N/2명의 사람이 들어가므로 N/2 크기로 배열을 만들자.
		startTeam = new int[N / 2];
		linkTeam = new int[N / 2];

		// for문을 이용해 배열에 값을 입력 받자.
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				arr[row][col] = sc.nextInt();
			}
		}

		// 스타팀과 링크팀의 조합을 뽑고, 그 조합을 이용해 능력치의 합을 구해야 한다.
		// 이때 새로운 조합을 만들어서 저장할 변수가 필요하다.
		partitionStart = new int[2];
		partitionLink = new int[2];

		// 최솟값에 max_value를 저장하자.
		min = Integer.MAX_VALUE;

		// 재귀함수를 호출
		combination(0, 0);

		// 최솟값을 출력하자.
		System.out.println(min);
	}

	public static void combination(int idx, int start) {

		// 기저조건
		// 조합 한개가 완성 된다면??
		int k = 0;
		if (idx == N / 2) {
			// q배열을 만들어서, 뽑힌 조합과 반대의 조합을 구해보자.
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < N / 2; i++) {
				// 큐에 startTeam의 정보를 저장해 놓자.
				q.offer(startTeam[i]);
			}

			// N까지 반복하면서 q에 들어있지 않다면,
			// startTeam에 없는 것이고, 이는 linkTeam 이므로, linkTeam 배열에 저장한다.
			for (int i = 0; i < N; i++) {
				if (!q.contains(i)) {
					// 반대의 조합을 만들자.
					linkTeam[k++] = i;
				}

			}

			// 만들어진 조합을 이용해 능력치의 합을 구해야 하는데,
			// 한번에 구할 수 없으므로 새로운 메소드를 만들어
			// 스타트팀과 링크팀의 능력치의 합을 구해보자.
			sumStart(0, 0);
			sumLink(0, 0);

			// 최솟값을 구해보고, 최솟값을 갱신하는 코드
			int re = Math.abs(sumLinkTeam - sumStartTeam);
			min = Math.min(re, min);

			// 스타트팀과 링크팀 능력치의 합을 0으로 초기화 시킨다.
			sumStartTeam = 0;
			sumLinkTeam = 0;

			// 큐 배열도 비우자.
			q.clear();

			return;
		}

		// 재귀조건
		// 조합을 뽑아보자.
		for (int i = start; i < N; i++) {
			startTeam[idx] = i;
			combination(idx + 1, i + 1);
		}

	}

	public static void sumStart(int idx, int start) {
		// 기저조건
		// 2개롤 뽑아서 능력치의 합을 구해보자.
		if (idx == 2) {
			sumStartTeam += arr[partitionStart[0]][partitionStart[1]];
			sumStartTeam += arr[partitionStart[1]][partitionStart[0]];

			return;
		}

		// 재귀조건
		// 조합을 이용해 2개를 뽑아보자.
		for (int i = start; i < N / 2; i++) {
			partitionStart[idx] = startTeam[i];
			sumStart(idx + 1, i + 1);
		}
	}

	public static void sumLink(int idx, int start) {
		// 기저조건
		// 2개롤 뽑아서 능력치의 합을 구해보자.
		if (idx == 2) {
			sumLinkTeam += arr[partitionLink[0]][partitionLink[1]];
			sumLinkTeam += arr[partitionLink[1]][partitionLink[0]];
			return;
		}

		// 재귀조건
		// 조합을 이용해 2개를 뽑아보자.
		for (int i = start; i < N / 2; i++) {
			partitionLink[idx] = linkTeam[i];
			sumLink(idx + 1, i + 1);
		}
	}
}