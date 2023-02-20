package com.ssafy.ws.step3;

import java.util.Scanner;

public class P15649 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int pick = sc.nextInt();
		
		
		Method(num, pick);
		
		sc.close();

	}
	
	
	public static void Method(int num, int pick) {
		
		for(int i=1; i<=num; i++) {
			System.out.println(i+" ");
		}
		
		pick--;
		
		if(pick !=0) {
			Method(num, pick-1);
		}
		
	}
}



