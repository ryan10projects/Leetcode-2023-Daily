// 452. Minimum Number of Arrows to Burst Balloons 

class Solution {

    public int findMinArrowShots(int[][] points) {

        //Integer overflow fix

        //compares two elements, instead of subtracting which causes integer overflow

        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));

        //range, all balloons between this end variable will be popped

       int end = points[0][1];

       int arrowCount = 1;

       for(int i=1;i<points.length;i++){

          if(points[i][0] <= end){

               continue;

               //do nothing

           }

           else{

               //used one arrow

               arrowCount++;

               //update range

               end = points[i][1];

           }

       }

        return arrowCount;

    }

}
