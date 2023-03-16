package study_ssafy;

/* 가장 작은수부터 차례대로 구하다 S를 넘어가면 결과를 출력한다
 * 
 * 1. 1부터 1씩늘려가면서 합을 구한다
 * 2. S가 합과 같으면 num을 출력하고
 * 3. 합이 S를 넘어가거나 부족하면 num-1을 출력한다
 * 
 * */
import java.util.Scanner;

public class solution_1789_수들의합_김현수 {
	public static void main(String[] args) {
		
		// 스캐너 사용
		Scanner sc = new Scanner(System.in);
		
		// 40억까지 입력값이 있으므로 long형으로 받는다
		long S = sc.nextLong();
		
		// 1부터 더해야하므로 1로 변수를 선언
		long num = 1;
		
		// num을 늘려가면서 S에서 빼준다
		while (S > num) {
			S -= num++;
		}
		
		// 스캐너 사용 종료
		sc.close();

		// 결과 출력
		if (S == num) {
			System.out.println(num);
		}
		else {
			
			System.out.println(--num);
		}
	}
}
