
// 왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 
// 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.
// 아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 
// 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.
// 아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.

package Baekjun;

// 난쟁이들의 키를 입력 받자.
// 난쟁이들의 키의 합에서 100을 빼, 가짜 난쟁이 두 명의 키의 합을 도출하자.
// 반복문과 가짜 난쟁이 두명의 키의 합을 통해, 가짜 난쟁이가 누구인지 밝혀내자.
// 가짜 난쟁이들을 제외한, 진짜 난쟁이들의 키를 배열에 저장하고, 정렬하자.
// 값을 출력하자.

import java.util.Arrays;
import java.util.Scanner;

public class P2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] height = new int[9]; // 난쟁이의 키를 입력 받을 크기 9인 배열 height를 생성한다. 
		
		int difference = 0; // 두 가짜 난쟁이의 키의 합을 나타내는 변수 difference를 0으로 초기화 한다. 
		for(int idx = 0; idx < 9; idx++) { // for문을 통해 난쟁이들의 키를 입력 받아, 배열 height에 저장한다.
			height[idx] = sc.nextInt();
			difference += height[idx]; // 입력된 난쟁이들의 키를 모두 더해, difference 변수에 대입하고,
		}
		difference -= 100; // 변수 difference에서 100을 빼, 가짜 난쟁이 두 명의 키의 합을 도출한다.
		
		int idx1 = 0; // 가짜 난쟁이 1호의 인덱스 값을 저장할, 변수 idx1을 0으로 초기화 한다. 
		int idx2 = 0; // 가짜 난쟁이 2호의 인덱스 값을 저장할, 변수 idx2를 0으로 초기화 한다. 
		
		for(int i = 0; i < 9; i++) { // 2중 for문을 실행해,
			for(int j = 0; j < 9; j++) {
				if(height[i] + height[j] == difference && i != j) { // 가짜 난쟁이의 키의 합(difference)과 같은 요소값을 가지면서, 
					// 인덱스 값은 다른 수(인덱스) i와 j를 찾아내,  
					idx1 = i; idx2 = j; // 각각 idx1과 idx2에 저장한다. 
					break;
				}
			}
		}
		
		int[] nHeight = new int[7]; // 진짜 난쟁이들의 키를 저장할 배열 nHeight를 생성한다.
		
		int i = 0;
		for(int idx = 0; idx < 7; idx++) { // for문을 통해 배열 nHeight에 값을 순차적으로 채워 넣는다.
			if(i != idx1 && i != idx2) { // height 배열에서 인덱스 idx1과 idx2가 아닌 값을
				nHeight[idx] = height[i]; // nHeight에 저장하기로 한다.
				i++;
			}
			else {
				i++;
				idx--; // 조건이 충족되지 않았음에도 for문이 실행되면서 idx값이 증가하기 때문에
				// 이를 방지하기 위해, 조건을 충족시키지 못했을 때에도 idx값을 1 감소시킨다.
			}
		}
		Arrays.sort(nHeight); // Arrays.sort 메서드를 사용해 배열을 오름차순으로 정렬한다.
		for(int idx = 0; idx < 7; idx++) {
			System.out.println(nHeight[idx]); // 배열의 요소값을 순차적으로 출력한다.
		}
	}
}
