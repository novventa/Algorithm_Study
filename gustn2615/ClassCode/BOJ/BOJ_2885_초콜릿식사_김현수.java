package study_ssafy2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2885_초콜릿식사_김현수 {
	static int K, chocolateSize, sum, count;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		
		// 만들어야하는 정사각형 개수
		K = Integer.parseInt(br.readLine().trim());

		// 초콜릿 사이즈를 먼저 찾는다
		chocolateSize = 1;
		
		// K개보다 큰 초콜렛크기를 찾아야한다
		// 비트연산자를 통해 초콜릿 사이즈를 찾는다
		while (chocolateSize < K) {
			chocolateSize = chocolateSize << 1;
		}
		
		// 초콜릿 사이즈 출력
		System.out.print(chocolateSize + " ");

		// 쪼개는 횟수 
		count = 0;

		// 만약 K개의 정사각형이 초콜렛 크기와 갔다면
		if (K == chocolateSize) {
			
			// 0 출력
			System.out.print(count);
		} 
		
		// 초콜렛 크기와 같지 않다면
		else {
			
			// 초콜렛 개수가 K개가 될때까지 반복한다
			while (sum != K) {
				
				// 초콜렛을 자르고
				chocolateSize = chocolateSize >> 1;
			
				// 합에 초콜렛 개수를 더한다
				sum += chocolateSize;
				
				// 합이 K를 넘으면
				if (sum > K) {
					
					// 더한 초콜렛개수를 뺀다
					sum -= chocolateSize;		
				}
				
				// 잘랐다고 카운트해준다.
				count++;
			}
			
			// 출력한다.
			System.out.print(count);
		}
	}
}
