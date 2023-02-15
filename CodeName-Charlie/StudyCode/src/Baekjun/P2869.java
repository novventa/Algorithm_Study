
// 땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
// 달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
// 달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.

package Baekjun;

import java.util.Scanner;

public class P2869 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt(); // 낮에 올라가는 거리인 A를 입력 받는다.
		int B = sc.nextInt(); // 밤에 미끄러지는 거리인 B를 입력 받는다.
		int V = sc.nextInt(); // 나무 막대기의 높이 V를 입력 받는다.
			
		int first = V-A; // 나무 막대기의 높이와 달팽이가 올라가는 높이의 차를 변수로 선언한다.
		int result = A-B; // 달팽이가 결과적으로 이동한 거리(올라간 거리 A - 미끄러진 거리 B)에 대한 변수 result를 선언한다.
		
		if(first == 0) { // 만약, 막대기의 높이와 달팽이가 올라가는 거리가 같다면,
			System.out.println(1); // 1을 출력한다.
			return;
		}
		int	day = first / result; // 달팽이가 나무 막대기를 올라가는데 걸리는 날짜를 변수로 선언한다.
		
		if(day * result + A >= V) { // 만약 막대기의 높이보다, (날짜 * 하루 이동 거리 + 올라간 거리)가 크거나 같다면, 
			System.out.println(day + 1); // 날짜에 1을 더해 출력하고,
		}
		else {
			System.out.println(day + 2); // 작다면, 2를 더해 출력한다.
		}
	}
}