// 382. Linked List Random Node
class Solution {
public:
    vector<int> arr;
    Solution(ListNode* head) {
        while(head!=nullptr) {
            arr.push_back(head->val);
            head = head->next;
        }
    }
    // % will always ensure that the rand number is wtihin the arr.size(). Unlike 0.0 to 1.0 doube in java, rand generates a larger positive value
    int getRandom() {
        return arr[rand() % arr.size()];
    }
};
