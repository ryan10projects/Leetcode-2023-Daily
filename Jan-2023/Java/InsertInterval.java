// 57. Insert Interval
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ls = new LinkedList<>();
        int size = intervals.length;
        int i = 0;
      
        //keep pushing if end is less than the start of the array to be merged
        while(i<size && intervals[i][1]<newInterval[0]){
                ls.add(intervals[i]);
                i++;
            }
           int[] mat = newInterval;
           //check for mergable numbers formula
           while(i<size && intervals[i][0]<=newInterval[1]){
                 mat[0] = Math.min(mat[0],intervals[i][0]);
                mat[1] = Math.max(mat[1], intervals[i][1]);
               i++;             
             }
        ls.add(mat);
        //add the rest of the numbers
        while(i<size){
            ls.add(intervals[i]);
            i++;
        }
    return ls.toArray(new int[ls.size()][2]);
    }
}
