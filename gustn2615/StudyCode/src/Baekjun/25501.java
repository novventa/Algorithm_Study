package 재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class solution_25501_재귀의귀재 {
	public static int[] recursion(String s, int l, int r, int cnt) {
		
		// 각각의 조건문에 들어갈 때마다 cnt 카운트를 하나씩 올려준다
		if (l >= r) {
			cnt++;
			// return값이 두개가 될 수 없으므로
			// int 배열을 통해서 두가지 값을 반환한다.
			return new int[] { 1, cnt };
		} else if (s.charAt(l) != s.charAt(r)) {
			cnt++;
			return new int[] { 0, cnt };
		} else {
			cnt++;
			return recursion(s, l + 1, r - 1, cnt);
		}

	}

	public static int[] isPalindrome(String s) {
		// recursion 메소드를 불러오는 횟수를 세기위해
		// int cnt 변수 설정
		int cnt = 0;
		return recursion(s, 0, s.length() - 1, cnt);
	}

	public static void main(String[] args) throws IOException {
		// 입력값을 받아오기 위해 버퍼 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			// isPalindrome이 int배열로 리턴값을 받으므로
			// 결과값을 임의의 배열을 정의
			int[] result=isPalindrome(st.nextToken());
			// 결과값을 받은 배열에 첫번째는 팰린드롬인지 여부를
			// 두번째는 함수를 불러온 횟수를 나타낸다
			bw.write(String.valueOf(result[0])+" ");
			bw.write(String.valueOf(result[1])+"\n");
		}
		br.close();
		bw.flush();
		bw.close();

	}
}
