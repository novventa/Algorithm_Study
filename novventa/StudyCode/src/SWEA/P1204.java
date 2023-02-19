package SWEA;

import java.util.Scanner;

public class P1204 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 입력받기
		int tc = sc.nextInt();
		
		// 테스트 케이스만큼 반복
		for(int T=1;T<tc+1;T++) {
			
			// 테스트 케이스 번호 입력받기
			int tcNum = sc.nextInt();
			// 점수를 저장할 크키 1000 배열 선언
			int[] scores = new int[1000];
			// 0점부터 100점까지 몇번 나왔는지를 저장할 배열 선언
			int[] cnt = new int[101];
			
			// 1000개의 점수를 입력받고
			// j 점수가 나올때마다 j를 1씩 더한다.
			for(int i=0; i<1000; i++) {
				scores[i] = sc.nextInt();
				for(int j=0;j<=100;j++) {
					if(scores[i]==j) {
						cnt[j]++;
					}
				}
			}
			
			// cnt배열의 인덱스 중 가장 많이 등장한 점수를 저장할
			// 변수 max와 값이 같을 경우를 고려해
			// answer 변수를 선언한다.
			int max = 0;
			int answer = 0;
			
			// 최대값을 찾고
			for(int i=0;i<=100;i++) {
				if(cnt[i]>=max) {
					max = cnt[i];
					answer = i;
				}
			}

			// 출력
			System.out.println("#"+T+" "+ answer);	
			
		}
	}
}
