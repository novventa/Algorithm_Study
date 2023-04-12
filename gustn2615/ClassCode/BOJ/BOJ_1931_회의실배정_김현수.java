package study_ssafy2;

/*
 * 회의 정보가 주어질때 회의가 겹치치 않으면서 회의실을 가장 많이 사용할 수 있어야한다.
 * 
 * - 단순하지만 조금 생각이 필요한 문제이다.
 * - 회의 시작시간을 기준으로 생각하지말고 끝나는 시간을 기준으로 생각하자
 * - 주어진 회의들을 회의가 끝나는 시간을 기준으로 정렬 한다.
 * - 이때 만약 회의가 끝나는 시간이 같다면 회의 시작시간이 빠른 순으로 정렬한다.
 * 
 * 1. 회의실을 가장 많이 사용해야 하므로 회의가 끝나는 시간이 가장 빠른 시간을 첫번째 회의시간으로 잡는다.
 * 2. 이후 N번째 회의 시간을 선택할 때는 (N-1번째 회의 끝나는시간)<=(N번째 회의시작 시간) 이 되도록 선택해준다.
 * 3. 이후 모두 다 골랐다면 회의 개수를 세어준다.
 * 
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1931_회의실배정_김현수 {
	static int N;
	static int[][] meetingTime;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine().trim());

		meetingTime = new int[N][2];

		// 회의 시간을 받아온다
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			meetingTime[i][0] = Integer.parseInt(st.nextToken());
			meetingTime[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		// 회의 시간 정렬
		Arrays.sort(meetingTime, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				// 회의 끝나는 시간이 같다면
				if (o1[1] == o2[1]) {
					
					// 회의 시작시간이 빠른 순으로 정렬하고
					return o1[0] - o2[0];
				}

				// 아니라면 회의가 가장 빨리 끝나는 시간을 기준으로 정렬한다.
				return o1[1] - o2[1];

			}

		});

//		for (int[] arr : meetingTime)
//			System.out.println(Arrays.toString(arr));

		// 회의의 최대 개수를 세어줄 변수
		int count = 1;
		
		// 첫번째 회의의 끝나는 시간
		int endTime = meetingTime[0][1];
		
		// 두번째 회의 부터 훑으면서
		for (int i = 1; i < N; i++) {
			
			// 만약 현재 회의 시작시간이 이전 회의 끝나는 시간보다 크거나같다면
			if (meetingTime[i][0] >= endTime) {
				
				// 회의 끝나는 시간을 갱신해주고
				endTime = meetingTime[i][1];
				
				// 회의 개수를 늘려준다
				count++;
			}
		}

		// 출력한다
		System.out.println(count);

	}
}
