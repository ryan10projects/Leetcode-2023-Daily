// 1232. Check If It Is a Straight Line
// Algorithm 
// slope formula

// y2-y1/x2-x1

 // cross multiply two slopes instead of divide
class Solution {

public:

    bool checkStraightLine(vector<vector<int>>& coordinates) {

        for (int i = 1; i < coordinates.size() - 1; i++) {

            int x1 = coordinates[0][0];

            int y1 = coordinates[0][1];

            int x2 = coordinates[i][0];

            int y2 = coordinates[i][1];

            int x3 = coordinates[i + 1][0];

            int y3 = coordinates[i + 1][1];

            if ((y2 - y1) * (x3 - x1) != (y3 - y1) * (x2 - x1))

                return false;

        }

        return true;

    }

};
