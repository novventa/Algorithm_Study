package Baekjoon;

import java.util.Scanner;

public class P1193 {
	public static void main(String[] args) throws Exception {
	
		// 배열이 1,2,3,4,5 개수로 늘어나므로
		// T가 주어졌을 때
		// 몇번 째 줄의 분수인지 확인하기 위해 sum과 i를 정의한다.
		int sum = 0;
		int i = 1;
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// T가 주어졌을 때 
		while (true) {
			// T가 몇번째 줄에 해당 되는지 알아내기 위해
			// sum이 T보다 커질 때까지 더해준다
			sum += i;
			i++;
			// sum이 T보다 커졌다면
			// sum의 직전 값을 저장시킨 후 반복문을 빠져나온다.
			if (sum>T) {
				i--;
				sum -= i;
				break;
			}
		}
		sc.close();
		// i가 짝수일 경우 뒤쪽부터 시작하고
		if (i % 2 == 0) {
			System.out.printf("%d/%d", T - sum, i+1-T+sum);
			
		// i가 홀수일 경우 앞쪽부터 시작한다.
		} else {
			System.out.printf("%d/%d", i+1-T+sum , T - sum);
		}

	}
}
