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
    public TreeNode invertTree(TreeNode root) {
        TreeNode node = TreeNode(root.val);
        if(node != null){
            node.left = invertTree(root.right);
            node.right = invertTree(root.left);
            return node;
        }else{
            return node;
        }
    }
}