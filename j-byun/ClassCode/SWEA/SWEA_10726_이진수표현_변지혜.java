import java.util.Scanner;

/**
 * @author jihye.byun
 * SWEA 10726 이진수 표현 D3
 * 
 * 문제
 * 정수 N, M 이 주어질 때, M의 이진수 표현의 마지막 N 비트가 모두 1로 켜져 있는지 아닌지 판별하자.
 * 
 * 조건
 * 1 ≤ N ≤ 30
 * 0 ≤ M ≤ 10^8
 * 
 * 풀이
 * 1. 비트쉬프트를 활용하자
 * 2. N개의 마지막 비트가 1인 숫자를 만들자.
 * 2-1. 2^N - 1
 * 3. M을 2^N으로 나눈 나머지와 2-1의 숫자를 ^(XOR) 연산하자.
 * 4. 연산의 결과가 0 이면 ON, 0이 아니면 OFF를 출력하자.
 */

public class SWEA_10726_이진수표현_변지혜 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기
		
		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복 실행
			sb.append("#").append(tc).append(" "); // 출력양식
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// 대조군 값 만들기
			int control = (int) Math.pow(2, N) - 1;
			
			M = M % (control + 1); // M의 마지막 N개의 비트만 남기자
			
			// M과 control의 모든 비트를 비교했을 때 모두 일치하면 ON을 출력하고,
			// 하나라도 일치하지 않는 비트가 존재한다면 OFF를 출력하자.
			String result = ((M ^ control) == 0) ? "ON" : "OFF";
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb); // 출력
	}

}
