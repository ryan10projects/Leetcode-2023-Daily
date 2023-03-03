// 912. Sort an Array
// Counting Sort
class Solution {
    public int[] sortArray(int[] nums) {
      HashMap<Integer,Integer> map = new HashMap<>();
      for(int i=0; i<nums.length; i++){
          map.put(nums[i],map.getOrDefault(nums[i],0)+1);
          
       }
        // get min and Max to use as range in counting sort
        int mini = Arrays.stream(nums).min().getAsInt();
        int maxi = Arrays.stream(nums).max().getAsInt();
        int j=0;
        for(int i=mini; i<=maxi; i++){
            
            while(map.containsKey(i) && map.get(i)>0){
                // Reduce count of duplicates
                map.put(i,map.get(i)-1);
                nums[j]=i;
                j++;
            }
            
        }
        return nums;
    }
}
