package study_ssafy;
/*
 * BFS를 이용해서 문제를 푼다
 * 
 * 1. 전체 단지를 훑으면서 1 즉 아파트가 존재하면
 * 2. bfs를 통해 그 주변에 아파트가 있는지 확인한다
 * 3. 이때 아파트를 만나면 그 아파트는 확인했으므로 0으로 바꾸어준다.
 * 4. 한 단지가 끝났으면 또 전체를 훑으면서 1값을 가지는 지점을 찾는다
 * 5. bfs를 사용해서 주변을 확인한다...
 * 6. 계속 위와같이 반복해 준 후에
 * 7. 결과값을 출력한다
 * 
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class solution_2667_단지번호붙이기_김현수 {
	// 단지 정보
	static int[][] map;
	
	// 변수들 정의
	static int N, complex, apartmentCount;
	
	// bfs에 사용할 큐 정의
	static Queue<int[]> queue;
	
	// 단지마다 아파트의 개수를 넣어줄 List 정의
	static ArrayList<Integer> totalCount;

	// 델타배열 사용
	static int[] deltaRow = { -1, 1, 0, 0 }; // x방향배열-상하
	static int[] deltaCol = { 0, 0, -1, 1 }; // y방향배열-좌우

	public static void main(String[] args) throws IOException {
		
		// 버퍼 리더 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 단지의 크기 받아오기
		N = Integer.parseInt(br.readLine());
		
		// 단지를 받아올 2차원 배열 정의
		// 크기는 N이다.
		map = new int[N][N];

		// map에 지도의 상태를 입력받는다.
		for (int row = 0; row < N; row++) {
			// 한줄을 문자열로 읽은 후
			String str = br.readLine();
			for (int col = 0; col < N; col++) {
				
				// 이를 문자로 가져와서 집어 넣는다
				// 이때 int 형으로 바꾸기 위해 '0' 값을 빼준다
				// 48을 빼주어도 된다.
				map[row][col] = str.charAt(col) - '0';
			}
		}
		
		// 버퍼리더 사용종료
		br.close();

		// 단지의 총 개수를 세줄 변수
		complex = 0;
		
		// 단지내에 아파트의 개수를 세줄 변수
		// 아파트를 만나는 순간 이미 1개의 아파트가 확보되므로
		// 1로 두고 시작한다
		apartmentCount = 1;
		
		// bfs에 사용할 queue
		queue = new ArrayDeque<>();
		
		// 단지마다의 아파트 개수를 넣어줄 리스트
		totalCount = new ArrayList<>();

		//지도 전체를 훑으면서
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				
				// 만약 값이 1이라면 즉, 아파트라면
				if (map[row][col] == 1) {
					
					// 0으로 바꾸어주고
					map[row][col] = 0;
					
					// bfs 메소드 실행
					searchApartment(row, col);

					// 단지 추가
					complex++;

					// 단지의 아파트 수를 배열에 추가
					totalCount.add(apartmentCount);
					apartmentCount = 1;
				}
			}
		}
		
		// map이 제대로 바뀌었는지 확인
//		for (int row = 0; row < N; row++) {
//			for (int col = 0; col < N; col++) {
//				System.out.print(map[row][col]);
//			}
//			System.out.println();
//		}

		// 리스트 정렬 사용
		Collections.sort(totalCount);

		// stringbuilder를 사용해 출력
		StringBuilder sb = new StringBuilder();
		sb.append(complex + "\n");
		for (Integer i : totalCount)
			sb.append(i + "\n");

		System.out.print(sb);
	}

	// bfs 메소드
	static void searchApartment(int x, int y) {
		
		// 큐에 처음 시작 좌표를 추가한다
		queue.add(new int[] { x, y });

		
		// 큐가 차있는동안 반복한다
		while (!queue.isEmpty()) {
			
			// 큐에 있는 원소를 빼내고
			int[] now = queue.poll();
			
			// 이를 각각 x,y좌표로 받는다
			int nowX = now[0];
			int nowY = now[1];

			// 델타배열 만큼 반복하면서
			for (int i = 0; i < 4; i++) {
				
				// 상하좌우 방향으로 이동했을 때의 좌표를 저장한다
				int newRow = nowX + deltaRow[i];
				int newCol = nowY + deltaCol[i];

				// 이때 좌표가 범위를 벗어나거나 그 값이 0이면 다음으로 넘어간다
				if (newRow < 0 || newRow > N - 1 || newCol < 0 || newCol > N - 1 || map[newRow][newCol] == 0) {
					continue;
				}
				
				// 만약 if문에 걸러지지 않았다면 아파트 이므로
				// queue에 추가한다
				queue.add(new int[] { newRow, newCol });
				
				// 단지내에 아파트 개수 추가
				apartmentCount++;
				
				// 지도에 있는 아파트를 0으로 바꾸어준다.
				map[newRow][newCol] = 0;
			}

		}
	}
}
