class Solution
{
  public:
	int dfs(unordered_map<int, vector<int>> &map, int curr, int parent, vector<bool> &hasApple)
	{
		int time = 0;
		for (int &child : map[curr])
		{
			if (child == parent)
			{
				//infinite self loop without this condition
				continue;
			}
			//pass the child and the previous child will be the new parent
		  
			int totaltime = dfs(map, child, curr, hasApple);
			//child has apple
			if (totaltime > 0 || hasApple[child])
			//if totaltime>0, children have apple too
			{
				//2 for 1 for going and 1 for returning
				time += 2 + totaltime;
			}
		}
		return time;
	}
	int minTime(int n, vector<vector<int>> &edges, vector<bool> &hasApple)
	{
		unordered_map<int, vector<int>> map;
		//parent as key and list of children
		for (auto &i : edges)
		{
			int parent = i[0];
			int child = i[1];
			map[parent].push_back(child);
			map[child].push_back(parent);
		}
		return dfs(map, 0, -1, hasApple);
	}
};
