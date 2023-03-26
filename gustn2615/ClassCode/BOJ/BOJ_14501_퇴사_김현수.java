package study_ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class solution_14501_퇴사_김현수 {
	static int totalDay, sumCost;
	static int[] dayCount, cost;
	static int[] dp;
	static int limitCost = 150000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		totalDay = Integer.parseInt(br.readLine());
		dayCount = new int[totalDay ];
		cost = new int[totalDay];
		for (int i = 0; i < totalDay; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dayCount[i] = Integer.parseInt(st.nextToken());
			cost[i] = Integer.parseInt(st.nextToken());
		}

//		for (int i = 0; i < totalDay; i++) {
//			System.out.println(dayCount[i] + " " + cost[i]);
//		}

		dp = new int[totalDay + 1];
		
		for (int i = 0; i < totalDay; i++) {
			if (i + dayCount[i] <= totalDay) {
				
				dp[i + dayCount[i]] = Math.max(dp[i + dayCount[i]], dp[i] + cost[i]);
				
			}
			dp[i+1]=Math.max(dp[i+1], dp[i]);
		}
//		System.out.println(Arrays.toString(dp));
		
		System.out.println(dp[totalDay]);

	}
}
