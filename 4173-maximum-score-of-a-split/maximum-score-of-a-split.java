class Solution {
    public long maximumScore(int[] nums) {
        int n = nums.length;

        int[] suffixarr = new int[n];
        suffixarr[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixarr[i] = Math.min(nums[i], suffixarr[i + 1]);
        }

        long prefix = 0;
        long maxi = Long.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            prefix += nums[i];
            long score = prefix - suffixarr[i + 1];
            maxi = Math.max(maxi, score);
        }

        return maxi;
    }
}
