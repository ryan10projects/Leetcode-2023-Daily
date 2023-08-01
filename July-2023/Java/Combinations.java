class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public void solve(int n, int k, List<Integer> temp, int idx) {
        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (idx > n)
            return;

        temp.add(idx);
        solve(n, k - 1, temp, idx + 1);
        temp.remove(temp.size() - 1);
        solve(n, k, temp, idx + 1);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        solve(n, k, temp, 1);
        return result;
    }
}
