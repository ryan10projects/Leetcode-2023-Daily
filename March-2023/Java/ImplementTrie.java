// 208. Implement Trie (Prefix Tree)
// TrieNode is a data structure used in the implementation of a trie, also known as a prefix tree. A trie is a tree-like data structure used to store a collection of strings. In a trie, each node represents a character, and each path from the root to a leaf node represents a string. A TrieNode contains several fields that define its properties and behavior. Typically, a TrieNode contains the following fields: Children: an array or map of child nodes, each representing a possible next character in the string. IsEndOfWord: a boolean value indicating whether the current node marks the end of a word.Using TrieNodes, it is possible to efficiently search for words in a large collection of strings, as well as to perform operations such as insertion, deletion, and traversal of the trie.

class Trie {
    // no struct in java
    static class TrieNode{
        boolean isEnd;
        TrieNode[] children=new TrieNode[26];
    }
    TrieNode newNode(){
        TrieNode node = new TrieNode();
        node.isEnd=false;
        for(int i=0; i<26; i++){
          node.children[i]=null;
        }
     return node;
    }
        
    TrieNode root;
    public Trie() {
        root = newNode();
    }
    
    public void insert(String word) {
        // pointer at root
        TrieNode crawler = root;
        for(int i=0; i<word.length(); i++){
            int c = word.charAt(i)-'a';
            if(crawler.children[c]==null){
                crawler.children[c]=newNode();
             }
             // traverse
            crawler = crawler.children[c];
        }
        crawler.isEnd=true;
    }
    
    public boolean search(String word) {
        TrieNode crawler = root;
        for(int i=0; i<word.length(); i++){
            int c = word.charAt(i)-'a';
            if(crawler.children[c]==null) return false;
            
            crawler=crawler.children[c];
        }
       if(crawler.isEnd==true) return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode crawler = root;
        int i=0;
        for(; i<prefix.length(); i++){
          int c = prefix.charAt(i)-'a';
          if(crawler.children[c]==null){
              return false;
          }
            crawler=crawler.children[c];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
