class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        //formed the adjlist here 
        boolean vis[] = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                List<Integer> al = new ArrayList<>();
                dfs(i, vis, adjList, al);
                int vertices = al.size();
                int edgecount = 0;
                for (int node : al) {
                    edgecount = edgecount + adjList.get(node).size();
                }
                edgecount = edgecount / 2;//since undirected
                if (edgecount == (vertices * (vertices - 1) / 2)) {
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int node, boolean vis[], ArrayList<List<Integer>> adjList, List<Integer> al) {
        vis[node] = true;
        al.add(node);
        for (int it : adjList.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, adjList, al);
            }
        }
        return;
    }
}