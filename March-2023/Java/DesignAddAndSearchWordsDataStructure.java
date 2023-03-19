// 211. Design Add and Search Words Data Structure
// Learn trie structure before looking it up
class WordDictionary {
	static class TrieNode {

		boolean isEnd;
		TrieNode[] children;
	}

	TrieNode getNode() {
		TrieNode node = new TrieNode();
		node.isEnd = false;
		node.children = new TrieNode[26];
		for (int i = 0; i < 26; i++) {
			node.children[i] = null;
		}
		return node;
	}
	TrieNode root;
	public WordDictionary() {
		root = getNode();
	}
	public void addWord(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			int c = word.charAt(i) - 'a';
			if (node.children[c] == null) {
				node.children[c] = getNode();
			}
			node = node.children[c];
		}
		node.isEnd = true;
	}

	public boolean helper(TrieNode root, String word) 		{
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (word.charAt(i) == '.') {
				for (int j = 0; j < 26; j++) {
					// make the node root and start checking once again from the remaining letters besides .
					if (node.children[j] != null && helper(node.children[j], word.substring(i + 1))) {
						return true;
					}
				}
				// nothing found so return false
				return false;
			} else if (node.children[c - 'a'] == null) {
				return false;
			} else {
				node = node.children[c - 'a'];
			}
		}
		return node.isEnd;
	}
	public boolean search(String word) {
		return helper(root, word);
	}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
