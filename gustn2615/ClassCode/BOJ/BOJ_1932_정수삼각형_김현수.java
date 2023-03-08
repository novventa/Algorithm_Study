package study_ssafy;

/*
 * tree구조 처럼 생각한다
 *    1
 *   2 3
 *  4 5 6
 * 7 8 9 10   
 * 
 * 이때 위에서 둘중 하나를 선택하면서 마지막까지 내려오면서 더하고
 * 이의 최대값을 구하는 문제이다.
 * 
 * 각각의 칸에 자신 위의 두개의 숫자 중 자기 자신과 더했을 때 더 큰 값을
 * 저장하면서 내려온다.
 * 양 끝값은 더할 숫자가 하나밖에 없다
 * 위에서 부터 1층이라고 했을 때 i층일 때
 * 1. 맨 왼쪽의 경우 (자기자신의 index)-i+1
 * 2. 맨 오른쪽의 경우 (자기자신의 index)-i
 * 3. 가운데의 경우 (자기자신의 index)-i / (자기자신의 index)-i+1 두개 중 최대값을 찾는다
 * 
 * 이 후 마지막 층에 도착했을 시
 * 
 * 마지막 층에 해당하는 index 중에서 최대값을 찾아낸다.
 * 
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class solution_1932_정수삼각형_김현수 {
	public static void main(String[] args) throws IOException {

		// 버퍼리더 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 삼각형의 높이 받아오기
		int N = Integer.parseInt(br.readLine());
		
		// 전체 숫자의 개수 받아오기
		int sum = N * (N + 1) / 2;
		
		// 전체 숫자를 넣을 배열 생성
		// tree처럼 1층 에는 1번 2층에는 2,3번 이런식으로 1차원 배열에 넣을 것이다
		// index는 1부터 숫자를 넣어줄 것이기 때문에 sum+1로 만든다
		int[] tree = new int[sum + 1];
		
		// tree에 index에 맞게 숫자를 넣어준다.
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = i * (i - 1) / 2 + 1; j <= i * (i + 1) / 2; j++) {
				tree[j] = Integer.parseInt(st.nextToken());
			}
		}

		// 버퍼리더 사용 종료
		br.close();
		
		// tree의 층을 2층부터 내려오면서 
		for (int i = 2; i <= N; i++) {
			
			// 각각의 층의 시작지점부터 끝지점 까지 반복하면서
			for (int j = i * (i - 1) / 2 + 1; j <= i * (i + 1) / 2; j++) {
				
				// 만약 맨 왼쪽이면
				if (j == i * (i - 1) / 2 + 1) {
					// (자기자신의 index)-i+1 를 더해준다
					tree[j] += tree[j - i + 1];
				} 
				// 만약 맨 오른쪽 이라면
				else if (j == i * (i + 1) / 2) {
					// (자기자신의 index)-i 를 더해준다
					tree[j] += tree[j - i];
				} 
				// 만약 중앙이라면
				else {
					
					// 최대값을 찾아서 더한다
					tree[j] += Math.max(tree[j - i], tree[j - i + 1]);
				}
			}
		}
		
		// 이후 마지막 층에서 최대값을 구한다.
		int max = Integer.MIN_VALUE;
		for (int i = N * (N - 1) / 2 + 1; i <= sum; i++) {
			if (tree[i] > max) {
				max = tree[i];
			}
		}
//		System.out.println(Arrays.toString(tree));
		
		// 최대값을 출력한다
		System.out.println(max);
	}
}
