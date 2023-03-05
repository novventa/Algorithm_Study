
// 정보 초등학교에서는 단체로 2박 3일 수학여행을 가기로 했다. 여러 학년이 같은 장소로 수학여행을 가려고 하는데 1학년부터 6학년까지 학생들이 묵을 방을 배정해야 한다.
// 남학생은 남학생끼리, 여학생은 여학생끼리 방을 배정해야 한다. 또한 한 방에는 같은 학년의 학생들을 배정해야 한다. 물론 한 방에 한 명만 배정하는 것도 가능하다.
// 한 방에 배정할 수 있는 최대 인원 수 K가 주어졌을 때, 조건에 맞게 모든 학생을 배정하기 위해 필요한 방의 최소 개수를 구하는 프로그램을 작성하시오.

package Baekjun;

// 변수 N과 K를 입력 받자.
// 남학생과 여학생 수를 저장할 배열을 생성하고, 해당 값이 입력 되면, 인덱스를 증가시킨다.
// 배열에 저장 된 학생 수를 변수 K와 비교해서,   
// 학생 수를 K로 나눈 몫과 나머지를 토대로, 필요한 방의 최소값을 도출하자.

import java.util.Scanner;

public class P13300 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 수학여행에 참가하는 학생 수 N을 입력 받는다.
		int K = sc.nextInt(); // 한 방에 배정할 수 있는 최대 인원 수 K를 입력 받는다. 
		
		int[] boy = new int[6]; // 남학생 수를 학년별로 나눠 저장할 배열 boy를 생성한다.(1학년부터 6학년까지 구분하여 저장하기 위해 크기 6의 배열을 생성한다.)
		int[] girl = new int[6]; // 마찬가지로, 여학생 수를 학년별로 나눠 저장할 배열 girl을 생성한다.
		
		for(int idx = 0; idx < N; idx++) { // 반복문을 통해 학생들의 정보를 입력 받는다.
			int sex = sc.nextInt(); // 성별을 입력받고,
			if(sex == 0) { // 성별이 여자인 경우(0인 경우,)
				int grade = sc.nextInt(); // 학년을 입력 받아서,
				girl[grade-1]++; // girl 배열의 해당 인덱스를 증가시킨다.
			}
			else {
				int grade = sc.nextInt(); // 남자의 경우도 마찬가지로
				boy[grade-1]++; // boy 배열의 해당 인덱스를 증가시킨다.
			}
		}
		int room = 0; // 방의 최소값을 나타내는 변수 room을 선언하고, 0으로 초기화한다.
		for(int idx = 0; idx < 6; idx++) { // for문을 통해, 각 배열을 탐색해,
			if(boy[idx]%K == 0) { // 만약 배열의 요소값을 K(한 방에 들어갈 수 있는 최대 인원)로 나눴을 때, 그 나머지가 0이라면,
				room += boy[idx]/K; // 몫만큼, 변수 room을 증가시키고,
			}
			else {
				room += ((boy[idx]/K) + 1); // 나머지가 0이 아니라면, 몫+1(남은 인원이 묵을 방이 하나 더 필요)만큼 변수 room을 증가시킨다.
			}
			
			if(girl[idx]%K == 0) {
				room += girl[idx]/K;
			}
			else {
				room += ((girl[idx]/K) + 1);
			}
		}
		System.out.println(room); // room을 출력한다. 
	}
}
