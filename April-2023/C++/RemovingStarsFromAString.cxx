// 2390. Removing Stars From a String
class Solution {
public:
    string removeStars(string s) {
    stack<char> stack;
    for (int i = 0; i < s.length(); i++) {
        if (s[i] != '*') {
            stack.push(s[i]);
        } else {
            stack.pop();
        }
    }
    string result = "";
    while (!stack.empty()) {
        result += stack.top();
        stack.pop();
    }
    reverse(result.begin(), result.end());
    return result;
}
};
