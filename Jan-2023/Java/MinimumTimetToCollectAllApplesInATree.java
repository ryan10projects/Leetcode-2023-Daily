// 1443. Minimum Time to Collect All Apples in a Tree
class Solution
{
  public
	int dfs(HashMap<Integer, List<Integer>> map, int curr, int parent, List<Boolean> hasApple)
	{
		int time = 0;
		List<Integer> children = map.get(curr);
		for (int node : children)
		{
			if (node == parent)
			{
			    //infinite self loop without this condition
			    //map[0:[0,1,2,3]]
			    //0->0
				continue;
			}
			//pass the child and the previous child will be the new parent
			int totaltime = dfs(map, node, curr, hasApple);
	    	//if child has apple
				if (totaltime > 0 || hasApple.get(node))
					//if totaltime>0, children have apple too
			{
				//2 for 1 for going and 1 for returning
				time += 2 + totaltime;
			}
		}
		return time;
	}

  public
	int minTime(int n, int[][] edges, List<Boolean> hasApple)
	{
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		//parent as key and list of children
		for (int[] i : edges)
		{
			int parent = i[0];
			int child = i[1];
			if (!map.containsKey(parent))
			{
				map.put(parent, new ArrayList<>());
			}
			if (!map.containsKey(child))
			{
				map.put(child, new ArrayList<>());
			}
			map.get(parent).add(child);
			map.get(child).add(parent);
		}
		return dfs(map, 0, -1, hasApple);
	}
}
