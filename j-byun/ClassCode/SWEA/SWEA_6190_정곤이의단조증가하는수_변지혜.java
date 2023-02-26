import java.util.Arrays;
import java.util.Scanner;

// 6190 정곤이의 단조 증가하는 수
// D3

// 문제
// 규칙을 만족하는 수 찾기
// 규칙 : 단조 증가하는 수 -> 각 숫자의 자릿수가 단순하게 증가하는 수
// k자리 수 X=abcde일 때 a <= b <= c <= d <= e 를 만족하면 단조 증가임
// 단조 증가 O : 111566, 233359
// 단조 증가 X : 12343, 999888

// 정수 n개 주어짐
// 1 <= i < j <= n 인 i, j에 대해 i번째값*j번째값 이 단조 증가하는 수인 것들을 구하고
// 	=> 그 중 최댓값 출력

// 풀이
// 두 수 뽑아서 곱하고 
// 곱한 수의 각 자리 수 비교하기
//	=> 일단 true로 가정하고, 확인하면서 < 작으면 false break;
//		=> 최대값 하나만 필요하니까 두 개 뽑아서 곱한 값을 배열에 저장하고,
//			=> 배열에 저장한 값을 정렬해서 제일 큰 값부터 단조 증가하는 수 인지 확인하기

public class SWEA_6190_정곤이의단조증가하는수_변지혜 {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();

	static int size;
	static int[] list;
	static boolean[] isUsed;
	static int[] pickedNums;
	static boolean isMonotonicIncreasing;
	static int maxNum;
	static int[] multipliedNum;
	static int index;

	public static void receiveInputData() { // 데이터 입력받는 method
		size = sc.nextInt(); // 정수 n 입력받기
		list = new int[size]; // n개의 수를 저장할 list 초기화
		isUsed = new boolean[size]; // isUsed배열을 n크기로 초기화
		pickedNums = new int[2]; // 뽑은 두 수를 저장할 배열 초기화
		multipliedNum = new int[size * (size - 1) / 2]; // 두 수의 곱을 저장할 배열 만들기
		index = 0; // multipliedNum배열의 인덱스를 나타낼 index의 초기값 0으로 지정
		
		maxNum = -1; // 최대값을 일단 -1으로 가정하기

		for (int idx = 0; idx < size; idx++) { // n개의 정수를 리스트에 넣기
			list[idx] = sc.nextInt();
		}
		
	}

	public static void pickNums() { // n개의 수 중 2개 고르기

		for (int num1 = 0; num1 < size - 1; num1++) { // 서로 다른 수 수 뽑아서
			for (int num2 = num1 + 1; num2 < size; num2++) {
				multipliedNum[index++] = list[num1] * list[num2]; // 뽑은 두 수 곱해서 배열에 저장하기
			}
		}
		
//		if (depth == 2) { // 2개의 수 다 골랐으면
//			multipliedNum[index++] = pickedNums[0] * pickedNums[1]; // 뽑아낸 두 수 곱해서 배열에 저장하기
//			return;
//		}
//
//		for (int idx = 0; idx < size; idx++) {
//			if (!isUsed[idx]) { // 현재 인덱스의 값이 사용되지 않았으면
//				isUsed[idx] = true; // 사용하자
//				pickedNums[depth] = list[idx]; // 현재 인덱스의 값을 pickedNums배열에 저장하기
//				backtracking(depth + 1); // 다음 값 뽑으러 가기
//				isUsed[idx] = false; // 다 뽑았으면 다시 사용되지 않은 상태로 바꿔주기
//			}
//		}

	}

	public static void findMonotonicIncreasing() { // 단조증가하는 수 인지 찾는 method
		Arrays.sort(multipliedNum); // 두 수의 곱이 저장된 배열 오름차순 정렬하기
		int multipliedNumSize = multipliedNum.length; // 배열 크기 나타낼 변수 만들기
		
		for (int idx = multipliedNumSize - 1; idx >= 0; idx--) { // 오름차순 배열이니까 제일 큰 수 부터 확인하기
			isMonotonicIncreasing = true; // 일단 단조 증가하는 수라고 가정하고 시작
			
			String num = String.valueOf(multipliedNum[idx]); // 곱한 수를 string으로 변환
			
			for (int stringCnt = 1; stringCnt < num.length(); stringCnt++) { // 곱한 수의 자리수 - 1만큼 반복
				if (num.charAt(stringCnt - 1) > num.charAt(stringCnt)) { // 단조 증가하지 않으면
					isMonotonicIncreasing = false; // 단조 증가 여부를 false로 만들고
					break; // 더 확인할 필요 없으니까 끝내기
				}
			}
			
			if (isMonotonicIncreasing) { // 수의 모든 자리 다 확인했는데 단조 증가 수가 맞으면 maxNum에 저장하기
				maxNum = multipliedNum[idx];
				return; // 제일 큰 수 부터 확인했으니까 하나만 찾으면 끝
			}
			
		}
		
	}

	public static void main(String[] args) {

		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기

		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복
			sb.append("#").append(tc).append(" "); // 출력 양식

			receiveInputData(); // 데이터 입력받기

			pickNums(); // n개의 수 중 2개의 수 골라서 곱하기

			findMonotonicIncreasing(); // 곱한 수가 단조증가 수 인지 확인하기
			
			sb.append(maxNum).append("\n"); // method 실행 후 저장된 maxNum이 단조증가하는 수 중 최대값이다
			// 만약 단조증가하는 수가 없으면 maxNum은 초기값인 -1이다
		}

		System.out.println(sb); // 출력

	}

}
