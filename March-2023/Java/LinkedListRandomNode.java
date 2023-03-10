// 382. Linked List Random Node
class Solution {
    ArrayList<Integer> arr = new ArrayList<>();    
    public Solution(ListNode head) {
         while(head!=null){
             arr.add(head.val);
             head=head.next;             
             }
    }    
    // Math.random() method generates a random double value between 0.0 and 1.0 (double). When this value is multiplied by arr.size(), the result will be a value between 0.0 (inclusive) and arr.size() (exclusive). This means that the maximum value that can be generated is one less than the size of the array because the index of an array starts at 0.
    public int getRandom() {
        return arr.get((int)(Math.random()*arr.size()));
    }
}
