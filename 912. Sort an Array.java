class Solution {
    public int[] sortArray(int[] nums) {
    if (nums == null || nums.length <= 1) return nums;
      int max=Integer.MIN_VALUE;
      int min=Integer.MAX_VALUE;
      for(int i=0;i<nums.length;i++){
        max=Math.max(max,nums[i]);
         min=Math.min(min,nums[i]);
      }
      int count[]=new int[max - min + 1];
        for(int num : nums) {
            count[num - min]++;
        }
    
      int j=0;
      for(int i=0;i<count.length;i++){
        while(count[i]>0){
            nums[j]=i+min;
            j++;
            count[i]--;
        }
      }
      return nums;

    }
}
