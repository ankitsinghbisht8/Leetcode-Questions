/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    class Pair {
        int value;
        boolean left;

        Pair(int value, boolean left) {
            this.value = value;
            this.left = left;
        }
    }

    public TreeNode createBinaryTree(int[][] desc) {
        int n = desc.length;
        Set<Integer> children = new HashSet<>();
        Set<Integer> parent = new HashSet<>();
        Map<Integer, List<Pair>> parentToChild = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int par = desc[i][0];
            int child = desc[i][1];
            boolean isleft = (desc[i][2] == 1) ? true : false;
            children.add(child);
            parent.add(par);
            // List<Pair> al = new ArrayList<>();
            // al.add(new Pair(child, isleft));
            parentToChild.computeIfAbsent(par, k-> new ArrayList<>()).add(new Pair(child,isleft));
        }
        parent.removeAll(children);
        TreeNode root = new TreeNode(parent.iterator().next());
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            for (Pair p : parentToChild.getOrDefault(node.val, Collections.emptyList())) {
                int childval = p.value;
                boolean isLeft = p.left;
                TreeNode child = new TreeNode(childval);
                q.add(child);
                if (isLeft) {
                    node.left = child;
                } else {
                    node.right = child;
                }
            }
        }

        return root;
    }
}