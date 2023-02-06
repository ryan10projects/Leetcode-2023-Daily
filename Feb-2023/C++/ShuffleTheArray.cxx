/*Maintain two pointers so you can update the entire array in a single iteration
*/
// 1470. Shuffle the Array
class Solution {
public:
    vector<int> shuffle(vector<int>& nums, int n) {
        vector<int> arr;
        int j=0;
        for(int i=0; i<n; i++){
            arr.push_back(nums[i]);
            j++;
            arr.push_back(nums[i+n]);
            j++;
            
        }
        return arr;
    }
};
