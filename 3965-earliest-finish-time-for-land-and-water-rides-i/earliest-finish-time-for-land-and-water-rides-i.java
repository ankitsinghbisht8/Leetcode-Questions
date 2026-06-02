class Solution {
    public int earliestFinishTime(int[] ls, int[] ld, int[] ws, int[] wd) {
        return Math.min(getans(ls, ld, ws, wd), getans(ws, wd, ls, ld));
    }

    private int getans(int[] ls, int[] ld, int[] ws, int[] wd) {
        int mini = Integer.MAX_VALUE;

        for (int i = 0; i < ls.length; i++) {
            mini = Math.min(mini, ls[i] + ld[i]);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < ws.length; i++) {
            ans = Math.min(
                    ans,
                    Math.max(mini, ws[i]) + wd[i]);
        }
        return ans;
    }
}