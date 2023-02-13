import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// 재귀
	// 1193 분수찾기
	// 실버5
	
	// sum1 : 1/1
	// sum2 : 1/2 2/1
	// sum3 : 3/1 2/2 1/3
	// sum4 : 1/4 2/3 3/2 4/1
	
	// 위의 순서로 진행되는 배열에서
	// 입력값 n번째 분수 찾기
	// => sum의 index값만 알면 됨
	// => 1/index 값으로 시작하는 짝수번째 분수를 기준으로 하고
	// 		홀수번째는 짝수번째의 분모분자를 뒤집기
	
	// sum함수 만들기
	// 1~n까지의 수를 모두 더한 값 반환
	public static int sum(int n) {
		if (n == 0) return 0;
		
		return n + sum(n - 1);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력값 n
        int n = Integer.parseInt(br.readLine());
        br.close();

        int i = 1;

//        System.out.println(n);
        
        // n이 sum 몇 번 째 배열에 들어있는 값인지 찾기
        for (i = 1; sum(i) < n; i++) {
        	if (sum(i) > n) {
        		break;
        	}
        }
        // for문 다 돌면 sum(i) > n >= sum(i - 1)
        
        // 지그재그로 왔다갔다 하는 순서
        // sum index가 짝수일 때 기준으로 분수 값 정하고
        // 홀수일 때는 짝수일 때의 분자와 분모를 바꿔주면 됨
        
        // 분자
        // 해당 sum 배열의 몇 번 째 수 인지?
        int numerator = n - sum(i - 1);
        // 분모
        // 해당 sum 배열 index + 1에서 분자의 값을 뺀 값
        int denominator = (i + 1) - numerator;
        
//        System.out.println(numerator);
//        System.out.println(denominator);

        // 짝수일 때 기준으로 분자 분모를 정했으니
        // 짝수일 때는 분자/분모를 출력
        if (i % 2 == 0) {
        	System.out.println(numerator + "/" + denominator);
        } else {
        	// 홀수일 때는 분모/분자를 출력
        	System.out.println(denominator + "/" + numerator);
        }
        
	}
}

