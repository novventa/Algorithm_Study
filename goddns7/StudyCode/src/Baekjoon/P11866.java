package day0213;

import java.util.Scanner;

public class p11866 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 올라가는 A
		int a = sc.nextInt();
		// 떨어지는 B
		int b = sc.nextInt();
		// 높이
		int v = sc.nextInt();

		//걸리는 날
		int count = 0;

		//전제: 떨어지는 b는 올라가는 a보다 무조건 하루 더 적게 적용됨
		//a*걸리는 날 - b*(걸리는날 -1) >= v를 만족하면서
		//나머지가 없다면 그대로,
		//나머지가 있다면 +1을 더해주면 걸리는 날을 구할 수 있다.
		if((v-b)%(a-b)==0) {
			count = (v-b)/(a-b);
		}else {
			count = ((v-b)/(a-b))+1;
		}
		
		System.out.println(count);
		sc.close();
	}
}
