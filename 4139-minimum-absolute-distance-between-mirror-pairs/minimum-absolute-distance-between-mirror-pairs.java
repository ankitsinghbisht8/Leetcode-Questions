class Solution {
    int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int rem = x % 10;
            res = res * 10 + rem;
            x /= 10;
        }
        return res;
    }

    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(reverse(nums[0]), 0);

        int res = Integer.MAX_VALUE;

        for (int j = 1; j < nums.length; j++) {
            if (map.containsKey(nums[j])) {
                res = Math.min(res, j - map.get(nums[j]));
            }
            map.put(reverse(nums[j]), j);
        }

        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
}