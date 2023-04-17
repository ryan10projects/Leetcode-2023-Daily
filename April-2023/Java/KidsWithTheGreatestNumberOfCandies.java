// 1431. Kids With the Greatest Number of Candies
// get max and compare with max
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> l = new LinkedList<>();
        int max=0;
        for(int n: candies){            
                max=Math.max(max,n);                            
            }
        int i;
        for(i=0;i<candies.length;i++){
       if(candies[i]+extraCandies>=max){
                l.add(true);                              
                }
            else{
                l.add(false);
                }            
            }
        return l;
    }
}
