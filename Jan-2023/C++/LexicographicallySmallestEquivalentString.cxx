// 1061. Lexicographically Smallest Equivalent String
class Solution {
	public:
	int find(int * lexo, int ind) {
		//gets the smallest character 
		//a-->b-->c
		//if x = c
		//return a 
		//or if e=f
		//and if f = x return e
		while (lexo[ind] != ind) {
			ind = lexo[ind]; }
		return ind;
	}
	
	
	string smallestEquivalentString(string s1, string s2, string baseStr) {
		int lexo[26];
		for (int i = 0; i < 26; i++) {
			lexo[i] = i;
		}

		for (int i = 0; i < s1.length(); i++) {

			int a = s1[i] - 'a';
			int b = s2[i] - 'a';
			int end1 = find(lexo, a);
			int end2 = find(lexo, b);
			//get the smaller character and make an adjaency matrix
			if (end1 < end2) {
	  		lexo[end2] = end1;
			}
			else {
				lexo[end1] = end2;
			}
		}

		stringstream sb;
		for (int i = 0; i < baseStr.length(); i++) {
			int c = baseStr[i] - 'a';
			//'a'+ returns the correct character which is returned after adding to index and adds it to the stringstream/stringbuilder 
			sb << (char)('a' + find(lexo, c));
		}
		return sb.str();
	}
};
