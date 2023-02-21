package test;

import java.util.Scanner;
import java.util.Stack;

// SWEA
// 5432 쇠막대기 자르기
// D4

// 문제
// 여러개의 쇠막대기를 레이저로 절단

// 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 “()” 으로 표현된다. 또한, 모든 “()”는 반드시 레이저를 표현한다.
// 쇠막대기의 왼쪽 끝은 여는 괄호 ‘(’ 로, 오른쪽 끝은 닫힌 괄호 ‘)’ 로 표현된다.

// 조건
// 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다.
// 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되, 끝점은 겹치지 않도록 놓는다.
// 각 쇠막대기를 자르는 레이저는 적어도 하나 존재한다.
// 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다.

// 괄호 문자의 개수는 최대 100,000이다.

// 풀이
// char 기준으로 끊어서 입력받으면서...
// (가 들어오면
// 		다음애가 ) 인지 확인
// 		다음애가 ) 라면 이건 레이저니까
//		여태 스택에 들어있던 ( 갯수 다 세서 ++ (여기서 조각났음!)
//				=> 어차피 레이저 지나가면 다음 조각 시작해야되니까 ( 빼지는 말고 그대로 놔두기
//			=> ) 다음 순서로 넘어감
//		다음애가 )가 아니라면
//		스택에 넣어주기
// )가 들어오면
// 들어있던 ( 하나 빼주고 갯수 ++ 하기
// => 스택에는 여는 괄호만 들어갈 수 있음!!!

public class SWEA_5432_쇠막대기자르기_변지혜 {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		// 테스트케이스 수 t 입력받기
		int t = sc.nextInt();
		
		// 테스트케이스 개수만큼 반복
		for (int testCase = 1; testCase <= t; testCase++) {
			// 출력양식
			sb.append("#").append(testCase).append(" ");
			
			// 괄호를 저장할 스택 bracket 만들기
			Stack<Character> bracket = new Stack<>();
			
			// 쇠막대기 조각 개수를 저장할 sum 공간 만들기
			int sum = 0;
			
			// 쇠막대기와 레이저 배치를 나타내는 괄호 표현 읽어오기
			String read = sc.next();
			
			// read에서 확인할 char의 index를 나타낼 idx 만들기
			int idx = 0;
			
			// 읽어온 bracket의 길이만큼 다 확인할 때 까지 반복
			while (idx < read.length()) {
				
				// 여는 괄호 ( 가 들어왔다면 
				// 그 다음이 닫는 괄호 ) 인지 확인
				if (read.charAt(idx) == '(') {
					
					// 다음이 닫는 괄호 ) 라면
					// 얘는 레이저다!
					if (read.charAt(idx + 1) == ')') {
						// stack에는 여는 괄호 ( 만 들어있으니까
						// stack의 길이가 곧 여는 괄호 (쇠막대기)의 개수이다
						// 레이저가 조각낼거니까
						// stack에서 꺼내지는 말고 개수만 세서 sum에 더해주기
						sum += bracket.size();
						
						// 레이저 다음 괄호 확인하러 가기
						idx += 2;
						
					} else {
						// 다음이 닫는 괄호 ( 가 아니라면
						// 얘는 그냥 새로운 쇠막대기의 시작이니까
						// 스택에 넣어주기
						bracket.push('(');
						
						// 다음꺼 확인하러가기
						idx++;
					}
				} else {
					
					// 닫는 괄호 ) 가 들어왔다면
					// 이게 레이저일 경우는 위의 if문에서 여는괄호-닫는괄호 가 연속으로 들어올때 고려해줬기 때문에
					// 남은 건 쇠막대기의 끝일 때 뿐이다
					// => stack에서 여는 괄호 ( 하나 뽑아내고
					// 쇠막대기 조각 개수 하나 ++
					bracket.pop();
					sum++;
					
					// 다음꺼 확인하러가기
					idx++;
				}
				
			}
			
			// while문이 끝나면 읽어온 괄호의 개수만큼 다 처리했으니까
			// 최종 쇠막대기의 개수 sum값 출력
			sb.append(sum).append("\n");
		}
		
		// 출력
		System.out.println(sb);
	}

}


