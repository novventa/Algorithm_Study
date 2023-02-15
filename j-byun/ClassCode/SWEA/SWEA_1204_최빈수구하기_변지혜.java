package test;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// SWEA
		// 1204 최빈수 구하기
		// D2
		
		// 1000명의 수학 성적 => 통계 자료
		// 최빈수로 평균 수준 짐작
		// 최빈수 출력
		
		// 0 <= 점수 <= 100
		// 0점, 100점 포함해야되니까 101크기의 int 배열을 만들어서
		// 학생의 점수가 80점이면 배열의 80번 인덱스 값을 ++ 시킨다
		// 이렇게 천 명의 점수를 확인해서 배열 ++시키고
		// 그 배열의 가장 큰 값의 인덱스를 뽑아내면 그게 최빈수이다
		
		// 최빈수가 여러개면 가장 높은 점수 출력
		// 조건에 >= 크거나 "같다" 꼭 붙이기
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 수 t 입력받기
		int t = sc.nextInt();
		
		// 테스트케이스 개수만큼 반복
		for (int testCase = 1; testCase <= t; testCase++) {
			// 테스트케이스 번호 입력받기
			int caseNum = sc.nextInt();
			
			// 0점부터 100점까지 점수의 빈도수를 저장할 배열 scoreCnt 만들기
			int[] scoreCnt = new int[101];
			
			// 1000명의 학생들의 점수를 확인해서 scoreCnt배열의 해당 인덱스 값을 ++시키기
			// 예) 학생의 점수가 80점이면 scoreCnt[80]++;
			for (int idx = 0; idx < 1000; idx++) {
				scoreCnt[sc.nextInt()]++;
			}
			
			// scoreCnt 배열에서 가장 큰 값의 인덱스 번호 뽑아내기
			// 초기값 설정
			int max = -1;
			int modeScore = -1;
			
			// 배열 돌면서 확인하고 업데이트
			for (int idx = 0; idx < 101; idx++) {
				if (scoreCnt[idx] >= max) {
					max = scoreCnt[idx];
					modeScore = idx;
				}
			}
			
			// 출력
			System.out.printf("#%s %s", caseNum, modeScore);
			System.out.println();
			
			
			
		}
		

	}

}
