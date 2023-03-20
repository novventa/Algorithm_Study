package 백준;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2667 {
	// 지도의 크기
	static int size;
	// 지도
	static int[][] map;
	// 방문 여부 확인 배열
	static boolean[][] visited;

	// 델타배열
	static int[] deltaR = { 0, 0, 1, -1 };
	static int[] deltaC = { 1, -1, 0, 0 };

	// 단지 수의 배열
	static int arr[];
	// 단지 속 집의 개수
	static int count;
	// idx번째의 단지
	static int idx = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 지도의 크기
		size = sc.nextInt();
		// 지도
		map = new int[size][size];
		// 지도에 정보 입력
		for (int i = 0; i < size; i++) {
			char[] line = sc.next().toCharArray();
			for (int j = 0; j < size; j++) {
				map[i][j] = line[j] - '0';
			}
		}
		// 초기화
		visited = new boolean[size][size];
		// 단지의 개수를 넉넉히 잡기
		arr = new int[625];
		int idx = 0;
		// 지도에서 1을 찾으면 해당 row와 col의 정보를 bfs로 보낸다
		// ->1은 단지가 있다는 것을 의미
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (map[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		// 오름차순 정렬
		Arrays.sort(arr);

		// 0이 아닌 수를 갖는 원소의 개수
		int cnt = 0;
		// 오름차순이므로 뒤에서부터 검사하는게 빠름
		for (int i = 624; i >= 0; i--) {
			if (arr[i] != 0) {
				cnt++;
				// 0이 나오면 그 뒤는 다 0이므로 멈추기
			} else {
				break;
			}
		}

		System.out.println(cnt);
		// 작은 수부터 출력
		for (int i = 625 - cnt; i < 625; i++) {
			System.out.println(arr[i]);
		}

		sc.close();
	}

	private static void bfs(int i, int j) {
		// 하나의 단지를 시작할 때마다 0으로 초기화
		count = 0;
		// 큐 생성
		Queue<int[]> queue = new LinkedList<>();
		// 큐에 현재 위치 추가
		queue.add(new int[] { i, j });
		// 현재 위치가 단지 중 집 하나
		count++;
		// 크기가2인 배열 생성(하나는 행, 하나는 열)
		int[] tmp = new int[2];
		// 방문했다고 기록
		visited[i][j] = true;
		// 큐가 빈 상태가 될 때까지 반복
		while (!queue.isEmpty()) {

			// 원소 하나를 뽑음
			tmp = queue.poll();

			for (int k = 0; k < 4; k++) {
				// 뽑은 원소의 index=0(row를 의미)의 값과 델타배열의 값을 더해 새로운 위치 생
				int row = tmp[0] + deltaR[k];
				// 뽑은 원소의 index=1(col를 의미)의 값과 델타배열의 값을 더해 새로운 위치 생
				int col = tmp[1] + deltaC[k];
				// 지도 범위 밖의 경우 무시
				if (row >= size || row < 0 || col >= size || col < 0) {
					continue;
				}
				// 집이 있는 위치이고(1) 방문한 적이 없으면
				if (map[row][col] == 1 && visited[row][col] == false) {
					// 큐에 해당 위치 추가
					queue.add(new int[] { row, col });
					// 나중에 1을 찾아 새로운 단지 탐색을 할 때와 구별하기 위해 1이라는 수를 없애기 위해 1씩 더해줌
					map[row][col] += 1;
					// 방문했다고 기록
					visited[row][col] = true;
					// 단지 중 집 개수 증가
					count++;
				}

			}

		}
		// 해당 단지에 있는 집의 수를 arr배열의 원소에 하나씩 대입
		arr[idx] = count;
		// 다음 인덱스로 넘어가기 위해 +1씩 증가시킴
		idx++;
	}
}



