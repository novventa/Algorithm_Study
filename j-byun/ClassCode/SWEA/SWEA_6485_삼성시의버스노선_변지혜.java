import java.util.Scanner;

// 6485 삼성시의 버스 노선
// D3

// 문제
// 1~5000까지 번호가 붙어있는 버스 정류장
// N개의 버스 노선이 있는데...
// i번째 버스 노선은 번호가 Ai <= <= Bi 인 모든 정류장만을 다니는 버스 노선이다

// P개의 버스 정류장에 대해 각 정류장에 몇 개의 버스 노선이 다니는지 구하는 프로그램을 작성하라

// 조건
// N ( 1 ≤ N ≤ 500 )
// Ai, Bi ( 1 ≤ Ai ≤ Bi ≤ 5,000 )
// P ( 1 ≤ P ≤ 500 )
// Cj ( 1 ≤ Cj ≤ 5,000 )

// 풀이
// 5001크기의 배열에 1~5000번 까지의 버스 정류장을 만들고...
// A <= 배열 인덱스 <= B 를 만족하는 배열[인덱스]++ 해준다

// N개의 버스 노선에 대해 위 과정을 반복 실행 한 후
// 찾고차 하는 버스정류장 번호를 인덱스로 해서 배열 값을 출력하면
// 그 값이 해당 인덱스 번호의 정류장을 다니는 버스 노선의 개수이다

public class SWEA_6485_삼성시의버스노선_변지혜 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기
		
		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복 실행
			sb.append("#").append(tc).append(" "); // 출력 양식
			
			int[] busStop = new int[5001]; // 1~5000번까지의 버스 정류장
			
			int busCnt = sc.nextInt(); // 버스 노선 개수 N 입력받기
			
			for (int cnt = 0; cnt < busCnt; cnt++) { // N번 만큼 반복하며...
				int start = sc.nextInt(); // A 입력받기
				int end = sc.nextInt(); // B 입력받기
				
				// A~B인 버스 정류장을 다니는 버스 노선이니까 A~B까지 버스정류장에 지나는 버스 노선 하나 더해주기
				for (int idx = start; idx <= end; idx++) {
					busStop[idx]++;
				}
			}
			
			int busStopCnt = sc.nextInt(); // P 입력받기
			
			for (int cnt = 0; cnt < busStopCnt; cnt++) { // P번 만큼 반복하며...
				int busStopNum = sc.nextInt(); // C 입력받기
				
				sb.append(busStop[busStopNum] + " "); // C번 버스정류장을 지나는 버스 노선의 개수 출력
			}
			
			sb.append("\n"); // 테케 하나 끝나면 개행
		}
		
		System.out.println(sb); // 출력
	}

}
