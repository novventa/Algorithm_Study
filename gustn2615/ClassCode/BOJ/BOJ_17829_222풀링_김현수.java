package study_ssafy2;

/*
 * 
 * 재귀 함수를 문제를 풀어본다.
 * 1. 주어진 행렬을 2*2 사이즈로 모두나눈다
 * 2. 나뉘어진 사각형의 원소 중 두번째로 큰 원소를 구한다
 * 3. 기존의 map에 구한 원소를 넣어준다
 * 4. 맵의 size를 반으로 줄여가면서 반복한다.
 * 
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17829_222풀링_김현수 {
	static int N;
	static int[][] map;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine().trim());

		map = new int[N][N];
		
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int col = 0; col < N; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		// 222 폴링 메소드
		cnn(N);

		// 결과 출력
		System.out.println(map[0][0]);
	}

	// 222폴링 메소드
	// size 현재 map의 크기
	static void cnn(int size) {
		
		// 만약 맵사이즈가 1이라면 메소드를 종료하고 결과를 출력한다
		if (size == 1) {
			return;
		}

		// 현재 맵을 2*2 사이즈의 정사각형으로 나눈다.
		for (int row = 0; row < size; row += 2) {
			for (int col = 0; col < size; col += 2) {
				// 나뉘어진 2*2 사각형의 원소를 넣어줄 배열
				int[] arr = new int[4];
				int index = 0;
				
				// 배열에 원소를 넣고
				for (int i = row; i < row + 2; i++) {
					for (int j = col; j < col + 2; j++) {
						arr[index++] = map[i][j];
					}
				}

				// 정렬 후
				Arrays.sort(arr);

				// 두번째 큰수를 넣어준다
				map[row / 2][col / 2] = arr[2];
			}
		}
		
		// 맵의 크기를 반으로 줄여준다.
		cnn(size / 2);

	}
}
