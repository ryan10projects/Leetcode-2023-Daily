// 946. Validate Stack Sequences
// Check if top of stack exists within popped array, if it does not keep pushing or pop from stack
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j=0;
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<pushed.length; i++){
            s.push(pushed[i]);
            while(!s.isEmpty() && s.peek()==popped[j]){
                s.pop();
                j++;
            }          
      }
        return s.isEmpty();
    }
}
