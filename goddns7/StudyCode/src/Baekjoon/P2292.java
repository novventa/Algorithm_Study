package day0221;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 방 번호
		int room = sc.nextInt();
		
		// 최소 몇 번 지나가는 지
		int result = 0;
		
//		최소 지나가는 횟수 - 방 번호	
//		1-1		1
//		2-2~7	6
//		3-8~19	12					=> 6+(6k를 1부터 n-1까지)
//		4-20~37	18
//		5-38~61	24
		
		for(int k=1; k<100000000;k++) {
			//해당 범위에 속하는 k의 값을 구하고 거기에 +2를 하면 답
			if (room < 3*Math.pow(k, 2)+3*k+2 && room >= 3*Math.pow(k, 2)-3*k+2) {
				result = k+1;
				break;
			}else if(room==1){
				result = 1;
			}
		}

		System.out.println(result);

		sc.close();
	}
}



