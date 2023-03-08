package day0308;

import java.util.Scanner;

public class P1932 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 삼각형의 크기
		int size = sc.nextInt();
		// 삼각형
		int[][] rectangle = new int[size][size];

		// 삼각형의 값 대입
		// row=0일 때는 col=0까지
		// row=1일 때는 col=0~1까지
		// row=2일 때는 col=0~2까지의 규칙으로 값을 입력하고 있으므로
		// 일반화 시키면
		// row=x일 때는 col=0~x까지의 값을 넣기 위해
		// row=x일 때 col의 범위를 j=0 ~ j<=x라고 정한다
		for (int i = 0; i < size; i++) {
			for (int j = 0; j <= i; j++) {
				rectangle[i][j] = sc.nextInt();
			}
		}

		// 삼각형의 배열을 이해하기 쉽게 왼쪽 정렬로 이미지화 시켜서 생각하면
		// 해당 위치가 row=i, col=j일 때 그 위치에서 다음으로 갈 수 있는 위치는 row=i+1, col=j와 col=j+1로 움직일 수
		// 있다.

		// 아래서부터 올라오는 방식으로 최대값을 잦으려고 한다.
		// 주어진 예제를 보면 row=4부터 확인하는데, (4,0)과 (4,1)중의 최대값을 (3, 0)의 값에 더해 (3, 0)의 자리에 넣고
		// (4, 1)과 (4, 2)중의 최대값을 (3, 1)의 자리에 넣는다.
		// 이와 같은 방식으로 맨 위까지 채우면 최대값을 구할 수 있다.

		for (int row = size - 1; row > 0; row--) {
			for (int col = 0; col < row; col++) {

				rectangle[row - 1][col] += Math.max(rectangle[row][col], rectangle[row][col + 1]);
			}
		}

		System.out.println(rectangle[0][0]);
		sc.close();
	}

}



