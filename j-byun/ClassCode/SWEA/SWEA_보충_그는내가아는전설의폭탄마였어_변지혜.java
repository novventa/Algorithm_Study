import java.util.Scanner;

// 그는 내가 아는 전설의 폭탄마였어

// 문제
// 2차원 배열의 맵 각 칸에는 폭탄을 터뜨려서 얻을 수 있는 행복이 주어진다
// 폭탄은 +모양, x모양으로 터뜨릴 수 있지만 따로 결정해주는 조건은 없다

// 폭탄의 폭발 범위가 0일때는 현재 칸만, 1일때는 d+1까지 ...로 범위가 설정된다

// 조건
// 맵 크기는 5이상 100이하
// 폭발 범위는 2 이상 100 이하
// 행복지수에 음수는 없다

// 폭탄 설치 위치와 터뜨릴 방향은 주어지지 않는다

// 풀이
// 완전 탐색 실행해서
// 한 칸 고른 후 해단 칸에서 +모양으로 터뜨렸을 때, x모양으로 터뜨렸을 때의 행복지수 중 큰 값을 저장하고
// 다음 칸에서 반복 실행하며 최대 행복지수로 업데이트 한다

public class SWEA_보충_그는내가아는전설의폭탄마였어_변지혜 {
	static int[][] map;
	static int maxHappiness;

	static int[] drPlus = new int[] { -1, 0, 1, 0 };
	static int[] dcPlus = new int[] { 0, 1, 0, -1 };

	static int[] drX = new int[] { -1, 1, 1, -1 };
	static int[] dcX = new int[] { 1, 1, -1, -1 };

	public static void searchPlusHappiness(int row, int col, int size, int range) {
		int happiness = 0;

		happiness += map[row][col];

		for (int direction = 0; direction < 4; direction++) {
			int dRange = 1;
			while (dRange <= range) {
				int nr = row + drPlus[direction] * dRange;
				int nc = col + dcPlus[direction] * dRange;
				
				if (nr < 0 || nr >= size || nc < 0 || nc >= size) break;
				
				happiness += map[nr][nc];

				dRange++;
			}
		}
		
		maxHappiness = Math.max(maxHappiness, happiness);
	}

	public static void searchXHappiness(int row, int col, int size, int range) {
		int happiness = 0;

		happiness += map[row][col];

		for (int direction = 0; direction < 4; direction++) {
			int dRange = 1;
			while (dRange <= range) {
				int nr = row + drX[direction] * dRange;
				int nc = col + dcX[direction] * dRange;
				
				if (nr < 0 || nr >= size || nc < 0 || nc >= size) break;
				
				happiness += map[nr][nc];

				dRange++;
			}
		}
		
		maxHappiness = Math.max(maxHappiness, happiness);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for (int tc = 1; tc <= testCase; tc++) {

			int size = sc.nextInt(); // 맵 사이즈
			int range = sc.nextInt(); // 폭발 범위

			map = new int[size][size]; // 맵 초기화

			for (int row = 0; row < size; row++) {
				for (int col = 0; col < size; col++) {
					map[row][col] = sc.nextInt(); // 맵 각 칸의 행복 입력
				}
			}

			maxHappiness = 0; // 행복지수 초기화

			for (int row = 0; row < size; row++) {
				for (int col = 0; col < size; col++) {
					searchPlusHappiness(row, col, size, range); // 최대 행복지수 찾기
					searchXHappiness(row, col, size, range);
				}
			}

			System.out.printf("#%d %d\n", tc, maxHappiness); // 출력
		}

		sc.close();
	}
}
