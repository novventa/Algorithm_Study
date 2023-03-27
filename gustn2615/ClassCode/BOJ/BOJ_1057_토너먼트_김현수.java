package study_ssafy;
/*
 * 트리구조처럼 생각해서 푼다
 * - 어떤 사람이 짝수번째 번호 N을 가지고 있다고 하자
 * - 이때 이 사람은 N-1번째 사람과 겨루게 되고 둘중 이긴사람이 N/2번 번호를 가지게된다
 * - 이때 주의할 점은 총 사람 수 가 홀수일때는 마지막 사람이 부전승이 된다
 * - 부전승이 되는 사람을 N이라고 할때 이 사람의 경우 (N+1)/2 번째로 올라가게된다.
 * 
 * 배열에 지민이와 한수를 넣고 이 둘이 만나는 경우를 구하면 된다.
 * 어차피 만날때 까지는 두명의 선수가 무조건 이기기 때문에 어디서든 만나게된다.
 * 근데 서로 대결하지 않을때는 -1을 왜 출력하라고하지..?
 * 
 * */

import java.util.Scanner;

public class solution_1057_토너먼트_김현수 {
	public static void main(String[] args) {
		
		// 스캐너 사용
		Scanner sc = new Scanner(System.in);
		
		// 사람 명수 받아오기
		int N = sc.nextInt();
		
		// 사람의 번호는 1번부터 시작이므로 배열을 1크게 만들어준다
		int[] person = new int[N + 1];
		
		// 지민이와 한수의 INDEX는 1로 만들어준다
		person[sc.nextInt()]++;
		person[sc.nextInt()]++;
		
		// 스캐너 사용 종료
		sc.close();
		
		// 현재 라운드를 세어준다
		int round = 1;
		
		// N은 사람명수를 나타낸다 
		// 사람이 1명남을때 까지 반복
		loop: while (N > 1) {
			
			// 만약 사람이 홀수명 이라면
			if (N % 2 == 1) {
				
				// 2칸씩늘려가면서 사람을 확인해본다
				for (int i = 2; i < N + 1; i += 2) {
					// 만약 I번째 사람과 I-1번째 사람이 1이라면
					// 둘이 만났으므로 반복문을 빠져나간다
					if (person[i] == 1 && person[i - 1] == 1) {
						break loop;
					} 
					// 만약 둘이 안만났다면
					else {
						// i/2 번째 사람에 두 수중 큰수를 올린다.
						person[i / 2] = Math.max(person[i], person[i - 1]);
					}
				}
				
				// 홀수의 경우 마지막 사람을 다음경기에 올려야한다
				person[(N + 1) / 2] = person[N];
				
				// 홀수의 경우 N이 버림되기 때문에 2로나눈후 1을 더해준다
				N = N / 2 + 1;
			}

			//만약 짝수라면
			else {
				// 둘이 만나면 반복문을 빠져나오고
				for (int i = 2; i < N + 1; i += 2) {
					if (person[i] == 1 && person[i - 1] == 1) {
						break loop;
					} 
					// i/2 번째 사람에 두 수중 큰수를 올린다.
					else {
						person[i / 2] = Math.max(person[i], person[i - 1]);
					}
				}
				// 짝수의 경우 2를 나누어준다
				N = N / 2;
			}
			// 라운드를 올려준다
			round++;

		}
		
		// 결과출력
		System.out.println(round);

	}
}
