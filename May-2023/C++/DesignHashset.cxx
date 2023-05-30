class MyHashSet {
public:
    
    vector<bool> vec;
    MyHashSet() {
        vec.resize(1000001, false);
    }
    
    void add(int key) {
        vec[key] = true;
    }
    
    void remove(int key) {
        vec[key] = false;
    }
    
    
    bool contains(int key) {
        return vec[key] == true;
    }
};
