import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 4; i++) {

			int[] arr = new int[8];

			// 직사각형 좌표 입력
			for (int j = 0; j < 8; j++) {
				arr[j] = sc.nextInt();
			}

			// 꼭지점이 일치할 경우
			if (arr[2] == arr[4] && arr[3] == arr[5]) {
				System.out.println("c");
				// 꼭지점이 일치할 경우
			} else if (arr[0] == arr[6] && arr[1] == arr[7]) {
				System.out.println("c");
				// 꼭지점이 일치할 경우
			} else if (arr[6] == arr[0] && arr[5] == arr[3]) {
				System.out.println("c");
				// 꼭지점이 일치할 경우
			} else if (arr[2] == arr[4] && arr[1] == arr[7]) {
				System.out.println("c");
				
				
				// x축 또는 y축이 떨어져 있을 때
			} else if (arr[2] < arr[4] || arr[3] < arr[5] || arr[7] < arr[1] || arr[6] < arr[0]) {
				System.out.println("d");
				
				
				// y축이 일치할 때 사각형 양 변 사이에 위치
			} else if (arr[1] == arr[7] || arr[3] == arr[5]) {
				if (arr[0] < arr[6] && arr[4] < arr[2]) {
					System.out.println("b");
				}
				// x축이 일치할 때 사각형 양 변 사이에 위치
			} else if (arr[2] == arr[4] || arr[0] == arr[6]) {
				if (arr[1] < arr[7] && arr[5] < arr[3]) {
					System.out.println("b");
				}
			} else if(arr[2]>arr[4] && arr[6]>arr[0] && arr[5]<arr[3] && arr[7]>arr[1]) {
				System.out.println("a");
			} else {

				// 위의 경우가 아니면 모두 a
				System.out.println("b");
			}

		}sc.close();

	}
}



