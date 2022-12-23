package WeeklyContest324;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DegreeNodesEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPossible(int n, List<List<Integer>> edges) {

		/*
		 * boolean graph[][]=new boolean[n+1][n+1]; for(List<Integer> edge:edges){
		 * graph[edge.get(0)][edge.get(1)]=true; graph[edge.get(1)][edge.get(0)]=true; }
		 */
		HashMap<Integer, Set<Integer>> graph = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			graph.put(i, new HashSet<Integer>());
		}

		for (List<Integer> edge : edges) {
			graph.get(edge.get(0)).add(edge.get(1));
			graph.get(edge.get(1)).add(edge.get(0));

		}
		List<Integer> oddNode = new ArrayList<>();
		int odd = 0;
		int deg = 0;
		for (int i = 1; i <= n; i++) {
			int size = graph.get(i).size();
			if (size % 2 == 1) {
				odd++;
				oddNode.add(i);
			}
		}

		if (odd == 0) {
			return true;
		} else if (odd == 2) {
			int odd1 = oddNode.get(0);
			int odd2 = oddNode.get(1);
			for (int i = 1; i <= n; i++) {
				/*
				 * if (!graph[odd1][i] && !graph[odd2][i]) { return true; }
				 */
				if (!graph.get(odd1).contains(i) && !graph.get(odd2).contains(i)) {
					return true;
				}
			}
			return false;
		} else if (odd == 4) {
			int odd1 = oddNode.get(0);
			int odd2 = oddNode.get(1);
			int odd3 = oddNode.get(2);
			int odd4 = oddNode.get(3);

			/*
			 * if ((!graph[odd1][odd2] && !graph[odd3][odd4]) || (!graph[odd1][odd3] &&
			 * !graph[odd2][odd4]) || (!graph[odd1][odd4] && !graph[odd2][odd3])) { return
			 * true; }
			 */

			if ((!graph.get(odd1).contains(odd2) && !graph.get(odd3).contains(odd4))
					|| (!graph.get(odd1).contains(odd3) && !graph.get(odd2).contains(odd4))
					|| (!graph.get(odd1).contains(odd4) && !graph.get(odd2).contains(odd3))) {
				return true;
			}
			return false;
		} else {
			return false;
		}
	}

}
