// Approach 1
class Solution {
    int time;
    int[][] vis;
    int[][] low;
    int[] d=new int[]{0,1,0,-1,0};
    boolean arti;
    public int minDays(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        arti=false;
        vis=new int[n][m];
        low=new int[n][m];
        time=1;
        boolean hasArt=false;
        boolean found=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    if(found)
                        return 0;
                    found=true;
                    art(i,j,grid,-100,-100);
                }
            }
        }

        if(time==1)
            return 0;

        if(time==2)
            return 1;
        if(arti)
            return 1;
        else
            return 2;
    }

    public void art(int row,int col,int[][] grid , int parRow,int parCol){
        grid[row][col]=0;
        vis[row][col]=time;
        low[row][col]=time;
        time++;
        int child=0;
        for(int i=0;i<4;i++){
            int x=d[i]+row;
            int y=d[i+1]+col;

            if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || (x==parRow && y==parCol) || (vis[x][y]==0 && grid[x][y]==0))
                continue;
            if(vis[x][y]==0){
                child++;
                art(x,y,grid,row,col);
                low[row][col]=Math.min(low[row][col],low[x][y]);
                if(low[x][y]>=vis[row][col] && (parRow!=-100 && parCol!=-100))
                    arti=true;
            }else{
                low[row][col]=Math.min(low[row][col],vis[x][y]);
            }
        }

        if(parRow==-100 && parCol==-100 && child>1)
            arti=true;
    }
}

// Approach 2 

class Solution {

    // Directions for adjacent cells: right, left, down, up
    private static final int[][] DIRECTIONS = {
        { 0, 1 },
        { 0, -1 },
        { 1, 0 },
        { -1, 0 },
    };

    public int minDays(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Count initial islands
        int initialIslandCount = countIslands(grid);

        // Already disconnected or no land
        if (initialIslandCount != 1) {
            return 0;
        }

        // Try removing each land cell
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) continue; // Skip water

                // Temporarily change to water
                grid[row][col] = 0;
                int newIslandCount = countIslands(grid);

                // Check if disconnected
                if (newIslandCount != 1) return 1;

                // Revert change
                grid[row][col] = 1;
            }
        }

        return 2;
    }

    private int countIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islandCount = 0;

        // Iterate through all cells
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // Found new island
                if (!visited[row][col] && grid[row][col] == 1) {
                    exploreIsland(grid, row, col, visited);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    // Helper method to explore all cells of an island
    private void exploreIsland(
        int[][] grid,
        int row,
        int col,
        boolean[][] visited
    ) {
        visited[row][col] = true;

        // Check all adjacent cells
        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            // Explore if valid land cell
            if (isValidLandCell(grid, newRow, newCol, visited)) {
                exploreIsland(grid, newRow, newCol, visited);
            }
        }
    }

    private boolean isValidLandCell(
        int[][] grid,
        int row,
        int col,
        boolean[][] visited
    ) {
        int rows = grid.length;
        int cols = grid[0].length;
        // Check bounds, land, and not visited
        return (
            row >= 0 &&
            col >= 0 &&
            row < rows &&
            col < cols &&
            grid[row][col] == 1 &&
            !visited[row][col]
        );
    }
}
