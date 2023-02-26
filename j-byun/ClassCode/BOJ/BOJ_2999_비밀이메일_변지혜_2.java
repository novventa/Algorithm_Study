import java.util.Scanner;

// 2999 비밀 이메일
// 브론즈1

// 문제
// 암호화해서 메일 보내기
// 1. R <= C && R * C = N(글자 수) 인 R과 C 고르기
//	=> 해당하는 경우가 여러 개면 R이 큰 값 선택
// 2. R행 C열 배열 만들기
// 3. 메세지를 행렬에 옮기기
//	=> 첫 번째 행 0열부터 C열까지 순서대로 채우고,
//		차례대로 두 번째 행, 세 번째 행 ... 내려가면서 채우기
// 4. 행렬에서 메세지 읽어오기
//	=> 첫 번째 열 0행부터 R행까지 순서대로 읽고,
//		차례대로 두 번째 열, 세 번째 열 ... 오른쪽으로 가면서 읽기

// => 암호해독 프로그램 만들기
//		=> 위의 암호화하기를 거꾸로 실행

// 조건
// 메세지는 알파벳 소문자로만 이루어져있다
// 메세지는 최대 100글자

// 풀이
// R행 C열 배열 만들어서
// 메세지를 첫 번째 열의 0행~R행 까지 채우고 ... 를 반복한 뒤 (세로로 쓰고)
// 메세지를 첫 번째 행의 0열~C열 까지 읽기 ... 를 반복한다 (가로로 읽기)

// 일단 R=1, C=N으로 초기값 설정하고...
// N <= 100 (100 = 10 * 10) 이라는 조건에 의해 R의 최대값은 10이니까
// 10~2 까지 다 나눠보고 나머지가 0인 경우...
// MATH.MIN = R, MATH.MAX = C 해서 현재 R보다 크면 R 업데이트하기


public class BOJ_2999_비밀이메일_변지혜_2 {
	
	static int size;
	static int mapRow;
	static int mapCol;
	
	
	public static void getMaxRow() { // R이 최대값일 때의 R, C 구하는 method
		
		for (int nr = 10; nr > 1; nr--) { // R이 최대인 경우만 찾을거니까 최대치인 10부터 거꾸로 내려오기
			int nc = size / nr;
			
			if (size % nr == 0 && nr <= nc) { // N이 R로 나누어 떨어지고, R <= C일 때
				mapRow = nr; // R, C값 업데이트
				mapCol = nc;
				return; // R이 최대일 때 하나만 찾아내고 종료하기
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 한 줄만 읽을거니까 스캐너로 읽기
		StringBuilder sb = new StringBuilder(); // 배열 돌면서 char 하나씩 읽어야되니까 stringbuilder로 읽기
		
		String code = sc.next(); // 암호 읽어오기
		size = code.length(); // 암호 길이 저장
		
		// 초기 R, C를 1*N 일 때의 값으로 지정
		mapRow = 1;
		mapCol = size;
		
		getMaxRow(); // max R 일 때의 R, C 찾기
		
		char[][] map = new char[mapRow][mapCol]; // 암호 문자를 입력할 R*C 사이즈의 map 만들기
		
		int codeIdx = 0; // 암호에서 읽어올 char를 나타낼 인덱스
		
		for (int col = 0; col < mapCol; col++) { // 암호 세로로 쓰기
			for (int row = 0; row < mapRow; row++) {
				map[row][col] = code.charAt(codeIdx++);
			}
		}
		
		for (int row = 0; row < mapRow; row++) { // 암호 가로로 읽어서 암호화 전 문자로 만들기
			for (int col = 0; col < mapCol; col++) {
				sb.append(map[row][col]);
			}
		}
		
		System.out.println(sb); // 출력
		
	}
	
}
