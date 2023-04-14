package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P7795 {
	
	static int T,N,M,cnt;
	static int[] A;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			
			cnt = 0;

			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
			M = Integer.parseInt(st.nextToken());

			A = new int[N];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++) {
				A[i] = Integer.parseInt(st.nextToken()); 
			}
			
			Arrays.sort(A);
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<M;i++) {
				int B = Integer.parseInt(st.nextToken());
				for(int j=N-1;j>=0;j--) {
					int tmpA = A[j];
					if(tmpA>B)
						cnt++;
					else
						continue;
				}
			}
			
			System.out.println(cnt);
		}
		
	}
}
