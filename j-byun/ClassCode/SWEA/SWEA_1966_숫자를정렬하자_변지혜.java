import java.util.Scanner;

// 1966 숫자를 정렬하자
// D2

// 문제
// 주어진 N길이의 숫자열을 오름차순으로 정렬하여 출력하라

// 조건
// 5 <= N <= 50

// 풀이
// 선택정렬로 정렬하자

public class SWEA_1966_숫자를정렬하자_변지혜 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기
		
		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복 실행
			sb.append("#").append(tc).append(" "); // 출력 양식
			
			int size = sc.nextInt(); // 숫자열 길이 입력받기
			
			int[] nums = new int[size]; // n의 크기를 갖는 배열 만들기
			
			for (int idx = 0; idx < size; idx++) { // 배열에 숫자 입력받기
				nums[idx] = sc.nextInt();
			}
			
			// 삽입정렬
			for (int pass = 1; pass < size; pass++) { // 0번 인덱스는 이미 정렬된 자리라고 가정하고 시작
				for (int idx = pass; idx > 0; idx--) { // 내 앞의 값들을 확인하면서
					if (nums[idx - 1] > nums[idx]) { // 나보다 내 앞의 값이 크면 둘이 자리를 바꾼다
						int tmp = nums[idx];
						nums[idx] = nums[idx - 1];
						nums[idx - 1] = tmp;
					}
						
				}
			}
			
			
			// 정렬된 배열의 원소 차례대로 출력하기
			for (int idx = 0; idx < size; idx++) {
				sb.append(nums[idx] + " ");
			}
			sb.append("\n"); // 테케 끝날 때 마다 개행
			
		}
		
		sc.close(); // 입력 다 받았으면 스캐너 닫기
		System.out.println(sb); // 출력
	}

}
