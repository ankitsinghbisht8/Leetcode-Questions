class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) {
                    if (bfs(i, j, grid, vis, dir)) return true;
                }
            }
        }
        return false;
    }

    private boolean bfs(int i, int j, char[][] grid, boolean[][] vis, int[][] dir) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j, -1, -1}); 
        vis[i][j] = true;
        char ch = grid[i][j];

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], pr = cur[2], pc = cur[3];

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length)
                    continue;

                if (grid[nr][nc] != ch) continue;

                if (nr == pr && nc == pc) continue;

                if (vis[nr][nc]) return true;

                vis[nr][nc] = true;
                q.offer(new int[]{nr, nc, r, c});
            }
        }
        return false;
    }
}