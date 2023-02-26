import java.util.Scanner;

// 8320 직사각형을 만드는 방법
// 브론즈2

// 문제
// 변의 길이가 1인 정사각형 n개로 만들 수 있는 직사각형의 개수는?

// 조건
// 이동, 회전했을 때 같은 직사각형은 하나로 친다
// 정사각형을 변형시키거나, 정사각형을 겹쳐서 놓을 수 없다
// 직사각형 안에 빈 공간이 있을 수 없다
// 1 <= n <= 10000

// 풀이
// 1~n의 약수 구해서 다 더하기
//	=> 정사각형을 n개 이하로만 활용하면 됨
// a*b = n인 a,b를 찾는데...
// 둘이 자리 바뀐 건 회전했을 때 같은 직사각형 이니까
// a <= b의 조건 하에서 찾기

public class BOJ_8320_직사각형을만드는방법_변지혜 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int product = sc.nextInt(); // 정사각형 개수 n 입력받기
		
		int cnt = 0; // 만들 수 있는 직사각형의 개수
		
		for (int num = 1; num <= product; num++) { // 1~n까지의 약수 다 구하자
			for (int a = 1; a <= Math.sqrt(num); a++) { // a*b=n && a <= b 조건을 만족하는 a,b를 찾을거니까 num의 제곱근까지만 탐색
				if (num % a == 0 && a <= (num / a)) { // a*b=n && a <= b 조건만족하면
					cnt++; // 직사각형 개수 하나 더하기
				}
			}
		}
		
		System.out.println(cnt); // 총 만들 수 있는 직사각형 개수 출력

	}

}

