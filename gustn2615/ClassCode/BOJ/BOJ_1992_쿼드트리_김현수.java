package study_ssafy2;

/*
 * 2630 색종이 문제와 똑같이 풀었지만, 출력 결과 때문에 조금 헷갈리는 문제
 * 1. 정사각형의 범위 내에서 모두 같은 색인지 확인하는 메소드를 만든다.
 * 2. 이때 같은 값을 가지지 않는 점들이 있다면 정사각형을 4등분하여
 * 3. 정사각형이 시작하는 모든 위치에 대해서 재귀메소드를 실행한다.
 * 4. 이후 모든 점이 같은 값을 가질 때 그 점을 출력해준다.
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992_쿼드트리_김현수 {
	static int N;
	static int[][] map;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine().trim());

		map = new int[N][N];

		// 점들의 위치를 받아오고
		for (int row = 0; row < N; row++) {
			String str = br.readLine().trim();
			for (int col = 0; col < N; col++) {
				map[row][col] = str.charAt(col) - '0';
			}
		}

		// 쿼드트리 메소드를 실행 후
		quadTree(0, 0, N);

		// 출력한다
		System.out.println(sb);
	}

	static void quadTree(int sr, int sc, int size) {
		
		// 시작지점의 점값을 확인한다
		int tmp = map[sr][sc];

		for (int row = sr; row < sr + size; row++) {
			for (int col = sc; col < sc + size; col++) {
				
				// 시작지점의 점값과 다르다면
				if (tmp != map[row][col]) {
					
					// 정사각형을 4등분해서 다시 확인해본다.
					// 이때 확인하기 전에 괄호를 넣어준다.
					// 처음 주어진 모든 정사각형의 값들이 같으면 괄호가 없이 그 값만 나타내면 되므로
					// 괄호는 이곳에만 필요하다
					sb.append("(");
					quadTree(sr, sc, size / 2);
					quadTree(sr, sc + size / 2, size / 2);
					quadTree(sr + size / 2, sc, size / 2);
					quadTree(sr + size / 2, sc + size / 2, size / 2);
					sb.append(")");
					return;
				}
			}
		}
		
		// 점이 모두 같은 값이라면
		// 출력결과에 값을 넣어준다.
		sb.append(tmp);
	}

}
