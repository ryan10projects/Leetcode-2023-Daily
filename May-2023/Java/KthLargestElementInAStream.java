
// 703. Kth Largest Element in a Stream
class KthLargest {    
    PriorityQueue<Integer> pq;
    int t;    
    public KthLargest(int k, int[] nums) {
        this.t = k;
        pq = new PriorityQueue<>();
        for(int n:nums){
            pq.offer(n);
            while(pq.size()>t){
                pq.poll();
                }           
         }      
    }    
    public int add(int val) {
        pq.offer(val);
        while(pq.size() > t){
             pq.poll();
            }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
