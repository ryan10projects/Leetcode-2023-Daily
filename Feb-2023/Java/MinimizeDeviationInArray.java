// 1675. Minimize Deviation in Array
class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
       // Take care of all odd conditions by multiplying all odd to even
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2==1) nums[i]*=2;
            set.add(nums[i]); 
        }
        //treeSet to get the elements in logn average complexity
        //Elements in treeset are unique and sorted
        int diff=Integer.MAX_VALUE;
        while(true){
            //First element is the smallest because it is sorted, get the maximum value by using set.last() method
            int small = set.first();
            int large = set.last();
            diff = Math.min(diff,large-small);
            //The set still can an even number which is the largest that can be divided 
            if(large%2==0){
                set.remove(large);
                set.add(large/2);
            }
            else{
                return diff;
            }
            
        }
      
    }
}
