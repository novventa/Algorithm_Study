package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1931 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 회의 수
		int N = Integer.parseInt(br.readLine());
		
		// 시간 정보 배열
		int[][] time = new int[N][2];
		
		int cnt = 0;
		
		int endTime = 0;
		
		// 회의 시작 끝 시간 입력받기
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 회의 끝나는 시간 순으로 정렬
		Arrays.sort(time, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				// 회의 끝나는 시간이 같으면 시작시간이 빠른 것이 먼저
				if(o1[1] == o2[1])
					return o1[0]-o2[0];
				return o1[1]-o2[1];
			}
		});
		
		// 회의시간 하나씩 모두 비교
		for(int i=0;i<N;i++) {
			// 회의 끝나는 시간이 다음 회의 시작시간보다 작으면
			if(endTime <= time[i][0]) {
				// 회의 끝나는 시간 갱신하고 cnt+1
				endTime = time[i][1];
				cnt++;
			}
		}
		
		// 출력
		System.out.println(cnt);
		
	}
}