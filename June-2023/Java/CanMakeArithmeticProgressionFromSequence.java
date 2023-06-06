// 1502. Can Make Arithmetic Progression From Sequence
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = 0;
        boolean isSet=false;
        for(int i=0; i<arr.length-1; i++){
            if(!isSet){
            diff = Math.abs(arr[i]-arr[i+1]);
            isSet=true;
            }
            
            if(isSet){
                if(diff!=Math.abs(arr[i]-arr[i+1])) return false;
            }
        }
        return true;
       
    }
}
