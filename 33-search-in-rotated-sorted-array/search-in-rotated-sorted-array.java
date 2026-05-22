class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int piv = getpivot(nums);

        int idx = bs(0, piv - 1, nums, target);

        if (idx != -1) {
            return idx;
        }

        idx = bs(piv, n - 1, nums, target);
        return idx;
    }

    public int bs(int start, int end, int[] nums, int target) {
        int low = start;
        int high = end;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int getpivot(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (high > low) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }
}