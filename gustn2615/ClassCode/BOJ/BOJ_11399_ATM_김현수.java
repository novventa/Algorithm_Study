package study_ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 
 * Arrays.sort를 사용해서 정렬 후 누적합을 구하는 방법으로 문제를 푼다
 * 
 * */

public class solution_11399_ATM_김현수 {
	public static void main(String[] args) throws IOException {
		
		// 버퍼 리더 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 사람 명수 받아오기
		int personNums = Integer.parseInt(br.readLine());
		
		// 사람마다 걸리는 시간을 받아올 배열
		int[] personTime = new int[personNums];
		
		// Tokenizer 사용
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 배열에 사람별로 걸리는 시간 넣어주기
		for (int i = 0; i < personNums; i++) {
			personTime[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		// 이를 적게걸리는 순으로 정렬
		Arrays.sort(personTime);
		
		// 사람마다 걸리는 시간의 합을 더해줄 변수
		// 처음사람은 미리 더해주고 시작한다
		int sum = personTime[0];
		
		// 사람마다 걸리는 시간을 돌면서 누적합을 구해준다
		for (int i = 1; i < personNums; i++) {
			personTime[i] += personTime[i - 1];
			// 구한 누적합을 전체 걸리는 시간에 더해준다
			sum += personTime[i];
		}
		
		// 결과를 출력한다
		System.out.println(sum);

	}
}
