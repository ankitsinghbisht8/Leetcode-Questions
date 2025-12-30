class Solution {
    public boolean isMagic(int r, int c, int[][] grid) {
        int[] rowSum = { 0, 0, 0 };
        int[] colSum = { 0, 0, 0 };
        int diagSum = 0;
        int antiDiagSum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int curr = grid[r + i][c + j];
                if (curr < 1 || curr > 9 || set.contains(curr))
                    return false;
                rowSum[i] += curr;
                colSum[j] += curr;
                if (i == j)
                    diagSum += curr;
                if (i + j == 2)
                    antiDiagSum += curr;
                set.add(curr);
            }
        }

        return rowSum[0] == rowSum[1] && rowSum[1] == rowSum[2] &&
                rowSum[0] == colSum[0] && colSum[0] == colSum[1] && colSum[1] == colSum[2]
                && colSum[2] == diagSum && diagSum == antiDiagSum;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;
        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (isMagic(i, j, grid))
                    ans++;
            }
        }
        return ans;
    }
}