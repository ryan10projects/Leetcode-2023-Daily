// 228. Summary Ranges
// 2 pointer approach 
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> l = new LinkedList<>();
        if(nums.length==0) return new LinkedList<>();
        if(nums.length==1){
            l.add(""+nums[0]);
            return l;
        }
        int i=0, j=0;
        while(i<nums.length && j<nums.length){
            if(j<nums.length-1 && nums[j]+1==nums[j+1]){
                j++;
            }
            else{
                String s;
                if(i==j){
                  s = nums[i]+"";
                }
                else{
                s = nums[i]+"->"+nums[j];
                }
                l.add(s);
               
                i=j+1;
                j++;
            }
          
        }
          return l;
      }
   }
                
            
            
           
        


    
