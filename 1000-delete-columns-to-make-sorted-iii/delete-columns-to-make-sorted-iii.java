class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs.length;
        int n = strs[0].length();
        int[] dp = new int[n];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < i; j++){
                boolean isless = true;
                for(int p = 0; p < m; p++){
                    if(strs[p].charAt(i) < strs[p].charAt(j)){
                        isless = false;
                        break;
                    }
                }
                if(isless){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] ++;
            min = Math.min(min, n - dp[i]);
        }
        return min;
        
        
    }
}