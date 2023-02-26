import java.util.Scanner;

// 7102 준홍이의 카드놀이
// D3

// 문제
// 카드 두 세트
// 한 세트 : 1~n번 까지
// 다른 세트 : 1~m번 까지

// 각 카드 세트에서 카드 한 장 씩 뽑아서 둘을 더함
// 	=> 더한 값 중 등장할 확률이 가장 높은 숫자는?
//		확률 같은게 여러 개면 오름차순으로 출력

// 풀이
// 브루트포스 (완전탐색)
// 1~n+m까지인 배열 만들어서
//	=> 인덱스 계산 귀찮으니까 n+m+1사이즈로 만들어서 인덱스번호 = 카드의 합 으로 표현
// 완전탐색해서 배열[뽑은 두 수의 합]++
//	=> 하면서 지금 배열의값이 이전까지의 최대값보다 크면 갱신
//		=> 배열 탐색하면서 최대값인 배열의 인덱스 차례대로 출력


public class SWEA_7102_준홍이의카드놀이_변지혜 {
	
	static StringBuilder sb = new StringBuilder();
	static int card1Max;
	static int card2Max;
	static int[] cardSumProbability;
	static int maxSum;
	
	public static void calculateCardSumProbability() { // 두 카드의 합 확률을 계산하는 method
		cardSumProbability = new int[card1Max + card2Max + 1]; // 두 카드의 합 확률을 저장할 배열
		maxSum = Integer.MIN_VALUE; // 확률 중 최대값을 일단 임의의 최소값으로 지정해놓기
		
		for (int card1 = 1; card1 <= card1Max; card1++) { // 두 카드 덱에서 하나씩 카드를 뽑아서
			for (int card2 = 1; card2 <= card2Max; card2++) {
				cardSumProbability[card1 + card2]++; // 두 카드의 합을 배열의 인덱스로 받아서 확률 +1
				
				maxSum = Math.max(maxSum, cardSumProbability[card1 + card2]); // ++한 확률이 여태 나왔던 확률의 최대값보다 크면 최대값 갱신
			}
		}
		
		
	}
	
	public static void findMaxProbability() { // 카드의 합 확률 중 최대 값의 인덱스를 찾는 method
		
		for (int idx = 1; idx <= card1Max + card2Max; idx++) { // 확률 배열을 돌면서
			if (cardSumProbability[idx] == maxSum) // 확인한 배열의 값이 최대값이면
				sb.append(idx + " "); // 출력한다
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기
		
		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복
			sb.append("#").append(tc).append(" "); // 출력양식
			
			card1Max = sc.nextInt(); // n입력받기
			card2Max = sc.nextInt(); // m입력받기
			
			calculateCardSumProbability(); // 두 카드의 합 확률 구하기
			
			findMaxProbability(); // 가장 확률이 높은 숫자 오름차순 순서대로 뽑아내기
			
			sb.append("\n"); // 출력양식
		}
		
		System.out.println(sb); // 출력
	}

}
