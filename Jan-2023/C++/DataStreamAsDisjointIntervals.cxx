// 352. Data Stream as Disjoint Intervals
/* we need to add all the numbers in an ordered set which makes it sorted, and add all the numbeds in the set that form a valid range 1,2,3,5,6 so here {1,3} {5,6} is a valid set */
class SummaryRanges {
public:
    set<int> set;
    SummaryRanges() {
        set.clear();
    }
    
    void addNum(int value) {
        set.insert(value);
    }
    vector<vector<int>> getIntervals() {
        vector<int> nums(begin(set),end(set));
        vector<vector<int>> res;
        for(int i=0; i<nums.size(); i++){
            //get left number
            int left = nums[i];
            while(i<nums.size()-1 && nums[i]+1==nums[i+1]){
                i++;
             }
             //get right number
            int right = nums[i];
            //add both the numbers making a valid range
            res.push_back({left,right});
               
        }
        return res;
        
    }
};

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges* obj = new SummaryRanges();
 * obj->addNum(value);
 * vector<vector<int>> param_2 = obj->getIntervals();
 */
