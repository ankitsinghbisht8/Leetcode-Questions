class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long mod = (long) 1e9 + 7;
        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];
        TreeMap<Integer, Integer> count = new TreeMap<>();

        dp[0] = 1;
        prefix[0] = 1;
        for (int i = 0, j = 0; i < n; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);

            while (j <= i && count.lastKey() - count.firstKey() > k) {
                count.put(nums[j], count.get(nums[j]) - 1);
                if (count.get(nums[j]) == 0) {
                    count.remove(nums[j]);
                }
                j++;
            }

            dp[i + 1] = (prefix[i] - (j > 0 ? prefix[j - 1] : 0) + mod) % mod;
            prefix[i + 1] = (prefix[i] + dp[i + 1]) % mod;
        }

        return (int) dp[n];
    }
}