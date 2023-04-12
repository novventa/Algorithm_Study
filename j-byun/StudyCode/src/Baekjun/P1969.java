import java.util.Scanner;

/**
 * @author jihye.byun
 * BOJ 1969 DNA 실버4 문자열/그리디/브루트포스
 * 
 * 문제
 * DNA 구성 : A, T, G, C
 * Hamming Distance : 길이가 같은 두 DNA에서, 각 위치의 구성 문자가 다른 것의 개수
 * 길이 M인 DNA가 N개 주어졌을 때, Hamming Distance의 합이 가장 작은 DNA s를 구하자.
 * s와 s1의 Hamming Distance + s와 s2의 Hamming Distance + s와 s3의 Hamming Distance ... 의 합이 최소가 된다는 의미이다.
 * 
 * 조건
 * DNA갯수 N은 1,000보다 작거나 같은 자연수
 * DNA길이 M은 50보다 작거나 같은 자연수
 * Hamming Distance 합이 같은 DNA가 있다면, 사전순으로 가장 앞서는 DNA를 출력하시오.
 * 
 * 풀이
 * 1. AAAAA~GGGGG 까지 만들어서 다른애들이랑 한 번씩 다 확인해보자.
 * 2. 한 번씩 다 확인하며 Hamming Distance 합을 구하고, 최솟값일 때는 합과 DNA를 업데이트해주자.
 * 2-1. 문자열도 사전순으로 대소 비교 할 수 있음을 활용하자.
 * 2-2. Hamming Distance 합의 초기값은 DNA길이 * DNA갯수로 지정하자.
 * 
 * => 시간초과
 * 1-1. 모든 DNA를 다 만들어보지 말고, 각 위치의 구성 문자 중 제일 많이 등장한 문자로 DNA를 구성하자
 */

public class P1969 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // DNA 갯수
		int M = sc.nextInt(); // DNA 문자열의 길이
		
		String[] dna = new String[N]; // N개의 DNA를 저장할 배열 공간
		
		// DNA 정보를 입력받자
		for (int idx = 0; idx < N; idx++) {
			dna[idx] = sc.next();
		}
		
		String minDna = ""; // 최소 Hamming Distance 합을 가지는 DNA 정보를 저장할 변수
		int min = 0; // 최소 Hamming Distance 합을 저장할 변수
		
		// DNA의 각 위치에 제일 많이 등장한 문자를 찾아서 그 문자를 디폴트로 정하자
		for (int idx = 0; idx < M; idx++) {
			// 사전 순으로 A C G T 순서대로 갯수를 세어주자
			int[] count = new int[4];
			
			for (int dnaNum = 0; dnaNum < N; dnaNum++) {
				char curr = dna[dnaNum].charAt(idx);
				
				switch (curr) {
				case 'A' :
					count[0]++;
					break;
				case 'C' :
					count[1]++;
					break;
				case 'G' :
					count[2]++;
					break;
				case 'T' :
					count[3]++;
					break;
				}
			}
			
			// 이제 현재 위치에 네 종류의 문자 중 어떤게 제일 많이 나왔는지 확인해주자
			int maxCount = 0;
			int maxAlphaIdx = 0;
			for (int alpha = 0; alpha < 4; alpha++) {
				// 사전 순으로 나열했으니 maxCount가 동일한 경우는 고려하지 않아도 된다
				if (maxCount < count[alpha]) {
					maxCount = count[alpha];
					maxAlphaIdx = alpha;
				}
			}
			
			// 이제 현재 위치에 제일 많이 등장한 문자로 지정해주고,
			// 이 때 현재 위치에 대한 Hamming Distance 합은 N - count 이다
			switch (maxAlphaIdx) {
			case 0 :
				minDna += "A";
				break;
			case 1 :
				minDna += "C";
				break;
			case 2 :
				minDna += "G";
				break;
			case 3 :
				minDna += "T";
				break;
			}
			min += N - count[maxAlphaIdx];
		}
		
		System.out.println(minDna);
		System.out.println(min);
	}
	
	/*
	 * 시간초과 코드
	 * 
	static int N, M, min;
	static String[] dna;
	static String minDna;
	
	public static void calcDist(String newDna) {
		// 지금 만들어본 DNA와, 입력으로 들어온 N개의 DNA를 비교해보자
		
		// 현재 DNA 기준 Hamming Distance 합을 저장할 변수를 초기화해주자
		int sum = 0;
		
		for (int you = 0; you < N; you++) {
			// 나랑 다른 애랑 DNA 문자열 길이만큼 확인해보자
			// 다른 뉴클오티드 개수만큼 세어주자
			for (int idx = 0; idx < M; idx++) {
				if (newDna.charAt(idx) != dna[you].charAt(idx))
					sum++;
				
				// 시간초과 뜨니까 유망성 없는 가지는 잘라내버리자
				if (sum > min)
					return;
			}
		}
		
		// 현재 DNA 기준 Hamming Distance 합을 다 구했다면, 최솟값인지 확인해서 업데이트하자
		if (sum < min) {
			min = sum;
			// 최솟값이 업데이트됐다면 DNA 정보도 업데이트
			minDna = newDna;
			
		} else if (sum == min) {
			// 최솟값이 업데이트되지는 않고 동일하다면, DNA 정보는 사전순 앞에 있는 애로 업데이트
			if (minDna.compareTo(newDna) > 0)
				minDna = newDna;
		}
	}
	
	public static void comb(int depth, int maxDepth, String dna) {
		// 길이가 M인 모든 DNA를 만들어보자
		
		// 길이가 M이 됐다면 이제 입력으로 들어온 DNA들과 비교해서 Hamming Distance를 구해보자
		if (depth == maxDepth) {
			calcDist(dna);
			return;
		}
		
		// A, T, G, C 로 DNA를 구성해보자
		comb(depth + 1, maxDepth, dna + "A");
		comb(depth + 1, maxDepth, dna + "T");
		comb(depth + 1, maxDepth, dna + "G");
		comb(depth + 1, maxDepth, dna + "C");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // DNA 갯수
		M = sc.nextInt(); // DNA 문자열의 길이
		
		dna = new String[N]; // N개의 DNA를 저장할 배열 공간
		
		// DNA 정보를 입력받자
		for (int idx = 0; idx < N; idx++) {
			dna[idx] = sc.next();
		}
		
		minDna = null; // 최소 Hamming Distance 합을 가지는 DNA 정보를 저장할 변수
		min = N * M; // 최소 Hamming Distance 합을 저장할 변수
		
		// 길이가 M인 모든 DNA를 만들어보자
		comb(0, M, "");
		
		System.out.println(minDna);
		System.out.println(min);
	}
	*/
	
}
