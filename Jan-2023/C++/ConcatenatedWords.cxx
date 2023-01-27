

// 472. Concatenated Words
class Solution {
    
public:
    unordered_set<string> set;
    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        for(auto s: words){
      	//add them to set and check them later
            set.insert(s);

        }
        vector<string> result;
        for(int i=0; i<words.size(); i++){
            string word = words[i];
            if(isPresent(word)){
                result.push_back(word);
              }
            }
        return result;
    }
    
    bool isPresent(string word){
        for(int i=0;i<word.length();i++){
            	//cut the string into two seperate parts and check if they contain within the hashset
			//hashset peforms operation in O(1) in avearge case so it is better than linkedlist which searches in O(n) 
            string prefix = word.substr(0,i+1); 
            string suffix = word.substr(i+1);
            if((set.count(prefix) && set.count(suffix)) || (set.count(prefix) && isPresent(suffix))){
                return true;
                }
            
          }
        return false;
     }
};
