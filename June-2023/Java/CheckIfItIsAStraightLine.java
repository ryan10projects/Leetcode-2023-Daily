// 1232. Check If It Is a Straight Line
class Solution {
    public boolean checkStraightLine(int[][] cordinates) {
        for(int i=1; i<cordinates.length-1; i++){
            int x1 = cordinates[0][0];
            int y1 = cordinates[0][1];
            
            int x2 = cordinates[i][0];
            int y2 = cordinates[i][1];
            
            int x3 = cordinates[i+1][0];
            int y3 = cordinates[i+1][1];
            // slope formula
            // y2-y1/x2-x1
            // cross multiply two slopes instead of divide
            if((y2-y1)*(x3-x1)!=(y3-y1)*(x2-x1)) return false;
            
     }
        
        return true;
  }
}
