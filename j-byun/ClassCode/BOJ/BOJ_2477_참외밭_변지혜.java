package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2477 참외밭
// 실버2

// 문제
// 1제곱미터에서 자라는 참외개수 * 참외밭의 면적으로 참외 총 개수 구하기

// 참외밭은 ㄱ을 0도, 90도, 180도, 270도 회전한 모양이다
// 1제곱미터에서 자라는 참외의 개수와 
// 참외밭을 이루는 육각형의 임의의 한 꼭짓점에서 출발하여 반시계방향으로 둘레를 돌면서 지나는 변의 방향과 길이가 순서대로 주어진다
// 참외밭에서 자라는 참외의 수를 구하시오

// 풀이
// 4방향에 대한 boolean 배열 만들어서
// 값이 들어올 때 마다 반전시킴
//		=> 한 번 씩만 들어온 두 방향의 곱이 큰 직사각형
//		=> 두 번 씩 들어온 값 중 작은 직사각형을 만들 수 있는 값
//	=> 큰 직사각형 면적 - 작은 직사각형 면적 = 참외밭의 면적
// 참외밭의 면적 * 1제곱미터당 자라는 참외 개수

public class BOJ_2477_참외밭_변지혜 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 1제곱미터에서 자라는 참외의 개수 입력받기
		int melon = Integer.parseInt(br.readLine());
		
		// 6변의 방향 번호와 길이를 저장할 배열 만들기
		int[] direction = new int[6];
		int[] length = new int[6];
		
		// 이미 값이 들어왔던 방향인지 나타낼 boolean배열 만들기
		boolean[] isEnter = new boolean[4];
		
		
		// 변의 방향과 길이 입력받기
		for (int idx = 0; idx < 6; idx++) {
			st = new StringTokenizer(br.readLine());
			
			direction[idx] = Integer.parseInt(st.nextToken());
			length[idx] = Integer.parseInt(st.nextToken());
			
			// 들어온 방향의 boolean값 반전시키기
			isEnter[direction[idx] - 1] = !isEnter[direction[idx] - 1];
		}
		br.close();
		
		
		// direction, length 배열의 첫 값이 중복된 방향이면 (false에 해당하는 방향이면)
		// false length 중 어떤 값을 살려야 될 지 알 수 없음
		//	=> 배열의 처음이 true인 값이 되게 재정렬하고
		// false cnt 3까지만 길이 넣어줌
		//	=> true 다음에 오는 false값의 두번째, 세번째 길이의 곱이 작은 직사각형의 면적이다
		
		// 배열을 큐로 바꿔서 제일 첫 방향이 true가 되게 재정렬하고
		// 다시 큐를 배열로 바꿔준다
		Queue<Integer> dQueue = new LinkedList<Integer>();
		Queue<Integer> lQueue = new LinkedList<Integer>();
		
		for (int idx = 0; idx < 6; idx++) {
			dQueue.offer(direction[idx]);
			lQueue.offer(length[idx]);
		}
		
		while (!isEnter[dQueue.peek() - 1]) {
			dQueue.offer(dQueue.poll());
			lQueue.offer(lQueue.poll());
		}
		
		for (int idx = 0; idx < 6; idx++) {
			direction[idx] = dQueue.poll();
			length[idx] = lQueue.poll();
		}
		// 배열의 제일 젓 방향이 true가 되게 재정렬 끝

		
		// boolean true인 길이를 저장할 배열과 인덱스 만들기
		int[] trueLength = new int[2];
		int trueIdx = 0;
		
		// boolean false인 길이를 저장할 배열과 인덱스 만들기
		// falseLength 배열의 1, 2번 인덱스 값의 곱 = 작은 직사각형 넓이
		int[] falseLength = new int[4];
		int falseIdx = 0;
		
		// direction 배열 돌면서 현재 인덱스 값의 boolean이 true인지 false인지 확인
		for (int idx = 0; idx < 6; idx++) {
			// true면...
			// 해당 인덱스의 길이를 trueLength에 넣어준다
			if (isEnter[direction[idx] - 1]) {
				trueLength[trueIdx++] = length[idx];
				
			} else {
				// false면...
				// 해당 인덱스의 길이를 falseLength에 넣어준다
				falseLength[falseIdx++] = length[idx];
				
			}
		}
		
		
		// 큰 직사각형 넓이 구하기
		int largeSquare = trueLength[0] * trueLength[1];
		
		// 작은 직사각형 넓이 구하기
		int smallSquare = falseLength[1] * falseLength[2];
		
		// (큰 직사각형 넓이 - 작은 직사각형 넓이) * 1제곱미터당 참외개수 출력하기
		bw.write((largeSquare - smallSquare) * melon + " ");
		bw.flush();
		bw.close();
	}

}


