

// 93. Restore IP Addresses
/*Recursion 3 keys
Step 1: Goals
Step 2: Constraints
Step 3: Choice
*/

class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        vector<string> result;
        int path[4];
        backtrack(result, s, path, 0, 0);
        return result;
    }

    void backtrack(vector<string> &ls, string s, int path[], int segment, int builder) {
        //Goals
        //we can divide the string into 4 maximum parts so the segment is 4 and if we reached end of the string by checkinf if builder is 4, we found an answer
        if (segment == 4 && builder == s.length()) {
            ls.push_back(to_string(path[0]) + "." + to_string(path[1]) + '.' + to_string(path[2]) + '.' + to_string(path[3]));
        } else if (segment == 4 || builder == s.length()) {
            return;
        }
        
        //Contraints
         //len = 1 because we will add a dot after the first digi
        for (int len = 1; len <= 3 && builder + len <= s.length(); len++) {
            // grab a substring, maximum 3 digits, minimum 1
            string snapshot = s.substr(builder, len);
            int value = stoi(snapshot);
            
            //First constraint
            //shouldn't start with 0 and if it does, it length should not be greater than 1. Ex 00 is invalid but 0 is valid
            if (snapshot[0] == '0' && snapshot.length() > 1) {
                continue;
            }
            //Second constraint
            if (value > 255) {
                continue;
            }
            //we found one segment so we add it into the path
            path[segment] = value;
            //Choice
            //Explore remaining parts
            backtrack(ls, s, path, segment + 1, builder + len);
            //path[segment]=-1;

        }
    }
};
