class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean vis[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        int maxIdx = 0;
        while (!q.isEmpty()) {
            int idx = q.remove();
            int left = Math.max(idx + minJump, maxIdx);
            int right = Math.min(idx + maxJump, n - 1);
            for (int i = left; i <= right; i++) {
                if (!vis[i] && s.charAt(i) == '0') {
                    vis[i] = true;
                    q.add(i);
                }
            }
            maxIdx = right;
        }
        return vis[n - 1];
    }
}