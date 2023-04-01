/* 문제
 * 상근이는 "최고의 피자"를 구매하고 싶다.
 * "최고의 피자"란 주문할 수 있는 피자 중 1원당 열량이 가장 높은 피자를 말한다.
 * 피자 가게는 토핑 N개에서 여러 종류를 선택해서 주문할 수 있다.
 * 같은 종류의 토핑을 2개 이상 선택할 수는 없고, 토핑을 전혀 선택하지 않을수도 있다.
 * 도우의 가격이 A원, 토핑은 모두 B원이라고 할 때,
 * 피자의 가격은 A+B*k(k : 토핑의종류)가 된다.
 * 도우의 가격, 토핑의 가격, 도우와 토핑의 열량 값이 주어졌을 때, 최고의 피자의 1원당 열량을 구해보자.
 *  
 * 
 * 
 * 조건
 * 토핑의 종류의 수는  1 이상 100 이하다.
 * 도우와 토핑의 가격은 1 이상 1000 이하다.
 * 도우와 토핑의 열량은 1 이상 10000 이하다.
 * 같은 종류의 토핑을 2개 이상 선택할 수는 없고, 토핑을 전혀 선택하지 않을수도 있다.
 * 
 * 
 * 
 * 아이디어
 * 토핑의 가격은 모두 같으므로 피자의 1원 당 열량이 가장 높기 위해서는, 토핑의 열량이 중요하다.
 * 토핑의 열량을 내림차순으로 정렬한다면, 열량이 큰 값부터 계산된다.
 * 열량을 계산 후 열량을 가격으로 나눈 값을 구해보자.
 * 이때, 계산한 값이 기존 값 보다 작아진다면, 내림차순으로 정렬했으므로 다음 값도 무조건 작아질 수 밖에 없다.
 * 
 * 
 * 
 * 아이디어 요약
 * 내림차순으로 정렬해서 최고 열량을 찾아보자.
 * max값이 낮아지기 바로 전 순간이 최고가다.
 * 
 * 
 */

package Baekjun;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P5545 {

	// N : 토핑의 수
	static int N;

	// dowPrice : 도우의 가격
	static int dowPrice;

	// topingPrice : 토핑의 가격
	static int topingPrice;

	// dowCalories : 도우의 열량
	static int dowCalories;

	// max : 최고의 피자의 1원 당 열량 중 최댓값을 저장할 변수
	static int max;

	public static void main(String[] args) {

		// 우선순위 큐를 이용하여 값을 내림차순으로 뽑아보자.
		// Collections.reverseOrder() : 우선순위 큐에서 하나씩 뽑을 때마다 가장 큰 값이 나온다.
		PriorityQueue<Integer> topingCalories = new PriorityQueue<>(Collections.reverseOrder());

		Scanner sc = new Scanner(System.in);

		// 토핑의 수
		N = sc.nextInt();

		// 도우의 가격
		dowPrice = sc.nextInt();

		// 토핑의 가격
		topingPrice = sc.nextInt();

		// 도우의 칼로리
		dowCalories = sc.nextInt();

		// N개의 토핑의 열량
		for (int i = 0; i < N; i++) {
			topingCalories.offer(sc.nextInt());
		}

		// 열량의 합에 도우의 열량으 저장해놓자.
		int sumCalories = dowCalories;

		// 피자의 가격엔 도우의 가격을 저장해놓자.
		int sumPrice = dowPrice;

		// 토핑이 선택되지 않는 경우도 있으므로
		// 열량/가격 max값에 저장해두자.
		max = sumCalories / sumPrice;

		// 우선순위 큐가 빌 때 까지 반복해보자.
		// 중간에 max값이 낮아지는 순간에는 break를 하여 메모리를 아끼자.
		while (!topingCalories.isEmpty()) {

			// 우선순위 큐에서 토핑의 열량을 하나 빼낸다.
			int poll = topingCalories.poll();

			// 열량의 합 변수에 빼낸 값을 더하자.
			sumCalories += poll;

			// 가격에는 토핑 가격을 더한다.
			sumPrice += topingPrice;

			// 최댓값을 다시 구해보자.
			// 기존에 저장된 값보다 크거나 같다면 갱신하고,
			// 크거나 같은 이유는, 소숫점을 버리며 계산되므로, 실제로는 더 큰 값이지만 버림이 되어서
			// 값이 더이상 증가하지 않기 때문이다.

			// 예를 들어, 도우의 가격이 12원, 열량이 10인 경우,
			// 현재 max값은 10/12 = 0이 된다.
			// 다음으로 토핑의 가격이 9원, 토핑의 열량이 10인 경우,
			// (10+10)/(12+9) = 0.95 이고, 버림으로 계산되므로 0이 된다.
			// 이 경우 같다는 조건이 없다면 반복문이 여기서 빠져나오게 된다.
			// 하지만 다시 토핑의 열량이 10 인 경우
			// (10+10+10)/(12+9+9) = 1이 되므로, 같다는 조건이 필요하다.

			// 조건에 맞지 않는다면 이미 최댓값이 구해진 상태이므로 break를 하자.

			if (max <= sumCalories / sumPrice) {
				max = sumCalories / sumPrice;
			} else {
				break;
			}
		}

		System.out.println(max);

	}

}
