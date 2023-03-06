// 1345. Jump Game IV

class Solution {

    public int minJumps(int[] arr) {

        int n = arr.length;

        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[n];

        HashMap<Integer,List<Integer>> map = new HashMap<>();

        // store indexes as values

        for(int i=0; i<arr.length;i++){

           map.computeIfAbsent(arr[i],k->new ArrayList<>()).add(i);

        }

        int steps=0;

        q.add(0);

        visited[0]=true;

        while(!q.isEmpty()){

            int size = q.size();

            while(size-->0){

                int curr = q.poll();

                // first jump condition 

                int left = curr-1;

                // second jump condition

                int right= curr+1;

                //check boundaries and add

                if(curr==n-1) return steps;

                if(left>=0 && !visited[left]){

                 q.add(left);

                 visited[left]=true;

               }

               //check boundaries and add

               if(right<n && !visited[right]){

                   q.add(right);

                   visited[right]=true;

               }

               // third jump condition

             // add all the indexes with same number

                if(map.containsKey(arr[curr])){

               for(int i: map.get(arr[curr])){

                   q.add(i);

                   visited[i]=true;

                   }              

                 }

               // no need to traverse again, timeout error without it

                map.remove(arr[curr]);

           }

            steps++;          

       }

        return -1;

    }

}
