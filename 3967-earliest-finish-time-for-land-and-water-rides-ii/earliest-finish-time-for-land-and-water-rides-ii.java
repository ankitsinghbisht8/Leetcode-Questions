class Solution {
    public int earliestFinishTime(int[] ls, int[] ld, int[] ws, int[] wd) {
        return Math.min(getmin(ls, ld, ws, wd), getmin(ws, wd, ls, ld));
    }

    public int getmin(int[] ls, int[] ld, int[] ws, int[] wd) {

        int mini = Integer.MAX_VALUE;

        for (int i = 0; i < ls.length; i++) {
            mini = Math.min(mini, ls[i] + ld[i]);
        }
        
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < ws.length; i++) {
            ans = Math.min(ans, Math.max(mini, ws[i]) + wd[i]);
        }
        return ans;
    }
}