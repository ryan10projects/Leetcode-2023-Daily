class Solution {
    public int longestSubsequence(int[] arr, int difference) {
       Map<Integer,Integer> map = new HashMap<>();
        int result = 0;
        for(int i=0; i<arr.length; i++){
            int prev = arr[i]-difference;
               
                int subLen = map.getOrDefault(prev,0);
              
                result = Math.max(result, subLen+1);
            
            map.put(arr[i],subLen+1);
            
        }
        return result;
    }
}
