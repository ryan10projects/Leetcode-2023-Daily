// Scramble Strings
// Algorithm
// check if swapped letters or non scrambles are equal if yes return true
// hashmap for memoization
class Solution {
    public boolean solve(String s1, String s2,HashMap<String,Boolean>map){
        String k = s1+"."+s2;
        if(map.containsKey(k)) return map.get(k);
        
        if(s1.equals(s2)) return true;
        
        if(s1.length()!=s2.length()) return false;
        
        boolean result = false;
        // 1 otherwise string will be empty
        for(int i=1; i<s1.length(); i++){
            boolean swapped = solve(s1.substring(0,i),s2.substring(s1.length()-i),map) && solve(s1.substring(i),s2.substring(0,s1.length()-i),map);
                  
            boolean notswapped = solve(s1.substring(0,i),s2.substring(0,i),map) && solve(s1.substring(i,s1.length()),s2.substring(i,s1.length()),map);
            if(swapped==true || notswapped==true){
                result=true; 
                break;
            }
        }
        map.put(k,result);        
        return result;        
    }
    public boolean isScramble(String s1, String s2) {
        HashMap<String, Boolean> map = new HashMap<>();
        return solve(s1,s2,map);
    }
}
