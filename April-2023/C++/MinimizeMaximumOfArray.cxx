// Minimize Maximum of Array
// Equally distribute all values
// +1 to not divide by 0
// Fetch average of every running sum and return the maximum
class Solution {
public:
    int minimizeArrayValue(vector<int>& nums) {
        long res=0;
        long sum=0;
        for(int i=0; i<nums.size(); i++){
            sum+=nums[i];
            res=max(res,(sum+i)/(i+1));
            
        }
        return res;
    }
};
