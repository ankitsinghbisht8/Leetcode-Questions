class Solution {

    public int maxJumps(int[] arr, int d) {
        int res = 1;
        int n = arr.length;
        Integer[] dp = new Integer[n + 1];
        for (int i = 0; i < n; i++) {
            res = Math.max(res, solve(arr, i, d, dp));
        }
        return res;
    }

    public int solve(int[] arr, int i, int d, Integer[] dp) {
        int res = 1;
        if (dp[i] != null) {
            return dp[i];
        }
        //left
        for (int j = i - 1; j >= Math.max(0, i - d); j--) {
            if (arr[j] >= arr[i])
                break;
            res = Math.max(res, 1 + solve(arr, j, d, dp));
        }

        //right
        for (int j = i + 1; j <= Math.min(arr.length - 1, i + d); j++) {
            if (arr[j] >= arr[i])
                break;
            res = Math.max(res, 1 + solve(arr, j, d, dp));
        }

        return dp[i] = res;
    }
}