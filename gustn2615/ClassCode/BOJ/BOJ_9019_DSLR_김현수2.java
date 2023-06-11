package study_ssafy2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019_DSLR_김현수2 {

	static int T, num, answerNum;
	static boolean[] visted;
	static String[] command;
	static Queue<Integer> q;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());

			num = Integer.parseInt(st.nextToken());
			answerNum = Integer.parseInt(st.nextToken());

			visted = new boolean[10000];
			command = new String[10000];
			Arrays.fill(command, "");
			
			bfs(num);
			
			System.out.println(command[answerNum]);
		}

	}

	static void bfs(int start) {
		q = new ArrayDeque<>();

		q.add(start);
		
		visted[start]=true;

		while (!q.isEmpty() && !visted[answerNum]) {
			int now = q.poll();

			D(now);
			if (!visted[num]) {
				q.add(num);
				visted[num] = true;
				command[num] = command[now] + "D";
			}

			S(now);
			if (!visted[num]) {
				q.add(num);
				visted[num] = true;
				command[num] = command[now] + "S";
			}
			
			L(now);
			if (!visted[num]) {
				q.add(num);
				visted[num] = true;
				command[num] = command[now] + "L";
			}
			
			R(now);
			if (!visted[num]) {
				q.add(num);
				visted[num] = true;
				command[num] = command[now] + "R";
			}

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
}
