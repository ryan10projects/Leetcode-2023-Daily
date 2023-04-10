// 20. Valid Parentheses
class Solution {
public:
    bool isValid(string s1) {
        if (s1.length() % 2 != 0) return false;
        stack<char> s;
        for (char c : s1) {
            if (c == '(' || c == '[' || c == '{') {
                s.push(c);
            }
            else if (c == ')' && !s.empty() && s.top() == '(') {
                s.pop();
            }
            else if (c == ']' && !s.empty() && s.top() == '[') {
                s.pop();
            }
            else if (c == '}' && !s.empty() && s.top() == '{') {
                s.pop();
            }
            else {
                s.push(c);
            }
        }
        return s.empty();
    }
};
