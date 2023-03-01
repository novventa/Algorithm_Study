import java.util.Arrays;
import java.util.Scanner;

public class P2309 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 9명이므로 9 크기의 배열을 만든다.
		int[] arr = new int[9];
		// 9명의 키의 합을 더해줄 변수를 만든다.
		int sum = 0;

		// 키 정보를 입력 받고, 키의 합을 sum변수에 저장한다.
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}

		// Arrays.sort를 이용해 오름차순으로 정렬한다.
		Arrays.sort(arr);

		// 특정 2명을 찾으면 break하기 위해 outer를 사용한다.
		// 브루트 포스를 이용하여 모든 경우의 수를 탐색한다.
		outer: for (int i = 0; i < 9; i++) {
			for (int j = i; j < 9; j++) {
				// sum에서 특정 2명의 값을 뺐을 때 100이라면
				if (sum - arr[i] - arr[j] == 100) {
					// 특정 2명을 제외하고 출력해보자.
					for (int k = 0; k < 9; k++) {
						if (k != i && k != j) {
							System.out.println(arr[k]);
						}
					}
					// 찾았으니 break하자.
					break outer;
				}
			}

		}

	}
}
