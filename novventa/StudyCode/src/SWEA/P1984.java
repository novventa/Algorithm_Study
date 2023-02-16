package SWEA;


import java.util.Scanner;

public class P1984 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 입력받기
		int tc = sc.nextInt();

		// 테스트 케이스 수만큼 반복
		for (int T = 1; T < tc + 1; T++) {

			// 길이가 10인 배열 선언
			int[] arr = new int[10];
			int sum = 0;
			double avg = 0;
			// 배열 채우기
			for (int idx = 0; idx < 10; idx++) {
				arr[idx] = sc.nextInt();
			}

			// 선택정렬 알고리즘 (오름차순)
			for (int i = 0; i < arr.length - 1; i++) {
				// 최소값의 인덱스를 minIdx에 저장
				int minIdx = i;
				// 최소값의 다음 인덱스의 요소와 비교
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[j] < arr[minIdx]) {
						minIdx = j;
					}
				}
				// 위치 바꾸기
				int tmp = arr[minIdx];
				arr[minIdx] = arr[i];
				arr[i] = tmp;
			}

			// 오름차순으로 정렬했으므로 최소수와 최대수를 빼려면

			for (int k = 1; k < 9; k++) {
				sum += arr[k];
			}
			avg = sum*1.0 /8;
			
			System.out.print("#" + T + " " + String.format("%.0f", avg));

		}
	}
}
