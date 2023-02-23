package day0223;

import java.util.Scanner;

public class P2810 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		String seat = sc.next();
		
		char[] arr = seat.toCharArray();
		
		//컵홀더의 수 (왼쪽에 있는 1개는 기본으로 두기)
		int count = 1;
		//커플을 구별하기 위함
		int couple =0;
		
		//좌석 전체 확인
		for(int i=0; i<seat.length(); i++) {
			
			//S가 있으면 컵홀더 하나씩 추가
			if(arr[i] == 'S') {
				count++;
			//L이 있으면 두번째 L에서 컵홀더 하나씩  추가
			}else if(arr[i] == 'L') {
				//첫번쨰, 두번째 L을 구별하기 위해
				//첫번째 L은 couple가 0 
				if(couple == 0) {
					couple++;
					continue;
				//두번째 L은 couple가 1로한다
				}else {
					count++;
					couple =0;
				}
			}
		}
		
		//최대로 놓을 수 있는 사람을 구하는데
		//컵홀더가 사람보다 많으면 사람 수를 출력
		if(count>num) {
			count = num;
		}
		System.out.println(count);
		
		sc.close();
	}
}



