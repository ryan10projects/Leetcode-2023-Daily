//520. Detect Capital

class Solution {
	public boolean detectCapitalUse(String word) {
		int count = 0;
		//using inbuilt function for checking for uppercase
		for (int i = 0; i < word.length(); i++) {
			if (Character.isUpperCase(word.charAt(i))) {
				count++;
			}
		}
		//Checking for all 3 conditions
		return count == 0 || count == word.length() || count == 1 && Character.isUpperCase(word.charAt(0));
	}
}
