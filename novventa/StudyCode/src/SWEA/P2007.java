package SWEA;

import java.util.Scanner;

public class P2007 {
	public static void main(String[] args) {
		
		// 스캐너 선언
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 횟수 입력받기
		int T = sc.nextInt();
		
		// 테스트 케이스만큼 반복
		for(int tc=1;tc<T+1;tc++) {
			
			// 문자열 입력받기
			String str = sc.next();
			
			// 문자 2개부터 반복될 수 있으므로 1부터 시작
			for(int i=1;i<str.length()+1;i++) {
				// substring메소드를 사용해 i까지 잘라본다.
				String first = str.substring(0,i);
				// i부터 i+i까지 잘라본다.
				String second = str.substring(i,i+i);
				// 만약 두 문자열이 같다면
				if(first.equals(second)) {
					// 패턴을 찾았고, 입력되는 문자열의 길이는 30이므로 패턴 문자열의 길이만큼 반복된다.
					System.out.println("#" + tc + " " + first.length());
					break;
				}
			}		
		}
	}
}
