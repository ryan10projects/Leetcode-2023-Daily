

// 705. Design HashSet
class MyHashSet {

    HashSet<Integer> map;
    public MyHashSet() {
        map = new HashSet<Integer>();
    }
    
    public void add(int key) {
        map.add(key);
    }
    
    public void remove(int key) {
        map.remove(key);
    }
    
    public boolean contains(int key) {
        if(map.contains(key)) return true;
        
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
