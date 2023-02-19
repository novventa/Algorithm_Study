package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class P2063 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 점수 갯수 입력받기
		int N = sc.nextInt();
		// 크기가 N인 배열 선언
		int[] arr = new int[N];
		
		// 점수 입력받아 배열 채우기
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
//		Arrays.sort(arr);
//		System.out.println(arr[N/2]);
		
		// 선택정렬 알고리즘 (오름차순)
		for (int i = 0; i < arr.length - 1; i++) {
			// 최소값의 인덱스를 minIdx에 저장
			int minIdx = i;
			// 최소값의 다음 인덱스의 요소와 비교
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}
			// 위치 바꾸기
			int tmp = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = tmp;
		}

		// 중간값 찾기 및 출력
		
		System.out.println(arr[N/2]);
		
	}
}
