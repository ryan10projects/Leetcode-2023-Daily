// 20. Valid Parentheses
class Solution {
    public boolean isValid(String s1) {
        if(s1.length()%2!=0) return false;
        Stack<Character> s = new Stack();
        for(char c: s1.toCharArray()){
            if(c=='(' || c=='[' || c=='{'){
                s.push(c);
             }
            else if(c==')' && !s.isEmpty() && s.peek()=='('){
                s.pop();
                }
            else if(c==']' && !s.isEmpty() && s.peek()=='['){
                s.pop();
                }
            else if(c=='}' && !s.isEmpty() && s.peek()=='{'){
                s.pop();
                }
            else{
                s.push(c);
                }
            }
        return s.isEmpty();
     
    }
}
