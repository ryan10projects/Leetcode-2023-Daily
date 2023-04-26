// 258. Add Digits
// Keep calling the function until you have met your desired goal
Here, we need the answer to be in single digit, so we've added <=9 as the goal

class Solution {
public:
    int addDigits(int num) {
        int ans = 0;
        int glob = num;
        if(glob <= 9) {
            return glob;
        }
        while(num != 0) {
            // fetch last digit
            ans += num % 10;
            // fetch all the digits except the last digit
            num = num / 10; 
        }
        return addDigits(ans);
    }
};
