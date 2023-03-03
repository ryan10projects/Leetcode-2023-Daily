// Find the Index of the First Occurrence in a String
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n>m) return -1;
        else if(n==0) return 0;
        // Sliding window
        for(int i=0; i<=m-n; i++){
            if(haystack.substring(i,i+n).equals(needle)){
                return i;
             }
        }
            return -1;
    }
}
