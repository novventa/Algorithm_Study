import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author jhye.byun
 * SWEA 1247 최적 경로 D5 백트래킹/순열
 * 
 * 문제
 * 회사에서 출발해서 N명의 고객을 방문하고 집으로 돌아가자.
 * 가장 짧은 경로를 찾자.
 * 
 * 조건
 * 이차원 정수 좌표 (x,y) (0 ≤ x ≤ 100, 0 ≤ y ≤ 100)
 * 두 위치 (x1, y1)와 (x2, y2) 사이의 거리는 |x1-x2| + |y1-y2|으로 계산
 * 회사의 좌표, 집의 좌표, 고객들의 좌표는 모두 다르다.
 * 고객의 수 N 2≤N≤10
 * 회사의 좌표, 집의 좌표를 포함한 모든 N+2개의 좌표는 서로 다른 위치이다.
 * 
 * 풀이
 * 1. 회사와 우리집을 제외한 나머지 N개의 좌표들에 대해 몇 번째로 방문할 지 구하는 순열을 만들자.
 * 2. 유망성이 없는 가지는 탐색하지 않기 위해 백트래킹 조건을 생각해보자.
 * 2-1. 백트래킹 조건을 활용하기 위해 좌표 하나를 선택할 때 마다 이전 좌표에서부터의 거리를 더해주자.
 * 2-2. 현재까지의 거리가 이전에 찾았던 최소 거리보다 같거나 큰 값이라면, 해당 가지는 이미 유망성이 없으니 다른 가지를 탐색하자.
 */

public class SWEA_1247_최적경로_변지혜 {
	
	static int peopleCount, minDis;
	static boolean[] used;
	static ArrayList<Coo> location;
	
	public static void perm(int prevX, int prevY, int sumDis, int depth, int maxDepth) {
		// N개의 집에 대한 방문 순서를 정하는 순열을 만들어보자
		
		// 현재 집까지 방문한 거리가 지금까지 찾은 최단 경로보다 큰 값이라면
		// 이 가지는 유망성이 없으니 더 이상 탐색할 필요가 없다
		if (sumDis >= minDis) {
			return;
		}
		
		// 기저조건
		if (depth == maxDepth) {
			// N개의 집에 대한 방문 순서를 정했다면, 마지막 집에서 우리 집까지의 거리를 추가로 더해주고,
			// 현재까지 확인했던 최단경로와 현재 경로를 비교해서,
			// 현재 경로가 더 짧다면 최단경로의 값을 업데이트 해주자
			Coo home = location.get(1);
			minDis = Math.min(minDis, sumDis + Math.abs(prevX - home.x) + Math.abs(prevY - home.y));
			return;
		}
		
		// 아직 방문하지 않은 집이 있다면 방문해주자
		for (int idx = 2; idx < peopleCount + 2; idx++) {
			if (used[idx]) continue; // 이미 방문한 집은 패스
			// 방문하지 않은 집이라면 방문하자
			used[idx] = true;
			Coo cur = location.get(idx);
			// 현재까지 거리 합에 이전 집과 지금 방문한 집의 거리를 더해주자
			perm(cur.x, cur.y, sumDis + Math.abs(prevX - cur.x) + Math.abs(prevY - cur.y), depth + 1, maxDepth);
			used[idx] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner	sc = new Scanner(System.in);
		
		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기
		
		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복 실행
			
			peopleCount = sc.nextInt(); // 회사-집 사이에 들려야 하는 집의 개수
			
			location = new ArrayList<>(); // 각 좌표를 저장할 배열 공간을 만들어보자
			
			// 좌표들을 입력받자
			for (int cnt = 0; cnt < peopleCount + 2; cnt++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				// Coo 클래스를 활용해서 좌표를 저장하자
				location.add(new Coo(x, y));
			}
			
			// 최단경로를 찾아야하니, 일단 최단 경로를 엄청 큰 수로 선언해놓자.
			minDis = Integer.MAX_VALUE;
			
			// 현재 순열에 몇번쨰 집이 사용되었는지 여부를 나타낼 boolean 배열을 만들자
			// 인덱스 2번부터 활용하자
			used = new boolean[peopleCount + 2];
			
			// 입력받은 좌표의 0번째와 1번째는 각각 회사와 우리 집의 좌표니까,
			// 2번째 인덱스부터 접근해서 순열을 만들어보자
			
			// 제일 먼저 회사에서 출발해야 하니, 회사의 x,y 좌표를 파라미터로 넘겨주자
			Coo com = location.get(0);
			perm(com.x, com.y, 0, 0, peopleCount);
			
			// 순열을 구해서 N개의 집에 방문하는 순서를 모두 확인해봤다면,
			// 찾아낸 최단 경로의 값을 출력하자
			System.out.printf("#%d %d\n", tc, minDis); // 결과 출력
		}
	}
	
	// 좌표를 나타내기 위한 Coo 클래스를 만들어서 활용하자
	public static class Coo {
		int x, y;

		public Coo(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
