package study_ssafy;

import java.util.Scanner;

public class solution_2477_참외밭_김현수 {
	public static void main(String[] args) {
		// 스캐너로 입력받기
		Scanner sc = new Scanner(System.in);
		// 1m^2 의 땅에 자라나는 과일 개수 입력받기
		int fruitCount = sc.nextInt();
		// 육각형을 그릴 방향과 크기를 입력받을 이차원배열 만들기
		int[][] line = new int[6][2];
		// 이차원 배열에 방향과 크기를 입력받기
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 2; col++) {
				line[row][col] = sc.nextInt();
			}
		}
		// 이차원 배열이 잘 들어갔는지 확인
//		for (int row = 0; row < 6; row++) {
//			for (int col = 0; col < 2; col++) {
//				System.out.print(line[row][col] + " ");
//			}
//			System.out.println();
//		}
		// 큰사각형과 작은사각형의 크기를 담을 배열
		// ㄱ자 모양의 육각형의 넓이를 구해야 하므로
		// 큰 직사각형에서 작은 직사각형을 뺄 것 이다.
		int smallSize = 0;
		int maxSize = 0;
		
		// 이차원 배열을 돌면서
		for (int row = 0; row < 6; row++) {
			// row를 기준으로 row와 row+1이 특정 조건을 만족 할 때 작은 사각형의 넓이를 구할 수 있다.
			int tmp1 = line[row % 6][0];
			int tmp2 = line[(row + 1) % 6][0];
			// 아래와 같이 특정 조건을 만족할 때 큰사각형과 작은사각형의 넓이를 구한다.
			if (tmp1 == 1 && tmp2 == 3) {
				smallSize = line[row % 6][1] * line[(row + 1) % 6][1];
				maxSize = line[(row + 3) % 6][1] * line[(row + 4) % 6][1];
				break;
			} else if (tmp1 == 3 && tmp2 == 2) {
				smallSize = line[row % 6][1] * line[(row + 1) % 6][1];
				maxSize = line[(row + 3) % 6][1] * line[(row + 4) % 6][1];
				break;
			} else if (tmp1 == 2 && tmp2 == 4) {
				smallSize = line[row % 6][1] * line[(row + 1) % 6][1];
				maxSize = line[(row + 3) % 6][1] * line[(row + 4) % 6][1];
				break;
			}
			else if (tmp1 == 4 && tmp2 == 1) {
				smallSize = line[row % 6][1] * line[(row + 1) % 6][1];
				maxSize = line[(row + 3) % 6][1] * line[(row + 4) % 6][1];
				break;
			}
		}
		// 이후 결과값을 출력한다.
		System.out.println((maxSize - smallSize)*fruitCount);

	}
}

