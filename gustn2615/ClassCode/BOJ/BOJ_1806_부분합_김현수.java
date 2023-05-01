package study_ssafy2;

/*
 * 투포인터를 활용해서 푸는 문제
 * 주의할점은 정렬을 해서 푸는 문제가 아니라 주어진 배열 순서 그대로 풀어야한다
 * 
 * 1. start와 end를 0으로 지정한다
 * 2. end를 늘려가면서 배열의 합을 구하고 주어진 sum값을 넘어가면 멈춘다.
 * 3. 이때의 문자열 길이를 저장 해둔다.
 * 4. start와 end를 1 늘려가면서 sum 값을 넘어가는 지 확인한다.
 * 5. 이때 문자열의 길이가 가장 작다면 저장해둔다.
 * 6. 가장 작은 문자열 결과를 출력한다.
 * 
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806_부분합_김현수 {
	static int num, sum;
	static int[] numbers;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		
		// num : 숫자의 개수 sum: 주어진 부분합
		num = Integer.parseInt(st.nextToken());
		sum = Integer.parseInt(st.nextToken());

		numbers = new int[num];

		// 배열에 숫자를 담는다
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < num; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		// 문자열의 최솟값을 저장해줄 변수
		int min = Integer.MAX_VALUE;

		// 포인터의 끝값 index를 나타내는 변수
		int end = 0;
		
		// start~end 까지의 숫자의 합을 담아줄 변수
		int tmpSum = 0;
		
		// i : start라고 생각하면 된다
		for (int i = 0; i < num; i++) {
			
			// end가 index를 넘어가지 않을 때까지
			// 부분합이 sum보다 작을때 까지 계속 진행
			while (end < num && tmpSum < sum) {
				
				// 부분합을 구해준다
				tmpSum += numbers[end++];
			}

			// 만약 전부 진행했는데 부분합이 넘지 않았다면 종료
			// 즉, 이 조건문에 들어가려면 모든 배열의 숫자의 합이 주어진 sum을 넘지 않았을 때다
			if (tmpSum < sum) {
				break;
			}

			// 만약 부분합의 길이가 최소라면 갱신 
			if (min > end - i) {
				min = end - i;
			}

			// start를 늘려주기전에 부분합에서 앞부분 원소를 빼준다
			tmpSum -= numbers[i];
		}

		// 결과출력
		System.out.println(min == Integer.MAX_VALUE ? 0 : min);

	}
}
