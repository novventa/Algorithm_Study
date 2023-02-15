package test;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		// SWEA
		// 1208 Flatten
		// D3
		
		// 평탄화 : 높은 곳의 상자를 낮은 곳에 옮김
		// 평탄화를 진행해 가장 높은 곳과 가장 낮은 곳의 차이가 최대 1이 되게함
		// 상자 옮기는 작업 횟수에 제한 있음
		// 제한 횟수만큼 옮긴 후 최고점과 최저점의 차이를 반환
		
		// 덤프 : 가장 높은 곳의 상자를 가장 낮은 곳으로 옮긴다
		
		// 가로길이 : 100
		// 1 <= 상자의 높이 <= 100
		// 1 <= 덤프 횟수 <= 1000
		
		// 주어진 덤프 횟수 이내에 평탄화가 완료되면 더 이상 덤프할 수 없으므로
		// 그 때의 최고점과 최저점의 높이 차 반환 (상자 갯수에 따라 0 또는 1이 될 수 있음)
		
		// 테스트 케이스 10개
		// 첫 줄에 덤프 횟수, 다음 줄에 100개의 상자의 높이가 주어짐
		
		// 덤프 제한 횟수만큼 덤프를 진행하고
		// 배열을 오름차순으로 정렬하여
		// index 0과 n-1(== 99) 값의 차를 출력한다
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 10번만큼 반복
		for (int testCase = 1; testCase <= 10; testCase++) {
			
			// 덤프 제한 횟수 입력받기
			int maxDumpCnt = sc.nextInt();
			
			// 100개의 상자 높이를 저장할 배열 boxes 만들어주기
			int[] boxes = new int[100];
			
			for (int idx = 0; idx < 100; idx++) {
				boxes[idx] = sc.nextInt();
			}
			
			// 덤프 제한 횟수만큼 덤프 진행하기
			Dump(boxes, maxDumpCnt);
			
			
			// 덤프 진행 된 boxes배열을 다시 오름차순 정렬해주기
			// 선택정렬
			for (int idx = 0; idx < 99; idx++) {
				// 현재 인덱스값이 최저점이라고 가정하고 인덱스 값 저장
				int minIdx = idx;
				
				// 현재 인덱스 기준으로 오른쪽 배열을 확인하며
				for (int newIdx = idx + 1; newIdx < 100; newIdx++) {
					// 오른쪽 값이 최저값일 경우 인덱스 값 업데이트
					if (boxes[newIdx] < boxes[minIdx]) {
						minIdx = newIdx;
					}
				}
				// 오른쪽에 있는 모든 값을 확인했으면
				// minIdx에 저장된 인덱스의 값이 최저값이므로
				// 현재 idx와 swap해준다
				int tmp = boxes[idx];
				boxes[idx] = boxes[minIdx];
				boxes[minIdx] = tmp;
			}
			
			
			// 재정렬 후 최고점과 최저점의 차 출력하기
			System.out.printf("#%s %s", testCase, boxes[99] - boxes[0]);
			System.out.println();
			
		}
		

	}

	// 상자가 쌓인 배열과 덤프 제한 횟수를 입력받아서
	// 제판 횟수만큼 덤프를 진행한 배열을 반환하는 Dump 메소드
	public static void Dump(int[] map, int maxDumpCnt) {
		// Dump : 배열을 오름차순으로 정렬하고
		// 		  index99-- >> index0++ 해서 최고점의 상자를 최저점에 옮겨준다
		// 위의 dump과정을 maxDumpCnt만큼 반복
		
		// 배열의 크기를 저장하는 변수 n 만들기
		int n = map.length;
		
		// 현재까지의 덤프 횟수를 저장하는 변수를 만들어 준다
		int dumpCnt = 0;
		
		// 현재까지의 덤프 횟수가 덤프 제한 횟수보다 작을 때 반복한다
		while (dumpCnt < maxDumpCnt) {
			// 선택정렬
			// 오름차순으로 정렬하다보면 마직막에는 두 값이 한 번에 정렬되므로
			// n-1만큼 반복
			for (int idx = 0; idx < n - 1; idx++) {
				// 현재 인덱스값이 최저점이라고 가정하고 인덱스 값 저장
				int minIdx = idx;
				
				// 현재 인덱스 기준으로 오른쪽 배열을 확인하며
				for (int newIdx = idx + 1; newIdx < n; newIdx++) {
					// 오른쪽 값이 최저값일 경우 인덱스 값 업데이트
					if (map[newIdx] < map[minIdx]) {
						minIdx = newIdx;
					}
				}
				// 오른쪽에 있는 모든 값을 확인했으면
				// minIdx에 저장된 인덱스의 값이 최저값이므로
				// 현재 idx와 swap해준다
				int tmp = map[idx];
				map[idx] = map[minIdx];
				map[minIdx] = tmp;
			}
			
			// 배열이 오름차순 정렬 됐으므로
			// index(n - 1) >> index0으로 상자를 하나 옮겨준다
			// 이 때 두 값의 차이가 1이하이면 평탄화가 완료됐으니 while문을 break해준다
			if (map[n - 1] - map[0] <= 1) {
				break;
			} else {
				map[n - 1]--;
				map[0]++;
				dumpCnt++;
			}
			
		}
		
	}
}


