import java.util.Scanner;

// 2810 컵홀더
// 브론즈1

// 문제
// 극장 컵홀더 사수하기
// 한 줄에 N개의 자리
// 자리-자리 사이에는 컵홀더 하나씩, 양끝에는 컵홀더 하나씩 더
// 커플석-커플석 사이에는 컵홀더 없음
// 	=> 컵홀더 사용 가능한 사람 수 구하기

// 조건
// 무조건 1인 1컵
// 내 자리 양옆에 붙어있는 컵홀더만 사용가능

// S : 일반 좌석
// L : 커플석 -> 두 개씩 쌍으로 주어짐

// SLLLLSSLL -> *S*LL*LL*S*S*LL* (* : 컵홀더)

// 풀이
// 일단 계산하고 컵홀더 +1 (한 줄의 시작 컵홀더 계산)
//	=> 끝 컵홀더는 자동으로 계산될 것
// while (idx < N)
// 좌석charAt(idx) 가 S면 컵홀더++, idx++
// 좌석charAt(idx) 가 L이면 컵홀더++, idx += 2 (커플석은 두 개가 세트)

// 컵홀더 수 아니고 사람 수니까 입력받은 좌석 갯수랑 컵홀더 수 중에 작은거 출력

public class BOJ_2810_컵홀더_변지혜 {
	
	static int length;
	static String seat;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		length = sc.nextInt(); // 좌석의 수 입력받기
		
		seat = sc.next(); // 좌석 배치도 입력받기
		
		int cupholders = cupholderCounter(); // 컵홀더 수 세기
		
		int result; // 결과값 저장할 공간
		
		if (cupholders > length) { // 만약 사람 수 보다 컵홀더 수가 많으면
			result = length; // 사람 수 출력
		} else {
			result = cupholders; // 사람 수가 더 많으면 컵홀더 수 출력
		}
		
		System.out.println(result);
		
	}
	
	private static int cupholderCounter() {
		
		int cupholderCnt = 0; // 컵홀더 수 저장할 공간
		int idx = 0; // 입력받은 좌석 문자열의 인덱스 표시
		
		while (idx < length) { // 좌석 문자열의 길이만큼 확인
			
			if (seat.charAt(idx) == 'S') { // 현재자리가 일반석이면
				cupholderCnt++; // 컵홀더 +1
				idx++; // 다음좌석 확인하러 가기
				
			} else if (seat.charAt(idx) == 'L') { // 현재자리가 커플석이면
				cupholderCnt++; // 커플석 두 개 끝나고 컵홀더 하나있으니까 +1
				idx += 2; // 다음 커플석은 확인할 필요 없으니까 다다음좌석 확인하러가기
			}
		}
		
		return cupholderCnt + 1; // 확인한 컵홀더 수에 제일 처음 컵홀더 수 +1 해서 반환
	}

}
