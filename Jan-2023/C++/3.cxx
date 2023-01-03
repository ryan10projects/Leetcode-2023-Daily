//944. Delete Columns to Make Sorted
class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        int count = 0;
        /*[[a, l, p],[b, m, q]]
        in the above example compare if a>b, if it is greater then increment count */
        for(int i=0;i <strs.size();i++){
            for(int j=1; j<strs[0].size();j++){
                if(strs[j][i]>strs[j-1][i]){
                    count++;
                }
            }
        }
        return count;
    }
};
