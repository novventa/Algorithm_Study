import java.util.Scanner;

// 16778 반 배치고사
// D2

// 문제
// 모 학교의 학생 N명을 대상으로 반 배치고사 실시
// 반 배치고사 점수를 기반으로 A, B, C 3개의 분반으로 나눌 것

// 분반 기준 : 임의의 점수 S1, S2를 선정하여...
// S2이상 : A분반
// S1이상 S2미만 : B분반
// S1미만 : C분반

// 각 분반은 분반별 최소 인원 N_min과 최대인원 N_max를 만족해야한다

// 학생 수가 가장 많은 반과 가장 적은 반의 차이의 최솟값을 구하여라
//	=> 최대한 모든 분반에 비슷한 수의 학생이 배치되어야 함
// 각 반의 최소인원, 최대인원을 만족하는 점수 S1, S2가 없다면 -1 출력

// 5 <= 학생 수 N <= 1000
// 1 <= 학생의 점수 Score <= 100

// 풀이
// 최소 인원 수 * 3 > 전체 학생 수 이면 최소인원 만족 불가 => -1 출력
// 최대 인원 수 * 3 < 전체 학생 수 이면 최대인원 만족 불가 => -1 출력
// else...
// 브루트포스 (완전 탐색) 실행
// 학생 수 입력 받으면서 최대, 최소값 저장해놓고...
// 최소값 ~ 최대값 사이에서 s1, s2 정하는 브루트포스 실행
// 브루트 포스 안에서 학생들의 점수를 저장해 놓은 배열 돌면서 a, b, c반으로 나눠서 학생 수를 세고
//	=> 여기서 다시 각 반이 최소, 최대 인원 수를 만족했는지 확인하기
// 셋 중 학생 수가 가장 많은 반, 가장 적은 반 구해서 그 차이를 저장
// 저장한 학생 수의 차이가 여태까지 저장된 min학생 수 차이보다 작다면 업데이트

public class SWEA_16778_반배치고사_변지혜 {
	
	public static int separateClass(int[] arr, int minScore, int maxScore, int minStudent, int maxStudent) {
		int size = arr.length;
		
		if (minStudent * 3 > size) { // 최소 인원 수를 만족하지 못하는 경우...
			return -1; // -1 반환
			
		} else if (maxStudent * 3 < size) { // 최대 인원 수를 만족하지 못하는 경우...
			return -1; // -1 반환
			
		} else { // 최소, 최대 인원 수를 만족하는 경우 S1, S2를 구하자
			
			int minGap = size; // 모든 s1, s2를 정해서 분반 시켰을 때 학생 수가 가장 많은 반과 가장 적은 반의 차이를 저장할 공간
			
			for (int s1 = minScore; s1 < maxScore; s1++) { // 최저점~최고점 사이의 s1, s2의 모든 경우의 수 확인해보기
				for (int s2 = minScore + 1; s2 <= maxScore; s2++) {
					
					// 임의의 s1, s2를 골랐다면 학생들의 점수를 저장해놓은 배열을 확인하면서 분반시켜본다
					// 분반시키기 전에 각 반의 인원을 0명으로 초기화 하고 분반 진행
					int aClass = 0;
					int bClass = 0;
					int cClass = 0;
					
					for (int studentIdx = 0; studentIdx < size; studentIdx++) {
						int score = arr[studentIdx]; // 현재 확인할 학생의 점수 저장하기
						
						// 분반 기준에 따라 현재 확인한 학생을 A, B, C반 중 한 군데에 넣는다
						if (score >= s2) {
							aClass++;
							
						} else if (score < s2 && score >= s1) {
							bClass++;
							
						} else if (score < s1) {
							cClass++;
						}
					}
					
					// 분반 후의 A, B, C반 중 한 반이라도 최소, 최대 학생 수를 만족하지 못한다면 분반실패
					// 	=> 다음 s1, s2 확인하러 넘어간다
					if (aClass < minStudent || aClass > maxStudent || bClass < minStudent || bClass > maxStudent || cClass < minStudent || cClass > maxStudent) {
						continue;
					}
					
					// 분반 후에 학생 수가 가장 많은 반과 학생 수가 가장 적은 반을 찾는다
					int maxClass = Math.max(aClass, Math.max(bClass, cClass));
					int minClass = Math.min(aClass, Math.min(bClass, cClass));
					
					// 학생 수가 가장 많은 반과 가장 적은 반의 학생 수 차이가 현재까지 저장한 최소 학생 수 차이보다 적다면 최소값인 minGap을 업데이트한다
					minGap = Math.min(minGap, maxClass - minClass);
				}
			}
			
			if (minGap == size) // 임의의 s1, s2를 다 정해서 확인했는데 분반이 이뤄질 수 없었다면
				return -1; // -1을 출력한다
			
			return minGap; // 분반이 정상적으로 이루어 졌다면 모든 s1, s2 경우의 수를 확인한 후의 학생 수 차 최솟값을 반환
		}
		
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기
		
		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복 실행
			sb.append("#").append(tc).append(" "); // 출력 양식
			
			int studentSize = sc.nextInt(); // 학생 수 입력받기
			int minStudent = sc.nextInt(); // 각 반의 최소 인원 수 입력받기
			int maxStudent = sc.nextInt(); // 각 반의 최대 인원 수 입력받기
			
			int[] scores = new int[studentSize]; // 각 학생들의 점수를 저장할 배열
			
			int minScore = Integer.MAX_VALUE; // 학생들의 점수 중 가장 낮은 점수를 저장할 공간
			int maxScore = Integer.MIN_VALUE; // 학생들의 점수 중 가장 높은 점수를 저장할 공간
			
			for (int idx = 0; idx < studentSize; idx++) { // 학생 수 만큼 점수 배열에 각 학생들의 점수 입력받기
				scores[idx] = sc.nextInt();
				
				if (maxScore < scores[idx]) {
					maxScore = scores[idx]; // 학생들의 점수 중 가장 높은 점수 저장하기
					
				} else if (minScore > scores[idx]) {
					minScore = scores[idx]; // 학생들의 점수 중 가장 낲은 점수 저장하기
				}
			}
			
			int result = separateClass(scores, minScore, maxScore, minStudent, maxStudent); // 점수 입력이 끝났으니 분반 진행
			
			sb.append(result).append("\n"); // 분반 결과 출력
		}
		
		sc.close(); // 입력 끝났으니 스캐너 닫기
		
		System.out.println(sb); // 출력
	}

}
