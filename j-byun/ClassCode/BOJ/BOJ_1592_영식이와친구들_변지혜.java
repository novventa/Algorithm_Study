package test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 1592
		// 영식이와 친구들
		// 브론즈2
		
		// 시계방향으로 1~N까지 적혀있는 자리에 앉는다
		// 일단 1번자리가 공을 받고
		// 다른 사람한테 공을 던지는데
		// 한 사람이 공을 M번 받으면 게임 끝 (지금 받은 공까지 센다)
		// 공 던질 사람이 공 받은 횟수가 홀수면 시계방향으로 L번째 사람한테 던지고
		// 						짝수면 반시계방향으로 L번째 사람한테 던진다
		
		// 공을 총 몇 번 던지는지 구하시오
		// *공을 받은 횟수와 던진 횟수 따로 세애된다
		
		Scanner sc = new Scanner(System.in);

		// n, m, l 입력받기
		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();

		// n명의 친구들이 공을 받은 횟수를 저장할 friends 배열 만들기
		int[] friends = new int[n];

		// 다음 공을 받을 친구의 idx번호를 저장
		int idx = 0;

		// 공을 던지는 횟수를 저장할 cnt 만들기
		int cnt = 0;

		// 현재 친구의 공을 받은 횟수가 m을 넘어갔을 때 false를 저장할 boolean 만들기
		boolean isTrue = true;

		// 초기 상황
		// 0번 인덱스가 공을 받음
		// 여기서 m = 1 일 수 있으니 확인해줌
		// 진짜 m이 1이라면 if문에 걸려서 isTrue가 false이기 때문에 while문 돌지 않음
		friends[idx]++;
		if (friends[idx] >= m) {
			System.out.println(cnt);
			isTrue = false;
		}

		// m이 1이 아니라면 특정 친구가 공을 받은 횟수가 m을 넘지 않을 때 까지 반복
		while (isTrue) {
			if (friends[idx] % 2 != 0) {
				// 홀수일 때
				// 시계방향으로 l번째 친구의 idx 지정
				idx += l;
				// 이 때, idx가 배열 크기를 벗어났다면,
				// 다시 0번부터 세서 올바른 idx 번호로 지정
				if (idx > n - 1) {
					idx -= n;
				}

			} else if (friends[idx] % 2 == 0) {
				// 짝수일 때
				// 시계반대방향으로 l번째 친구의 idx 지정
				idx -= l;
				// 이 때, idx가 배열 크기를 벗어났다면,
				// 다시 n-1부터 세서 올바른 idx 번호로 지정
				if (idx < 0) {
					idx += n;
				}

			}

			// System.out.println(idx);

			// 공던진 횟수 ++
			cnt++;
			// 현재 idx 친구가 공을 받은 횟수++
			friends[idx]++;

			// 현재 idx 친구가 공을 받은 횟수가 m 이상이 되면
			if (friends[idx] >= m) {
				// 현재까지 공을 던진 횟수를 출력하고
				System.out.println(cnt);
				// isTrue를 false로 지정해서 while문을 벗어난다
				isTrue = false;
			}

		}

	}

}
