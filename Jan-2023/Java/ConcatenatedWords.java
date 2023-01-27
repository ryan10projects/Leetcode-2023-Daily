// 472. Concatenated Words
class Solution {
	Set<String> set = new HashSet<>();
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		List<String> result = new LinkedList<>();
		//add them to set and check them later
		for (String s : words) {
			set.add(s);
		}
		for (int i = 0; i < words.length; i++) {
			String w = words[i];
			if (isPresent(w)) {
				result.add(w);
			}
		}
		return result;
	}
	public boolean isPresent(String word) {
		for (int i = 0; i < word.length(); i++) {
			//cut the string into two seperate parts and check if they contain within the hashset
			//hashset peforms operation in O(1) in avearge case so it is better than linkedlist which searches in O(n) 
			String prefix = word.subString(0, i + 1);
			String suffix = word.subString(i + 1, word.length());
			if ((set.contains(prefix) && set.contains(suffix)) || set.contains(prefix) && isPresent(suffix)) {
				return true;
			}
		}
		return false;
	}
}
