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
    private static final int MOD = 1_000_000_007;
    private long maxProduct = 0;
    private long totalSum = 0;

    public int maxProduct(TreeNode root) {
        totalSum = subtreeSum(root);

        subtreeSum(root);

        return (int) (maxProduct % MOD);
    }

    private long subtreeSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        long left = subtreeSum(node.left);
        long right = subtreeSum(node.right);
        long sum = left + right + node.val;

        if (totalSum - sum > 0) {
            maxProduct = Math.max(maxProduct, sum * (totalSum - sum));
        }

        return sum;
    }
}