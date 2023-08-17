class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        int[][] result = new int[mat.length][mat[0].length];
    for(int[] res: result){
        Arrays.fill(res,-1);
    }
        //store result of all 0s and traverse from there first to get the nearest answer
    for(int i=0; i<mat.length; i++){
      for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]==0){
                    result[i][j]=0;
                    queue.add(new Pair(i,j));
                }
           }
        }
        // traverse in 4 directions
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
       // shortest distance automatically cause bfs
        while(!queue.isEmpty()){
            Pair<Integer,Integer> pair = queue.poll();
            int new_i = pair.getKey();
            int new_j = pair.getValue();
            for(int[] dir: directions){
                int i = dir[0]+new_i;
                int j = dir[1]+new_j;
                if(i>=0 && i<mat.length && j>=0 && j<mat[0].length && result[i][j]==-1){
                    result[i][j]=result[new_i][new_j]+1;
                    queue.add(new Pair(i,j));
               }
            }
                
        }
        return result;
    }
}
