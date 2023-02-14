package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2869 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// A, B, V 입력받기
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());	
		
		// 걸리는 일수 선언
		int days = 0;
		
		// A-B는 하루에 가는 거리
		// (V-B)%(A-B)는 마지막 날 딱 맞게 올라가는지 확인
		if((V-B)%(A-B)==0)
			// 딱 맞게 올라가면 바로 출력
			days = (V-B)/(A-B);
		else
			// 아니면 하루 더 올라간다.
			days = ((V-B)/(A-B))+1;
		
		// 출력
		System.out.println(days);
	}
}
