package study_ssafy;

import java.util.Scanner;

public class solution_2851_슈퍼마리오_김현수 {
	public static void main(String[] args) {
		// 스캐너 사용
		Scanner sc = new Scanner(System.in);
		// 버섯의 합을 구할 변수
		int sum = 0;
		// 10개의 버섯을 더하면서
		for (int i = 0; i < 10; i++) {
			// 스캐너로 버섯 점수를 받아온다
			int N=sc.nextInt();
			// 버섯 점수를 더한다
			sum += N;
			// sum이 100을 넘어가면
			// 이전 합과 비교해서 100과 가까운 것을 출력한다.
			if (sum >= 100)
				if (Math.abs(sum - N - 100) < sum - 100) {
					sum -= N;
					break;
				} else {
					break;
				}
		}
		sc.close();
		System.out.println(sum);
	}
}
