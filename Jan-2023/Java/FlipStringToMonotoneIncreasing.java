// 926. Flip String to Monotone Increasing
class Solution {
	public int minFlipsMonoIncr(String s) {
		int i = 0;
		while (i < s.length() && s.charAt(i) != '1') {
			i++;
		}
		int zero = 0;
		int one = 0;
		while (i < s.length()) {
			if (s.charAt(i) == '0') zero++;
			if (s.charAt(i) == '1') one++;
			if (one < zero) {
				zero = one;
			}
			i++;
		}
		return zero;
	}
}
//step 1. ignore all the zero to the left and keep iterating i till you find 1
//step 2. start counting ones and zeroes
//step 3. keep track of minimum, we need to retuen the minimum amount to be flipped so we return the minimum count from both
