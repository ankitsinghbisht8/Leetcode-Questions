class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int currx = points[i][0];
            int curry = points[i][1];
            int targetx = points[i + 1][0];
            int targety = points[i + 1][1];
            ans += Math.max(Math.abs(targetx - currx), Math.abs(targety - curry));
        }
        
        return ans;
    }
}