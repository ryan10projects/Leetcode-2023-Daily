// 72. Edit Distance
// Levenshtein distance algorithm
class Solution {
    public int minDistance(String word1, String word2) {
        // same words, no need to insert, replace, delete
        if(word1.equals(word2)) return 0;
        if(word1.length()==0 || word2.length()==0) return Math.abs(word1.length()-word2.length());
        int[][] dist = new int[word1.length()+1][word2.length()+1];
        
        for(int i=0; i<=word1.length(); i++)
          {
            dist[i][0]=i;
          }
        for(int i=0; i<=word2.length(); i++)
            {
               dist[0][i]=i;
            }
        for(int i=1; i<=word1.length(); i++){
         for(int j=1; j<=word2.length(); j++){
             // if words are same then no operations need to be performed
             if(word1.charAt(i-1)==word2.charAt(j-1)){
                 dist[i][j]=dist[i-1][j-1];
              }
             else {
                 //look left, adjacent, top value and pick minimum and add 1, that will be the min distance 
                 dist[i][j]=Math.min(dist[i-1][j-1],Math.min(dist[i-1][j],dist[i][j-1]))+1;                 
             }             
          }            
      }
          return dist[word1.length()][word2.length()];
    }
}
