/*
Algorithm
Outer loop, goes thru the rows
Inner loop, goes thru the characters on same line
2*numRows-1 gives alternate characters on the same line
the if condition gives the next character besides the current character so j is the current character (j+increment-2*row). 2*row because we can imagine cutting it in half everytime we traverse down in a V like pattern*/

// 6. Zigzag Conversion
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String res = "";
        int increment = 2 * (numRows - 1);
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += increment) {
                res += s.charAt(j);
                int secondIndex = j + increment - 2 * i;
                if (i > 0 && i < numRows - 1 && secondIndex < s.length() && secondIndex >= 0) {
                    res += s.charAt(secondIndex);
                }
            }
        }
        return res;
    }
}
