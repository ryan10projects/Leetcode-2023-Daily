class Solution {
    List<List<Integer>> result = new LinkedList<>();

    public void solve(int[] nums, List<Integer> temp, boolean[] visited) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp.add(nums[i]);
                solve(nums, temp, visited);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<Integer> temp = new LinkedList<>();
        solve(nums, temp, visited);
        return result;
    }
}
