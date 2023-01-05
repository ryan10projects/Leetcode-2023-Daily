// 452. Minimum Number of Arrows to Burst Balloons 

class Solution {
public:
    bool static compareFunction(vector<int> &a, vector<int> &b) {
        return a[1]<b[1];
      }
    int findMinArrowShots(vector<vector<int>>& points) {
        
        //bool compareFunction(const vector<int> &a, const vector<int> &b){
           // return a[1]>b[1];
       // }
        sort(points.begin(), points.end(), compareFunction);
        
        int arrowCount = 1;
        int range = points[0][1];
        
        for(int i=1;i<points.size();i++){
            if(points[i][0]<=range){
                continue;
            }
            else{
                arrowCount++;
                range = points[i][1];
            }
             
        }
        return arrowCount;
    }
};
