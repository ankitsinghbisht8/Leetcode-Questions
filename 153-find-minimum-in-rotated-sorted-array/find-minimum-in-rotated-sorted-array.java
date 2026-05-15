class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        return pivot(nums);
    }
    public int pivot(int[]nums){
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(high>low){
            int mid=low+(high-low)/2;
            if(nums[mid]>nums[high]){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return nums[high];
        
    }
}