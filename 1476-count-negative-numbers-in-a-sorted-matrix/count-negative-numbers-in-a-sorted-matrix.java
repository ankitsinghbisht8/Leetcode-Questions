class Solution {
    public int countNegatives(int[][] grid) {
        int n=grid.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]<0){
                    count++;
                }
            }
        }
        return count;
    }
}