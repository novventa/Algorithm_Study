package day0221;

import java.util.Arrays;
import java.util.Scanner;

public class P2309 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
        //키 입력받을 배열
		int[] height = new int[9];
        //키 입력받기
		for (int i = 0; i < 9; i++) {
			height[i] = sc.nextInt();
		}
        //모든 원소의 총합
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			sum += height[i];
		}
        //찾으려는 난쟁이 두 명의 키의 합은 모든 원소의 총합에서 100(7명 난쟁이 키의 합)을 뺀 것
		int find = sum-100;
		//첫번째 숨겨진 난쟁이의 인덱스
		int first = 0;
        //두번째 숨겨진 난쟁이의 인덱스
		int second = 0;
        //find와 같아지는 두 키의 합을 찾고, 해당 인덱스를 first, second에 대입
		for(int i=0; i<8; i++) {
			for(int j=i+1;j<9;j++) {
				if(height[i]+height[j]==find) {
					first = i;
					second = j;
				}
			}
		}
		
        //진짜 난쟁이만 모아놓은 배열 생성
		int[] result = new int[7];
 
		int idx=0;
		for(int i=0; i<9; i++) {
			//first나 second(가짜 난쟁이 두 명)를 만나면 계속 진행한다
			if(i == first || i==second) {
				continue;
            //진짜 난쟁이를 만나면 result 배열에 대입시킨다.
			}else {
				result[idx] = height[i];
				idx++;
			}
		
		}
		//오름차순 정렬
		Arrays.sort(result);
	    //원소 출력
		for(int i=0; i<7; i++) {
			System.out.println(result[i]);
		}
		sc.close();

	}
}



