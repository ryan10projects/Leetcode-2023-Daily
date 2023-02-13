// 1523. Count Odd Numbers in an Interval Range
// Assume half the numbers are odd
// +1 because to round up for int
class Solution {
public:
    int countOdds(int low, int high) {
        return (high+1)/2-low/2;
    }
};
