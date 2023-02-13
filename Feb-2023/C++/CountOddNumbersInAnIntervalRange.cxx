// 1523. Count Odd Numbers in an Interval Range
// Half the numbers are  always odd
// so the difference between  High/2 and low/2 is the answer
// +1 because while diving to round up an integer
```
class Solution {
public:
    int countOdds(int low, int high) {
        return (high+1)/2-low/2;
    }
};
