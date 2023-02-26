import java.util.Scanner;

// 4613 러시아 국기 같은 깃발
// D4

// 문제
// 러시아 국기 만들기

// 이미 1*1칸 마다 흰파빨로 칠해져있는 n*m 크기의 깃발
//		=> 여기서 최소의 칸만 칠해서 러시아 국기로 만들자!

// 조건
// 제일 위에서부터 최소 1줄 이상은 다 흰색
// 그 다음부터 최소 1줄 이상은 다 파란색
// (나머지) 제일 밑에서부터 최소 1줄 이상은 다 빨간색

// 3 <= n, m <= 50
// W : 흰색
// B : 파란색
// R : 빨간색

// 풀이
// 깃발 배열을 n*3사이즈 배열로 바꿔서
//	각 줄의 하얀색개수, 파란색개수, 빨간색개수 로 나타낸다
//		=> 다시 색칠할 때 모든 칸 다시 확인하기 귀찮으니까

// 브루트포스 (완전탐색)
// 하얀색은 row 0에서부터 ++
// 빨간색은 하얀row +2부터 <n까지 ++
// 그 사이는 다 파란색

// 이 안에서 색칠하기 실행
// math.min해서 제일 작은 값 살리기

public class SWEA_4613_러시아국기같은깃발_변지혜 {

	static int[][] flag;
	static int rowSize;
	static int colSize;
	
	public static void originalFlag(int row, String read) { // 원래 깃발 상태를 입력받아서 W, B, R 개수로 나타내는 method
		
		for (int col = 0; col < colSize; col++) {
			char color = read.charAt(col); // 읽어온 줄의 문자들을 확인하면서
			
			if (color == 'W') // W면 0번인덱스++
				flag[row][0]++;
			
			if (color == 'B') // B면 1번인덱스++
				flag[row][1]++;
			
			if (color == 'R') // R이면 2번인덱스++
				flag[row][2]++;
			
		}
	}
	
	public static int flagPainting(int whiteRow, int redRow) { // 깃발을 러시아 국기로 만들기 위해 색칠하는 method
		int paintCnt = 0;
		
		for (int row = 0; row < rowSize; row++) { // 모든 행을 확인하며
			if (row <= whiteRow) // 처음줄 ~ 하얀 줄 까지는 하얀색으로 칠한다
				paintCnt += flag[row][1] + flag[row][2]; // 해당 줄의 파란색 개수, 빨간색 개수 더하기
			
			if (row > whiteRow && row < redRow) // 하얀줄 + 1 ~ 빨간줄 - 1 까지는 파란색으로 칠한다
				paintCnt += flag[row][0] + flag[row][2]; // 해당 줄의 하얀색 개수, 빨간색 개수 더하기
			
			if (row >= redRow) // 빨간줄 ~ 마지막 줄 까지는 빨간색으로 칠한다
				paintCnt += flag[row][0] + flag[row][1]; // 해당 줄의 하얀색 개수, 파란색 개수 더하기
		}
		
		return paintCnt; // 색칠한 횟수 반환
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기

		for (int tc = 1; tc <= testCase; tc++) {
			sb.append("#").append(tc).append(" "); // 출력 양식

			rowSize = sc.nextInt(); // 깃발의 행 입력받기
			colSize = sc.nextInt(); // 깃발의 열 입력받기

			flag = new int[rowSize][3]; // n*3사이즈 깃발 만들기 => 각 줄의 {하얀색 개수, 파란색 개수, 빨간색 개수}

			for (int row = 0; row < rowSize; row++) { // 깃발 입력받기
				String read = sc.next(); // 깃발 정보 한 줄 읽어와서

				originalFlag(row, read); // 깃발 정보 flag배열에 저장하기
			}

			int minPaintCnt = Integer.MAX_VALUE; // 최소 색칠 횟수를 최대값으로 정해놓기

			for (int whiteRow = 0; whiteRow < rowSize - 2; whiteRow++) { // 브루트포스 실행
				for (int redRow = whiteRow + 2; redRow < rowSize; redRow++) { // 하얀줄~빨간줄 사이가 파란줄이니까 흰빨 두개만 정하면됨

					int paintCnt = flagPainting(whiteRow, redRow); // 현재 정해진 흰줄, 빨간줄 조건으로 깃발 다시 칠하기
					minPaintCnt = Math.min(minPaintCnt, paintCnt); // 현재까지의 최소 색칠 횟수랑 이번에 확인한 색칠 횟수 중에 작은 값 저장하기
				}
			}

			sb.append(minPaintCnt).append("\n"); // 최소 색칠 횟수 출력
		}

		System.out.println(sb);
	}

}
