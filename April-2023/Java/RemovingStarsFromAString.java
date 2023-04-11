// 2390. Removing Stars From a String
class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!='*'){
                stack.push(s.charAt(i));
            }
            else{
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();     
        while(!stack.isEmpty()){
            sb.append(stack.pop());         
        }   
        return sb.reverse().toString();
    }
}
