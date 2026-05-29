class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(getsum(nums[i]), mini);
        }
        return mini;
    }

    public int getsum(int i) {
        int sum = 0;
        while (i > 0) {
            int rem = i % 10;
            sum += rem;
            i /= 10;
        }
        return sum;
    }
}