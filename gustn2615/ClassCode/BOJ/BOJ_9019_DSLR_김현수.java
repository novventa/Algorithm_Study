package study_ssafy2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019_DSLR_김현수 {
	static class Command {
		int num;
		String command;

		public Command(int num, String command) {
			this.num = num;
			this.command = command;
		}

	}

	static int T, num, answerNum;
	static boolean[] visted;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());

			num = Integer.parseInt(st.nextToken());
			answerNum = Integer.parseInt(st.nextToken());

			visted = new boolean[10000];

			search(num);
		}
	}

	static void D(int n) {
		num = (2 * n) % 10000;
	}

	static void S(int n) {
		num = n - 1;
		if (num == -1) {
			num = 9999;
		}
	}

	static void L(int n) {
		num = (n % 1000) * 10 + n / 1000;
	}

	static void R(int n) {
		num = (n % 10) * 1000 + n / 10;
	}

	static void search(int n) {
		Queue<Command> q = new ArrayDeque<>();

		q.add(new Command(n, ""));
		visted[n] = true;

		while (true) {
			Command c = q.poll();
			int tmp = c.num;
			
			D(tmp);
			if (num==answerNum) {
				System.out.println(c.command + "D");
				break;
			}
			if(!visted[num]) {
				q.add(new Command(num, c.command + "D"));
				visted[num] = true;				
			}

			S(tmp);
			if (num==answerNum) {
				System.out.println(c.command + "S");
				break;
			}
			if(!visted[num]) {
				q.add(new Command(num, c.command + "S"));
				visted[num] = true;				
			}

			L(tmp);
			if (num==answerNum) {
				System.out.println(c.command + "L");
				break;
			}
			if(!visted[num]) {
				q.add(new Command(num, c.command + "L"));
				visted[num] = true;				
			}

			R(tmp);
			if (num==answerNum) {
				System.out.println(c.command + "R");
				break;
			}
			if(!visted[num]) {
				q.add(new Command(num, c.command + "R"));
				visted[num] = true;				
			}
		}
	}
}
