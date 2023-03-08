package study_ssafy;

/*
 * 배열의 오름차순 정렬과 내림차순 정렬을 이용해서 풀어준다.
 * 이때 내림차순 정렬의 경우 Collections에 있는 reverseOrder을 사용한다
 * Collections는 기본적으로 Object를 상속한 클래스에 대해서 사용 가능한 인터페이스이므로,
 * String, Integer, Double 등과 같은 Object 타입에 배열은 sort에 Collections.reverseOrder() 사용이 가능하고
 * 기본타입인 int, double, char, float 등은 사용이 불가하므로
 * 기본타입의 배열을 Object를 상속하는 Wrapper 클래스로 박싱해주어야 역순정렬도 가능하다.
 * 
 * */
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class solution_1026_보물_김현수 {
	public static void main(String[] args) {
		
		// 스캐너 사용
		Scanner sc = new Scanner(System.in);
		
		// 배열크기 설정
		int N = sc.nextInt();
		
		// A랑 B 배열 받을 1차원 배열 설정
		// 이때 B는 내림차순 정렬 할 것 이므로 Integer로 설정
		int[] A = new int[N];
		Integer[] B = new Integer[N];
		
		// A, B 배열 받고
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			B[i] = sc.nextInt();
		}
		// 스캐너 종료
		sc.close();

		
		// A, B 정렬하고
		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());

		// 합구하기
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += A[i] * B[i];
		}
		
		// 출력
		System.out.println(sum);
	}
}
