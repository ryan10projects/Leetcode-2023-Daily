// 1146. Snapshot Array
// Algorithm
// Create a list of list of pair
// the main list (outer list) will store the index
// the inner list will have a list of pairs
// each pair having the snapshot id and value associated with it (giving the exact value at the intended snapshot)
// binary search of logn time complexity
class SnapshotArray {
    int snapshots;
    List<List<Pair<Integer,Integer>>> list;
    public SnapshotArray(int length) {        
        this.snapshots=0;
        list = new ArrayList<>(length);
        for(int i=0; i<length; i++){   
        List<Pair<Integer, Integer>> l = new ArrayList<>();
            l.add(new Pair<>(0,0));
            list.add(i,l);            
        }
        
    }
    
    public void set(int index, int val) {
        list.get(index).add(new Pair(snapshots,val));
    }
    
    public int snap() {     
        return snapshots++;
    }
    
    public int get(int index, int snap_id) {
        int left = 0;
        int right = list.get(index).size()-1;
        int ans =0;
        while(left<=right){
            int mid = left + (right-left)/2;                              
            if(list.get(index).get(mid).getKey()<=snap_id){
                ans = list.get(index).get(mid).getValue();;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return ans;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
