package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class P7568_1 {
	public static void main(String[] args) throws IOException {
		// 버퍼리더를 사용한다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 횟수를 받아온다.
		int T = Integer.parseInt(br.readLine());

		// 배열을 리스트에 넣어서 Comparator을 사용하여 답을 구하려고 한다.
		List<int[]> personSize = new ArrayList<>();

		// 테스트 케이스 횟수가 반복되는동안 배열에 사람의 키, 몸무게, 인덱스 값, rank값을 넣어준다.
		for (int i = 0; i < T; i++) {
			// 크기가 4인 배열을 만든다.
			int[] person = new int[4];
			// tokenizer를 사용해 키와 몸무게를 받아온후
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 차례대로 person배열에 넣어준다.
			// rank의 경우 아직 정해지지않았으므로 초기값으로 둔다.
			person[0] = Integer.parseInt(st.nextToken());
			person[1] = Integer.parseInt(st.nextToken());
			person[2] = i;
			personSize.add(person);
		}

//		//리스트에 배열이 잘 담겼는지 확인한다.
//		for (int[] i : personSize) {
//			System.out.println(Arrays.toString(i));
//
//		}
//
//		System.out.println();

		// Comparator을 사용해서 0번째 즉 몸무게를 내림차순으로 정리한다.
		Collections.sort(personSize, new Comparator<int[]>() {
			// Comparator을 재정의 한다.
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				// int[]배열의 0번째 원소끼리 비교후 내림차순으로 정리한다.
				return Integer.compare(o2[0], o1[0]);
			}
		});

		// Comparator을 사용해서 1번째 즉 키를 내림차순으로 정리한다.
		Collections.sort(personSize, new Comparator<int[]>() {
			// Comparator을 재정의 한다.
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub

				// int[]배열의 1번째 원소끼리 비교후 내림차순으로 정리한다.
				return Integer.compare(o2[1], o1[1]);
			}
		});

//		//리스트에 배열이 잘 정렬됬는지 확인한다.
//		for (int[] i : personSize) {
//			System.out.println(Arrays.toString(i));
//
//		}
//
//		System.out.println();

		// 리스트의 크기를 변수로 저장해준다.
		// for문에서 계속 불러오는 것을 막기위해서(?)
		int size = personSize.size();

		// 이중 for문을 통해 rank를 구해준다.
		// 사실 이걸 쓸꺼였으면 위에 comparator은 필요가 없다
		for (int i = 0; i < size; i++) {
			// 기준이 되는 사람의 랭크를 우선 1로 정의한다.
			int rank = 1;
			for (int j = 0; j < size; j++) {
				// 자기자신을 포함한 모든사람과 비교하면서 자신보다 덩치가 큰사람이 있으면 rank를 올린다.
				if (personSize.get(i)[0] < personSize.get(j)[0] && personSize.get(i)[1] < personSize.get(j)[1]) {
					rank++;
				}
			}
			// 나온 랭크를 저장한다.
			personSize.get(i)[3] = rank;
		}

//		System.out.println();

		// 다시한번 index기준으로 정의한다.
		// 덩치 순위를 사람 순으로 보여줘야하기때문에 index순으로 정렬한다.
		Collections.sort(personSize, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[2], o2[2]);
			}
		});

		// 정렬한 이후 리스트에서 3번째 rank값만 출력한다.
		for (int[] i : personSize) {
			System.out.print(i[3] + " ");

		}

	}

}
