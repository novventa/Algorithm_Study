package day0223;

import java.util.Scanner;

public class P2851 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] arr = new int[10];

		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
		}

		// 100이 넘는 100에 가장 가까운 버섯의 합
		int sum = 0;
		//100
		int last = 0;

		//순서대로 버섯을 더하다가 합이 100을 넘으면 멈춘다
		for (int index = 0; index < 10; index++) {
			sum += arr[index];
			if (sum >= 100) {
				last = index;
				break;
			}

		}
		// 100이 넘지 않는 100에 가장 가까운 버섯의 합
		int compare = 0;
		// sum에 추가로 더해진 인덱스의 값을 빼준다
		if(sum == 100) {
			System.out.println(sum);
		}else {
			compare = sum - arr[last];
				// 100에서 더 가까운 것이 출력되도록
				if ((100 - compare) > (sum - 100)) {
					System.out.println(sum);
					// 100까지의 거리가 같을 때 더 큰수가 출력되도록
				} else if ((100 - compare) == (sum - 100)) {
					System.out.println(sum);
					// 100에서 더 가까운 것이 출력되도록
				} else if ((100 - compare) < (sum - 100)) {
					System.out.println(compare);
				}
		}

		sc.close();

	}
}



