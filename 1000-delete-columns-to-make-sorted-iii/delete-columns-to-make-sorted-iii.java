class Solution {
    public int minDeletionSize(String[] s) {
        int n = s.length;
        int m = s[0].length();
        int size = 0;
        int[] dp = new int[m];

        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }

        int max_keep = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                boolean valid = true;
                for (int k = 0; k < n; k++) {
                    if (s[k].charAt(j) > s[k].charAt(i)) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max_keep = Math.max(max_keep, dp[i]);
        }

        return m - max_keep;
    }
}