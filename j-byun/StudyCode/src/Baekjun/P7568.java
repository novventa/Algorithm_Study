package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 브루트포스
// 7568 덩치
// 실버5

// 문제
// 덩치 = 키, 몸무게로 표현
// 몸무게 x, 키 y => (x, y)

// 사람1 = x1, y1
// 사람2 = x2, y2 일 때...
// x1 > x2 && y1 > y2 면 사람1이 사람2보다 더 크지만...
// x1 > x2 && y1 < y2 면 누가 더 크다고 할 수 없다

// 내 덩치 등수 = 나보다 큰 사람의 수 + 1
// 내 덩치 등수는?

// 풀이
// x기준으로 두 개 뽑아서 순열 구하고,
// 	x, y를 비교해서 나보다 크면 카운트한다
// 모든 사람에 대해 탐색이 끝나면...
// 	내 등수는 카운트 + 1 번

public class P7568 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 전체 사람 수 n명을 peopleSize로 입력 받기
		int peopleSize = Integer.parseInt(br.readLine());
		
		// 2행, n열의 2차원 배열 people 만들기
		// 1행에는 x값, 2행에는 y값 저장
		// 인덱스가 사람 번호
		int[][] people = new int[peopleSize][peopleSize];
		
		// people 배열에 x, y값 넣기
		for (int col = 0; col < peopleSize; col++) {
			// 한 줄을 띄어쓰기 기준으로 잘라서 read 배열에 저장해놓고
			String[] read = br.readLine().split(" ");
			
			for (int row = 0; row < 2; row++) {
				// 저장한 값을 나눠서 배열에 x, y값으로 넣어준다
				people[row][col] = Integer.parseInt(read[row]);
			}
		}
		
		// 입력 끝났으니까 bufferedReader닫아서 메모리 확보
		br.close();
		
		// 나보다 덩치가 큰 사람의 수를 저장할 변수 rankCnt 만들기
		int rankCnt = 0;
		
		// 각 사람의 등수를 저장할 peopleSize 크기의 배열 rank를 만든다
		int[] rank = new int[peopleSize];
		
		// 서로 다른 두 값을 뽑아서
		// x1 < x2 && y1 < y2를 만족하면 rankCnt를 ++ 해준다
		// 한 사람에 대해 모든 비교가 끝났으면 rankCnt + 1을 그 사람 인덱스 번호에 맞는 rank 배열에 저장한다
		//		=> rankCnt는 나보다 덩치가 큰 사람의 숫자이고,
		//		=> 나는 rankCnt + 1 등이다
		for (int person1 = 0; person1 < peopleSize; person1++) {
			// 한 사람의 등수를 찾아내려고 시작 할 때 마다
			// rankCnt를 0으로 초기화해준다
			rankCnt = 0;
			
			for (int person2 = 0; person2 < peopleSize; person2++) {
				// 뽑아낸 두 사람이 다른 사람이어야 되니까 person1 != person2 조건 넣어주기
				if (person1 != person2) {
					// x1 < x2 && y1 < y2면 rankCnt++
					if (people[0][person1] < people[0][person2] && people[1][person1] < people[1][person2]) {
						rankCnt++;
					}
				}
			}
			
			// 한 사람에 대한 확인이 끝났으니까
			// 나보다 덩치가 큰 사람의 수 + 1을 rank배열의 내 인덱스에 넣어준다
			rank[person1] = rankCnt + 1;
		}
		
		// 모든 사람의 등수를 다 확인했으면...
		// 등수가 저장된 rank 배열을 출력해준다
		for (int idx = 0; idx < peopleSize; idx++) {
			bw.write(rank[idx] + " ");
		}
		
		// 출력
		bw.flush();
		// 출력 끝났으니까 bufferedWriter 닫아서 메모리 확보
		bw.close();

	}

}


