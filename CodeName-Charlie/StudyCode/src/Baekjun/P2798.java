
// 카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다.
// 카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다. 블랙잭은 카지노마다 다양한 규정이 있다.
// 한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.
// 김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다.
// 그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 그런 후에 딜러는 숫자 M을 크게 외친다.
// 이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다.
// 블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.
// N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.

package Baekjun;

//카드의 개수를 나타내는 변수 N을 입력 받는다.
//카드의 합을 나타내는 변수 M을 입력 받는다. 
//카드 3장의 합을 저장하는 배열을 생성한다.
//배열을 정렬한다.
//변수 M과 비교하여 값을 출력한다.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class P2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 카드의 개수를 나타내는 변수인 N을 스캐너를 통해 입력 받는다.
		int M = sc.nextInt(); // 카드의 합을 나타내는 변수 M을 스캐너를 통해 입력 받는다.
		
		int[] num = new int[N]; // 카드의 숫자를 저장할 배열 num를 생성한다.
		for(int i = 0; i < N; i++) { // 배열에 순차적으로 숫자를 입력한다.
			num[i] = sc.nextInt();
		}
		HashSet<Integer> set = new HashSet<Integer>(); // 중복이 허용되지 않는 HashSet을 생성하여, 이곳에 카드의 합을 저장하자.
		
		for(int num1 = 0; num1 < N; num1++) { // 3중 for문을 사용해서 카드 3장의 합을 더한다.
			for(int num2 = 0; num2 < N; num2++) {
				for(int num3 = 0; num3 < N; num3++) {
					if(num1 != num2 && num2 != num3 && num3 != num1) { // 카드는 숫자별로 한 장씩 존재하기 때문에, 
						// 조건문을 통해 더하는 카드의 숫자가 다르도록 설정한다.
						set.add(num[num1] + num[num2] + num[num3]); // 조건문을 만족하면, HashSet에 그 값을 저장하도록 한다.
						// 이 과정에서 중복되는 숫자는 자동으로 걸러져, 저장되지 않는다.
					}
				}
			}
		}
		List<Integer> blackJack = new ArrayList<Integer>(set); // HashSet을 정렬하기 위해, ArrayList로 변환한다.
		Collections.sort(blackJack); // List를 정렬하는 메서드 Collections.sort를 사용해, blackJack List를 정렬한다.
		
		for(int i = 0; i < blackJack.size(); i++) { // 반복문을 통해 ArrayList의 요소 값을 확인한다.
			if(blackJack.get(i) > M) { //확인된 요소 값이 M보다 크다면,
				System.out.println(blackJack.get(i-1)); // 이전의 요소 값을 출력하고,
				break; // 반복문을 빠져나온다.
			}
			else if(blackJack.get(blackJack.size()-1) < M) { // 만약 ArrayList 내의 모든 값이 M보다 작다면,
				// (현재는 Collections.sort메서드를 통해 정렬되어있기 때문에 가장 뒤에 위치한 요소 값만 확인한다.)
				System.out.println(blackJack.get(blackJack.size()-1)); // 가장 뒤에 위치한 요소값을 출력하고,
				break; // 반복문을 빠져나온다.
			} 
		}
	}
}
