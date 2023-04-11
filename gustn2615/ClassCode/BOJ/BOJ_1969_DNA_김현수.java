package study_ssafy2;

/*
 * 1. count 배열을 이용해서 주어진 단어들의 각 위치마다 존재하는 알파벳의 개수를 세어준다.
 * 2. 0번째 index : A  1번째 index : C 2번째 index : G  3번째 index : T
 * 3. 이때 count값이 가장 큰 index를 찾아 그 index의 알파벳으로 단어를 만들어 준다.
 * 4. 만약 가장 큰값이 여러개라면 가장 앞부분의 index를 골라준다
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1969_DNA_김현수 {
	static int DNANum, length, min;
	static String[] DNA;

	// A, C, G, T 
	static int[] count;
	static char[] alphabet = { 'A', 'C', 'G', 'T' };

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		String[] str = br.readLine().trim().split(" ");

		DNANum = Integer.parseInt(str[0]);
		length = Integer.parseInt(str[1]);

		DNA = new String[DNANum];

		// 단어를 받아온다
		for (int i = 0; i < DNANum; i++) {
			DNA[i] = br.readLine().trim();
		}
		br.close();

		// hamming distance 합을 구할 변수
		min = 0;
		
		// 단어의 각 위치별로 돌면서
		for (int i = 0; i < length; i++) {
			
			// 각 위치별로 알파뱃의 개수를 카운팅 해줄 배열
			count = new int[4];
			
			// 전체 단어를 돌면서 알파벳 개수를 카운팅 한다
			for (int j = 0; j < DNANum; j++) {
				if (DNA[j].charAt(i) == 'A') {
					count[0]++;
				} else if (DNA[j].charAt(i) == 'C') {
					count[1]++;
				} else if (DNA[j].charAt(i) == 'G') {
					count[2]++;
				} else if (DNA[j].charAt(i) == 'T') {
					count[3]++;
				}
			}
			
			// 해당위치에서 가장 많은 알파벳 개수 받아올 변수
			int maxMatch = 0;
			
			// 가장 많은 알파벳의 index 번호를 받아올 변수
			int maxIndex = 0;
			
			// count 배열을 돌면서
			for (int k = 0; k < 4; k++) {
				
				// 알파벳 개수가 가장 많은 것을 찾고 갱신해준다
				if (count[k] > maxMatch) {
					maxMatch = count[k];
					maxIndex = k;
				}
			}
			
			// hamming distance 합에 더해주고
			min += (DNANum - maxMatch);
			
			// 알파벳은 stringbuilder에 넣어서 단어로 만들어준다
			sb.append(alphabet[maxIndex]);
		}
		
		// hamming distance 값 또한 넣어준다
		sb.append("\n").append(min);

		// 출력
		System.out.println(sb);
	}
}
