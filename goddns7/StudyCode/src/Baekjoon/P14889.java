package 백준;

import java.util.Scanner;

public class P14889 {
	// 조합으로 팀을 두 팀으로 나누고 <- divideTeam
	// 각 팀에서 순열로 people/2에서 2개를 뽑는 조합을 구해준 시너지를 구한다 <- synergy
	// 그리고 해당 조합을 row와 col의 수를 뒤집어 하나씩 또 생긴 시너지를 더해준다

	// 사람들의 수
	static int people;
	// 능력치 표
	static int[][] list;
	// 스타트 팀 선택 여부 확인 배열
	static boolean[] picked;
	// 스타트 팀
	static int[] team1;
	// 링크 팀
	static int[] team2;

	// 스타트 팀 총 시너지
	static int total1;
	// 링크 팀 총 시너지
	static int total2;
	// 스타트 팀의 능력치와 링크 팀의 능력치의 차이 중 최소값
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 사람들의 수
		people = sc.nextInt();
		// 능력치 표
		list = new int[people][people];
		// 능력치 정보 입력
		for (int i = 0; i < people; i++) {
			for (int j = 0; j < people; j++) {
				list[i][j] = sc.nextInt();
			}
		}

		team1 = new int[people / 2]; // 초기화
		team2 = new int[people / 2]; // 초기화
		picked = new boolean[people]; // 초기화

		// 최소값을 찾기 위해 사용하므로 최대값 지정
		result = Integer.MAX_VALUE;
		// 조합으로 팀을 두 팀으로 나누자
		divideTeam(0, 0);

		System.out.println(result);
		sc.close();
	}

	private static void divideTeam(int start, int pick) {
		// 절반의 팀원을 구했다면
		if (pick == people / 2) {
			int idx1 = 0; // 초기화
			int idx2 = 0; // 초기화

			for (int i = 0; i < people; i++) {
				// 선택한 것은
				if (picked[i]) {
					// 스타트 팀으로
					team1[idx1++] = i;
					// 선택하지 않은 것은
				} else {
					// 링크 팀으로
					team2[idx2++] = i;
				}
			}
			total1 = 0; // 초기화
			total2 = 0; // 초기화
			boolean[] player = new boolean[people / 2]; // 초기화

			// 각 팀에서 순열로 people/2에서 2개를 뽑는 조합을 구해준 시너지를 구한다
			// 그리고 해당 조합을 row와 col의 수를 뒤집어 하나씩 또 생긴 시너지를 더해준다
			synergy(player, 0, 0);
			// 스타트 팀의 능력치와 링크 팀의 능력치의 차이 중 최소값을 구하자
			result = Math.min(result, Math.abs(total1 - total2));

			return;
		}

		for (int i = start; i < people; i++) {
			// 고른 적이 없다면
			if (!picked[i]) {
				// 고르고
				picked[i] = true;
				// 다음 사람의 것부터 다음 팀원으로 고르러 가자
				divideTeam(i + 1, pick + 1);
				// 다시 반납
				picked[i] = false;
			}
		}
	}

	private static void synergy(boolean[] play, int pick, int start) {
		// 2명을 다 구했다면
		if (pick == 2) {
			int[] index1 = new int[2]; // 초기화
			int[] index2 = new int[2]; // 초기화
			int idx1 = 0; // 초기화
			int idx2 = 0; // 초기화

			for (int i = 0; i < people / 2; i++) {
				// 고른 것들의 값은 정해진 팀들에 속한 팀원들의 순서를 의미한다
				// 순서를 골랐다면
				if (play[i]) {
					// 해당 순서에 맞는 팀원의 번호를 index 배열에 넣는다
					index1[idx1++] = team1[i];
					index2[idx2++] = team2[i];
				}
			}
			// 각 팀의 총 능력치를 구한다
			// Sij와 Sji의 능력치를 모두 더해야하기 때문에 순서를 바꿔서 한번씩 더 더해준다
			total1 += list[index1[1]][index1[0]] + list[index1[0]][index1[1]]; // 스타트 팀의 총 능력치
			total2 += list[index2[1]][index2[0]] + list[index2[0]][index2[1]]; // 링크 팀의 총 능력치

			return;

		}

		for (int i = start; i < people / 2; i++) {
			// 고르지 않았다면
			if (!play[i]) {
				// 고른다
				play[i] = true;
				// 고른 것 다음의 순서부터 다음 순서를 고르러 가자
				synergy(play, pick + 1, i + 1);
				// 다시 반납
				play[i] = false;
			}

		}
	}

}
