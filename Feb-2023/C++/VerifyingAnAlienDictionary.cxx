class Solution {
public:
    int mapping[26];
   
    bool isAlienSorted(vector<string>& words, string order) {
       //Mapping according to the new alphabet order (alien)
        for (int i = 0; i < order.length(); i++)
            mapping[order[i] - 'a'] = i;
        
        for (int i = 1; i < words.size(); i++)
            if (bigger(words[i - 1], words[i]))
                return false;
        
        return true;
    }
    
    bool bigger(string s1, string s2) {
       
        int n = s1.length(), m = s2.length();
        
        for (int i = 0; i < n && i < m; ++i)
            //Ignore if same, only consider the first letter of each word
            if (s1[i] != s2[i])
                return mapping[s1[i] - 'a'] > mapping[s2[i] - 'a'];
        
        return n > m;
    }
};
