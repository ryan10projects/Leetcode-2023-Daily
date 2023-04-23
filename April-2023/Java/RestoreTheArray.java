// 1416. Restore The Array
class Solution {
    int[] memset;
    int mod = 1000000007;
    public int solve(int start,String s, int k){
        // constraint
        if(start>=s.length()) return 1;
        // check for leading 0
        if(s.charAt(start)=='0') return memset[start]=0;
        if(memset[start]!=-1) return memset[start];
        long num = 0;
        long ans = 0;
        // divide the string into subparts and compare if each string is less than k
        //1234
        //1,234 // 12,34 // 123,4 // 1234
        // 1,2,34 // 12,3,4
        // 1,2,3,4 
        for(int i=start; i<s.length(); i++){
            num = (num*10) + s.charAt(i)-'0';
            if(num>k) break;
           // Goals
            ans = (ans%mod) + (solve(i+1,s,k)%mod);
        }
        return memset[start]=(int)(ans%mod);
        
     }
        
    public int numberOfArrays(String s, int k) {
        
        memset = new int[s.length()];
       
        Arrays.fill(memset,-1);
        
        return solve(0,s,k);
    }
}
