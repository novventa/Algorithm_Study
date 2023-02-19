import java.util.Scanner;

// 문제 조건
// 자연수 N과 M에 대하여 1 <= M <= N <= 8이다.
// 중복된 수를 출력하면 안된다.

// 문제 해결 방법
// 모든 경우의 수를 탐색하며 이미 선택한 값이 아닌 값을 선택한다.
// 예를 들어 N이 M이 4인 경우 길이가 4인 트리가 생성된다고 가정하자.
// 첫번째 트리에 1을 선택했다면, 두번째 트리에서 선택할 수 있는 값은 2,3,4이고,
// 두번째 트리에서 3을 선택한다면, 3번째는 2,4중 선택, 3번째에 2를 선택한다면 4번째로는 4를 선택한다.

// 위 과정은 방문 여부를 체크하고, 방문하지 않았다면
// 방문한 것으로 바꾼 후 숫자를 채택하면 된다.
// 다음으로 재귀함수를 이용해 다음 트리에 있는 숫자를 확인한다.
// 위 과정을 반복하면서 숫자의 길이가 M이 되었다면,
// 이전에 생성되지 않은 숫자 조합이기 때문에 배열에 추가한다.

// 1. N과 M을 입력 받고 M자리의 숫자를 저장하기 위해 M크기의 배열을 생성한다.
// 2. 방문 여부를 체크할 boolean 타입의 변수를 만든다.
// 3. 재귀함수를 만드는데, 종료 조건은 m과 길이가 같아질 때이다.
// 4. 반복문을 이용해 트리의 최상단부터 탐색하고,
// 방문되지 않았다면, boolean값을 변경하면서 배열에 추가한다.
// 5. 배열에 추가한 후 재귀함수를 이용해 다음 트리를 검색하고
// 방문 여부를 false로 바꾼다. (백트랙킹 설정)

public class P15649 {
	// 전역변수로 사용하기 위해 static을 사용해 변수를 선언한다.
	public static int n, m;
	public static int[] arr;
	public static boolean[] visit;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 1. n과 m을 입력 받고 m크기의 배열을 만든다.
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[m];

		// 2. 방문 여부를 체크할 boolean 타입의 변수를 만든다.
		visit = new boolean[n];

		recursion(0);

	}

	public static void recursion(int idx) {

		// 3. 종료 조건은 idx와 m이 같아질 때이다.
		if (idx == m) {
			// 같아진다면, arr 배열에 저장해 놓았던 값을 출력 형식에 맞춰 출력한다.
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		// 반복문을 이용해 최상단 트리부터 검색한다.
		for (int j = 0; j < n; j++) {

			// j번째를 방문하지 않았다면
			if (visit[j] == false) {
				// 방문한 것으로 바꾼 후
				visit[j] = true;
				// arr배열에 값을 추가한다.
				arr[idx] = j + 1;
				// 재귀함수를 호출하여 다음 트리를 검색한다.
				recursion(idx + 1);
				// 백트랙킹을 위해 방문 여부를 false로 바꾼다.
				visit[j] = false;
			}
		}

	}

}
