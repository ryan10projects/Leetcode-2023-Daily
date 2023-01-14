// 1061. Lexicographically Smallest Equivalent String
class Solution {
	public int find(int[] lexo, int ind) {
		while (lexo[ind] != ind) {
				//gets the smallest character 
		//a-->b-->c
		//if x = c
		//return a 
		//or if e=f
		//and if f = x return e
			ind = lexo[ind];
		}
		return ind;
	}

	public String smallestEquivalentString(String s1, String s2, String baseStr) {
		int[] lexo = new int[26];
		for (int i = 0; i < 26; i++) {
			lexo[i] = i;
		}

		for (int i = 0; i < s1.length(); i++) {

			int a = s1.charAt(i) - 'a';
			int b = s2.charAt(i) - 'a';
			int end1 = find(lexo, a);
			int end2 = find(lexo, b);
			if (end1 < end2) {
					//get the smaller character and make an adjaency matrix
				lexo[end2] = end1;
			} else {
				lexo[end1] = end2;
			}

		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < baseStr.length(); i++) {
			int c = baseStr.charAt(i) - 'a';
				//'a'+ returns the correct character which is returned after adding to index and adds it to the stringstream/stringbuilder 
			sb.append((char)('a' + find(lexo, c)));
		}
		return sb.toString();

	}
}
