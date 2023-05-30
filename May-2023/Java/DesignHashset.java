class MyHashSet {
    private boolean[] vec;

    /** Initialize your data structure here. */
    public MyHashSet() {
        vec = new boolean[1000001];
    }
    
    public void add(int key) {
        vec[key] = true;
    }
    
    public void remove(int key) {
        vec[key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return vec[key];
    }
}
