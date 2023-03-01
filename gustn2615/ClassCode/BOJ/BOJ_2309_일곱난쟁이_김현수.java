package study_ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class solution_2309_일곱난쟁이 {
	// 난쟁이를 담을 배열이다.
	int[] dwarf;

	// 난쟁이의 키를 사용했는지 안했는지 알려주는 논리형
	boolean[] dwarfUsed;

	// 7명의 합이 100을 만족하는 난쟁이를 담을 배열이다.
	int[] answerDwarf;

	public void solution() throws IOException {
		// 버퍼리더 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 난쟁이를 담을 배열크기 설정
		dwarf = new int[9];
		// 9명 난쟁이의 키를 사용했는지 안했는지 알려주는 논리형 크기 설정
		dwarfUsed = new boolean[9];
		// 7명의 난쟁이를 담을 배열크기 정의
		answerDwarf = new int[7];
		
		// for문을 통해 배열에 난쟁이들 키값을 넣어준다.
		for (int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		// 키가 잘 들어가졌는지 확인한다.
//		for (int dwarf : dwarf)
//			System.out.println(dwarf);
		// 버퍼리더를 종료하고
		br.close();
		// 백트래킹 함수를 실행한다.
		backtracking(0, 0, 0);

	}

	// 백트래킹 함수를 실행한다.
	// 여기서 start는 난쟁이의 키를 사용할 때 시작지점을 의미한다
	// 한번 사용한 난쟁이의 키는 이후에 또 사용하면 안되기 때문에
	// start의 index를 1씩 늘리면서 사용되지 않게 하려고 한다.
	public void backtracking(int k, int start, int sum) {
		// 기저 조건, 종료조건
		// 7명을 뽑으면 그 키의 합이 100이되는지 확인해야 한다.
		// 7명을 뽑았을때
		if (k == 7) {
			// 합이 100이라면
			if (sum == 100) {
				// 답인 배열을 정렬해준뒤
				Arrays.sort(answerDwarf);
				// 결과를 출력해준다.
				for (int dwarfCm : answerDwarf)
					System.out.println(dwarfCm);
				System.out.println();
				// 이후 프로그램을 종료한다.
				// 이후 100이 나오는 경우를 없애기 위해서이다.
				System.exit(0);
			} 
			// 합이 100이 아니라면 그냥 return한다.
			else {
				return;
			}

		}

		// 숫자가 중복해서 나오지 않게 7개를 뽑아내면된다.
		// 9명의 난쟁이중 7명을 뽑아 배열로 만들었을때
		// k번째에 오는 난쟁이를 채우는 반복문이다.
		
		// 초기 백트래킹에 들어오는 값은 k=0 start=0 sum=0 이다.
	
		// 여기서 for문을 start 부터 9까지 돌린다
		// for문의 시작이 start인 이유는 백트래킹 함수를 시작해서
		// 다시 돌아왔을 때 사용했던 난쟁이의 키를 사용하지 않기 위해서이다.
		// ex) 예를들어 start가 0일때는 0~8번째 난쟁이를 모두 확인하지만
		//     start가 1이되면 1~8번째의 난쟁이만 확인하기 때문에 한번 사용했던
		//	   난쟁이의 키는 더이상 사용 안하게 된다. 
		for (int i = start; i < 9; i++) {
			// 만약 난쟁이 키를 사용하지 않았다면.
			if (!dwarfUsed[i]) {
				// 난쟁이 키를 사용한 것으로 바꾸어주고
				dwarfUsed[i] = true;
				// 선택한 난쟁이 키를 배열에 넣어준다
				// 즉 k번째 난쟁이의 키를 채웠다
				answerDwarf[k] = dwarf[i];
				// 이후 k+1번째 난쟁이의 키를 채워주기 위해 백트래킹 함수를 실행한다
				// 이때 start값 또한 1을 더하고
				// sum에는 방금 추가한 난쟁이의 키를 더한다.
				backtracking(k + 1, i + 1, sum + dwarf[i]);
				// 백트래킹 함수 호출이 종료되면 i번째 난쟁이의 키의 쓰임이 다했으므로
				// 다시 false로 바꾸어 주면서 사용안했다고 바꾸어준다.
				// 이를 true로 그냥 둘시 한번만 사용했더라도 모두 true가 되기 때문에
				// loop를 한번만 돌면 모든 boolean이 true가 되어
				// if (!dwarfUsed[i]) 조건문을 만족하지 못해서 함수가 돌아가지않는다.
				dwarfUsed[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new solution_2309_일곱난쟁이().solution();
	}
}
