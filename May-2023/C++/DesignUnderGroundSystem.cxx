// 1396. Design Underground System
// Algorithm 
// find the difference between the time if both station
// add the time to the totalTime and divide by total count

class UndergroundSystem {
public:
    unordered_map<int, pair<string, int>> checkIn_mp;
    unordered_map<string, pair<int, int>> checkOut_mp;    
    
    UndergroundSystem() {
        
    }
    
    void checkIn(int id, string stationName, int t) {
        checkIn_mp[id] = {stationName, t};
    }
    
    void checkOut(int id, string stationName, int t) {
        auto& it                  = checkIn_mp[id];
        int entryTime             = it.second;
        int timeTaken             = t-entryTime;
        string entryStation       = it.first;
        string route              = entryStation + "_" + stationName;
        checkOut_mp[route].first  += timeTaken;
        checkOut_mp[route].second += 1;
        checkIn_mp.erase(id); 
    }
    
    double getAverageTime(string startStation, string endStation) {
        string route =  startStation + "_" + endStation;
        auto&it      = checkOut_mp[route];
        return (double)it.first/it.second;
    }
};
