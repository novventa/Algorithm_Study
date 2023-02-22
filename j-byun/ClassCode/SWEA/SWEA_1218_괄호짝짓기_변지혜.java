import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1218 괄호 짝짓기
// D4

// 문제
// 4종류의 괄호 () [] {} <> 이루어진 문자열

// 짝 맞으면 1, 안맞으면 0 출력

// 풀이
// 여는 괄호면 일단 넣고
// 닫는 괄호면 현재 큐 길이 만큼 확인하고
// 내 짝 여는괄호 나올 때 까지 다 뽑아서 다시 큐에 넣어
// 		짝 맞으면 둘이 날려버리고
// 		만약에 현재 큐 길이만큼 다 확인했는데 짝 못찾으면 0출력
// 입력 문자열 끝났는데 큐 남아있으면 0출력
// 나머지 1출력

public class SWEA_1218_괄호짝짓기_변지혜 {

	static int size;
	static String brackets;
	static Queue<Character> openingBrackets;
	static HashMap<Character, Character> bracketMatch = new HashMap<Character, Character>() {{ // 괄호 짝 default 저장
		put(')', '(');
		put(']', '[');
		put('}', '{');
		put('>', '<');
	}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) { // 테케 10개만큼 반복
			
			size = sc.nextInt(); // 괄호문자열 길이
			
			brackets = sc.next(); // 괄호 문자열 입력받기
			
			openingBrackets = new LinkedList<Character>(); // 여는 괄호 저장할 큐
			
			int result = matchingBrackets(); // 괄호 짝짓기 method 실행해서 결과값 받기
			
			sb.append("#").append(tc).append(" ").append(result).append("\n"); // 출력 양식
		}

		System.out.println(sb); // 출력
	}
	
	private static int matchingBrackets() { // 괄호 짝짓기 method
		Character current;
		Character before;
		int opBSize;
		
		for (int idx = 0; idx < size; idx++) { // 괄호 문자열 길이만큼 반복
			current = brackets.charAt(idx); // 현재 확인할 괄호 저장
			
			if (current == '(' || current == '[' || current == '{' || current == '<')  { // current가 여는 괄호면
				openingBrackets.offer(current); // 여는 괄호 큐에 넣어줌
				continue;
			}
			
			opBSize = openingBrackets.size(); // current가 닫는 괄호면 여는 괄호 큐 다 확인해야되니까 여는 괄호 큐의 사이즈 저장
			
			for (int newIdx = 0; newIdx < opBSize; newIdx++) { // 닫는 괄호면 여는 괄호문자열을 다 확인해서
				before = openingBrackets.poll(); // 현재 확인할 여는 괄호 저장
				
				if (before == bracketMatch.get(current)) { // 짝인 여는 괄호를 발견하면 둘이 같이 날려버리자
					break;
					
				} else {
					openingBrackets.offer(before); // 확인한 괄호가 짝이 아니면 다시 여는괄호 문자열의 제일 뒤에 넣어주자
				}
				
				if (newIdx + 1 == opBSize) { // 마지막 인덱스에서 이 if문까지 왔다면 끝까지 짝인 괄호를 발견하지 못한 것
					return 0; // 짝이 맞을 수가 없으니 0 반환하고 method 종료
				}
			}
		}
		
		if (!openingBrackets.isEmpty()) // 괄호문자열 길이만큼 다 확인했는데 여는 괄호 큐가 남았으면 짝 안맞는거니까
			return 0; // 0 반환
		
		return 1; // 위의 두 경우가 아니면 짝이 맞으니까 1 반환
		
	}

}
