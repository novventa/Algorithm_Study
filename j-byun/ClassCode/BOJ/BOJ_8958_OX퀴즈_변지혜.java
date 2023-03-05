import java.util.Scanner;

// 8958 OX퀴즈
// 브론즈2

// 문제
// O : 문제 받은건데...
// 점수는 현재 칸 까지 연속된 O의 개수
// X 나오면 리셋

// 조건
// 0 < 문자열길이 < 80
// 문자열은 O랑 X로만 이루어져 있음

// 풀이
// 초기 score = 1로 선언
// O가 나오면 result += score++
// X가 나오면 score = 1로 다시 초기화

public class BOJ_8958_OX퀴즈_변지혜 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기
		
		for (int tc = 1; tc <= testCase; tc++) { // 테케 개수만큼 반복
			String line =sc.next();
			
			int result = 0; // 이번 테스트 케이스의 총 점수 저장할 공간
			int score = 1; // 새로운 문자열 시작할 때 마다 초기점수 1로 초기화
			
			for (int idx = 0; idx < line.length(); idx++) { // 읽어온 문자열 길이만큼 확인
				
				char cur = line.charAt(idx); // 지금 확인할 문자
				
				if (cur == 'O') { // 확인할 문자가 O면
					result += score++; // 현재 O의 점수를 총점에 더해주고 다음 O점수 +1 해주기
					
				} else { // 확인할 문자가 X면
					score = 1; // 다음 O점수를 1로 초기화
				}
			}
			
			System.out.println(result); // 이번 테케의 총 점수 출력
			
		}

	}

}

