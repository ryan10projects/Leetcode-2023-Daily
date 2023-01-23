// 997. Find the Town Judge

// Used only one array, if -1, he/she trust someone, so not a candidate for town judge

class Solution {

public:

    int findJudge(int n, vector<vector<int>>& trust) {

       vector<int> count(n+1);

       for(vector<int> i: trust){

           count[i[0]]=-1;

           count[i[1]]++;

        }

        for(int i=1;i<=n;i++){

            if(count[i]==n-1) return i;

         }

           

        return -1;

    }

};
