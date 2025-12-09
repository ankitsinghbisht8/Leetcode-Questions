class Solution {
    public int specialTriplets(int[] nums) {
        final long MOD = 1_000_000_007L;
        int n = nums.length;

        Map<Long, Long> rmap = new HashMap<>();
        Map<Long, Long> lmap = new HashMap<>();

        for (int x : nums) {
            long v = x;
            rmap.put(v, rmap.getOrDefault(v, 0L) + 1);
        }

        long ans = 0L;

        for (int j = 0; j < n; j++) {
            long mid = nums[j];

            rmap.put(mid, rmap.get(mid) - 1);

            long big = mid * 2;

            long lcount = lmap.getOrDefault(big, 0L);
            long rcount = rmap.getOrDefault(big, 0L);

            ans = (ans + (lcount % MOD) * (rcount % MOD)) % MOD;

            lmap.put(mid, lmap.getOrDefault(mid, 0L) + 1);
        }

        return (int) (ans % MOD);
    }
}
