package study_ssafy;

/*
 * 재귀함수를 통해 중복순열을 뽑아서 이를 사용했다
 * 기본적으로 브루트 포스처럼 나올 수 있는 전체 경우를 탐색 후
 * 이중 가장 작은 봉지 값을 뽑아냈다.
 * 5kg짜리 봉지개수와 3kg짜리 봉지 개수를 (0,0)~(N/5,N/3) 사이에 모든값들을
 * 집어 넣어 주면서 N kg을 만족하는 최솟값을 찾았다.
 * 
 * 
 * */
import java.util.Scanner;

public class solution_2839_설탕배달_김현수 {

	// 중복순열에 사용할 배열
	static int[] arr;

	// 입력받은 N kg과 결과값을 저장할 min 값
	static int N, min;

	public static void main(String[] args) {

		// 스캐너 사용
		Scanner sc = new Scanner(System.in);

		// N 값 받아오기
		N = sc.nextInt();

		// 스캐너 사용중지
		sc.close();

		// 봉지의 최솟값을저장할 변수
		// 일단 최대값으로 설정해준다
		min = 2000;

		// 두봉지의 개수를 뽑아줄 배열
		arr = new int[2];

		// 중복순열을 뽑을 메소드
		backtracking(0);

		// 만약 min값이 초기값이라면 -1 저장
		if (min == 2000) {
			min = -1;
		}

		// 출력
		System.out.println(min);
	}

	static void backtracking(int k) {

		// 두 수를 뽑앗으면
		if (k == 2) {
//			System.out.println(Arrays.toString(arr));
			// Nkg을 만족하는지 확인
			if (arr[0] * 5 + arr[1] * 3 == N) {

				// 만족한다면 최솟값을 저장
				if (min > arr[0] + arr[1]) {
					min = arr[0] + arr[1];
				}
			}

			// return 필수
			return;
		}

		// i는 N/3만큼 반복 N/5로 하면 더 줄어들 수 있으나
		// 그럼 고려못하는 경우가 있어서 그냥 통일
		for (int i = 0; i <= N / 3; i++) {

			// K번째에 i를 넣고 k+1번을 채운다.
			arr[k] = i;
			backtracking(k + 1);

		}
	}
}
