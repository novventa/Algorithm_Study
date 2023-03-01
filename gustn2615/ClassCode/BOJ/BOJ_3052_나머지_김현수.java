package study_ssafy;

/*
 * 카운팅 배열을 통해 나머지를 index로 생각해서 카운트 해준다
 * 이때 똑같은 숫자가 나오면 2이상이 되므로 count를 마이너스 해준다
 * 
 * */
import java.util.Scanner;

public class solution_3052_나머지_김현수 {
	public static void main(String[] args) {
		// 스캐너 사용
		Scanner sc = new Scanner(System.in);
		
		// 서로 다른값일때 더해줄 카운팅
		int count = 0;
		
		// 나머지값을 넣을 배열
		int[] mod = new int[42];
		
		// 10개의 숫자를 받으면서
		for (int i = 0; i < 10; i++) {
			int tmp = sc.nextInt();
			
			// tmp를 42로 나눈 나머지의 index를 놀려준다
			mod[tmp % 42]++;
			
			// 카운트 해준다
			count++;
			
			// 이때 카운트가 2이상이면 카운트를 줄여준다
			if (mod[tmp % 42] > 1) {
				count--;
			}
		}
		
		// 답을 출력한다
		System.out.println(count);

	}

}
