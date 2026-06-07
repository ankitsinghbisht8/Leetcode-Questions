class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(arr, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    private void solve(int[] arr, int i, int target, List<Integer> currlist, List<List<Integer>> ans) {
        if (i >= arr.length || target < 0)
            return;
        if (target == 0) {
            ans.add(new ArrayList<>(currlist));
            return;
        }

        //take 
        currlist.add(arr[i]);
        solve(arr, i , target - arr[i], currlist, ans);

        //not take
        currlist.remove(currlist.size() - 1);
        solve(arr, i + 1, target, currlist, ans);
    }
}