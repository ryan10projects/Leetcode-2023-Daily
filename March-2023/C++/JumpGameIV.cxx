// 1345. Jump Game IV

class Solution {

public:

    int minJumps(vector<int>& arr) {

        int n = arr.size();      

        unordered_map<int,vector<int>> map(n);  

        // store indexes as values

        for(int i=0; i<n; i++){

            map[arr[i]].push_back(i);

        }

        int steps=0;

        queue<int> q;

        vector<bool> visited(n,false);

        q.push(0);

        visited[0]=true;

        while(!q.empty()){

            int size = q.size();

            while(size-->0){

                int curr = q.front();

                q.pop();

                // first jump condition 

                int left = curr-1;

                // second jump condition

                int right = curr+1;

                if(curr==n-1) return steps;

                //check boundaries and add

                if(left>=0 && !visited[left]){

                    q.push(left);

                    visited[left]=true;

               }

               //check boundaries and add

                if(right<=n-1 && !visited[right]){

                    q.push(right);

                    visited[right]=true;

                 }

                //third jump condition 

                for(int &ind: map[arr[curr]]){

                   if(!visited[ind]){

                       q.push(ind);

                       visited[ind]=true;

                    } 

               }

               // no need to traverse again, timeout error without it

                map.erase(arr[curr]);           

            }

        steps++;

        }

        return -1;

        

    }

};
