// Optimal Partition of String
// hash set to keep track of distinct elements
class Solution {
public:
    int partitionString(string s) {
        unordered_set<char> set;
        int count = 1;
        
        for(int i = 0; i < s.length(); i++) {
            if(set.count(s[i])) {
                count++;
                set.clear();
                set.insert(s[i]);
            } else {
                set.insert(s[i]);
            }
        }
        
        return count;
    }
};
