import java.util.Scanner;

// 1859 백만 장자 프로젝트
// D2

// 문제
// 미래를 보는 능력으로 사재기를 해서 이익을 남기자
// n일 동안의 물건의 매매가를 알고 있다
// 하루에 최대 1만큼만 구입할 수 있다
// 판매는 개수 제한 없음

// 조건
// 매매가를 알고 있는 날짜 자연수 N(2 ≤ N ≤ 1,000,000)
// 각 날의 매매가 <= 10,000
// 10,000 * 1,000,000 => 총 이익은 long형으로 만들자! 

// 풀이
// 매매가를 알고 있는 제일 마지막 날부터 거꾸로 진행하면서...
// 현재 가격이 여태까지의 가격중 최대 가격이면 max에 저장해놓고
// 그 전날 가격이 더 싸면 max와의 차액을 총 이익에 더해준다
// 진행하다가 더 큰 max 가격을 발견하면 업데이트하고
// 그 전날 가격이 더 싸면 max와의 차액을 총 이익에 더해준다

public class SWEA_1859_백만장자프로젝트_변지혜_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기

		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복 실행

			int days = sc.nextInt(); // 매매가를 알고있는 날짜 입력받기

			int[] cost = new int[days]; // 각 날짜의 매매가를 저장할 배열

			for (int idx = 0; idx < days; idx++) { // 각 날짜의 매매가 저장하기
				cost[idx] = sc.nextInt();
			}

			long profit = 0; // 총 이익을 저장할 공간
			int maxCost = Integer.MIN_VALUE; // 여태까지 확인한 매매가 중 최고가를 저장할 공간

			for (int idx = days - 1; idx >= 0; idx--) { // 마지막 날부터 거꾸로 확인하면서
				if (maxCost < cost[idx]) { // 현재까지 확인한 매매가 중 오늘 가격이 최고가이면
					maxCost = cost[idx]; // 최고가 금액 업데이트

				} else { // 오늘 매매가가 최고가가 아니면
					profit += maxCost - cost[idx]; // 최고가 - 오늘 금액의 차익을 총 이익에 더해주자 }
				}
			}

			System.out.printf("#%d %s\n", tc, profit);
		}
	}

}


