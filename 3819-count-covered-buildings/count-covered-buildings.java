class Solution {

    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] maxX = new int[n + 1];
        int[] minX = new int[n + 1];
        int[] maxY = new int[n + 1];
        int[] minY = new int[n + 1];

        Arrays.fill(minX, n + 1);
        Arrays.fill(minY, n + 1);

        for (int[] arr : buildings) {
            int x = arr[0];
            int y = arr[1];
            maxX[y] = Math.max(maxX[y], x);
            minX[y] = Math.min(minX[y], x);
            maxY[x] = Math.max(maxY[x], y);
            minY[x] = Math.min(minY[x], y);
        }

        int ans = 0;
        for (int[] arr : buildings) {
            int x = arr[0];
            int y = arr[1];
            if (x > minX[y] && x < maxX[y] && y > minY[x] && y < maxY[x]) {
                ans++;
            }
        }

        return ans;
    }
}