class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int cumsum = 0;
        int leftsum[] = new int[n];
        int rightsum[] = new int[n];
        for (int i = 0; i < n; i++) {
            leftsum[i] = cumsum;
            cumsum += nums[i];
        }
        cumsum = 0;
        for (int i = n - 1; i >= 0; i--) {
            rightsum[i] = cumsum;
            cumsum += nums[i];
        }
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Math.abs(leftsum[i] - rightsum[i]);
        }
        return ans;
    }
}