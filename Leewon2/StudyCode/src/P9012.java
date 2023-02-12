import java.util.Scanner;

public class P9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// T를 입력받는다.
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			String vps = sc.next();
			int size = vps.length();
			int open = 0;
			int close = 0;
			char[] arr = new char[size];
			// 문자열을 배열로 변환
			for (int j = 0; j < size; j++) {
				arr[j] = vps.charAt(j);
			}

			// 배열의 j번째가 '(' 이라면 open++
			for (int j = 0; j < size; j++) {
				if (arr[j] == '(') {
					open++;
					// 배열의 j번째가 ')' 이라면 close++
				} else if (arr[j] == ')') {
					close++;
				}

				// close가 open보다 커지는 순간 break
				if (close > open) {
					break;
				}
			}
			// open과 close의 길이가 같다면 YES 출력
			if (open == close) {
				System.out.println("YES");
				// 아니라면 NO 출력
			} else {
				System.out.println("NO");
			}
		}

	}
}