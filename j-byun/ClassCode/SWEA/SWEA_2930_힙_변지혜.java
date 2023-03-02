import java.util.Scanner;

// 2930 힙
// D3

// 문제
// 최대 힙을 구현하자
// 2가지 연산 수행
// 연산1. 자연수 x 삽입
// 연산2. 최대 힙의 루트 노드의 키 값을 출력하고, 해당 노드를 삭제

// 조건
// 가장 큰 키 값이 여러 개 일 때 같은 키 값의 노드 전부가 삭제되지 않고 루트노드만 삭제된다
// 연산의 수를 나타내는 자연수 N(1≤N≤10^5)

// 삭제 연산 구현 시, 자식 노드 2개가 존대한다면 둘 중 큰 키 값을 가지는 노드와 현재 노드의 위치를 바꿔준다
// 삭제 시, 힙이 비어있는지 먼저 확인하고 삭제해야한다

public class SWEA_2930_힙_변지혜 {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	
	static int[] tree;
	static int lastNode;
	
	public static void doInsert() { // 삽입 연산
		int value = sc.nextInt(); // 삽입할 값을 입력받아서
		tree[++lastNode] = value; // 제일 마지막 노드로 만들어서 tree에 추가해주고
		
		// 부모 노드와 비교하며 최대 힙 조건을 만족할 때 까지 자리 바꾸기
		int curIdx = lastNode;
		int parentIdx = curIdx / 2;
		
		while (curIdx > 1) {
			if (tree[curIdx] > tree[parentIdx]) { // 자식의 값이 더 크면 부모와 자리 바꾸기
				swap(curIdx, parentIdx);
				
				curIdx = parentIdx;
				parentIdx = curIdx / 2;
				
			} else { // 부모의 값이 더 크면 최대힙 조건 만족하니까 break
				break;
			}
			
		}
		
	}
	
	public static void doDelete() { // 삭제 연산
		if (lastNode == 0) { // tree가 비어있으면 -1 출력
			sb.append(-1).append(" ");
			
		} else { // tree에 삭제할 값이 있으면...
			sb.append(tree[1]).append(" "); // 루트 노드 출력하고
			swap(1, lastNode); // 마지막 노드를 root 노드 자리와 바꾸기
			tree[lastNode--] = 0; // 마지막 노드 삭제하고 노드 인덱스 --
			
			// 이제 최대 힙 조건을 만족하는지 확인하기
			int curIdx = 1;
			int childIdx = curIdx * 2;
			
			while (childIdx <= lastNode) {
//				if (2 * curIdx <= lastNode) { // 왼쪽 자식 노드가 존재하면
//					childIdx = 2 * curIdx; // 왼쪽 자식 노드 인덱스 번호 저장
//				}
//				
				if (childIdx + 1 <= lastNode && tree[childIdx + 1] > tree[childIdx]) { // 오른쪽 자식 노드가 존재하고 왼쪽 노드보다 오른쪽 노드의 값이 크다면
					childIdx += 1; // 오른쪽 자식 노드의 인덱스로 업데이트
				}
				
				// 자식과 부모 비교하기
				if (tree[curIdx] < tree[childIdx]) { // 자식이 더 큰 값이면
					swap(curIdx, childIdx); // 자식과 부모의 자리를 바꿔준다
					
					curIdx = childIdx;
					childIdx = curIdx * 2;
					
				} else { // 부모의 값이 더 크면 최대 힙 조건 만족하니까 break
					break;
				}
				
			}
			
		}
		
	}
	
	public static void swap(int a, int b) { // 두 값의 자리를 바꿔서 저장하는 method
		int tmp = tree[a];
		tree[a] = tree[b];
		tree[b] = tmp;
	}
	
	
	public static void main(String[] args) {
		
		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기
		
		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복 실행
			sb.append("#").append(tc).append(" "); // 출력 양식
			
			int nodeSize = sc.nextInt(); // 수행해야하는 연산 개수 입력받기
			
			tree = new int[nodeSize + 1]; // 연산개수까지의 인덱스 번호 공간을 확보한 트리 만들기
											// 연산이 다 삽입일 경우를 가정한 최대 공간 확보
			
			lastNode = 0; // 현재까지 저장된 노드 개수를 저장할 공간
			
			for (int cnt = 0; cnt < nodeSize; cnt++) { // 연산 수행
				int command = sc.nextInt(); // 명령어 입력받고
				
				if (command == 1) // 1번 명령어면 삽입 연산 수행
					doInsert();
				
				else if (command == 2) // 2번 명령어면 삭제 연산 수행
					doDelete();
			}
			
			sb.append("\n"); // 테스트케이스 끝날 때 마다 개행
		}
		
		sc.close(); // 스캐너 닫기
		System.out.println(sb); // 출력
	}

}

