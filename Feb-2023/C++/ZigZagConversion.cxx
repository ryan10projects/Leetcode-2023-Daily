/*
Algorithm
Outer loop, goes thru the rows
Inner loop, goes thru the characters on same line
2*numRows-1 gives alternate characters on the same line
the if condition gives the next character besides the current character so j is the current character (j+increment-2*row). 2*row because we can imagine cutting it in half everytime we traverse down in a V like pattern*/

// 6. Zigzag Conversion
class Solution {
public:
    string convert(string s, int numRows) {
        if(numRows==1) return s;
        int increment = 2*(numRows-1);
        string res="";
        for(int i=0; i<numRows; i++){
            for(int j=i;j<s.size();j+=increment){
                res+=s[j];
                if(i>0 && i<numRows-1 && j+increment-2*i> 0 &&
                   j+increment-2*i<s.size()){
                    res+=s[j+increment-2*i];
                }
            }
        }
        return res;
    }
};
