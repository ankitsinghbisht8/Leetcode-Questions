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
    public int maxLevelSum(TreeNode root) {
        int ans = Integer.MIN_VALUE;
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return 0;
        q.add(root);
        int currlevel = 1;
        while (!q.isEmpty()) {
            int currsum = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                int val = node.val;
                currsum += val;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            if (currsum > ans) {
                ans = currsum;
                level = currlevel;
            }
            currlevel++;
        }
        return level;
    }
}