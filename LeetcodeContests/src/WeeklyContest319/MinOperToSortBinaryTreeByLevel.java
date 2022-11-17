package WeeklyContest319;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MinOperToSortBinaryTreeByLevel {

	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public int minimumOperations(TreeNode root) {

		Queue<TreeNode> q = new LinkedList();

		q.offer(root);
		int count = 0;
		while (!q.isEmpty()) {

			int size = q.size();
			int[] arr = new int[size];
			int c = 0;
			for (int i = 0; i < size; i++) {
				TreeNode cur = q.poll();
				arr[c++] = cur.val;
				if (cur.left != null) {
					q.offer(cur.left);

				}
				if (cur.right != null) {
					q.offer(cur.right);
				}
			}

			count += minSwaps(arr);
		}
		return count;
	}

	public int minSwaps(int[] nums) {
		int len = nums.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++)
			map.put(nums[i], i);

		Arrays.sort(nums);

		// To keep track of visited elements. Initialize
		// all elements as not visited or false.
		boolean[] visited = new boolean[len];
		Arrays.fill(visited, false);

		// Initialize result
		int ans = 0;
		for (int i = 0; i < len; i++) {

			// already swapped and corrected or
			// already present at correct pos
			if (visited[i] || map.get(nums[i]) == i)
				continue;

			int j = i, cycle_size = 0;
			while (!visited[j]) {
				visited[j] = true;

				// move to next node
				j = map.get(nums[j]);
				cycle_size++;
			}

			// Update answer by adding current cycle.
			if (cycle_size > 0) {
				ans += (cycle_size - 1);
			}
		}
		return ans;
	}

}
