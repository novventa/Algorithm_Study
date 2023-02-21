import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2851 슈퍼 마리오
// 브론즈1

// 문제
// 10개의 버섯이 일렬로 놓여져 있다
// 이 버섯을 먹으면 점수받음

// 버섯을 처음부터 순서대로 집을건데
// 모든 버섯 다 안줍고 중도포기해도됨
// 중도포기하면 그 뒤의 버섯은 싹 다 못먹음

// 점수의 합을 최대한 100에 가깝게 했을 때의 점수를 출력하시오

// 풀이
// 순서대로 버섯 먹고
// 합이 100 넘으면 100-이전값 과 지금값-100 을 비교해서
// 차이가 적은 애를 남긴다
//	=> 둘이 차이가 똑같으면 큰거 출력

public class BOJ_2851_슈퍼마리오_변지혜 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] mushrooms = new int[10]; // 버섯 10개의 점수 저장할 배열

		int score = 0; // 최종 점수 저장할 공간

		for (int idx = 0; idx < 10; idx++) { // 버섯 배열에 각 버섯의 점수입력받기
			mushrooms[idx] = Integer.parseInt(br.readLine());
		}

		for (int idx = 0; idx < 10; idx++) { // 버섯 순서대로 확인하면서 먹기
			if (score + mushrooms[idx] >= 100) { // 점수가 100을 넘으면 이전까지의 값이랑 지금까지의 값 비교해서 100에서 차이가 적은 애를 살리자
				if ((100 - score) >= (score + mushrooms[idx] - 100)) { // 둘이 차이가 같으면 더 큰 값을 살리자
					score += mushrooms[idx];
					break;
				} else {
					break;
				}
			}

			score += mushrooms[idx]; // 점수가 100을 안넘으면 그냥 버섯 먹어
		}
		
		System.out.println(score);

	}

}
