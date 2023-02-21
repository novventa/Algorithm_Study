
// 육각형으로 이루어진 벌집이 있다.
// 중앙의 방 1부터 시작해서 이웃하는 방에 돌아가면서 1씩 증가하는 번호를 주소로 매길 수 있다.
// 숫자 N이 주어졌을 때, 벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 계산하는 프로그램을 작성하시오.

package Baekjun;

// 구획의 번호가 증가할 때 마다, 해당 구획의 최고 번호는 6(n-1)씩 늘어나는 규칙을 가지고 있다. 
// 1  
// 1 + (6*1)
// 1 + (6*1) + (6*2)
// ...
// 1 + (6*1) + (6*2) + ... + (6*n)
// 숫자를 입력했을 때, 구획을 출력해주는 메서드를 작성해 풀어보자.

import java.util.Scanner;

public class P2292 {

	static void bee(int num) { // 변수 num를 매개 변수로 받는 메서드 bee를 생성한다.
		int index = 0; // index 초기값을 0으로,
		int cnt = 1; // cnt 초기값을 1로 각각 초기화 한다.(cnt는 구획의 인덱스를 나타내는 변수이며, 1부터 시작하기 때문에 초기값을 1로 설정)
		if (num == 1) { // bee 메서드에 매개 변수 1이 입력되면, 
			System.out.println(1); // 그대로 1을 출력한다.
		} else { // 1이 아닌 수가 입력되면,
			while (num > 1) { // 매개변수가 1이하가 될 때 까지 while문을 실행하자.
				cnt++; // cnt 값이 1 증가하고,
				index++; // index 값도 1 증가한다.
				num -= (6 * index); // num에서 6*index 값을 뺀다.
			}
			System.out.println(cnt); // while문이 종료되면, 변수 cnt를 출력한다.
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 변수 N을 입력 받는다.

		bee(N); // 해당 변수를 매개 변수로 메서드 bee를 실행한다.
	}
}