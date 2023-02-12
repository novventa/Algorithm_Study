import java.util.Scanner;

public class P25501 {
	// 문제 조건
	// 1<=T<=1000
	// 1<=|S|<=1000

	// 문제 해결 방법
	// 재귀함수로 앞과 뒤를 하나씩 비교한다.
	// 다 돌았으면 1을 return
	// 중간에 서로 다른 글자가 있다면 0을 retrun한다.

	// 함수 recursion을 선언
	// 변수 l은 앞 인덱스를, 변수 r은 뒷 인덱스를 의미한다.

	public static int recursion(String s, int l, int r) {
		// l이 r보다 크거나 같아지는 순간은 비교가 끝났음을 의미하므로 1을 return한다.
		if (l >= r)
			return 1;
		// 중간에 서로 다른 글자가 있다면 0을 return한다.
		else if (s.charAt(l) != s.charAt(r))
			return 0;
		else
			// 비교가 끝나지 않았다면, 재귀함수를 호출하여 다음 글자를 비교한다.
			return recursion(s, l + 1, r - 1);

	}

	// recursion 함수의 호출 횟수를 구하기 위해 함수를 하나 더 만듦
	// cnt는 호출 횟수를 의미하는 변수
	public static int recursion2(String s, int l, int r, int cnt) {
		// 같은 방법으로 cnt를 구한다.
		if (l >= r)
			return cnt;
		else if (s.charAt(l) != s.charAt(r))
			return cnt;
		else
			return recursion2(s, l + 1, r - 1, cnt + 1);

	}

	// isPalindrome 함수를 선언
	public static int isPalindrome(String s) {
		// 재귀함수를 호출
		return recursion(s, 0, s.length() - 1);
	}

	// cnt를 구하기 위해 isPalindrome2 함수를 선언
	public static int isPalindrome2(String s) {
		return recursion2(s, 0, s.length() - 1, 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트케이스의 갯수 T를 입력 받는다.
		int T = sc.nextInt();
		// T번 반복하며 문자열 S를 입력 받는다.
		for (int i = 0; i < T; i++) {
			String S = sc.next();
			// 출력
			System.out.println(isPalindrome(S) + " " + isPalindrome2(S));
		}

	}
}
