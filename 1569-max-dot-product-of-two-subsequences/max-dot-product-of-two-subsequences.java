class Solution {
    public int m;
    public int n;
    Integer[][] dp;

    public int maxDotProduct(int[] nums1, int[] nums2) {
        n = nums1.length;
        m = nums2.length;
        dp = new Integer[n][m];
        return solve(0, 0, nums1, nums2);
    }

    public int solve(int i, int j, int[] nums1, int[] nums2) {
        if (i == n || j == m) {
            return Integer.MIN_VALUE;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int val1 = nums1[i] * nums2[j];
        int takebothiandj = val1 + Math.max(0, solve(i + 1, j + 1, nums1, nums2));
        int takeonlyi = solve(i + 1, j, nums1, nums2);
        int takeonlyj = solve(i, j + 1, nums1, nums2);
        return dp[i][j] = Math.max(val1, Math.max(takebothiandj, Math.max(takeonlyi, takeonlyj)));
    }
}