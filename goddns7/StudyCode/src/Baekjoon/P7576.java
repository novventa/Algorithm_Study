package solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P7576 {
	// 상자의 가로 칸의 수
	static int width;
	// 상자의 세로 칸의 수
	static int height;
	// 박스
	static int[][] box;

	// 상하좌우를 확인하기 위한 델타배열
	static int[] deltaR = { 0, 0, 1, -1 };
	static int[] deltaC = { 1, -1, 0, 0 };

	// 방문했는지 안 했는지 확인하는 배열
	static boolean[][] visited;

    //익지 않은 토마토를 발견했을 때 해당 토마토를 넣고 빼기 위해 필요한 큐(for bfs)
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 상자의 가로 칸의 수
		width = sc.nextInt();
		// 상자의 세로 칸의 수
		height = sc.nextInt();
		// 박스
		box = new int[height][width];
        // 박스 정보 입력
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				box[row][col] = sc.nextInt();
			}
		}
        // 박스의 토마토에 방문했는지 안 했는지 확인하기 위함
		visited = new boolean[height][width];

		// 1인 칸의 수
		int count1 = 0;
		// -1인 칸의 수
		int count = 0;
    
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
                //익은 토마토가 있으면 count1++을 해준다
				if (box[row][col] == 1) {
					count1++;
                 //토마토가 아무것도 없으면 count++를 해준다
				} else if (box[row][col] == -1) {
					count++;
				}
			}
		}
        //박스에 익은 토마토로만 채워져있고 토마토가 없는 칸도 존재한다면
		if (count + count1 == width * height && count >= 0 && count < width * height) {
            //0 출력(모든 칸을 익은 토마토로 채울 수 없다는 의미)
			System.out.println(0);

		} else {
			for (int row = 0; row < height; row++) {
				for (int col = 0; col < width; col++) {
                    //익은 토마토를 찾으면
					if (box[row][col] == 1) {
                        //해당 행과 열을 큐에 추가한다
						queue.add(new int[] { row, col });
					}

				}
			}
			bfs();
		}
		sc.close();
	}

	public static void bfs() {

		//크기가 2인 배열을 생성(행과 열 2개를 의미)
		int[] tmp = new int[2];
        //큐가 비어있지 않으면 계속 반복
		while (!queue.isEmpty()) {
            //큐에서 하나 뽑는다
			tmp = queue.poll();
            //하나는 row, 하나는 col으로 넣어준다
			int row = tmp[0];
			int col = tmp[1];
            //해당 row와 col에 방문하면 true로 바꿔준다
			visited[row][col] = true;

			for (int i = 0; i < 4; i++) {
                //상하좌우 델타배열 적용
				int newR = row + deltaR[i];    //델타배열 적용된 row
				int newC = col + deltaC[i];    //델타배열 적용된 col
                //박스의 배열 범위 밖으로 나가면 넘어가기
				if (newR >= height || newC >= width || newR < 0 || newC < 0) {
					continue;
				}
                //해당 원소가 익은 토마토(1)이거나 비어있는 칸(0)이라면
				if (box[newR][newC] == 1 || box[newR][newC] == -1) {
                    //방문 안한 거라면
					if (visited[newR][newC] == false) {
                        //방문했다고 바꾸기
						visited[newR][newC] = true;
					}
                //안 익은 토마토이고 방문하지 않았다면
				} else if (box[newR][newC] == 0 && visited[newR][newC] == false) {
                    //익은 토마토로 바꾸기
					box[newR][newC] = 1;
                    //해당 원소를 큐에 넣어주기
					queue.add(new int[] { newR, newC });
                     //방문했다고 바꾸기
                    visited[newR][newC]=true;
                    //해당 원소에 기존 원소의 값을 더해준다 
                    //-> 계속 증가하여 다 익는데 필요한 일수(day)를 찾기 위해
					box[newR][newC] += box[row][col];
				}

			}
		}
        //필요한 일 수 찾기
		int max = 0;
		outer: for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				if (box[row][col] > max) {
					max = box[row][col];
                 //안 익은 토마토가 하나라도 있다면
				} else if (box[row][col] == 0) {
                    //익은 토마토로 채울 수 없는 것이므로 0으로 출력해야 한다.
					max = 0;
                    //그리고 반복문 중단
					break outer;
				}
			}
		}
		if (max == 0) {
			System.out.println(-1);
            //max에서 1을 빼줘야 필요한 날이 나온다(1부터 시작하기 때문)
		} else {
			System.out.println(max - 1);
		}

	}
}



