import java.util.Scanner;

// 수학
// 1026 보물
// 실버4

// 문제
// 길이가 N인 배열A, B
// 함수 S = A[0] × B[0] + ... + A[N-1] × B[N-1]
// S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자
// B에 있는 수는 재배열하면 안 된다
// S의 최솟값을 출력하는 프로그램을 작성하시고

// 조건
// N은 50보다 작거나 같은 자연수
// A와 B의 각 원소는 100보다 작거나 같은 음이 아닌 정수

// 풀이
// B배열의 가장 큰 값과 A배열의 가장 작은 값이 곱해질 수 있게 정렬하자
// B배열을 돌면서 각 원소들의 크기 순서를 order 배열에 저장해놓고
// A배열을 order배열과 거꾸로 매치되게 정렬하자
// 50*100*100 = int범위 내에서 해결 가능

public class P1026 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt(); // 배열의 크기 N 입력받기
		
		int[] a = new int[size]; // A, B배열 만들기
		int[] b = new int[size];
		
		for (int idx = 0; idx < size; idx++) {
			a[idx] = sc.nextInt(); // A배열의 원소 입력받기
		}
		
		for (int idx = 0; idx < size; idx++) {
			b[idx] = sc.nextInt(); // B배열의 원소 입력받기
		}
		sc.close(); // 입력끝났으니 스캐너 닫기
		
		// B배열의 크기 순서 저장하기
		// 작은 수 부터 큰 수로 진행되는 방향으로 저장하자
		int[] orderB = new int[size]; // B배열의 크기 순서를 저장할 공간
		for (int idx = 0; idx < size; idx++) {
			int cnt = 1; // 현재 확인할 값보다 작은 값의 개수를 세 줄 변수
			
			for (int newIdx = 0; newIdx < size; newIdx++) {
				if (b[idx] > b[newIdx]) cnt++;
			}
			
			// 현재 값보다 작은 값의 개수를 다 세어줬다면 그게 현재 값의 등수인데...
			// 같은 값이 여러 개 있을 수도 있으니 order배열에 해당 값이 있는지 확인하자
			for (int newIdx = 0; newIdx < size; newIdx++) {
				if(orderB[newIdx] != 0 && b[newIdx] == b[idx]) cnt++;
			}
			
			// 이미 순서가 정해진 동일 값도 고려해줬기 때문에 이제 cnt가 현재 값의 등수이다 (1이 가장 작은 수)
			orderB[idx] = cnt;
		}
		
		// A배열의 크기 순서 저장하기
		// 큰 수 부터 작은 수로 진행되는 방향으로 저장하자
		int[] orderA = new int[size]; // A배열의 크기 순서를 저장할 공간
		for (int idx = 0; idx < size; idx++) {
			int cnt = 1; // 현재 확인할 값보다 큰 값의 개수를 세 줄 변수
			
			for (int newIdx = 0; newIdx < size; newIdx++) {
				if (a[idx] < a[newIdx]) cnt++;
			}
			
			// 현재 값보다 큰 값의 개수를 다 세어줬다면 그게 현재 값의 등수인데...
			// 같은 값이 여러 개 있을 수도 있으니 order배열에 해당 값이 있는지 확인하자
			for (int newIdx = 0; newIdx < size; newIdx++) {
				if(orderA[newIdx] != 0 && a[newIdx] == a[idx]) cnt++;
			}
			
			// 이미 순서가 정해진 동일 값도 고려해줬기 때문에 이제 cnt가 현재 값의 등수이다 (1이 가장 큰 수)
			orderA[idx] = cnt;
		}
		
		// orderB배열의 순서대로 A배열을 정렬해보자
		int[] aCopy = new int[size];
		for (int idx = 0; idx < size; idx++) {
			int cnt = orderB[idx]; // 현재 B배열 원소의 등수
			
			for (int newIdx = 0; newIdx < size; newIdx++) { // A배열 원소들의 등수를 저장해놓은 배열을 돌면서
				if(orderA[newIdx] == cnt) // B배열 원소의 등수와 같은 애를 찾았다면
					aCopy[idx] = a[newIdx]; // 같은 등수의 A배열 원소를 B배열과 같은 인덱스에 저장하자
			}
		}
		
		// A배열의 원소를 B배열 원소들의 등수에 맞게 재정렬했다면 다시 A배열에 저장하자
		a = aCopy.clone(); // 얕은 복사
					// 더 이상 aCopy의 값을 바꾸지 않을거니까 얕은 복사만 해도 문제없다
					// 깊은 복사가 필요할 때는 deepCopy() 메소드 사용
					// size만큼 for문을 돌려서 aCopy의 값을 a배열에 저장해 주는 방법도 있지만,
					// java method 활용하는 방법을 실험해보자
		
		// 정렬이 끝났으니 같은 인덱스 번호를 가진 A배열 원소와 B배열 원소를 곱해서 결과값에 더해주자
		int sum = 0;
		for (int idx = 0; idx < size; idx++) {
			sum += a[idx] * b[idx];
		}
		
		System.out.println(sum);
	}

}
