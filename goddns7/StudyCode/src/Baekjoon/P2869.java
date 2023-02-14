package day0213;

import java.util.Scanner;

public class P2869 {
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
			
			//나머지가 없는 경우는 바로 출력
			if((v-b)%(a-b)==0) {
				count = (v-b)/(a-b);
			//나머지가 있으면 또 올라가야 하기 때문에 +1을 해준다
			}else {
				count = ((v-b)/(a-b))+1;
			}
			
			System.out.println(count);
			sc.close();
		
	}
}
