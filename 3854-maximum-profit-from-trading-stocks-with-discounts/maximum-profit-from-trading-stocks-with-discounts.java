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
            adList[h[0] - 1].add(h[1] - 1);
        }
        
        dfs(0, present, future, budget);
        
        int solution = 0;
        for (int i = 0; i <= budget; i++) {
            solution = Math.max(solution, Math.max(dp[0][i][0], dp[0][i][1]));
        }
        return solution;
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

    private void dfs(int v, int[] present, int[] future, int budget) {
        if (budget <= 0) return;

        int profit = future[v] - present[v];
        int halfPresent = present[v] / 2;
        int profitWithDiscount = future[v] - halfPresent;
        
        List<Integer> childNodes = adList[v];
        int len = childNodes.size();
        
        for (int u : childNodes) {
            dfs(u, present, future, budget);
        }
        
        for (int rep = 0; rep < 3; rep++) {
            int[][] childDp = new int[len + 1][budget + 1];
            
            for (int l = 0; l < len; l++) {
                int node = childNodes.get(l);
                int[] prevRow = childDp[l];
                int[] currRow = childDp[l + 1];
                
                for (int b = 0; b <= budget; b++) {
                    if (prevRow[b] == 0 && b > 0) continue;
                    
                    currRow[b] = Math.max(currRow[b], prevRow[b]);
                    
                    int maxChildBudget = budget - b;
                    for (int cb = 0; cb <= maxChildBudget; cb++) {
                        int childCost = getCost(node, cb, rep);
                        if (childCost == 0 && cb > 0) continue;
                        
                        int newCost = prevRow[b] + childCost;
                        if (newCost > currRow[b + cb]) {
                            currRow[b + cb] = newCost;
                        }
                    }
                }
            }
            
            int[] lastRow = childDp[len];
            if (rep == 0) {
                for (int b = 0; b <= budget; b++) {
                    dp[v][b][0] = lastRow[b];
                }
            } else if (rep == 1) {
                int cost = present[v];
                for (int b = cost; b <= budget; b++) {
                    dp[v][b][1] = lastRow[b - cost] + profit;
                }
            } else {
                for (int b = halfPresent; b <= budget; b++) {
                    dp[v][b][2] = lastRow[b - halfPresent] + profitWithDiscount;
                }
            }
        }
    }
}