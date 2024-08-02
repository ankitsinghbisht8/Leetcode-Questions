// Approach : 1 
class Solution {
    public int minSwaps(int[] nums) {
        int k=0;
        for(int i=0;i<nums.length;i++){
            k+=nums[i];
        }
        int sum=0;
        int min=nums.length;
        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
            if(j>=k){
                sum-=nums[j-k];
                }
            if(j>=k-1)min=Math.min(min,k-sum);
        }
        for(int i=0;i<=k-2;i++){
            sum=sum+nums[i]-nums[nums.length-k+i];
            min=Math.min(min,k-sum);
        }
        return min;
    }
}

Approach 2: Using Sliding Window

  class Solution {

    public int minSwaps(int[] nums) {
        // Calculate the minimum swaps needed to group all 1s or all 0s together
        int op1 = minSwapsHelper(nums, 0); // Grouping all 0s together
        int op2 = minSwapsHelper(nums, 1); // Grouping all 1s together
        return Math.min(op1, op2);
    }

    // Helper function to calculate the minimum swaps required
    // to group all `val` together
    public int minSwapsHelper(int[] data, int val) {
        int length = data.length;
        int totalValCount = 0;

        // Count the total number of `val` in the array
        for (int i = length - 1; i >= 0; i--) {
            if (data[i] == val) totalValCount++;
        }

        // If there is no `val` or the array is full of `val`,
        // no swaps are needed
        if (totalValCount == 0 || totalValCount == length) return 0;

        int start = 0, end = 0;
        int maxValInWindow = 0, currentValInWindow = 0;

        // Initial window setup: count the number of `val` in
        // the first window of size `totalValCount`
        while (end < totalValCount) {
            if (data[end++] == val) currentValInWindow++;
        }
        maxValInWindow = Math.max(maxValInWindow, currentValInWindow);

        // Slide the window across the array to find the
        // maximum number of `val` in any window
        while (end < length) {
            if (data[start++] == val) currentValInWindow--;
            if (data[end++] == val) currentValInWindow++;
            maxValInWindow = Math.max(maxValInWindow, currentValInWindow);
        }

        // Minimum swaps are the total `val` minus
        // the maximum found in any window
        return totalValCount - maxValInWindow;
    }
}
