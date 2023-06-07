// 1318. Minimum Flips to Make a OR b Equal to c
// Algorithm 
// Perform Or operation
// use x&1 to get the right most bit
// use >> for deleting the right most bit
// compare if Or operation gives the results of both in c, if not flip

class Solution {
public:
    int minFlips(int a, int b, int c) {
        int result = 0;        
        while( a != 0 || b != 0 || c != 0) {
            if( (c & 1) == 1) {
                if((a & 1) == 0 && (b & 1) == 0) {
                    result++;
                }
            } 
            else {
                result += (a & 1) + (b & 1);
        }
            a >>= 1;
            b >>= 1;
            c >>= 1;          
      }        
        return result;
    }
};
