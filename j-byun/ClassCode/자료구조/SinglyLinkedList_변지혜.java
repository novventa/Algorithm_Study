
public class SinglyLinkedList_변지혜 {

	class Node {
		int data;
		Node next;

		public Node(int data) {
			super();
			this.data = data;
			this.next = null;
		}
	}

	public Node head;

	public SinglyLinkedList_변지혜() {
		super();
	}

	// 가장 마지막에 추가 : addToEnd
	public void addToEnd(int data) {
		Node n = new Node(data);

		if (head == null) {
			head = n;

		} else {
			Node curr = head;

			while (curr.next != null) {
				curr = curr.next;
			}

			curr.next = n;
		}
	}

	// 가장 처음에 추가 : addToStart
	public void addToStart(int data) {
		Node n = new Node(data);

		n.next = head;
		head = n;
	}

	// 특정 값을 갖는 노드를 반환: getNode
	public Node getNode(int target) {
		Node curr = head;

		while (curr != null) {
			if (curr.data == target) {
				return curr;
			}
			curr = curr.next;
		}
		
		System.out.println("찾는 노드가 존재하지 않습니다.");
		return null;
	}

	// 특정 값을 갖는 노드 다음에 추가: addAfter
	public void addAfter(int target, int data) {
		Node targetNode = getNode(target);

		if (targetNode != null) {
			Node n = new Node(data);
			n.next = targetNode.next;
			targetNode.next = n;
		}
	}

	// 가장 마지막에 있는 노드 삭제: deleteLast
	public void deleteLast() {
		if (head != null) {
			Node curr = head;

			while (curr.next != null) {
				curr = curr.next;
			}

			curr = null;
			return;
		}

		System.out.println("리스트가 비어있습니다.");
		return;
	}

	// 가장 처음에 있는 노드 삭제: deleteStart
	public void deleteStart() {
		if (head != null) {
			head = head.next;
			return;
		}

		System.out.println("리스트가 비어있습니다.");
		return;
	}

	// 특정 값을 갖는 노드 다음 노드 삭제: deleteAfter
	public void deleteAfter(int data) {
		if (head != null) {
			Node pre = getNode(data);
			Node target = pre.next;

			if (target == null)
				return;

			pre.next = target.next;
		}
		System.out.println("리스트가 비어있습니다.");
		return;
	}

	// 리스트를 순회해서 출력: printList
	public void printList() {
		Node curr = head;
		System.out.print("LinkedList [head: ");

		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}

		System.out.println("]");
	}

}
