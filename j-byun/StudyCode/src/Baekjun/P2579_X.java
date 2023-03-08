import java.util.Scanner;

// DP
// 2579 계단 오르기
// 실버3

// 문제
// 계단을 밟으면 해당 계단에 쓰여 있는 점수를 획득하며 꼭대기까지 도착하기

// 계단 오르기 규칙
// 1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다.
// 2. 연속된 세 개의 계단을 모두 밟아서는 안 된다.
//		(시작점은 계단에 포함되지 않는다.)
// 3. 마지막 도착 계단은 반드시 밟아야 한다.

// 조건
// 계단의 개수는 300이하의 자연수
// 계단에 쓰여 있는 점수는 10,000이하의 자연수

// 풀이
// 300*10,000 => int범위 내에서 해결 가능

// <DP가 이해 안돼서 풀어본 방법>
// 각 계단을 오를지 말지 판단한 상태를 저장해 줄 boolean배열을 만들자
// 계단 3개를 한 세트로 보고 세 계단 중 점수가 가장 작은 계단 빼고 나머지 두개 오르기
// 다음 계단부터 세 계단 한 세트로 보고... 이미 오른 계단이 가장 작은 점수라면 그 점수 빼고 나머지 두개 오르기
// 마지막 세 세트에서는 제일 마지막 계단은 무조건 오르고 나머지 둘 중에 낮은 점수의 계단을 버리기

// 이렇게 모든 계단을 확인 한 후 오르기로 한 계단의 점수만 더해서 출력하자

// => 틀린 코드다! DP를 다시 공부해서 풀어보자

public class P2579_X {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int stairsCnt = sc.nextInt(); // 계단의 개수 입력받기
		
		int[] stairs = new int[stairsCnt]; // 각 계단에 쓰여진 점수를 저장할 배열 공간
		
		boolean[] isUsed = new boolean[stairsCnt]; // 해당 계단을 오를지 말지 상태를 저장해 줄 배열 공간
		
		for (int cnt = 0; cnt < stairsCnt; cnt++) {
			stairs[cnt] = sc.nextInt(); // 각 계단의 점수 입력받기
		}
		sc.close(); // 입력이 끝났으니 스캐너를 닫아주자
		
		for (int cnt = 0; cnt < stairsCnt - 2; cnt++) {
			int min = stairs[cnt]; // 일단 현재 계단을 최소 점수로 가정하고
			
			if (cnt == stairsCnt - 3) { // 가장 마지막 계단 세트일 때는 도착 계단 빼고 앞의 두 계단 중 최소 점수를 찾자
				for (int idx = cnt + 1; idx < cnt + 2; idx++) {
					min = Math.max(min, stairs[idx]);
				}
				
			} else { // 가장 마지막 계단 세트가 아닐 때는
				for (int idx = cnt + 1; idx < cnt + 3; idx++) { // 현재 계단 부터 세 개의 계단 중 최소 점수를 찾자
					min = Math.max(min, stairs[idx]);
				} // 최소 점수를 찾았다면 그 계단 빼고 나머지 두 계단을 오르자
			}
			
			for (int idx = cnt; idx < cnt + 3; idx++) { // 현재 계단 부터 세 개의 계단 중 최소 점수를 찾자
				if (stairs[idx] == min) 
					isUsed[idx] = false; // 한 세트에서 최소 점수인 계단은 오르지 말자
				else
					isUsed[idx] = true; // 최소 점수가 아닌 두 계단은 오르자
			}
		} // 모든 계단에 대해 오를지 말지 판단이 끝났다!
		
		int maxScore = 0; // 최대 점수를 저장할 공간
		
		for (int cnt = 0; cnt < stairsCnt; cnt++) { // 모든 계단을 확인하며 오르기로 한 계단이라면 최종 점수에 더해주자
			if (!isUsed[cnt]) continue; // 안 오른 계단의 점수는 더해주지 말자
			maxScore += stairs[cnt];
		}
		
		System.out.println(maxScore); // 최종 점수 출력
	}

}
