class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int i = 0;
        int ans = 0;
        int j = 0;
        while (i < n) {
            while (i < n && nums[i] != 0) {
                j++;
                ans = Math.max(j, ans);
                i++;
            }
            j = 0;
            i++;
        }
        return ans;
    }
}