/* 문제
 * 한 개의 회의실이 있다. 이를 사용하고자 하는 N개의 회의에 대해 회의실 사용표를 만들고자 한다.
 * 각 회의의 시작하는 시간과 끝나는 시간이 주어질 때, 회의가 겹치지 않도록 할때
 * 사용 할 수 있는 회의의 최대 개수를 구해보자.
 * 
 * 
 * 
 * 조건
 * 회의의 수 N은 1 이상 10만 이하다.
 * 시작하는 시간과 끝나는 시간은 INT범위 이내다.
 * 회의는 한번 시작하면 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 * 회의의 시작시간과 끝나는 시간이 같을 수도 있다.
 * 
 * 
 * 
 * 아이디어
 * 끝나는 시간을 정렬하자.
 * 하나를 확인 후 다음 끝나는 시간의 시작하는 시간을 확인해보자.
 * 시작하는 시간이 이전 끝나는 시간보다 작다면 continue하고,
 * 끝나는 시간보다 크다면  cnt를 늘린 후 끝나는 시간 값을 초기화 시키자.
 * 
 */

package Baekjun;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P1931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 회의의 수 N을 입력 받자.
		int N = sc.nextInt();

		// 회의의 시작/끝 시간의 정보를 담을 N*2 크기의 배열을 만든다.
		int[][] arr = new int[N][2];

		// 0번 인덱스 : 시작하는 시간
		// 1번 인덱스 : 끝나는 시간
		for (int row = 0; row < N; row++) {
			arr[row][0] = sc.nextInt();
			arr[row][1] = sc.nextInt();
		}

		// 끝나는 시간을 기준으로 정렬해보자.
		// 끝나는 시간이 같다면, 시작하는 시간 순으로 정렬해보자.
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return (o1[1] == o2[1]) ? o1[0] - o2[0] : o1[1] - o2[1];
			}
		});

		// 첫 회의는 무조건 포함시키니, cnt에 1을 저장하자.
		int cnt = 1;
		// 끝나는 시간에는 arr[0][1]을 저장해두자.
		int endTime = arr[0][1];

		// 첫번째는 구해놨으니, i는 1부터 시작하면 되겠다.
		for (int i = 1; i < arr.length; i++) {
			// 시작하는 시간을 따로 저장하고
			int startTime = arr[i][0];
			// 시작하는 시간이 끝나는 시간보다 크거나 같으면
			if (startTime >= endTime) {
				// 회의 수를 1개 늘리고
				cnt++;
				// 끝 시간을 갱신하자.
				endTime = arr[i][1];
			}
		}

		System.out.println(cnt);

	}
}