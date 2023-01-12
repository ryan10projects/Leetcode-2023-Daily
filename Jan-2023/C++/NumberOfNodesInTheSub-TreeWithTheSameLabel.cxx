//Same solution worked in java but passed 57/59 test cases for this one due to time limit exceeded error
//1519. Number of Nodes in the Sub-Tree With the Same Label
class Solution {
public:
    static vector<int> dfs(vector<vector<int>>& map, int child, int parent,vector<int>&count, string labels){
        vector<int> res(26,0);
        //record the parent's label
        res[labels[child]-'a']++;
        for(auto &i: map[child]){
            //dont reiterate to the parent again
            if(i==parent) continue;
            //get the child's' labels
            vector<int> sub_res(26,0);
            sub_res=dfs(map,i,child,count,labels);
            for(int j=0;j<26;j++){
            		//if a child has a label add it to parent
				//if a is twice it will be 2 in parent_res after adding
            res[j]+=sub_res[j];
            }
        }
        	//add it to the array to be returned and next recursion initialize parent_res again
        count[child]=res[labels[child]-'a'];
        return res;
    }
                     
    vector<int> countSubTrees(int n, vector<vector<int>>& edges, string labels) {
        vector<vector<int>> map(n);
        for(auto&i: edges){
            int u = i[0];
            int v = i[1];
            map[u].push_back(v);
            map[v].push_back(u);
        }
        vector<int> count(n,0);
        dfs(map,0,-1,count,labels);
        return count;
    }
};
