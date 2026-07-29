class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 1;
        while (j < n && i < n) {
            if (nums[i] < nums[j] && j < n) {
                nums[++i] = nums[j++];
            }
            if (( i < n && j < n) && (nums[i] == nums[j])) {
                j++;
            }
        }
        return i + 1;
    }
}