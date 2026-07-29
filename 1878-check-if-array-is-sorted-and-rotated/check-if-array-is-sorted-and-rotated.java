class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            if (count == n - 1) {
                return true;
            }
            else if (nums[(i + 1) % n] >= nums[(i) % n]) {
                // System.out.println("count is "+count);
                count++;
            }
             else {
                count = 0;
            }
        }
        return false;

    }
}