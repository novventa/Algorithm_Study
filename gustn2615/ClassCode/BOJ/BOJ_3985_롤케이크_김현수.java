package study_ssafy;

/*
 * 
 * 카운팅 배열 알고리즘과 비슷하게 풀었습니다
 * 롤케이크의 번호가 첫번째가 1번 마지막이 L번이므로
 * L+1 크기의 배열을 만들어서 그 배열에 사람의 번호를 넣어주었습니다.
 * 배열의 index가 케이크 번호이며, 그 번호에 고른 사람 번호를 넣어준다.
 * 
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution_3985_롤케이크_김현수 {
	public static void main(String[] args) throws IOException {
		
		// 버퍼리더를 사용한다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 케이크의 크기를 받아온다.
		int L = Integer.parseInt(br.readLine()) + 1;
		
		// 고른케이크에 사람번호를 넣어줄 배열을 만든다
		int[] cake = new int[L];
		
		// 사람 명수를 받아온다
		int personNum = Integer.parseInt(br.readLine());
		
		// 가장 많은조각을 받을 것으로 기대되는 조각수 저장
		int max = 0;
		
		// 가장 많은 조각을 받을 것으로 기대되는 사람 번호를 저장할 변수
		int maxIndex = 0;
		
		// 가장 많은 조각을 받았을 때 조각 수를 받아올 변수
		int maxCount = 0;
		
		// 가장 많은 조각을 받은 사람 번호를 저장할 변수
		int maxCountIndex = 0;
		
		// 사람의 번호가 1부터 시작이기때문에 i는 1부터 시작한다
		for (int i = 1; i <= personNum; i++) {
			
			// 이사람이 받을 수 있는 케이크 개수를 count 할 변수
			// 새로운 사람으로 변할때마다 초기화 시킨다
			int count = 0;
			
			// tokenizer을 통해 받아온다
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 이사람이 선택한 케이크의 맨 앞번호와 뒷번호를 받아온다
			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());
			
			// 케이크를 쭉 훑으면서
			for (int idx = front; idx <= back; idx++) {
				
				// 만약 아무도 고르지 않았다면
				// 사람 번호를 넣어주고 케이크의 개수를 카운트한다
				if (cake[idx] == 0) {
					cake[idx] = i;
					count++;
				}
			}
			
			// 이 사람이 받을 것으로 기대하는 케이크 개수를 확인 후
			// 이게 max 값이면 개수를 저장하고
			// 사람 번호를 저장한다
			// 케이크 개수를 저장하는 이유는 다음 케이크 개수와 비교하기 위함이다.
			if (max < back - front) {
				max = back - front;
				maxIndex = i;
			}
			
			// 실제로 가장 많은 조각을 받았으면 maxCount에 저장한다
			// 사람 번호 또한 저장한다
			if (maxCount < count) {
				maxCount = count;
				maxCountIndex = i;
			}

		}
		
		// 버퍼리더 종료
		br.close();
		
		// 결과 출력
		System.out.println(maxIndex);
		System.out.println(maxCountIndex);

	}
}
