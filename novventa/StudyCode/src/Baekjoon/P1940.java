package BOJ;

import java.util.Scanner;

public class P1940 {
	
	static int N,M,R,cnt;
	static int[] arr;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();

		M = sc.nextInt();
		
		R = 2;
		
		arr = new int[N];
		
		cnt = 0;
		
		
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		combi(new int[R],0,0);
		
		System.out.println(cnt);
		
	}

	private static void combi(int[] sel, int idx, int sidx) {
		if(sidx==R) {
			int tmp = 0;
			for(int i=0;i<R;i++) {
				tmp += sel[i];
			}
			if(tmp==M)
				cnt++;
			return;
		}
		
		// 인덱스를 넘어가면
		if(idx >= N) {
			// 종료
			return;
		}
		// sel 배열에 뽑은 수 저장하고
		sel[sidx] = arr[idx];
		// 재귀조건
		// 선택한 것과
		// 선택 안한 것
		combi(sel,idx+1,sidx+1);
		combi(sel,idx+1,sidx);
	}
}
