import java.util.Scanner;

// 2805 농작물 수확하기
// D3

// 문제
// N X N크기의 농장
// -> 농장의 크기는 항상 홀수이다
// -> 수확은 항상 농장의 크기에 딱 맞는 정사각형 마름모 형태로만 가능

// 조건
// 1 <= 농장크기 n <= 49
// 각 칸의 농작물 가치는 0~5 (int범위 안에서 해결 가능)

// 교수님 풀이
// 농장 크기는 항상 홀수니까
// 중앙 좌표 (n/2, n/2) 에서부터 현재 확인할 좌표의 차이가 n/2까지인 칸만 가치더하기
// 마름모꼴 : 중앙 칸에서부터 <= n/2번만큼 움직였을 때의 칸들

public class SWEA_2805_농작물수확하기_변지혜 {
	static int size;
	static int[][] farm;

	public static int abs(int leftValue, int rightValue) { // 절댓값 구하는 method
		int result = leftValue - rightValue;

		return (result < 0) ? -result : result; // result가 음수면 -result, 아니면 그냥 result를 반환하는 삼항연산자
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기

		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복
			sb.append("#").append(tc).append(" "); // 출력 양식

			size = sc.nextInt(); // 농장 크기 입력받기
			int mid = size >> 1; // 비트연산자 : /2한 결과가 나오지만 /2보다 연산 속도가 빠름
									// << 1 : *2

			farm = new int[size][size]; // n*n 크기의 농장 만들기

			for (int row = 0; row < size; row++) { // farm 배열에 농작물 가치 입력받기
				String line = sc.next();

				for (int col = 0; col < size; col++) {
					farm[row][col] = line.charAt(col) - '0';
				}
			}

			int grain = 0; // 농작물 가치 총 합 저장할 공간

			for (int row = 0; row < size; row++) { // 농작물 가치 구하기
				for (int col = 0; col < size; col++) {
					if (abs(row, mid) + abs(col, mid) <= mid) { // 절대값의 합이 mid보다 작거나 같을 때만
						grain += farm[row][col]; // 해당 칸의 농작물 수 더해주기
					}
				}
			}

			sb.append(grain).append("\n"); // 출력 양식
		}

		System.out.println(sb); // 출력
	}

}
