// 71. Simplify Path
// string stream takes in an input to be used as stream. getline then takes the stream as input and a temp variable as the second parameter and a delimiter as the third parameter
// this is a alternate version to string.split in java
class Solution {
public:
    string simplifyPath(string path) {
         stack<string> s;
        stringstream ss(path);
        string token="";
        while (getline(ss,token,'/')) {
            if (token=="" || token==".")
                continue;
            if (token!="..")
                s.push(token);
            else if (!s.empty())
                s.pop();
        }
       string result = "";
        while (!s.empty()) {
            result = "/" + s.top() + result;
            s.pop();
        }
        if (result.length() == 0)
            result = "/";
        return result;
    }
};
