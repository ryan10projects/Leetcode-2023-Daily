// 57. Insert Interval

l

class Solution {

public:

    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {

        vector<vector<int>> result;      

        int i = 0;

        int size = intervals.size();

         //keep pushing if end is less than the start of the array to be merged

        while(i<size && intervals[i][1] < newInterval[0]){

           result.push_back(intervals[i++]);

        }

        vector<int> mat = newInterval;

            //check for mergable numbers formula

        while(i<intervals.size() && intervals[i][0]<= newInterval[1]){

            mat[0] = min(mat[0],intervals[i][0]);

            mat[1] = max(mat[1],intervals[i][1]);

            i++;

        }

        result.push_back(mat);

           //add the rest of the numbers

        while(i<intervals.size()){

            result.push_back(intervals[i]);

            i++;

         }

            

        return result;

    }

};
