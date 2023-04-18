// 1768. Merge Strings Alternately
class Solution {
	public String mergeAlternately(String word1, String word2) {
		String res = "";
		int i = 0;
		int min = Math.min(word1.length(), word2.length());
		while (i < min) {
			res += word1.charAt(i);
			res += word2.charAt(i);
			i++;
		}
		while (i < word1.length()) {
			res += word1.charAt(i);
			i++;
		}
		while (i < word2.length()) {
			res += word2.charAt(i);
			i++;
		}
		return res;
	}
}
