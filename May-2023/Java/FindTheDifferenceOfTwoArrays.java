// 2215. Find the Difference of Two Arrays
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for(int num: nums1){
            s1.add(num);
        }
        for(int num: nums2){
            s2.add(num);
        }
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> n1 = new LinkedList<>();
        List<Integer> n2 = new LinkedList<>();
        for(int i: s1){
            if(!s2.contains(i)){
                n1.add(i);
            }
        }       
        for(int i: s2){
            if(!s1.contains(i)){
                n2.add(i);
            }
        }
        list.add(n1);
        list.add(n2);
        return list;
} }
    
