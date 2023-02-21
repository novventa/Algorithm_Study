package com.ssafy.hw.step4;

import java.util.Scanner;

public class P7568 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 사람 수
		int num = sc.nextInt();
		
		//리스트(몸무게, 키)
		int[][] list = new int[num][2];

		//리스트에 값 대입
		for (int weight = 0; weight < num; weight++) {
			for (int height = 0; height < 2; height++) {
				list[weight][height] = sc.nextInt();
			}
		}
		
		//확인하고자하는 인덱스
		int i=0;
		
		//자기(i)보다 더 큰 몸무게와 키를 가진 인덱스가 k명 있다면 등수는 k+1이다
		while(i<num) {
			int k=0;
			//모든 인덱스와 비교하기 위해
			for(int j = 0; j<num; j++) {
				//키와 몸무게 모두 크다면
				if(list[i][0]<list[j][0] && list[i][1] < list[j][1]) {
					k++;
				}
			}
			i++;
			
			//
			System.out.print((k+1) + " ");
		}
		
		
		
		

		sc.close();

	}
}


