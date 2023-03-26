import java.util.LinkedList;
import java.util.Scanner;


/**
 * @author jhye.byun
 * SWEA 6808 규영이와 인영이의 카드게임 D3 백트래킹
 * 
 * 문제
 * 1에서 18까지의 수가 적힌 18장의 카드로 게임을 하자.
 * 카드를 잘 섞어 9장씩 두 명이 나누어 가지고, 아홉 라운드를 진행한다.
 * 각 라운드에서 두 명이 카드를 한 장씩 내는데,
 * 1. 높은 수가 적힌 카드를 낸 사람은 두 카드 수의 합만큼 점수를 얻는다.
 * 2. 낮은 수가 적힌 카드를 낸 사람은 점수를 얻을 수 없다.
 * 아홉 라운드를 끝내고 총점을 따졌을 때, 총점이 더 높은 사람이 게임의 승자가 된다.
 * 두 사람의 총점이 같으면 무승부이다.
 * 
 * 이번 게임에 플레이어1이 받은 9장의 카드 정보와 카드를 내는 순서가 주어졌을 때,
 * 플레이어2의 플레이에 따라 플레이어1이 이기는 경우와 지는 경우의 수를 구하자.
 * 
 * 조건
 * 카드에 쓰여져 있는 정수는 1이상 18이하이며, 같은 정수는 없다.
 * 플레이어1은 주어지는 순서대로 카드를 낸다.
 * 
 * 풀이
 * 1. 9크기의 배열을 만들어서, 플레이어1의 카드를 순서대로 저장하자.
 * 2. 1~18까지 돌면서, 플레이어1의 카드에 포함되지 않은 카드라면, 플레이어2의 카드에 저장하자.
 * 2-1. 귀찮으니까 1~18까지 넣어 놓은 linkedList를 먼저 만들고,
 * 2-2. 그 중 입력되는 값은 뽑아서 플레이어1 배열에 순서대로 넣어준 후,
 * 2-3. linkedList에 남은 수들을 플레이어2 배열에 넣자.
 * 3. depth를 9까지 증가시키며 순열을 만들고, 하나의 순열이 끝나면 점수를 계산해서 winCount 또는 loseCount를 하나 증가시키자.
 * 
 * => 보완점
 * list에 1~18을 저장하지 말고 1~18번의 인덱스를 사용할 수 있는 boolean배열을 만들어서
 * 플레이어1이 가져간 숫자는 true로 표시하고, 입력이 끝난 후 false인 숫자들만 플레이어2가 가져가자.
 * play2 배열에 플레이어2가 해당 라운드에 사용할 카드의 인덱스가 아닌, 해당 인덱스의 값을 저장해서 play메소드에서 값을 바로 가져와 사용하자.
 */

public class SWEA_6808_규영이와인영이의카드게임_변지혜 {
	
	static int size = 9;
	static int[] player1, player2, play2;
	static boolean[] used;
	static int winCount, loseCount;
	
	private static void perm(int depth) {
		
		// 기저조건
		if (depth == size) {
			// 9장의 카드 순서를 다 골랐다면
			// 각 라운드를 진행해보자
			play();
			return;
		}
		
		for (int idx = 0; idx < size; idx++) {
			if (used[idx]) continue;
			play2[depth] = idx;
			used[idx] = true;
			perm(depth + 1);
			used[idx] = false;
		}
		
	}
	
	private static void play() {
		// 플레이어1, 2가 낼 카드 순서에 따라 9개의 라운드를 진행해보자
		
		// 두 플레이어의 점수를 저장할 공간
		int score1 = 0;
		int score2 = 0;
		
		// 9개의 라운드를 진행해보자
		for (int cnt = 0; cnt < size; cnt++) {
			int cur1 = player1[cnt]; // 이번 라운드에 플레이어1이 낼 정수
			int cur2 = player2[play2[cnt]]; // 이번 라운드에 플레이어2가 낼 정수
			
			if (cur1 > cur2) // 플레이어1이 이겼다면
				score1 += cur1 + cur2; // 두 카드의 합을 플레이어1의 점수에 더해주고
			else // 플레이어2가 이겼다면
				score2 += cur1 + cur2; // 두 카드의 합을 플레이어2의 점수에 더해주자
		}
		
		// 9개의 라운드를 모두 진행한 후,
		// 두 점수를 비교해서 플레이어1 기준으로 이기고 진 횟수를 1 증가시키자
		// 만일 두 점수가 같다면 비긴것이니 아무것도 증가시키기 말고 끝내자
		if (score1 > score2)
			winCount++;
		else if (score1 < score2)
			loseCount++;
		
		return;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기
		
		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복
			sb.append("#").append(tc).append(" ");
			
			player1 = new int[size]; // 각 플레이어의 카드 정보를 저장할 배열
			player2 = new int[size];
			play2 = new int[size]; // 플레이어2가 카드를 낼 순서를 구해서 저장할 배열
			used = new boolean[size]; // 플레이어2의 각 카드를 사용했는지 여부를 저장할 배열
			
			winCount= 0; // 플레이어 1 기준 승 패 횟수를 저장할 공간
			loseCount = 0;
			
			LinkedList<Integer> num = new LinkedList<>(); // 1~18까지의 수를 저장할 공간
			
			for (int idx = 1; idx <= 18; idx++) {
				num.add(idx);
			}
			
			// 플레이어1의 카드 정보 및 순서 입력받기
			for (int cnt = 0; cnt < size; cnt++) {
				int cur = sc.nextInt();
				player1[cnt] = cur; // 입력받은 수를 플레이어1 배열에 차례대로 저장하고,
				num.remove(num.indexOf(cur)); // num리스트에서 해당 값을 제거하자
			}
			
			// 플레이어1의 카드 정보 입력이 끝난 후
			// num리스트에 남아있는 값들을 플레이어2 배열에 저장하자
			for (int cnt = 0; cnt < size; cnt++) {
				player2[cnt] = num.remove(0);
			}
			
			// 플레이어2가 카드를 낼 수 있는 경우의 수를 순열로 구해보자
			perm(0);
			
			// 백트래킹을 통해 플레이어2가 낼 수 있는 카드의 모든 경우의 수를 고려해줬으니,
			// 가능한 경우의 수를 저장해둔 두 개의 count를 출력하자
			sb.append(winCount).append(" ").append(loseCount).append("\n");
		}
		
		System.out.println(sb); // 출력
	}

}
