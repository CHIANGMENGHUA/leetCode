package heap;

import java.util.PriorityQueue;

class ListNode {
	
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		ListNode current = this;
		
		while (current != null) {
			sb.append(current.val);
			if (current.next != null) {
				sb.append(" -> ");
			}
			current = current.next;
		}
		
		return sb.toString();
	}
}

public class MergeKSortedLists {

	public static ListNode mergeKLists(ListNode[] lists) {

		PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

		for (ListNode i : lists) {
			if (i != null) {
				minHeap.offer(i);
			}
		}

		ListNode result = new ListNode(0);
		ListNode currentNode = result;

		while (!minHeap.isEmpty()) {
			ListNode top = minHeap.poll();
			currentNode.next = top;
			currentNode = currentNode.next;

			if (top.next != null) {
				minHeap.offer(top.next);
			}
		}

		return result.next;
	}

	public static void main(String[] args) {
		
		ListNode[] lists = new ListNode[3];
		
		lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
		lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
		lists[2] = new ListNode(2, new ListNode(6));

		System.out.println(mergeKLists(lists));
	}
}
