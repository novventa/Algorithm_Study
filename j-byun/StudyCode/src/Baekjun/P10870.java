import java.util.Scanner;

public class Main {
	// 재귀
	// 10870 피보나치 수 5
	// 브론즈2
	
	// 피보나치 메소드 정의
	public static int fibonacci(int n) {
		// 0번째 피보나치는 0
		if (n == 0) return 0;
		// 1번째 피보나치는 1
		if (n == 1) return 1;
		
		// 0과 1 이외의 값은 n-1번째 값 + n-2번째 값 반환
		// 그럼 n-1번째는 n-2 + n-3 호출하고, n-2는 n-3 + n-4 호출하고 ... 반복해서 0번쨰, 1번째까지 내려감
		return (fibonacci(n - 1) + fibonacci(n - 2));
	}
	
	public static void main(String[] args) {
		// 입력받을 스캐너 가져오기
		Scanner sc = new Scanner(System.in);
		
		// 입력값 n 저장
		int n = sc.nextInt();
		
		// n번째 피보나치 값 출력
		System.out.println(fibonacci(n));
		
	}
}


