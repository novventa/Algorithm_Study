package day0216;

import java.util.Scanner;

public class P2563{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//색종이의 수
		int num = sc.nextInt();
		
		//도화지
		int[][] map = new int[100][100];
		
		for(int i=0; i<num; i++) {
		    //꼭짓점의 x와 y좌표	
			int x = sc.nextInt();
			int y = sc.nextInt();
			
            //해당 꼭짓점으로부터 정사각형을 도화지에 1로 표현
			for(int j=x; j<x+10; j++) {
				for(int k=y; k<y+10; k++) {
					map[j][k]=1;
				}
			}
			
		}
			
		//색종이 검은색 부분 넓이
		int count =0;
        //도화지 배열에서 1의 개수가 검은색 부분 넓이다
		for(int i=0; i<100; i++) {
			for(int j= 0; j<100; j++) {
				if(map[i][j]==1) {
					count++;
				}
			}
		}
			
			System.out.println(count);
		
		
		
		sc.close();
	}
}


