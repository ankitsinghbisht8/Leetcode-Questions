class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        int repeated = n / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val == repeated) {
                return key;
            }
        }
        return -1;
    }
}