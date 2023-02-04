// 567. Permutation in String
//Sliding window approach 

class Solution {

public:

    bool checkInclusion(string s1, string s2) {

        if (s1.length() > s2.length()) return false;

        if (s1 == s2) return true;

        if (s1.length() == 0) return false;

        int freq[26] = {0}, freq2[26] = {0};

        for (int i = 0; i < s1.length(); i++) {

            freq[s1[i] - 'a']++;

            freq2[s2[i] - 'a']++;

         

        }

        for (int i = s1.length(); i < s2.length(); i++) {

            if (memcmp(freq, freq2, sizeof(freq)) == 0) return true;

            freq2[s2[i] - 'a']++;

            freq2[s2[i - s1.length()] - 'a']--;

        }

        if (memcmp(freq, freq2, sizeof(freq)) == 0) return true;

        

        return false;

            

    }

};

