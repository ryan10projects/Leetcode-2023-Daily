// 1071. Greatest Common Divisor of Strings
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) return "";
        return str2.substring(0,gcd(str1.length(),str2.length()));
    }
    
    public int gcd(int s1, int s2){
        //eculidean greatest commom divisor formula.eg 28%16=8 and 16%8=0, both have a common divisor 8 and it is the highest gcd by using the formula so here s1=26 and s2=16
        if(s2==0) return s1;
        return gcd(s2,s1%s2);
        //(16,28%16) first call
        //(8,0) second call
    }
}
