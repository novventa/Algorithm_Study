package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2292 벌집
// 브론즈2

// 문제
// 육각형 벌집
// 중앙의 방 1부터 시작해서 이웃하는 방에 돌아가면서 1씩 증가하는 번호 넣기
// 숫자 N이 주어졌을 때...
// 벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때
// 몇 개의 방을 지나가는지 (시작과 끝 포함해서) 계산하시오

// 풀이
// 1
// 2 3 4 5 6 7 (+6)
// 8~19 (+12)
// 20~37 (+18)
// 38~61 (+24)

// 6의 배수로 증가
// 몇 번 째 pass에 포함된 숫자인지만 알면된다
// 어차피 육각형모양이라 방향은 내 맘대로 갈 수 있으니까!

public class BOJ_2292_벌집_변지혜 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// n 입력받기
		int n = Integer.parseInt(br.readLine());
		br.close();
		
		// 지나가는 방의 개수 roomCnt
		int roomCnt = 0;
		
		
		// 6의 배수로 증가시킨 벌집 개수를 저장할 num 만들기
		int num = 0;
		
		
		
		// 6의 배수로 증가시키면서 한 pass 마다 num에 더하기
		while (true) {
			
			// 처음에는 그냥 num에 1 더해주기
			if (roomCnt == 0) {
				num += 1;
			} else {
				num += 6*roomCnt;
			}
			
			// pass 증가할 때 마다 지나가는 방의 개수 ++
			roomCnt++;
			
			// 증가시킨 num이 찾는 숫자 n보다 크거나 같아지면
			if (num >= n) {
				// 지나온 방의 개수 뱉고 while문 탈출
				bw.write(roomCnt + " ");
				break;
			}
			
		}
		
		// 출력
		bw.flush();
		bw.close();
		
	}

}


