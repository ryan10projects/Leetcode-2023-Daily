// Algorithm
// usually whenever the question tells us to pick minimum or maximum, always go with priorityQueue
// get two queues which acts as a window for n number of candidates from start and end
// pick the minimum from both the pq and add it to the ans
// keep doing that until k number of works have been hired as per question 
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int hired = 0;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        int i=0, j=costs.length-1;
        long ans = 0;
        while(hired<k){
            while(pq1.size()<candidates && i<=j){
                pq1.offer(costs[i]);
                i++;
          }
          while(pq2.size()<candidates && j>=i){
              pq2.offer(costs[j]);
              j--;
              }
            int min1 = pq1.size()==0?Integer.MAX_VALUE: pq1.peek();
            int min2 = pq2.size()==0?Integer.MAX_VALUE: pq2.peek();
            if(min1<=min2) {
                ans+=min1;
                pq1.poll();
              
            }
            else{
                ans+=min2;
                pq2.poll();
                
              
            }
            hired++;
        }
        return ans;
    }
}
