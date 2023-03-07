// 2187. Minimum Time to Complete Trips

// Time complexity O(nlog(m))

// m is to find the minimum element in right

// n to loop through time 

class Solution {

public:   

    bool tripsSatisfied(vector<int>& time, int totalTrips, long long mid){

        long long tripsum=0;       

        for(int &t: time){

            tripsum+=mid/t;

        }        

        // if it can reach the totaltrips, we discard the right side of array

        return tripsum>=totalTrips;

    }  

    long long minimumTime(vector<int>& time, int totalTrips) {

        long long left = 1;

        // maximum trips will be the minimum time it requires for one trip. So if a bus take 1 time per trip, to complete for example 5 trips it will take 1*5, similary if there are 10 totaltrips, if a bus takes 2 units of time per trip, it will take 20 trips atmost

        long long right = (long long)*min_element(time.begin(), time.end())*totalTrips;

        

        while(left<right){

            long long mid = left + (right-left)/2;

            // find a mid so that the sum of all the units of time is equal to totaltrips

            if(tripsSatisfied(time,totalTrips,mid)){

                right=mid;

            }

            else{

                left=mid+1;

             }          

       }

        return left;

    }

};
