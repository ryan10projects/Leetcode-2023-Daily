// 946. Validate Stack Sequences
// Check if top of stack exists within popped array, if it does not keep pushing or pop from stack
class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        int j=0;
        stack<int> s;
        for(int i=0; i<pushed.size(); i++){
            s.push(pushed[i]);
            while(!s.empty() && s.top()==popped[j]){
                s.pop();
                j++;
            }          
        }
        return s.empty();
    }
};
