/* Explanation
In the bck method, check if the index has traversed through the entire nums array,
if it has check if the length is greated than 2 or atleast 2 since we need to return
subsequences and not a single element, if it exist add it into the final res array.
Also use a set for non-repeating charactsrs. In the if statement below, check if the
list is empty or check the previous element in the list with the current element in nums
index. If it is smaller, add it into the list. Ex 3<5. 3 is the last element in the list
and 5 is the element in nums[index], now perform backtracking and keep adding all elements,
after bck is called remove the last element from the list to check all possible combinations,
if it doesn't find any number smaller than current index called the bck method again outside
loop. (If you still didn't understand, try out permutations before doing this problem)
*/
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> list = new LinkedList<>();
        bck(res,0,list, nums);
        List<List<Integer>> result = new LinkedList<>(res);
        return result;
    }
    
    public void bck(Set<List<Integer>> res, int index, List<Integer> list, int[] nums){
        if(index==nums.length){
            if(list.size()>=2){
                res.add(new LinkedList<>(list));
             }
            return;
        }
		// set l
        if(list.isEmpty() || list.get(list.size()-1)<=nums[index]){
            list.add(nums[index]);
            bck(res,index+1,list,nums);
            list.remove(list.size()-1);
         }
        bck(res,index+1,list,nums);
        }
}
