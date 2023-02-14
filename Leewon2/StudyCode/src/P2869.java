import java.util.Scanner;

// 문제 조건
// 1<=자는 동안 미끄러지는 미터<낮에 올라가는 미터<=나무막대의 높이<=1,000,000,000
// 정상에 올랐을 땐 더이상 미끄러지지 않는다.

// 문제 해결 방법
// 달팽이가 나무에 다 올라가기 위해선 (나무높이 - n*(올라가기 - 내려오기))가 된다.
// 하지만 위 식은 정상에 올랐을 때도 내려가기 때문에 내려오는 횟수를 1회 줄인다.
// 이를 식으로 표현하면, (나무높이 - (n*올라가기 - (n-1) * 내려오기))가 된다.
// 변수를 대입해 식을 정리하면, (V - (n*A - (n-1)*B))가 된다.
// V - (n*A - (n-1)*B) = V - (n*A - n*B+B)) = (V-B) - n(A-B)가 된다.
// n에 대하여 정리하면, V-B = n(A-B) -> (V-B)/(A-B)=n이 된다.
// 만약 위 식이 1.23과 같이 소수라면, 달팽이는 1.23회 올라간 것이 아닌 2회를 올라간 것이다.
// 즉, 위 식을 올림 해야한다.

public class P2869 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// A : 낮에 올라가는 미터
		// B : 자는 동안 미끄러지는 미터
		// V : 나무의 높이
		double A = sc.nextInt();
		double B = sc.nextInt();
		double V = sc.nextInt();
		// 올림을 하는 Math.ceil 함수를 사용해 올림한다.
		double result = Math.ceil((V - B) / (A - B));

		// 정수형으로 출력하기 위해 int로 형변환을 한 후 출력한다.
		System.out.println((int) result);

	}
}
