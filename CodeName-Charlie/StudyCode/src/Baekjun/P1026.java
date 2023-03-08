
// 옛날 옛적에 수학이 항상 큰 골칫거리였던 나라가 있었다. 이 나라의 국왕 김지민은 다음과 같은 문제를 내고 큰 상금을 걸었다.
// 길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.
// S = A[0] × B[0] + ... + A[N-1] × B[N-1]
// S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안 된다.
// S의 최솟값을 출력하는 프로그램을 작성하시오.

package Baekjun;

// 두 수의 곱의 크기를 작게 만들기 위해서는...
// 큰 수와 작은 수를 곱해야한다.
// 각 배열을 오름차순과 내림차순으로 정렬한 뒤,
// 각각의 요소값을 곱하고,
// 선언한 변수 S에 순차적으로 더한다.
// S를 출력하자.

import java.util.Arrays;
import java.util.Scanner;

public class P1026 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 배열의 길이를 나타내는 변수 N을 입력 받는다.
		
		int[] A = new int[N]; // 배열 A를 생성하고,
		int[] B = new int[N]; // 배열 B를 생성한 뒤,
		int[] newA = new int[N]; // 배열 A를 정렬 후, 그 값을 새로 입력 받을 배열 newA를 생성한다.
		
		for(int idx = 0; idx < N; idx++) { // 반복문을 통해,
			A[idx] = sc.nextInt(); // 배열 A와
		}
		
		for(int idx = 0; idx < N; idx++) {
			B[idx] = sc.nextInt(); // 배열 B의 값을 순차적으로 입력 받는다.
		}
		
		Arrays.sort(A); // 배열 A와
		Arrays.sort(B); // B를 Arrays.sort 메서드를 통해 오름차순으로 정렬한다.
		
		int i = N-1; // 변수 i를 선언하면서, 그 값을 각 배열에서 가장 큰 인덱스 값인 N-1로 초기화하고,
		for(int idx = 0; idx < N; idx++) { // for문을 통해,
			newA[i] = A[idx]; // newA 배열에 마지막 요소값에 A배열의 첫 번째 요소값을, N-2 번째 요소값에는 두 번째 요소값을 대입한다.
			// => newA 배열을 내림차순으로 정렬시키기 위해서...
			i--; // 변수 i를 1 감소시킨다.
		}
		
		int S = 0; // 합을 나타내는 변수 S를 선언하고, 0으로 초기화한다.
		for(int idx = 0; idx < N; idx++) { // 반복문을 사용해,
			S += (newA[idx] *B[idx]); // newA 배열의 요소값과 B배열의 요소값의 곱을 순차적으로 더해준다. 
		}
		System.out.println(S); // 변수 S를 출력한다.
	}
}
