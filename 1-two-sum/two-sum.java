class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int el = nums[i];
            int compl = target - el;
            if (map.containsKey(compl)) {
                return new int[] { i, map.get(compl) };
            }
            map.put(el, i);
        }
        return new int[] { -1, -1 };
    }
}