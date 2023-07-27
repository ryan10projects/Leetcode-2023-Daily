class Solution {
    long result = 0;
    public boolean solve(int[] batteries, long mid, int n){
        // if the minutes of each computer is greater than the sum of all n computers, we have one possible answer
        // here the total_mins to run all computers is gathered, as long as its running all computers, we increase minutes
        long total_mins = n*mid;
        long target = 0;
        for(int i=0; i<batteries.length; i++){
            // fetch the minimum minutes
            // take smaller batteries first so we can replace with bigger batteries later
           target += Math.min((long)batteries[i], mid);
                
            
            if(target>=total_mins){
                return true;
            }
        }
        return false;
    }
    public long maxRunTime(int n, int[] batteries) {
        long left = 0, right = 0, sum = 0;
        
        for(int i=0; i<batteries.length; i++){
            left = Math.min(left, batteries[i]);
            sum += batteries[i];
        }
        // each computer needs atleast x number of mins, so we divide by sum, and the get the maximum mins range
        right = sum/n;
        
        while(left<=right){
            long mid = left + (right-left)/2;
            if(solve(batteries, mid, n)){
                result = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
            
        }
        return result;
    }
}
