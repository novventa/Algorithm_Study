package study_ssafy;

/*
 * bfs를 응용한 다익스트라 알고리즘으로 문제를 푼다.
 * 
 * 1. 해당위치에 가는데까지 걸리는 시간을 저장할 배열과
 * 2. 해당위치에 방문했는지를 확인하는 논리형을 만든다.
 * 3. 순간이동과, 양옆으로 이동하는 경우를 고려해서 bfs를 만든다.
 * 4. 이때 논리형을 통해 방문했다면 재방문하지 않는다.
 * 
 * */


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class solution_13549_숨박꼭질3_김현수 {
	
	// 전역변수로 사용할 변수들을 정의
	static int[] time;
	static boolean[] isVisted;
	static int start, end;
	static Queue<Integer> queue;

	public static void main(String[] args) {
		
		// 스캐너 사용
		Scanner sc = new Scanner(System.in);
		
		// 각위치에 도달하는 시간을 저장해줄 배열
		time = new int[100001];
		
		// 방문했는지를 확인할 배열
		isVisted = new boolean[100001];
		
		// 처음 시작지점과 끝지점 받아오기
		start = sc.nextInt();
		end = sc.nextInt();
		
		// 스캐너 종료
		sc.close();

		// 숨박꼭질 시작
		hide();

//		for (int i = 0; i < 21; i++) {
//			System.out.println(i + "번째:" + time[i] + " ");
//		}

		// 결과출력
		System.out.println(time[end]);
	}

	// 숨박꼭질 메소드
	static void hide() {
		
		// bfs에 사용할 큐
		queue = new ArrayDeque<>();
		
		// 큐에 시작지점 넣기
		queue.offer(start);
		
		// 시작 지점을 방문했다고 바꾸기
		isVisted[start]=true;
		
		// 큐가 빌때까지 반복
		while (!queue.isEmpty()) {
			
			// 큐에서 숫자를 빼내서
			int tmp = queue.poll();

			// 만약 도착지점이라면 중지
			if (tmp == end) {
				break;
			}

			// 순간이동을 했던 자리가 방문을 안했던 자리면
			if (2 * tmp < 100001 && isVisted[2 * tmp] == false) {
				
				// 기존시간과 변동이없으므로 그대로 가져간다
				time[2 * tmp] = time[tmp];
				
				// 방문했다고 표시
				isVisted[2 * tmp] = true;
				
				// 방문한 좌표 큐에 넣기
				queue.offer(2 * tmp);
			}

			// 좌측으로 이동하고 방문을 하지않았다면 그리고 범위를 넘지 않았다면
			if (tmp - 1 >= 0 && isVisted[tmp - 1] == false) {
				
				// 시간을 1초 더해주고
				time[tmp - 1] = time[tmp] + 1;
				
				// 방문했다고 표시하고
				isVisted[tmp - 1] = true;
				
				// 방문한 좌표를 넣는다
				queue.offer(tmp - 1);
			}

			// 우측으로 이동하고 방문을 하지않았다면 그리고 범위를 넘지 않았다면
			if (tmp + 1 < 100001 && isVisted[tmp + 1] == false) {
				
				// 시간을 1초 더해주고
				time[tmp + 1] = time[tmp] + 1;
				
				// 방문했다고 표시하고
				isVisted[tmp + 1] = true;
				
				// 방문한 좌표를 넣는다
				queue.offer(tmp + 1);
			}
		}
	}

}
