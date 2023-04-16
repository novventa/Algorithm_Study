package study_ssafy2;

/*
 * 조합을 이용해서 문제를 푼다.
 * 이때 갑옷을 만들 재료는 두개만 필요하므로 따로 메소드를 만들지 않고
 * 반복문을 사용해서 문제를 풀었다.
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1940_주몽_김현수 {
	static int N, num, count;
	static int[] armor;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		// 변수들 받아오기
		N = Integer.parseInt(br.readLine().trim());
		num = Integer.parseInt(br.readLine().trim());

		// 갑옷 재료를 넣을 배열
		armor = new int[N];

		st = new StringTokenizer(br.readLine().trim());

		// 갑옷 재료를 넣고
		for (int i = 0; i < N; i++) {
			armor[i] = Integer.parseInt(st.nextToken());
		}

		br.close();
		
		// 카운트 해줄 변수
		count = 0;

		
		// 두개를 중복없이 뽑으면서 갑옷을 만드는데 필요한 수와 일치하면 카운트 해준다
		for (int i = 0; i < N - 1; i++) {
			for (int j = i+1; j < N; j++) {
				if (armor[i] + armor[j] == num) {
					count++;
				}
			}
		}

		// 결과 출력
		System.out.println(count);
	}
}
