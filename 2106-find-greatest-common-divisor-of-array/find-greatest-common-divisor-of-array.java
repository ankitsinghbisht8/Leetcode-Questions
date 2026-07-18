import java.math.BigInteger;
class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int smallest = nums[0];
        int largest = nums[n - 1];
        return BigInteger.valueOf(smallest).gcd(BigInteger.valueOf(largest)).intValue();
    }
}