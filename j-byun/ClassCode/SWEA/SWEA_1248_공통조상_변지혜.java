import java.util.LinkedList;
import java.util.Scanner;

// 1248 공통조상
// D5

// 문제
// 이진 트리에서 임의의 두 정점의 가장 가까운 공통 조상을 찾고,
// 그 정점을 루트로 하는 서브트리의 크기를 알아내는 프로그램을 작성하라

// 조건
// 정점의 개수 V(10 ≤ V ≤ 10000)
// 간선은 항상 “부모 자식” 순서로 표기된다

// 풀이
// [정점의 개수]*[3] 크기의 배열을 만들어서...
// 0번 인덱스에는 부모 노드 입력
// 1번 인덱스에는 왼쪽 자식 노드 입력
// 1번인덱스가 != 0이 아니라면...
// 2번 인덱스에 오른쪽 자식 노드 입력

// 간선개수만큼 입력이 끝났다면...

// 한 점의 부모노드가 0이 아닐 때 까지 타고 올라가면서 연결리스트에 저장하기
// 다른 한 점의 부모노드를 타고 올라가면서...
// 이전 점의 부모노드가 저장된 연결리스트에 같은 부모가 있는지 확인
// 	=> 같은 부모가 발견되면 걔가 가장 가까운 공통 조상이다! break;
// 그럼 공통조상 번호부터 탐색 시작해서 노드 개수 카운트++하기

public class SWEA_1248_공통조상_변지혜 {
	
	static int nodeCnt;
	static int[][] tree;
	static int subTreeCnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int testCase = sc.nextInt(); // 테스트케이스 개수 입력받기
		
		for (int tc = 1; tc <= testCase; tc++) { // 테스트케이스 개수만큼 반복
			sb.append("#").append(tc).append(" "); // 출력 양식
			
			nodeCnt = sc.nextInt(); // 정점의 개수 V 입력받기
			
			tree = new int[nodeCnt + 1][3]; // 각 노드의 부모노드, 왼쪽 자식 노드, 오른쪽 자식 노드 정보를 저장할 트리 배열
			
			int edgeCnt = sc.nextInt(); // 간선의 개수 E 입력받기 (V - 1)
			
			int firstNode = sc.nextInt(); // 공통 조상을 찾는 두 개의 정점 번호 입력받기
			int secondNode = sc.nextInt();
			
			int parent;
			int child;
			
			for (int cnt = 0; cnt < edgeCnt; cnt++) { // E개의 간선 정보 입력받기
				parent = sc.nextInt(); // 부모 노드 번호
				child = sc.nextInt(); // 자식 노드 번호
				
				if (tree[parent][1] == 0) { // 왼쪽 자식 노드가 비어있으면 왼쪽 먼저 채워주기
					tree[parent][1] = child;
					
				} else { // 왼쪽 자식 노드가 이미 차있으면 오른쪽 자식 노드에 넣어주기
					tree[parent][2] = child;
				}
				
				tree[child][0] = parent; // 자식노드에게도 부모 노드 번호 알려주기
			}
			
			
			LinkedList<Integer> firstNodesParents = new LinkedList<>(); // 한 정점의 부모 노드들을 저장할 연결 리스트
			parent = tree[firstNode][0]; // 한 정점의 부모 노드
			
			while(parent != 0) { // root부모 노드까지 찾아서 연결 리스트에 저장하기
				firstNodesParents.add(parent);
				parent = tree[parent][0];
			}
			
			int commonParent = 0; // 두 정점의 가장 가까운 조상을 저장할 공간
			parent = tree[secondNode][0]; // 두 번째 정점의 부모 노드
			
			while (parent != 0) { // root부모 노드까지 찾아가면서
				if(firstNodesParents.contains(parent)) { // 내 조상이 첫 번째 노드의 조상에 있는 애면
					commonParent = parent; // 걔가 가장 가까운 공통 조상이다
					break; // 탐색 끝
				}
				parent = tree[parent][0]; // 내 조상이 첫 번째 노드의 조상에 없으면 또 다음 조상 찾으러 가자
			}
			
			// 공통 조상을 찾았으니...
			// 공통 조상부터 tree를 탐색하면서 서브트리의 개수를 세자
			subTreeCnt = 0;
			
			preorder_traverse(commonParent); // 전위순회
			
			sb.append(commonParent).append(" ").append(subTreeCnt).append("\n"); // 공통 조상의 노드 번호와 서브트리의 크기 출력
		}
		
		System.out.println(sb); // 출력
	}

	private static void preorder_traverse(int i) { // 전위 순회
		if (i <= nodeCnt && i != 0) { // V
			subTreeCnt++; // 노드 개수 +1 해주자
			
			preorder_traverse(tree[i][1]); // L
			
			preorder_traverse(tree[i][2]); // R
		}
	}
	
}
