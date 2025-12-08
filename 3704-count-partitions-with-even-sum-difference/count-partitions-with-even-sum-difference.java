class Solution {
    public int countPartitions(int[] nums) {
        int totalsum=0;
        for(int i:nums){
            totalsum+=i;
        }
        if(totalsum%2==0){
            return nums.length-1;
        }
        return 0;
    }
}