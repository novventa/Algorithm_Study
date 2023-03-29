
// 민혁이는 타워버거와 불고기버거를 매우 좋아한다.
// 민혁이는 타워버거를 먹는데 n분이 걸리고, 불고기버거를 먹는데 m분이 걸린다.
// 그는 t분 동안 햄버거를 최대한 많이 먹으려고 한다.
// 햄버거를 먹는 도중에 t분이 끝나면 안 되고, 아무것도 안 먹고 있을 때는 콜라를 마신다. 문제의 목적은 다음과 같다.
// 1. 우선 콜라를 마시는 시간을 최소로 한다.
// 2. 콜라를 마시는 시간이 같은 여러 가지 경우에는 햄버거를 가장 많이 먹을 수 있는 경우를 알아본다.

package Baekjun;

// n과 m을 비교해 작은 수를 가려내자. 
// t가 작은 수의 배수라면(나눠 떨어진다면), 작은 수를 나눈 몫과 나머지가 정답이다.
// 배수가 아니라면, 큰 수를 차례로 빼면서 작은 수로 나눌 수 있는 지 확인하고
// 0으로 나눠지지 않는다면, 나머지를 비교하여 나머지가 작은 값을 출력할 수 있도록 하자.
// 추가적인 반례를 생각해보자...

import java.util.Scanner;

public class P1980 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 타워버거를 먹는데 걸리는 시간 n분
		int m = sc.nextInt(); // 불고기버거를 먹는데 걸리는 시간 m분
		int t = sc.nextInt(); // 주어지는 시간 t분
		int cnt = 0; // 섭취한 버거의 개수를 세어줄 변수 cnt
		int min = Integer.MAX_VALUE; // 콜라를 마신시간. max_value로 초기화 한다.
		int sum = 0; // 버거의 합계를 나타내는 변수 sum
		
		if(n > t && m > t) { // 만약 주어진 시간보다 버거를 먹는 시간이 오래걸린다면?
			System.out.println(0 + " " + t); // 콜라만 홀짝이다 끝내자.
		}
		else if(n <= t && m > t) { // 만약 타워버거를 먹을 시간은 되지만, 불고기버거를 먹기에는 시간이 부족하다면?
			System.out.println(t/n + " " + t%n); // 타워버거를 최대한 많이 먹고, 남은 시간은 콜라를 마시자.
		}
		else if(n > t && m <= t) { // 만약 불고기버거를 먹을 시간은 되지만, 타워버거를 먹기엔 시간이 부족하다면?
			System.out.println(t/m + " " + t%m); // 불고기버거를 최대한 많이 먹고, 남은 시간은 콜라를 마시자.
		}
		else if(n >= m) { // 불고기 버거를 먹는데 걸리는 시간이 더 작다면,
			if(t%m == 0) { // 불고기 버거를 먹었을 때 시간이 딱 맞아떨어지는 경우에는,
				System.out.println(t/m + " " + 0); // 양식에 맞춰 출력한다.
			}
			else { int time = t; // 그렇지 않다면,
				while(time > m) { // 반복문을 통해
					time -= n; // 시간에서 타워버거를 빼주고,
					cnt++; // 섭취한 버거의 개수를 늘려준다.
					if(time%m == 0) { // 만약 이후에 불고기 버거를 먹을 시간이 딱 맞아떨어진다면,
						System.out.println((time/m + cnt) + " " + 0); // 양식에 맞춰 값을 출력하고,
						break; // 반복문을 종료한다.
					}
					else if(min > time%m && time > 0) { // 아닌 경우에는 값의 비교를 통해,
						min = time%m; // 콜라를 최소로 마실 수 있는 시간과
						sum = cnt + (time/m); // 먹을 수 있는 버거의 개수를 변수에 입력한다.
					}
				}
				if(time%m != 0) { // 반복문을 빠져나왔을 때, 시간이 딱 맞아떨어지는 상황이 아니라면,
					if(min < t%m) // 두 버거를 섞어서 먹었을 때 콜라를 마신 시간(min)과 
						// 시간이 적게 걸리는 버거만을 먹었을 때 콜라를 마신 시간(t%m)을 비교해,
						// 콜라를 더 적게 마신 값을 출력한다.
						System.out.println(sum + " " + min);
					else
						System.out.println(t/m + " " + t%m);
				}
			}
		}
		else if(n < m) { // 타워버거를 먹는데 걸리는 시간이 더 적은 경우에도, 방법은 동일하다.
			if(t%n == 0) {
				System.out.println(t/n + " " + 0);
			}
			else { int time = t;
				while(time > n) {
					time -= m;
					cnt++;
					if(time%n == 0) {
						System.out.println((time/n + cnt) + " " + 0);
						break;
					}
					else if(min > time%n && time > 0) {
						min = time%n;
						sum = cnt + (time/n);
					}
				}
				if(time%n != 0) {
					if(min < t%n)
						System.out.println(sum + " " + min);
					else
						System.out.println(t/n + " " + t%n);
				}
			}
		}
	}
}