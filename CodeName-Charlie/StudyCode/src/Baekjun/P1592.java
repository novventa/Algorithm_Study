
// 영식이와 친구들이 원형으로 모여서 시계방향으로 1부터 N까지 적혀있는 자리에 앉는다. 
// 영식이와 친구들은 공 던지는 게임을 하기로 했다. 게임의 규칙은 다음과 같다.
// 일단 1번 자리에 앉은 사람이 공을 받는다. 그리고 나서 공을 다른 사람에게 던진다. 
// 다시 공을 받은 사람은 다시 공을 던지고, 이를 계속 반복한다. 
// 한 사람이 공을 M번 받았으면 게임은 끝난다. (지금 받은 공도 포함하여 센다.) 
// 공을 M번보다 적게 받은 사람이 공을 던질 때, 현재 공을 받은 횟수가 홀수번이면 자기의 현재 위치에서 시계 방향으로 L번째 있는 사람에게, 
// 짝수번이면 자기의 현재 위치에서 반시계 방향으로 L번째 있는 사람에게 공을 던진다.
// 공을 총 몇 번 던지는지 구하는 프로그램을 작성하시오.


package Baekjun;

import java.util.Scanner;

public class P1592 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 사람의 수를 나타내는 변수 N을 입력 받는다.
		int[] arr = new int[N]; // 공을 받은 횟수를 저장하기 위해, 크기가 N인 배열 arr를 만든다.

		arr[0] = 1; // 맨 처음에는, 1번 자리에 앉은 사람이 공을 받기 때문에,
		// 1번 자리에 해당하는 인덱스 0번의 값에 1을 대입한다.
		for (int idx = 1; idx < N; idx++) { // 나머지 사람들(인덱스 1번 부터 인덱스 (N-1)번까지)은 값을 0으로 초기화한다.  
			arr[idx] = 0;
		}
		int M = sc.nextInt(); // 달성 시 종료되는 횟수를 나타내는 변수 M을 입력 받는다. 
		int L = sc.nextInt(); // 이동할 거리를 나타낼 변수 L을 입력 받는다.

		int idx = 0; // 최초에는 인덱스 0(1번 자리)에서 시작하고,
		while (arr[idx] != M) { // 인덱스 값이 M이 되면(한 사람이 공을 M번 받으면), while문을 종료하도록 설정한다.
			// 조건은 총 네가지로 설정한다.
			if (arr[idx] % 2 == 1 && (idx + L) <= (N - 1)) { // 공을 받은 횟수가 홀수이면서(시계방향), 주어진 배열의 크기를 넘어가지않는 경우,
				idx += L;
			}
			else if (arr[idx] % 2 == 1 && (idx + L) > (N - 1)) { // 공을 받은 횟수가 홀수이면서(시계방향), 주어진 배열의 크기를 넘어가야하는 경우,
				idx += (L - N);
			}
			else if (arr[idx] % 2 == 0 && (idx - L) >= 0) { // 공을 받은 횟수가 짝수이면서(반시계방향), 주어진 배열의 크기를 넘어가지않는 경우,
				idx -= L;
			}
			else if (arr[idx] % 2 == 0 && (idx - L) < 0) { // 공을 받은 횟수가 짝수이면서(반시계방향), 주어진 배열의 크기를 넘어가야하는 경우
				idx += (N - L);
			}
			arr[idx]++; // 해당 인덱스의 값을 1 증가시킨다.
		}
		int sum = 0;
		for(int i = 0; i < N; i++) { // 공을 총 몇 번 던졌는지 = 각각 공을 몇번 받았는지 합(배열의 모든 요소 값의 합) - 1(처음에는 1번 자리의 사람이 공을 받으면서 시작함.)
			sum += arr[i];
		}
		System.out.println(sum-1); // 값을 출력한다.
	}
}