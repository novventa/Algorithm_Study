package Baekjoon;

import java.util.Scanner;

public class P15649 {

	// 백트래킹은 전역변수에 변수를 저장하는 것이 좋다.
	// 여러개의 함수를 만들어야 하기때문에 전역변수에 저장하고 사용하는 것이 좋은것 같다?

	// num : 주어진 자연수를 담을 변수
	// selectionCount : 뽑을 숫자의 개수
	int num, selectionCount;

	// 숫자를 사용할 때 사용했는지 안했는지를 알려주는 논리형
	boolean[] isused;
	// 뽑은 자연수를 담을 배열
	int[] arr;

	// 백트래킹은 arr[k] 채우는 함수다...
	// 뽑은 자연수를 arr배열의 k번째에 넣으면서 arr가 다 채워지면 출력해주는 형식이다.
	public void backtracking(int k) {
		// 숫자를 뽑아서 배열을 다 채워 넣었으면 출력을 해주어야한다.
		// 만약 k가 selectionCount가 되었으면
		// 뽑은 숫자 배열을 출력해준다.
		if (k == selectionCount) {
			// 향상된 for문을 통해 출력
			for (int nums : arr)
				System.out.print(nums + " ");
			System.out.println();
			// 이후 return 해준다. 
			return;
		}

		// 백트래킹의 핵심이 되는 곳이다.
		// arr[k]에 숫자를 중복없이 채워야함으로
		// 1. 우선 전체 숫자를 훑어야한다.
		//    따라서 i를 자연수 num까지 반복문을 돌려줘야한다.
		//    여기서 i는 ((뽑을 자연수)-1) 이라고 생각하면 편하다.
		// 숫자 전체를 훑으면서
		for (int i = 0; i < num; i++) {
			// isused라는 배열은 해당 자연수를 사용햇는지를 알아보는 논리형이 함수이다.
			// for문을 돌면서 가장 작은숫자를 하나 선택하고
			// 그 뒤쪽을 확인하면서 false(사용안한 숫자)를 찾아 arr[k]에 넣어 출력하는 방식이다.
			
			// 만약 해당 숫자를 사용하지 않았다면
			if (!isused[i]) {
				// arr[k]에 사용안한 숫자를 넣어준다.
				arr[k] = i + 1;
				// 이후 i번째 숫자는 사용하였으므로 true로 바꾸어준다.
				// 전역 변수 이므로 이후 backtracking 함수가 호출되어도
				// 이값은 계속 true로 남아있는다.
				// 따라서 중복된 자연수값이 안나오게 하는 일종의 장치인 것이다.
				isused[i] = true;
				// 이후 arr배열의 k+1 번째에 숫자를 채우기 위해 다시 자기자신을 호출해준다.
				backtracking(k + 1);
				// backtracking로 호출한 함수들이 모두 작업을 끝냈으므로
				// i번째 숫자의 사용은 이미 쓰임이 다한것이다.
				// 쓰임이 다했는데 false로 바꾸는 이유는 
				// 이후 다음 for문을 진행 할때 다시 숫자를 사용하기 위함이다.
				// 예를들어 4개의 자연수를 가지고 진행한다고 할 때
				// 첫번째 반복문이 끝나고 [T, F, F, F] 가 된다고 가정하면
				// 이후 반복문에서는 첫번째 자연수를 사용할 수 없으므로 1이라는 숫자를
				// 더이상 사용하지 못하게 된다는 것이다.
				isused[i] = false;
			}
		}
	}

	public void solution() {
		// 스캐너를 사용한다.
		Scanner sc = new Scanner(System.in);
		// 자연수값을 입력받는다.
		num = sc.nextInt();
		// 뽑을 숫자의 개수를 받아온다.
		selectionCount = sc.nextInt();

		// 뽑은 숫자를 담을 배열이다
		arr = new int[selectionCount];
		// 숫자를 사용했는지 알려주는 논리형
		// 여기서 index를 숫자로 사용할 것이다
		// index에 +1을하면 숫자를 얻을수 있다.
		isused = new boolean[num];

		// 백트래킹 함수를 불러온다.
		// arr[0] 번째 부터 숫자를 채워야하므로
		// 0을 호출한다.
		backtracking(0);

	}

	public static void main(String[] args) {
		new P15649().solution();
	}
}