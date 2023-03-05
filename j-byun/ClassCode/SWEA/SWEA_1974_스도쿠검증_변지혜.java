import java.util.Scanner;

// 1974 스도쿠 검증
// D2

// 문제
// 스도쿠 : 가로9칸 세로9칸 표에 1~9까지 숫자를 채워넣는 숫자퍼즐
// 각 가로, 세로 줄에 1~9까지 숫자 한번씩만 넣기
// 3*3 크기의 작은 격자에도 1~9까지 숫자 겹치지 않게 한번씩만 넣기

// 스도쿠 조건을 만족하면 1, 만족하지 않으면 0 출력

// 조건
// 퍼즐은 모두 숫자로 채워진 상태로 주어진다
// 퍼즐의 각 칸의 숫자는 1이상 9이하의 정수이다

// 풀이
// 1~9까지의 번호를 인덱스로 갖는 배열을 만들어서
// 각 가로줄, 세로줄, 3*3 직사각형에 대해 해당 칸의 번호를 인덱스로 카운트하고
// 한 줄이 끝나면 1~9 배열의 값이 모두 1인지 확인하자
// 하나라도 1이 아니면 스도쿠 조건을 만족하지 못한다

public class SWEA_1974_스도쿠검증_변지혜 {
	static int[][] map = new int[9][9];
	
	public static boolean checkSudoku() { // 현재 map 상태가 스도쿠 조건을 만족하는지 확인하는 method
		
		for (int row = 0; row < 9; row++) { // 가로줄 다 확인
			int[] nums = new int[10];
			
			for (int col = 0; col < 9; col++) {
				nums[map[row][col]]++; // 현재 칸에 입력된 번호를 인덱스 번호로해서 카운팅 배열 ++
			}
			
			for (int idx = 1; idx < 10; idx++) { // 1~9까지 중 하나라도 두번 이상 나오거나, 한 번도 나오지 않았다면 스도쿠 조건을 만족하지 못함
				if (nums[idx] != 1) {
					return false; // 더 이상 탐색 불필요
				}
			}
		}
		
		for (int col = 0; col < 9; col++) { // 세로줄 다 확인
			int[] nums = new int[10];
			
			for (int row = 0; row < 9; row++) {
				nums[map[row][col]]++;
			}
			
			for (int idx = 1; idx < 10; idx++) {
				if (nums[idx] != 1) {
					return false;
				}
			}
			
		}
		
		// 3*3 작은 사각형 확인 => 가로 세로 조건을 다 만족했을 경우, 첫 번 째 사각형만 스도쿠 조건을 만족하면 다 만족한다
		int[] nums = new int[10];
		
		for (int row = 0; row < 3; row++) { 
			for (int col = 0; col < 3; col++) {
				nums[map[row][col]]++;
			}
		}
		
		for (int idx = 1; idx < 10; idx++) {
			if (nums[idx] != 1) {
				return false;
			}
		}
		
		return true; // 가로, 세로, 3*3 사각형을 다 확인했는데 스도쿠 조건을 만족하면 스도쿠다!
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기

		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복 실행
			sb.append("#").append(tc).append(" "); // 출력 양식
			
			for (int row = 0; row < 9; row++) { // map data 입력받기
				for (int col = 0; col < 9; col++) {
					map[row][col] = sc.nextInt();
				}
			}
			
			boolean isSudoku = checkSudoku(); // 스도쿠 조건을 만족하는지 확인
			
			if (isSudoku) { // 스도쿠 조건을 만족하면 1 출력
				sb.append(1).append("\n");
				
			} else { // 스도쿠 조건을 만족하지 못하면 0 출력
				sb.append(0).append("\n");
			}
			
		}

		System.out.println(sb); // 출력
	}

}