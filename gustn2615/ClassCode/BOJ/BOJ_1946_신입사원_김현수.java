package study_ssafy;

/*
 * 문제를 제대로 이해하는게 가장 중요하다.
 * 
 * 1. 서류나 면접 등수 중 둘중 하나를 기준으로 정렬한다
 * 2. 이후 1등인 면접자를 하나 뽑는다 (서류 점수를 기준으로 뽑앗다고 하자)
 * 3. 서류 1등인 면접자의 면접 등수를 최소라고 가정한다
 * 4. 이후 서류 2등인 면접자들의 면접 등수가 서류 1등의 면접 등수보다 높은자들만 합격을 시키면 된다.
 * 5. 이때 합격한 사람이 있는 경우 면접 등수의 최솟값을 합격한 사람의 면접 등수로 갱신해 주어야한다
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class solution_1946_신입사원_김현수 {
	static int T, N;
	static int[][] person;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		// 테스트 케이스 횟수 받아오기
		T = Integer.parseInt(br.readLine().trim());
		
		// 테스트 케이스 횟수만큼 반복
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			person = new int[N][2];
			
			// person[i][0] : 서류 등수
			// person[i][1] : 면접 등수
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				person[i][0] = Integer.parseInt(st.nextToken());
				person[i][1] = Integer.parseInt(st.nextToken());
			}

			// 서류 등수를 기준으로 정렬
			Arrays.sort(person, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {

					return o1[0] - o2[0];

				}
			});

//			for (int[] arr : person)
//				System.out.println(Arrays.toString(arr));

			// 1등의 면접 등수를 최소라고 가정
			int min = person[0][1];
			
			// 뽑은 사람의 수
			int count = 1;
			
			// 반복문을 돌면서
			for (int i = 1; i < N; i++) {
				
				// 만약 최소 등수 보다 더 작다면
				if (min > person[i][1]) {
					
					// 사람을 뽑고
					count++;
					
					// 최솟값을 갱신한다
					min = person[i][1];
				}
			}
			
			// 사람 개수를 출력한다
			System.out.println(count);
		}
		
		// 버퍼 사용 종료
		br.close();
	}
}
