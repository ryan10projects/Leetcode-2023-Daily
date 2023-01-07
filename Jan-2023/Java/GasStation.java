// 134. Gas Station
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for(int i=0;i<cost.length;i++){
            totalGas+=gas[i];
            totalCost+=cost[i];
        }
        //should be able to travel atleast once in a clockwise direction according to question
        if(totalGas<totalCost){
           return -1;
        }
        int remainingGas=0;
        int start = 0;
        for(int i=0;i<cost.length;i++){
            remainingGas += (gas[i]-cost[i]);
            //look for a positive value so you can travel to the next gas station, you should return start when you find it and make sure no other values make the remainingGas below 0 otherwise you cant move through all the stations
            if(remainingGas<0){
              start=i+1;
              remainingGas=0;
            }
        }
        //this will start from a the gas station that can travel to all stations atleast once
        return start;
    }
}
