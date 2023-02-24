
// 1675. Minimize Deviation in Array
class Solution {
public:
    int minimumDeviation(vector<int>& nums) {
        set<int> set;
        // Take care of all odd conditions by multiplying all odd to even
        for(int i = 0; i < nums.size(); i++) {
            if(nums[i] % 2 == 1) nums[i] *= 2;
            set.insert(nums[i]);
        }
        // set to get the elements in logn average complexity
        // Elements in set are unique and sorted
        int diff = INT_MAX;
        while(true) {
            // First element is the smallest because it is sorted, get the maximum value by using set.rbegin() method
            int small = *set.begin();
            int large = *set.rbegin();
            diff = min(diff, large - small);
            // The set still has an even number which is the largest that can be divided
            if(large % 2 == 0) {
                set.erase(large);
                set.insert(large / 2);
            } else {
                return diff;
            }
        }
    }
};
