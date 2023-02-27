package day0216;

import java.util.Scanner;

public class P10163 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 색종이의 수
		int num = sc.nextInt();

		// 도화지
		int[][] map = new int[1001][1001];

		for (int i = 0; i < num; i++) {
			// 왼쪽 아래 꼭짓점의 x좌표
			int x = sc.nextInt();
			// 왼쪽 아래 꼭짓점의 y좌표
			int y = sc.nextInt();
			// 너비
			int width = sc.nextInt();
			// 높이
			int height = sc.nextInt();

			// 해당 꼭짓점으로부터 정사각형을 도화지에 1부터 표현
			for (int k = y; k < y + height; k++) {
				for (int j = x; j < x + width; j++) {
					map[k][j] = i + 1;
				}
			}
		}

		int cnt = 0;
		// 첫 색종이부터 시작(size = i+1)
		int size = 1;
		while (size <= num) {
			// 색종이 검은색 부분 넓이
			int count = 0;
			// 도화지 배열에서 size의 개수가 검은색 부분 넓이다
			for (int k = 0; k < 1001; k++) {
				for (int j = 0; j < 1001; j++) {
					//해당 size에 해당되는 갯수만큼 count++시키면 
					//그 count의 값은 해당 색종이가 보이는 면적이다
					if (map[k][j] == size) {
						count++;
					//해당 size에 해당되는 것이 없다면(해당 색종이가 보이지 않는다면)
					} else if (map[k][j] == 0) {
					//cnt의 값을 1씩 증가시킨다
						cnt++;
					}
				}
			}
			System.out.println(count);
			// 1부터 하나씩 증가시키면서 확인하기
			size++;
		}
		//색종이가 보이지 않는다면
		if (cnt == 1001*1001) {
			//0을 출력
			System.out.println(0);
		}
		sc.close();
	}
}
