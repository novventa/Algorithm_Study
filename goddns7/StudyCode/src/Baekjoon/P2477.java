

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 1m^2당 참외의 개수
		int num = sc.nextInt();
		// 방향과 거리
		int[][] direction = new int[6][2];

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				direction[i][j] = sc.nextInt();
			}
		}

		// 북-남과 동-서가 세트로 묶인다 : 세트의 각 방향의 길이의 합은 같다
		// 인덱스의 순서를 고려하지 않고 큐의 개념처럼 원 모양으로 순서가 반복된다고 생각했을 때
		// 각 세트의 최대값은 붙어있고, 나머지 4개가 각 최대값을 분리하는 값이다
		// 그 때, 인덱스가 더 큰 최대값의 인덱스(i) 기준으로 도형으로 확인하면 ((i+1) * ((i+2)+(i+4))) + (i+3) *
		// (i+4) = 전체 참외 밭이다

		// 북-남에 해당하는 것들을 모아놓은 배열
		int[] indexNS = new int[3];
		// 북/남의 원소가 전체 direction배열에서 몇번째 인덱스(row)인지 나타냄
		int k = 0;
		for (int i = 0; i < 6; i++) {
			if (direction[i][0] == 4 || direction[i][0] == 3) {
				indexNS[k++] = i;
			}
		}

		// 북-남중 길이가 최대인 것
		int maxNS = 0;
		// 최대인 거리일 때의 인덱스값(row)
		int idxNS = 0;
		// 북-남에서 길이가 최대인 것을 찾는다(참외밭의 가로 중 가장 긴 길이)
		for (int i = 0; i < 3; i++) {
			if (direction[indexNS[i]][1] > maxNS) {
				maxNS = direction[indexNS[i]][1];
				idxNS = indexNS[i];
			}
		}
		// 동-서에 해당하는 것들을 모아놓은 배열
		int[] indexEW = new int[3];
		// 동/서의 원소가 전체 direction배열에서 몇번째 인덱스(row)인지 나타냄
		int kEW = 0;
		for (int i = 0; i < 6; i++) {
			if (direction[i][0] == 1 || direction[i][0] == 2) {
				indexEW[kEW++] = i;
			}
		}

		// 동-서 중 길이가 최대인 것
		int maxEW = 0;
		// 최대인 거리일 때의 인덱스값(row)
		int idxEW = 0;
		// 동-서에서 길이가 최대인 것을 찾는다(참외밭의 가로 중 가장 긴 길이)
		for (int i = 0; i < 3; i++) {
			if (direction[indexEW[i]][1] > maxEW) {
				maxEW = direction[indexEW[i]][1];
				idxEW = indexEW[i];
			}
		}

		// 참외밭 넓이
		int result = 0;
		// 참외밭을 구하기 위한 기준이 되는 최대값
		int a = 0;

		if (idxEW > idxNS) {
			// 붙어있는 경우 더 큰 인덱스의 최대값이 a값이 된다
			if (idxEW - idxNS == 1) {
				a = idxEW;
				// index = 5, index=0의 경우 떨어져있기 때문에 인덱스가 더 작은 최대값의 인덱스가 기준이 된다.
			} else {
				a = idxNS;
			}
		} else if (idxEW < idxNS) {
			// 붙어있는 경우 더 큰 인덱스의 최대값이 a값이 된다
			if (idxNS - idxEW == 1) {
				a = idxNS;
				// index = 5, index=0의 경우 떨어져있기 때문에 인덱스가 더 작은 최대값의 인덱스가 기준이 된다.
			} else {
				a = idxEW;
			}
		}

		//a=0, 1의 경우 연속되는 4개의 인덱스들은 인덱스의 범위를 벗어나지 않아 다음과 같이 작성 가능
		if (a < 2) {
			result = (direction[a + 1][1] * (direction[a + 2][1] + direction[a + 4][1]))
					+ (direction[a + 4][1] * direction[a + 3][1]);
		//a=2부터 연속되는 4개의 인덱스는 인덱스의 범위를 벗어나므로, 따로 지정
		} else if (a == 2) {
			result = (direction[3][1] * (direction[4][1] + direction[0][1])) + (direction[0][1] * direction[5][1]);
		} else if (a == 3) {
			result = (direction[4][1] * (direction[5][1] + direction[1][1])) + (direction[1][1] * direction[0][1]);
		} else if (a == 4) {
			result = (direction[5][1] * (direction[0][1] + direction[2][1])) + (direction[2][1] * direction[1][1]);
		} else if (a == 5) {
			result = (direction[0][1] * (direction[1][1] + direction[3][1])) + (direction[3][1] * direction[2][1]);
		}

		System.out.println(result * num);

		sc.close();

	}
}



