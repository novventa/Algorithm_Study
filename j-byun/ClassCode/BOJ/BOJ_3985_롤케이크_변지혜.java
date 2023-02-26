import java.util.Scanner;

// 3985 롤 케이크
// 브론즈1

// 문제
// 길이 L미터의 롤케이크 -> 방청객 N명에게 나누어 주기

// 1미터 단위로 잘라서 1번~N번까지로 나눠놓고
// 방청객이 P, K의 숫자를 적어서 내면
//	=> P번~K번 조각 다 달라는거
// 근데 1번 방청객부터 찜해서 뒤에 애는 앞에 애가 찜한 조각은 못가져감

// 가장 많은 케이크 조각을 받을 것으로 기대한 방청객의 번호 -> K - P가 최대인 사람
// 실제로 가장 많은 케이크 조각을 받은 방청객의 번호 -> 케이크 배열 다 돌면서 방청객 번호 카운팅해서 제일 큰 사람

// 조건
// 1 <= 롤케이크 길이 L <= 1000
// 1 <= 방청객의 수 N <= 1000
// 1 <= P <= K <= L

// 풀이
// 케이크 배열의 값이 0이 아닐 때만 방청객 선점하기
// 케이크 수가 같으면 번호가 작은 사람 출력해야 되니까 등호 빼기

public class BOJ_3985_롤케이크_변지혜 {
	static Scanner sc = new Scanner(System.in);

	static int rollSize;
	static int[] roll;
	static int audienceSize;
	static int[] audience;

	static int wishMax;
	static int wishMaxIdx;
	static int realMax;
	static int realMaxIdx;

	public static void divideRolls() { // 롤케이크 나누는 method
		int start;
		int end;

		for (int audienceCnt = 1; audienceCnt <= audienceSize; audienceCnt++) { // 방청객 수 만큼 반복

			start = sc.nextInt(); // 가져가고 싶은 조각의 시작 번호
			end = sc.nextInt(); // 가져가고 싶은 조각의 끝 번호

			// 가장 많은 조각을 받을 것으로 기대하는 방청객 업데이트하기
			if (wishMax < end - start) { // 최대 조각이 같으면 인덱스 번호가 작은 애 출력해야되니까 등호 빼기
				wishMax = end - start;
				wishMaxIdx = audienceCnt;
			}

			for (int rollIdx = start; rollIdx <= end; rollIdx++) { // 롤케이크의 p~k조각 까지 돌면서 선점한 사람이 없으면 지금 방청객한테 주기
				if (roll[rollIdx] == 0) { // 아무도 안가져간 조각이면
					roll[rollIdx] = audienceCnt; // 현재 방청객이 먹고
					audience[audienceCnt]++; // 현재 방청객이 가져간 케이크 +1 해주기

					// 실제로 가장 많은 조각을 받은 방청객 업데이트 하기
					if (realMax < audience[audienceCnt]) { // 현재 방청객이 가져간 케이크가 여태까지의 최고 개수보다 크면
						realMax = audience[audienceCnt];
						realMaxIdx = audienceCnt; // 가져간 케이크 수랑 가져간 사람 번호 업데이트하기
					}
				}
			}
		}
	}

	public static void main(String[] args) {

		rollSize = sc.nextInt(); // 롤케이크 길이 L

		roll = new int[rollSize + 1]; // L길이의 롤케이크 (인덱스 계산 귀찮으니까 0번 빼고 생각하기)

		audienceSize = sc.nextInt(); // 방청객 수 N

		audience = new int[audienceSize + 1]; // 각 방청객이 가져갈 롤케이크 조각의 개수 저장할 공간 (인덱스 계산 귀찮으니까 0번 빼고 생각)

		wishMax = Integer.MIN_VALUE; // 롤 케이크 조각을 가장 많이 가져갈 것으로 기대하고 있던 사람이 원하던 케이크 개수
		realMax = Integer.MIN_VALUE; // 실제로 롤 케이크 조각을 가장 많이 가져간 사람이 가져간 케이크 개수

		divideRolls(); // 롤케이크 나누기

		System.out.println(wishMaxIdx); // 가장 많이 가져갈거라고 기대하던 사람 출력
		System.out.println(realMaxIdx); // 진짜로 가장 많이 가져간 사람 출력

	}

}
