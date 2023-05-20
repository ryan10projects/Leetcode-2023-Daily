// 399. Evaluate Division
// algorithm
// map a/b and b/a value to a hashmap
// using dfs find the parent a->b->c val and keep multiplying it to find the value of the query, transivity property 
// a/b = 2
// b/a = 1/2
// b/c = 3
// b/c = 1/3
// a/c = (a/b = b/c) then 2*3=6
class Pair {
	String first;
	Double second;
	Pair(String s, Double v) {
		this.first = s;
		this.second = v;
	}
}

class Solution {

	public void dfs(Map<String, List<Pair>> adj, String src, String des, Set<String> visited, double product, double[] ans) {
		if (visited.contains(src)) return;
		visited.add(src);
		if (src.equals(des)) {
			ans[0] = product;
			return;
		}

		List<Pair> nei = adj.get(src);
		if (nei != null) {
			for (Pair p : nei) {
				String s = p.first;
				double val = p.second;
				dfs(adj, s, des, visited, product * val, ans);
			}
		}
	}

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		Map<String, List<Pair>> adj = new HashMap<>();
		for (int i = 0; i < equations.size(); i++) {
			String u = equations.get(i).get(0);
			String v = equations.get(i).get(1);
			Double val = values[i];
			adj.computeIfAbsent(u, k-> new LinkedList<>()).add(new Pair(v, val));
			adj.computeIfAbsent(v, k->new LinkedList<>()).add(new Pair(u, 1.0 / val));
		}
		double[] result = new double[queries.size()];
		int i = 0;
		for (List<String> ls : queries) {

			double product = 1.0;
			double[] ans = new double[1];
			ans[0] = -1;
			String src = ls.get(0);
			String des = ls.get(1);
			Set<String> visited = new HashSet<>();
			if (adj.containsKey(src)) {
				dfs(adj, src, des, visited, product, ans);
			}
			result[i] = ans[0];
			i++;

		}

		return result;
	}
}
