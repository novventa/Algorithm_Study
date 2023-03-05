import java.util.Scanner;

// 1232 사칙연산
// D4

// 문제
// 사칙연산 -> 이진트리로 표현
// 사칙연산 +-*/와 양의 정수로 구성된 이진트리의 계산 결과를 출력하는 프로그램을 작성하라

// 정점이 정수면 정점번호 양의 정수 입력
// 정점이 연산자이면 정점번호 연산자 해당 정점의 왼쪽 자식, 오른쪽 자식 번호 입력

// 조건
// 정점의 개수 N(1≤N≤1000)
// 루트 정점의 번호는 항상 1이다

// 풀이
// 일단 [n+1] * 3개의 배열에 다 입력 받고
// idx n부터 1까지 --해가면서 연산자면 찾아서 좌우 계산하기

// 연산자랑 숫자 따로 입력받기 귀찮으니까 String 배열에 다 받아서 뽑아낼 때 int로 변환

public class SWEA_1232_사칙연산_변지혜 {
	
	static int nodeCnt;
	static String[] node;
	static int[] left;
	static int[] right;
	
	public static int calculateTree(int i) { // 트리에 표현된 수식을 계산하는 method
		
		if (i <= nodeCnt) { // 해당 노드가 tree범위 내에 있을 때만 실행
			char operator = node[i].charAt(0);
			
			if (operator >= '*' && operator <= '/') { // 해당 노드가 연산자 노드라면
				int leftNode = calculateTree(left[i]); // 왼쪽 자식과 오른쪽 자식의 계산 값을 가져오고
				int rightNode = calculateTree(right[i]);
				
				if (operator == '+') { // 해당 노드의 연산자에 따라 연산한 결과를 반환
					return leftNode + rightNode;
					
				} else if (operator == '-') {
					return leftNode - rightNode;
					
				} else if (operator == '*') {
					return leftNode * rightNode;
					
				} else { // 나누기 연산자 일 때
					return leftNode / rightNode;
				}
				
			} else { // 정수 노드이면 해당 노드에 저장된 정수 반환
				return Integer.parseInt(node[i]);
			}
			
		}
		
		return 0;
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) { // 테스트케이스 10개만큼 반복 실행
			sb.append("#").append(tc).append(" "); // 출력 양식
			
			nodeCnt = sc.nextInt(); // 노드개수 입력받기
			
			node = new String[nodeCnt + 1]; // 해당 노드에 저장된 연산자/숫자 저장
			left = new int[nodeCnt + 1]; // 해당 노드의 왼쪽 자식 인덱스 번호 저장
			right = new int[nodeCnt + 1]; // 해당 노드의 오른쪽 자식 인덱스 번호 저장
			
			for (int idx = 1; idx <= nodeCnt; idx++) { // 노드 정보 입력받기
				int index = sc.nextInt(); // 노드 인덱스 번호
				String data = sc.next(); // 노드에 저장할 연산자/숫자
				
				node[index] = data; // 노드에 연산자/숫자 저장하기
				
				if (data.charAt(0) >= '*' && data.charAt(0) <= '/') { // 해당 노드가 연산자 노드이면
					left[index] = sc.nextInt(); // 양쪽 자식 노드의 인덱스 번호 입력받기
					right[index] = sc.nextInt();
				}
			}
			
			// 노드 정보 입력이 끝났으면 tree 계산
			// root node부터 타고 내려가면서 재귀 호출
			int result = calculateTree(1);
			
			sb.append(result).append("\n"); // 결과값 출력
			
		}
		
		System.out.println(sb);
	}


}

