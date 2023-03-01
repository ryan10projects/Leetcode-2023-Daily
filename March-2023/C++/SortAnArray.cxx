// 912. Sort an Array
// Counting sort, get the min and Max range and keep checking if element exists in map
class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        unordered_map<int,int> map;
        for(int &n: nums){
            map[n]++;
        }
        // get minimum and maximum 
        int mini = *min_element(nums.begin(),nums.end());
        int maxi = *max_element(nums.begin(),nums.end());
        int j=0;
        for(int i=mini; i<=maxi; i++){
           // To handle duplicates
            while(map[i]>0){
                nums[j]=i;
                j++;
                map[i]--;
                
            }
        }
        return nums;
    }
};
