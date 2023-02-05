// Find All Anagrams in a String
// Maintain a sliding window, Add elements from fhe front and delete elements from the behind to maintain the same length as p String. Then compare them
// Similar to permutations in a string just add the start index
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length()>s.length()) return new LinkedList<>(); 
        List<Integer> ls = new LinkedList<>();
        if(p.equals(s)){
            ls.add(0);
            return ls;
        }
        int start=0;
        int end=0;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i=0; i<p.length();i++){
            freq1[p.charAt(i)-'a']++;
            freq2[s.charAt(i)-'a']++;
         }     
        if(Arrays.equals(freq1,freq2)) ls.add(start);
        
        for(int i=p.length();i<s.length();i++){
            start++;
            end--;
            freq2[s.charAt(i)-'a']++;
            freq2[s.charAt(i-p.length())-'a']--;
            if(Arrays.equals(freq1,freq2)){
                ls.add(start);
            }
         }
        return ls;
        
        
    }
} ;
