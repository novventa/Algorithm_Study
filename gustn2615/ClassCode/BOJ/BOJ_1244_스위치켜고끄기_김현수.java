package study_ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution_1244_스위치 {
	public static void main(String[] args) throws IOException {
		// 버퍼로 입력값 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 스위치의 개수를 받는다
		int N = Integer.parseInt(br.readLine());
		
		// 스위치의 on off를 넣을 배열 정의
		int[] switchStatus = new int[N];
		
		// 한줄을 읽어오면서 공백을 기준으로 string으로 숫자를 받는다
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			// 받은 숫자를 정수형으로 변환시켜 배열에 넣어준다
			switchStatus[i] = Integer.parseInt(st.nextToken());
		}
		
		// 학생의 수를 변수로 받는다
		int studentNum = Integer.parseInt(br.readLine());
		
		// 학생의 개수만큼 student 메소드를 불러온다.
		for (int i = 0; i < studentNum; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st1.nextToken());
			int num = Integer.parseInt(st1.nextToken());
			student(gender, num, switchStatus);
		}
		
		// 20개씩 나눠서 출력하기 위해 카운팅 정의
		int cnt = 0;
		
		// 배열의 길이만큼 반복하면서
		for (int i = 0; i < switchStatus.length; i++) {
			System.out.print(switchStatus[i] + " ");
			cnt++;
			// 20개를 출력 후 한줄 띄어준다.
			if (cnt % 20 == 0) {
				System.out.println();
			}
		}
	}

	// 학생의 성별과 뽑은 숫자에 따라 스위치를 끄고 키는 메소드
	public static void student(int gender, int num, int[] switchStatus) {
		
		// 남학생일 때
		if (gender == 1) {
			// 뽑은 숫자와 index가 1차이가 나므로
			// 3을 뽑으면 index 2부터 스위치가 시작되어야한다.
			for (int i = num-1; i < switchStatus.length; i++) {
				if ((i+1) % num == 0) {
					if (switchStatus[i] == 0) {
						switchStatus[i] = 1;
					} else {
						switchStatus[i] = 0;
					}
				}
			}
		}
		// 여학생일때
		else {
			// 뽑은 자리의 스위치를 바꾸고
			if (switchStatus[num-1] == 0) {
				switchStatus[num-1] = 1;
			} else {
				switchStatus[num-1] = 0;
			}
			
			// 주변으로 뻗어 나가면서
			// 서로 같은 값이면 바꿔준다
			int index = 1;
			while (num-1 + index < switchStatus.length && num-1 - index >= 0) {
				if (switchStatus[num-1 + index] == switchStatus[num-1 - index]) {
					if (switchStatus[num-1 + index] == 1) {
						switchStatus[num-1 + index] = switchStatus[num-1 - index] = 0;
						index++;
					} else {
						switchStatus[num-1 + index] = switchStatus[num-1 - index] = 1;
						index++;
					}
				}
				// 만약 같지 않다면 반복문을 빠져나온다.
				else {
					break;
				}
			}
		}
	}
}
