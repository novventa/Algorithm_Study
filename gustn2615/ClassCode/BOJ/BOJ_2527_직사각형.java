package study_ssafy;

import java.util.Scanner;

public class solution_2527_직사각형 {
	public static void main(String[] args) {
		// 스캐너를 이용한다
		Scanner sc = new Scanner(System.in);

		// 스캐너를 활용해 4개의 좌표를 받아온다.
		for (int tc = 0; tc < 4; tc++) {
			int[] coordinate = new int[8];
			for (int i = 0; i < 8; i++) {
				coordinate[i] = sc.nextInt();
			}
			// 좌표를 받아온 후 대응이 되는 것들 끼리
			// 묶어서 변수로 지정해준다.
			int a1 = coordinate[0];
			int a2 = coordinate[6];
			int b1 = coordinate[1];
			int b2 = coordinate[7];
			int c1 = coordinate[2];
			int c2 = coordinate[4];
			int d1 = coordinate[3];
			int d2 = coordinate[5];

			// 겹치지 않을 조건을 먼저 찾는게 좋다
			// 가장 쉽게 찾을 수 있기도 하고
			// 이를 제외하면 남은 것들은 조건을 만들기가 쉽다.
			if (c1 < c2 || d1 < d2 || a2 < a1 || b2 < b1) {
				System.out.println("d");
			}
			// 이후 선분이 되는 조건을 찾았다
			// 위에서 만나지 않을 조건을 찾았으므로 아래부터는 무조건 만나게된다
			// 우선 선분이 같은 것 부터 찾아준다
			// 선분의 경우 한쪽 선분이 만나면서 점만 되지 않으면된다.
			// 따라서 점이 되는 지점은 같지않다로 두고 선분이 될부분만 같다고 두면 된다.
			else if (a1 != a2 && c2 != c1 && d1 == d2) {
				System.out.println("b");
			} 
			
			else if (a1 != a2 && c2 != c1 && b1 == b2) {
				System.out.println("b");
			} 
			
			else if (b1 != b2 && d2 != d1 && c1 == c2) {
				System.out.println("b");
			} 
			
			else if (b1 != b2 && d2 != d1 && a1 == a2) {
				System.out.println("b");
			} 
			// 꼭지점만 겹칠 때 이다.
			// 아래와 같이 4가지 경우가 있다.
			else if (c1 == c2 && d1 == d2) {
				System.out.println("c");
			} 
			
			else if (a1 == a2 && b1 == b2) {
				System.out.println("c");
			} 
			
			else if (c1 == c2 && b1 == b2) {
				System.out.println("c");
			} 
			
			else if (a1 == a2 && d1 == d2) {
				System.out.println("c");
			} 
			// 그외에는 전부 내부가 조금이라도 겹칠 때 이다.
			else {
				System.out.println("a");
			}

		}
	}
}
