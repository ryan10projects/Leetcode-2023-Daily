// 1539. Kth Missing Positive Number
class Solution {
public:
    int findKthPositive(vector<int>& arr, int k) {
        int left = 0;
        int right = arr.size()-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            // example
            // 2,5,6,7
            // 1,2,3,4
            // let us pick 7
            // 7-4 = 3 
            //there are 3 missing numbers before 7
            //mid+1 due to 0 based indexing
            int num = arr[mid]-(mid+1);
            // we need to get find missing numbers equal to k 
            // you found more missing numbers than k, so we look to the left
            if(num>=k){
                right=mid-1;
            }
            // you found less missing numbers so look through the right
            else if(num<=k){
                left=mid+1;
            }
        }
        return left+k;
    }
};
