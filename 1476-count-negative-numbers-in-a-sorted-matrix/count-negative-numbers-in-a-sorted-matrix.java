class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            count+=binary(grid[i]);
        }
        return count;
    }
    public int binary(int arr[]){
        int l=0;
        int r=arr.length-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(arr[mid]<0){
                r=mid;
            }
            else if(arr[mid]>=0){
                l=mid+1;
            }
        }
        if(arr[r]<0){
            return arr.length-r;
        }
        return 0;
    }
}