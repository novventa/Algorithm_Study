package study_ssafy;
/*
 * 1. 도핑을 내림 차순으로 정렬한다 (최고의 열량을 만들기 위해서는 열량이 가장 큰 토핑부터 선택해야한다)
 * 2. 도핑의 개수를 0개 1개 2개 늘려가면서 각각의 열량을 구한다
 * 3. 그 중 가장 최대값을 찾아서 출력한다.
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class solution_5545_최고의피자_김현수 {
	public static void main(String[] args) throws IOException {
		
		// 버퍼 리더를 사용해 변수를 받는다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 도핑의 개수
		int N = Integer.parseInt(br.readLine());
		
		// Tokenizer 사용
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 도우 가격과 토핑가격
		int doughPrice = Integer.parseInt(st.nextToken());
		int toppingPrice = Integer.parseInt(st.nextToken());

		// 도우 열량
		int doughC = Integer.parseInt(br.readLine());
		
		// 토핑 열량
		// 내림차순 정렬을 위해 integer 사용
		Integer[] toppingC = new Integer[N];
		
		// 토핑 열량 저장
		for (int i = 0; i < N; i++) {
			toppingC[i] = Integer.parseInt(br.readLine());
		}

		// 내림차순정렬
		Arrays.sort(toppingC, Collections.reverseOrder());

		// 열량의 최대값을 저장하기 위한 변수
		int max = Integer.MIN_VALUE;

		
		// i : 토핑 선택 개수
		for (int i = 0; i <= N; i++) {
			
			// 토핑 열량의 합을 구할 변수
			int sum = 0;
			
			// 선택한 토핑 개수만큼 열량의 합을 구한다
			for (int j = 0; j < i; j++) {
				sum += toppingC[j];
			}

			// 1원당 열량값을 구해서 최대값을 갱신
			max = Math.max(max, (doughC + sum) / (doughPrice + toppingPrice * i));

		}

		// 출력
		System.out.println(max);
	}
}
