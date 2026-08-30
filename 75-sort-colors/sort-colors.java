class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        boolean swapped;
        //Bubble sort Inplace
        for(int i=0;i<n-1;i++){
            swapped=false;
            //let say length is 6 so 5 passes we need for 0 to 4 will be total 5
            for(int j=0;j<n-i-1;j++){
                if(nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                    swapped = true;
                }
            }
            if(!swapped){
                return;
            }
        }
    }
    public void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}