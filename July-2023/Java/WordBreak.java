class Solution {
    Boolean[] dp = new Boolean[301];
    public boolean solve(int index, HashMap<String,Integer> map, String s){
        if(index==s.length()) return true;
       
        if(dp[index]!=null) return dp[index];
        
        for(int i=index+1; i<=s.length(); i++){
            if(map.containsKey(s.substring(index,i)) && solve(i, map, s)){
                return dp[index]=true;
            }
        }
        return dp[index]=false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<wordDict.size(); i++) map.put(wordDict.get(i),i);
        return solve(0,map,s);
    }
}
