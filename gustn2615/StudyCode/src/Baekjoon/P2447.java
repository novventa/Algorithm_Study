package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2447 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		char[][] stars = new char[T][T];
		Star(T, stars);
		br.close();
	}

	public static void Star(int size, char[][] stars) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {

				if (row >= size / 3 && row < 2 * size / 3 && col >= size / 3 && col < 2 * size / 3) {
					stars[row][col] = ' ';
				} else {
					stars[row][col] = '*';
					if (size / 3 >= 3) {
						Star(size / 3, stars);
					}
				}
			}
			
		}
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				System.out.print(stars[row][col]);
			}System.out.println();
		}
		
		
		bw.flush();
		bw.close();
	}
}
