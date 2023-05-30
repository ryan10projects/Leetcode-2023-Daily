

class MyHashSet {
    unordered_set<int> set;
    
public:
    MyHashSet() {
        
    }
    
    void add(int key) {
        set.insert(key);
    }
    
    void remove(int key) {
        set.erase(key);
    }
    
    bool contains(int key) {
        return set.count(key) > 0;
    }
};
