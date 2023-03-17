// 208. Implement Trie (Prefix Tree)
// TrieNode is a data structure used in the implementation of a trie, also known as a prefix tree. A trie is a tree-like data structure used to store a collection of strings. In a trie, each node represents a character, and each path from the root to a leaf node represents a string. A TrieNode contains several fields that define its properties and behavior. Typically, a TrieNode contains the following fields: Children: an array or map of child nodes, each representing a possible next character in the string. IsEndOfWord: a boolean value indicating whether the current node marks the end of a word.Using TrieNodes, it is possible to efficiently search for words in a large collection of strings, as well as to perform operations such as insertion, deletion, and traversal of the trie.
class Trie {
public:
   // defining structure
    struct trieNode{
        bool isEnd;
        trieNode* children[26];
    };
    // create new node using the above structure
    trieNode* newNode() {
        trieNode* node = new trieNode();
        node->isEnd = false;
        for(int i=0; i<26; i++){
            node->children[i]=nullptr;
        }
        return node;
    }
    // setting root
    trieNode* root;
    Trie() {
        root = newNode();
    }
    
    void insert(string word) {
        // pointer to traverse the nodes
        trieNode* crawler = root;
        for(int i=0; i<word.length(); i++){
            int c = word[i]-'a';
            if(crawler->children[c]==nullptr){
                crawler->children[c] = newNode();
             }
            crawler=crawler->children[c];
        }
        crawler->isEnd=true;
    }
    bool search(string word) {
        trieNode* crawler = root;
        for(int i=0; i<word.length(); i++){
            int c = word[i]-'a';
            if(crawler->children[c]==nullptr){
                return false;
           }
            crawler=crawler->children[c];
        }
        if(crawler->isEnd==true) return true;
        return false;
    }
    bool startsWith(string prefix) {
        trieNode* crawler = root;
        int i=0;
        for(; i<prefix.length();i++){
            int c = prefix[i]-'a';
            if(crawler->children[c]==nullptr){
                return false;
            }
            crawler=crawler->children[c];
        }
        // end of prefix reached without finding a null, so return true
        if(i==prefix.length()) return true;
        return false;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
