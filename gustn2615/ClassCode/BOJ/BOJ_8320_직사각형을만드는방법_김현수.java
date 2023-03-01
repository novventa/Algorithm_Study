package study_ssafy;

/*
 * 1. 백트래킹을 이용해서 만들 수 있는 직사각형의 개수를 찾고
 * 2. 이후 정사각형을 통해 만들 수 있는 정사각형의 개수를 찾는다
 * 
 * */
import java.util.Scanner;

public class solution_8320_직사각형을만드는방법_김현수 {
	
	// 백트래킹 함수를 사용하므로 변수를 전역변수로 설정
	static int square, count;
	static boolean[] isUsed;
	static int[] arr;

	public static void main(String[] args) {
		
		// 스캐너 사용
		Scanner sc = new Scanner(System.in);
		
		// 정사각형 개수 받아오기
		square = sc.nextInt();

		// 스캐너 사용 종료
		sc.close();
		
		// 백트래킹에 사용할 논리형 정의
		isUsed = new boolean[square];
		
		// 직사각형의 가로와 세로 길이를 담아줄 배열 생성
		arr = new int[2];
		
		// 만들 수 있는 사각형 개수 카운트
		count = 0;
		
		// 만들 수 있는 직사각형 확인
		backtracking(0, 0);
		
		// 정사각형의 개수 확인 후 카운트
		for (int i = 1; i <= square ; i++) {
			if (i * i <= square) {
				count++;
			}
		}
		
		// 총 개수 출력
		System.out.println(count);
	}

	static void backtracking(int k, int start) {
		
		// 원소가 두개가 되면
		if (k == 2) {
//			System.out.println(Arrays.toString(arr));
			
			// 두 원소의 곱이 사각형의 개수보다 작으면 카운트
			if (arr[0] * arr[1] <= square) {
				count++;
			}
			return;
		}

		// 직사각형의 두 길이를 중복없이 뽑는 반복문
		for (int i = start; i < square; i++) {
			if (!isUsed[i]) {
				isUsed[i] = true;
				arr[k] = i + 1;
				backtracking(k + 1, i + 1);
				isUsed[i] = false;
			}
		}
	}
}
