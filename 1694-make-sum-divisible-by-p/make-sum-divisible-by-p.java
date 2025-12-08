class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int x : nums) sum += x;

        int weneed = (int)(sum % p);
        if (weneed == 0) return 0;  

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  

        int prefix = 0;
        int minLen = nums.length;

        for (int i = 0; i < nums.length; i++) {

            prefix = (prefix + nums[i]) % p;

            int target = (prefix - weneed) % p;
            if (target < 0) target += p;

            if (map.containsKey(target)) {
                minLen = Math.min(minLen, i - map.get(target));
            }
            map.put(prefix, i);
        }

        return minLen == nums.length ? -1 : minLen;
    }
}
