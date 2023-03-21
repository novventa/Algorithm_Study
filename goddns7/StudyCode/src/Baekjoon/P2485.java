package solution;

import java.util.Scanner;

public class P2485 {

	public static void main(String[] args) {
		// 모든 가로수가 같은 간격이 되도록 새로 심어야 하는 가로수의 최소수를 구하기 위해서는
		// 가장 넓게 같은 간격을 가져야 한다
		// 즉, 간격들의 최대공배수를 구해야 한다.
		//[방법1] <= 시간 초과
//		// -> 간격들의 수들 중 가장 작은 값보다 작거나 같은 범위에서
//		// 간격들을 특정 정수를 나눠서 나머지가 0이 되는 수 중에서 최대 값을 구해야 한다. => 최대공배수 값
		
		//[방법2] : 유클리드 호제법
		// 이론: a>=b일 때, a%b=r이면 => a, b의 최대공약수는 b와 r의 최대공약수와 같다
		Scanner sc = new Scanner(System.in);

		// 이미 심어져 있는 가로수의 수
		int treeCnt = sc.nextInt();

		// 심어져 있는 가로수의 위치
		int[] tree = new int[treeCnt];

		for (int i = 0; i < treeCnt; i++) {
			tree[i] = sc.nextInt();
		}

		// 심어져 있는 가로수 사이의 간격
		int[] width = new int[treeCnt - 1];
		// 가로수 사이의 간격은 다음 가로수 - 현재 가로수의 값이다
		for (int i = 0; i < treeCnt - 1; i++) {
			width[i] = tree[i + 1] - tree[i];
		}

		// 간격들의 수들 중 가장 작은 값을 구한다
		int min = 1000000000;
		for (int i = 0; i < treeCnt - 1; i++) {
			if (min > width[i]) {
				min = width[i];
			}
		}

		//[방법1]
//		// 간격들의 수들 중 가장 작은 값보다 작거나 같은 범위에서
//		// 간격들을 특정 정수를 나눠서 나머지가 0이 되는 수 중에서 최대 값 => 최대공배수 값
//		int finalWidth = 0;

//		for (int i = min; i >= 1; i--) { 	// 간격들의 수들 중 가장 작은 값보다 작거나 같은 범위에서
//			int count = 0; 					// 특정 정수로 나눌 때 나머지가 0이 되면 count++시켜주기 (=> 최종적으로 width배열의 크기와 같아지면 해당 수는 최대공약수)
//			int idx = 0; 					// 심어져 있는 가로수 사이의 간격의 배열(width)에서의 인덱스
//			while (idx < treeCnt - 1) {
//				if (width[idx] % i == 0) {
//					count++;
//				}
//				idx++; // width배열의 원소들 모두 확인
//			}
//			if (count == treeCnt - 1) {		// count의 개수를 구해 최종적으로 width배열의 크기와 같아지면
//				finalWidth = i; 			// 해당 수는 최대공약수
//				break;	
//			}
//		}

		//[방법2]
		
		int gcdFirst = 0;	//최대공약수
		//제일 앞의 두 수의 최대공약수를 구해준다
		gcdFirst = gcd(width[0], width[1]);
		//그 다음 수와 최대공약수의 최대공약수를 구해서 갱신해준다
		for(int i=2; i<treeCnt-1; i++) {
			gcdFirst = gcd(gcdFirst, width[i]);
			
		}

		// 새로 심어야 하는 가로수의 합
		int sum = 0; 						
		for (int i = 0; i < treeCnt - 1; i++) { 	// tree배열의 모든 원소를 다 확인하기 위한 범위
			sum += width[i]/ gcdFirst - 1; 			// tree배열에서 다음 원소-현재원소(즉, 간격)를 최대공약수로 나누고 -1 하면
		} 											// 해당 간격에서 심어야 하는 가로수의 수를 구할 수 있다.
		System.out.println(sum);
		sc.close();
	}
	
	public static int gcd(int a, int b) {
		
		//0으로 나눠질 때까지 계속 반복
		while(b!=0) {
			//1. 나머지를 구한다
			int r= a%b;
			
			//2. "a,b의 최대공배수 = b, r의 최대공배수"를 찾아내기위해
			//	-> a : b , b : r로 변환시킨다
			a = b;
			b = r;
		}
		
		return a;
	}

}





