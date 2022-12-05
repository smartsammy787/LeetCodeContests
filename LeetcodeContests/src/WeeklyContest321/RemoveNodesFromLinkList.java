package WeeklyContest321;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveNodesFromLinkList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode removeNodes(ListNode head) {

		List<Integer> list = new ArrayList();
		ListNode node = head;
		while (node != null) {
			list.add(node.val);
			node = node.next;
		}

		Stack<Integer> stack = new Stack<>();
		int i = 0;
		while (i < list.size()) {
			while (!stack.isEmpty() && stack.peek() < list.get(i)) {
				stack.pop();
			}
			stack.push(list.get(i));
			i++;
		}

		List<Integer> ans = new ArrayList();

		while (!stack.isEmpty()) {
			ans.add(stack.pop());
		}
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		for (int j = ans.size() - 1; j >= 0; j--) {
			cur.next = new ListNode(ans.get(j));
			cur = cur.next;
		}
		return dummy.next;

	}
}
