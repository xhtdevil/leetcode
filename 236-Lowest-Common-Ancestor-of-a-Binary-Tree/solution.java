/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)return null;
        if(isDescent(root.right, p) && isDescent(root.right, q))return lowestCommonAncestor(root.right, p, q);
        if(isDescent(root.left, p) && isDescent(root.left, q))return lowestCommonAncestor(root.left, p, q);
        else return root;
    }
    
    private boolean isDescent(TreeNode root, TreeNode child){
        if(root == null)return false;
        if(root == child)return true;
        return isDescenet(root.right, child) || isDescent(root.left, child);
    }
}