class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        while (top < bottom && left < right) {
            ArrayList<Integer> layer = new ArrayList<>();
            for (int i = top; i <= bottom; i++) {
                layer.add(grid[i][left]);
            }
            for (int i = left + 1; i <= right; i++) {
                layer.add(grid[bottom][i]);
            }
            for (int i = bottom - 1; i >= top; i--) {
                layer.add(grid[i][right]);
            }
            for (int i = right - 1; i > left; i--) {
                layer.add(grid[top][i]);
            }
            int size = layer.size();
            int rotate = k % size;
            Collections.rotate(layer, rotate);
            int idx = 0;
            for (int i = top; i <= bottom; i++) {
                grid[i][left] = layer.get(idx++);
            }
            for (int i = left + 1; i <= right; i++) {
                grid[bottom][i] = layer.get(idx++);
            }
            for (int i = bottom - 1; i >= top; i--) {
                grid[i][right] = layer.get(idx++);
            }
            for (int i = right - 1; i > left; i--) {
                grid[top][i] = layer.get(idx++);
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return grid;
    }
}