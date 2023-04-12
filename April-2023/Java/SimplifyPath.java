// 71. Simplify Path
// Split String using split and setting the delimiter to /
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String token : path.split("/")) {
            if (token.equals("") || token.equals("."))
                continue;
            if (!token.equals(".."))
                stack.push(token);
            else if (!stack.empty())
                stack.pop();
        }
       String result = "";
        while (!stack.empty()) {
            result = "/" + stack.pop() + result;
        }
        if (result.length() == 0)
            result = "/";
        return result;
    }
}
