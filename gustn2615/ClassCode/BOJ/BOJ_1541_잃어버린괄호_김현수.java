package study_ssafy2;

/*
 * split 함수를 통해 -와 +를 기준으로 숫자를 쪼개서 답을 구해준다
 * - 메타문자로 들어가는 일부 특수문자인 ?, *, +, (, ), [, ], {, } 와 같은 문자를 split으로 나눌 때 에러가 발생
 * - 특수문자 앞에 \\(역슬래시)를 붙여줌으로써 이스케이프 처리가 되어 나눌 수 있습니다.
 * 위의 에러만 주의한다면 쉽게 풀 수 있는 문제입니다
 * 
 * 1. 가장 최솟값을 구해야 하므로 '-' 사이의 모든 숫자들을 다 더한다
 * 2. 이후 순서대로 맨앞의 숫자에서 부터 차례대로 빼준다
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1541_잃어버린괄호_김현수 {
	public static void main(String[] args) throws IOException {
		
		// 버퍼 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// -를 기준으로 먼저 문자열을 쪼개준다
		String[] num = br.readLine().split("-");
//		System.out.println(Arrays.toString(num));
		
		// 버퍼리더 사용 종료
		br.close();
		
		// 최솟값을 저장할 변수
		int answer = 0;
		
		// 쪼개진 숫자들을 돌면서
		// 쪼개어진 숫자들을 괄호에 묶여있다고 생각한다
		for (int i = 0; i < num.length; i++) {
			
			// 괄호안의 숫자들의 합을 담을 변수
			int sum = 0;
			
			// 만약 쪼개진 숫자들 안에 덧셈이 존재한다면
			if (num[i].contains("+")) {
//				System.out.println(num[i]);
				
				// '+'를 기준으로 문자열을 나눈 후
				// 이때 특수문자 이므로 \\ 를 붙여준다
				String[] str = num[i].split("\\+");

				// 모든 숫자들의 합을 구한다
				for (int j = 0; j < str.length; j++) {
					sum += Integer.parseInt(str[j]);
				}
			} 
			// 만약 덧셈이 존재하지 않다면
			else {
				// 숫자로 바꾸어만 준다
				sum = Integer.parseInt(num[i]);
			}
			
			// 첫번째 항이면 더해주고
			if (i == 0) {
				answer = sum;
			} 
			// 그 이후부터는 빼준다
			else {
				answer -= sum;
			}
		}
		
		// 결과출력
		System.out.println(answer);

	}
}
