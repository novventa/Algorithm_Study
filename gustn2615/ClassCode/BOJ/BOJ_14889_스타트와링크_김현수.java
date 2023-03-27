package study_ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution_14889_스타트와링크_김현수 {
	static int soccerMapSize, teamSize;
	static int[][] soccerMap;
	static StringTokenizer st;
	static boolean[] isUsed;

	static int[] teamA, teamB;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		teamSize = soccerMapSize / 2;
		isUsed = new boolean[soccerMapSize];
		min = Integer.MAX_VALUE;
		subset(0, 0);
		System.out.println(min);

	}

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		soccerMapSize = Integer.parseInt(br.readLine());
		soccerMap = new int[soccerMapSize][soccerMapSize];
		for (int row = 0; row < soccerMapSize; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < soccerMapSize; col++) {
				soccerMap[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
	}

	static void subset(int totalNum, int subsetNum) {
		if (subsetNum == teamSize) {
			teamA = new int[teamSize];
			teamB = new int[teamSize];
//			System.out.println(Arrays.toString(isUsed));
			int indexA = 0;
			int indexB = 0;
			for (int i = 0; i < soccerMapSize; i++) {
				if (isUsed[i]) {
					teamA[indexA++] = i;
				} else {
					teamB[indexB++] = i;
				}
			}

			int tmp = Math.abs(status(teamA) - status(teamB));
			min = Math.min(tmp, min);
			return;
		}

		if (totalNum == soccerMapSize) {
			return;
		}

		subset(totalNum + 1, subsetNum);
		isUsed[totalNum] = true;
		subset(totalNum + 1, subsetNum + 1);
		isUsed[totalNum] = false;

	}

	static int status(int[] team) {
		int sum = 0;
		for (int i = 0; i < teamSize; i++) {
			for (int j = i + 1; j < teamSize; j++) {
				sum += soccerMap[team[i]][team[j]];
				sum += soccerMap[team[j]][team[i]];
			}
		}
		return sum;
	}
}
