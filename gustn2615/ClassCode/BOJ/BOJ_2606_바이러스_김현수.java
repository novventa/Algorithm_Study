package study_ssafy;

/*
 * 1번 컴퓨터가 감염되었다는 가정 하에 1번 컴퓨터와 네트워크상에서 연결 된 컴퓨터들만 감염이된다
 * 
 * 1. dfs를 통해 1번 컴퓨터부터 시작해서 깊이 탐색을 하여 감염된 컴퓨터가 존재할 때 마다 count 한다
 * 2. 카운트가 끝나면 이를 출력한다
 * 
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class solution_2606_바이러스_김현수 {

	// dfs에 사용할 논리형
	static boolean[] isVirus;

	// 네트워크 상에 연결된 컴퓨터 쌍을 넣어줄 이차원 배열
	static Integer[][] graph;

	// 전역 변수
	static int count, computerNum, lineNum;

	public static void main(String[] args) throws IOException {

		// 버퍼 리더 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 컴퓨터 개수 받아오기
		computerNum = Integer.parseInt(br.readLine());

		// 컴퓨터 쌍의 개수 받아오기
		lineNum = Integer.parseInt(br.readLine());

		// 컴퓨터 쌍을 받아올 2차원 배열 정의
		graph = new Integer[lineNum][2];

		// 컴퓨터 쌍을 받아온다
		for (int i = 0; i < lineNum; i++) {

			// Tokenizer 사용
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 두개의 컴퓨터 번호를 받아온다
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());

			// 컴퓨터 번호가 작은것을 0번 index에 담기 위해서
			// 조건문을 사용한다
			// 이렇게 하면 컴퓨터 쌍을 정렬할 때 예외가 발생하지 않는다
			if (tmp1 < tmp2) {
				graph[i][0] = tmp1;
				graph[i][1] = tmp2;
			} else {
				graph[i][0] = tmp2;
				graph[i][1] = tmp1;
			}
		}

		// 버퍼리더 종료
		br.close();

		// 컴퓨터 쌍을 정렬한다
		// graph[i][0]을 기준으로 정렬하돼
		// 만약 graph[i][0]와 graph[i+1][0]의 크기가 서로 같다면
		// graph[i][1]의 크기를 비교해서 정렬을 해준다.
		// ex) 1 2
		// 1 5
		// 2 3
		// 2 5
		// 4 7
		// 5 6
		Arrays.sort(graph, new Comparator<Integer[]>() {

			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				// TODO Auto-generated method stub
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}

		});

		// 정렬이 잘 되었는지 확인
//		for (int i = 0; i < lineNum; i++) {
//			for (Integer num : graph[i]) {
//				System.out.print(num);
//			}
//			System.out.println();
//		}

		// 컴퓨터가 바이러스에 감염이 되었는지 안되었는지 확인하는 논리형
		isVirus = new boolean[computerNum + 1];

		// 바이러스에 감염된 컴퓨터를 세는 변수
		count = 0;

		// 깊이 탐색 메소드
		dfs(1);

		// 탐색이 끝나고 나면 마지막 컴퓨터의 경우 뒤에 감염된 컴퓨터가 없어도
		// 무조건 카운트를 한번 하게되므로 count--를 해준다.
		count--;

		// 결과 출력
		System.out.println(count);

	}

	// 깊이를 탐색하는 메소드
	static void dfs(int k) {

		// 만약 감염되지 않은 컴퓨터라면
		if (isVirus[k] == false) {

			// 감염된 컴퓨터 수를 1대 늘려준다.
			count++;
		}

		// 컴퓨터가 감염되었다고 표시해준다
		isVirus[k] = true;

		// 컴퓨터 쌍 전체를 훑으면서
		for (int i = 0; i < lineNum; i++) {
			for (int j = 0; j < 2; j++) {

				// 만약 컴퓨터 번호가 입력 받은 k값과 같으면
				// 그옆의 컴퓨터는 감염되야 하므로
				if (graph[i][j] == k) {

					// 향상된 for문을 통해 옆에 컴퓨터를 확인한다
					for (int num : graph[i]) {

						// 이때 만약 감염되지 않은 컴퓨터라면
						if (isVirus[num] == false) {

							// 메소드에 넣어준다
							dfs(num);
						}
					}

				}
			}
		}

	}
}
