import java.util.Scanner;

// 1860 진기의 최고급 붕어빵
// D3

// 라이브강의 교수님 풀이방법대로 다시 풀어본 코드

// 문제
// 예약제 붕어빵
// n명의 사람이 붕어빵을 사러 올건데
// 진기는 m초에 k개의 붕어빵을 만들 수 있음
// 손님이 도착했을 때 모든 손님이 기다리지 않고 붕어빵을 살 수 있으면 possible,
// 한 명이라도 기다려야 되면 impossible 출력

public class SWEA_1860_진기의최고급붕어빵_변지혜_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기
		
		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복 실행
			
			int peopleCnt = sc.nextInt(); // 손님의 수
			int bakeTime = sc.nextInt(); // 진기가 붕어빵 굽는 시간
			int bakedFish = sc.nextInt(); // 진기가 붕어빵 굽는 시간 동안 구울 수 있는 붕어빵 개수
			
			int[] visit = new int[11112]; // 각 초에 도착하는 손님의 수를 저장할 배열
			
			for (int cnt = 0; cnt < peopleCnt; cnt++) { // 각 손님이 도착하는 시간
				visit[sc.nextInt()]++;
			}
			
			String result = "Possible"; // 결과를 일단 possible로 가정하고 확인하기
			int fish = 0; // 구워진 붕어빵 저장할 공간
			
			for (int time = 0; time < 11112; time++) {
				
				if (time != 0 && time % bakeTime == 0) { // m초마다
					fish += bakedFish; // k개의 붕어빵 굽기
				}
				
				fish -= visit[time]; // 해당 초에 도착하는 손님이 있다면 손님 수 만큼 붕어빵 팔기
				
				if (fish < 0) { // 만약 붕어빵이 충분하지 않다면
					result = "Impossible"; // 결과를 impossible로 바꾸고
					break; // 더 이상 손님 받지 않고 종료
				}
				
			}
			
			System.out.printf("#%d %s\n", tc, result);
		}
		
	}

}