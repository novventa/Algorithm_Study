import java.util.Scanner;

/**
 * @author jihye.byun
 * BOJ 1057 토너먼트 실버4
 * 
 * 문제
 * N명의 참가자끼리 토너먼트를 진행하자.
 * 인접한 두 번호끼리 대결해서 이긴 사람은 다음 라운드 진출, 진 사람은 그 라운드에서 떨어진다.
 * 각 라운드의 참가자가 홀수명이라면, 마지막 참가자는 부전승한다
 * 라운드가 진행될 때 마다 참가자의 번호를 1번부터 다시 매긴다.
 * (이전 번호 순서를 유지하면서 번호를 매긴다.)
 * 한 명만 남을 때까지 라운드를 계속 진행한다.
 * 지민이는 한수와 몇 번째 라운드에서 대결하는지 궁금하다.
 * 둘은 서로 만나기 전까지 항상 이긴다고 가정하자.
 * 1라운드에서의 지민이와 한수의 번호가 주어질 때, 둘이 몇 라운드에서 대결할지 출력하자.
 * 
 * 조건
 * 참가자의 수 N은 2보다 크거나 같고, 100,000보다 작거나 같은 자연수
 * 지민이의 번호는 한수의 번호와 다르다
 * 
 * 풀이
 * 1. 편의를 위해 두 사람의 번호 중 작은 번호가 지민이라고 정의하자.
 * 2. 라운드를 1씩 증가시키며, 지민이의 번호가 홀수일 때, +1한 번호가 한수의 번호이면 해당 라운드에서 대결하는 것이다.
 * 3. 2번 조건에 해당하지 않는다면, 각자의 번호를 /2하면되는데, 이 때 /2하기 전 번호가 홀수라면 +1 하고 /2 해주자.
 */

public class P1057 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int peopleCnt = sc.nextInt(); // 전체 사람 수 받아서 버리기
		
		int a = sc.nextInt(); // 두 사람의 번호를 입력받아서
		int b = sc.nextInt();
		
		// 작은 번호가 지민이가 되게 만들자
		int jimin, hansu;
		if (a < b) {
			jimin = a;
			hansu = b;
		} else {
			jimin = b;
			hansu = a;
		}
		
		// 몇 라운드까지 진행됐는지 세어줄 변수
		int round = 0;
		
		// 지민이와 한수가 만날 때 까지 무한 반복
		while (true) {
			round++; // 라운드 +1
			
			// 지민이의 번호가 홀수일 때, +1번이 한수이면 둘이 대결할 수 있다
			if (jimin % 2 == 1) {
				if (jimin + 1 == hansu)
					break; // 둘이 대결했으면 현재 라운드에서 게임 종료
				// 둘이 대결하지 못했으면 지민이가 이긴 상태로 다음 라운드로 진출시키기 위해 일단 짝수번으로 만들어주자
				else
					jimin++;
			}
			
			// 한수도 다음 라운드로 진출시키기 위해 짝수번으로 만들어주자
			if (hansu % 2 == 1)
				hansu++;
			
			// 현재 번호 /2해서 다음 라운드로 진출시켜주자
			jimin /= 2;
			hansu /= 2;
		}
		
		// 둘이 만났을 때의 라운드를 출력하자
		System.out.println(round);
	}
	
}
