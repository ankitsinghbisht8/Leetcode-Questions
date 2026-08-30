class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int cumsum = 0;
        for (int i = 0; i < n; i++) {
            cumsum += nums[i];
            if (map.containsKey(cumsum - k)) {
                ans += map.get(cumsum - k);
            }
            map.put(cumsum,map.getOrDefault(cumsum,0)+1);
        }
        return ans;
    }
}