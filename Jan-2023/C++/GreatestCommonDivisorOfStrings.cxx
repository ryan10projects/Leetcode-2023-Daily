1071. Greatest Common Divisor of Strings
class Solution {
public:
    string gcdOfStrings(string str1, string str2) {
        if ((str1 + str2) != (str2 + str1)) return "";
        return str2.substr(0, gcd(str1.length(), str2.length()));
    }
    
    int gcd(int s1, int s2) {
        // Euclidean greatest common divisor formula.
       // eg 28%16=8 and 16%8=0, both have a common divisor 8 and it is the highest gcd by using the formula so here s1=26 and s2=16
        if (s2 == 0) return s1;

       //(16,28%16) first call
        //(8,0) second call

        return gcd(s2, s1 % s2);
    }
};
