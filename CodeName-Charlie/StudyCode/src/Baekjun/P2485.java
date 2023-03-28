package Baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2485 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] position = new int[N];

		for (int idx = 0; idx < N; idx++) {
			position[idx] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(position);
		
		int min = Integer.MAX_VALUE; // 가로수 사이의 간격의 최소값.
		for(int idx = 0; idx < N-1; idx++) {
			if(min > position[idx+1] - position[idx]) {
				min = position[idx+1] - position[idx];
			}
		}
		
		int area = position[N - 1] - position[0]; // 전체 가로수 사이의 거리

		int number = 0;
		int max = 0;
		for (int num = min; num >= 1; num--) { 
			if (area % num == 0) {
				number = position[0];	// position [1 3 7 13]  1 3 5 7 .. 
				int[] check = new int[N]; // check [1 1 1 1]
				int i = 0;
				while (number <= position[N - 1]) {
					if (number == position[i]) {
						check[i]++;
						i++;
					}
					number += num;
				}
				boolean flag = true;
				for (int idx = 0; idx < N; idx++) {
					if (check[idx] == 0) {
						flag = false;
						break;
					}
				}
				if (flag == true) {
					max = num;
					break;
				}

			}
		}
		
		int result = (area / max) - 1 - (N - 2);
		System.out.println(result);
	}
}
