package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2309 일곱 난쟁이
// 브론즈1

// 문제
// 난쟁이가 9명
// 이 중에 진짜 7명 찾아서
// 키를 오름차순으로 한 줄 씩 출력

// 조건
// 일곱 난쟁이 키의 합은 100

public class BOJ_2309_일곱난쟁이_변지혜 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 9 난쟁이의 키를 저장할 배열 만들기
		int[] dwarf9 = new int[9];
		
		// 9난쟁이의 키 입력받기
		for (int idx = 0; idx < 9; idx++) {
			dwarf9[idx] = Integer.parseInt(br.readLine());
		}
		br.close();
		
		// 진짜 7난쟁이를 저장할 배열 만들기
		int[] dwarf7 = new int[7];
		
		
		// 9난쟁이 중 둘만 빼고 나머지의 키의 합 구하기
		outer : for (int fake1 = 0; fake1 < 8; fake1++) {
			for (int fake2 = fake1 + 1; fake2 < 9; fake2++) {
				// fake1 != fake2 여야 하고,
				// 어차피 키의 합 구할거라 순서 상관 없으니
				// fake2는 fake1 + 1부터 시작
				
				// 키의 합을 저장해서 7난쟁이인지 확인할 sum 만들기
				int sum = 0;
				
				for (int real = 0; real < 9; real++) {
					if (real != fake1 && real != fake2) { // 둘만 빼고 나머지
						sum += dwarf9[real];
					}
				}
				
				// if 키의 합이 100이면
				// 이 때 fake1이랑 fake2 뺀 나머지 7명이 진짜임!
				// => 둘 뺀 나머지 7난쟁이를 7난쟁이 배열에 저장하기
				if (sum == 100) {
					
					int idx = 0;
					
					for (int real = 0; real < 9; real++) {
						if (real != fake1 && real != fake2) {
							dwarf7[idx++] = dwarf9[real];
						}
					}
					
					// 키가 100일 때 진짜 7난쟁이를 찾았으니
					// 더 이상 탐색하지 말고 break outer
					break outer;
				}
				
			}
		}
		
		// 7난쟁이 배열을 오름차순으로 정렬하기
		// 버블정렬
		for (int pass = 0; pass < 6; pass++) {
			for (int idx = 0; idx < 6; idx++) {
				if (dwarf7[idx] > dwarf7[idx + 1]) {
					int tmp = dwarf7[idx];
					dwarf7[idx] = dwarf7[idx + 1];
					dwarf7[idx + 1] = tmp;
				}
			}
		}
		
		// 출력
		for (int idx = 0; idx < 7; idx++) {
			bw.write(dwarf7[idx] + "\n");
		}
		bw.flush();
		bw.close();
		
	}

}


