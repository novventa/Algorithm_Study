package study_ssafy;

import java.util.Scanner;

// 흰색 도화지를 0으로 초기화 시켜주고
// 색종이가 존재하는 곳을 1값으로 바꾸어준다
// 이후 도화지에 1인 부분만 count해주면 넓이를 알 수 있다.

public class solution_2563_색종이_김현수 {
	public static void main(String[] args) {
		// 스캐너로 입력받기
		Scanner sc = new Scanner(System.in);
		// 색종이 개수 입력받기
		int paperNum = sc.nextInt();
		// 100*100 흰도화지 배열을 만들면서 초기화
		int[][] whitePaper = new int[100][100];
		// 색종이의 x,y좌표를 받아오기 위한 배열
		int[][] paper = new int[paperNum][2];
		// 색종이의 x,y좌표를 받아온다
		for (int i = 0; i < paperNum; i++) {
			paper[i][0] = sc.nextInt();
			paper[i][1] = sc.nextInt();
		}
		// 스캐너를 종료
		sc.close();
		
		// 색종이 개수 만큼 반복하면서
		for (int i = 0; i < paperNum; i++) {
			// 색종이의 x,y좌표를 가지고 온 후
			int x1 = paper[i][0];
			int y1 = paper[i][1];
			// 도화지안에 색종이의 정사각형 범위안에 있는 x,y 좌표를 1값으로 바꾼다
			for (int row = x1; row < x1 + 10; row++) {
				for (int col = y1; col < y1 + 10; col++) {
					whitePaper[row][col] = 1;
				}
			}
		}
		// 이후 흰도화지에 1이 적혀있는 곳을 셀 변수를 초기화한다.
		int count = 0;
		// 이후 흰도화지를 돌면서 1을 세준다.
		for (int row = 0; row < 100; row++) {
			for (int col = 0; col < 100; col++) {
				if (whitePaper[row][col] == 1) {
					count++;
				}
			}
		}
		// 결과를 출력한다.
		System.out.println(count);

	}
}
