package test;

import java.util.Scanner;

// SWEA
// 2001 파리퇴치
// D2

// 문제
// n*n 배열
// 배열의 각 칸에는 해당 영역에 존재하는 파리의 개수가 들어있음

// m*m 크기의 파리채를 한 번 내리쳐서 최대한 많은 파리를 죽이자!
// => 죽은 파리의 개수 출력

// 조건
// 5 <= n <= 15
// 2 <= m <= n
// 각 영역의 파리 갯수 <= 30

// 풀이
// 맵에 파리 수 입력 받고
// 모든 칸을 돌면서 row로 row<= <row+m까지, col로 col<= <col+m까지의 값을 sum하고
// 그 sum 중 최대값을 뽑아낸다

public class SWEA_2001_파리퇴치_변지혜 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		
		// 테스트케이스 개수 t 입력
		int t = sc.nextInt();
		
		for (int testCase = 1; testCase <= t; testCase++) {
			// mapSize n 입력받기
			int mapSize = sc.nextInt();
			
			// 파리채 사이즈 m 입력받기
			int flapperSize = sc.nextInt();
			
			// 파리 수를 저장할 n*n 크기의 2차원 배열 map만들기
			int[][] map = new int[mapSize][mapSize];
			
			// map에 파리 수 입력받기
			for (int row = 0; row < mapSize; row++) {
				for (int col = 0; col < mapSize; col++) {
					map[row][col] = sc.nextInt();
				}
			}
			
			// 최대로 죽일 수 있는 파리 수를 저장할 maxFlies 공간 만들기
			int maxFlies = -1;
			
			// 현재 칸에서 파리채가 시작됐을 때 죽일 수 있는 파리 수를 저장하는 sumDeadFlies 공간 만들기
			int sumDeadFlies = 0;
			
			// 모든 칸에서 시작해서
			// 현재 칸에서 파리채가 시작 됐을 때 죽일 수 있는 파리 수 sumDeadFlies를 구해보고
			// sumDeadFlies가 현재까지의 최대로 죽일 수 있는 파리 수 maxFlies보다 크다면 maxFlies 업데이트
			//		파리채 펼칠 수 있는 공간이 확보돼야 하니까
			//		row와 col은 mapSize <= flapperSize 까지만 확인한다
			for (int row = 0; row <= mapSize - flapperSize; row++) {
				for (int col = 0; col <= mapSize - flapperSize; col++) {
					// 모든 칸에 대해 시작 할 때 마다 sumDeadFlies 0으로 초기화
					sumDeadFlies = 0;
					
					// row <= < row + maxFlies까지,
					// col <= < col + maxFlies까지 확인하며 파리 수를 더한다
					for (int newRow = row; newRow < row + flapperSize; newRow++) {
						for (int newCol = col; newCol < col + flapperSize; newCol++) {
							sumDeadFlies += map[newRow][newCol];
						}
					}
					
					// 해당 칸에서 m*m 사이즈의 파리채로 죽일 수 있는 파리수가 모두 더해졌으니
					// 현재까지의 max값과 비교해보고
					// max < sum 이면 max = sum 으로 업데이트해준다
					if (maxFlies < sumDeadFlies) {
						maxFlies = sumDeadFlies;
					}
				}
			}
			// for문이 종료되면
			// map의 전체 부분에 대해
			// 최대로 죽일 수 있는 파리 수가 maxFlies에 저장된 상태
			
			// 출력양식
			sb.append("#").append(testCase).append(" ").append(maxFlies).append("\n");
		}
		
		// 출력
		System.out.println(sb);
	}
}





