class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n=nums.length;
        long mini=Long.MAX_VALUE;
        long maxi=Long.MIN_VALUE;
        for(int i=0;i<n;i++){
            mini=Math.min(mini,nums[i]);
            maxi=Math.max(maxi,nums[i]);
        }
        return k*(maxi-mini);
    }
}