package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P7568_2 {
	public static void main(String[] args) throws IOException {
		
		// 버퍼 리더 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 사람의 명수를 받아온다.
		int personNum = Integer.parseInt(br.readLine());
		
		// 사람의 몸무게와 키를 담을 배열 정의
		int[] personKg = new int[personNum];
		int[] personCm = new int[personNum];

		// 각각의 배열에 사람의 키와 몸무게를 집어넣는다.
		for (int index = 0; index < personNum; index++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			personKg[index] = Integer.parseInt(st.nextToken());
			personCm[index] = Integer.parseInt(st.nextToken());
		}

		// 사람들의 덩치 rank를 넣을 result 배열을 만든다.
		int[] result = new int[personNum];
		
		// 이중 for문을 돌려서 각자리에 있는 사람들의 랭크를 저장할 것이다.
		// out 루프는 현재 덩치가 몇등인지 알고싶은 사람이다. 
		for (int i = 0; i < personNum; i++) {
			// 기본적으로 rank는 1등부터 시작하므로 자신이 1등일 것이라고 가정한다.
			int rank = 1;
			// 이때 in루프에서 모든사람과 덩치를 비교하면서
			for (int j = 0; j < personNum; j++) {
				// 만약 자신이(현재 덩치가 몇등인지 알고싶은 사람) 키나 몸무게 두가지 전부다 다른사람보다 작다면 rank를 올려준다.
				// 이때 등호(=)를 사용하지 않았으므로 같을때는 rank가 늘어나지않아서
				// 덩치 비교가 안되서 같은 등수를 가지는 사람들은 똑같은 rank를 가지게 된다.
				if (personKg[i] < personKg[j] && personCm[i] < personCm[j]) {
					
					rank++;
				}
			}
			// for문을 빠져나와서 저장된 rank값을 결과배열에 저장
			result[i] = rank;

		}

		// 결과 배열을 출력
		for (int integer : result)
			System.out.print(integer+" ");
	}
}
