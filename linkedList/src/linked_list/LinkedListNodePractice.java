package linked_list;

public class LinkedListNodePractice {

	public static void main(String[] args) {

		LinkedList linkedList = new LinkedList();

		linkedList.add(0);
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);

		linkedList.printList();
		System.out.println();

		linkedList.contain(2);
		System.out.println();

		linkedList.remove(2);

		linkedList.printList();
		System.out.println();

		linkedList.remove(2);
		
		linkedList.contain(2);
		linkedList.contain(3);
		System.out.println();
		
		linkedList.remove(0);
		linkedList.remove(1);
		linkedList.remove(3);
		linkedList.remove(4);
		linkedList.remove(5);
		
		linkedList.printList();
		System.out.println();
		
		linkedList.add(0);
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		linkedList.add(6);
		
		System.out.println(linkedList.findMiddle());
		System.out.println(linkedList.findLast_k_Node(3));
		System.out.println(linkedList.findLast_k_Node_2Pointer(3));
		System.out.println();
		
		linkedList.reverse();
		linkedList.printList();
	}
}

class Node {

	protected int data;
	protected Node next;
	protected Node previous;

	Node(int data) {
		this.data = data;
		this.next = null;
		this.previous = null;
	}
}

class LinkedList {

	private Node headNode;

	public void add(int data) {

		Node newNode = new Node(data);

		if (headNode == null) {
			headNode = newNode;
		} else {
			Node currentNode = headNode;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
			currentNode.next.previous = currentNode;
		}
	}

	public void remove(int data) {

		Node currentNode = headNode;

		if (headNode == null) return;

		if (headNode.data == data) {
			headNode = headNode.next;
			return;
		}

		while (currentNode.next != null && currentNode.next.data != data) {
			currentNode = currentNode.next;
		}

		if (currentNode.next != null) {
			currentNode.next = currentNode.next.next;
		} else {
			System.out.println("No element " + "\"" + data + "\"" + " in linked list.");
		}
	}

	public void printList() {

		Node currentNode = headNode;

		if (headNode == null) {
			System.out.println("null");
		}

		while (currentNode != null) {
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}
	}

	public void contain(int data) {

		Node currentNode = headNode;

		while (currentNode != null) {
			if (currentNode.data == data) {
				System.out.println(true);
				return;
			}
			currentNode = currentNode.next;
		}

		System.out.println(false);
	}
	
	public int findMiddle() {
		
		Node i = headNode;
		Node j = headNode;
		
		while (j != null && j.next != null) {
			i = i.next;
			j = j.next.next;
		}
		
		return i.data;
	}
	
	public int findLast_k_Node(int k) {
		
		Node currentNode = headNode;
		
		if (k < 1) {
			return -1;
		}
		
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		
		for (int i = 1; i < k; i++) {
			if (currentNode.previous == null) {
				return -1;
			}
			currentNode = currentNode.previous;
		}
		
		return currentNode.data;
	}
	
	public int findLast_k_Node_2Pointer(int k) {
		
		Node i = headNode;
		Node j = headNode;
		
		if (k < 1) {
			return -1;
		}
		
		for (int p = 1; p < k; p++) {
			if (j.next == null) {
				return -1;
			}
			j = j.next;
		}
		
		while (j.next != null) {
			i = i.next;
			j = j.next;
		}
		
		return i.data;
	}
	
    public Node reverse(Node currentNode) {
    	
        if (currentNode == null || currentNode.next == null) {
            if (currentNode != null) {
                currentNode.previous = null;
            }
            return currentNode;
        }
        
        Node newHead = reverse(currentNode.next);
        
        currentNode.next.next = currentNode;
        currentNode.previous = currentNode.next;
        currentNode.next = null;
        
        return newHead;
    }
	
    public void reverse() {
        headNode = reverse(headNode);
    }

}
