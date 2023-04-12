import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author jihye.byun
 * BOJ 1931 회의실 배정 실버1 그리디
 * 
 * 문제
 * 한 개의 회의실에서 N개의 회의를 진행하자.
 * 각 회의에 대해 시작시간과 끝나는 시간이 주어져 있다.
 * 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자.
 * 회의는 중간에 중단될 수 없으며, 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 * 회의의 시작시간과 끝나는 시간이 같은 경우는 시작하자마자 끝나는 것이다.
 * 
 * 조건
 * 회의의 수 N(1 ≤ N ≤ 100,000)
 * 시작 시간과 끝나는 시간은 2^31-1보다 작거나 같은 자연수 또는 0이다.
 * 
 * 풀이
 * 1. DP를 사용해서 회의 시작 시간의 회의 개수 +1을 회의가 끝나는 시간에 저장하자.
 * => 시간초과
 * 
 * 다른 방법으로 풀어보자! feat.구글링+원희어시스트
 * 1. 끝나는 시간 기준으로 오름차순 정렬하자!
 * 1-1. 시작 시간으로 백날 정렬해봤자 0초~제일마지막에 끝나는 회의 같은 애가 있으면 골치아파진다!
 * 1-2. 그러니 제일 먼저 끝나는 애 부터 회의실을 배정해주자.
 * 2. 끝나는 시간이 동일하다면 시작시간 기준으로 오름차순 정렬하자.
 * 2-1. 4 8 / 8 8 의 두 회의가 있다면, 8 8이 먼저 정렬될 경우 원래라면 두 회의 다 진행 가능하지만 4 8을 고려하지 못하게 된다.
 * 
 * 그리디 어렵다.. 사실 이해 잘 안 된 것 같아... 다음에 다시 풀어보자
 * 왜 정형화된 방법으로밖에 못푸는걸까..? 다른 방법은 없나???
 */

public class P1931 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		 * 시간초과 코드
		 * 
		int N = sc.nextInt(); // 회의의 수 입력받기
		
		int[] start = new int[N + 1]; // 각 회의의 시작시간을 저장할 공간
		int[] end = new int[N + 1]; // 각 회의의 끝나는 시간을 저장할 공간
		
		// 회의 시간을 입력받으면서 제일 마지막으로 끝나는 시간을 찾아두자
		int maxEnd = 0;
		for (int idx = 1; idx <= N; idx++) {
			start[idx] = sc.nextInt();
			end[idx] = sc.nextInt();
			
			if (maxEnd < end[idx])
				maxEnd = end[idx];
		}
		
		// 제일 마지막 회의가 끝나는 시간까지 확인해보자
		int[] time = new int[maxEnd + 1];
		
		// N개의 회의에 대해 전체 시간만큼 다 확인해보자
		for (int i = 1; i <= N; i++) {
			for (int t = 0; t <= maxEnd; t++) {
				if (t == end[i]) // 현재 회의가 끝나는 시간이라면
					// 현재 회의가 시작할 때의 최대 회의 수에 +1 해주자
					time[t] = Math.max(time[start[i]] + 1, time[t - 1]);
				else if (t != 0) // 현재 회의가 끝나는 시간이 아니라면
					// 이전 회의까지만 고려했을 때 VS 현재 회의까지 고려했을 때 중 큰 값을 저장하자
					time[t] = Math.max(time[t], time[t - 1]);
			}
		}
		
		// 마지막 회의가 끝난 시간에 저장된 최대 회의 개수 출력
		System.out.println(time[maxEnd]);
		*/
		
		
		int N = sc.nextInt(); // 회의의 수 입력받기
		
		int[][] meeting = new int[N][2]; // 각 회의의 시작시간과 끝나는 시간을 저장할 배열 공간
		
		// 회의 시간 입력받기
		for (int idx = 0; idx < N; idx++) {
			meeting[idx][0] = sc.nextInt();
			meeting[idx][1] = sc.nextInt();
		}
		
		// 회의들을 1. 끝나는 시간 기준 오름차순으로, 끝나는 시간이 동일하다면 2. 시작시간 기준 오름차순으로 정렬해주자
		Arrays.sort(meeting, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1])
					return o1[0] - o2[0]; // 시작시간 기준 오름차순
				return o1[1] - o2[1]; // 끝나는 시간 기준 오름차순
			}
		});
		
		int latestEnd = 0; // 제일 마지막으로 고려해준 회의의 끝나는 시간을 저장해둘 변수
		int maxMeetingCount = 0; // 진행한 회의 개수를 세어줄 변수
		
		for (int idx = 0; idx < N; idx++) {
			// 이전에 배정해준 회의가 진행중이면 이번 회의는 배정 불가
			if (meeting[idx][0] < latestEnd) continue;
			
			// 이전 회의가 끝났다면?
			maxMeetingCount++; // 이번 회의 배정해줄 수 있으니 회의 개수 +1
			latestEnd = meeting[idx][1];
			// 이번 회의 진행시켜야 하니 이번 회의가 끝날 때 까지 다른 회의를 진행하지 못하게 끝나는 시간을 저장해두자
		}
		
		// 배정해준 회의 개수를 출력하자
		System.out.println(maxMeetingCount);
	}
}
