package study_ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class solution_1592_영식이 {
	public static void main(String[] args) {
		// 큐의 경우 앞과 뒤가 오픈되어있는 배열이기 때문에
		// 원형인 식탁 문제에 유용하게 사용할 수 있다.
		// 공을 받은 횟수에 따라서 시계방향과 반시계 방향으로 나뉘므로
		// 두가지 경우에 대해서만 고려해주면서 문제를 풀면된다.
		
		// 스캐너로 입력을 받는다.
		Scanner sc = new Scanner(System.in);
		
		// 총 사람 수를 입력받는다.
		int personNum = sc.nextInt();
		int maxBallCount = sc.nextInt();
		int throwNum = sc.nextInt();

		// 사용할 큐 객체를 생성한다.
		Queue<Integer> roundPeron = new LinkedList<>();

		// 큐에 학생의 번호를 넣어준다.
		// 사실 번호는 크게 의미가없다.
		for (int i = 0; i < personNum; i++) {
			roundPeron.offer(i+1);
		}
		
		// ballCount라는 배열을 만들어서
		// 각각의 index를 한명의 사람이라고 생각하고
		// 그사람이 공을 받았을 때 배열의 값을 1 늘려준다.
		// 배열의 index값을 저장할 i를 정의한다.
		int i = 0;
		// ballCount 배열을 만들어준다.
		// 이때 배열의 초기값은 0으로 주어진다.
		int[] ballCount = new int[personNum];
		
		// 첫번째 사람부터 공을 받기 시작하고 공을 받은것도 카운트 하기 때문에
		// index=0에 1값을 넣어준다.
		ballCount[0] = 1;
		
		// 반복문인 while문을 돌린다. 
		// 공을 시계방향으로만 넘겨준다고 생각하고 문제를 푼다.
		// 반시계방향의 경우 시계방향으로 바꾸어서 생각한다.
		// 공을 옆으로 전달해준다는 가정하에 옆으로 갈때마다 index i를 1씩 늘린다.
		// i가 ballCount의 size값인 personNum을 벗어나면 나머지를 구하는 '%'를 통해 원래 index로 돌아온다.
		// count가 초기 설정값인 maxBallCount를 넘으면 while문을 중지한다.
		while (ballCount[i % personNum] < maxBallCount) {
			// 반복문 중 공을 받은 횟수가 짝수번이면
			if (ballCount[i % personNum] % 2 == 0) {
				// 반시계 방향으로 움직이므로
				// 시계방향으로는 (전체 사람수)-(throwNum) 만큼 움직이면 된다.
				for (int j = 0; j < personNum - throwNum; j++) {
					roundPeron.offer(roundPeron.poll());
					// 움직이면서 매번 index값을 증가시킨다.
					i++;
				}
			} 
			// 반복문 중 공을 받은 횟수가 홀수번이면
			else if (ballCount[i % personNum] % 2 == 1) {
				// 시계방향이므로 throwNum만큼 움직인다.
				for (int j = 0; j < throwNum; j++) {
					roundPeron.offer(roundPeron.poll());
					// 움직이면서 매번 index값을 증가시킨다.
					i++;
				}
			}
			// 공을 받을 사람의 자리로 가졌다면 count값을 증가시킨다.
			ballCount[i % personNum]++;

		}
		// 이후 배열의 원소들의 합을 구한다.
		int sum = 0;
		for (int idx = 0; idx < personNum; idx++) {
			sum += ballCount[idx];
		}

		// 이때 공을 던진 횟수를 구해야 하므로 처음 공을 들고 시작할 때 1번 받은 경우는 빼준다.
		System.out.println(sum - 1);

	}
}
