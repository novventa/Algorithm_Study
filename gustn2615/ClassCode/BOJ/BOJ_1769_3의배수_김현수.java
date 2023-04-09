package study_ssafy;

/*
 * 숫자를 문자열로 받아서 각각 자릿수의 합을 구한다
 * 
 * 1. 숫자를 문자열로 받는다
 * 2. 받은 문자열을 -> 문자 -> 숫자로 바꾸어 각 자리수의 합을 구한다
 * 3. 이후 이 숫자를 문자열로 바꾸어 문자열의 크기가 1이 될때 까지 반복한다
 * 4. 문자열의 크기가 1이되면 이 숫자가 3의 배수인지를 확인한다
 * */
import java.util.Scanner;

public class solution_1769_3의배수_김현수 {
	public static void main(String[] args) {
		
		// 스캐너 사용
		Scanner sc = new Scanner(System.in);
		
		// 숫자를 문자열로 받는다
		String num = sc.next();
		
		// 스캐너 사용 종료
		sc.close();
		
		// 몇번 변환했는지 세어줄 변수
		int count = 0;
		
		// 숫자의 길이가 1이 될때까지 반복
		while (num.length() >= 2) {
			
			// 변환한 숫자를 담아줄 변수
			int tmp = 0;
			
			// 전체 숫자를 훑으면서 더해준다
			for (int i = 0; i < num.length(); i++) {
				tmp += num.charAt(i) - '0';
			}
			
			// 문자열로 바꾸어 준다
			num = Integer.toString(tmp);
			
			// 변환횟수 증가시켜주기
			count++;
		}

		// 답을 저장해줄 변수
		String answer = "NO";
		
		// 만약 3의 배수라면 YES로 변환
		if ((num.charAt(0) - '0') % 3 == 0) {
			answer = "YES";
		}

		// 답 출력
		System.out.println(count);
		System.out.println(answer);

	}
}
