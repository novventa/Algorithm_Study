package SWEA;

import java.util.Scanner;

public class P1979 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 입력받기
		int T = sc.nextInt();
		
		// 테스트 케이스 횟수만큼 반복
		for(int tc=1;tc<T+1;tc++) {
			// 퍼즐 크기 입력받기
			int N = sc.nextInt();
			// 단어 길이 입력받기
			int K = sc.nextInt();
			// 퍼즐판 생성
			int[][] map = new int[N][N];
			// 퍼즐판 채우기
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					map[r][c] = sc.nextInt();
				}
			}
			// 단어가 몇개 들어가는지 세는 변수
			int word = 0;
			// 흰 칸의 개수를 세는 변수
			int cnt = 0;
			// 행부터 한칸씩 탐색
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					// 흰 칸을 만나면
					if(map[r][c]==1) {
						// 카운터 증가
						cnt++;
					// 검은 칸을 만나면
					}else {
						// 카운터가 단어의 길이가 같으면
						if(cnt==K) {
							// 들어가는 단어 개수 증가
							word++;
						}
						// 카운터 초기화
						cnt = 0;
					}
				}
				// 한 줄이 다 끝나고 흰 칸이 단어의 길이와 같으면
				if(cnt==K) {
					// 단어 개수 증가
					word++;
				}
				// 카운터 초기화
				cnt = 0;
			}
			// 열도 마찬가지로 반복
			for(int c=0; c<N; c++) {
				for(int r=0; r<N; r++) {
					// 흰 칸을 만나면
					if(map[r][c]==1) {
						// 카운터 증가
						cnt++;
						// 검은 칸을 만나면
					}else {
						// 카운터가 단어의 길이가 같으면
						if(cnt==K) {
							// 들어가는 단어 개수 증가
							word++;
						}
						// 카운터 초기화
						cnt = 0;
					}
				}
				// 한 줄이 다 끝나고 흰 칸이 단어의 길이와 같으면
				if(cnt==K) {
					// 단어 개수 증가
					word++;
				}
				// 카운터 초기화
				cnt = 0;
			}
			// 출력
			System.out.println("#"+tc+" "+ word);
		}
	}
}
