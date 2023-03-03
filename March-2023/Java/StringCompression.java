// 443. String Compression
class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0;
       
        int index=0;
        while(i<n){
            char curr_ch = chars[i];
            int count=0;
            // Check the count of the same character
            while(i<n && chars[i]==curr_ch){
                i++;
                count++;
            }
            // Add the alphabet 
            chars[index]=curr_ch;
            index++;
            // If count is greater than 1, add it in the string
            if(count>1){
                String c = String.valueOf(count);
                for(char s: c.toCharArray()){
                    chars[index]=s;
                    index++;
               }
            }
            
        }
        return index;
    }
}
