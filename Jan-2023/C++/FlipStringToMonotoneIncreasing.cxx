// 926. Flip String to Monotone Increasing
class Solution {
public:
    int minFlipsMonoIncr(string s) {
        int i=0;
        for(;i<s.size();i++){
            if(s[i]=='1'){
                break;
             }
        }
        int zeroCount = 0;
        int onesCount = 0;
        for(;i<s.size();i++){
            if(s[i]=='1') onesCount++;
            if(s[i]=='0') zeroCount++;
        
        if(zeroCount>onesCount){
            zeroCount=onesCount;
        }
      }
        return zeroCount;
        
    }
};
//step 1. ignore all the zero to the left and keep iterating i till you find 1
//step 2. start counting ones and zeroes
//step 3. keep track of minimum, we need to retuen the minimum amount to be flipped so we return the minimum count from both
