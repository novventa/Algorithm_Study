package SWEA;


import java.util.Arrays;
import java.util.Scanner;

public class P1206 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 10개만큼 반복
		for (int tc = 1; tc < 11; tc++) {

			// 빌딩 개수 입력받기
			int N = sc.nextInt();
			int cnt = 0;

			// 크기가 빌딩 개수인 배열 생성
			int[] arr = new int[N];

			// 빌딩 높이 입력받기
			for (int idx = 0; idx < N; idx++) {
				arr[idx] = sc.nextInt();
			}

			// 빌딩을 하나씩 탐색하는데 좌측 끝 2칸과 우측 끝 2칸은 빌딩이 없으므로
			for (int i = 2; i < N - 2; i++) {
				// i를 기준으로 왼쪽으로 한칸, 두칸, 오른쪽으로 한칸, 두칸의 공간이 확보된다면
				if ((arr[i] - arr[i - 1] > 0) && (arr[i] - arr[i - 2] > 0) && (arr[i] - arr[i + 1] > 0)
						&& (arr[i] - arr[i + 2] > 0)) {
					// 인접한 4개의 빌딩 중 가장 높은 빌딩을 찾는다.
					int[] building = { arr[i - 2], arr[i - 1], arr[i + 1], arr[i + 2] };
					// 오름차순으로 정렬하고
					Arrays.sort(building);
					// 카운터에 i 빌딩의 높이에서 인접한 4개의 빌딩 중 가장 높은 빌딩의 높이를 뺀 값을 더한다.
					cnt = cnt + arr[i] - building[3];
				}

			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
	
}
