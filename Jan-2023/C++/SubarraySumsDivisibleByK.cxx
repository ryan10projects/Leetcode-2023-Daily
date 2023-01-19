/* Subarray Sums Divisible by K

Algorithm

Step 1: Get cumulative sum

Step 2: fetch remainder

Step 3: Check if remainder is in HashMap

Step 4: Add the count of remainder in HashMap

Step 5: Return Count

If remainder less than 0, add the divisor

*/ 

class Solution {

public:

    int subarraysDivByK(vector<int>& nums, int k) {

        unordered_map<int,int> map;

        map[0]=1;

        int cumulative_sum=0;

        int count=0;

        for(int i=0; i<nums.size(); i++){

            cumulative_sum+=nums[i];

            int remainder = cumulative_sum%k;

            if(remainder<0) remainder+=k;

            if(map.count(remainder)){

                count+=map[remainder];

            }

            map[remainder]++;

        }

        return count;

    }

}; 


