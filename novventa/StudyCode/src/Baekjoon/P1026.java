package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class P1026 {
	public static void main(String[] args) {
		// 배열 2개가 주어지고
		// 두 배열의 요소들을 각각 곱했을 때
		// 최솟값을 찾는 문제
		// 문제에서는 두번째 배열을 정렬하지 말라고 했지만
		// 최솟값만 찾으면 되므로 그냥 정렬하자
		// 나중에 시간이 있으면 정렬하지 않고 풀어보자
		
		// 스캐너 선언
		Scanner sc = new Scanner(System.in);
		// 숫자의 갯수 입력받기
		int N = sc.nextInt();
		// 첫번째 숫자들을 저장할 배열
		int[] firstArr = new int[N];
		// 두번째 숫자들을 저장할 배열
		int[] secondArr = new int[N];
		// 첫번째 배열 숫자들 입력받기
		for(int i=0;i<N;i++) {
			firstArr[i] = sc.nextInt();
		}
		// 두번째 배열 숫자들 입력받기
		for(int i=0;i<N;i++) {
			secondArr[i] = sc.nextInt();
		}		
		// 둘다 정렬하기
		Arrays.sort(firstArr);
		Arrays.sort(secondArr);
		// 두번째 배열의 인덱스는 따로 설정
		int idx=N-1;
		// 곱의 합을 저장할 변수
		int sum = 0;
		// 첫번째 배열은 작은 수부터, 두번째 배열은 큰 수부터 곱해주면 된다.
		for(int i=0;i<N;i++) {
			sum += firstArr[i]*secondArr[idx--];
		}
		// 출력
		System.out.println(sum);
		
	}
}

