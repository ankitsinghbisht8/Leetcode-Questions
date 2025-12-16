class Solution {
    private int[][][] dp;
    private List<Integer>[] adList;
    
    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        dp = new int[n][budget + 1][3];
        adList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adList[i] = new ArrayList<>();
        }

        for (int[] h : hierarchy) {
            int u = h[0] - 1;
            int v = h[1] - 1;
            adList[u].add(v);
        }
        
        dfs(0, present, future, budget);
        
        int solution = 0;
        for (int i = 0; i <= budget; i++) {
            solution = Math.max(solution, Math.max(dp[0][i][0], dp[0][i][1]));
        }
        return solution;
    }

    private void dfs(int v, int[] present, int[] future, int budget) {
        List<Integer> children = adList[v];
        int childCount = children.size();
        
        int[][] childDp = new int[3][budget + 1];
        
        for (int child : children) {
            dfs(child, present, future, budget);
            
            for (int rep = 0; rep < 3; rep++) {
                int[] temp = childDp[rep].clone();
                for (int b = budget; b >= 0; b--) {
                    for (int cb = 0; cb <= budget - b; cb++) {
                        int childProfit = getCost(child, cb, rep);
                        if (temp[b] + childProfit > childDp[rep][b + cb]) {
                            childDp[rep][b + cb] = temp[b] + childProfit;
                        }
                    }
                }
            }
        }
        
        int profit = future[v] - present[v];
        int profitWithDiscount = future[v] - present[v] / 2;
        
        for (int b = 0; b <= budget; b++) {
            dp[v][b][0] = childDp[0][b];
            
            if (b >= present[v]) {
                dp[v][b][1] = childDp[1][b - present[v]] + profit;
            }
            
            if (b >= present[v] / 2) {
                dp[v][b][2] = childDp[2][b - present[v] / 2] + profitWithDiscount;
            }
        }
    }

    private int getCost(int node, int curCost, int rep) {
        if (rep == 0) {
            return Math.max(dp[node][curCost][0], dp[node][curCost][1]);
        } else if (rep == 1) {
            return Math.max(dp[node][curCost][0], dp[node][curCost][2]);
        } else {
            return Math.max(dp[node][curCost][0], Math.max(dp[node][curCost][1], dp[node][curCost][2]));
        }
    }
}