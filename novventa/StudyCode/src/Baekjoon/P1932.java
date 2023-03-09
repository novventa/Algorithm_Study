package BOJ;

import java.util.Scanner;

public class P1932 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
				
		// 삼각형의 마지막 줄 숫자 갯수 입력받기
		int N = sc.nextInt();
        // 삼각형의 숫자들을 저장할 배열 생성
		int[][] tri = new int[N][N];
		// 숫자들 입력받기
		for(int i=0;i<N;i++) {
			for(int j=0;j<i+1;j++) {
				tri[i][j] = sc.nextInt();
			}
		}
			
	    // 1번 행부터
		for(int i=1;i<N;i++) {
			for(int j=0;j<i+1;j++) {
		      	// j-1열이 0 이상이면, 이전 행의 자신과 같은열(오른쪽 대각선), 이전 열(왼쪽 대각선) 중 큰 값을 더해준다.
				if(j-1>=0)
					tri[i][j]+=Math.max(tri[i-1][j], tri[i-1][j-1]);
		            // 만족하지 않는 좌,우 값들은 자신과 같은열(왼쪽 또는 오른쪽 대각선)의 값만 더해줄 수 밖에 없다.    
				else
					tri[i][j]+=tri[i-1][j];
			}			
		}
		// 최대값을 구해야하므로 초기값을 매우 작은 수로 설정
		int max = Integer.MIN_VALUE;
				
		// 마지막행에서 취할 수 있는 최댓값을 구한다.
		for(int i=0;i<N;i++) {
			if(max<tri[N-1][i]) 
				max = tri[N-1][i];
		}
				
		System.out.println(max);		
	}
}

