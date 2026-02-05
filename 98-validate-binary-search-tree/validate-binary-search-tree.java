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
     public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
  }
    public boolean helper(TreeNode node, Integer low, Integer high) {
        if(node==null){
            return true;
        }

        if(low!=null && low>=node.val){
            return false;
        }
        if(high!=null && node.val>=high){
            return false;
        }
        boolean leftree=helper(node.left,low,node.val);
        boolean rightree=helper(node.right,node.val,high);
        return leftree && rightree;
        
    }
}