import java.util.HashMap;
import java.util.Scanner;

// 1231 중위순회
// D4

// 문제
// 주어진 트리를 in-order 형식으로 순회해 각 노드를 읽어와서 특정 단어를 출력하자

// 조건
// 트리는 완전 이진 트리 형식
// 노드 당 하나의 문자만 저장할 수 있다
// 노드는 레벨0부터 차례대로 주어진다
// 루트 정점의 번호는 항상 1

// 트리가 갖는 정점의 총 수 N(1≤N≤100)

// 풀이
// 배열에 노드 정보를 저장하자
// [노드 개수]*[2] 크기의 배열에 트리 정보를 저장하자
// 배열의 [노드번호]는 {왼쪽 자식 노드의 인덱스, 오른쪽 자식 노드의 인덱스} 로 구성된다

// 각 노드의 데이터를 저장할 hashMap 공간을 만들어서
// 노드의 인덱스를 key, 해당 노드의 데이터(문자)를 value로 받아서 입력하자

public class SWEA_1231_중위순회_변지혜 {
	static StringBuilder sb = new StringBuilder();
	
	static int nodeCnt;
	static int[][] tree;
	static HashMap<Integer, Character> node;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) { // 테스트케이스 10개만큼 반복 실행
			sb.append("#").append(tc).append(" "); // 출력 양식
			
			nodeCnt = sc.nextInt(); // 노드의 개수 입력받기
			
			tree = new int[nodeCnt + 1][2]; // 노드인덱스, 왼쪽 자식, 오른쪽 자식 정보를 저장할 트리 배열 초기화
			
			node = new HashMap<>(); // 노드 데이터(문자)를 저장할 hashMap 초기화
			
			for (int cnt = 0; cnt < nodeCnt; cnt++) { // 각 노드에 정보 입력받기
				int idx = sc.nextInt(); // 노드 번호
				char data = sc.next().charAt(0); // 노드 데이터(문자)
				
				if (idx * 2 <= nodeCnt) { // 왼쪽 자식 노드가 존재하면...
					int leftChildIdx = sc.nextInt(); // 왼쪽 자식 노드의 번호
					tree[idx][0] = leftChildIdx; // tree의 0번 인덱스에 왼쪽 자식 인덱스 번호 저장
				}
				
				if (idx * 2 + 1 <= nodeCnt) { // 오른쪽 자식 노드가 존재하면...
					int rightChildIdx = sc.nextInt(); // 오른쪽 자식 노드의 번호
					tree[idx][1] = rightChildIdx; // tree의 1번 인덱스에 오른쪽 자식 인덱스 번호 저장
				}
				
				node.put(idx, data); // hashMap에 현재 노드의 인덱스 번호를 key, 해당 노드의 데이터(문자)를 value로 저장
			}
			
			inorder_traverse(1); // 루트인 1번 노드부터 중위순회를 시작하자
			
			sb.append("\n"); // 테케 하나 끝날 때 마다 개행
		}
		
		System.out.println(sb); // 출력
	}
	
	private static void inorder_traverse(int i) {
		if (i <= nodeCnt && i != 0) { // 트리의 범위 안에 있다면...
			inorder_traverse(tree[i][0]); // L : 왼쪽 트리로 탐색을 이어나감
			
			if (node.get(i) != '\u0000') // V : 자기 자신을 출력
				sb.append(node.get(i));
			
			inorder_traverse(tree[i][1]); // R : 오른쪽 트리로 탐색을 이어나감
		}
	}
	
}
