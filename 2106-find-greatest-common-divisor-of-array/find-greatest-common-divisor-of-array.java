class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int smallest = nums[0];
        int largest = nums[n - 1];
        return gcd(smallest, largest);
    }

    public int gcd(int a, int b) {
        if (a == 0 || b == 0)
            return Math.max(a, b);
        int res = Math.min(a, b);
        while (res > 0) {
            if (a % res == 0 && b % res == 0) {
                break;
            }
            res--;
        }
        return res;
    }
}