import java.util.Arrays;
import java.util.Scanner;

// 1860 진기의 최고급 붕어빵
// D3

// 문제
// 자격 검증 합격자에 한해 예약제로 운영되는 최고급 붕어빵
// 오늘은 N명의 사람이 자격을 얻었다
// 진기는 0초~M초까지 K개의 붕어빵 만들 수 있다
// 붕어빵 제작 외의 다른 시간 지연 없음
// 특정 시간에 모든 손님들에게 기다리는 시간없이 붕어빵을 제공할 수 있는지 판별하라
// 모든 손님에 대해 기다리는 시간이 없이 붕어빵을 제공할 수 있으면 “Possible”을, 
// 											아니라면 “Impossible”을 출력

// 조건
// 세 자연수 N, M, K(1 ≤ N, M, K ≤ 100)
// 각 사람이 도착하는 초 0 <= <= 11,111

// 풀이
// 11,112사이즈의 배열에 m초마다 k개의 붕어빵 만들어서 저장하기
// 누적합 배열로 만들기
// 사람이 x초에 오면 배열의 x번째 인덱스에서 하나 빼가기
// 여태까지 빼간 붕어빵 개수를 저장해두고
//	=> 현재 인덱스의 붕어빵이 <= 여때까지 빼간 붕어빵 개수여서 빼갈 붕어빵이 없으면 impossible 출력

// 방문 시간이 순서대로 입력되지 않으니까 한꺼번에 입력받아서 오름차순 정렬하기
// => 안그러면 붕어빵 팔 때마다 붕어빵 배열 다 돌면서 붕어빵 개수 --해줘야됨

public class SWEA_1860_진기의최고급붕어빵_변지혜 {
	static Scanner sc = new Scanner(System.in);
	
	public static void bakeFish(int[] arr, int time, int fishSize) { // 붕어빵 굽기
		
		for (int idx = time; idx < arr.length; idx++) {
			if (idx % time == 0) // m초 마다
				arr[idx] += fishSize; // k개의 붕어빵 구워서 내보내기
			
			arr[idx] += arr[idx - 1]; // 누적합 배열로 만들기
		}
		
	}
	
	public static String sellFish(int[] fish, int[] visitTime, int peopleSize) {
		int soldFishCnt = 0; // 판매한 붕어빵의 개수
		
		for (int idx = 0; idx < peopleSize; idx++) { // 순서대로 방문하는 손님들에 대해
			int visit = visitTime[idx]; // 이번 손님이 방문할 시간
			
			if (fish[visit] > soldFishCnt) // 팔 수 있는 붕어빵이 있으면 판매
				soldFishCnt++; // 판매한 붕어빵 개수 +1
			
			else // 팔 수 있는 붕어빵이 없으면
				return "Impossible"; // 불가능 출력하고 그만 확인하기
			
		}
		
		return "Possible"; // 모든 손님 다 확인했는데 팔 수 있었으면 가능 출력하기
		
	}
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기
		
		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복
			sb.append("#").append(tc).append(" "); // 출력 양식
			
			int peopleSize = sc.nextInt(); // 오늘 붕어빵 예약한 사람 수 입력받기
			int time = sc.nextInt(); // 붕어빵 만드는 데 걸리는 시간 입력받기
			int fishSize = sc.nextInt(); // m초마다 만들 수 있는 붕어빵 개수 입력받기
			
			int[] prefixSumFish = new int[11112]; // 각 초에 사갈 수 있는 붕어빵 개수 저장할 공간
			
			bakeFish(prefixSumFish, time, fishSize); // 붕어빵 만들기
			
			int[] visitTime = new int[peopleSize];
			
			for (int idx = 0; idx < peopleSize; idx++) { // 손님들이 붕어빵 사러 방문하는 시간 입력받기
				visitTime[idx] = sc.nextInt();
			}
			
			Arrays.sort(visitTime); // 손님들을 방문시간 순서대로 정렬시키기
			
			String result = sellFish(prefixSumFish, visitTime, peopleSize); // 붕어빵 팔기
			
			sb.append(result).append("\n"); // 결과 문자열 출력
			
		}
		
		sc.close();
		System.out.println(sb);
	}

}
