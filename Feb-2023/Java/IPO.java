// 502. IPO

// Algorithm in short

// we need to make sure whenever we add profits[i], the capital for it should we less than w, and then we can update the w with the profit and start again (Note: we can pick only k items)

class Solution {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = capital.length;

        int[][] current = new int[n][2];

        for(int i=0; i<n; i++){

            current[i][0]=capital[i];

            current[i][1]=profits[i];

        }

		// j will act as a pointer to the sliding window		// priority queue to find the maximum within the sliding window

		// developing a sliding window helps us to know what possible capitals can be added that is less than w

		// to add profits into the current, capital should be less than or equal to current, hence we maintain a vector pair and sort them based on capital

        Arrays.sort(current, (a,b)->a[0]-b[0]);

        int j=0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<k; i++){

            while(j<n && current[j][0]<=w){

                pq.offer(current[j][1]);

                j++;

            }

         if(pq.isEmpty()) break;

         w+=pq.poll();

        }

        

        return w;

    }

}
