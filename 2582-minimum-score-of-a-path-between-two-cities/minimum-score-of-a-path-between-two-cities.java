class Solution {
    int[] parent;
    int[] rank;

    public int minScore(int n, int[][] roads) {
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] road : roads) {
            union(road[0], road[1]);
        }

        int root = find(1);
        int ans = Integer.MAX_VALUE;

        for (int[] road : roads) {
            if (find(road[0]) == root) {
                ans = Math.min(ans, road[2]);
            }
        }

        return ans;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return;

        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        } else if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        } else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }
}