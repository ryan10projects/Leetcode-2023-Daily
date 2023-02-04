// 567. Permutation in String 
// Sliding window approach
class Solution {

    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length()) return false;

        if(s1.equals(s2)) return true;

        if(s1.length()==0) return false;

        int[] freq = new int[26];

        int[] freq2 = new int[26];

        for(int i=0; i<s1.length(); i++){

            freq[s1.charAt(i)-'a']++;

            freq2[s2.charAt(i)-'a']++;

            if(Arrays.equals(freq,freq2)) return true;

        }

        

        for(int i=s1.length();i<s2.length();i++){

            if(Arrays.equals(freq,freq2)) return true;

            freq2[s2.charAt(i)-'a']++;

            freq2[s2.charAt((i-s1.length()))-'a']--;

            }

        

          if(Arrays.equals(freq,freq2)) return true;

            

           

         

        

        return false;

        

    }

}
