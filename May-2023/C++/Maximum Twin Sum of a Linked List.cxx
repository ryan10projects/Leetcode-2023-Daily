class Solution {
public:
    int pairSum(ListNode* head) {
        vector<int> vec;
        
        while(head) {
            vec.push_back(head->val);
            head = head->next;
        }
        
        int i = 0, j = vec.size()-1;
        int result = 0;
        
        while(i < j) {
            result = max(result, vec[i] + vec[j]);
            i++;
            j--;
        }
        
        return result;
    }
};
