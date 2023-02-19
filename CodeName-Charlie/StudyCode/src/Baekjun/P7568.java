
// 우리는 사람의 덩치를 키와 몸무게, 이 두 개의 값으로 표현하여 그 등수를 매겨보려고 한다.
// 어떤 사람의 몸무게가 x kg이고 키가 y cm라면 이 사람의 덩치는 (x, y)로 표시된다.
// 두 사람 A 와 B의 덩치가 각각 (x, y), (p, q)라고 할 때 x > p 그리고 y > q 이라면 우리는 A의 덩치가 B의 덩치보다 "더 크다"고 말한다.
// N명의 집단에서 각 사람의 덩치 등수는 자신보다 더 "큰 덩치"의 사람의 수로 정해진다.
// 학생 N명의 몸무게와 키가 담긴 입력을 읽어서 각 사람의 덩치 등수를 계산하여 출력해야 한다.

package Baekjun;

//전체 사람 수 N을 입력 받는다.
//이차원 배열을 만들어, 몸무게와 키를 순차적으로 입력 받는다.
//최종 등수를 저장할 배열을 만든 뒤... 비교하고..
//값을 출력한다.

import java.util.Scanner;

public class P7568 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 학생 수를 나타내는 변수 N을 입력 받는다.

		int[][] data = new int[N][2]; // N명의 학생의 몸무게와 키 값을 저장할 Nx2 크기의 배열 data를 생성한다.

		for (int row = 0; row < N; row++) { // data 배열에 몸무게와 키를 순차적으로 입력 받는다.
			for (int col = 0; col < 2; col++) {
				data[row][col] = sc.nextInt();
			}
		}
		
		int[] ranking = new int[N]; // 각각의 덩치의 등수를 저장할 ranking 배열을 생성한다.
		
			for (int row = 0, rank = 1; row < N; row++) { // 랭킹을 나타내는 변수 rank를 1로 초기화해주고, 
				// col 값에 따라 몸무게냐 키냐가 정해지기 때문에,
				// 개개인의 비교를 위해, row 값끼리 비교를 할 수 있도록 반복문을 설정한다.
				for (int idx = 0; idx < N; idx++) { // 추가로 비교할 상대의 행 인덱스 값에 변화를 주기위해 idx 변수를 따로 설정해 반복문에 집어넣는다. 
					if(data[row][0] < data[idx][0] && data[row][1] < data[idx][1]) { // 키와 몸무게가 모두 다 작은 경우에는
						rank++; // rank를 1 상승시킨다.(덩치가 작을 수록 등수가 낮아지기 때문,)
					}
				}
				ranking[row] = rank; // idx가 들어간 for문을 빠져 나왔을 때, 최종적으로 합산된 rank를 ranking 배열에 입력하고,
				rank = 1; // 다음 대상의 비교를 위해, rank를 다시 1로 초기화한다. 
			}

		for (int i = 0; i < N; i++) { // 반복문을 사용해 주어진 출력결과에 맞춰 등수를 순차적으로 출력한다.
			System.out.print(ranking[i]);
			if (i == (N - 1)) {
				break;
			}
			System.out.print(" ");
		}
	}
}
