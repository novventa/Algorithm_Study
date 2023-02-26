import java.util.Scanner;

// 3052 나머지
// 브론즈2

// 문제
// 나머지 연산자 %
// 수 10개를 입력받아서, 각 수를 42로 나눈 나머지 구하기
// 	=> 서로 다른 값이 몇 개인지 출력

// 조건
// 0 <= 입력되는 수 <= 1000

// 풀이
// 0~41 까지 크기 42짜리 카운팅 배열 만들어서
// 배열[나머지] = 1로 만들고
// 카운팅 배열 돌면서 개수 세기

public class BOJ_3052_나머지_변지혜 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] mod = new int[42];
		
		for (int tc = 1; tc <= 10; tc++) { // 수 10개 입력받아서 반복 실행
			int num = sc.nextInt(); // 수 입력받고
			
			mod[num % 42] = 1; // 입력받은 수를 42로 나눈 나머지를 인덱스로해서 mod배열 해당 칸 1로 만들기
								// 서로 다른 나머지의 개수만 필요하니까 ++하지 않고 무조건 1로 만든다
		} // 10개 입력받아서 배열의 해당 칸 1로 만들었으면
		
		int result = 0; // 서로 다른 나머지 개수 저장할 공간
		
		for (int idx = 0; idx < 42; idx++) { // 배열 돌면서 확인해서 1인 칸 개수 세기
			result += mod[idx];
		}
		
		System.out.println(result); // 서로 다른 나머지 개수 출력

	}

}
