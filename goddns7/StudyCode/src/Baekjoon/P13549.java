package 백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P13549 {
	// 수빈이가 동생을 찾는 가장 빠른 시간: 최대치를 최소값으로 지정
	static int min = Integer.MAX_VALUE;
	// 방문했는지 안 했는지 확인하기 위한 배열(100000까지인데 index=1부터 시작하기 위해 100001까지로 지정)
	static boolean[] visited = new boolean[100001];
	// 수빈이의 위치(X)
	static int subin;
	// 동생의 위치
	static int sister;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 수빈이의 위치(X)
		subin = sc.nextInt();
		// 동생의 위치
		sister = sc.nextInt();
		// 처음 수빈이의 위치와 처음의 시간(0)을 넣어준다
		bfs(subin, 0);

		sc.close();
	}

	private static void bfs(int locate, int t) {
		Queue<int[]> queue = new LinkedList<>();
		// 현재 수빈이의 위치와 시간을 큐에 추가
		queue.add(new int[] { locate, 0 });
		// 큐가 비어있는 상태가 될 때까지 반복
		while (!queue.isEmpty()) {
			//queue 원소의 위치와 시간을 하나씩 받을 배열 생성
			int tmp[] = new int[2];
			// 현재 수빈이의 위치와 시간을 뽑는다.
			tmp = queue.poll();
			int location = tmp[0];	//index=0 : 위치
			int time = tmp[1];		//index=1 : 시간

			// 해당 수빈이의 위치에 방문했다고 기록
			visited[location] = true;

			// 수빈이가 동생을 찾았다면
			if (location == sister) {
				// 동생을 찾기까지 걸린 시간과 min과의 비교를 통해 최솟값을 구하고, 그 시간을 min의 값으로 지정
				// -> 계속 반복 => 여러 경우로 나오는 시간들 중에 가장 최소값을 구하기 위함
				min = Math.min(time, min);
			}

			// 순간이동
			// 해당 범위 안에 있고, 방문하지 않았다면 -> 가능
			if (location * 2 <= 100000 && location * 2 >= 0 && visited[location * 2] == false) {
				// 위치는 2배가 되고, 시간은 그대로
				queue.add(new int[] { location * 2, time });
			}
			// 걷기 (X+1)
			// 해당 범위 안에 있고, 방문하지 않았다면 -> 가능
			if (location + 1 <= 100000 && location + 1 >= 0 && visited[location + 1] == false) {
				// 위치는 X+1가 되고, 시간은 +1
				queue.add(new int[] { location + 1, time + 1 });
			}
			// 걷기 (X-1)
			// 해당 범위 안에 있고, 방문하지 않았다면 -> 가능
			if (location - 1 <= 100000 && location - 1 >= 0 && visited[location - 1] == false) {
				// 위치는 X-1가 되고, 시간은 +1
				queue.add(new int[] { location - 1, time + 1 });
			}
		}
		System.out.println(min);
	}
}




