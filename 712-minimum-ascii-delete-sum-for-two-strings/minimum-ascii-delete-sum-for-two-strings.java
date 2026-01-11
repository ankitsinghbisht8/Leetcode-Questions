class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < s1.length(); ++i) {
            int value = s1.charAt(i);
            dp[i + 1][0] = dp[i][0] + value;
        }

        for (int j = 0; j < s2.length(); ++j) {
            int value = s2.charAt(j);
            dp[0][j + 1] = dp[0][j] + value;
        }

        for (int i = 0; i < s1.length(); ++i) {
            for (int j = 0; j < s2.length(); ++j) {
                int value1 = s1.charAt(i), value2 = s2.charAt(j);
                dp[i + 1][j + 1] = Math.min(dp[i][j + 1] + value1, dp[i + 1][j] + value2);

                if (value1 == value2) {
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}